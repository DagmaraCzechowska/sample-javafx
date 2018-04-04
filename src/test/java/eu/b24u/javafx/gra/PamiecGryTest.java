package eu.b24u.javafx.gra;

import org.junit.jupiter.api.Test;

import eu.b24u.javafx.Program;
import eu.b24u.javafx.gra.Kratka.Figura;

public class PamiecGryTest {

	/**
	 * Tylko kolko nikt nie wygral
	 */
	@Test
	public void test1() {
		Program.wypisz("test1");
		PamiecGry gra = new PamiecGry();
		gra.dodajKliknietaKratke(0, 0, Figura.KOLKO);
		Sprawdz.czyFalsz(gra.czyWygrana());
	}

	/**
	 * 3 kolka po ukosie wygraly kolka
	 */
	@Test
	public void test2() {
		Program.wypisz("test2");
		PamiecGry gra = new PamiecGry();
		gra.dodajKliknietaKratke(0, 0, Figura.KOLKO);
		gra.dodajKliknietaKratke(0, 1, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(1, 1, Figura.KOLKO);
		gra.dodajKliknietaKratke(0, 2, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(2, 2, Figura.KOLKO);
		Sprawdz.czyPrawda(gra.czyWygrana());
	}

	/**
	 * 3 krzyzyki po ukosie wygraly krzyzyki
	 * 
	 */
	@Test
	public void test3() {
		Program.wypisz("test3");
		PamiecGry gra = new PamiecGry();
		gra.dodajKliknietaKratke(2, 1, Figura.KOLKO);
		gra.dodajKliknietaKratke(2, 0, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(0, 2, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(0, 0, Figura.KOLKO);
		gra.dodajKliknietaKratke(1, 1, Figura.KRZYZYK);
		Sprawdz.czyPrawda(gra.czyWygrana());
	}

	/**
	 * Kolumna 1 wygraly krzyzyki
	 */
	@Test
	public void test4() {
		Program.wypisz("test4");
		PamiecGry gra = new PamiecGry();
		// gra.dodajKliknietaKratke(2, 1, Figura.KOLKO);
		gra.dodajKliknietaKratke(2, 0, Figura.KOLKO);
		gra.dodajKliknietaKratke(1, 0, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(0, 2, Figura.KOLKO);
		gra.dodajKliknietaKratke(1, 1, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(2, 2, Figura.KOLKO);
		gra.dodajKliknietaKratke(1, 2, Figura.KRZYZYK);
		Sprawdz.czyPrawda(gra.czyWygrana());
	}

	/**
	 * ?
	 */
	@Test
	public void test5() {
		Program.wypisz("test5");
		PamiecGry gra = new PamiecGry();
		// gra.dodajKliknietaKratke(2, 1, Figura.KOLKO);
		gra.dodajKliknietaKratke(1, 1, Figura.KOLKO);
		gra.dodajKliknietaKratke(1, 2, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(2, 1, Figura.KOLKO);
		gra.dodajKliknietaKratke(0, 1, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(1, 0, Figura.KOLKO);
		gra.dodajKliknietaKratke(0, 0, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(2, 2, Figura.KOLKO);
		Sprawdz.czyFalsz(gra.czyWygrana());
	}

}
