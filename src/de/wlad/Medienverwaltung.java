package de.wlad;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Medienverwaltung {
	private List<Medium> medien = new ArrayList<>();

	public void aufnehmen(Medium m) {
		medien.add(m);
		System.out.println("Medium aufgenommen: " + medien.size());
	}

	public void zeigeMedien(OutputStream os) {
		Collections.sort(medien);

		for (Medium m : medien)
			m.druckeDaten(os);
	}

	public List<Medium> getMediumList() {
		return medien;
	}

	public void setMediumList(List<Medium> list) {
		if (list != null)
			medien = list;
	}

	public Medium sucheNeuesMedium() {
		if (medien.size() == 0)
			return null;
		return medien.stream().min((a, b) -> a.alter() - b.alter()).get();
	}

	public double berechneErscheinungsjahr() {
		final double size = medien.size();
		if (size == 0d)
			return 0d;
		return medien.stream().map(m -> m.alter() / size).reduce(0d, (a, b) -> a + b);
	}

}
