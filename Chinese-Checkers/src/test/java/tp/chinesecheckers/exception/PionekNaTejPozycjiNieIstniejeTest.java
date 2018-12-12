package tp.chinesecheckers.exception;

import static org.junit.Assert.*;

import org.junit.Test;

public class PionekNaTejPozycjiNieIstniejeTest {

  @Test
  public void testFunkcji() {
    PionekNaTejPozycjiNieIstnieje ex = new PionekNaTejPozycjiNieIstnieje(10, 20);
    assertEquals(10, ex.podajX());
    assertEquals(20, ex.podajY());
  }

}
