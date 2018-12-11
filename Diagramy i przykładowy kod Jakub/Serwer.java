package chinskie.warcaby;

import java.io.*;
import java.net.*;
import java.util.*;

public class Serwer {

	ArrayList strumienieWyjsciowe;
	
	public class Obslugaklientow implements Runnable
	{
		BufferedReader czytelnik;
		Socket gniazdo;
		
		public Obslugaklientow(Socket clientSocket) 
		{
			try 
			{
			gniazdo = clientSocket;
			InputStreamReader isReader = new InputStreamReader(gniazdo.getInputStream());
			czytelnik = new BufferedReader(isReader);
			} 
			catch(Exception ex) 
			{
				ex.printStackTrace();
			}
			
		} // koniec konstruktora
		
		public void run() 
		{
			String wiadomosc;
			try 
			{
			
				
				while ((wiadomosc = czytelnik.readLine()) != null)
				{
					System.out.println("Odczytano: " + wiadomosc);
					rozeslijDoWszystkich(wiadomosc);
				} // koniec ptli
			} 
			catch(Exception ex) 
			{
				ex.printStackTrace();
			}
		} 
		// koniec metody
	}	

	
	
	public void doRoboty() 
	{
		strumienieWyjsciowe = new ArrayList();
		try {
			ServerSocket serverSock = new ServerSocket(5000);
			while(true) {
				Socket gniazdoKlienta = serverSock.accept();
				PrintWriter pisarz = new PrintWriter(gniazdoKlienta.getOutputStream());
				strumienieWyjsciowe.add(pisarz);
				Thread t = new Thread(new Obslugaklientow(gniazdoKlienta));
				t.start();
				System.out.println("mamy polaczenie");
						}
			}
		catch(Exception ex)
		{
			ex.printStackTrace ();
		}
	} // koniec metody
	
public void rozeslijDoWszystkich(String message)
{
	Iterator it = strumienieWyjsciowe.iterator();
	while(it.hasNext())
	{
		try 
		{
			PrintWriter pisarz = (PrintWriter) it.next();
			pisarz.println(message);
			pisarz.flush();
		} 
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	} // koniec ptli
} //
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Serwer().doRoboty();
	}

}
