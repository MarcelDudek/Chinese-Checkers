package chinskie.warcaby;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.awt.EventQueue;
import java.awt.geom.GeneralPath;

import javax.imageio.ImageIO;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Obrazek extends JPanel  implements MouseListener,  MouseMotionListener
{
 
	 
	
	
	Point toRemove = null;
	Point movingPoint = null;
	ArrayList<Point> punkty = new ArrayList<Point>();
	ArrayList<Point> pozaPlansze = new ArrayList<Point>();
	
	boolean kolor,kolor2,kolor3,kolor4,kolor5,kolor6;//numery odpowiadaja voidom do rys pionkow
	//sa to flagi logiczne odpowiedzialne za zmiane koloru pionkow
	
	private BufferedImage image;

	public Obrazek() {
		super();

		
 
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(300, 400));
		
		File imageFile = new File("C:\\Users\\Kazik\\Desktop\\warcaby2Obraz.jpg");
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

		Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
		setPreferredSize(dimension);
		//Ustaw_pionki();
		//Ustaw_pionki2();
		//Ustaw_pionki3();
	//	Ustaw_pionki4();
	//	Ustaw_pionki5();
	//	Ustaw_pionki6();
	}

	public void Ustaw_pionki(Graphics2D g3d)//przemysl w ktorym miejscu wywolac metode, raczej nie paint comoponent
	{//lewy gorny od niego sie zaczelo
		int ptkX,ptkX2,ptkX3,ptkX4;//doodamy przycisk w gui pt"rozmiesc pionki"
		//bedzie zapisywal punkty ale tylko raz i bedzie mozna je usuwac, usun met z mouse clicked
		int ptkY,ptkY2,ptkY3,ptkY4;
		
		kolor=true;
		
		ptkX=198;
		ptkY=177;
		ptkX2=214;
		ptkY2=211;
		ptkX3=235;
		ptkY3=245;
		ptkX4=256;
		ptkY4=279;
		
		
		for(int i = 0; i<4; i++)
		{
			punkty.add(new Point(ptkX,ptkY));
			ptkX=ptkX+40;
			
		}
		
		for(int i = 0; i<3; i++)
		{

		 
			punkty.add(new Point(ptkX2,ptkY2));
			ptkX2=ptkX2+40;
			
		}
		for(int i = 0; i<2; i++)
		{

		 
			punkty.add(new Point(ptkX3,ptkY3));
			ptkX3=ptkX3+40;
			
		}
		
		punkty.add(new Point(ptkX4,ptkY4));
		
			int x1, y1;
		
			if(kolor=true)
		{ 
			for (int i =0; i<10;i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
			kolor=false;
		}
	}
	
	public void Ustaw_pionki2(Graphics2D g3d)//inny kolor bedzie 6 tych metod
	{//lewy dolny operacje na y bazujac na void 1
		int ptkX,ptkX2,ptkX3,ptkX4;

		int ptkY,ptkY2,ptkY3,ptkY4;
		
		kolor2=true;
		
		ptkX=198;
		ptkY=453;
		ptkX2=214;
		ptkY2=419;
		ptkX3=235;
		ptkY3=385;
		ptkX4=256;
		ptkY4=351;
		
		
		
		for(int i = 0; i<4; i++)
		{
			punkty.add(new Point(ptkX,ptkY));
			ptkX=ptkX+40;
			
		}
		
		for(int i = 0; i<3; i++)
		{

		 
			punkty.add(new Point(ptkX2,ptkY2));
			ptkX2=ptkX2+40;
			
		}
		for(int i = 0; i<2; i++)
		{

		 
			punkty.add(new Point(ptkX3,ptkY3));
			ptkX3=ptkX3+40;
			
		}
		
		punkty.add(new Point(ptkX4,ptkY4));
		
		int x1,y1;
		if(kolor2=true)
		{ 
			for (int i =10; i<20;i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}kolor2=false;
		}
	}

	public void Ustaw_pionki3(Graphics2D g3d)//inny kolor bedzie 6 tych metod
	{//prawy dolny operacje na x bazujac na void 2
		int ptkX,ptkX2,ptkX3,ptkX4;

		int ptkY,ptkY2,ptkY3,ptkY4;
		
		kolor3=true;
		
		
		ptkX=558;
		ptkY=453;
		ptkX2=574;
		ptkY2=419;
		ptkX3=595;
		ptkY3=385;
		ptkX4=616;
		ptkY4=351;
		
		
		
		for(int i = 0; i<4; i++)
		{
			punkty.add(new Point(ptkX,ptkY));
			ptkX=ptkX+40;
			
		}
		
		for(int i = 0; i<3; i++)
		{

		 
			punkty.add(new Point(ptkX2,ptkY2));
			ptkX2=ptkX2+40;
			
		}
		for(int i = 0; i<2; i++)
		{

		 
			punkty.add(new Point(ptkX3,ptkY3));
			ptkX3=ptkX3+40;
			
		}
		
		punkty.add(new Point(ptkX4,ptkY4));
		

		int x1,y1;
		if(kolor3=true)
		{ 
			for (int i =20; i<30;i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}kolor3=false;
		}
	}
	
	public void Ustaw_pionki4(Graphics2D g3d)//inny kolor bedzie 6 tych metod
	{//prawy gorny operacje na y bazujac na void 3
		int ptkX,ptkX2,ptkX3,ptkX4;

		int ptkY,ptkY2,ptkY3,ptkY4;
		
		kolor4=true;
		
		ptkX=558;
		ptkY=177;
		ptkX2=574;
		ptkY2=211;
		ptkX3=595;
		ptkY3=245;
		ptkX4=616;
		ptkY4=279;
		
		
		
		for(int i = 0; i<4; i++)
		{
			punkty.add(new Point(ptkX,ptkY));
			ptkX=ptkX+40;
			
		}
		
		for(int i = 0; i<3; i++)
		{

		 
			punkty.add(new Point(ptkX2,ptkY2));
			ptkX2=ptkX2+40;
			
		}
		for(int i = 0; i<2; i++)
		{

		 
			punkty.add(new Point(ptkX3,ptkY3));
			ptkX3=ptkX3+40;
			
		}
		
		punkty.add(new Point(ptkX4,ptkY4));
		
		int x1,y1;
		if(kolor4=true)
		{ 
			for (int i =30; i<40;i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}kolor4=false;
		}
	}
	public void Ustaw_pionki5(Graphics2D g3d)//inny kolor bedzie 6 tych metod
	{//dolny dolny operacje na nowej bazie
		int ptkX,ptkX2,ptkX3,ptkX4;

		int ptkY,ptkY2,ptkY3,ptkY4;
		
		kolor5=true;
		
		
		ptkX=377;
		ptkY=488;
		ptkX2=393;
		ptkY2=522;
		ptkX3=414;
		ptkY3=556;
		ptkX4=435;
		ptkY4=590;
		
		
		
		for(int i = 0; i<4; i++)
		{
			punkty.add(new Point(ptkX,ptkY));
			ptkX=ptkX+40;
			
		}
		
		for(int i = 0; i<3; i++)
		{

		 
			punkty.add(new Point(ptkX2,ptkY2));
			ptkX2=ptkX2+40;
			
		}
		for(int i = 0; i<2; i++)
		{

		 
			punkty.add(new Point(ptkX3,ptkY3));
			ptkX3=ptkX3+40;
			
		}
		
		punkty.add(new Point(ptkX4,ptkY4));
		
		int x1,y1;
		if(kolor5=true)
		{ 
			for (int i =40; i<50;i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}kolor5=false;
		}
	}
	
	public void Ustaw_pionki6(Graphics2D g3d)//inny kolor bedzie 6 tych metod
	{//gorny gorny operacje na nowej bazie
		int ptkX,ptkX2,ptkX3,ptkX4;

		int ptkY,ptkY2,ptkY3,ptkY4;
		
		kolor6=true;
		
		ptkX=377;
		ptkY=142;
		ptkX2=393;
		ptkY2=108;
		ptkX3=414;
		ptkY3=70;
		ptkX4=435;
		ptkY4=36;
		
		
		
		for(int i = 0; i<4; i++)
		{
			punkty.add(new Point(ptkX,ptkY));
			ptkX=ptkX+40;
			
		}
		
		for(int i = 0; i<3; i++)
		{

		 
			punkty.add(new Point(ptkX2,ptkY2));
			ptkX2=ptkX2+40;
			
		}
		for(int i = 0; i<2; i++)
		{

		 
			punkty.add(new Point(ptkX3,ptkY3));
			ptkX3=ptkX3+40;
			
		}
		
		punkty.add(new Point(ptkX4,ptkY4));
		
		
		int x1,y1;
		if(kolor6=true)
		{ 
			for (int i =50; i<60;i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}kolor6=false;
		}
	}
	
	//@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this); 
	 
		 
		 
			g2d.setColor(Color.BLACK);
			Ustaw_pionki( g2d);
		 
		 
		 
			g2d.setColor(Color.CYAN);
			Ustaw_pionki2( g2d);
		 //dobry tok myslenia, dziala w sensie
			
			g2d.setColor(Color.BLUE);
			Ustaw_pionki3( g2d);
			
			g2d.setColor(Color.GRAY);
			Ustaw_pionki4( g2d);
		
			g2d.setColor(Color.DARK_GRAY);
			Ustaw_pionki5( g2d);
			
			g2d.setColor(Color.MAGENTA);
			Ustaw_pionki6( g2d);
	 
		 
		 
		
		//drawRectangles(g2d);
	
	}
	
 
	//ponizej metody interfejsu ktore trzeba nadpisac
	public void mouseClicked(MouseEvent e)
	{
		//Ustaw_pionki();
		//repaint();
	
		/*int x,y;
	 
		
		x = e.getX();
		y = e.getY();
		punkty.add(new Point(x, y));
		System.out.println( punkty);
	 
		
		// wspó³rzêdne kwadracików
				int x2, y2;

				// czy chcemy dodaæ, usun¹æ, lub przesun¹æ
				if (e.getButton() == MouseEvent.BUTTON3) {
					Point toRemove = null;
					for (Point p : punkty) {
						x2 = (int) p.getX();
						y2 = (int) p.getY();
						if (x >= x2 && y >= y2 && x <= x2 + 20 && y <= y2 + 20)
							toRemove = p;
					}
					// usuwamy kwadracik
					punkty.remove(toRemove);
		
				}
				
				else if (e.getButton() != MouseEvent.BUTTON3) {
					int index = 0;
					int size = punkty.size();
					Point p;
					while (movingPoint == null && index < size) {
						p = punkty.get(index);
						x2 = (int) p.getX();
						y2 = (int) p.getY();
						if (x >= x2 && y >= y2 && x <= x2 + 20 && y <= y2 + 20)
							movingPoint = p;
						index++;
					}
				}
				
				
				
				if (movingPoint==null && e.getButton() == MouseEvent.BUTTON1) {
					x = e.getX();
					y = e.getY();
					// dodajemy kwadracik
					punkty.add(new Point(x, y));
				}
				
				
				
				repaint();*/
	}
	
	public void mouseEntered(MouseEvent e)
	{
		;
	}
	
	public void mouseExited(MouseEvent e)
	{
		;
	}
	

	public void mousePressed(MouseEvent e)
	{
		
		
	 
	 
		
		int x=0;// = e.getX();
		int y=0;// = e.getY();
		x = e.getX();
		y = e.getY();
		//punkty.add(new Point(x, y));
		//System.out.println( punkty);
	 
		
		// wspó³rzêdne kwadracików
				int x2, y2;
				
				 if (movingPoint==null && e.getButton() == MouseEvent.BUTTON1) {
					//x = e.getX();
					//y = e.getY();
					// dodajemy kwadracik
					punkty.add(new Point(x, y));
					 
				}
				 
				
				// czy chcemy dodaæ, usun¹æ, lub przesun¹æ
				if (e.getButton() == MouseEvent.BUTTON3) {
					 
					
					//Point toRemove = null;
					//for (Point p : punkty)
					for(int i =0;i<60;i++){
						x2 = (int) punkty.get(i).getX();
						y2 = (int) punkty.get(i).getY();
						if (x >= x2 && y >= y2 && x <= x2 + 25 && y <= y2 + 25)
						{
							
							//toRemove = p;
							punkty.set(i, new Point(0,0));
							 
						}
					}
					//punkty.remove(toRemove);
					// usuwamy kwadracik
					//punkty.remove(toRemove);
					repaint();
				}
				
				else if (e.getButton() != MouseEvent.BUTTON3) {
				//	x = e.getX();
				//	y = e.getY();
					int index = 0;
					int size = punkty.size();
					Point p;
					while (movingPoint == null && index < size) {
						p = punkty.get(index);
						x2 = (int) p.getX();
						y2 = (int) p.getY();
						if (x >= x2 && y >= y2 && x <= x2 + 25 && y <= y2 + 25)
							movingPoint = p;
						index++;
						 
					}
				}
				
				
			 
				
				
				repaint();
		
	}

	public void mouseReleased(MouseEvent e)
	{
		 movingPoint = null;
		  
	 
	}
 
	
	public void mouseDragged(MouseEvent e) 
	{
		if (movingPoint != null) {
			movingPoint.x = e.getX();
			movingPoint.y = e.getY();
			repaint();
		}
	}
	public void mouseMoved(MouseEvent e) 
	{
		;
	}

	
/*	public void drawRectangles(Graphics2D g3d) {
		int x1, y1;
		
		if(kolor=true)
		{ 
			for (int i =0; i<9;i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}
			kolor=false;
		}
		if(kolor2=true)
		{ 
			for (int i =9; i<=19;i++) {
				x1 = (int) punkty.get(i).getX();
				y1 = (int) punkty.get(i).getY();
				g3d.fillOval(x1, y1, 25, 25);
			}kolor2=false;
		}
		for (Point p : punkty) {
			x1 = (int) p.getX();
			y1 = (int) p.getY();
			g3d.fillOval(x1, y1, 25, 25);
		}
	}*/
	
	
 
	
	
}
