package tp.chinesecheckers.serwer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 * 
 * @author mdlot
 *
 */
class Polaczenie implements Runnable {

  /**
   * Nazwa gracza.
   */
  private final transient String nazwa;
  /**
   * Socket gracza.
   */
  private final transient Socket socket;
  /**
   * InputStreamReader.
   */
  private transient InputStreamReader reader;
  /**
   * BufferReader.
   */
  private transient BufferedReader readerBuffer;
  /**
   * PrintWriter.
   */
  private transient PrintWriter writer;
  /**
   * Wiadomoœc odebrana od gracza.
   */
  private transient String wiadomosc;
  /**
   * Referencja do serwera, który obs³uguje to po³¹czenie.
   */
  private final transient Serwer serwer;
  /**
   * Czy w¹tek po³¹czenia jest uruchomiony.
   */
  private transient boolean running;
  /**
   * Czy ten gracz aktualnie wykonuje ruch.
   */
  public transient boolean ruch;
  
  /**
   * Konstruktor.
   * @param nazwa Nazwa gracza.
   * @param socket Socket gracza.
   * @param serwer Referencja do serwera, który obs³uguje to po³¹czenie.
   */
  public Polaczenie(String nazwa, Socket socket, Serwer serwer) {
    this.nazwa = nazwa;
    this.socket = socket;
    this.ruch = false;
    this.running = false;
    this.serwer = serwer;
  }
  
  /**
   * Podaje nazwê gracza.
   * @return Nazwa gracza
   */
  public String podajNazwe() {
    return new String(nazwa);
  }
  
  /**
   * Wysy³a wiadomoœc do gracza.
   * @param wiadomosc Wiadomoœc do wys³ania
   */
  public void wyslijWiadomosc(final String wiadomosc) {
    if (running) {
      writer.println(wiadomosc);
      writer.flush();
    }
  }
  
  /**
   * Zamyka po³¹czenie.
   */
  public void zamknijPolaczenie() {
    try {
      socket.close();
      reader.close();
      readerBuffer.close();
      writer.close();
    } catch (IOException ex) {}
  }
  
  @Override
  /**
   * Metoda w¹tku.
   */
  public void run() {
    running = true;
    
    try {
      reader = new InputStreamReader(socket.getInputStream());
      readerBuffer = new BufferedReader(reader);
      writer = new PrintWriter(socket.getOutputStream());
      
      while (!serwer.czyZamkniety()) {
        wiadomosc = readerBuffer.readLine();
        if (ruch) {
          serwer.podajWiadomosc(wiadomosc);
        }
      }
    } catch (SocketException ex) {
      
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
