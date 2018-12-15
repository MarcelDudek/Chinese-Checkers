package tp.chinesecheckers;

/**
 * 
 * @author mdlot
 *
 */
public abstract class Gra {
  
  /**
   * Aktualna runda rozgrywki.
   */
  protected transient int runda;
  
  /**
   * Nazwa zawodnika, który aktualnie wykonuje ruch.
   */
  protected transient String wykonujeRuch;
  
  /**
   * Konstruktor.
   */
  public Gra() {
    this.runda = 0;
    wykonujeRuch = "";
  }
  
  /**
   * Dodaje zawodnika do gry.
   * @param zawodnik Zawodnik do dodania
   */
  public abstract void dodajZawodnika(Zawodnik zawodnik);
  
  /**
   * Ustawia rundê rozgrywki.
   * @param runda Ustawiana runda.
   */
  public void ustawRunde(final int runda) {
    this.runda = runda;
  }
  
  /**
   * Podaje aktualn¹ rundê gry.
   * @return Aktualna runda gry.
   */
  public int podajRunde() {
    return this.runda;
  }
  
  /**
   * Ustawia nazwê gracza, który aktualnie wykonuje ruch.
   * @param nazwa Nazwa gracza, który aktualnie wykonuje ruch.
   */
  public void ustawKtoWykonujeRuch(String nazwa) {
    wykonujeRuch = new String(nazwa);
  }
  
  /**
   * Zwraca nazwê gracza, który aktualnie wykonuje ruch.
   * @return Nazwa gracza, który aktualnie wykonuje ruch.
   */
  public String podajKtoWykonujeRuch() {
    return new String(wykonujeRuch);
  }
}
