package de.wlad;

import java.util.Objects;

public class Bild extends Medium {
	private String ort;

	public Bild(String titel, int jahr, String ort) {
		super(titel, jahr);
		this.ort = ort;
	}
	
	public String getOrt() {
		return ort;
	}
	
	@Override
	public void druckeDaten() {
		System.out.printf("ID = %d \"%s\" aufgenommen im Jahr %d in %s%n", getId(), getTitel(), getJahr(), getOrt());
	}
	
	@Override
	public int hashCode() {
		return super.hashCode() + 7 * Objects.hashCode(ort);
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
}
