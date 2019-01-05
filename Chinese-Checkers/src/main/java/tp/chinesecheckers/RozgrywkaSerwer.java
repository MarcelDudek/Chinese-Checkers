package tp.chinesecheckers;

import tp.chinesecheckers.exception.NiepoprawnyRuch;

public interface RozgrywkaSerwer {

  public void dodajGracza(String nazwa, long ipAdres, int iloscGraczy);
  
  public void dodajBota(String nazwa, int iloscGraczy);
  
  public void zamienGraczaNaBota(String nazwa);
  
  public void wykonajRuch(String nazwa, int staryX, int staryY, int nowyX, int nowyY) throws NiepoprawnyRuch;
  
  public void wykonajRuchBota(String nazwa);
}
