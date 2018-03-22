package eu.b24u.javafx.gra;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Sprawdz {

	public static void czyPrawda(boolean warunek) {
		assertTrue(warunek);
	}

	public static void czyFalsz(boolean warunek) {
		assertFalse(warunek);
	}
}
