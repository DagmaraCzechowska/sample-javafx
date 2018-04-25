package eu.b24u;

import eu.b24u.javafx.Aplikacja;
import eu.b24u.javafx.Plotno;
import eu.b24u.javafx.Program;
import eu.b24u.javafx.Scena;
import eu.b24u.javafx.element.Lista;
import eu.b24u.javafx.element.Prostokat;
import eu.b24u.javafx.element.Punkt;
import eu.b24u.javafx.gra.Kratka;
import eu.b24u.javafx.gra.Kratka.Figura;
import eu.b24u.javafx.gra.PamiecGry;
import javafx.scene.paint.Color;

public class MojaAplikacja extends Aplikacja {

	Plansza plansza;
	boolean czyKolko;
	private Lista<Prostokat> listaProstokatow;
	private PamiecGry pamiecGry;
	boolean koniecGry;

	@Override
	public void zdarzenieKlikniecaMyszka(double x, double y, Plotno plotno) {
		// Program.wypisz("x=" + x + " y=" + y);
		if (koniecGry) {
			utworzNowaPlansze(plotno);
			return;
		}
		Prostokat kliknietyProstokat = zwrocProstokatKlikniety(x, y);
		if (kliknietyProstokat == null) {
			return;
		}
		Figura figura = null;

		if (pamiecGry.czyKratkaJestPusta(kliknietyProstokat.x, kliknietyProstokat.y)) {
			if (czyKolko) {
				figura = Figura.KOLKO;

			} else {
				figura = Figura.KRZYZYK;
			}

			pamiecGry.dodajKliknietaKratke(kliknietyProstokat.x, kliknietyProstokat.y, figura);
			rysujFigureWKratce(plotno, kliknietyProstokat);

			if (pamiecGry.czyWygrana()) {
				Punkt p1 = new Punkt(0, 250);
				Punkt p2 = new Punkt(600, 100);
				plotno.rysujPelnyProstokat(p1, p2, Color.RED);
				plotno.wypiszTekst(170, 315, 60, "Wygrana", Color.WHITE);
			}

			ruchWykonanyPrzezBota(plotno, figura);

			if (pamiecGry.czyKoniecGry()) {
				koniecGry = true;
				// TODO zwiekszanie przegranej lub wygranej jak rozroznic ?
			}
		}
		if (figura != null) {
			// Tworzenie testow
			Program.wypisz("gra.dodajKliknietaKratke(" + policzWspolrzedna(kliknietyProstokat.x) + ", "
					+ policzWspolrzedna(kliknietyProstokat.y) + ", Figura." + figura.name().toUpperCase() + ");");
		}
	}

	public void ruchWykonanyPrzezBota(Plotno plotno, Figura figura) {
		// TODO Kiedy ma wykonac ruch BOT
		// TODO Jakie kroki ma wykonac BOT ?

		boolean czyPusta = false;
		// wykrzyknik oznacza zaprzeczenie
		while (!czyPusta) {
			// 1. losowanie kratki
			int losX = Program.losujLiczbe(0, 2);
			int losY = Program.losujLiczbe(0, 2);
			Kratka wylosowanaKratka = new Kratka(losX, losY);
			// 1a po wylosowaniu kratki trzeba sprawic czy jest pusta, losujemy az
			czyPusta = pamiecGry.czyKratkaJestPusta(wylosowanaKratka);
			if (czyPusta) {
				Prostokat wylosowanyProstokat = zmienKratkeNaProstokat(wylosowanaKratka);
				rysujFigureWKratce(plotno, wylosowanyProstokat);

				// TODO dodawanie kratki kliknietej przez BOTa do pamieci gry
				// pamiecGry.dodajKliknietaKratke(wylosowanyProstokat.x, wylosowanyProstokat.y,
				// figura);

				// przerywamy losowanie
			} else {
				// losuje jeszcze raz

			}
		}
		// znajdziemy pusta
		// 2. dodanie kratki do pamieci gry
		// 3. rysowanie figury
		// TODO wylosuj kratke ktora ma wybrac BOT
	}

	public void rysujFigureWKratce(Plotno plotno, Prostokat wylosowanyProstokat) {
		// rysuje figure
		if (czyKolko) {
			rysujKolkoWKwadracie(plotno, (int) wylosowanyProstokat.x, (int) wylosowanyProstokat.y);
			czyKolko = false;
		} else {
			rysujKrzyzykWKwadracie(plotno, (int) wylosowanyProstokat.x, (int) wylosowanyProstokat.y);
			czyKolko = true;
		}
	}

	private int policzWspolrzedna(int wspolrzedna) {
		int tymczasowo = wspolrzedna - 10;
		return tymczasowo / 200;
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

	/**
	 * Budowanie okna aplikacji po uruchomieniu<br>
	 * metoda wykonuje sie tylko raz!
	 */
	@Override
	public void budujScene(Scena scena, Plotno plotno) {
		scena.ustawTytul("Kółko i krzyżyk");
		scena.ustawRozmiar(640, 620);
		plotno.ustawRozmiar(640, 640);
		pamiecGry = new PamiecGry();
		utworzNowaPlansze(plotno);
	}

	/**
	 * Tworzenie nowej planszy od poczatku
	 * 
	 * @param plotno
	 */
	private void utworzNowaPlansze(Plotno plotno) {
		plotno.czysc();
		plansza = new Plansza(plotno);
		czyKolko = true;
		koniecGry = false;
		listaProstokatow = new Lista<Prostokat>();
		pamiecGry.wyczyscKratki();
		plotno.wypiszTekst(15, 30, 12, "Wygrane:" + pamiecGry.pobierzWygrane(), Color.GREEN);
		plotno.wypiszTekst(15, 50, 12, "Przegrane:" + pamiecGry.pobierzPrzegrane(), Color.RED);

		rysujKwadratKolkoIKrzyzyk(plotno, 0, 0, listaProstokatow);
		rysujKwadratKolkoIKrzyzyk(plotno, 1, 0, listaProstokatow);
		rysujKwadratKolkoIKrzyzyk(plotno, 2, 0, listaProstokatow);
		rysujKwadratKolkoIKrzyzyk(plotno, 2, 1, listaProstokatow);
		rysujKwadratKolkoIKrzyzyk(plotno, 0, 1, listaProstokatow);
		rysujKwadratKolkoIKrzyzyk(plotno, 1, 1, listaProstokatow);
		rysujKwadratKolkoIKrzyzyk(plotno, 0, 2, listaProstokatow);
		rysujKwadratKolkoIKrzyzyk(plotno, 2, 2, listaProstokatow);
		rysujKwadratKolkoIKrzyzyk(plotno, 1, 2, listaProstokatow);
	}

	/**
	 * metoda rysuje szary kwadrat w ktorym mozna wpisac kolko lub krzyzyk
	 * 
	 * @param plotno
	 * @param x
	 * @param y
	 * @param listaKratek
	 */
	private void rysujKwadratKolkoIKrzyzyk(Plotno plotno, int x, int y, Lista listaKratek) {
		// Punkt punktPoczatkowy = new Punkt(x * 200 + 10, y * 200 + 10);
		// plotno.rysujProstokat(punktPoczatkowy, new Punkt(180, 180), Color.LIGHTGRAY);
		// Punkt wysokoscISzerokosc = new Punkt(180, 180);
		// plotno.rysujProstokat(punktPoczatkowy, wysokoscISzerokosc, Color.LIGHTGRAY);
		Kratka kratka = new Kratka(x, y);
		listaKratek.dodaj(zmienKratkeNaProstokat(kratka));
		// return new Prostokat(punktPoczatkowy, wysokoscISzerokosc);
	}

	private Prostokat zmienKratkeNaProstokat(Kratka kratka) {
		Punkt punktPoczatkowy = new Punkt(((int) kratka.x) * 200 + 10, ((int) kratka.y) * 200 + 10);
		Punkt wysokoscISzerokosc = new Punkt(180, 180);
		return new Prostokat(punktPoczatkowy, wysokoscISzerokosc);
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
