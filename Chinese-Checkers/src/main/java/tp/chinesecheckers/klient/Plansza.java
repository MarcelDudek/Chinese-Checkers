package tp.chinesecheckers.klient;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import tp.chinesecheckers.GraDomyslna;
import tp.chinesecheckers.Pionek;
import tp.chinesecheckers.TworcaGryDomyslnej;
import tp.chinesecheckers.Zawodnik;
import tp.chinesecheckers.exception.NiepoprawnaWiadomosc;
import tp.chinesecheckers.klient.Klient.OdbiorcaKomunikatow;
import tp.chinesecheckers.klient.Klient.PrzyciskWyslijListener;

//proba
import java.io.*;
import java.net.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Plansza extends JPanel
		implements
			MouseListener,
			MouseMotionListener {

	private static final long serialVersionUID = 1L;
	Point movingPoint = null;

	ArrayList<Point> punkty = new ArrayList<Point>();

	int iloscGraczy = 6;// musi dostac od serwera wiadomosc z iloscia graczy

	private BufferedImage image;

	Piony pionki;

	//rozpoczynamy wyciaganie informacji z serwera
	
 /*   TworcaGryDomyslnej tworca = new TworcaGryDomyslnej();
    GraDomyslna gra = (GraDomyslna)tworca.stworzGre();
    
    
    String nazwaGracza;  
    int runda; */ 
    //-----------------------------------------------------
	
	
	
	int XpoRuchu = 0;
	int YpoRuchu = 0;
	int Xsrodek;
	int Ysrodek;
	int XdlaSerwera=0;
	int YdlaSerwera=0;
	int XprzedRuchem=0;
	int YprzedRuchem=0;
	int Yzwrotne;
	int Xzwrotne;
	
	String wiadom;//od serwera
	ArrayList<String> ruchyZserwera2 = new ArrayList<String>();
	String [] ruchyZserwera=null;
	
	GraczeIlosc ilu = new GraczeIlosc();
	Klient wysylaj;
 
	public Plansza() {
		 
		super();
 
		 
		 
			 
		 
		
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(300, 400));

		// File imageFile = new File(
		// "C:\\Users\\Kazik\\Desktop\\warcaby2Obraz.jpg");
		try {
			URL imageURL = new URL(
					"https://github.com/MarcelDudek/Chinese-Checkers/blob/Jakub_Kod/Chinese-Checkers/src/main/java/tp/chinesecheckers/klient/warcaby2Obraz.jpg?raw=true");
			image = ImageIO.read(imageURL);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

		Dimension dimension = new Dimension(image.getWidth(),
				image.getHeight());
		setPreferredSize(dimension);
		pionki = new Piony();
		pionki.IloscGraczy = iloscGraczy;
	 
		wysylaj = new Klient();
		wysylaj.doDziela();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this);

		if (iloscGraczy == 2) {

			pionki.Ustaw_pionki5(g2d);
			pionki.Ustaw_pionki6(g2d);
		} else if (iloscGraczy == 3) {
			pionki.Ustaw_pionki(g2d);
			pionki.Ustaw_pionki4(g2d);
			pionki.Ustaw_pionki5(g2d);
		} else if (iloscGraczy == 4) {
			pionki.Ustaw_pionki5(g2d);
			pionki.Ustaw_pionki6(g2d);
			pionki.Ustaw_pionki(g2d);// kolejnosc jest istotna w tych warunkach
			pionki.Ustaw_pionki3(g2d);// bazuja na ifach i petlach for z klasy
										// piony
		} else if (iloscGraczy == 6) {
			pionki.Ustaw_pionki(g2d);
			pionki.Ustaw_pionki2(g2d);
			pionki.Ustaw_pionki3(g2d);
			pionki.Ustaw_pionki4(g2d);
			pionki.Ustaw_pionki5(g2d);
			pionki.Ustaw_pionki6(g2d);

		}
		
		for (Point p : pionki.punkty) {
			punkty.add(p);
		}

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
		XprzedRuchem = e.getX();
		YprzedRuchem = e.getY();
		NamaszczWspolrzednePrzed( XprzedRuchem, YprzedRuchem);
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
	// trzeba bedzie doddac buforowane zmienne
	public void mouseReleased(MouseEvent e) {

		movingPoint = null;
		XpoRuchu = e.getX();// te wspolrzedne beda wysylane do serwera
		YpoRuchu = e.getY();
		 
		// Klient wysylaj = new Klient();

		NamaszczWspolrzedne( XpoRuchu, YpoRuchu);
		
		wysylaj.punktX = Integer.toString(XdlaSerwera);
		wysylaj.punktY = Integer.toString(YdlaSerwera);
		wysylaj.punktXprzed = Integer.toString(XprzedRuchem);
		wysylaj.punktYprzed = Integer.toString(YprzedRuchem);
		wysylaj.wiadomosc.setText(wysylaj.punktXprzed+","+wysylaj.punktYprzed+","+wysylaj.punktX + "," + wysylaj.punktY);
		 
		//probuje naprawic

		
		//--------------------------------------------------------
		
		// wysylaj.doDziela();// jak juz bedzie gotowy serwer to dodamy
		// odbieranie
		// ilosci graczy
		// poniewaz klient jest klasa wewn, nie bedzie problemu z wymiana danych

		//-----------------------------------------------------------
		//ZASADNICZO NA DOBREJ DRODZE 

	/*    TworcaGryDomyslnej tworca = new TworcaGryDomyslnej();

		   try {
			      tworca.zaladujGreZWiadomosci(wiadom);
			    } catch (NiepoprawnaWiadomosc e2) {}
	    GraDomyslna gra = (GraDomyslna)tworca.stworzGre();
	    
	     
	    String nazwaGracza;  
	    int runda;  
		
		 
		 //wciz czesc o ktorej rozmawialismy
		
		nazwaGracza = gra.podajKtoWykonujeRuch();
	    runda = gra.podajRunde();
	    //teraz czesc, z ktorej musze wymyslic jak rozkladac pionki przy pom serwera
	    ArrayList<Zawodnik> zawodnicy = (ArrayList<Zawodnik>) gra.podajListeZawodnikow();
	    
	 //   Zawodnik przykladowyZawodnik = zawodnicy.get(0);
	 //   ArrayList<Pionek> pionki = (ArrayList<Pionek>) przykladowyZawodnik.podajPionki();
	 //   Pionek przykladowyPionek = pionki.get(0);
	 //   int x = przykladowyPionek.podajX();
	 //   int y = przykladowyPionek.podajY();
	    
	    
	    punkty.clear();
	    for( Zawodnik k : zawodnicy)
	    {
	    	
	    	for(Pionek p : k.podajPionki())
	    	{
	    		
	    		NamaszczenieZwrotne(p.podajX(),p.podajY());
	    		punkty.add(new Point(Xzwrotne,Yzwrotne)); 
	    		  
	    		System.out.println(p.podajX());//pomysl jak zrepaintowac
	    		System.out.println(p.podajY());
	    		System.out.println(Xzwrotne);
	    		System.out.println(Yzwrotne);
	    	}
	    	
	    }
	    
	    
	    
	    //----------------------------------petla bedzie chyba potrzebna
	    System.out.println(wiadom);
	    System.out.println(nazwaGracza);
	    System.out.println(runda);
	     */
	    repaint();
	     
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

	//stworzenie voida, ktory ma za zadanie zabezpieczac wspolrzedne ruchu, 
	//numerowane jak te podane na GIT'cie
	public void NamaszczWspolrzedne(int wspX,  int wspY)
	{
		
		for(int i = 0; i<17; i++)
		{
			if(wspY>17 + i*35 && wspY<=55 +i*35)
			{
				YdlaSerwera=i;
			}
		}
		
		for(int k = 0; k<25; k++)
		{
			if(wspX>198 + k*20 && wspX<=218 + k*20)
			{
				XdlaSerwera=k;
			}
		}
		
	}
	public void NamaszczWspolrzednePrzed(int wspX,  int wspY)
	{
		
		for(int i = 0; i<17; i++)
		{
			if(wspY>17 + i*35 && wspY<=55 +i*35)
			{
				YprzedRuchem=i;
			}
		}
		
		for(int k = 0; k<25; k++)
		{
			if(wspX>198 + k*20 && wspX<=218 + k*20)
			{
				XprzedRuchem=k;
			}
		}
		
	}
	
	public void NamaszczenieZwrotne(int wspX, int wspY)
	{
		
		 
		for(int i = 0; i<17; i++)
		{
			if(wspY==i)
			{
				Yzwrotne= 36 + 35*i;
			}
		}
		
		for(int k = 0; k<25; k++)
		{
			if(wspX==k )
			{
				Xzwrotne = 198 + k*20;
			}
		}
	}
	public void OperujSerwerem()
	{
		//-----------------------------------------------------------
				//ZASADNICZO NA DOBREJ DRODZE 

			    TworcaGryDomyslnej tworca = new TworcaGryDomyslnej();

				   try {
					      tworca.zaladujGreZWiadomosci(wiadom);
					    } catch (NiepoprawnaWiadomosc e2) {}
			    GraDomyslna gra = (GraDomyslna)tworca.stworzGre();
			    
			     
			    String nazwaGracza;  
			    int runda;  
				
				 
				 //wciz czesc o ktorej rozmawialismy
				
				nazwaGracza = gra.podajKtoWykonujeRuch();
			    runda = gra.podajRunde();
			    //teraz czesc, z ktorej musze wymyslic jak rozkladac pionki przy pom serwera
			    ArrayList<Zawodnik> zawodnicy = (ArrayList<Zawodnik>) gra.podajListeZawodnikow();
			    
			 //   Zawodnik przykladowyZawodnik = zawodnicy.get(0);
			 //   ArrayList<Pionek> pionki = (ArrayList<Pionek>) przykladowyZawodnik.podajPionki();
			 //   Pionek przykladowyPionek = pionki.get(0);
			 //   int x = przykladowyPionek.podajX();
			 //   int y = przykladowyPionek.podajY();
			    
			    
			    punkty.clear();
			    for( Zawodnik k : zawodnicy)
			    {
			    	
			    	for(Pionek p : k.podajPionki())
			    	{
			    		
			    		NamaszczenieZwrotne(p.podajX(),p.podajY());
			    		punkty.add(new Point(Xzwrotne,Yzwrotne)); 
			    		  
			    		System.out.println(p.podajX());//pomysl jak zrepaintowac
			    		System.out.println(p.podajY());
			    		System.out.println(Xzwrotne);
			    		System.out.println(Yzwrotne);
			    	}
			    	
			    }
			    
			    
			    
			    //----------------------------------petla bedzie chyba potrzebna
			    System.out.println(wiadom);
			    System.out.println(nazwaGracza);
			    System.out.println(runda);
			    repaint();
	}
	
	
	//void odpowiedzialny za sprawdzanie przesuniec pionow
 
	
	public void SprawdzZmiane()//PROBLEM Z TA METODA
	{
		 
		 
		ruchyZserwera = wiadom.split("&");
		//System.out.println(Arrays.toString(ruchyZserwera));
		for(String s :(ruchyZserwera))
		{
		 ruchyZserwera2.add(s);
		}
	 
			
		System.out.println(ruchyZserwera2);
	}
	
	
	public class GraczeIlosc{
		
		JLabel polecenie;
		JTextField informacja;
		Frame ramka;
		
		
		public void doDziela() {
			JFrame ramka = new JFrame("Ilosc Graczy");
			JPanel panelGlowny = new JPanel();
 
 
			polecenie = new JLabel("Ilu Graczy?");
			informacja = new JTextField(20);

			JButton przyciskWyslij = new JButton("Wyslij");
			przyciskWyslij.addActionListener(new PrzyciskWyslijListener());

			panelGlowny.add(polecenie);
			panelGlowny.add(informacja);
			panelGlowny.add(przyciskWyslij);
			 
		 

	 

			ramka.getContentPane().add(BorderLayout.CENTER, panelGlowny);
			ramka.setSize(400, 300);
			ramka.setVisible(true);

		}

		public class PrzyciskWyslijListener implements ActionListener {
			public void actionPerformed(ActionEvent ev) {
	 

				 iloscGraczy = Integer.parseInt(informacja.getText());

			}
		}

		
		
	}
	
	// sprobuje zrobic klienta jako klase wew
	// _______________________________________________________________________//


	public class Klient {

		JTextArea odebraneWiadomosci;
		JTextField wiadomosc;
		BufferedReader czytelnik;
		PrintWriter pisarz;
		Socket gniazdo;
		Frame ramka;
		String punktX;
		String punktY;
		String punktXprzed;
		String punktYprzed;


		public void doDziela() {
			JFrame ramka = new JFrame("Klient Wiadomosci");
			JPanel panelGlowny = new JPanel();

			odebraneWiadomosci = new JTextArea(15, 50);
			odebraneWiadomosci.setLineWrap(true);
			odebraneWiadomosci.setWrapStyleWord(true);
			odebraneWiadomosci.setEditable(false);

			JScrollPane przewijanie = new JScrollPane(odebraneWiadomosci);
			przewijanie.setVerticalScrollBarPolicy(
					ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			przewijanie.setHorizontalScrollBarPolicy(
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

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
			ramka.setSize(650, 400);
			ramka.setVisible(true);

		}

		public class PrzyciskWyslijListener implements ActionListener {
			public void actionPerformed(ActionEvent ev) {
				try {
				 
				 
				 
					pisarz.println(wiadomosc.getText());
					pisarz.flush();
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				 
				wiadomosc.requestFocus();

			}
		}

		private void konfigurujKomunikacje() {
			try {
				gniazdo = new Socket("127.0.0.1", 5000);
				InputStreamReader czytelnikStrm = new InputStreamReader(
						gniazdo.getInputStream());
				czytelnik = new BufferedReader(czytelnikStrm);
				pisarz = new PrintWriter(gniazdo.getOutputStream());
				System.out.println("obsluga sieci gotowa");
			} catch (IOException ex) {
				ex.printStackTrace();

			}
		}
//zajmij sie t¹ czescia aby odebrac dane pionkow
		public class OdbiorcaKomunikatow implements Runnable {
			public void run() {
				//String wiadom;
				try {
					while ((wiadom = czytelnik.readLine()) != null) {
						// System.out.println("Odczytano: " + wiadom);
						odebraneWiadomosci.append(wiadom + "\n");
					 
						 
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				 
			 
				    
			}

		}

	}

}
