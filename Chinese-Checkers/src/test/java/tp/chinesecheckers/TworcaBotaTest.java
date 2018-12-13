package tp.chinesecheckers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TworcaBotaTest {

  @Test
  public void testKopiowaniaGracza() {
    TworcaBota twBota = new TworcaBota("Imie");
    Gracz gracz = new Gracz("InneImie", 0xD05098A2);
    gracz.dodajPionek(10, 20);
    gracz.dodajPionek(5, 6);
    
    twBota.wczytajGracza(gracz);
    Bot bot = (Bot)twBota.stworzZawodnika();
    
    assertEquals(20, bot.podajPionki().get(0).podajY());
    assertEquals(5, bot.podajPionki().get(1).podajX());
    assertEquals("InneImie", bot.podajNazwe());
  }

}
