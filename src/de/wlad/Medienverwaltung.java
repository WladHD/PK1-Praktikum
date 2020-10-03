package de.wlad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Medienverwaltung {
	private List<Medium> medien = new ArrayList<>();

	public void aufnehmen(Medium m) {
		medien.add(m);
	}

	public void zeigeMedien() {
		Collections.sort(medien);
		
		for (Medium m : medien)
			m.druckeDaten();
	}

	public Medium sucheNeuesMedium() {
		if(medien.size() == 0) return null;
		return medien.stream().min((a, b) -> a.alter() - b.alter()).get();
	}

	public double berechneErscheinungsjahr() {
		final double size = medien.size();
		if (size == 0d)
			return 0d;
		return medien.stream().map(m -> m.alter() / size).reduce(0d, (a, b) -> a + b);
	}

}
