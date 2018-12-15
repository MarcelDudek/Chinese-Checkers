package tp.chinesecheckers.exception;

import static org.junit.Assert.*;

import org.junit.Test;

public class NiepoprawnyRuchTest {

  @Test
  public void testTworzeniaObiektu() {
    NiepoprawnyRuch ex = new NiepoprawnyRuch();
    assertFalse("Obiekt stworzony.", ex == null);
  }

}
