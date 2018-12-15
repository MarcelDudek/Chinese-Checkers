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
  
  @Test
  public void testPromienia() {
    Zawodnik gracz = new Gracz("Imie", 0xD0509802);
    gracz.dodajPromien(10, 15);
    gracz.dodajPromien(11, 15);
    gracz.dodajPromien(10, 14);
    
    List<Pionek> promien = gracz.podajPromien();
    assertEquals("promien ma 3 elementy.", 3, promien.size());
    assertEquals("2 promien x", 11, promien.get(1).podajX());
    assertEquals("3 promien y", 14, promien.get(2).podajY());
    
    List<Pionek> promien2 = gracz.podajPromien();
    assertFalse("Funkcja zwraca kopie promienia.", promien.get(0) == promien2.get(0));
  }

}
