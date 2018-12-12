package chinskie.warcaby;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.awt.EventQueue;
import java.awt.geom.GeneralPath;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Obrazek extends JPanel  implements MouseListener,  MouseMotionListener
{
	Point toRemove = null;
	Point movingPoint = null;
	ArrayList<Point> punkty = new ArrayList<Point>();
	
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
	}

	public void Ustaw_pionki()//przemysl w ktorym miejscu wywolac metode, raczej nie paint comoponent
	{
		int ptkX;
		int ptkY;
		
		ptkX=198;
		ptkY=177;
		
		for(int i = 0; i<5; i++)
		{
			punkty.add(new Point(ptkX,ptkY));
			ptkX=ptkX+40;
			
		}
		
		
	}
	
	
	
	//@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this); 
		Ustaw_pionki();
		repaint();
		g2d.setColor(Color.BLACK);
		drawRectangles(g2d);
	
	}
	
 
	//ponizej metody interfejsu ktore trzeba nadpisac
	public void mouseClicked(MouseEvent e)
	{
	;
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
		System.out.println( punkty);
	 
		
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
					for (Point p : punkty) {
						x2 = (int) p.getX();
						y2 = (int) p.getY();
						if (x >= x2 && y >= y2 && x <= x2 + 25 && y <= y2 + 25)
						{
							toRemove = p;
							 
						}
					}
					punkty.remove(toRemove);
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

	
	public void drawRectangles(Graphics2D g3d) {
		int x1, y1;
		for (Point p : punkty) {
			x1 = (int) p.getX();
			y1 = (int) p.getY();
			g3d.fillOval(x1, y1, 25, 25);
		}
	}
}
