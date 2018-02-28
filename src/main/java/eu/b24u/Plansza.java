package eu.b24u;

import eu.b24u.javafx.Plotno;
import javafx.scene.paint.Color;

/**
 * Podzial na grupy<br>
 * <br>
 * Zadania:<br>
 * 1. Rysowanie kratki<br>
 * 2. Rysowanie krzyzyka<br>
 * 3. Rysowanie kolka<br>
 * 4. Rysowanie na kratce krzyzyka<br>
 * 5. Rysowanie na kratce kolka<br>
 * <br>
 * <br>
 * <br>
 * 
 * @author Jakub
 *
 */
public class Plansza {

	private Plotno plotno;

	public Plansza(Plotno plotno) {
		this.plotno = plotno;
		buduj();
	}

	private void buduj() {
		rysujKratke();
		rysujKolko(100, 100);
		rysujKrzyzyk(300, 300);
	}

	public void rysujKolko(int x, int y) {
		plotno.rysujOkrag(x, y, 50, Color.YELLOW);

	}

	public void rysujKrzyzyk(int x, int y) {
		plotno.rysujLinie(x - 50, y - 50, x + 50, y + 50);
		plotno.rysujOkrag(x - 50, y - 50, 10, Color.ORANGE);
		plotno.rysujOkrag(x + 50, y + 50, 10, Color.ORANGE);

	}

	public void rysujKratke() {
		plotno.rysujOkrag(0, 200, 10, Color.RED);
		plotno.rysujOkrag(600, 200, 10, Color.RED);

		plotno.rysujOkrag(200, 0, 10, Color.RED);
		plotno.rysujOkrag(400, 0, 10, Color.RED);

		plotno.rysujOkrag(0, 400, 10, Color.RED);
		plotno.rysujOkrag(600, 400, 10, Color.RED);

		plotno.rysujOkrag(200, 600, 10, Color.RED);
		plotno.rysujOkrag(400, 600, 10, Color.RED);
	}
}
