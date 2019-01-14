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

/**
 * 
 * @author mdlot
 *
 */
public class Serwer implements Runnable {

  /**
   * Port, na którym uruchomiony jest serwer.
   */
  private final transient int port;
  /**
   * Iloœc graczy podczas gry.
   */
  private final transient int iloscGraczy;
  /**
   * Czy serwer powinien uzupe³nic wolne miejsca botami.
   */
  private transient boolean uzupelnijBotami;
  /**
   * Lista po³¹czeñ.
   */
  private final transient List<Polaczenie> polaczenie = new ArrayList<Polaczenie>();
  /**
   * Wiadomoœc od po³¹czenia, które aktualnie wykonuje ruch.
   */
  private transient String wiadomoscOdPolaczenia = "";
  /**
   * Obiekt gry.
   */
  private transient GraDomyslnaSerwer gra;
  /**
   * Socket serwera.
   */
  private transient ServerSocket socketSerwer;
  /**
   * Czy serwer powinien zostac zamkniety.
   */
  private transient boolean zamkniecieSerwera;
  
  /**
   * 
   * @param port Port, na którym zostanie uruchomiony serwer
   * @param iloscGraczy Iloœc graczy
   */
  public Serwer(final int port, final int iloscGraczy) {
    this.port = port;
    this.iloscGraczy = iloscGraczy;
    this.uzupelnijBotami = false;
    //this.gra = null;
    //this.socketSerwer = null;
    this.zamkniecieSerwera = false;
  }
  
  /**
   * Przestaje oczekiwac na po³¹czenie gracza i wype³nia resztê miejsc botami.
   */
  public void uzupelnijGreBotami() {
    if (!this.polaczenie.isEmpty()) {
      this.uzupelnijBotami = true;
    }
  }
  
  /**
   * Metoda w¹tku.
   */
  public void run() {
    try {
      socketSerwer = new ServerSocket(port);
    } catch (IOException ex) {
      ex.printStackTrace();
      return;
    }
    
    System.out.println("Uruchomiono serwer");
    
    //Oczekiwanie na dolaczenie graczy
    while (!uzupelnijBotami) {
      polaczZKlientem();
      
      //Jezeli osiagnieto wymagana liczbe graczy
      if (polaczenie.size() == iloscGraczy || zamkniecieSerwera) {
        break;
      }
    }
    
    if (zamkniecieSerwera) {
      zamknijSockety();
      return;
    }
    
    //Start gry
    System.out.println("Startowanie gry");
    
    //Stworzenie obiektu gry
    final TworcaGryDomyslnejSerwer tworca = new TworcaGryDomyslnejSerwer(iloscGraczy);
    for (int i = 0; i < iloscGraczy; i++) {
      if (i >= polaczenie.size()) {
        tworca.dodajGracza("Bot" + i, 0, true);
        System.out.println("Dodano bota.");
        continue;
      }
      final Polaczenie pol = polaczenie.get(i);
      tworca.dodajGracza(pol.podajNazwe(), 0, false);
    }
    gra = (GraDomyslnaSerwer)tworca.stworzGre();
    
    //Wylosowanie startujacego gracza
    final Random rand = new Random();
    int aktualnyRuch = rand.nextInt(iloscGraczy);
    
    //Petla gry
    while (true) {
      if (zamkniecieSerwera) {
        zamknijSockety();
        return;
      }
      
      final Zawodnik aktualnyRuchZawodnik = gra.podajListeZawodnikow().get(aktualnyRuch);
      boolean wykonanoRuch = true;
      if (aktualnyRuchZawodnik.podajPozycje() == 0) {
        if (aktualnyRuchZawodnik instanceof Gracz) {
          System.out.println("Runda gracza " + aktualnyRuchZawodnik.podajNazwe());
          wykonanoRuch = rozegrajRunde(aktualnyRuch);
        } else {
          System.out.println("Runda bota " + aktualnyRuchZawodnik.podajNazwe());
          //Spij przez pol sekundy
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          //rozegraj runde
          rozegrajRundeBota(aktualnyRuchZawodnik);
          wykonanoRuch = true;
        }
      }
      
      //Przygotowanie do nastepnej rundy
      wiadomoscOdPolaczenia = "";
      if (wykonanoRuch) {
        aktualnyRuch++;
      }
      if (aktualnyRuch ==  iloscGraczy) {
        aktualnyRuch = 0;
      }
    }
  }
  
  private void polaczZKlientem() {
    try {
      //Czekaj na polaczenie klienta z serwerem
      socketSerwer.setSoTimeout(1000);
      Socket socketKlient = null;
      while (socketKlient == null) {
        if (this.uzupelnijBotami || this.zamkniecieSerwera) {
          return;
        }
        try {
          socketKlient = socketSerwer.accept();
        } catch (SocketTimeoutException ex) {}
      }
      System.out.println("Polaczono klienta");
      final InputStreamReader reader = new InputStreamReader(socketKlient.getInputStream());
      final BufferedReader readerBuffer = new BufferedReader(reader);
      final PrintWriter writer = new PrintWriter(socketKlient.getOutputStream());
      
      //Pobierz nazwe
      writer.println("podaj_nazwe");
      writer.flush();
      final String wiadomosc = readerBuffer.readLine();
      
      //Sprawdz czy nazwa zajeta
      if (sprawdzCzyNazwaWolna(wiadomosc)) {
        //Dodanie klienta do obslugiwanych polaczen i wyslanie potwierdzienia poprawnego polaczenia
        polaczenie.add(new Polaczenie(wiadomosc, socketKlient, this));
        System.out.println("Polaczono gracza: " + wiadomosc);
        writer.println("polaczenie_udane");
        writer.flush();
        
        //Uruchomienie watku obslugujacego polaczenie z danym klientem
        final Thread thr = new Thread(polaczenie.get(polaczenie.size() - 1));
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
  
  private void rozegrajRundeBota(Zawodnik aktualnyBot) {
    //wyslanie stanu gry
    final String wiadomoscStanuGry =
        gra.wygenerujWiadomosc(aktualnyBot.podajNazwe());
    for (int i = 0; i < polaczenie.size(); i++) {
      polaczenie.get(i).wyslijWiadomosc(wiadomoscStanuGry);
    }
    //wykonanie ruchu
    gra.wykonajRuchBota(aktualnyBot.podajNazwe());
    gra.ustawRunde(gra.podajRunde() + 1);
  }
  
  private boolean rozegrajRunde(final int aktualnyRuch) {
    //Podbicie licznika rund
    gra.ustawRunde(gra.podajRunde() + 1);
    
    //wyslanie stanu gry
    final String wiadomoscStanuGry =
        gra.wygenerujWiadomosc(polaczenie.get(aktualnyRuch).podajNazwe());
    for (int i = 0; i < polaczenie.size(); i++) {
      polaczenie.get(i).wyslijWiadomosc(wiadomoscStanuGry);
    }
    
    //Czekanie na wiadomosc od klienta, ktory wykonuje aktualny ruch
    final Polaczenie polRuch = polaczenie.get(aktualnyRuch);
    polRuch.ruch = true;
    try {
      int oczekiwanie = 0;
      while (wiadomoscOdPolaczenia.equals("")) {
        Thread.sleep(1000);
        oczekiwanie++;
        //Je¿eli czekano 30 sekund, zamieñ gracza na bota
        if (oczekiwanie == 100) {
          gra.zamienGraczaNaBota(polRuch.podajNazwe());
          polRuch.zamknijPolaczenie();
          return false;
        }
        if (this.zamkniecieSerwera) {
          return false;
        }
      }
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
    
    //Rozkodowanie wiadomosci
    final String[] pozycja = wiadomoscOdPolaczenia.split(",");
    
    //Wykonanie ruchu
    boolean wykonano = true;
    try {
      gra.wykonajRuch(polRuch.podajNazwe(), Integer.parseInt(pozycja[0]),
          Integer.parseInt(pozycja[1]), Integer.parseInt(pozycja[2]), Integer.parseInt(pozycja[3]));
    } catch (NiepoprawnyRuch ex) {
      System.err.println("Niepoprawny ruch.");
      gra.ustawRunde(gra.podajRunde() - 1);
      wykonano = false;
    }
    
    polRuch.ruch = false;
    return wykonano;
  }
  
  private boolean sprawdzCzyNazwaWolna(final String nazwa) {
    //Czy pokrywa sie z jakimœ graczem
    for (int i=0; i < polaczenie.size(); i++) {
      if (nazwa.equals(polaczenie.get(i).podajNazwe())) {
        return false;
      }
    }
    //Czy pokrywa siê z nazwami botów
    if (nazwa.equals("Bot1") || nazwa.equals("Bot2") || nazwa.equals("Bot3") ||
        nazwa.equals("Bot4") || nazwa.equals("Bot5") || nazwa.equals("Bot6")) {
      return false;
    }
    
    return true; 
  }
  
  /**
   * Aktualizuje wiadomoœc od po³¹czenia.
   * @param wiadomosc Wiadomoœc od po³¹czenia
   */
  public void podajWiadomosc(final String wiadomosc) {
    this.wiadomoscOdPolaczenia = wiadomosc;
  }
  
  /**
   * Zamyka serwer.
   */
  public void zamknijSerwer() {
    zamkniecieSerwera = true;
    System.out.println("Zamkniêto serwer.");
  }
  
  private void zamknijSockety() {
    for (Polaczenie pol: polaczenie) {
      pol.zamknijPolaczenie();
    }
    try {
      this.socketSerwer.close();
    } catch (IOException ex) {}
  }
  
  /**
   * Podaje listê z nazwami aktualnie po³¹czonych graczy.
   */
  public List<String> podajListePolaczen() {
    final List<String> lista = new ArrayList<String>();
    for (Polaczenie pol: polaczenie) {
      lista.add(pol.podajNazwe());
    }
    return lista;
  }
  
  /**
   * Podaje czy serwer jest zamkniêty.
   * @return True je¿eli serwer jest zamkniêty.
   */
  public boolean czyZamkniety() {
    return this.zamkniecieSerwera;
  }
}
