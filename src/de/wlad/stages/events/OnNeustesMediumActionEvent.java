package de.wlad.stages.events;

import javax.swing.JOptionPane;

import de.wlad.Medienverwaltung;
import de.wlad.Medium;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OnNeustesMediumActionEvent implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent arg0) {
		Medium m = Medienverwaltung.getInstance().sucheNeuesMedium();
		JOptionPane.showMessageDialog(null, (m == null ? "Keine Medien vorhanden." : m.toString()));
	}

}
