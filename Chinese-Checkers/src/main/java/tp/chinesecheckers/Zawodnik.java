package tp.chinesecheckers;

import java.util.List;
import java.util.ArrayList;

public abstract class Zawodnik {

  private String nazwa;
  private int pozycjaKoncowa;
  private List<Pionek> pionek;
  
  public Zawodnik(String nazwa) {
    this.nazwa = nazwa;
    pozycjaKoncowa = 0;
    pionek = new ArrayList();
  }
  
  public void dodajPionek(int pozycjaX, int pozycjaY) {
    //TODO
  }
  
  public void przesunPionek(int staraPozycjaX, int staraPozycjaY, int nowaPozycjaX, int nowaPozycjaY) {
    //TODO
  }
  
  public void ustawPozycje(int pozycja) {
    //TODO
  }
  
  public int podajPozycje() {
    //TODO
    return 0;
  }
  
  public List<Pionek> podajPionki(){
    //TODO
    return pionek;
  }
}
