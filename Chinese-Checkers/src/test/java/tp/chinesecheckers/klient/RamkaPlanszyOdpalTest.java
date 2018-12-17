package tp.chinesecheckers.klient;

import static org.junit.Assert.*;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RamkaPlanszyOdpalTest   {

	Plansza testP; 
	 @Before
	public void przed() {
		
	 

		testP = new Plansza();
		testP.repaint();
	 }

	 
	@Test
	public void test() {
		 
		  assertEquals(   10,testP.punkty.size());
		
	}

}
