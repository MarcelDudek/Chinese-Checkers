package tp.chinesecheckers.klient;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class Piony {

	ArrayList<Point> punkty = new ArrayList<Point>();
	int IloscGraczy=6; //gdy serwer przesle klasie plansza ilosc graczy w klasie plansza,
	//ustawimy wartosc tutaj
	
	public void Ustaw_pionki(Graphics2D g3d)

	{
		int ptkX, ptkX2, ptkX3, ptkX4;
		int ptkY, ptkY2, ptkY3, ptkY4;

		g3d.setColor(Color.BLACK);

		ptkX = 198;
		ptkY = 177;
		ptkX2 = 214;
		ptkY2 = 211;
		ptkX3 = 235;
		ptkY3 = 245;
		ptkX4 = 256;
		ptkY4 = 279;

		for (int i = 0; i < 4; i++) {
			punkty.add(new Point(ptkX, ptkY));
			ptkX = ptkX + 40;

		}

		for (int i = 0; i < 3; i++) {

			punkty.add(new Point(ptkX2, ptkY2));
			ptkX2 = ptkX2 + 40;

		}
		for (int i = 0; i < 2; i++) {

			punkty.add(new Point(ptkX3, ptkY3));
			ptkX3 = ptkX3 + 40;

		}

		punkty.add(new Point(ptkX4, ptkY4));

		int x1, y1;
		if(IloscGraczy==4)
		{
			for (int i = 20; i < 30; i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
		}
		else 
		{
		for (int i = 0; i < 10; i++) {
			x1 = (int) punkty.get(i).getX();
			y1 = (int) punkty.get(i).getY();
			g3d.fillOval(x1, y1, 25, 25);

			}
		}

	}

	public void Ustaw_pionki2(Graphics2D g3d) {// lewy dolny
		int ptkX, ptkX2, ptkX3, ptkX4;
		int ptkY, ptkY2, ptkY3, ptkY4;

		g3d.setColor(Color.CYAN);

		ptkX = 198;
		ptkY = 453;
		ptkX2 = 214;
		ptkY2 = 419;
		ptkX3 = 235;
		ptkY3 = 385;
		ptkX4 = 256;
		ptkY4 = 351;

		for (int i = 0; i < 4; i++) {
			punkty.add(new Point(ptkX, ptkY));
			ptkX = ptkX + 40;

		}

		for (int i = 0; i < 3; i++) {

			punkty.add(new Point(ptkX2, ptkY2));
			ptkX2 = ptkX2 + 40;

		}
		for (int i = 0; i < 2; i++) {

			punkty.add(new Point(ptkX3, ptkY3));
			ptkX3 = ptkX3 + 40;

		}

		punkty.add(new Point(ptkX4, ptkY4));

		int x1, y1;
		
			for (int i = 10; i < 20; i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
		
	}

	public void Ustaw_pionki3(Graphics2D g3d) {// prawy dolny
		int ptkX, ptkX2, ptkX3, ptkX4;
		int ptkY, ptkY2, ptkY3, ptkY4;

		g3d.setColor(Color.BLUE);

		ptkX = 558;
		ptkY = 453;
		ptkX2 = 574;
		ptkY2 = 419;
		ptkX3 = 595;
		ptkY3 = 385;
		ptkX4 = 616;
		ptkY4 = 351;

		for (int i = 0; i < 4; i++) {
			punkty.add(new Point(ptkX, ptkY));
			ptkX = ptkX + 40;

		}

		for (int i = 0; i < 3; i++) {

			punkty.add(new Point(ptkX2, ptkY2));
			ptkX2 = ptkX2 + 40;

		}
		for (int i = 0; i < 2; i++) {

			punkty.add(new Point(ptkX3, ptkY3));
			ptkX3 = ptkX3 + 40;

		}

		punkty.add(new Point(ptkX4, ptkY4));

		int x1, y1;

	 
		 if(IloscGraczy==4)
		{
			

			for (int i = 30; i < 40; i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
			
		}
		else if(IloscGraczy==6)
		{
			for (int i = 20; i < 30; i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
		}
	}

	public void Ustaw_pionki4(Graphics2D g3d) {// prawy gorny
		int ptkX, ptkX2, ptkX3, ptkX4;
		int ptkY, ptkY2, ptkY3, ptkY4;

		g3d.setColor(Color.GRAY);

		ptkX = 558;
		ptkY = 177;
		ptkX2 = 574;
		ptkY2 = 211;
		ptkX3 = 595;
		ptkY3 = 245;
		ptkX4 = 616;
		ptkY4 = 279;

		for (int i = 0; i < 4; i++) {
			punkty.add(new Point(ptkX, ptkY));
			ptkX = ptkX + 40;

		}

		for (int i = 0; i < 3; i++) {

			punkty.add(new Point(ptkX2, ptkY2));
			ptkX2 = ptkX2 + 40;

		}
		for (int i = 0; i < 2; i++) {

			punkty.add(new Point(ptkX3, ptkY3));
			ptkX3 = ptkX3 + 40;

		}

		punkty.add(new Point(ptkX4, ptkY4));

		int x1, y1;

		if(IloscGraczy==3)
		{
			for (int i = 10; i < 20; i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
			
		}
	 
		else if(IloscGraczy==6)
		{
		
			for (int i = 30; i < 40; i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
		}
	}
	public void Ustaw_pionki5(Graphics2D g3d) {// dolny dolny
		int ptkX, ptkX2, ptkX3, ptkX4;
		int ptkY, ptkY2, ptkY3, ptkY4;

		g3d.setColor(Color.DARK_GRAY);

		ptkX = 377;
		ptkY = 488;
		ptkX2 = 393;
		ptkY2 = 522;
		ptkX3 = 414;
		ptkY3 = 556;
		ptkX4 = 435;
		ptkY4 = 590;

		for (int i = 0; i < 4; i++) {
			punkty.add(new Point(ptkX, ptkY));
			ptkX = ptkX + 40;

		}

		for (int i = 0; i < 3; i++) {

			punkty.add(new Point(ptkX2, ptkY2));
			ptkX2 = ptkX2 + 40;

		}
		for (int i = 0; i < 2; i++) {

			punkty.add(new Point(ptkX3, ptkY3));
			ptkX3 = ptkX3 + 40;

		}

		punkty.add(new Point(ptkX4, ptkY4));

		int x1, y1;

		if(IloscGraczy==2)
		{
			for (int i = 0; i < 10; i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
		}
		else if(IloscGraczy==3)
		{
			for (int i = 20; i < 30; i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
		}
		else if(IloscGraczy==4)
		{

			for (int i = 0; i < 10; i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
		}
		else if(IloscGraczy==6)
		{
			for (int i = 40; i < 50; i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
		}
	}

	public void Ustaw_pionki6(Graphics2D g3d) {// gorny gorny
		int ptkX, ptkX2, ptkX3, ptkX4;
		int ptkY, ptkY2, ptkY3, ptkY4;

		g3d.setColor(Color.MAGENTA);

		ptkX = 377;
		ptkY = 142;
		ptkX2 = 393;
		ptkY2 = 108;
		ptkX3 = 414;
		ptkY3 = 70;
		ptkX4 = 435;
		ptkY4 = 36;

		for (int i = 0; i < 4; i++) {
			punkty.add(new Point(ptkX, ptkY));
			ptkX = ptkX + 40;

		}

		for (int i = 0; i < 3; i++) {

			punkty.add(new Point(ptkX2, ptkY2));
			ptkX2 = ptkX2 + 40;

		}
		for (int i = 0; i < 2; i++) {

			punkty.add(new Point(ptkX3, ptkY3));
			ptkX3 = ptkX3 + 40;

		}

		punkty.add(new Point(ptkX4, ptkY4));

		int x1, y1;
		if(IloscGraczy==2)
		{
			for (int i = 10; i < 20; i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
		}
		else if(IloscGraczy==4)
		{

			for (int i = 10; i < 20; i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
		}
		else if(IloscGraczy==6)
		{
			for (int i = 50; i < 60; i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);

			}
		}

	}
	public void  RysujPionki(Graphics2D g3d)
	{
		int x1, y1;
		for(Point p : punkty) 
		{
			x1 = (int) p.getX();
			y1 = (int) p.getY();
			g3d.fillOval(x1, y1, 25, 25);
		}
		
		
	}

}
