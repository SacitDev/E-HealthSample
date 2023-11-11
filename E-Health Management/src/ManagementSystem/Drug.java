/*
 * Michael Wernofsky
 * OOP OSTIM Course
 * Small E-health managent system
 */
package ManagementSystem;

import static ManagementSystem.Types.dIDS;
import java.io.Serializable;

/**
 *
 * @author UPC
 */
public class Drug implements Serializable {

	private int dID;
	private String name;
	private String description;

	public Drug(int dID, String name, String description) {
		if (dIDS.contains(dID) || dID < 1) {
			System.out.println("This Drug exists already - Non valid ID");
			this.nonValidValue();
		} else {
			this.dID = dID;
			dIDS.add(this.dID);
			this.name = name;
			this.description = description;
		}
	}

	private void nonValidValue() {
		this.dID = -1;
		this.name = "NonValid";
		this.description = "NonValid";
	}

	public int getdID() {
		return dID;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Drug{" + "dID=" + dID + ", name=" + name + ", description=" + description + '}';
	}

}
