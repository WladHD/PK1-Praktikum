package de.wlad.stages.events;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import de.wlad.Medienverwaltung;
import de.wlad.exceptions.EmptyFilenameException;
import de.wlad.exceptions.InputAbortException;
import de.wlad.stages.utils.FileHelper;
import de.wlad.stages.utils.OutputHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OnMedienInDateiActionEvent implements EventHandler<ActionEvent>, FileHelper {

	@Override
	public void handle(ActionEvent arg0) {
		File f = null;
		try {
			f = new File(parsePath());
		} catch (InputAbortException e) {
			return;
		} catch (EmptyFilenameException e) {
			if (JOptionPane.showConfirmDialog(null, "Der Dateiname darf nicht leer sein. Wiederholen?") == 0)
				handle(arg0);
			return;
		}

		if (!f.isFile()) {
			handle(arg0);
			return;
		}

		try (FileOutputStream fos = new FileOutputStream(f)) {
			Medienverwaltung.getInstance().zeigeMedien(fos);
			OutputHelper.showSuccess();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
