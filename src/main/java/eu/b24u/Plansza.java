package eu.b24u;

import eu.b24u.javafx.Plotno;
import javafx.scene.paint.Color;

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
