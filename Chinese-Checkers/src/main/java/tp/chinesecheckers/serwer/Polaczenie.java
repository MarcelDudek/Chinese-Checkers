package tp.chinesecheckers.serwer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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
  
  @Override
  public void run() {
    running = true;
    
    try {
      reader = new InputStreamReader(socket.getInputStream());
      readerBuffer = new BufferedReader(reader);
      writer = new PrintWriter(socket.getOutputStream());
      
      while(true) {
        wiadomosc = readerBuffer.readLine();
        if(ruch) {
          serwer.podajWiadomosc(wiadomosc);
        }
      }
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }
}
