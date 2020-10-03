package de.wlad.stages.utils;

import de.wlad.stages.MainView;
import de.wlad.stages.events.InputCompletedEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public interface EventHandlerHelper {

	default void registerEvents() {
		((HBox) getBorderPane().getBottom()).getChildren().stream()
				.forEach(n -> ((Button) n).setOnAction(new InputCompletedEvent(this)));
	}

	default void goToMainView() {
		new MainView(getStage()).showView();
	}
	
	Stage getStage();

	void onInputSuccessfull();

	BorderPane getBorderPane();

	Object[] getTemp();

	int[] getIndexes();

}
