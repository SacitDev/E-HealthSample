/*
 * Michael Wernofsky
 * OOP OSTIM Course
 * Small E-health managent system
 */
package ManagementSystem;

import static ManagementSystem.Types.pIDs;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author UPC
 */
public class Report implements Serializable {
	// equal to Patient ID - pID
	private int reportNum;
	private String status;
	private ArrayList<Appointment> appList;

	public Report(int reportNum) {
		if ((!pIDs.contains(reportNum)) || reportNum < 0) {
			System.out.println("There is no such a Patient - Non valid ID" + reportNum);
			this.reportNum = -1;
		} else {
			this.reportNum = reportNum;
			this.appList = new ArrayList<>();
		}
	}

	public int getReportNum() {
		return reportNum;
	}

	public void setReportNum(int reportNum) {
		if (!pIDs.contains(reportNum) || reportNum < 0) {
			System.out.println("There is no such a Patient - Non valid ID");
			this.reportNum = -1;
		} else {
			this.reportNum = reportNum;
		}
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void addToReport(LocalDate addDate, Doctor addDoc, Disease addDis, ArrayList<Drug> addDrugs, String description) {
		Appointment apt = new Appointment(addDate, addDoc, addDis, addDrugs, description);
		appList.add(apt);
	}

	public void addToReport(LocalDate addDate, Doctor addDoc, Disease addDis, ArrayList<Drug> addDrugs) {
		Appointment apt = new Appointment(addDate, addDoc, addDis, addDrugs);
		appList.add(apt);
	}

	public ArrayList<Appointment> getAppList() {
		return appList;
	}
}
