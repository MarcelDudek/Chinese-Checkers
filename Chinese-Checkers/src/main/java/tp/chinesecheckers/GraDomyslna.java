package tp.chinesecheckers;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author mdlot
 *
 */
public class GraDomyslna extends Gra {

  /**
   * Lista zawodników.
   */
  protected List<Zawodnik> zawodnik;
  
  /**
   * Konstruktor.
   */
  public GraDomyslna() {
    super();
    zawodnik = new ArrayList<Zawodnik>();
  }
  
  @Override
  /**
   * Dodanie zawodnika.
   */
  public void dodajZawodnika(Zawodnik zawodnik) {
    Zawodnik zawodnikDodany = null;
    
    if(zawodnik instanceof Gracz) {
      zawodnikDodany = new Gracz(zawodnik);
    }
    
    if(zawodnik instanceof Bot) {
      zawodnikDodany = new Bot(zawodnik);
    }
    
    this.zawodnik.add(zawodnikDodany);
  }
  
  /**
   * Zwraca kopiê listy zawodników.
   * @return Kopia listy zawodników.
   */
  public List<Zawodnik> podajListeZawodnikow() {
    List<Zawodnik> lista = new ArrayList<Zawodnik>();
    
    for(int i = 0; i < zawodnik.size(); i++) {
      Zawodnik zawodnikDodany = null;
      
      if(zawodnik.get(i) instanceof Gracz) {
        zawodnikDodany = new Gracz(zawodnik.get(i));
      }
      
      if(zawodnik.get(i) instanceof Bot) {
        zawodnikDodany = new Bot(zawodnik.get(i));
      }
      
      lista.add(zawodnikDodany);
    }
    return lista;
  }

}
