package eu.b24u;

import eu.b24u.javafx.Aplikacja;
import eu.b24u.javafx.Plotno;
import eu.b24u.javafx.Program;
import eu.b24u.javafx.Scena;
import eu.b24u.javafx.element.Lista;
import eu.b24u.javafx.element.Prostokat;
import eu.b24u.javafx.element.Punkt;
import eu.b24u.javafx.gra.PamiecGry;
import javafx.scene.paint.Color;

public class MojaAplikacja extends Aplikacja {

	Plansza plansza;
	boolean czyKolko;
	private Lista<Prostokat> listaProstokatow;
	private PamiecGry pamiecGry;

	@Override
	public void zdarzenieKlikniecaMyszka(double x, double y, Plotno plotno) {
		Program.wypisz("x=" + x + " y=" + y);

		Prostokat kliknietyProstokat = zwrocProstokatKlikniety(x, y);

		pamiecGry.dodajKliknietaKratke(x, y);

		if (czyKolko) {
			rysujKolkoWKwadracie(plotno, kliknietyProstokat.x, kliknietyProstokat.y);
			czyKolko = false;
		} else {
			rysujKrzyzykWKwadracie(plotno, kliknietyProstokat.x, kliknietyProstokat.y);
			czyKolko = true;
		}

	}

	private Prostokat zwrocProstokatKlikniety(double x, double y) {
		for (Prostokat elementListy : listaProstokatow) {
			boolean czyZawiera = elementListy.czyZawieraPunkt(x, y);
			if (czyZawiera) {
				return elementListy;
			}
		}
		return null;
	}


	@Override
	public void budujScene(Scena scena, Plotno plotno) {
		scena.ustawTytul("Kółko i krzyżyk");
		scena.ustawRozmiar(660, 635);
		plotno.ustawRozmiar(660, 635);

		plansza = new Plansza(plotno);
		czyKolko = true;

		pamiecGry = new PamiecGry();

		listaProstokatow = new Lista<Prostokat>();

		rysujKwadratKolkoIKrzyzyk(plotno, 0, 0, listaProstokatow);
		rysujKwadratKolkoIKrzyzyk(plotno, 1, 0, listaProstokatow);
		rysujKwadratKolkoIKrzyzyk(plotno, 2, 0, listaProstokatow);


	}

	/**
	 * 
	 * @param plotno
	 * @param x
	 * @param y
	 * @param listaKratek
	 */
	private void rysujKwadratKolkoIKrzyzyk(Plotno plotno, int x, int y, Lista listaKratek) {
		Punkt punktPoczatkowy = new Punkt(x * 200 + 10, y * 200 + 10);
		// plotno.rysujProstokat(punktPoczatkowy, new Punkt(180, 180), Color.LIGHTGRAY);
		Punkt wysokoscISzerokosc = new Punkt(180, 180);
		plotno.rysujProstokat(punktPoczatkowy, wysokoscISzerokosc, Color.LIGHTGRAY);
		listaKratek.dodaj(new Prostokat(punktPoczatkowy, wysokoscISzerokosc));
		// return new Prostokat(punktPoczatkowy, wysokoscISzerokosc);
	}

	/**
	 * 
	 * @param plotno
	 * @param x
	 * @param y
	 */
	private void rysujKrzyzykWKwadracie(Plotno plotno, int x, int y) {
		// Punkt punktPoczatkowy = new Punkt(x * 200 + 10, y * 200 + 10);
		Punkt punktPoczatkowy = new Punkt(x, y);

		int wymiarKwadratu = 180;
		plotno.rysujLinie(punktPoczatkowy.x, punktPoczatkowy.y, punktPoczatkowy.x + wymiarKwadratu,
				punktPoczatkowy.y + wymiarKwadratu);
		plotno.rysujLinie(punktPoczatkowy.x + wymiarKwadratu, punktPoczatkowy.y, punktPoczatkowy.x,
				punktPoczatkowy.y + wymiarKwadratu);
	}

	/**
	 * 
	 * @param plotno
	 * @param x
	 * @param y
	 */
	private void rysujKolkoWKwadracie(Plotno plotno, int x, int y) {
		// Punkt punktPoczatkowy = new Punkt(x * 200 + 10, y * 200 + 10);
		Punkt punktPoczatkowy = new Punkt(x, y);

		plotno.rysujOkrag(punktPoczatkowy.x, punktPoczatkowy.y, 180);
		plotno.rysujOkrag(punktPoczatkowy.x + 5, punktPoczatkowy.y + 5, 170, Color.WHITE);

	}

	@Override
	public void zdarzeniePrzeciagniecieMyszka(double x, double y, Plotno plotno) {
		// plotno.rysujPunkt(x, y);
	}

}
