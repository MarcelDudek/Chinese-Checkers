package tp.chinesecheckers;

import tp.chinesecheckers.exception.NiepoprawnyRuch;

public interface RozgrywkaSerwer {

  public void dodajGracza(String nazwa, long ipAdres);
  
  public void dodajBota(String nazwa);
  
  public void zamienGraczaNaBota(String nazwa);
  
  public void wykonajRuch(String nazwa, int staryX, int staryY, int nowyX, int nowyY) throws NiepoprawnyRuch;
}
