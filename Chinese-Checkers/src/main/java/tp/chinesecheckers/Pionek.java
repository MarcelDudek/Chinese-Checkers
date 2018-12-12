package tp.chinesecheckers;

/**
 * 
 * @author mdlot
 *
 */
public class Pionek {
  
  /**
   * Koordynaty
   */
  private transient int pozX;
  private transient int pozY;
  
  /**
   * Konstruktor.
   * @param pozycjaX
   * @param pozycjaY
   */
  public Pionek(final int pozycjaX, final int pozycjaY) {
    this.pozX = pozycjaX;
    this.pozY = pozycjaY;
  }
  
  /**
   * Konstruktor.
   * @param pionek Pionek, który zostanie skopiowany
   */
  public Pionek(final Pionek pionek) {
    this.pozX = pionek.podajX();
    this.pozY = pionek.podajY();
  }
  
  /**
   * Zmienia po³o¿enie pionka.
   * @param pozycjaX
   * @param pozycjaY
   */
  public void przesunPionek(final int pozycjaX, final int pozycjaY) {
    this.pozX = pozycjaX;
    this.pozY = pozycjaY;
  }
  
  /**
   * 
   * @return Pozycja x pionka.
   */
  public int podajX() {
    return pozX;
  }
  
  /**
   * 
   * @return Pozycja y pionka.
   */
  public int podajY() {
    return pozY;
  }
}
