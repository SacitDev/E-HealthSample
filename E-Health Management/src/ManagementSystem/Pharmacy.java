/*
 * Michael Wernofsky
 * OOP OSTIM Course
 * Small E-health managent system
 */
package ManagementSystem;

import ManagementSystem.Types.accessLevel;
import static ManagementSystem.Types.phIDS;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author UPC
 */
public class Pharmacy implements Serializable {

	private int phID;
	private String name;
	private String address;
	public LinkedList<Drug> availableDrugs;
	private final accessLevel accLevel = accessLevel.Pharmaceutical;

	public Pharmacy(int phID, String name, String address, LinkedList<Drug> availableDrugs) {
		if (phIDS.contains(phID) || phID < 1) {
			System.out.println("This University exists already - Non valid ID");
			this.availableDrugs = new LinkedList<>();
			this.nonValidValue();
		} else {
			this.phID = phID;
			phIDS.add(this.phID);
			this.name = name;
			this.address = address;
			this.availableDrugs = availableDrugs;
		}
	}

	private void nonValidValue() {
		this.phID = -1;
		this.name = "NonValid";
		this.address = "NonValid";
		this.availableDrugs.clear();
	}

	public boolean isAvailable(LinkedList<Drug> askedDrugs) {
		return this.availableDrugs.containsAll(askedDrugs);
	}

	public int getPhID() {
		return phID;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Pharmacy{" + "phID=" + phID + ", name=" + name + ", address=" + address + '}';
	}
}
