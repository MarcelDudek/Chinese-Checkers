package tp.chinesecheckers;

import java.util.ArrayList;
import java.util.List;

import tp.chinesecheckers.exception.NiepoprawnaWiadomosc;

/**
 * 
 * @author mdlot
 *
 */
public class TworcaGryDomyslnej extends TworcaGry {
  
  /**
   * Lista zawodnikow.
   */
  private final transient List<Zawodnik> zawodnik;
  
  /**
   * Runda rozgrywki.
   */
  private transient int runda;
  
  /**
   * Nazwa gracza, który aktualnie wykonuje ruch.
   */
  private transient String wykonujeRuch;
  
  /**
   * Konstruktor.
   */
  public TworcaGryDomyslnej() {
    super();
    zawodnik = new ArrayList<Zawodnik>();
    runda = 0;
    wykonujeRuch = "";
  }
  
  /**
   * £adujê grê z wiadomoœci otrzymanej od serwera.
   * @param wiadomosc Wiadomosc otrzymana od serwera
   * @throws NiepoprawnaWiadomosc Otrzymana wiadomosc jest niepoprawna
   */
  public void zaladujGreZWiadomosci(String wiadomosc) throws NiepoprawnaWiadomosc {
    
    //Je¿eli nie zawiera % wyrzuc b³¹d
    if (!wiadomosc.contains("%")) {
      throw new NiepoprawnaWiadomosc(wiadomosc);
    }
    
    //Rozlozenie stringu w tabele stringow
    final String[] trescWiadomosci = wiadomosc.split("%");
    
    //Wyciagniecie rundy z wiadomosci
    try {
      runda = Integer.parseInt(trescWiadomosci[0]);
    } catch (NumberFormatException ex) {
      throw new NiepoprawnaWiadomosc(wiadomosc);
    }
    
    //Kto aktualnie wykonuje ruch
    wykonujeRuch = trescWiadomosci[1];
    
    //Wyciagniecie danych o zawodnikach
    Zawodnik zawodnikPobrany = null;
    
    for (int i = 2; i < trescWiadomosci.length; i++) {
      //Rozbicie stringa na osobne dane
      final String[] daneZawodnika = trescWiadomosci[i].split("&");
      if (daneZawodnika.length != 14) {
        throw new NiepoprawnaWiadomosc(wiadomosc);
      }
      
      if (daneZawodnika[0].equals("G") || daneZawodnika[0].equals("B")) {
        //Wyciagniecie danych o zawodniku
        final String nazwaZawodnika = daneZawodnika[1];
        long ipZawodnika = 0;
        int pozycjaZawodnika = 0;
        try {
          ipZawodnika = Long.parseLong(daneZawodnika[2]);
          pozycjaZawodnika = Integer.parseInt(daneZawodnika[3]);
        } catch (NumberFormatException ex) {
          throw new NiepoprawnaWiadomosc(wiadomosc);
        }
        
        //Stworzenie gracza lub bota
        if (daneZawodnika[0].equals("G")) {
          zawodnikPobrany = new Gracz(nazwaZawodnika, ipZawodnika);
        }
        if (daneZawodnika[0].equals("B")) {
          zawodnikPobrany = new Bot(nazwaZawodnika);
        }
        
        //Ustawianie pozycji gracza
        zawodnikPobrany.ustawPozycje(pozycjaZawodnika);
        
        //Wyciagniecie pozycji pionkow z wiadomosci
        for (int j = 4; j < 14; j++) {
          final String[] pozycja = daneZawodnika[j].split(",");
          if (pozycja.length != 2) {
            throw new NiepoprawnaWiadomosc(wiadomosc);
          }
          int pozycjaX = 0;
          int pozycjaY = 0;
          
          try {
            pozycjaX = Integer.parseInt(pozycja[0]);
            pozycjaY = Integer.parseInt(pozycja[1]);
          } catch (NumberFormatException ex) {
            throw new NiepoprawnaWiadomosc(wiadomosc);
          }
          
          zawodnikPobrany.dodajPionek(pozycjaX, pozycjaY);
        }
        //Dodanie zawodnika do listy
        zawodnik.add(zawodnikPobrany);
      }
    }
  }
  
  @Override
  /**
   * Tworzy grê na podstawie wczeœniej wczytanych danych.
   */
  public Gra stworzGre() {
    final GraDomyslna gra = new GraDomyslna();
    gra.ustawRunde(runda);
    gra.ustawKtoWykonujeRuch(wykonujeRuch);
    
    //Dodaj zawodnikow
    for (int i = 0; i < zawodnik.size(); i++) {
      gra.dodajZawodnika(zawodnik.get(i));
    }
    
    return gra;
  }

}
