package eu.b24u.javafx.gra;

import eu.b24u.javafx.gra.Kratka.Figura;

public interface InterfejsPamiecGry {

	/**
	 * Metoda tworzy pusta liste kratek
	 */
	public void utworzListeKratek();

	/**
	 * Metoda sprawdza czy kratka jest pusta ,czyli sprawdza czy jest na liście
	 * kratek
	 * 
	 * @param x
	 *            współrzędna pozioma od 0 do 2
	 * @param y
	 *            współrzędna pionowa od 0 do 2
	 * @return prawda lub fałsz
	 */
	boolean czyKratkaJestPusta(int x, int y);

	/**
	 * Metoda sprawdza czy jest juz wygrana ,czyli sprawdza na liście kratek czy
	 * krzyżyk lub kółko ma wypełnione trzy wartości po rząd w pionie, poziomie czy
	 * na ukos
	 * 
	 * @return prawda lub falsz
	 */
	public boolean czyWygrana();

	/**
	 * Metoda dodaj kliknieta kratke do pamieci gry do listy kratek
	 * 
	 */
	public void dodajKliknietaKratke(int i, int j, Figura kolko);
	/**
	 * Metoda zwraca wspolrzedne na kratce czyli x i y od 0 do 2
	 * 
	 * @param x
	 *            wspolrzedna pozioma
	 * @param y
	 *            wspolrzedna pionowa
	 * @return Punkt klikniety na kratce do gry
	 */
	public Kratka pobierzKratke(int x, int y);

}
