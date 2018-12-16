package tp.chinesecheckers.serwer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tp.chinesecheckers.GraDomyslnaSerwer;
import tp.chinesecheckers.TworcaGryDomyslnejSerwer;

public class Serwer implements Runnable{

  private int port;
  private int iloscGraczy;
  private boolean uzupelnijBotami;
  private boolean zakonczGre;
  private List<Polaczenie> polaczenie = new ArrayList<Polaczenie>();
  private String wiadomoscOdPolaczenia = "";
  
  public Serwer(int port, int iloscGraczy) {
    this.port = port;
    this.iloscGraczy = iloscGraczy;
    this.uzupelnijBotami = false;
    this.zakonczGre = false;
  }
  
  public void uzupelnijGreBotami() {
    this.uzupelnijBotami = true;
  }
  
  public void wymusZakonczenieGry() {
    this.zakonczGre = true;
  }
  
  public void run() {
    String wiadomosc;
    
    System.out.println("Uruchomiono");
    
    try {
      ServerSocket socketSerwer = new ServerSocket(port);
      //Oczekiwanie na dolaczenie graczy
      while(!uzupelnijBotami) {
        Socket socketKlient = socketSerwer.accept();
        System.out.println("Polaczono klienta");
        InputStreamReader reader = new InputStreamReader(socketKlient.getInputStream());
        BufferedReader readerBuffer = new BufferedReader(reader);
        PrintWriter writer = new PrintWriter(socketKlient.getOutputStream());
        
        //Pobierz nazwe
        writer.println("podaj_nazwe");
        writer.flush();
        wiadomosc = readerBuffer.readLine();
        
        //Sprawdz czy nazwa zajeta
        if(sprawdzCzyNazwaWolna(wiadomosc)) {
          polaczenie.add(new Polaczenie(wiadomosc, socketKlient, this));
          System.out.println("Polaczono gracza: " + wiadomosc);
          writer.println("polaczenie_udane");
          writer.flush();
          
          Thread thr = new Thread(polaczenie.get(polaczenie.size() - 1));
          thr.start();
        } else {
          System.out.println("Nazwa zajeta, rozlaczono klienta.");
          writer.println("nazwa_zajeta");
          writer.flush();
          socketKlient.close();
        }
        
        //Jezeli osiagnieto wymagana liczbe graczy
        if(polaczenie.size() == iloscGraczy) {
          break;
        }
      }
      
      //Start gry
      System.out.println("Startowanie gry");
      
      //Stworzenie obiektu gry
      TworcaGryDomyslnejSerwer tworca = new TworcaGryDomyslnejSerwer(iloscGraczy);
      for (int i = 0; i < iloscGraczy; i++) {
        if (i >= polaczenie.size()) {
          tworca.dodajGracza("Bot" + i, 0, true);
          continue;
        }
        Polaczenie pol = polaczenie.get(i);
        tworca.dodajGracza(pol.podajNazwe(), 0, false);
      }
      GraDomyslnaSerwer gra = (GraDomyslnaSerwer)tworca.stworzGre();
      
      //Wylosowanie startujacego gracza
      Random rand = new Random();
      int aktualnyRuch = 1;//rand.nextInt(iloscGraczy);
      
      //Petla gry
      while(true) {
        //Podbicie licznika rund
        gra.ustawRunde(gra.podajRunde() + 1);
        
        //wyslanie stanu gry
        String wiadomoscStanuGry = gra.wygenerujWiadomosc(polaczenie.get(aktualnyRuch).podajNazwe());
        for (int i = 0; i < polaczenie.size(); i++) {
          polaczenie.get(i).wyslijWiadomosc(wiadomoscStanuGry);
        }
        
        Polaczenie polRuch = polaczenie.get(aktualnyRuch);
        polRuch.ruch = true;
        while(wiadomoscOdPolaczenia.equals("")) {
          Thread.sleep(1000);
        }
        
        //Rozkodowanie wiadomosci
        String[] pozycja = wiadomoscOdPolaczenia.split(",");
        
        gra.wykonajRuch(polRuch.podajNazwe(), Integer.parseInt(pozycja[0]), Integer.parseInt(pozycja[1]),
            Integer.parseInt(pozycja[2]), Integer.parseInt(pozycja[3]));
        
        polRuch.ruch = false;
        
        aktualnyRuch++;
        if(aktualnyRuch ==  iloscGraczy) {
          aktualnyRuch = 0;
        }
      }
      
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  
  private boolean sprawdzCzyNazwaWolna(String nazwa) {
    for(int i=0; i < polaczenie.size(); i++) {
      if(nazwa.equals(polaczenie.get(i).podajNazwe())) {
        return false;
      }
    }
    return true; 
  }
  
  public void podajWiadomosc(String wiadomosc) {
    this.wiadomoscOdPolaczenia = wiadomosc;
  }
}
