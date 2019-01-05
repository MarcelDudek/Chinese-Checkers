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
   * Wiadomo�c odebrana od gracza.
   */
  private transient String wiadomosc;
  /**
   * Referencja do serwera, kt�ry obs�uguje to po��czenie.
   */
  private final transient Serwer serwer;
  /**
   * Czy w�tek po��czenia jest uruchomiony.
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
   * @param serwer Referencja do serwera, kt�ry obs�uguje to po��czenie.
   */
  public Polaczenie(String nazwa, Socket socket, Serwer serwer) {
    this.nazwa = nazwa;
    this.socket = socket;
    this.ruch = false;
    this.running = false;
    this.serwer = serwer;
  }
  
  /**
   * Podaje nazw� gracza.
   * @return Nazwa gracza
   */
  public String podajNazwe() {
    return new String(nazwa);
  }
  
  /**
   * Wysy�a wiadomo�c do gracza.
   * @param wiadomosc Wiadomo�c do wys�ania
   */
  public void wyslijWiadomosc(final String wiadomosc) {
    if (running) {
      writer.println(wiadomosc);
      writer.flush();
    }
  }
  
  /**
   * Zamyka po��czenie.
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
   * Metoda w�tku.
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
