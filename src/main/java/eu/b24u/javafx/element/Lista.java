package eu.b24u.javafx.element;

import java.util.ArrayList;

public class Lista<E> extends ArrayList<E> {

	public void dodaj(E element) {
		add(element);
	}

	public void iteruj(IteracjaPetli<E> petla) {
		for (E element : this) {
			petla.iteracja(element);
		}
	}
}
