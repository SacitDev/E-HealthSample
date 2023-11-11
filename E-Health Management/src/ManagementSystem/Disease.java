/*
 * Michael Wernofsky
 * OOP OSTIM Course
 * Small E-health managent system
 */
package ManagementSystem;

import static ManagementSystem.Types.dNums;
import ManagementSystem.Types.diseaseLevel;
import ManagementSystem.Types.diseaseType;
import java.io.Serializable;

/**
 *
 * @author UPC
 */
public class Disease implements Serializable {

	private int diseaseNum;
	private String diseaseName;
	private diseaseType type;
	private diseaseLevel level;

	public Disease(int diseaseNum, String diseaseName, diseaseType type, diseaseLevel level) {
		if (dNums.contains(diseaseNum) || diseaseNum < 0) {
			System.out.println("This Disease exists already - Non valid ID");
			this.nonValidValue();
		} else {
			this.diseaseNum = diseaseNum;
			dNums.add(this.diseaseNum);
			this.diseaseName = diseaseName;
			this.type = type;
			this.level = level;
		}
	}

	private void nonValidValue() {
		this.diseaseNum = -1;
		this.diseaseName = "NonValid";
		this.type = diseaseType.General;
		this.level = diseaseLevel.Basic;
	}

	public int getDiseaseNum() {
		return diseaseNum;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public diseaseType getType() {
		return type;
	}

	public diseaseLevel getLevel() {
		return level;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public void setType(diseaseType type) {
		this.type = type;
	}

	public void setLevel(diseaseLevel level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Disease{" + "diseaseNum=" + diseaseNum + ", diseaseName=" + diseaseName + ", type=" + type + ", level=" + level + '}';
	}
	
}
