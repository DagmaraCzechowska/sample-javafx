package eu.b24u.javafx.gra;

public class Kratka {
	double x;
	double y;
	Figura figura;

	public enum Figura {
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
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((figura == null) ? 0 : figura.hashCode());
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kratka other = (Kratka) obj;
		if (figura != other.figura)
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	};

}
