package tp.chinesecheckers.exception;

/**
 * 
 * @author mdlot
 *
 */
public class NiepoprawnaWiadomosc extends Exception {

  /**
   * Wiadomosc, kt�ra jest niepoprawna.
   */
  private final transient String wiadomosc;
  
  /**
   * Konstruktow.
   * @param wiadomosc Wiadomosc, kt�ra jest niepoprawna
   */
  public NiepoprawnaWiadomosc(final String wiadomosc) {
    super();
    this.wiadomosc = new String(wiadomosc);
  }
  
  /**
   * Podaj niepoprawn� wiadomosc.
   * @return Wiadomosc, kt�ra jest niepoprawna
   */
  public String podajWiadomosc() {
    return new String(wiadomosc);
  }
  
}
