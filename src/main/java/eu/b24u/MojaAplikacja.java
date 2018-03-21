package eu.b24u;

import eu.b24u.javafx.Aplikacja;
import eu.b24u.javafx.Plotno;
import eu.b24u.javafx.Program;
import eu.b24u.javafx.Scena;
import eu.b24u.javafx.element.Lista;
import eu.b24u.javafx.element.Prostokat;
import eu.b24u.javafx.element.Punkt;
import javafx.scene.paint.Color;

public class MojaAplikacja extends Aplikacja {

	Plansza plansza;
	boolean czyKolko;
	private Lista<Prostokat> listaKratek;

	@Override
	public void zdarzenieKlikniecaMyszka(double x, double y, Plotno plotno) {
		Program.wypisz("x=" + x + " y=" + y);

		// TODO metoda ktora znajduje klikniety kwadrat

		// TypZmiennej nazwaZmiennej = wartosc;
		Prostokat kliknietyProstokat = zwrocProstokatKlikniety(x, y);


		// TODO MojaAplikacja 2a rysowanie kolka lub krzyzyka w danej kratce
		// rysujKrzyzykWKwadracie(plotno, elementListy.x, elementListy.y);

		// TODO rysowanie w znalezionym kwadracie kolka lub krzyzyka
		// liscie
		// TODO MojaAplikacja 4 sprawdzenie czy punkt klikniety zawiera sie w danym
		// kwadracie

		if (czyKolko) {
			// jezeli czyZawieraProstokat00 prawda rysuj rysujKolkoWKwadracie
			// if (czyZawieraProstokat00) {
			// rysujKolkoWKwadracie(plotno, 0, 0);
			// }
			// plansza.rysujKolko(x, y);
			rysujKolkoWKwadracie(plotno, kliknietyProstokat.x, kliknietyProstokat.y);

			czyKolko = false;
		} else {
			// if (czyZawieraProstokat00) {
			// rysujKrzyzykWKwadracie(plotno, 0, 0);
			// }
			// plansza.rysujKrzyzyk(x, y);
			rysujKrzyzykWKwadracie(plotno, kliknietyProstokat.x, kliknietyProstokat.y);
			czyKolko = true;
		}

	}

	private Prostokat zwrocProstokatKlikniety(double x, double y) {
		for (Prostokat elementListy : listaKratek) {
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

		// TODO MojaAplikacja 1 Dodaj do listy prostokatow
		listaKratek = new Lista<Prostokat>();

		rysujKwadratKolkoIKrzyzyk(plotno, 0, 0, listaKratek);
		rysujKwadratKolkoIKrzyzyk(plotno, 1, 0, listaKratek);
		rysujKwadratKolkoIKrzyzyk(plotno, 2, 0, listaKratek);

		// rysujKolkoWKwadracie(plotno, 0, 0);
		// rysujKrzyzykWKwadracie(plotno, 1, 1);
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
