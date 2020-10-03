package de.wlad;

import java.util.ArrayList;
import java.util.Collection;

public class Medienverwaltung {
	private Collection<Medium> medien = new ArrayList<>();

	public void aufnehmen(Medium m) {
		medien.add(m);
	}

	public void zeigeMedien() {
		for (Medium m : medien)
			m.druckeDaten();
	}

	public Medium sucheNeuesMedium() {
		return medien.stream().min((a, b) -> a.alter() - b.alter()).get();
	}

	public double berechneErscheinungsjahr() {
		final double size = medien.size();
		if (size == 0d)
			return 0d;
		return medien.stream().map(m -> m.alter() / size).reduce(0d, (a, b) -> a + b);
	}

}
