package de.wlad;

@Deprecated
public class Menu {
/*	private Scanner sc = new Scanner(System.in);
	private Medienverwaltung mv = Medienverwaltung.getInstance();
	private static int menuOptionIndexCounter = 1;

	public enum MenuOption {
		AUDIO_AUFNEHMEN("Audio aufnehmen"), BILD_AUFNEHMEN("Bild aufnehmen"),
		ALLE_MEDIEN_IN_KONSOLE("Zeige alle Medien"), ALLE_MEDIEN_IN_DATEI("Medienliste in Datei schreiben"),
		ZEIGE_NEUES_MEDIUM("Zeige neues Medium"),
		ZEIGE_DURCHSCHNITTLICHES_ERSCHEINUNGSJAHR("Berechne durchschnittliches Erscheinungsjahr"),
		SPEICHERN("Speichern"), LADEN("Laden"), BEENDEN("Beenden");

		private final int i;
		private final String msg;

		MenuOption(String msg) {
			this.i = Menu.menuOptionIndexCounter++;
			this.msg = msg;
		}

		public final int getId() {
			return i;
		}

		public final String getMessage() {
			return msg;
		}

		public static MenuOption[] getOptions() {
			return values();
		}

		public static MenuOption parseById(int id) {
			for (MenuOption m : getOptions())
				if (m.getId() == id)
					return m;

			return null;
		}
	}

	public void printMenu() {
		System.out.println("Medienverwaltung\n");

		MenuOption[] options = MenuOption.getOptions();

		for (int i = 0; i < options.length; i++)
			System.out.printf("%d. %s%n", options[i].getId(), options[i].getMessage());

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

		MenuOption mo = MenuOption.parseById(parsed);

		try {
			switch (mo) {
			case AUDIO_AUFNEHMEN:
				aufnehmenAudio();
				break;
			case BILD_AUFNEHMEN:
				aufnehmenBild();
				break;
			case ALLE_MEDIEN_IN_KONSOLE:
				mv.zeigeMedien(System.out);
				break;
			case ALLE_MEDIEN_IN_DATEI:
				druckeDatenInDatei();
				break;
			case ZEIGE_NEUES_MEDIUM:
				System.out.print("Neustes Medium: ");
				Medium m = mv.sucheNeuesMedium();
				if (m == null) {
					System.out.println("-");
					break;
				}
				m.druckeDaten(System.out);
				break;
			case ZEIGE_DURCHSCHNITTLICHES_ERSCHEINUNGSJAHR:
				System.out.printf("Durchschnittliches Alter: %.1f%nNeustes Medium: ", mv.berechneErscheinungsjahr());
				break;
			case BEENDEN:
				return;
			case SPEICHERN:
				listeSpeichern();
				break;
			case LADEN:
				listeLaden();
				break;
			default:
				System.out.println("Ungültige Eingabe.");
				break;
			}
		} catch (InputAbortException e) {
			System.out.println("Aufnahme abgebrochen.");
		} catch (EmptyFilenameException e) {
			if (JOptionPane.showConfirmDialog(null, "Der Dateiname darf nicht leer sein. Wiederholen?") == 0)
				//startListening(e.getMenuOption().getId());
		}

		startListening();
	}

	public void listeSpeichern() throws InputAbortException, EmptyFilenameException {
		FileManager.serialize(new File(parsePath(MenuOption.SPEICHERN)), mv.getMediumList());
	}

	public void listeLaden() throws InputAbortException, EmptyFilenameException {
		mv.setMediumList(FileManager.deserialize(new File(parsePath(MenuOption.LADEN))));
	}

	public void druckeDatenInDatei() throws InputAbortException, EmptyFilenameException {
		File f = new File(parsePath(MenuOption.ALLE_MEDIEN_IN_DATEI));

		if (!f.isFile()) {
			druckeDatenInDatei();
			return;
		}

		try (FileOutputStream fos = new FileOutputStream(f)) {
			mv.zeigeMedien(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String parsePath(MenuOption mo) throws InputAbortException, EmptyFilenameException {
		String s = JOptionPane.showInputDialog("Dateipfad eingeben.");

		if (s == null)
			throw new InputAbortException();

		if (s.replaceAll(" ", "").length() == 0)
			throw new EmptyFilenameException(mo);

		return s;
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
	}*/

}
