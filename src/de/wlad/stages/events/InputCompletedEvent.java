package de.wlad.stages.events;

import de.wlad.Menu;
import de.wlad.stages.utils.EventHandlerHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputCompletedEvent implements EventHandler<ActionEvent> {

	private EventHandlerHelper helper;

	public InputCompletedEvent(EventHandlerHelper helper) {
		this.helper = helper;
	}

	@Override
	public void handle(ActionEvent e) {
		if (!(e.getSource() instanceof Button))
			return;

		Button btn = (Button) e.getSource();
		Object[] temp = helper.getTemp();
		
		switch (btn.getText()) {
		case "Neu":
			int i = 0;
			for (Node n : ((GridPane) helper.getBorderPane().getCenter()).getChildren()) {
				if (n instanceof TextField) {
					TextField tf = (TextField) n;

					if (tf.getText().replaceAll(" ", "").length() == 0)
						return;

					temp[i] = tf.getText();

					if (Menu.contains(helper.getIndexes(), i)) {
						try {
							temp[i] = Integer.parseInt(tf.getText());
						} catch (Exception ex) {
							return;
						}
					}
					i++;
				}
			}
			break;
		default:
			helper.goToMainView();
		}
	}

}
