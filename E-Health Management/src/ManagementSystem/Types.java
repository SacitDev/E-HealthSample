/*
 * Michael Wernofsky
 * OOP OSTIM Course
 * Small E-health managent system
 */
package ManagementSystem;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * List of types,constants,data used
 * @author UPC
 */
public class Types implements Serializable {

	/*
	No one can instantiate this class
	 */
	private Types() {
	}

	public enum sex {
		Male, Female
	};

	public enum degree {
		Undergraduate,
		Associate,
		Bachelor,
		Graduate,
		Master,
		Doctoral,
		Professional,
		Specialist
	};

	public enum diseaseType {
		General,
		AllergyAndImmunology,
		Anesthesiology,
		Dermatology,
		DiagnosticRadiology,
		InternalMedicine,
		MedicalGenetics,
		Neurology,
		Pathology,
		Urology
	};

	public enum diseaseLevel {
		Basic,
		Medium,
		High
	};
	
	public enum accessLevel {
		Full,
		Partial,
		Private,
		Pharmaceutical
	};

	// each doctor can have up to 5 patients
	public static final int DOC_CAP = 5;
	
	public static final String basicPass = "1234";
	
	public static LinkedList<Integer> pIDs = new LinkedList<>();
	public static LinkedList<Integer> dNums = new LinkedList<>();
	public static LinkedList<Integer> unIDS = new LinkedList<>();
	public static LinkedList<Integer> dIDS = new LinkedList<>();
	public static LinkedList<Integer> phIDS = new LinkedList<>();
}
