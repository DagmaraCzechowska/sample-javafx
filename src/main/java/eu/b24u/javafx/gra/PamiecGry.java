package eu.b24u.javafx.gra;

import java.util.Iterator;

import eu.b24u.javafx.Program;
import eu.b24u.javafx.element.Lista;
import eu.b24u.javafx.gra.Kratka.Figura;

public class PamiecGry implements InterfejsPamiecGry {

	Lista<Kratka> listaKratek;
	int iloscWygranych;
	int iloscPrzegranych;

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
		zainicjujZmienne();
	}

	/**
	 * TODO metoda zwieksza ilosc wygranych
	 */
	public void dodajWygrana() {

	}

	/**
	 * TODO metoda zwieksza ilosc przegranych
	 */
	public void dodajPrzegrana() {

	}

	private void zainicjujZmienne() {
		iloscWygranych = 0;
		iloscPrzegranych = 0;
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

	/**
	 * TODO czy koniec gry <br>
	 * Metoda sprawdza czy jest juz koniec gry <br>
	 * ktos juz wygral lub nie ma juz wolnych kratek
	 * 
	 * @return
	 */
	public boolean czyKoniecGry() {
		return czyWygrana();
	}

	@Override
	public boolean czyWygrana() {
		// Program.wypisz("Lista kratek: " + listaKratek.size());
		if (listaKratek.size() < 5) {
			return false;
		} else {
			for (Kratka kratkaZListy : listaKratek) {
				// Program.wypisz(kratkaZListy);
				// po ukosie
				Lista<Kratka> kratkiPoUkosieMalejaco0 = pobierzKratkiPoUkosieMalejaco();
				if (kratkiPoUkosieMalejaco0.size() == 3) {
					Kratka kratkaPoUkosieMalejaco0 = kratkiPoUkosieMalejaco0.get(0);
					Kratka kratkaPoUkosieMalejaco1 = kratkiPoUkosieMalejaco0.get(1);
					Kratka kratkaPoUkosieMalejaco2 = kratkiPoUkosieMalejaco0.get(2);
					if (kratkaPoUkosieMalejaco0.figura == kratkaPoUkosieMalejaco1.figura
							&& kratkaPoUkosieMalejaco0.figura == kratkaPoUkosieMalejaco2.figura) {
						Program.wypisz("wygrana po ukosie");
						return true;
					}
				}
				Lista<Kratka> kratkiPoUkosieRosnoco0 = pobierzKratkiPoUkosieRosnoco();

				// w pionie
				// Program.wypisz("kratkiKolumna0:" + kratkiKolumna0.size());

				for (int i = 0; i < 3; i++) {
					Lista<Kratka> listaKratekWKolumnie_i = pobierzKratkiWKolumnie(i);
					if (listaKratekWKolumnie_i.size() == 3) {
						Kratka kratka0 = listaKratekWKolumnie_i.get(0);
						Kratka kratka1 = listaKratekWKolumnie_i.get(1);
						Kratka kratka2 = listaKratekWKolumnie_i.get(2);
						if (kratka0.figura == kratka1.figura && kratka0.figura == kratka2.figura) {
							Program.wypisz("wygrana w " + i + " kolumnie");
							return true;
						}

					}
				}

				// w poziomie
				for (int i = 0; i < 3; i++) {
					Lista<Kratka> listaKratekWWierszu_i = pobierzKratkiWWierszu(i);
					if (listaKratekWWierszu_i.size() == 3) {

						Kratka kratka0 = listaKratekWWierszu_i.get(0);
						Kratka kratka1 = listaKratekWWierszu_i.get(1);
						Kratka kratka2 = listaKratekWWierszu_i.get(2);
						if (kratka0.figura == kratka1.figura && kratka0.figura == kratka2.figura) {
							Program.wypisz("wygrana w " + i + " wierszu");
							return true;
						}
					}
				}
				//
			}
			return false;
		}

	}

	private Lista<Kratka> pobierzKratkiPoUkosieRosnoco() {
		// TODO Pobierz kratki po ukosie rosnoco
		return null;
	}

	private Lista pobierzKratkiWWierszu(int numerWiersza) {
		Lista listaZwracana = new Lista();
		for (Kratka kratkaZListy : listaKratek) {
			if (kratkaZListy.y == numerWiersza) {
				listaZwracana.dodaj(kratkaZListy);
			}
		}
		return listaZwracana;
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
	private Lista pobierzKratkiPoUkosieMalejaco() {
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
		for (Iterator iterator = listaKratek.iterator(); iterator.hasNext();) {
			Kratka kratka = (Kratka) iterator.next();
			if (kratka.x == wspolrzednaPozioma && kratka.y == wspolrzednaPionowa) {
				return kratka;
			}
		}
		return null;
	}

	/**
	 * TODO metoda czysci kratki w pamieci gry
	 */
	public void wyczyscKratki() {
	}

	/**
	 * TODO metoda pobiera ilosc przegranych
	 * 
	 * @return
	 */
	public String pobierzPrzegrane() {
		return "0";
	}

	/**
	 * TODO metoda pobiera ilosc wygranych
	 * 
	 * @return
	 */
	public String pobierzWygrane() {
		return "0";
	}

}
