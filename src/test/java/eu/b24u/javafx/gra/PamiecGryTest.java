package eu.b24u.javafx.gra;

import org.junit.jupiter.api.Test;

import eu.b24u.javafx.Program;
import eu.b24u.javafx.gra.Kratka.Figura;

public class PamiecGryTest {

	@Test
	public void test() {
		Program.wypisz("test");
		PamiecGry gra = new PamiecGry();
		gra.dodajKliknietaKratke(0, 0, Figura.KOLKO);
		Sprawdz.czyFalsz(gra.czyWygrana());
	}

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

}
