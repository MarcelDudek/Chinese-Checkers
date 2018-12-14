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
   * Konstruktor.
   */
  public Gra() {
    this.runda = 0;
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
}
