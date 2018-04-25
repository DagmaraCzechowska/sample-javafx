package eu.b24u.javafx;

import java.util.concurrent.ThreadLocalRandom;

public class Program {

	public Program() {
	}

	public static void wypisz(Object object) {
		System.out.println(object.toString());
	}

	public static int losujLiczbe(int minimum, int maksimum) {
		return ThreadLocalRandom.current().nextInt(minimum, maksimum + 1);
	}

}
