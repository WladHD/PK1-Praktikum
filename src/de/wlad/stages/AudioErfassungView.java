package de.wlad.stages;

import de.wlad.Audio;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AudioErfassungView extends Stage {
	
	private Stage stage;
	private Audio audio;
	
	public AudioErfassungView(Audio audio, Stage stage) {
		this.audio = audio;
		this.stage = stage;
	}
	
	public void showView() {
		this.initOwner(stage);
		this.initModality(Modality.WINDOW_MODAL);
	}
	
}
