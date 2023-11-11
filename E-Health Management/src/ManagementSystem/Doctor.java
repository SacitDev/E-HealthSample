/*
 * Michael Wernofsky
 * OOP OSTIM Course
 * Small E-health managent system
 */
package ManagementSystem;

import ManagementSystem.Types.diseaseType;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author UPC
 */
public class Doctor extends Person{
	
	private diseaseType specialization;
	private String docPass;
	private ArrayList<Integer> patients;
	
	public Doctor() {
		super(0, "No Access", "No Access");
	}

	public Doctor(diseaseType specialization, int pID, String firstName, String lastName) {
		super(pID, firstName, lastName);
		this.specialization = specialization;
		this.docPass = Types.basicPass;
		this.patients = new ArrayList();
	}

	public Doctor(diseaseType specialization, int pID, String firstName, String lastName, LocalDate BirthDate, Types.sex gender, String city, String address, Types.degree pDegree) {
		super(pID, firstName, lastName, BirthDate, gender, city, address, "Doctor", pDegree);
		this.specialization = specialization;
		this.docPass = Types.basicPass;
		this.patients = new ArrayList();
	}
	
	public Doctor(int pID, String firstName, String lastName) {
		super(pID, firstName, lastName);
		this.docPass = Types.basicPass;
		this.patients = new ArrayList();
	}
	
	public Doctor(int pID, String firstName, String lastName, LocalDate BirthDate, Types.sex gender, String city, String address, String occupation, Types.degree pDegree) {
		super(pID, firstName, lastName, BirthDate, gender, city, address, occupation, pDegree);
		this.docPass = Types.basicPass;
		this.patients = new ArrayList();
	}

	public ArrayList<Integer> getPatients() {
		return patients;
	}

	public void addPatients(int p) {
		this.patients.add(p);
	}
	
	

	public diseaseType getSpecialization() {
		return specialization;
	}

	public void setSpecialization(diseaseType specialization) {
		this.specialization = specialization;
	}

	public String getDocPass() {
		return docPass;
	}

	public void setDocPass(String docPass) {
		this.docPass = docPass;
	}
	
	

	@Override
	public String toString() {
		return "Doctor{" + "pID=" + super.getpID() + ", firstName=" + super.getFirstName() + ", lastName=" + super.getLastName() + ", BirthDate=" + super.getBirthDate() + ", age=" + super.getAge() + ", gender=" + super.getGender() + ", city=" + super.getCity() + ", address=" + super.getAddress() + ", occupation= Doctor of " + this.specialization + ", pDegree=" + super.getpDegree() + '}';
	}
}
