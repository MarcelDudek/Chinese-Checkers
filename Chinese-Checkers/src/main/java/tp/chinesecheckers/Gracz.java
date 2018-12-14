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
   * Konstruktor.
   * @param nazwa Nazwa gracza
   * @param ipAdres ip gracza
   */
  public Gracz(final String nazwa, final long ipAdres) {
    super(nazwa);
    this.ipAdres = ipAdres;
  }
  
  /**
   * Konstruktor.
   * @param zawodnik Zawodnik do skopiowania.
   */
  public Gracz(final Zawodnik zawodnik) {
    super(zawodnik);
    if (zawodnik instanceof Gracz) {
      final Gracz zawodnikGracz = (Gracz)zawodnik;
      ipAdres = zawodnikGracz.podajIp();
    } else {
      ipAdres = 0;
    }
  }
  
  /**
   * 
   * @return ip gracza
   */
  public long podajIp() {
    return ipAdres;
  }
}
