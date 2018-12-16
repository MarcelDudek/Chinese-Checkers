package tp.chinesecheckers.klient;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Plansza extends JPanel
		implements
			MouseListener,
			MouseMotionListener {

	private static final long serialVersionUID = 1L;
	Point movingPoint = null;
	ArrayList<Point> punkty = new ArrayList<Point>();

	private BufferedImage image;

	Piony pionki;

	int Xsrodek;
	int Ysrodek;

	public Plansza() {
		super();

		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(300, 400));

		File imageFile = new File(
				"C:\\Users\\Kazik\\Desktop\\warcaby2Obraz.jpg");
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

		Dimension dimension = new Dimension(image.getWidth(),
				image.getHeight());
		setPreferredSize(dimension);
		pionki = new Piony();

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this);
		for (Point p : pionki.punkty) {
			punkty.add(p);
		}
		pionki.Ustaw_pionki(g2d);

	}

	public void mouseClicked(MouseEvent e) {
		;
	}
	public void mouseEntered(MouseEvent e) {
		;
	}

	public void mouseExited(MouseEvent e) {
		;
	}

	public void mousePressed(MouseEvent e) {
		int x = 0;
		int y = 0;
		x = e.getX();
		y = e.getY();
		int x2, y2;

		if (e.getButton() != MouseEvent.BUTTON3) {

			int index = 0;
			int size = punkty.size();
			Point p;
			while (movingPoint == null && index < size) {
				p = punkty.get(index);
				x2 = (int) p.getX();
				y2 = (int) p.getY();
				Xsrodek = e.getX() - x2;
				Ysrodek = e.getY() - y2;

				if (x >= x2 && y >= y2 && x <= x2 + 25 && y <= y2 + 25) {
					movingPoint = p;
				}
				index++;

			}
		}

		repaint();
	}

	public void mouseReleased(MouseEvent e) {

		movingPoint = null;

	}
	public void mouseDragged(MouseEvent e) {
		if (movingPoint != null) {

			movingPoint.x = e.getX() - Xsrodek;
			movingPoint.y = e.getY() - Ysrodek;
			repaint();
		}
	}
	public void mouseMoved(MouseEvent e) {
		;
	}

}
