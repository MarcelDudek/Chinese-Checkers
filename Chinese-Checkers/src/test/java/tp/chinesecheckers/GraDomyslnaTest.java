package tp.chinesecheckers;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class GraDomyslnaTest {

  @Test
  public void testGryDomyslnej() {
    GraDomyslna gra = new GraDomyslna();
    assertEquals("Runda powinna wynosic 0.", 0, gra.podajRunde());
    gra.ustawRunde(10);
    assertEquals("Runda powinna wynosic 10.", 10, gra.podajRunde());
    
    Zawodnik zawodnik1 = new Gracz("Gracz 1", 0xFFFFFF);
    zawodnik1.dodajPionek(5, 10);
    zawodnik1.dodajPionek(30, 2);
    zawodnik1.dodajPionek(72, 43);
    gra.dodajZawodnika(zawodnik1);
    
    Zawodnik zawodnik2 = new Bot("Bot 1");
    zawodnik1.dodajPionek(10, 1);
    zawodnik1.dodajPionek(7, 5);
    gra.dodajZawodnika(zawodnik2);
    
    List<Zawodnik> lista = gra.podajListeZawodnikow();
    assertEquals("Lista powinna miec 2 elementy.", 2, lista.size());
    assertTrue("Instanceof Gracz", lista.get(0) instanceof Gracz);
    assertTrue("Instanceof Bot", lista.get(1) instanceof Bot);
    assertEquals("Sprawdzenie nazwy elementu 0.", "Gracz 1", lista.get(0).podajNazwe());
    assertEquals("Sprawdzenie nazwy elementu 1.", "Bot 1", lista.get(1).podajNazwe());
    
    Gracz gr = (Gracz)lista.get(0);
    assertEquals("Sprawdzenie ip gracza.", 0xFFFFFF, gr.podajIp());
    
    List<Pionek> pionek = lista.get(0).podajPionki();
    assertEquals("Dlugosc listy pionkow.", 3, pionek.size());
    assertEquals("Koordynaty 2 pionka.", 30, pionek.get(1).podajX());
    
    assertFalse("Nie powinny byc tym samym obiektem.", lista.get(0) == zawodnik1);
  }

}
