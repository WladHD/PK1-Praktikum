package de.wlad;

import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Medium implements Comparable<Medium>, Serializable {
	private static final long serialVersionUID = -5733835028084439147L;
	private static int globalId = 0;
	private int id;
	private String titel;
	private int jahr;
	
	public Medium(String titel, int jahr) {
		this.titel = titel;
		this.jahr = jahr;
		id = globalId++;
	}
	
	public int alter() {
		return LocalDate.now().getYear() - jahr;
	}
	
	public abstract void druckeDaten(OutputStream os);
	
	public int getId() {
		return id;
	}
	
	public String getTitel() {
		return titel;
	}
	
	public int getJahr() {
		return jahr;
	}
	
	@Override
	public int hashCode() {
		return 3 * Objects.hashCode(getTitel()) + 5 * Integer.hashCode(jahr);
	}
	
	@Override
	public boolean equals(Object o) {
		return hashCode() == o.hashCode();
	}
	
	@Override
	public int compareTo(Medium m) {
		return getJahr() - m.getJahr();
	}
}
