package de.wlad.stages;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainView extends Stage {
	
	private Stage stage;
	
	public MainView(Stage stage) {
		this.stage = stage;
		this.initOwner(stage);
		this.initModality(Modality.WINDOW_MODAL);
	}
	
	public void showView() {
		Scene s = new Scene(new Label("Heyo"));
		stage.setScene(s);
	}
}
