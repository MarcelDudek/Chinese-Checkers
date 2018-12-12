package tp.chinesecheckers;

/**
 * 
 * @author mdlot
 *
 */
public class Gracz extends Zawodnik {
  
  /**
   * Adres ip gracza.
   */
  private final transient long ipAdres;
  
  /**
   * 
   * @param nazwa Nazwa gracza
   * @param ipAdres ip gracza
   */
  public Gracz(final String nazwa, final long ipAdres) {
    super(nazwa);
    this.ipAdres = ipAdres;
  }
  
  /**
   * 
   * @return ip gracza
   */
  public long podajIp() {
    return ipAdres;
  }
}
