package de.wlad;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Formatter;
import java.util.Objects;

public class Bild extends Medium {
	private static final long serialVersionUID = 6911841357496061384L;
	private String ort;

	public Bild(String titel, int jahr, String ort) {
		super(titel, jahr);
		this.ort = ort;
	}
	
	public Bild() {
	}
	
	public String getOrt() {
		return ort;
	}
	
	public void setOrt(String ort) {
		this.ort = ort;
	}

	@Override
	public void druckeDaten(OutputStream os) {
		new PrintStream(os).print(toString());
	}

	@Override
	public String toString() {
		Formatter f = new Formatter();
		f.format("ID = %d \"%s\" aufgenommen im Jahr %d in %s%n", getId(), getTitel(), getJahr(), getOrt());
		String s = f.toString();
		f.close();
		return s;
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
