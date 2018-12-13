package tp.chinesecheckers;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author mdlot
 *
 */
public class TworcaBota extends TworcaZawodnika {
  
  /**
   * Lista pionkow.
   */
  private transient List<Pionek> pionek;
  
  /**
   * Konstruktor.
   * @param nazwa Nazwa bota
   */
  public TworcaBota(final String nazwa) {
    super(nazwa);
    pionek = new ArrayList<Pionek>();
  }
  
  /**
   * Tworzy bota.
   */
  @Override
  public Zawodnik stworzZawodnika() {
    final Zawodnik bot = new Bot(nazwa);
    
    //Dodanie pionków do bota
    Pionek pion;
    for (int i = 0; i < pionek.size(); i++) {
      pion = pionek.get(i);
      bot.dodajPionek(pion.podajX(), pion.podajY());
    }
    
    return bot;
  }
  
  /**
   * Wczytuje dane gracza.
   * @param gracz Gracz do wczytania.
   */
  public void wczytajGracza(final Gracz gracz) {
    this.pionek = gracz.podajPionki();
    this.nazwa = gracz.podajNazwe();
  }
  
  /**
   * Rozk³ada pionki na pó³noc.
   * @param pozycjaX
   * @param pozycjaY
   */
  private void rozlozNaN(final int pozycjaX, final int pozycjaY) {
    pionek.add(new Pionek(pozycjaX, pozycjaY));
    pionek.add(new Pionek(pozycjaX - 1, pozycjaY - 1));
    pionek.add(new Pionek(pozycjaX + 1, pozycjaY - 1));
    pionek.add(new Pionek(pozycjaX - 2, pozycjaY - 2));
    pionek.add(new Pionek(pozycjaX, pozycjaY - 2));
    pionek.add(new Pionek(pozycjaX + 2, pozycjaY - 2));
    pionek.add(new Pionek(pozycjaX - 3, pozycjaY - 3));
    pionek.add(new Pionek(pozycjaX - 1, pozycjaY - 3));
    pionek.add(new Pionek(pozycjaX + 1, pozycjaY - 3));
    pionek.add(new Pionek(pozycjaX + 3, pozycjaY - 3));
  }

  /**
   * Rozk³ada pionki na po³udnie.
   * @param pozycjaX
   * @param pozycjaY
   */
  private void rozlozNaS(final int pozycjaX, final int pozycjaY) {
    pionek.add(new Pionek(pozycjaX, pozycjaY));
    pionek.add(new Pionek(pozycjaX - 1, pozycjaY + 1));
    pionek.add(new Pionek(pozycjaX + 1, pozycjaY + 1));
    pionek.add(new Pionek(pozycjaX - 2, pozycjaY + 2));
    pionek.add(new Pionek(pozycjaX, pozycjaY + 2));
    pionek.add(new Pionek(pozycjaX + 2, pozycjaY + 2));
    pionek.add(new Pionek(pozycjaX - 3, pozycjaY + 3));
    pionek.add(new Pionek(pozycjaX - 1, pozycjaY + 3));
    pionek.add(new Pionek(pozycjaX + 1, pozycjaY + 3));
    pionek.add(new Pionek(pozycjaX + 3, pozycjaY + 3));
  }
  
  /**
   * Rozk³ada pionki.
   * @param pozycjaX
   * @param pozycjaY
   * @param kierunek Kierunek rozk³adania
   */
  public void ustawMiejsceStartowe(final int pozycjaX, final int pozycjaY,
      final KierunekTworzeniaPionkow kierunek) {
    pionek.clear();
    
    int pozX;
    int pozY;
    
    switch (kierunek) {
      case N:
        rozlozNaN(pozycjaX, pozycjaY);
        break;
      case S:
        rozlozNaS(pozycjaX, pozycjaY);
        break;
      case NW:
        pozX = pozycjaX - 3;
        pozY = pozycjaY - 3;
        rozlozNaS(pozX, pozY);
        break;
      case NE:
        pozX = pozycjaX + 3;
        pozY = pozycjaY - 3;
        rozlozNaS(pozX, pozY);
        break;
      case SW:
        pozX = pozycjaX - 3;
        pozY = pozycjaY + 3;
        rozlozNaN(pozX, pozY);
        break;
      case SE:
        pozX = pozycjaX + 3;
        pozY = pozycjaY + 3;
        rozlozNaN(pozX, pozY);
        break;
      default:
        break;
    }
  }
}
