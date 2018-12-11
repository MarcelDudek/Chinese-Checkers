package chinskie.warcaby;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Obrazek extends JPanel  implements MouseListener{

	int x,y;
	ArrayList<Point> punkty = new ArrayList<Point>();
	
	private BufferedImage image;

	public Obrazek() {
		super();

		addMouseListener(this);
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

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this); 
		 
		
		g2d.setColor(Color.BLACK);
		drawRectangles(g2d);
	
	}
	
 
	//ponizej metody interfejsu ktore trzeba nadpisac
	public void mouseClicked(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
		punkty.add(new Point(x, y));
		System.out.println( punkty);
		repaint();
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
		;
	}

	public void mouseReleased(MouseEvent e)
	{
		;
	}
 
	
	public void drawRectangles(Graphics2D g3d) {
		int x1, y1;
		for (Point p : punkty) {
			x1 = (int) p.getX();
			y1 = (int) p.getY();
			g3d.fillOval(x1, y1, 15, 15);
		}
	}
}
