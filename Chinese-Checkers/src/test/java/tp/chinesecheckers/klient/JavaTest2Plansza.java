package tp.chinesecheckers.klient;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class JavaTest2Plansza {

	@Test
	public void testNamaszczWspolrzedne() {

		Plansza p = new Plansza();

		p.NamaszczWspolrzedne(200, 60);
		assertEquals("Oczekiwana wartosc: ", 0, p.XdlaSerwera);
		assertEquals("Oczekiwana wartosc: ", 1, p.YdlaSerwera);

	}

	@Test
	public void testNamaszczWspolrzednePrzed() {

		Plansza p = new Plansza();

		p.NamaszczWspolrzednePrzed(260, 130);
		assertEquals("Oczekiwana wartosc: ", 3, p.XprzedRuchem);
		assertEquals("Oczekiwana wartosc: ", 3, p.YprzedRuchem);

	}

	@Test
	public void NamaszczenieZwrotneTest() {

		Plansza p = new Plansza();

		p.NamaszczenieZwrotne(3, 4);
		assertEquals("Oczekiwana wartosc: ", 258, p.Xzwrotne);
		assertEquals("Oczekiwana wartosc: ", 176, p.Yzwrotne);

	}

}
