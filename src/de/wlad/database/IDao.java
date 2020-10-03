package de.wlad.database;

import java.util.List;

import de.wlad.Medium;
import de.wlad.exceptions.PersistenzException;

public interface IDao {
	void speichern(List<Medium> liste) throws PersistenzException;
	List<Medium> laden() throws PersistenzException;
}
