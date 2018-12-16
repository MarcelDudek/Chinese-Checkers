package tp.chinesecheckers;

import java.util.List;

import tp.chinesecheckers.exception.NiepoprawnyRuch;
import tp.chinesecheckers.exception.PionekNaTejPozycjiNieIstnieje;

/**
 * 
 * @author mdlot
 *
 */
public class GraDomyslnaSerwer extends GraDomyslna implements RozgrywkaSerwer {

  @Override
  /**
   * Dodaje gracza do gry.
   */
  public void dodajGracza(final String nazwa, final long ipAdres, final int iloscGraczy) {
    TworcaGracza tworca = null;
    
    //dla 2 graczy
    if (iloscGraczy == 2) {
      switch (this.zawodnik.size()) {
        case 0:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(12, 0, KierunekTworzeniaPionkow.S);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 1:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(12, 16, KierunekTworzeniaPionkow.N);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        default:
          break;
      }
    }
    
    //dla 3 graczy
    if (iloscGraczy == 3) {
      switch (this.zawodnik.size()) {
        case 0:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(12, 0, KierunekTworzeniaPionkow.S);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 1:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(0, 12, KierunekTworzeniaPionkow.NE);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 2:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(24, 12, KierunekTworzeniaPionkow.NW);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        default:
          break;
      }
    }
    
    //dla 4 graczy
    if (iloscGraczy == 4) {
      switch (this.zawodnik.size()) {
        case 0:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(12, 0, KierunekTworzeniaPionkow.S);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 1:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(12, 16, KierunekTworzeniaPionkow.N);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 2:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(0, 4, KierunekTworzeniaPionkow.SE);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 3:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(24, 12, KierunekTworzeniaPionkow.NW);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        default:
          break;
      }
    }
    
    //dla 6 graczy
    if (iloscGraczy == 6) {
      switch (this.zawodnik.size()) {
        case 0:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(12, 0, KierunekTworzeniaPionkow.S);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 1:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(12, 16, KierunekTworzeniaPionkow.N);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 2:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(0, 4, KierunekTworzeniaPionkow.SE);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 3:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(24, 12, KierunekTworzeniaPionkow.NW);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 4:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(0, 12, KierunekTworzeniaPionkow.NE);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 5:
          tworca = new TworcaGracza(nazwa, ipAdres);
          tworca.ustawMiejsceStartowe(24, 4, KierunekTworzeniaPionkow.SW);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        default:
          break;
      }
    }
  }

  @Override
  /**
   * Dodaje bota do gry.
   */
  public void dodajBota(final String nazwa, final int iloscGraczy) {
    TworcaBota tworca = null;
    
    //dla 2 graczy
    if (iloscGraczy == 2) {
      switch (this.zawodnik.size()) {
        case 0:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(12, 0, KierunekTworzeniaPionkow.S);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 1:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(12, 16, KierunekTworzeniaPionkow.N);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        default:
          break;
      }
    }
    
    //dla 3 graczy
    if (iloscGraczy == 3) {
      switch (this.zawodnik.size()) {
        case 0:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(12, 0, KierunekTworzeniaPionkow.S);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 1:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(0, 12, KierunekTworzeniaPionkow.NE);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 2:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(24, 12, KierunekTworzeniaPionkow.NW);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        default:
          break;
      }
    }
    
    //dla 4 graczy
    if (iloscGraczy == 4) {
      switch (this.zawodnik.size()) {
        case 0:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(12, 0, KierunekTworzeniaPionkow.S);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 1:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(12, 16, KierunekTworzeniaPionkow.N);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 2:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(0, 4, KierunekTworzeniaPionkow.SE);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 3:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(24, 12, KierunekTworzeniaPionkow.NW);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        default:
          break;
      }
    }
    
    //dla 6 graczy
    if (iloscGraczy == 6) {
      switch (this.zawodnik.size()) {
        case 0:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(12, 0, KierunekTworzeniaPionkow.S);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 1:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(12, 16, KierunekTworzeniaPionkow.N);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 2:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(0, 4, KierunekTworzeniaPionkow.SE);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 3:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(24, 12, KierunekTworzeniaPionkow.NW);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 4:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(0, 12, KierunekTworzeniaPionkow.NE);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        case 5:
          tworca = new TworcaBota(nazwa);
          tworca.ustawMiejsceStartowe(24, 4, KierunekTworzeniaPionkow.SW);
          zawodnik.add(tworca.stworzZawodnika());
          break;
        default:
          break;
      }
    }
  }

  @Override
  /**
   * Zamienia gracza na bota.
   */
  public void zamienGraczaNaBota(final String nazwa) {
    Zawodnik zawodnikDoZamiany = null;
    TworcaBota tworca = null;
    for (int i = 0; i < zawodnik.size(); i++) {
      zawodnikDoZamiany = zawodnik.get(i);
      if (zawodnikDoZamiany.podajNazwe().equals(nazwa)) {
        tworca = new TworcaBota(nazwa);
        tworca.wczytajGracza((Gracz)zawodnikDoZamiany);
        zawodnik.set(i, tworca.stworzZawodnika());
      }
    }
  }

  @Override
  /**
   * Wykonuje ruch danym zawodnikiem.
   */
  public void wykonajRuch(final String nazwa, final int staryX, final int staryY,
      final int nowyX, final int nowyY) throws NiepoprawnyRuch {
    Zawodnik zawodnikRuch = null;
    
    //TODO Sprawdzenie czy ruch jest poprawny
    
    //Wykonanie ruchu
    for (int i = 0; i < zawodnik.size(); i++) {
      zawodnikRuch = zawodnik.get(i);
      if (zawodnikRuch.podajNazwe().equals(nazwa)) {
        try {
          zawodnikRuch.przesunPionek(staryX, staryY, nowyX, nowyY);
        } catch (PionekNaTejPozycjiNieIstnieje ex) {
          System.err.println("Pionek na pozycji " + ex.podajX() 
              + ", " + ex.podajY() + " nie istnieje!");
          throw new NiepoprawnyRuch();
        }
      }
    }
  }

  /**
   * Generuje wiadomosc do klientow ze stanem rozgrywki.
   * @param nazwaGraczaAktualnegoRuchu Nazwa gracza, który bêdzie w tej rundzie wykonywa³ ruch
   * @return Wiadomoœc gotowa do wys³ania do klientów
   */
  public String wygenerujWiadomosc(String nazwaGraczaAktualnegoRuchu) {
    String wiadomosc = runda + "%" + nazwaGraczaAktualnegoRuchu;
    Zawodnik zaw = null;
    
    for (int i = 0; i < zawodnik.size(); i++) {
      zaw = zawodnik.get(i);
      //znak typu
      if(zaw instanceof Gracz) {
        wiadomosc += "%G";
      } else {
        wiadomosc += "%B";
      }
      //nazwa
      wiadomosc += "&" + zaw.podajNazwe();
      //ip - nieuzywane
      wiadomosc += "&" + 0;
      //pozycja
      wiadomosc += "&" + zaw.podajPozycje();
      //pozycje pionkow
      List<Pionek> pionek = zaw.podajPionki();
      Pionek pion;
      for (int j = 0; j < 10; j++) {
        pion = pionek.get(j);
        wiadomosc += "&" + pion.podajX() + "," + pion.podajY();
      }
    }
    
    return wiadomosc;
  }
}
