package tp.chinesecheckers.serwer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

class Polaczenie implements Runnable {

  private String nazwa;
  private Socket socket;
  private InputStreamReader reader;
  private BufferedReader readerBuffer;
  private PrintWriter writer;
  private String wiadomosc;
  private Serwer serwer;
  
  private boolean running;
  
  public boolean ruch;
  
  public Polaczenie(String nazwa, Socket socket, Serwer serwer) {
    this.nazwa = nazwa;
    this.socket = socket;
    this.ruch = false;
    this.running = false;
    this.serwer = serwer;
  }
  
  public String podajNazwe() {
    return new String(nazwa);
  }
  
  public void wyslijWiadomosc(String wiadomosc) {
    if(running) {
      writer.println(wiadomosc);
      writer.flush();
    }
  }
  
  public void zamknijPolaczenie() {
    try {
    socket.close();
    reader.close();
    readerBuffer.close();
    writer.close();
    } catch (IOException ex) {}
  }
  
  @Override
  public void run() {
    running = true;
    
    try {
      reader = new InputStreamReader(socket.getInputStream());
      readerBuffer = new BufferedReader(reader);
      writer = new PrintWriter(socket.getOutputStream());
      
      while(!serwer.czyZamkniety()) {
        wiadomosc = readerBuffer.readLine();
        if(ruch) {
          serwer.podajWiadomosc(wiadomosc);
        }
      }
    } catch(SocketException ex) {
      
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }
}
