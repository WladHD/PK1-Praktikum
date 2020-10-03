package de.wlad.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.List;

import de.wlad.Medium;
import de.wlad.exceptions.PersistenzException;

public class FileManager implements IDao {

	private File database = new File("C:\\Users\\wladh\\Desktop\\pk1database.dtb");

	@Override
	public void speichern(List<Medium> liste) throws PersistenzException {
		serialize(database, liste);
	}

	@Override
	public List<Medium> laden() throws PersistenzException {
		return deserialize(database);
	}

	public static void serialize(File to, List<Medium> list) {
		try (FileOutputStream fos = new FileOutputStream(to); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Medium> deserialize(File from) {
		try (FileInputStream fis = new FileInputStream(from); ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (List<Medium>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void copy(File from, File to) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(from);
			fos = new FileOutputStream(to);

			int c;
			while ((c = fis.read()) != -1)
				fos.write(c);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static void cat(File quelle) {
		try (RandomAccessFile raf = new RandomAccessFile(quelle, "r")) {
			String s;
			while ((s = raf.readLine()) != null)
				System.out.println(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
