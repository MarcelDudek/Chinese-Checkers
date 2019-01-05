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
  
  private int iloscZakonczen = 0;

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
    
    //Je¿eli brak ruchu
    if (staryX == nowyX && staryY == nowyY) {
      return;
    }
    
    //Sprawdzenie poprawnoœci ruchu
    if (!sprawdzPoprawnoscRuchu(nazwa, staryX, staryY, nowyX, nowyY)) {
      throw new NiepoprawnyRuch();
    }
    
    //Wykonanie ruchu
    for (int i = 0; i < zawodnik.size(); i++) {
      zawodnikRuch = zawodnik.get(i);
      if (zawodnikRuch.podajNazwe().equals(nazwa)) {
        try {
          zawodnikRuch.przesunPionek(staryX, staryY, nowyX, nowyY);
          
          //Sprawdzenie czy zawodnik zakoñczy³ grê
          if (czyZawodnikZakonczylGre(zawodnikRuch)) {
            zawodnikRuch.ustawPozycje(iloscZakonczen + 1);
          }
        } catch (PionekNaTejPozycjiNieIstnieje ex) {
          System.err.println("Pionek na pozycji " + ex.podajX() 
              + ", " + ex.podajY() + " nie istnieje!");
          throw new NiepoprawnyRuch();
        }
      }
    }
  }
  
  @Override
  /**
   * Wykonuje ruch bota.
   */
  public void wykonajRuchBota(String nazwa) {
    //Znalezienie odpowiedniego zawodnika
    Zawodnik bot = null;
    for (Zawodnik zaw: zawodnik) {
      if (nazwa.equals(zaw.podajNazwe())) {
        bot = zaw;
        break;
      }
    }
    if (bot == null) {
      return;
    }
    
    //Wykonanie ruchu
    List<Pionek> pionek = bot.podajPionki();
    List<Pionek> promien = bot.podajPromien();
    
    for (int i = 0; i < pionek.size(); i++) {
      Pionek pion = pionek.get(i);
      Pionek prom = promien.get(i);
      
      if (!(pion.podajX() == prom.podajX() && pion.podajY() == prom.podajY())) {
        int nowyX = pion.podajX();
        int nowyY = pion.podajY();
        
        if (nowyX < prom.podajX()) {
          nowyX++;
        } else {
          nowyX--;
        }
        
        if (nowyY < prom.podajY()) {
          nowyY++;
        } else {
          nowyY--;
        }
        try {
          wykonajRuch(nazwa, pion.podajX(), pion.podajY(), nowyX, nowyY);
        } catch (NiepoprawnyRuch ex) {
          continue;
        }
        break;
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
      if (zaw instanceof Gracz) {
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
  
  private boolean sprawdzPoprawnoscRuchu(final String nazwa, final int staryX,
      final int staryY, final int nowyX, final int nowyY) {
    
    //Sprawdzenie czy nowe polozenie pionka nie wychodzi poza plansze
    if (nowyX < 0 || nowyX > 24 || nowyY < 0 || nowyY > 16) {
      return false;
    }
    if (nowyY == 0 && (nowyX < 12 || nowyX > 12)) {
      return false;
    }
    if (nowyY == 1 && (nowyX < 11 || nowyX > 13)) {
      return false;
    }
    if (nowyY == 2 && (nowyX < 10 || nowyX > 14)) {
      return false;
    }
    if (nowyY == 3 && (nowyX < 9 || nowyX > 15)) {
      return false;
    }
    if (nowyY == 4 && (nowyX < 0 || nowyX > 24)) {
      return false;
    }
    if (nowyY == 5 && (nowyX < 1 || nowyX > 23)) {
      return false;
    }
    if (nowyY == 6 && (nowyX < 2 || nowyX > 22)) {
      return false;
    }
    if (nowyY == 7 && (nowyX < 3 || nowyX > 21)) {
      return false;
    }
    if (nowyY == 8 && (nowyX < 4 || nowyX > 20)) {
      return false;
    }
    if (nowyY == 9 && (nowyX < 3 || nowyX > 21)) {
      return false;
    }
    if (nowyY == 10 && (nowyX < 2 || nowyX > 22)) {
      return false;
    }
    if (nowyY == 11 && (nowyX < 1 || nowyX > 23)) {
      return false;
    }
    if (nowyY == 12 && (nowyX < 0 || nowyX > 24)) {
      return false;
    }
    if (nowyY == 13 && (nowyX < 9 || nowyX > 15)) {
      return false;
    }
    if (nowyY == 14 && (nowyX < 10 || nowyX > 14)) {
      return false;
    }
    if (nowyY == 15 && (nowyX < 11 || nowyX > 13)) {
      return false;
    }
    if (nowyY == 16 && (nowyX < 12 || nowyX > 12)) {
      return false;
    }
    
    //Sprawdzenie czy nowe polozenie pionka nie wchodzi pomiedzy pola
    if (nowyX % 2 != nowyY % 2) {
      return false;
    }
    
    //Sprawdzenie czy na danej pozycji nie znajduje siê ju¿ inny pionek
    if (czyNaPozycjiZnajdujeSiePionek(nowyX, nowyY)) {
      return false;
    }
    
    /* Sprawdzenie czy dany ruch jest w zasiêgu jednego pola,
     * je¿eli nie jest to, sprawdŸ uruchom rekurencyjnie sprawdzanie
     * dla pól gdzie mo¿liwe jest przeskoczenie innego piona.
     */
    if ((nowyY + 1 == staryY || nowyY - 1 == staryY)
        && (nowyX + 1 == staryX || nowyX - 1 == staryY)) {
      return true;
    }
    
    if ((nowyY == staryY) && (nowyX + 2 == staryX || nowyX - 2 == staryX)) {
      return true;
    }
    
    //Uruchomienie rekurencji
    return sprawdzMozliwoscSkoku(staryX, staryY, staryX, staryY, nowyX, nowyY); 
  }
  
  private boolean sprawdzMozliwoscSkoku(int skadX, int skadY, int dokadX,
      int dokadY, int nowyX, int nowyY) {
    
    //Sprawdzenie czy nowe polozenie pionka nie wychodzi poza plansze
    if (skadX < 0 || skadX > 24 || skadY < 0 || skadY > 16) {
      return false;
    }
    if (skadY == 0 && (skadX < 12 || skadX > 12)) {
      return false;
    }
    if (skadY == 1 && (skadX < 11 || skadX > 13)) {
      return false;
    }
    if (skadY == 2 && (skadX < 10 || skadX > 14)) {
      return false;
    }
    if (skadY == 3 && (skadX < 9 || skadX > 15)) {
      return false;
    }
    if (skadY == 4 && (skadX < 0 || skadX > 24)) {
      return false;
    }
    if (skadY == 5 && (skadX < 1 || skadX > 23)) {
      return false;
    }
    if (skadY == 6 && (skadX < 2 || skadX > 22)) {
      return false;
    }
    if (skadY == 7 && (skadX < 3 || skadX > 21)) {
      return false;
    }
    if (skadY == 8 && (skadX < 4 || skadX > 20)) {
      return false;
    }
    if (skadY == 9 && (skadX < 3 || skadX > 21)) {
      return false;
    }
    if (skadY == 10 && (skadX < 2 || skadX > 22)) {
      return false;
    }
    if (skadY == 11 && (skadX < 1 || skadX > 23)) {
      return false;
    }
    if (skadY == 12 && (skadX < 0 || skadX > 24)) {
      return false;
    }
    if (skadY == 13 && (skadX < 9 || skadX > 15)) {
      return false;
    }
    if (skadY == 14 && (skadX < 10 || skadX > 14)) {
      return false;
    }
    if (skadY == 15 && (skadX < 11 || skadX > 13)) {
      return false;
    }
    if (skadY == 16 && (skadX < 12 || skadX > 12)) {
      return false;
    }
    
    //Sprawdzenie mo¿liwych przeskoków z danej pozycji
    int pionX = dokadX + 1;
    int pionY = dokadY - 1;
    int skokX = pionX + 1;
    int skokY = pionY - 1;
    if (czyNaPozycjiZnajdujeSiePionek(pionX, pionY) &&
        !czyNaPozycjiZnajdujeSiePionek(skokX, skokY)) {
      if (skokX == nowyX && skokY == nowyY) {
        return true;
      } else if (!(skokX == skadX && skokY == skadY)) {
        if (sprawdzMozliwoscSkoku(dokadX, dokadY, skokX, skokY, nowyX, nowyY)) {
          return true;
        }
      }
    }
    
    pionX = dokadX + 2;
    pionY = dokadY;
    skokX = pionX + 2;
    skokY = pionY;
    if (czyNaPozycjiZnajdujeSiePionek(pionX, pionY) &&
        !czyNaPozycjiZnajdujeSiePionek(skokX, skokY)) {
      if (skokX == nowyX && skokY == nowyY) {
        return true;
      } else if (!(skokX == skadX && skokY == skadY)) {
        if (sprawdzMozliwoscSkoku(dokadX, dokadY, skokX, skokY, nowyX, nowyY)) {
          return true;
        }
      }
    }
    
    pionX = dokadX + 1;
    pionY = dokadY + 1;
    skokX = pionX + 1;
    skokY = pionY + 1;
    if (czyNaPozycjiZnajdujeSiePionek(pionX, pionY) &&
        !czyNaPozycjiZnajdujeSiePionek(skokX, skokY)) {
      if (skokX == nowyX && skokY == nowyY) {
        return true;
      } else if (!(skokX == skadX && skokY == skadY)) {
        if (sprawdzMozliwoscSkoku(dokadX, dokadY, skokX, skokY, nowyX, nowyY)) {
          return true;
        }
      }
    }
    
    pionX = dokadX - 1;
    pionY = dokadY + 1;
    skokX = pionX - 1;
    skokY = pionY + 1;
    if (czyNaPozycjiZnajdujeSiePionek(pionX, pionY) &&
        !czyNaPozycjiZnajdujeSiePionek(skokX, skokY)) {
      if (skokX == nowyX && skokY == nowyY) {
        return true;
      } else if (!(skokX == skadX && skokY == skadY)) {
        if (sprawdzMozliwoscSkoku(dokadX, dokadY, skokX, skokY, nowyX, nowyY)) {
          return true;
        }
      }
    }
    
    pionX = dokadX - 2;
    pionY = dokadY;
    skokX = pionX - 2;
    skokY = pionY;
    if (czyNaPozycjiZnajdujeSiePionek(pionX, pionY) &&
        !czyNaPozycjiZnajdujeSiePionek(skokX, skokY)) {
      if (skokX == nowyX && skokY == nowyY) {
        return true;
      } else if (!(skokX == skadX && skokY == skadY)) {
        if (sprawdzMozliwoscSkoku(dokadX, dokadY, skokX, skokY, nowyX, nowyY)) {
          return true;
        }
      }
    }
    
    pionX = dokadX - 1;
    pionY = dokadY - 1;
    skokX = pionX - 1;
    skokY = pionY - 1;
    if (czyNaPozycjiZnajdujeSiePionek(pionX, pionY) &&
        !czyNaPozycjiZnajdujeSiePionek(skokX, skokY)) {
      if (skokX == nowyX && skokY == nowyY) {
        return true;
      } else if (!(skokX == skadX && skokY == skadY)) {
        if (sprawdzMozliwoscSkoku(dokadX, dokadY, skokX, skokY, nowyX, nowyY)){
          return true;
        }
      }
    }
    //Koniec sprawdzania kolejnych pozycji
    
    return false;
  }
  
  private boolean czyNaPozycjiZnajdujeSiePionek(int pozycjaX, int pozycjaY) {
    for (int i = 0; i < zawodnik.size(); i++) {
      List<Pionek> pionek = zawodnik.get(i).podajPionki();
      for (int j = 0; j < pionek.size(); j++) {
        Pionek pion = pionek.get(j);
        if (pion.podajX() == pozycjaX && pion.podajY() == pozycjaY) {
          return true;
        }
      }
    }
    
    return false;
  }
  
  private boolean czyZawodnikZakonczylGre(Zawodnik zawodnik) {
    List<Pionek> pionek = zawodnik.podajPionki();
    List<Pionek> promien = zawodnik.podajPromien();
    
    //Sprawdz wszystkie pola promienia
    boolean znaleziony = false;
    for (Pionek pion: pionek) {
      znaleziony = false;
      for (Pionek prom: promien) {
        if (pion.podajX() == prom.podajX() && pion.podajY() == prom.podajY()) {
          znaleziony = true;
          break;
        }
      }
      if (!znaleziony) {
        return false;
      }
    }
    
    return true;
  }
}
