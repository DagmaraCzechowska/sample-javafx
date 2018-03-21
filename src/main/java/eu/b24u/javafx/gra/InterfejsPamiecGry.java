package eu.b24u.javafx.gra;

import eu.b24u.javafx.element.Punkt;

public interface InterfejsPamiecGry {

	/**
	 * Metoda tworzy pusta liste kratek
	 */
	public void utworzListeKratek();

	/**
	 * Metoda sprawdza czy kratka jest pusta
	 * 
	 * @return prawda lub falsz
	 */
	public boolean czyKratkaJestPusta();

	/**
	 * Metoda sprawdza czy jest juz wygrana
	 * 
	 * @return prawda lub falsz
	 */
	public boolean czyWygrana();

	/**
	 * Metoda dodaj kliknieta kratke do pamieci gry do listy kratek
	 */
	public void dodajKliknietaKratke(double x, double y);

	/**
	 * Metoda zwraca wspolrzedne na kratce czyli x i y od 0 do 2
	 * 
	 * @param x
	 *            wspolrzedna pozioma
	 * @param y
	 *            wspolrzedna pionowa
	 * @return Punkt klikniety na kratce do gry
	 */
	public Punkt kliknietaKratka(double x, double y);
}
