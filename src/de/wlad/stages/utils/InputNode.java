package de.wlad.stages.utils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class InputNode {

	public static BorderPane generateInputNode(Object[] temp, Object[] state) {
		BorderPane bp = new BorderPane();
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);

		for (int i = 0; i < state.length; i++) {
			if (state[i] == null || state[i].equals(0))
				state[i] = "";
			grid.addRow(i + 1, new Label(temp[i].toString()), new TextField(state[i].toString()));
		}
		
		for(Node c : grid.getChildren()) {
			System.out.println("G: " + c.toString());
		}

		Button bNeu = new Button("Neu");
		Button bAbbrechen = new Button("Abbrechen");
		HBox hb = new HBox();
		hb.setPadding(new Insets(10.0));
		hb.setSpacing(10.0);
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(bNeu, bAbbrechen);
		bp.setCenter(grid);
		bp.setBottom(hb);
		bp.setPadding(new Insets(10.0));
		
		for(Node c : hb.getChildren())
			System.out.println("HB: " + c.toString());
		
		System.out.println("BP: " + bp.getCenter().toString());

		return bp;
	}

}
