package de.wlad;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {

	private String[] options = { "Audio aufnehmen", "Bild aufnehmen", "Zeige alle Medien", "Zeige neues Medium",
			"Berechne durchschnittliches Erscheinungsjahr", "Beenden" };
	private Scanner sc = new Scanner(System.in);
	private Medienverwaltung mv = new Medienverwaltung();

	public void printMenu() {
		System.out.println("Medienverwaltung\n");

		for (int i = 0; i < options.length; i++)
			System.out.printf("%d. %s%n", i + 1, options[i]);

		System.out.print("\nBitte Menuepunkt waehlen: ");
	}

	public void startListening() {
		printMenu();
		int parsed = 0;

		try {
			parsed = Integer.parseInt(sc.next());
		} catch (Exception e) {
			System.out.println("Ungültige Eingabe.");
			startListening();
			return;
		}

		switch (parsed) {
		case 1:
			aufnehmenAudio();
			break;
		case 2:
			aufnehmenBild();
			break;
		case 3:
			mv.zeigeMedien();
			break;
		case 4:
			System.out.print("Neustes Medium: ");
			Medium m = mv.sucheNeuesMedium();
			if (m == null) {
				System.out.println("-");
				break;
			}
			m.druckeDaten();
			break;
		case 5:
			System.out.printf("Durchschnittliches Alter: %.1f%nNeustes Medium: ", mv.berechneErscheinungsjahr());
			break;
		case 6:
			return;
		default:
			System.out.println("Ungültige Eingabe.");
			break;
		}

		startListening();
	}

	public void aufnehmenAudio() {
		Object[] temp = { "Titel", "Jahr", "Interpreten", "Dauer" };
		aufnehmen(temp, 1, 3);
		mv.aufnehmen(new Audio(temp[0].toString(), (int) temp[1], temp[2].toString(), (int) temp[3]));
	}
	
	public void aufnehmenBild() {
		Object[] temp = { "Titel", "Jahr", "Ort" };
		aufnehmen(temp, 1);
		mv.aufnehmen(new Bild(temp[0].toString(), (int) temp[1], temp[2].toString()));
	}
	
	public void aufnehmen(Object[] temp, int... indexes) {
		for (int i = 0; i < temp.length; i++)
			temp[i] = JOptionPane.showInputDialog(null, temp[i] + " eingeben.");

		parseIntegerInArray(temp, indexes);
	}

	public void parseIntegerInArray(Object[] arr, int... indexes) {
		for (int i : indexes)
			arr[i] = Integer.parseInt(arr[i].toString());
	}

}
