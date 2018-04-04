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
		// TODO czyKratkaJestPusta
		for (Iterator iterator = listaKratek.iterator(); iterator.hasNext();) {
			Kratka kratka = (Kratka) iterator.next();
			if (kratka.x == x && kratka.y == y) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean czyWygrana() {
		if (listaKratek.size() < 5) {
			return false;
		} else {
			for (Kratka kratkaZListy : listaKratek) {
				Program.wypisz(kratkaZListy);
				// po ukosie
				Lista kratkiWiersz0 = pobierzKratkiPoUkosieRosnaco();

				// w pionie
				Lista kratkiWiersz1 = pobierzKratkiWKolumnie(0);

				// w poziomie
				Lista kratkiWiersz2 = pobierzKratkiWWierszu(0);

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
		listaKratek.add(new Kratka(x, y, figura));
	}

	@Override
	public Kratka pobierzKratke(int x, int y) {
		// TODO pobierzKratke
		return new Kratka(0, 0, Figura.KOLKO);
	}

}
