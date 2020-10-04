package de.wlad;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import de.wlad.stages.MainView;

public class Medienverwaltung {
	
	private static Medienverwaltung instance = new Medienverwaltung();
	
	public static Medienverwaltung getInstance() {
		return instance;
	}
	
	private Medienverwaltung() {
		
	}
	
	private List<Medium> medien = new ArrayList<>();

	public Iterator<Medium> iterator() {
		return medien.iterator();
	}

	public void updateList(Medium m) {
		if (m != null)
			MainView.getContentList().add(m.toString());
		else {
			MainView.getContentList().clear();
			medien.stream().map(medium -> medium.toString()).forEach(MainView.getContentList()::add);
		}
	}

	public void aufnehmen(Medium m) {
		medien.add(m);
		updateList(m);
	}

	public void zeigeMedien(OutputStream os) {
		Collections.sort(medien);
		medien.stream().forEach(m -> m.druckeDaten(os));
	}

	public List<Medium> getMediumList() {
		return medien;
	}

	public void setMediumList(List<Medium> list) {
		if (list == null)
			return;
		medien = list;
		updateList(null);

		// Nachträglich hinzugefügt, da bei Deserialisierung statische Variablen nicht
		// übernommen werden
		Medium.setGlobalId(list.size() == 0 ? 0 : list.stream().map(i -> i.getId()).max(Integer::compare).get() + 1);
	}

	public Medium sucheNeuesMedium() {
		if (medien.size() == 0)
			return null;
		return medien.stream().min((a, b) -> a.alter() - b.alter()).get();
	}

	public double berechneErscheinungsjahr() {
		final int size = medien.size();
		if (size == 0)
			return 0;
		return medien.stream().map(m -> (double) m.getJahr() / size).reduce(0d, (a, b) -> a + b);
	}

}
