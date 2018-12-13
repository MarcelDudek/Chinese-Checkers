package tp.chinesecheckers;

/**
 * 
 * @author mdlot
 *
 */
public abstract class TworcaZawodnika {
  
  /**
   * Nazwa zawodnika.
   */
  protected transient String nazwa;
  
  /**
   * Konstruktor.
   * @param nazwa Nazwa zawodnika
   */
  public TworcaZawodnika(final String nazwa) {
    this.nazwa = nazwa;
  }
  
  /**
   * Tworzy zawodnika na podstawie wczesniej ustawionych parametrów.
   * @return Stworzony zawodnik.
   */
  public abstract Zawodnik stworzZawodnika();
  
  /**
   * Zmienia nazwe zawodnika.
   * @param nazwa Nowa nazwa
   */
  public void podajNazwe(final String nazwa) {
    this.nazwa = nazwa;
  }
  
}
