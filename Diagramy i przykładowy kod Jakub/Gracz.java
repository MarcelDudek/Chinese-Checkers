package chinskie.warcaby;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.GeneralPath;


public class Gracz {

	//kamien wegielny do calosci
	
	JTextArea odebraneWiadomosci;
	JTextField wiadomosc;
	BufferedReader czytelnik;
	PrintWriter pisarz;
	Socket gniazdo;
	Frame ramka;
	
	//array list bedzie odnosil sie do punktow po kliknieciu myszka na pionka//
	ArrayList<Point> punkty = new ArrayList<Point>();
	//ponizsza klasa wewnetrzna bedzie operowala na kliknieciach myszki//
	
	public class MouseTestPanel extends JPanel implements MouseListener
	{
		int x,y;
		
		public MouseTestPanel() 
		{
			addMouseListener(this);
			setPreferredSize(new Dimension(300, 400));
		}
		//ponizej metody interfejsu ktore trzeba nadpisac
		public void mouseClicked(MouseEvent e)
		{
			x = e.getX();
			y = e.getY();
			punkty.add(new Point(x, y));
			System.out.println( punkty);
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

		
			
	}
	
	public class Frame extends JFrame
	{
		public Frame() 
		{
			super("MouseTest");

			add(new MouseTestPanel());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pack();
			setVisible(true);
		}
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gracz klient = new Gracz();
		klient.doDziela();
		 
		
	}
	
	public void doDziela()
	{
		JFrame ramka = new JFrame("Klient Wiadomosci");
		JPanel panelGlowny = new JPanel();
		ramka = new Frame();
		
		odebraneWiadomosci = new JTextArea(15,50);
		odebraneWiadomosci.setLineWrap(true);
		odebraneWiadomosci.setWrapStyleWord(true);
		odebraneWiadomosci.setEditable(false);
		
		JScrollPane przewijanie = new JScrollPane(odebraneWiadomosci);
		przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		wiadomosc = new JTextField(20);
		
		JButton przyciskWyslij = new JButton("Wyslij");
		przyciskWyslij.addActionListener(new PrzyciskWyslijListener());
		
		panelGlowny.add(przewijanie);
		panelGlowny.add(wiadomosc);
		panelGlowny.add(przyciskWyslij);
		konfigurujKomunikacje();
		
		Thread watekOdbiorcy = new Thread(new OdbiorcaKomunikatow());
		watekOdbiorcy.start();
		
		ramka.getContentPane().add(BorderLayout.CENTER, panelGlowny);
		ramka.setSize(400, 500);
		ramka.setVisible(true);
		
		
	}
	
	private void konfigurujKomunikacje()
	{
		try
		{
			gniazdo = new Socket("127.0.0.1", 5000);
			InputStreamReader czytelnikStrm = new InputStreamReader(gniazdo.getInputStream());
			czytelnik = new BufferedReader(czytelnikStrm);
			pisarz = new PrintWriter(gniazdo.getOutputStream());
			System.out.println("obsluga sieci gotowa");
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
			
		}
	}

	public class PrzyciskWyslijListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			try
			{
				pisarz.println(wiadomosc.getText());
				pisarz.flush();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			wiadomosc.setText("");
			wiadomosc.requestFocus();
		}
	}
	
	public class OdbiorcaKomunikatow implements Runnable
	{
		public void run()
		{
			String wiadom;
			try
			{
				while ((wiadom = czytelnik.readLine()) != null)
				{
					//System.out.println("Odczytano: " + wiadom);
					odebraneWiadomosci.append(wiadom + "\n");
					
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
}



