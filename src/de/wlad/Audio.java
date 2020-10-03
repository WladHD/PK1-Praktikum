package de.wlad;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Formatter;
import java.util.Objects;

public class Audio extends Medium {
	private static final long serialVersionUID = 3349503765447936726L;
	private String interpret;
	private int dauer;

	public Audio(String titel, int jahr, String interpret, int dauer) {
		super(titel, jahr);
		this.interpret = interpret;
		this.dauer = dauer;
	}
	
	public Audio() {
	}

	public String getInterpret() {
		return interpret;
	}
	
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	public int getDauer() {
		return dauer;
	}
	
	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	@Override
	public void druckeDaten(OutputStream os) {
		new PrintStream(os).print(toString());
	}

	@Override
	public String toString() {
		Formatter f = new Formatter();
		f.format("ID = %d \"%s\" von %s aus %d Spieldauer: %d sek.%n", getId(), getTitel(), getInterpret(), getJahr(),
				getDauer());
		String s = f.toString();
		f.close();
		return s;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + 7 * Objects.hashCode(interpret) + 11 * Integer.hashCode(dauer);
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
}
