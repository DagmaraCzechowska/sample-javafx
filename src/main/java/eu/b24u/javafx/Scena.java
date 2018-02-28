package eu.b24u.javafx;

import javafx.stage.Stage;

public class Scena {

	private Stage stage;

	public Scena(javafx.stage.Stage stage) {
		this.stage = stage;
	}

	public void ustawTytul(String tytul) {
		stage.setTitle(tytul);
	}

	public void ustawRozmiar(double wysokosc, double szerokosc) {
		stage.setHeight(wysokosc);
		stage.setWidth(szerokosc);
	}

	public Stage get() {
		return stage;
	}

}
