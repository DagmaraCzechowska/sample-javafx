package eu.b24u.javafx.gra;

import eu.b24u.javafx.element.Lista;
import eu.b24u.javafx.element.Punkt;

public class PamiecGry implements InterfejsPamiecGry {

	Lista listaKratek;
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

	}

	@Override
	public boolean czyKratkaJestPusta() {
		// TODO czyKratkaJestPusta
		return false;
	}

	@Override
	public boolean czyWygrana() {
		// TODO czyWygrana
		return false;
	}

	@Override
	public void dodajKliknietaKratke(double x, double y) {
		// TODO dodajKliknietaKratke

	}

	@Override
	public Punkt kliknietaKratka(double x, double y) {
		// TODO kliknietaKratka
		return null;
	}

}
