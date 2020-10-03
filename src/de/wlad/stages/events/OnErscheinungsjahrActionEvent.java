package de.wlad.stages.events;

import java.util.Formatter;

import javax.swing.JOptionPane;

import de.wlad.Medienverwaltung;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OnErscheinungsjahrActionEvent implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
		try (Formatter f = new Formatter()) {
			f.format("Durchschnittliches Erscheinungsjahr: %.1f",
					Medienverwaltung.getInstance().berechneErscheinungsjahr());
			JOptionPane.showMessageDialog(null, f.toString());
		} catch (Exception e) {
		}
	}

}
