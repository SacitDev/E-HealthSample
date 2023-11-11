/*
 * Michael Wernofsky
 * OOP OSTIM Course
 * Small E-health managent system
 */
package ManagementSystem;

import ManagementSystem.Types.accessLevel;
import static ManagementSystem.Types.unIDS;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author UPC
 */
public class University implements Serializable {
	
	private int unID;
	private String uniName;
	private LinkedList<Report> researchData;
	private final accessLevel accLevel = accessLevel.Private;

	public University(int unID, String uniName) {
		if (unIDS.contains(unID) || unID < 1) {
			System.out.println("This University exists already - Non valid ID");
			this.researchData = new LinkedList<>();
			this.nonValidValue();
		} else {
			this.unID = unID;
			unIDS.add(this.unID);
			this.uniName = uniName;
			this.researchData = new LinkedList();
		}
	}
	
	private void nonValidValue() {
		this.unID = -1;
		this.uniName = "NonValid";
		this.researchData.clear();
	}

	public int getUnID() {
		return unID;
	}

	public String getUniName() {
		return uniName;
	}

	public void setUniName(String uniName) {
		this.uniName = uniName;
	}

	public LinkedList<Report> getResearchData() {
		return researchData;
	}

	public void addResearchData(Report r) {
		this.researchData.add(r);
	}
	
	
	@Override
	public String toString() {
		return "University{" + "unID=" + unID + ", uniName=" + uniName + '}';
	}

}
