package de.wlad.stages.events;

import de.wlad.Audio;
import de.wlad.stages.AudioErfassungView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class OnAudioNeuActionEvent implements EventHandler<ActionEvent>{
	
	private Audio a;
	private Stage s;
	
	public OnAudioNeuActionEvent(Audio a, Stage s) {
		this.a = a;
		this.s = s;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		new AudioErfassungView(a, s).showView();
	}

}
