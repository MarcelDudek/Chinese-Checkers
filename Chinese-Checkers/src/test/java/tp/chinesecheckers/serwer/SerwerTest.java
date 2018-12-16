package tp.chinesecheckers.serwer;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import org.junit.Test;

public class SerwerTest {

  @Test
  public void testPolaczenia() {
    
    Serwer serwer = new Serwer(5000, 2);
    Thread t = new Thread(serwer);
    t.start();
    
    String wiadomosc = "";
    String ip = "";
    
    try(final DatagramSocket socket = new DatagramSocket()){
      socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
      ip = socket.getLocalAddress().getHostAddress();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    
    System.out.println("Test: "+ ip);
    
    try {
      //Klient nr 1
      Socket socketKlient = new Socket(ip, 5000);
      InputStreamReader reader = new InputStreamReader(socketKlient.getInputStream());
      BufferedReader readerBuffer = new BufferedReader(reader);
      PrintWriter writer = new PrintWriter(socketKlient.getOutputStream());
      wiadomosc = readerBuffer.readLine();
      assertEquals("Otrzymana wiadomosc powinna brzmiec podaj_nazwe", "podaj_nazwe", wiadomosc);
      writer.println("Nazwa gracza");
      writer.flush();
      wiadomosc = readerBuffer.readLine();
      assertEquals("Otrzymana wiadomosc powinna brzmiec polaczenie_udane", "polaczenie_udane", wiadomosc);
      
      //Klient nr 2
      socketKlient = new Socket(ip, 5000);
      reader = new InputStreamReader(socketKlient.getInputStream());
      readerBuffer = new BufferedReader(reader);
      writer = new PrintWriter(socketKlient.getOutputStream());
      wiadomosc = readerBuffer.readLine();
      assertEquals("Otrzymana wiadomosc powinna brzmiec podaj_nazwe", "podaj_nazwe", wiadomosc);
      writer.println("Nazwa gracza");
      writer.flush();
      wiadomosc = readerBuffer.readLine();
      assertEquals("Otrzymana wiadomosc powinna brzmiec nazwa_zajeta", "nazwa_zajeta", wiadomosc);
      
      //Klient nr 2 drugie podejscie
      socketKlient = new Socket(ip, 5000);
      reader = new InputStreamReader(socketKlient.getInputStream());
      readerBuffer = new BufferedReader(reader);
      writer = new PrintWriter(socketKlient.getOutputStream());
      wiadomosc = readerBuffer.readLine();
      assertEquals("Otrzymana wiadomosc powinna brzmiec podaj_nazwe", "podaj_nazwe", wiadomosc);
      writer.println("Inna nazwa gracza");
      writer.flush();
      wiadomosc = readerBuffer.readLine();
      assertEquals("Otrzymana wiadomosc powinna brzmiec polaczenie_udane", "polaczenie_udane", wiadomosc);
      
      writer.println("9,13,8,12");
      writer.flush();
      readerBuffer.readLine();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
