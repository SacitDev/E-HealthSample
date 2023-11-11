/*
 * Michael Wernofsky
 * OOP OSTIM Course
 * Small E-health managent system
 */
package ManagementSystem;

import java.util.LinkedList;

/**
 *
 * @author UPC
 */
public class HealthMinistry {

	private static LinkedList<Patient> pList = new LinkedList();
	private static LinkedList<Doctor> dList = new LinkedList();
	private static LinkedList<Pharmacy> phList = new LinkedList();
	private static LinkedList<Disease> disList = new LinkedList();
	private static LinkedList<University> uList = new LinkedList();
	private static String adminPass = Types.basicPass;

	;

	/*public HealthMinistry(LinkedList<Patient> pList, LinkedList<Doctor> dList, LinkedList<Pharmacy> phList, LinkedList<University> uList) {
		this.pList = pList;
		this.dList = dList;
		this.phList = phList;
		this.uList = uList;
	}*/

	public static void printDoc() {
		for (Doctor doctor : dList) {
			System.out.println(doctor.toString());
		}
	}

	public static boolean checkDoc(int inID) {
		for (Doctor doctor : dList) {
			if (doctor.getpID() == inID) {
				return true;
			}
		}
		return false;
	}

	public static Doctor getDoc(int inID) {
		for (Doctor doctor : dList) {
			if (doctor.getpID() == inID) {
				return doctor;
			}
		}
		return new Doctor();
	}

	public static Patient getPai(int inID) {
		for (Patient patient : pList) {
			if (patient.getpID() == inID) {
				return patient;
			}
		}
		return new Patient(-1, "", "");
	}

	public static Disease getDis(int inID) {
		for (Disease disease : disList) {
			if (disease.getDiseaseNum() == inID) {
				return disease;
			}
		}
		return new Disease(-1, "Non Valid", Types.diseaseType.General, Types.diseaseLevel.Basic);
	}

	public static LinkedList<Pharmacy> getPhar(LinkedList<Drug> askedDrugs) {
		LinkedList<Pharmacy> ph = new LinkedList();
		for (Pharmacy pharmacy : phList) {
			if (pharmacy.isAvailable(askedDrugs)) {
				ph.add(pharmacy);
			}
		}
		return ph;
	}

	public static LinkedList<Patient> getpList() {
		return pList;
	}

	public static void addpList(Patient p) {
		HealthMinistry.pList.add(p);
	}

	public static LinkedList<Doctor> getdList() {
		return dList;
	}

	public static void adddList(Doctor d) {
		HealthMinistry.dList.add(d);
	}

	public static LinkedList<Pharmacy> getPhList() {
		return phList;
	}

	public static void setPhList(LinkedList<Pharmacy> phList) {
		HealthMinistry.phList = phList;
	}

	public LinkedList<University> getuList() {
		return uList;
	}

	public static void adduList(University u) {
		HealthMinistry.uList.add(u);
	}

	public static String getAdminPass() {
		return adminPass;
	}

	public static void setAdminPass(String adminPass) {
		HealthMinistry.adminPass = adminPass;
	}

}
