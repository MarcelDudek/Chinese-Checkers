package tp.chinesecheckers;

import java.util.ArrayList;
import java.util.List;
import tp.chinesecheckers.exception.PionekNaTejPozycjiNieIstnieje;

/**
 * 
 * @author mdlot
 *
 */
public abstract class Zawodnik {
  
  /**
   * Nazwa zawodnika.
   */
  private final transient String nazwa;
  
  /**
   * Pozycja koñcowa: 0-nie ukoñczy³ jeszcze gry; 1,2... pozycja na koniec.
   */
  private transient int pozycjaKoncowa;
  
  /**
   * Lista pionków
   */
  private final transient List<Pionek> pionek;
  
  /**
   * Promien przedstawiony jako pionki na danych pozycjach.
   */
  private final transient List<Pionek> promien;
  
  /**
   * Konstruktor.
   * @param nazwa Nazwa zawodnika.
   */
  public Zawodnik(final String nazwa) {
    this.nazwa = nazwa;
    pozycjaKoncowa = 0;
    pionek = new ArrayList<Pionek>();
    promien = new ArrayList<Pionek>();
  }
  
  /**
   * Konstruktor.
   * @param zawodnik Zawodnik do skopiowania
   */
  public Zawodnik(final Zawodnik zawodnik) {
    this.nazwa = zawodnik.podajNazwe();
    pozycjaKoncowa = zawodnik.podajPozycje();
    
    pionek = new ArrayList<Pionek>();
    final List<Pionek> pionekZawodnik = zawodnik.podajPionki();
    for (int i = 0; i < pionekZawodnik.size(); i++) {
      final Pionek pion = pionekZawodnik.get(i);
      pionek.add(pion);
    }
    
    promien = new ArrayList<Pionek>();
    final List<Pionek> promienZawodnik = zawodnik.podajPromien();
    for (int i = 0; i < promienZawodnik.size(); i++) {
      final Pionek prom = promienZawodnik.get(i);
      pionek.add(prom);
    }
  }
  
  /**
   * Dodaje pionek do listy.
   * @param pozycjaX
   * @param pozycjaY
   */
  public void dodajPionek(final int pozycjaX, final int pozycjaY) {
    pionek.add(new Pionek(pozycjaX, pozycjaY));
  }
  
  /**
   * Przesuwa pionek z danej pozycji na now¹ pozycjê.
   * @param staraPozycjaX Pozycja pionka X
   * @param staraPozycjaY Pozycja pionka Y
   * @param nowaPozycjaX Pozycja pionka X po przesuniêciu
   * @param nowaPozycjaY Pozycja pionka Y po przesuniêciu
   * @throws PionekNaTejPozycjiNieIstnieje Brak pionka na danej pozycji
   */
  public void przesunPionek(final int staraPozycjaX, final int staraPozycjaY,
      final int nowaPozycjaX, final int nowaPozycjaY) throws PionekNaTejPozycjiNieIstnieje {
    
    for (int i = 0; i < pionek.size(); i++) {
      final Pionek pion = pionek.get(i);
      if (pion.podajX() == staraPozycjaX && pion.podajY() == staraPozycjaY) {
        pion.przesunPionek(nowaPozycjaX, nowaPozycjaY);
        return;
      }
    }
    throw new PionekNaTejPozycjiNieIstnieje(staraPozycjaX, staraPozycjaY);
  }
  
  /**
   * Ustawia pozycjê zawodnika.
   * @param pozycja 0 - nie ukoñczy³ jeszcze gry; dla <0 przyjmuje 0.
   */
  public void ustawPozycje(final int pozycja) {
    if (pozycja > 0) {
      this.pozycjaKoncowa = pozycja;
    } else {
      this.pozycjaKoncowa = 0;
    }
  }
  
  /**
   * 
   * @return Kopia nazwy zawodnika.
   */
  public String podajNazwe() {
    return new String(nazwa);
  }
  
  /**
   * 
   * @return Pozycja koñcowa zawodnika.
   */
  public int podajPozycje() {
    return pozycjaKoncowa;
  }
  
  /**
   * Podaje kopiê listy pionków.
   * @return Kopia listy pionków.
   */
  public List<Pionek> podajPionki() {
    final List<Pionek> pion = new ArrayList<Pionek>();
    for (int i = 0; i < pionek.size(); i++) {
      pion.add(new Pionek(pionek.get(i)));
    }
    return pion;
  }
  
  /**
   * Dodaje pionek do promienia.
   * @param pozycjaX
   * @param pozycjaY
   */
  public void dodajPromien(final int pozycjaX, final int pozycjaY) {
    final Pionek prom = new Pionek(pozycjaX, pozycjaY);
    promien.add(prom);
  }
  
  /**
   * Zwraca kopiê listy promienia.
   * @return Kopia listy promienia.
   */
  public List<Pionek> podajPromien() {
    final List<Pionek> prom = new ArrayList<Pionek>();
    for (int i = 0; i < promien.size(); i++) {
      prom.add(new Pionek(promien.get(i)));
    }
    return prom;
  }
}
