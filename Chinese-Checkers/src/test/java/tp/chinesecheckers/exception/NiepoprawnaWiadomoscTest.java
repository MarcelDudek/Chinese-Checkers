package tp.chinesecheckers.exception;

import static org.junit.Assert.*;

import org.junit.Test;

public class NiepoprawnaWiadomoscTest {

  @Test
  public void testNiepoprawnaWiadomosc() {
    NiepoprawnaWiadomosc ex = new NiepoprawnaWiadomosc("Tresc wiadomosci.");
    String wiadomosc = ex.podajWiadomosc();
    assertEquals("Sprawdzenie tresci.", "Tresc wiadomosci.", wiadomosc);
    assertFalse("Zwraca kopie tresci.", wiadomosc == ex.podajWiadomosc());
  }

}
