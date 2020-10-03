package de.wlad.stages;

import de.wlad.Audio;
import de.wlad.stages.utils.EventHandlerHelper;
import de.wlad.stages.utils.InputNode;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AudioErfassungView extends Stage implements EventHandlerHelper {

	private Stage stage;
	private Audio audio;
	private Object[] temp = { "Titel", "Jahr", "Interpreten", "Dauer" };
	private BorderPane inputNode;

	public AudioErfassungView(Audio audio, Stage stage) {
		this.audio = audio;
		this.stage = stage;
		this.initOwner(stage);
		this.initModality(Modality.WINDOW_MODAL);
	}

	public void showView() {
		inputNode = InputNode.generateInputNode(temp,
				new Object[] { audio.getTitel(), audio.getJahr(), audio.getInterpret(), audio.getDauer() });
		registerEvents();
		Scene s = new Scene(inputNode);
		stage.setScene(s);
	}

	@Override
	public void onInputSuccessfull() {
		audio.setTitel((String) temp[0]);
		audio.setJahr((int) temp[1]);
		audio.setInterpret((String) temp[2]);
		audio.setDauer((int) temp[3]);
	}

	@Override
	public BorderPane getBorderPane() {
		return inputNode;
	}

	@Override
	public Object[] getTemp() {
		return temp;
	}

	@Override
	public int[] getIndexes() {
		return new int[] { 1, 3 };
	}

	@Override
	public Stage getStage() {
		return stage;
	}

}
