package de.wlad.stages.utils;

import javax.swing.JOptionPane;

import de.wlad.exceptions.EmptyFilenameException;
import de.wlad.exceptions.InputAbortException;

public interface FileHelper {
	default String parsePath() throws InputAbortException, EmptyFilenameException {
		String s = JOptionPane.showInputDialog("Dateipfad eingeben.");

		if (s == null)
			throw new InputAbortException();

		if (s.replaceAll(" ", "").length() == 0)
			throw new EmptyFilenameException();

		return s;
	}
}
