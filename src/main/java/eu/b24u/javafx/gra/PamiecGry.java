package eu.b24u.javafx.gra;

import java.util.Iterator;

import eu.b24u.javafx.Program;
import eu.b24u.javafx.element.Lista;
import eu.b24u.javafx.element.Punkt;
import eu.b24u.javafx.gra.Kratka.Figura;

public class PamiecGry implements InterfejsPamiecGry {

	Lista<Kratka> listaKratek;
	// TODO PamiecGry 2 Lista kratek
	// TODO PamiecGry 3 Sprawdzenie czy kratka jest pusta
	// TODO PamiecGry 4 sprawdzenie czy ktos wygral

	public Lista getListaKratek() {
		return listaKratek;
	}

	public void setListaKratek(Lista listaKratek) {
		this.listaKratek = listaKratek;

	}

	/**
	 * Konstruktor tworzy pamiec gry , tworzy liste kratek
	 */
	public PamiecGry() {
		utworzListeKratek();
	}

	@Override
	public void utworzListeKratek() {
		// TODO utworzListeKratek

		listaKratek = new Lista<Kratka>();
	}

	@Override
	public boolean czyKratkaJestPusta(int x, int y) {
		return pobierzKratke(x, y) == null;
	}

	@Override
	public boolean czyWygrana() {
		Program.wypisz("Lista kratek: " + listaKratek.size());
		if (listaKratek.size() < 5) {
			return false;
		} else {
			for (Kratka kratkaZListy : listaKratek) {
				Program.wypisz(kratkaZListy);
				// po ukosie
				Lista<Kratka> kratkiWiersz0 = pobierzKratkiPoUkosieRosnaco();

				// w pionie
				Lista<Kratka> kratkiKolumna0 = pobierzKratkiWKolumnie(0);
				Program.wypisz("kratkiKolumna0:" + kratkiKolumna0.size());

				if (kratkiKolumna0.size() == 3) {
					Kratka kratka0 = kratkiKolumna0.get(0);
					Kratka kratka1 = kratkiKolumna0.get(1);
					Kratka kratka2 = kratkiKolumna0.get(2);
					if (kratka0.figura == kratka1.figura && kratka0.figura == kratka2.figura) {
						Program.wypisz("wygrana w pierwszej kolumnie");

						return true;
					}

				}
				// w poziomie
				Lista<Kratka> listaKratekWiersz0 = pobierzKratkiWWierszu(0);

			}
			return false;
		}
		// TODO czyWygrana

	}

	private Lista pobierzKratkiWWierszu(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Metoda pobiera kratki w kolumnie
	 * 
	 * @param numerKolumny
	 * @return lista kratek w kolumnie
	 */
	private Lista pobierzKratkiWKolumnie(int numerKolumny) {
		Lista listaZwracana = new Lista();
		for (Kratka kratkaZListy : listaKratek) {
			if (kratkaZListy.x == numerKolumny) {
				listaZwracana.dodaj(kratkaZListy);
			}
		}
		return listaZwracana;
	}

	/**
	 * Metoda pobiera liste kratek po ukosie rosnaco
	 * 
	 * @return zwraca liste kratek
	 */
	private Lista pobierzKratkiPoUkosieRosnaco() {
		Lista listaZwracana = new Lista();
		int licznik = 0;
		for (Kratka kratkaZListy : listaKratek) {
			if (kratkaZListy.x == kratkaZListy.y) {
				listaZwracana.dodaj(kratkaZListy);
			}
		}
		return listaZwracana;
	}

	@Override
	public Punkt kliknietaKratka(double x, double y) {
		// TODO kliknietaKratka
		return null;
	}

	@Override
	public void dodajKliknietaKratke(int x, int y, Figura figura) {
		int wspolrzednaPionowa = -1;
		int wspolrzednaPozioma = -1;
		if (x < 200) {
			wspolrzednaPozioma = 0;
		}
		if (x > 200 && x < 400) {
			wspolrzednaPozioma = 1;
		}
		if (x > 400) {
			wspolrzednaPozioma = 2;
		}

		if (y < 200) {
			wspolrzednaPionowa = 0;
		}
		if (y > 200 && y < 400) {
			wspolrzednaPionowa = 1;
		}
		if (y > 400) {
			wspolrzednaPionowa = 2;
		}
		listaKratek.add(new Kratka(wspolrzednaPozioma, wspolrzednaPionowa, figura));
	}

	@Override
	public Kratka pobierzKratke(int x, int y) {
		int wspolrzednaPionowa = -1;
		int wspolrzednaPozioma = -1;
		if (x<200) {
			wspolrzednaPozioma=0;
		}
		if (x>200 && x<400) {
			wspolrzednaPozioma=1;
		}
		if (x>400) {
			wspolrzednaPozioma=2;
		}
			
			if (y<200) {
				wspolrzednaPionowa=0;
			}
			if (y>200 && y<400) {
				wspolrzednaPionowa=1;
			}
			if (y>400) {
				wspolrzednaPionowa=2;
		}
		for (Iterator iterator = listaKratek.iterator(); iterator.hasNext();) {
			Kratka kratka = (Kratka) iterator.next();
			if (kratka.x == wspolrzednaPozioma && kratka.y == wspolrzednaPionowa) {
				return kratka;
			}
	}
		return null;
	}

}
