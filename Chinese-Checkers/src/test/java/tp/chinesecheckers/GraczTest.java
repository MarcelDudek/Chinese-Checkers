package tp.chinesecheckers;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class GraczTest {

  @Test
  public void testNazwyIp() {
    Gracz gracz = new Gracz("Imie", 0xD0509802);
    assertEquals("Imie", gracz.podajNazwe());
    assertEquals(0xD0509802, gracz.podajIp());
  }
  
  @Test
  public void testDodaniaPionka() {
    Zawodnik gracz = new Gracz("Imie", 0xD0509802);
    gracz.dodajPionek(10, 20);
    gracz.dodajPionek(5, 33);
    gracz.dodajPionek(52, 11);
    
    List<Pionek> pionek = gracz.podajPionki();
    assertEquals(3, pionek.size());
    
    Pionek pion = pionek.get(2);
    assertEquals(11, pion.podajY());
    
    pionek.get(2).przesunPionek(70, 70);
    pionek = null;
    pionek = gracz.podajPionki();
    pion = pionek.get(2);
    assertFalse(pion.podajX() == 70);
  }
  
  @Test
  public void testUstawieniaPozycji() {
    Zawodnik gracz = new Gracz("Imie", 0xD0509802);
    gracz.ustawPozycje(2);
    assertEquals(2, gracz.podajPozycje());
    gracz.ustawPozycje(-5);
    assertEquals(0, gracz.podajPozycje());
  }

}
