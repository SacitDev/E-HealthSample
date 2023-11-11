/*
 * Michael Wernofsky
 * OOP OSTIM Course
 * Small E-health managent system
 */
package ManagementSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author UPC
 */
public class FileManager {
	private static String docFilesLoc = ".\\src\\ManagementSystem\\Doctors\\";
	private static String paiFilesLoc = ".\\src\\ManagementSystem\\Patients\\";
	
	public static void writeDoc(Doctor doc) throws FileNotFoundException, IOException {
		String fName = doc.getpID() + ".doc";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(FileManager.docFilesLoc + fName)))) {
			oos.writeObject(doc);
			oos.close();
		}
	}
	
	public static void writePai(Patient pai) throws FileNotFoundException, IOException {
		String fName = pai.getpID() + ".pai";
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(FileManager.paiFilesLoc + fName)))) {
			oos.writeObject(pai);
			oos.close();
		}
	}
	
	public static Doctor readDoc(int nID) throws FileNotFoundException, IOException, ClassNotFoundException {
		String fName = nID + ".doc";
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(FileManager.docFilesLoc + fName)));
		Doctor doc = (Doctor) ois.readObject();
		ois.close();
		return doc;
	}
	
	public static Patient readPai(int nID) throws FileNotFoundException, IOException, ClassNotFoundException {
		String fName = nID + ".pai";
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(FileManager.paiFilesLoc + fName)));
		Patient pai = (Patient) ois.readObject();
		ois.close();
		return pai;
	}
	
	public static void readAll() throws IOException, FileNotFoundException, ClassNotFoundException {
		File docFolder = new File(FileManager.docFilesLoc);
		File[] dFileList = docFolder.listFiles();
		for (File file : dFileList) {
			if (file.getName().endsWith(".doc")) {
				String[] str = file.getName().split("\\.");
				HealthMinistry.adddList(FileManager.readDoc(Integer.parseInt(str[0])));
			} else {
				System.err.println("Doc + There is an unvalid file : " + file.getName());
			}
		}
		
		File paiFolder = new File(FileManager.paiFilesLoc);
		File[] pFileList = paiFolder.listFiles();
		for (File file : pFileList) {
			if (file.getName().endsWith(".pai")) {
				String[] str = file.getName().split("\\.");
				HealthMinistry.addpList(FileManager.readPai(Integer.parseInt(str[0])));
			} else {
				System.err.println("Pai + There is an unvalid file : " + file.getName());
			}
		}
	}
	
	public static void writeAll() throws IOException, FileNotFoundException, ClassNotFoundException {
		for (Doctor doc : HealthMinistry.getdList()) {
			FileManager.writeDoc(doc);
		}
		
		for (Patient pai : HealthMinistry.getpList()) {
			FileManager.writePai(pai);
		}
	}
}
