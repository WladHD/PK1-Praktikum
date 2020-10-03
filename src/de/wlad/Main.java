package de.wlad;

public class Main {

	public static void main(String[] args) {
		Medium[] list = { new Audio("It Means Nothing", 2007, "Stereophonics", 229),
				new Bild("Gebaeude FB Informatik", 2019, "Dortmund"),
				new Bild("Gebaeude FB Informatik", 2019, "Dortmund"),
				new Audio("Cry Me A River", 2019, "Dortmund", 123) };

		for (Medium m : list)
			m.druckeDaten();

		System.out.printf("\"%s\" ist %d Jahre alt%n", list[0].getTitel(), list[0].alter());
		
		p1aufgabe3(list[0], list[3]);
		p1aufgabe3(list[1], list[2]);
	}

	public static void p1aufgabe3(Medium a, Medium b) {
		if (a.equals(b)) {
			System.out.printf("Die Objekte mit Id %d und Id %d sind (fachlich) gleich%n"
					+ "Die gleichen Objekte haben den Hashcode %d%n", a.getId(), b.getId(), a.hashCode());
		} else {
			System.out.printf(
					"Die Objekte mit Id %d und Id %d sind nicht gleich%n"
							+ "Die unterschiedlichen Objekte haben die Hashcodes %d und %d%n",
					a.getId(), b.getId(), a.hashCode(), b.hashCode());
		}
	}

}
