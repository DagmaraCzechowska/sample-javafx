package eu.b24u.javafx.gra;

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

}
