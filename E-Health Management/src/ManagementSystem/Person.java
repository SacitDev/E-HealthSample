/*
 * Michael Wernofsky
 * OOP OSTIM Course
 * Small E-health managent system
 */
package ManagementSystem;

import ManagementSystem.Types.*;
import static ManagementSystem.Types.pIDs;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Father of Doctor and Patient Includes Basic data
 *
 * @author UPC
 */
public abstract class Person implements Serializable {

	private int pID;
	private String firstName;
	private String lastName;
	private LocalDate BirthDate;
	private int age;
	private sex gender;
	private String city;
	private String address;
	private String occupation;
	private degree pDegree;

	public Person(int pID, String firstName, String lastName) {
		if (pIDs.contains(pID) || pID < 0) {
			System.out.println("This Person exists already - Non valid ID");
			this.nonValidValue();
		} else {
			this.pID = pID;
			pIDs.add(this.pID);
			this.firstName = firstName;
			this.lastName = lastName;
			this.defaultValue();
		}
	}

	public Person(int pID, String firstName, String lastName, LocalDate BirthDate, sex gender, String city, String address, String occupation, degree pDegree) {
		if (pIDs.contains(pID) || pID < 1) {
			System.out.println("This Person exists already - Non valid ID");
			this.nonValidValue();
		} else {
			this.pID = pID;
			pIDs.add(this.pID);
			this.firstName = firstName;
			this.lastName = lastName;
			this.BirthDate = BirthDate;
			this.age = (int) ChronoUnit.YEARS.between(BirthDate, LocalDate.now());
			this.gender = gender;
			this.city = city;
			this.address = address;
			this.occupation = occupation;
			this.pDegree = pDegree;
		}
	}

	private void defaultValue() {
		this.BirthDate = LocalDate.now();
		this.age = (int) ChronoUnit.YEARS.between(BirthDate, LocalDate.now());
		this.gender = sex.Male;
		this.city = "None";
		this.address = "None";
		this.occupation = "None";
		this.pDegree = degree.Undergraduate;
	}
	
	private void nonValidValue() {
		this.pID = -1;
		this.firstName = "NonValid";
		this.lastName = "NonValid";
		this.BirthDate = LocalDate.now();
		this.age = (int) ChronoUnit.YEARS.between(BirthDate, LocalDate.now());
		this.gender = sex.Male;
		this.city = "NonValid";
		this.address = "NonValid";
		this.occupation = "NonValid";
		this.pDegree = degree.Undergraduate;
	}

	public int getpID() {
		return pID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(LocalDate BirthDate) {
		this.BirthDate = BirthDate;
		this.age = (int) ChronoUnit.YEARS.between(BirthDate, LocalDate.now());
	}

	public int getAge() {
		return age;
	}

	public sex getGender() {
		return gender;
	}

	public void setGender(sex gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public degree getpDegree() {
		return pDegree;
	}

	public void setpDegree(degree pDegree) {
		this.pDegree = pDegree;
	}

}
