package tp.chinesecheckers;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author mdlot
 *
 */
public class TworcaGryDomyslnejSerwer extends TworcaGry {
  
  private int iloscGraczy;
  private List<Zawodnik> zawodnik;
  
  public TworcaGryDomyslnejSerwer(int iloscGraczy) {
    this.iloscGraczy = iloscGraczy;
    zawodnik = new ArrayList<Zawodnik>();
  }
  
  public void ustawIloscGraczy(int iloscGraczy) {
    this.iloscGraczy = iloscGraczy;
  }
  
  public void dodajGracza(String nazwa, long ipAdres, boolean bot) {
    if(bot) {
      zawodnik.add(new Bot(nazwa));
    } else {
      zawodnik.add(new Gracz(nazwa, ipAdres));
    }
  }

  @Override
  public Gra stworzGre() {
    GraDomyslnaSerwer gra = new GraDomyslnaSerwer();
    if(zawodnik.size() != iloscGraczy)
      return null;
    
    Zawodnik zawodnikDodany = null;
    for (int i = 0; i < zawodnik.size(); i++) {
      zawodnikDodany = zawodnik.get(i);
      if(zawodnikDodany instanceof Gracz) {
        Gracz gracz = (Gracz)zawodnikDodany;
        gra.dodajGracza(gracz.podajNazwe(), gracz.podajIp(), iloscGraczy);
      } else {
        Bot bot = (Bot)zawodnikDodany;
        gra.dodajBota(bot.podajNazwe(), iloscGraczy);
      }
    }
    
    return gra;
  }

}
