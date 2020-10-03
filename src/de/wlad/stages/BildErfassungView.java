package de.wlad.stages;

import de.wlad.Bild;
import de.wlad.Medienverwaltung;
import de.wlad.stages.utils.EventHandlerHelper;
import de.wlad.stages.utils.InputNode;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BildErfassungView extends Stage implements EventHandlerHelper {

	private Object[] temp = { "Titel", "Jahr", "Ort" };
	private Stage stage;
	private Bild bild;
	private BorderPane inputNode;

	public BildErfassungView(Bild bild, Stage stage) {
		this.bild = bild;
		this.stage = stage;
		this.initOwner(stage);
		this.initModality(Modality.WINDOW_MODAL);
	}

	public void showView() {
		inputNode = InputNode.generateInputNode(temp, new Object[] { bild.getTitel(), bild.getJahr(), bild.getOrt() });
		registerEvents();
		Scene s = new Scene(inputNode);
		stage.setScene(s);
	}
	
	@Override
	public Stage getStage() {
		return stage;
	}

	@Override
	public void onInputSuccessfull() {
		bild.setTitel((String) temp[0]);
		bild.setJahr((int) temp[1]);
		bild.setOrt((String) temp[2]);
		Medienverwaltung.getInstance().aufnehmen(bild);
	}

	@Override
	public int[] getIndexes() {
		return new int[] { 1 };
	}

	@Override
	public BorderPane getBorderPane() {
		return inputNode;
	}

	@Override
	public Object[] getTemp() {
		return temp;
	}

}
