package eu.b24u;

import eu.b24u.javafx.Aplikacja;
import eu.b24u.javafx.Plotno;
import eu.b24u.javafx.Program;
import eu.b24u.javafx.Scena;
import eu.b24u.javafx.element.Prostokat;
import eu.b24u.javafx.element.Punkt;
import javafx.scene.paint.Color;

public class MojaAplikacja extends Aplikacja {

	Plansza plansza;
	boolean czyKolko;
	private Prostokat prostokat00;
	private Prostokat prostokat11;


	@Override
	public void zdarzenieKlikniecaMyszka(double x, double y, Plotno plotno) {
		Program.wypisz("x=" + x + " y=" + y);
		// plotno.czysc();
		boolean czyZawieraProstokat00 = prostokat00.czyZawieraPunkt(x, y);
		Program.wypisz("Czy kliknieto w prostokat 0 0 :" + czyZawieraProstokat00);
		boolean czyZawieraProstokat11 = prostokat11.czyZawieraPunkt(x, y);
		Program.wypisz("Czy kliknieto w prostokat 1 1 :" + czyZawieraProstokat11);

		// TODO MojaAplikacja 2 Sprawdzaj na liscie w ktorym jest kwadracie
		// TODO MojaAplikacja 3 Chodzenie po liscie elementow, poznajemy jak sprawdzac
		// elementy w
		// liscie
		// TODO MojaAplikacja 4 sprawdzenie czy punkt klikniety zawiera sie w danym
		// kwadracie
		// rysuj w odpowiednim kwadracie krzyzyk lub kolko

		if (czyKolko) {
			// jezeli czyZawieraProstokat00 prawda rysuj rysujKolkoWKwadracie
			if (czyZawieraProstokat00) {
				rysujKolkoWKwadracie(plotno, 0, 0);
			}
			// plansza.rysujKolko(x, y);

			czyKolko = false;
		} else {
			if (czyZawieraProstokat00) {
				rysujKrzyzykWKwadracie(plotno, 0, 0);
			}
			// plansza.rysujKrzyzyk(x, y);
			czyKolko = true;
		}

	}


	@Override
	public void budujScene(Scena scena, Plotno plotno) {
		scena.ustawTytul("Kółko i krzyżyk");
		scena.ustawRozmiar(660, 635);
		plotno.ustawRozmiar(660, 635);

		plansza = new Plansza(plotno);
		czyKolko = true;


		// TODO MojaAplikacja 1 Dodaj do listy prostokatow
		prostokat00 = rysujKwadratKolkoIKrzyzyk(plotno, 0, 0);
		prostokat11 = rysujKwadratKolkoIKrzyzyk(plotno, 1, 1);

		// rysujKolkoWKwadracie(plotno, 0, 0);
		// rysujKrzyzykWKwadracie(plotno, 1, 1);
	}

	/**
	 * 
	 * @param plotno
	 * @param x
	 * @param y
	 */
	private Prostokat rysujKwadratKolkoIKrzyzyk(Plotno plotno, int x, int y) {
		Punkt punktPoczatkowy = new Punkt(x * 200 + 10, y * 200 + 10);
		// plotno.rysujProstokat(punktPoczatkowy, new Punkt(180, 180), Color.LIGHTGRAY);
		Punkt wysokoscISzerokosc = new Punkt(180, 180);
		plotno.rysujProstokat(punktPoczatkowy, wysokoscISzerokosc, Color.LIGHTGRAY);
		return new Prostokat(punktPoczatkowy, wysokoscISzerokosc);
	}

	/**
	 * 
	 * @param plotno
	 * @param x
	 * @param y
	 */
	private void rysujKrzyzykWKwadracie(Plotno plotno, int x, int y) {
		Punkt punktPoczatkowy = new Punkt(x * 200 + 10, y * 200 + 10);
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
		Punkt punktPoczatkowy = new Punkt(x * 200 + 10, y * 200 + 10);
		plotno.rysujOkrag(punktPoczatkowy.x, punktPoczatkowy.y, 180);
		plotno.rysujOkrag(punktPoczatkowy.x + 5, punktPoczatkowy.y + 5, 170, Color.WHITE);

	}
	@Override
	public void zdarzeniePrzeciagniecieMyszka(double x, double y, Plotno plotno) {
		plotno.rysujPunkt(x, y);
	}

}
