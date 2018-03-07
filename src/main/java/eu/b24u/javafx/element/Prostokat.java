package eu.b24u.javafx.element;

import java.awt.Rectangle;

public class Prostokat extends Rectangle {

	private Punkt p1;
	private Punkt p2;

	public Prostokat(Punkt p1, Punkt p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
}
