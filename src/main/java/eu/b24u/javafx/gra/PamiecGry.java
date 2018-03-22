package eu.b24u.javafx.gra;

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
	public boolean czyKratkaJestPusta() {
		// TODO czyKratkaJestPusta
		return false;
	}

	@Override
	public boolean czyWygrana() {
		if (listaKratek.size() < 5) {
			return false;
		} else {
			for (Kratka kratkaZListy : listaKratek) {
			Program.wypisz(kratkaZListy);
				// po ukosie

				// w pionie

				// w poziomie
		}

		}
		// TODO czyWygrana

		return false;
	}


	@Override
	public Punkt kliknietaKratka(double x, double y) {
		// TODO kliknietaKratka
		return null;
	}

	@Override
	public void dodajKliknietaKratke(int x, int y, Figura figura) {
		// TODO Auto-generated method stub
		listaKratek.add(new Kratka(x, y, figura));
	}

	@Override
	public Kratka pobierzKratke(int x, int y) {
		// TODO pobierzKratke
		return new Kratka(0, 0, Figura.KOLKO);
	}

}
