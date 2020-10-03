package de.wlad.stages.events;

import de.wlad.Medienverwaltung;
import de.wlad.database.FileManager;
import de.wlad.exceptions.PersistenzException;
import de.wlad.stages.utils.OutputHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OnSpeichernActionEvent implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		try {
			new FileManager().speichern(Medienverwaltung.getInstance().getMediumList());
			OutputHelper.showSuccess();
		} catch (PersistenzException e) {
			e.printStackTrace();
		}
	}

}
