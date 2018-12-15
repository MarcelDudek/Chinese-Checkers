package tp.chinesecheckers;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class TworcaGraczaTest {

  @Test
  public void testUstawianiaPionkow() {
    TworcaGracza twGracza = new TworcaGracza("Imie", 0xD0509802);
    twGracza.ustawMiejsceStartowe(0, 4, KierunekTworzeniaPionkow.SE);
    Zawodnik gracz = twGracza.stworzZawodnika();
    
    List<Pionek> pionek = gracz.podajPionki();
    List<Pionek> promien = gracz.podajPromien();
    
    assertEquals("Test1", 3, pionek.get(0).podajX());
    assertEquals("Test2", 7, pionek.get(0).podajY());
    
    assertEquals("Test promienia 1", 21, promien.get(0).podajX());
    assertEquals("Test promienia 2", 7, promien.get(0).podajY());
    
    assertEquals("Test3", 3, pionek.get(4).podajX());
    assertEquals("Test4", 5, pionek.get(4).podajY());
    
    assertEquals("Test promienia 3", 21, promien.get(4).podajX());
    assertEquals("Test promienia 4", 5, promien.get(4).podajY());
    
    assertEquals("Test5", 6, pionek.get(9).podajX());
    assertEquals("Test6", 4, pionek.get(9).podajY());
    
    assertEquals("Test promienia 5", 24, promien.get(9).podajX());
    assertEquals("Test promienia 6", 4, promien.get(9).podajY());
  }
  
  @Test
  public void testUstawieniaIpImie() {
    TworcaGracza twGracz = new TworcaGracza("Imie", 0xD0509802);
    twGracz.ustawIpAdres(0xD05098A2);
    Gracz gracz = (Gracz)twGracz.stworzZawodnika();
    
    assertEquals("Imie", gracz.podajNazwe());
    assertEquals(0xD05098A2, gracz.podajIp());
    assertEquals(0, gracz.podajPionki().size());
  }

}
