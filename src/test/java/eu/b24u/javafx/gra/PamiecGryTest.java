package eu.b24u.javafx.gra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eu.b24u.javafx.Program;
import eu.b24u.javafx.gra.Kratka.Figura;

/**
 * Wyglad planszy do gry <br>
 * -----------------<br>
 * 0,0 | 1,0 | 2,0 <br>
 * -----------------<br>
 * 0,1 | 1,1 | 2,1 <br>
 * -----------------<br>
 * 0,2 | 1,2 | 2,2 <br>
 * -----------------<br>
 * 
 * @author student
 *
 */
public class PamiecGryTest {

	private PamiecGry gra;

	@BeforeEach
	public void setUp() {
		gra = new PamiecGry();
	}

	/**
	 * Tylko kolko nikt nie wygral
	 */
	@Test
	public void test1() {
		Program.wypisz("test1");
		gra.dodajKliknietaKratke(0, 0, Figura.KOLKO);
		Sprawdz.czyFalsz(gra.czyWygrana());
	}

	/**
	 * 3 kolka po ukosie wygraly kolka
	 */
	@Test
	public void test2() {
		Program.wypisz("test2");

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
		gra.dodajKliknietaKratke(1, 1, Figura.KOLKO);
		gra.dodajKliknietaKratke(1, 2, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(2, 1, Figura.KOLKO);
		gra.dodajKliknietaKratke(0, 1, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(1, 0, Figura.KOLKO);
		gra.dodajKliknietaKratke(0, 0, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(2, 2, Figura.KOLKO);
		Sprawdz.czyFalsz(gra.czyWygrana());
	}


	@Test
	public void test6() {
		Program.wypisz("test6");
		gra.dodajKliknietaKratke(0, 2, Figura.KOLKO);
		gra.dodajKliknietaKratke(2, 2, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(1, 1, Figura.KOLKO);
		gra.dodajKliknietaKratke(0, 1, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(2, 0, Figura.KOLKO);
		Sprawdz.czyPrawda(gra.czyWygrana());
	}


	@Test
	public void test7() {
		Program.wypisz("test7");
		gra.dodajKliknietaKratke(0, 0, Figura.KOLKO);
		gra.dodajKliknietaKratke(0, 1, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(2, 0, Figura.KOLKO);
		gra.dodajKliknietaKratke(1, 1, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(0, 2, Figura.KOLKO);
		gra.dodajKliknietaKratke(2, 1, Figura.KRZYZYK);
		Sprawdz.czyPrawda(gra.czyWygrana());
	}


	@Test
	public void test8() {
		Program.wypisz("test8");
		gra.dodajKliknietaKratke(2, 0, Figura.KOLKO);
		gra.dodajKliknietaKratke(1, 0, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(2, 1, Figura.KOLKO);
		gra.dodajKliknietaKratke(1, 1, Figura.KRZYZYK);
		gra.dodajKliknietaKratke(2, 2, Figura.KOLKO);
		Sprawdz.czyPrawda(gra.czyWygrana());
	}

}
