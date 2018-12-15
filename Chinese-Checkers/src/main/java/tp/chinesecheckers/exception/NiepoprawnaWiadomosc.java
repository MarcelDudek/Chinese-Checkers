package tp.chinesecheckers.exception;

/**
 * 
 * @author mdlot
 *
 */
public class NiepoprawnaWiadomosc extends Exception {

  /**
   * Wiadomosc, która jest niepoprawna.
   */
  private final transient String wiadomosc;
  
  /**
   * Konstruktow.
   * @param wiadomosc Wiadomosc, która jest niepoprawna
   */
  public NiepoprawnaWiadomosc(final String wiadomosc) {
    super();
    this.wiadomosc = new String(wiadomosc);
  }
  
  /**
   * Podaj niepoprawn¹ wiadomosc.
   * @return Wiadomosc, która jest niepoprawna
   */
  public String podajWiadomosc() {
    return new String(wiadomosc);
  }
  
}
