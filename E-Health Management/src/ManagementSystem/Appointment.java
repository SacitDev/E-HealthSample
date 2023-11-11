/*
 * Michael Wernofsky
 * OOP OSTIM Course
 * Small E-health managent system
 */
package ManagementSystem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author UPC
 */
public class Appointment implements Serializable {

	private LocalDate appDate;
	private Doctor appDoc;
	private Disease appDis;
	private ArrayList<Drug> appDrugs;
	private String description;

	public Appointment(LocalDate appDate, Doctor appDoc, Disease appDis, ArrayList<Drug> appDrugs) {
		this.appDate = appDate;
		this.appDoc = appDoc;
		this.appDis = appDis;
		this.appDrugs = appDrugs;
		this.description = "None";
	}

	public Appointment(LocalDate appDate, Doctor appDoc, Disease appDis, ArrayList<Drug> appDrugs, String description) {
		this.appDate = appDate;
		this.appDoc = appDoc;
		this.appDis = appDis;
		this.appDrugs = appDrugs;
		this.description = description;
	}

	public LocalDate getAppDate() {
		return appDate;
	}

	public Doctor getAppDoc() {
		return appDoc;
	}

	public Disease getAppDis() {
		return appDis;
	}

	public ArrayList<Drug> getAppDrugs() {
		return appDrugs;
	}

	public String getDescription() {
		return description;
	}
	
	

}
