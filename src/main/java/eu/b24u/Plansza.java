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
		// TODO Auto-generated method stub
		plotno.rysujLinie(0, 0, 500, 500);
		plotno.rysujOkrag(50, 50, 50, Color.YELLOW);

	}


}
