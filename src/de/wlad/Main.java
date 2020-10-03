package de.wlad;

public class Main {

	private static Medium[] list = { new Audio("It Means Nothing", 2007, "Stereophonics", 229),
			new Bild("Gebaeude FB Informatik", 2019, "Dortmund"), new Bild("Gebaeude FB Informatik", 2019, "Dortmund"),
			new Audio("Cry Me A River", 2018, "Dortmund", 123) };

	public static void main(String[] args) {
		new Main().new Praktikum2().p2aufgabe2();
	}

	public class Praktikum1 {
		public void p1aufgabe3() {
			for (Medium m : list)
				m.druckeDaten();

			System.out.printf("\"%s\" ist %d Jahre alt%n", list[0].getTitel(), list[0].alter());

			p1aufgabe3tester(list[0], list[3]);
			p1aufgabe3tester(list[1], list[2]);

		}

		public void p1aufgabe3tester(Medium a, Medium b) {
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

	public class Praktikum2 {
		Medienverwaltung mv = new Medienverwaltung();

		public void p2aufgabe2() {
			for (Medium m : list)
				mv.aufnehmen(m);

			mv.zeigeMedien();
			System.out.printf("Durchschnittliches Alter: %.1f%nNeustes Medium: ", mv.berechneErscheinungsjahr());
			Medium m = mv.sucheNeuesMedium();
			if (m != null)
				m.druckeDaten();
		}
	}
}
