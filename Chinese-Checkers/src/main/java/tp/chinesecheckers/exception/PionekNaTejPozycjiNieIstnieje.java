package tp.chinesecheckers.exception;

/**
 * 
 * @author mdlot
 *
 */
public class PionekNaTejPozycjiNieIstnieje extends Exception {
  
  /**
   * Pozycja na której nie wystêpuje pionek;
   */
  private final transient int pozycjaX;
  private final transient int pozycjaY;

  /**
   * Konstruktor.
   * @param pozycjaX
   * @param pozycjaY
   */
  public PionekNaTejPozycjiNieIstnieje(final int pozycjaX, final int pozycjaY) {
    super();
    this.pozycjaX = pozycjaX;
    this.pozycjaY = pozycjaY;
  }
  
  /**
   * 
   * @return Koordynat X.
   */
  public int podajX() {
    return pozycjaX;
  }
  
  /**
   * 
   * @return Koordynat Y.
   */
  public int podajY() {
    return pozycjaY;
  }
  
}
