package eu.b24u;

import eu.b24u.javafx.Aplikacja;
import eu.b24u.javafx.Plotno;
import eu.b24u.javafx.Program;
import eu.b24u.javafx.Scena;
import eu.b24u.javafx.element.Punkt;
import javafx.scene.paint.Color;

public class MojaAplikacja extends Aplikacja {

	Plansza plansza;
	boolean czyKolko;


	@Override
	public void zdarzenieKlikniecaMyszka(double x, double y, Plotno plotno) {
		Program.wypisz("x=" + x + " y=" + y);
		// plotno.czysc();
		if (czyKolko) {
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

		plotno.rysujProstokat(new Punkt(10, 10), new Punkt(400, 400), Color.BLACK);
	}

	@Override
	public void zdarzeniePrzeciagniecieMyszka(double x, double y, Plotno plotno) {
		// TODO Auto-generated method stub
		plotno.rysujPunkt(x, y);
	}

}
