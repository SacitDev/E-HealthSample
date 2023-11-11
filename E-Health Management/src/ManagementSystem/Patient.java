/*
 * Michael Wernofsky
 * OOP OSTIM Course
 * Small E-health managent system
 */
package ManagementSystem;

import ManagementSystem.Types.accessLevel;
import ManagementSystem.Types.diseaseType;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author UPC
 */
public class Patient extends Person {

	private String patientPass;
	private boolean selectedDoc;
	private String basicInsurance;
	private String supplementaryInsurance;
	private Report pReport;
	private boolean toShare;
	private ArrayList<Doctor> fullDoc;
	private ArrayList<Doctor> partialDoc;


	public Patient(String basicInsurance, String supplementaryInsurance, int pID, String firstName, String lastName) {
		super(pID, firstName, lastName);
		this.basicInsurance = basicInsurance;
		this.supplementaryInsurance = supplementaryInsurance;
		this.pReport = new Report(pID);
		this.toShare = false;
		this.fullDoc = new ArrayList();
		this.partialDoc = new ArrayList();
		this.selectedDoc = false;
		this.patientPass = Types.basicPass;
	}

	public Patient(String basicInsurance, String supplementaryInsurance, int pID, String firstName, String lastName, LocalDate BirthDate, Types.sex gender, String city, String address, String occupation, Types.degree pDegree) {
		super(pID, firstName, lastName, BirthDate, gender, city, address, occupation, pDegree);
		this.basicInsurance = basicInsurance;
		this.supplementaryInsurance = supplementaryInsurance;
		this.pReport = new Report(pID);
		this.toShare = false;
		this.fullDoc = new ArrayList();
		this.partialDoc = new ArrayList();
		this.selectedDoc = false;
		this.patientPass = Types.basicPass;
	}

	public Patient(int pID, String firstName, String lastName) {
		super(pID, firstName, lastName);
		this.pReport = new Report(pID);
		this.toShare = false;
		this.fullDoc = new ArrayList();
		this.partialDoc = new ArrayList();
		this.selectedDoc = false;
		this.patientPass = Types.basicPass;
	}

	public Patient(int pID, String firstName, String lastName, LocalDate BirthDate, Types.sex gender, String city, String address, String occupation, Types.degree pDegree) {
		super(pID, firstName, lastName, BirthDate, gender, city, address, occupation, pDegree);
		this.pReport = new Report(pID);
		this.toShare = false;
		this.fullDoc = new ArrayList();
		this.partialDoc = new ArrayList();
		this.selectedDoc = false;
		this.patientPass = Types.basicPass;
	}

	public String getPatientPass() {
		return patientPass;
	}

	public void setPatientPass(String patientPass) {
		this.patientPass = patientPass;
	}
	

	public String getBasicInsurance() {
		return basicInsurance;
	}

	public void setBasicInsurance(String basicInsurance) {
		this.basicInsurance = basicInsurance;
	}

	public String getSupplementaryInsurance() {
		return supplementaryInsurance;
	}

	public void setSupplementaryInsurance(String supplementaryInsurance) {
		this.supplementaryInsurance = supplementaryInsurance;
	}

	public boolean isToShare() {
		return toShare;
	}

	public void setToShare(boolean toShare) {
		this.toShare = toShare;
	}

	public ArrayList<Doctor> getFullDoc() {
		return fullDoc;
	}

	public void addFullDoc(Doctor fullDoc) {
		this.fullDoc.add(fullDoc);
		//System.out.println("ManagementSystem.Patient.addFullDoc()");
	}

	public ArrayList<Doctor> getPartialDoc() {
		return partialDoc;
	}

	public void addPartialDoc(Doctor partialDoc) {
		this.partialDoc.add(partialDoc);
	}

	public boolean isSelectedDoc() {
		return selectedDoc;
	}

	public void setSelectedDoc(boolean selectedDoc) {
		this.selectedDoc = selectedDoc;
	}
	

	@Override
	public String toString() {
		return "Patient{" + "pID=" + super.getpID() + ", firstName=" + super.getFirstName() + ", lastName=" + super.getLastName() + ", BirthDate=" + super.getBirthDate() + ", age=" + super.getAge() + ", gender=" + super.getGender() + ", city=" + super.getCity() + ", address=" + super.getAddress() + ", occupation=" + super.getOccupation() + ", pDegree=" + super.getpDegree() + "basicInsurance=" + basicInsurance + ", supplementaryInsurance=" + supplementaryInsurance + '}';
	}

	public Report getReport(accessLevel accLevel, int docID) {
		if(docID == -2) {
			return this.pReport;
		}
		Report rp = new Report(this.getpID());
		boolean chk = true;
		if (null != accLevel) {
			switch (accLevel) {
				case Full:
					for (Doctor doctor : fullDoc) {
						if (doctor.getpID() == docID) {
							chk = false;
							rp = this.pReport;
							break;
						}
					}
					if (chk) {
						System.out.println("InValid accsess - this doc hasn't full access");
						rp.setReportNum(-1);
					}
					break;
				case Partial:
					for (Doctor doctor : partialDoc) {
						if (doctor.getpID() == docID) {
							chk = false;
							for (Appointment appointment : this.pReport.getAppList()) {
								if (appointment.getAppDis().getType() == doctor.getSpecialization()) {
									rp.addToReport(appointment.getAppDate(), appointment.getAppDoc(), appointment.getAppDis(), appointment.getAppDrugs(), appointment.getDescription());
								}
							}
							rp.setStatus(this.pReport.getStatus());
							break;
						}
					}

					if (chk) {
						System.out.println("InValid accsess - this doc hasn't partial access");
						rp.setReportNum(-1);
					}
					break;
				case Private:
					if (!this.toShare) {
						System.out.println("The Patient don't want to share info");
						rp.setReportNum(-1);
					} else {
						rp = this.pReport;
						rp.setReportNum(0);
					}
					break;
				default:
					for (Appointment appointment : this.pReport.getAppList()) {
						rp.addToReport(appointment.getAppDate(), new Doctor(), new Disease(0, "No Access", diseaseType.General, Types.diseaseLevel.Basic), appointment.getAppDrugs(), "No Access");
					}
					rp.setStatus("No Access");
					break;
			}
		}
		return rp;
	}

	public boolean addReport(int docID, LocalDate addDate, Doctor addDoc, Disease addDis, ArrayList<Drug> addDrugs) {
		for (Doctor doctor : fullDoc) {
			if (doctor.getpID() == docID) {
				this.pReport.addToReport(addDate, addDoc, addDis, addDrugs);
				//System.out.println("added Report");
				return true;
			}
		}
		for (Doctor doctor : partialDoc) {
			if (doctor.getpID() == docID) {
				this.pReport.addToReport(addDate, addDoc, addDis, addDrugs);
				return true;
			}
		}
		return false;
	}

	public boolean addReport(int docID, LocalDate addDate, Doctor addDoc, Disease addDis, ArrayList<Drug> addDrugs, String description) {
		for (Doctor doctor : fullDoc) {
			if (doctor.getpID() == docID) {
				this.pReport.addToReport(addDate, addDoc, addDis, addDrugs, description);
				return true;
			}
		}
		for (Doctor doctor : partialDoc) {
			if (doctor.getpID() == docID) {
				this.pReport.addToReport(addDate, addDoc, addDis, addDrugs, description);
				return true;
			}
		}
		return false;
	}
}
