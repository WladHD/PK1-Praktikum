package de.wlad.stages.events;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OnBeendenActionEvent implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent arg0) {
		System.exit(0);
	}

}
