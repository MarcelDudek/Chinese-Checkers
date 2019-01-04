package tp.chinesecheckers.serwer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tp.chinesecheckers.GraDomyslnaSerwer;
import tp.chinesecheckers.Gracz;
import tp.chinesecheckers.TworcaGryDomyslnejSerwer;
import tp.chinesecheckers.Zawodnik;
import tp.chinesecheckers.exception.NiepoprawnyRuch;

public class Serwer implements Runnable{

  private int port;
  private int iloscGraczy;
  private boolean uzupelnijBotami;
  private List<Polaczenie> polaczenie = new ArrayList<Polaczenie>();
  private String wiadomoscOdPolaczenia = "";
  private GraDomyslnaSerwer gra;
  private ServerSocket socketSerwer;
  private boolean zamkniecieSerwera;
  
  public Serwer(int port, int iloscGraczy) {
    this.port = port;
    this.iloscGraczy = iloscGraczy;
    this.uzupelnijBotami = false;
    this.gra = null;
    this.socketSerwer = null;
    this.zamkniecieSerwera = false;
  }
  
  public void uzupelnijGreBotami() {
    this.uzupelnijBotami = true;
  }
  
  public void run() {
    try {
      socketSerwer = new ServerSocket(port);
    } catch(IOException ex) {
      ex.printStackTrace();
      return;
    }
    
    System.out.println("Uruchomiono serwer");
    
    //Oczekiwanie na dolaczenie graczy
    while(!uzupelnijBotami) {
      polaczZKlientem();
      
      //Jezeli osiagnieto wymagana liczbe graczy
      if(polaczenie.size() == iloscGraczy || zamkniecieSerwera) {
        break;
      }
    }
    
    if(zamkniecieSerwera) {
      zamknijSockety();
      return;
    }
    
    //Start gry
    System.out.println("Startowanie gry");
    
    //Stworzenie obiektu gry
    TworcaGryDomyslnejSerwer tworca = new TworcaGryDomyslnejSerwer(iloscGraczy);
    for (int i = 0; i < iloscGraczy; i++) {
      if (i >= polaczenie.size()) {
        tworca.dodajGracza("Bot" + i, 0, true);
        System.out.println("Dodano bota.");
        continue;
      }
      Polaczenie pol = polaczenie.get(i);
      tworca.dodajGracza(pol.podajNazwe(), 0, false);
    }
    gra = (GraDomyslnaSerwer)tworca.stworzGre();
    
    //Wylosowanie startujacego gracza
    Random rand = new Random();
    int aktualnyRuch = rand.nextInt(iloscGraczy);
    
    //Petla gry
    while(true) {
      if(zamkniecieSerwera) {
        zamknijSockety();
        return;
      }
      
      Zawodnik aktualnyRuchZawodnik = gra.podajListeZawodnikow().get(aktualnyRuch);
      if(aktualnyRuchZawodnik instanceof Gracz) {
        rozegrajRunde(aktualnyRuch);
      } else {
        gra.wykonajRuchBota(aktualnyRuchZawodnik.podajNazwe());
      }
      
      //Przygotowanie do nastepnej rundy
      wiadomoscOdPolaczenia = "";
      aktualnyRuch++;
      if(aktualnyRuch ==  iloscGraczy) {
        aktualnyRuch = 0;
      }
    }
  }
  
  private void polaczZKlientem() {
    try {
      //Czekaj na polaczenie klienta z serwerem
      socketSerwer.setSoTimeout(1000);
      Socket socketKlient = null;
      while(socketKlient == null) {
        if(this.uzupelnijBotami || this.zamkniecieSerwera) {
          return;
        }
        try {
          socketKlient = socketSerwer.accept();
        } catch (SocketTimeoutException ex) {}
      }
      System.out.println("Polaczono klienta");
      InputStreamReader reader = new InputStreamReader(socketKlient.getInputStream());
      BufferedReader readerBuffer = new BufferedReader(reader);
      PrintWriter writer = new PrintWriter(socketKlient.getOutputStream());
      
      //Pobierz nazwe
      writer.println("podaj_nazwe");
      writer.flush();
      String wiadomosc = readerBuffer.readLine();
      
      //Sprawdz czy nazwa zajeta
      if(sprawdzCzyNazwaWolna(wiadomosc)) {
        //Dodanie klienta do obslugiwanych polaczen i wyslanie potwierdzienia poprawnego polaczenia
        polaczenie.add(new Polaczenie(wiadomosc, socketKlient, this));
        System.out.println("Polaczono gracza: " + wiadomosc);
        writer.println("polaczenie_udane");
        writer.flush();
        
        //Uruchomienie watku obslugujacego polaczenie z danym klientem
        Thread thr = new Thread(polaczenie.get(polaczenie.size() - 1));
        thr.start();
      } else {
        //Nieudane polaczenie, wyslij do klienta informacje o zajetej nazwie i rozlacz polaczenie
        System.out.println("Nazwa zajeta, rozlaczono klienta.");
        writer.println("nazwa_zajeta");
        writer.flush();
        socketKlient.close();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
  
  private void rozegrajRunde(int aktualnyRuch) {
    //Podbicie licznika rund
    gra.ustawRunde(gra.podajRunde() + 1);
    
    //wyslanie stanu gry
    String wiadomoscStanuGry = gra.wygenerujWiadomosc(polaczenie.get(aktualnyRuch).podajNazwe());
    for (int i = 0; i < polaczenie.size(); i++) {
      polaczenie.get(i).wyslijWiadomosc(wiadomoscStanuGry);
    }
    
    //Czekanie na wiadomosc od klienta, ktory wykonuje aktualny ruch
    Polaczenie polRuch = polaczenie.get(aktualnyRuch);
    polRuch.ruch = true;
    try {
      while(wiadomoscOdPolaczenia.equals("")) {
        Thread.sleep(1000);
        if(this.zamkniecieSerwera) {
          return;
        }
      }
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
    
    //Rozkodowanie wiadomosci
    String[] pozycja = wiadomoscOdPolaczenia.split(",");
    
    try {
      gra.wykonajRuch(polRuch.podajNazwe(), Integer.parseInt(pozycja[0]), Integer.parseInt(pozycja[1]),
          Integer.parseInt(pozycja[2]), Integer.parseInt(pozycja[3]));
    } catch (NiepoprawnyRuch ex) {
      System.err.println("Niepoprawny ruch.");
    }
    
    polRuch.ruch = false;
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
  
  public void zamknijSerwer() {
    zamkniecieSerwera = true;
    System.out.println("Zamkniêto serwer.");
  }
  
  private void zamknijSockety() {
    for(Polaczenie pol: polaczenie) {
      pol.zamknijPolaczenie();
    }
    try {
      this.socketSerwer.close();
    } catch (IOException ex) {}
  }
  
  public List<String> podajListePolaczen() {
    List<String> lista = new ArrayList<String>();
    for(Polaczenie pol: polaczenie) {
      lista.add(pol.podajNazwe());
    }
    return lista;
  }
  
  public boolean czyZamkniety() {
    return this.zamkniecieSerwera;
  }
}
