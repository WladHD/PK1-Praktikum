package de.wlad.stages;

import de.wlad.Bild;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BildErfassungView extends Stage {
	
	private Stage stage;
	private Bild bild;
	
	public BildErfassungView(Bild bild, Stage stage) {
		this.bild = bild;
		this.stage = stage;
		this.initOwner(stage);
		this.initModality(Modality.WINDOW_MODAL);
	}
	
	public void showView() {
		this.show();
	}
	
}
