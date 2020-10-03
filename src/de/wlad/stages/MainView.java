package de.wlad.stages;

import de.wlad.Audio;
import de.wlad.Bild;
import de.wlad.stages.events.OnAudioNeuActionEvent;
import de.wlad.stages.events.OnBeendenActionEvent;
import de.wlad.stages.events.OnBildNeuActionEvent;
import de.wlad.stages.events.OnErscheinungsjahrActionEvent;
import de.wlad.stages.events.OnLadenActionEvent;
import de.wlad.stages.events.OnMedienInDateiActionEvent;
import de.wlad.stages.events.OnNeustesMediumActionEvent;
import de.wlad.stages.events.OnSpeichernActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainView extends Stage {
	
	private Stage stage;
	private static ObservableList<String> contentList = FXCollections.observableArrayList();
	
	public static ObservableList<String> getContentList() {
		return contentList;
	}
	
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
		
		laden.setOnAction(new OnLadenActionEvent());
		speichern.setOnAction(new OnSpeichernActionEvent());
		medienListeInDatei.setOnAction(new OnMedienInDateiActionEvent());
		beenden.setOnAction(new OnBeendenActionEvent());
		
		audioNeu.setOnAction(new OnAudioNeuActionEvent(new Audio(), stage));
		bildNeu.setOnAction(new OnBildNeuActionEvent(new Bild(), stage));
		
		erscheinungsjahr.setOnAction(new OnErscheinungsjahrActionEvent());
		neustesMedium.setOnAction(new OnNeustesMediumActionEvent());
		
		ListView<String> lv = new ListView<>(getContentList());
		bp.setCenter(lv);
		
		Scene s = new Scene(bp, 400, 300);
		stage.setScene(s);
	}
}
