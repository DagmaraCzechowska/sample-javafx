package eu.b24u.javafx;

import eu.b24u.javafx.element.Punkt;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Plotno extends Canvas {

	private GraphicsContext context;

	public Plotno() {
		super();
		context = getGraphicsContext2D();
	}

	public void czysc() {
		context.clearRect(0, 0, 500, 500);
	}

	public void rysujOkrag(int startx, int starty, int promien) {
		rysujOkrag(startx, starty, promien, Color.BLUE);
	}

	public void rysujOkrag(double x, double y, int promien, Color color) {
		context.setFill(color);
		context.setStroke(color);
		context.setLineWidth(5);
		context.fillOval(x, y, promien, promien);
	}

	public void rysujLinie(double d, double e, double f, double g) {
		context.setFill(Color.BLUE);
		context.setStroke(Color.BLUE);
		context.setLineWidth(5);
		context.strokeLine(d, e, f, g);

	}

	public void rysujProstokat(Punkt p1, Punkt p2, Color green) {
		context.setFill(green);
		context.setStroke(green);
		context.setLineWidth(5);
		context.strokeRect(p1.x, p1.y, p2.x, p2.y);
	}

	public void ustawRozmiar(double wysokosc, double szerokosc) {
		setHeight(wysokosc);
		setWidth(szerokosc);
	}

	public void rysujPunkt(double x, double y) {
		context.setFill(Color.BLACK);
		context.fillRect(x, y, 1, 1);
	}

}
