package tp.chinesecheckers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import tp.chinesecheckers.exception.NiepoprawnyRuch;

public class GraDomyslnaSerwerTest {

  @Test
  public void testDodaniaGracza() {
    GraDomyslnaSerwer gra = new GraDomyslnaSerwer();
    
    gra.dodajGracza("Gracz1", 0, 2);
    gra.dodajGracza("Gracz2", 1, 2);
    
    List<Zawodnik> zawodnik = gra.podajListeZawodnikow();
    
    assertEquals("2 graczy w liscie", 2, zawodnik.size());
    
    List<Pionek> pionek = zawodnik.get(0).podajPionki();
    List<Pionek> promien = zawodnik.get(0).podajPromien();
    
    assertEquals("1 pion 1 gracza w odpowienim miejscu", 12, pionek.get(0).podajX());
    assertEquals("1 pion 1 gracza w odpowienim miejscu", 0, pionek.get(0).podajY());
    
    assertEquals("1 promien 1 gracza w odpowienim miejscu", 12, promien.get(0).podajX());
    assertEquals("1 promien 1 gracza w odpowienim miejscu", 16, promien.get(0).podajY());
  }
  
  @Test
  public void testDodaniaBota() {
    GraDomyslnaSerwer gra = new GraDomyslnaSerwer();
    
    gra.dodajBota("Bot1", 2);
    gra.dodajBota("Bot2", 2);
    
    List<Zawodnik> zawodnik = gra.podajListeZawodnikow();
    
    assertEquals("2 graczy w liscie", 2, zawodnik.size());
    
    List<Pionek> pionek = zawodnik.get(0).podajPionki();
    List<Pionek> promien = zawodnik.get(0).podajPromien();
    
    assertEquals("1 pion 1 gracza w odpowienim miejscu", 12, pionek.get(0).podajX());
    assertEquals("1 pion 1 gracza w odpowienim miejscu", 0, pionek.get(0).podajY());
    
    assertEquals("1 promien 1 gracza w odpowienim miejscu", 12, promien.get(0).podajX());
    assertEquals("1 promien 1 gracza w odpowienim miejscu", 16, promien.get(0).podajY());
  }
  
  @Test
  public void testZamianyGraczaNaBota() {
    GraDomyslnaSerwer gra = new GraDomyslnaSerwer();
    
    gra.dodajGracza("Gracz1", 0, 4);
    gra.dodajGracza("Gracz2", 1, 4);
    gra.dodajGracza("Gracz3", 3, 4);
    gra.dodajGracza("Gracz4", 4, 4);
    
    assertTrue("Gracz3 to gracz", gra.podajListeZawodnikow().get(2) instanceof Gracz);
    
    List<Pionek> pionek = gra.podajListeZawodnikow().get(2).podajPionki();
    List<Pionek> promien = gra.podajListeZawodnikow().get(2).podajPromien();
    
    gra.zamienGraczaNaBota("Gracz3");
    
    assertTrue("Gracz3 to bot", gra.podajListeZawodnikow().get(2) instanceof Bot);
    assertEquals("Nazwa sie nie zmienila", "Gracz3", gra.podajListeZawodnikow().get(2).podajNazwe());
    
  }
  
  @Test
  public void testWykonaniaRuchu() {
    GraDomyslnaSerwer gra = new GraDomyslnaSerwer();
    
    gra.dodajGracza("Gracz1", 0, 2);
    gra.dodajGracza("Gracz2", 1, 2);
    
    List<Zawodnik> zawodnik = gra.podajListeZawodnikow();
    
    assertEquals("2 graczy w liscie", 2, zawodnik.size());
    
    List<Pionek> pionek = zawodnik.get(0).podajPionki();
    List<Pionek> promien = zawodnik.get(0).podajPromien();
    
    assertEquals("1 pion 1 gracza w odpowienim miejscu", 12, pionek.get(0).podajX());
    assertEquals("1 pion 1 gracza w odpowienim miejscu", 0, pionek.get(0).podajY());
    
    assertEquals("1 promien 1 gracza w odpowienim miejscu", 12, promien.get(0).podajX());
    assertEquals("1 promien 1 gracza w odpowienim miejscu", 16, promien.get(0).podajY());
    
    try {
      gra.wykonajRuch("Gracz1", 13, 3, 12, 4);
    } catch(NiepoprawnyRuch ex) {
      fail("Blad");
    }
    
    assertEquals("Pionek przesuniety", 12, gra.podajListeZawodnikow().get(0).podajPionki().get(8).podajX());
    assertEquals("Pionek przesuniety", 4, gra.podajListeZawodnikow().get(0).podajPionki().get(8).podajY());
  }
}
