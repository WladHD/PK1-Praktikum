package de.wlad.stages.utils;

import javax.swing.JOptionPane;

public interface OutputHelper {
	
	static void showSuccess() {
		JOptionPane.showMessageDialog(null, "Aktion erfolgreich ausgef�hrt.");
	}
	
	static void wrongInput() {
		JOptionPane.showMessageDialog(null, "Bitte geben Sie g�ltige Zahlen ein.");
	}
	
}
