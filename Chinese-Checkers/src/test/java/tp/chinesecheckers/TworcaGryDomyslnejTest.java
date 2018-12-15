package tp.chinesecheckers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import tp.chinesecheckers.exception.NiepoprawnaWiadomosc;

public class TworcaGryDomyslnejTest {

  @Test
  public void testStworzeniaGryZWiadomosci() {
    TworcaGryDomyslnej tworca = new TworcaGryDomyslnej();
    
    String wiadomosc = "13%Nazwa1%G&Nazwa1&1234&0&1,1&2,2&3,3&4,4&5,5&6,6&7,7&8,8&9,9&10,10%B&Nazwa2&0&0&11,11&22,22&33,33&44,44&55,55&66,66&77,77&88,88&99,99&100,100";
    
    try {
      tworca.zaladujGreZWiadomosci(wiadomosc);
    }
    catch(NiepoprawnaWiadomosc ex) {
      fail("Niepoprawna wiadomosc: " + ex.podajWiadomosc());
    }
    
    GraDomyslna gra = (GraDomyslna)tworca.stworzGre();
    
    assertEquals("Sprawdzenie poprawnosci rundy.", 13, gra.podajRunde());
    assertEquals("Sprawdzenie poprawnosci aktualnego gracza.", "Nazwa1", gra.podajKtoWykonujeRuch());
    
    List<Zawodnik> zawodnik = gra.podajListeZawodnikow();
    
    assertEquals("Lista powinna miec 2 elmenty", 2, zawodnik.size());
    assertTrue("Element 0 to Gracz.", zawodnik.get(0) instanceof Gracz);
    assertTrue("Element 1 to Bot.", zawodnik.get(1) instanceof Bot);
    
    List<Pionek> pionek = zawodnik.get(0).podajPionki();
    
    assertEquals("Element 2 zawodnika 0", 3, pionek.get(2).podajX());
    assertEquals("Element 2 zawodnika 0", 3, pionek.get(2).podajY());
    
    pionek = zawodnik.get(1).podajPionki();
    
    assertEquals("Element 9 zawodnika 1", 100, pionek.get(9).podajX());
    assertEquals("Element 9 zawodnika 1", 100, pionek.get(9).podajY());
  }

}
