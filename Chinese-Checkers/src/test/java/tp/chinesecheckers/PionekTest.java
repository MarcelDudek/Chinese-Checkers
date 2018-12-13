package tp.chinesecheckers;

import static org.junit.Assert.*;

import org.junit.Test;

public class PionekTest {

  @Test
  public void testPionka() {
    Pionek pionek = new Pionek(10, 20);
    assertEquals(10, pionek.podajX());
    assertEquals(20, pionek.podajY());
    pionek.przesunPionek(5, 73);
    assertEquals(5, pionek.podajX());
    assertEquals(73, pionek.podajY());
  }

}
