package eu.b24u.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
 
public abstract class Aplikacja extends Application {
 
	private Plotno plotno;

	@Override
    public void start(Stage primaryStage) {
		plotno = new Plotno();
		Scena scena = new Scena(primaryStage);
		Image image = new Image(getClass().getResourceAsStream("/icon.png"));

		scena.get().getIcons().add(image);
		budujScene(scena, plotno);
        Group root = new Group();
		plotno.setOnMouseClicked(event -> {
			zdarzenieKlikniecaMyszka(event.getX(), event.getY(), plotno);
		});
		plotno.setOnMouseDragged(event -> {
			zdarzeniePrzeciagniecieMyszka(event.getX(), event.getY(), plotno);
		});

		root.getChildren().add(plotno);
		scena.get().setScene(new Scene(root));
		scena.get().show();
    }

	public abstract void budujScene(Scena scena, Plotno plotno);

	public abstract void zdarzenieKlikniecaMyszka(double x, double y, Plotno plotno);

	public abstract void zdarzeniePrzeciagniecieMyszka(double x, double y, Plotno plotno);

	public Plotno pobierzPlotno() {
		return plotno;
	}


}


