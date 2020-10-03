package de.wlad.stages;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
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
		BorderPane bp = new BorderPane();
		MenuBar mb = new MenuBar();
		Menu datei = new Menu("Datei");
		MenuItem laden = new MenuItem("Laden");
		MenuItem speichern = new MenuItem("Speichern");
		MenuItem medienListeInDatei = new MenuItem("Medienliste in Datei");
		MenuItem beenden = new MenuItem("Beenden");
		datei.getItems().addAll(laden, speichern, medienListeInDatei, beenden);

		Menu medium = new Menu("Medium");
		MenuItem audioNeu = new MenuItem("Audio neu");
		MenuItem bildNeu = new MenuItem("Bild neu");
		medium.getItems().addAll(audioNeu, bildNeu);
		
		Menu anzeige = new Menu("Anzeige");
		MenuItem erscheinungsjahr = new MenuItem("Erscheinungsjahr");
		MenuItem neustesMedium = new MenuItem("Neustes Medium");
		anzeige.getItems().addAll(erscheinungsjahr, neustesMedium);
		
		mb.getMenus().addAll(datei, medium, anzeige);
		bp.setTop(mb);
		
		Scene s = new Scene(bp, 400, 300);
		stage.setScene(s);
	}
}
