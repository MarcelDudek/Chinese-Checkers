package tp.chinesecheckers;

/**
 * 
 * @author mdlot
 *
 */
public class Bot extends Zawodnik {

  /**
   * Konstruktor.
   * @param nazwa Nazwa bota.
   */
  public Bot(final String nazwa) {
    super(nazwa);
  }
  
  /**
   * Konstruktor.
   * @param zawodnik Zawodnik do skopiowania.
   */
  public Bot(final Zawodnik zawodnik) {
    super(zawodnik);
  }
}
