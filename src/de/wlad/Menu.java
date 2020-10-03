package de.wlad;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {

	private String[] options = { "Audio aufnehmen", "Bild aufnehmen", "Zeige alle Medien",
			"Medienliste in Datei schreiben", "Zeige neues Medium", "Berechne durchschnittliches Erscheinungsjahr",
			"Beenden" };
	private Scanner sc = new Scanner(System.in);
	private Medienverwaltung mv = new Medienverwaltung();

	public void printMenu() {
		System.out.println("Medienverwaltung\n");

		for (int i = 0; i < options.length; i++)
			System.out.printf("%d. %s%n", i + 1, options[i]);

		System.out.print("\nBitte Menuepunkt waehlen: ");
	}

	public void startListening() {
		startListening(-1);
	}

	public void startListening(int preselect) {
		int parsed = preselect;

		if (parsed == -1) {
			printMenu();

			try {
				parsed = Integer.parseInt(sc.next());
			} catch (Exception e) {
				System.out.println("Ungültige Eingabe.");
				startListening();
				return;
			}
		}

		try {
			switch (parsed) {
			case 1:
				aufnehmenAudio();
				break;
			case 2:
				aufnehmenBild();
				break;
			case 3:
				mv.zeigeMedien(System.out);
				break;
			case 4:
				druckeDatenInDatei();
				break;
			case 5:
				System.out.print("Neustes Medium: ");
				Medium m = mv.sucheNeuesMedium();
				if (m == null) {
					System.out.println("-");
					break;
				}
				m.druckeDaten(System.out);
				break;
			case 6:
				System.out.printf("Durchschnittliches Alter: %.1f%nNeustes Medium: ", mv.berechneErscheinungsjahr());
				break;
			case 7:
				return;
			default:
				System.out.println("Ungültige Eingabe.");
				break;
			}
		} catch (InputAbortException e) {
			System.out.println("Aufnahme abgebrochen.");
		} catch (EmptyFilenameException e) {
			if (JOptionPane.showConfirmDialog(null, "Der Dateiname darf nicht leer sein. Wiederholen?") == 0)
				startListening(4);
		}

		startListening();
	}

	public void druckeDatenInDatei() throws InputAbortException, EmptyFilenameException {
		String s = JOptionPane.showInputDialog("Dateipfad eingeben.");

		if (s == null)
			throw new InputAbortException();

		if (s.replaceAll(" ", "").length() == 0)
			throw new EmptyFilenameException();

		File f = new File(s);

		if (!f.isFile()) {
			druckeDatenInDatei();
			return;
		}

		try (FileOutputStream fos = new FileOutputStream(new File(s))) {
			mv.zeigeMedien(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void aufnehmenAudio() throws InputAbortException {
		Object[] temp = { "Titel", "Jahr", "Interpreten", "Dauer" };
		aufnehmen(temp, 1, 3);
		mv.aufnehmen(new Audio((String) temp[0], (int) temp[1], (String) temp[2], (int) temp[3]));
	}

	public void aufnehmenBild() throws InputAbortException {
		Object[] temp = { "Titel", "Jahr", "Ort" };
		aufnehmen(temp, 1);
		mv.aufnehmen(new Bild((String) temp[0], (int) temp[1], (String) temp[2]));
	}

	public void aufnehmen(Object[] temp, int... indexes) throws InputAbortException {
		for (int i = 0; i < temp.length; i++) {
			Object o = JOptionPane.showInputDialog(null, temp[i] + " eingeben.");

			if (o == null)
				throw new InputAbortException();

			if (contains(indexes, i)) {
				try {
					o = Integer.parseInt((String) o);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Bitte gültige Zahl für " + temp[i] + " eingeben.");
					i--;
					continue;
				}
			}

			temp[i] = o;
		}
	}

	public boolean contains(int[] arr, int needle) {
		for (int i : arr)
			if (needle == i)
				return true;

		return false;
	}

}
