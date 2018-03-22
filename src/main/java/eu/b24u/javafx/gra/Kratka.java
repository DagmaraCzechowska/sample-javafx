package eu.b24u.javafx.gra;

public class Kratka {
	double x;
	double y;
	Figura figura;

	enum Figura {
		KOLKO, KRZYZYK
	}

	public Kratka(double x, double y, Figura figura) {
		this.x = x;
		this.y = y;
		this.figura = figura;
	}

	@Override
	public String toString() {
		return "Kratka [x=" + x + ", y=" + y + ", figura=" + figura + "]";
	};

}
