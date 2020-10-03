package de.wlad.stages.events;

import de.wlad.Bild;
import de.wlad.stages.BildErfassungView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class OnBildNeuActionEvent implements EventHandler<ActionEvent>{
	
	private Bild b;
	private Stage s;
	
	public OnBildNeuActionEvent(Bild b, Stage s) {
		this.b = b;
		this.s = s;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		new BildErfassungView(b, s).showView();
	}

}
