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


	@Override
	public void zdarzenieKlikniecaMyszka(double x, double y, Plotno plotno) {
		Program.wypisz("x=" + x + " y=" + y);
		// plotno.czysc();
		boolean czyZawieraProstokat00 = prostokat00.czyZawieraPunkt(x, y);
		Program.wypisz("Czy kliknieto w prostokat 0 0 :" + czyZawieraProstokat00);

		if (czyKolko) {
			// jezeli czyZawieraProstokat00 prawda rysuj rysujKolkoWKwadracie
			plansza.rysujKolko(x, y);
			czyKolko = false;
		} else {
			plansza.rysujKrzyzyk(x, y);
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



		prostokat00 = rysujKwadratKolkoIKrzyzyk(plotno, 0, 0);
		rysujKwadratKolkoIKrzyzyk(plotno, 1, 1);

		rysujKolkoWKwadracie(plotno, 0, 0);
		rysujKrzyzykWKwadracie(plotno, 1, 1);
	}

	/**
	 * 
	 * @param plotno
	 * @param x
	 * @param y
	 */
	private Prostokat rysujKwadratKolkoIKrzyzyk(Plotno plotno, int x, int y) {
		Punkt punktPoczatkowy = new Punkt(x * 200 + 10, y * 200 + 10);
		plotno.rysujProstokat(punktPoczatkowy, new Punkt(180, 180), Color.BLACK);
		Punkt wysokoscISzerokosc = new Punkt(180, 180);
		plotno.rysujProstokat(punktPoczatkowy, wysokoscISzerokosc, Color.BLACK);
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
		// rysuj linie pierwsza na ukos
		// rysuj linie druga na ukos

	}

	/**
	 * 
	 * @param plotno
	 * @param x
	 * @param y
	 */
	private void rysujKolkoWKwadracie(Plotno plotno, int x, int y) {
		Punkt punktPoczatkowy = new Punkt(x * 200 + 10, y * 200 + 10);
		// rysuj okrag niebieski domyslny
		// rysuj okrag bialy

	}
	@Override
	public void zdarzeniePrzeciagniecieMyszka(double x, double y, Plotno plotno) {
		// TODO Auto-generated method stub
		plotno.rysujPunkt(x, y);
	}

}
