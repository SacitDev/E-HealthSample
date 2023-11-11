/*
 * Michael Wernofsky
 * OOP OSTIM Course
 * Small E-health managent system
 */
package ManagementSystem;

import ManagementSystem.Types.accessLevel;
import ManagementSystem.Types.diseaseLevel;
import ManagementSystem.Types.diseaseType;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UPC
 */
public class Main {

	public static void patientPanel(Patient p) {
		boolean stay = true;
		Scanner sc = new Scanner(System.in);

		while (stay) {

			System.out.println("*** What do you want to do ***");
			System.out.print("\t**********************************************************************************************\n");
			System.out.print("\t*                                                                                            *\n");
			System.out.print("\t*                  1.Edit Password                                                           *\n");
			System.out.print("\t*                  2.Select first Doctor                                                     *\n");
			System.out.print("\t*                  3.Show Pharmacys base on your drugs                                       *\n");
			System.out.print("\t*                  4.Show your report                                                        *\n");
			System.out.print("\t*                  5.Exit                                                                    *\n");
			System.out.print("\t**********************************************************************************************\n");
			int sl = sc.nextInt();
			sc.nextLine();
			switch (sl) {
				case 1:
					System.out.println("*** Enter new Password ***");
					p.setPatientPass(sc.nextLine());
					System.out.println("*** Done ***");
					break;
				case 2:
					if (p.isSelectedDoc()) {
						System.out.println("*** Sorry, You Choosed your Doctor ***");
					} else {
						System.out.println("*** Enter Doctor ID ***");
						HealthMinistry.printDoc();
						int inID = sc.nextInt();
						sc.nextLine();
						if (HealthMinistry.checkDoc(inID)) {
							p.addFullDoc(HealthMinistry.getDoc(inID));
							HealthMinistry.getDoc(inID).addPatients(p.getpID());
							System.out.println("*** Done ***");
							p.setSelectedDoc(true);
						} else {
							System.out.println("*** InValid Doctor ID ***");
						}
					}
					break;
				case 3:
					LinkedList<Drug> drugs = new LinkedList();
					for (Appointment app : p.getReport(accessLevel.Full, -2).getAppList()) {
						drugs.addAll(app.getAppDrugs());
					}
					LinkedList<Pharmacy> ph = HealthMinistry.getPhar(drugs);
					System.out.println("*** Pharmacy List  ***");
					for (Pharmacy pharmacy : ph) {
						System.out.println(ph.toString());
					}
					break;
				case 4:
					System.out.println("Report #" + p.getReport(accessLevel.Full, -2).getReportNum() + "|" + p.getReport(accessLevel.Full, -2).getStatus() + " :");
					int i = 1;
					for (Appointment app : p.getReport(accessLevel.Full, -2).getAppList()) {

						System.out.println("NUM " + i + "-->>");
						System.out.println(app.getAppDate());
						System.out.println(app.getAppDoc().toString());
						System.out.println(app.getAppDis().toString());
						System.out.println(app.getDescription());
						System.out.println("---------------------------------------------------------------------------");
						i++;
					}
					break;
				case 5:
					System.out.println("*** Bye!!!  ***");
					stay = false;
					break;
				default:
					System.out.println("Wrong choice, Try again");
					break;
			}
		}
	}

	public static void doctorPanel(Doctor d) {
		boolean stay = true;
		Scanner sc = new Scanner(System.in);

		while (stay) {

			System.out.println("*** What do you want to do ***");
			System.out.print("\t**********************************************************************************************\n");
			System.out.print("\t*                                                                                            *\n");
			System.out.print("\t*                  1.Edit Password                                                           *\n");
			System.out.print("\t*                  2.Add Appointment details                                                 *\n");
			System.out.print("\t*                  3.Add new doctor accsess                                                  *\n");
			System.out.print("\t*                  4.Show your Patient List                                                  *\n");
			System.out.print("\t*                  5.Exit                                                                    *\n");
			System.out.print("\t**********************************************************************************************\n");
			int sl = sc.nextInt();
			sc.nextLine();
			switch (sl) {
				case 1:
					System.out.println("*** Enter new Password ***");
					d.setDocPass(sc.nextLine());
					System.out.println("*** Done ***");
					break;
				case 2:
					System.out.println("*** Enter Patient ID ***");
					int inID = sc.nextInt();
					sc.nextLine();
					if (d.getPatients().contains(inID)) {
						System.out.println("*** Do you want to create a new disease? y/n ***");
						String yORn = sc.nextLine();
						Disease disTemp;
						ArrayList<Drug> drTemp = new ArrayList();
						if (yORn.equals("y")) {
							System.out.println("*** Enter Disease NUM ***");
							int disID = sc.nextInt();
							sc.nextLine();
							System.out.println("*** Enter Disease Name ***");
							String disName = sc.nextLine();
							System.out.println("*** Enter Disease Type ***");
							System.out.print("\t**********************************************************************************************\n");
							System.out.print("\t*                                                                                            *\n");
							System.out.print("\t*                  1.General                                                                 *\n");
							System.out.print("\t*                  2.AllergyAndImmunology                                                    *\n");
							System.out.print("\t*                  3.Anesthesiology                                                          *\n");
							System.out.print("\t*                  4.Dermatology                                                             *\n");
							System.out.print("\t*                  5.DiagnosticRadiology                                                     *\n");
							System.out.print("\t*                  6.InternalMedicine                                                        *\n");
							System.out.print("\t*                  7.MedicalGenetics                                                         *\n");
							System.out.print("\t*                  8.Neurology                                                               *\n");
							System.out.print("\t*                  9.Pathology                                                               *\n");
							System.out.print("\t*                  10.Urology                                                                *\n");
							System.out.print("\t**********************************************************************************************\n");
							int slc = sc.nextInt();
							sc.nextLine();
							diseaseType dt;
							switch (slc) {
								case 1:
									dt = diseaseType.General;
									break;
								case 2:
									dt = diseaseType.AllergyAndImmunology;
									break;
								case 3:
									dt = diseaseType.Anesthesiology;
									break;
								case 4:
									dt = diseaseType.Dermatology;
									break;
								case 5:
									dt = diseaseType.DiagnosticRadiology;
									break;
								case 6:
									dt = diseaseType.InternalMedicine;
									break;
								case 7:
									dt = diseaseType.MedicalGenetics;
									break;
								case 8:
									dt = diseaseType.Neurology;
									break;
								case 9:
									dt = diseaseType.Pathology;
									break;
								case 10:
									dt = diseaseType.Urology;
									break;
								default:
									System.out.println("Not Valid");
									return;
							}
							System.out.println("*** Enter Disease level 1,2,3 for basic to high ***");
							int disLevel = sc.nextInt();
							sc.nextLine();
							diseaseLevel dl;
							switch (disLevel) {
								case 1:
									dl = diseaseLevel.Basic;
									break;
								case 2:
									dl = diseaseLevel.Medium;
									break;
								case 3:
									dl = diseaseLevel.High;
									break;
								default:
									System.out.println("Not Valid");
									return;
							}
							disTemp = new Disease(disID, disName, dt, dl);
						} else {
							System.out.println("*** Enter Disease NUM ***");
							int disID = sc.nextInt();
							sc.nextLine();
							disTemp = HealthMinistry.getDis(disID);
						}
						while (true) {
							System.out.println("*** Enter Drug names -- enter end when finished***");
							String dName = sc.nextLine();
							if (dName.equals("end")) {
								break;
							} else {
								System.out.println("*** Enter Drug ID ***");
								int drugID = sc.nextInt();
								sc.nextLine();
								drTemp.add(new Drug(drugID, dName, "empty"));
							}
						}
						HealthMinistry.getPai(inID).addReport(d.getpID(), LocalDate.now(), d, disTemp, drTemp);
					} else {
						System.out.println("*** USER NOT FOUND ***");
					}
					break;
				case 3:
					System.out.println("*** Enter Patient ID ***");
					int pID = sc.nextInt();
					sc.nextLine();
					if (d.getPatients().contains(pID)) {
						System.out.println("*** Enter Doctor ID ***");
						int docID = sc.nextInt();
						sc.nextLine();
						if (HealthMinistry.checkDoc(docID)) {
							System.out.println("*** which kind of access? 1 for full, others for Partial ***");
							int chk = sc.nextInt();
							sc.nextLine();
							if (chk == 1) {
								HealthMinistry.getPai(pID).addFullDoc(HealthMinistry.getDoc(docID));
								HealthMinistry.getDoc(docID).addPatients(pID);
							} else {
								HealthMinistry.getPai(pID).addPartialDoc(HealthMinistry.getDoc(docID));
								HealthMinistry.getDoc(docID).addPatients(pID);
							}
						} else {
							System.out.println("*** DOC NOT FOUND ***");
						}
					} else {
						System.out.println("*** USER NOT FOUND ***");
					}
					break;
				case 4:
					System.out.println("*** Your Patients are : ***");
					for (int paID : d.getPatients()) {
						System.out.println(HealthMinistry.getPai(paID).toString());
					}
					break;
				case 5:
					System.out.println("*** Bye!!!  ***");
					stay = false;
					break;
				default:
					System.out.println("Wrong choice, Try again");
					break;
			}
		}
	}

	public static void adminPanel() {
		boolean stay = true;
		Scanner sc = new Scanner(System.in);

		while (stay) {

			System.out.println("*** What do you want to do ***");
			System.out.print("\t**********************************************************************************************\n");
			System.out.print("\t*                                                                                            *\n");
			System.out.print("\t*                  1.Edit Password                                                           *\n");
			System.out.print("\t*                  2.ADD Doctor                                                              *\n");
			System.out.print("\t*                  3.ADD Patient                                                             *\n");
			System.out.print("\t*                  4.ADD Univercity                                                          *\n");
			System.out.print("\t*                  5.ADD Drug                                                                *\n");
			System.out.print("\t*                  6.ADD Pharmacy                                                            *\n");
			System.out.print("\t*                  7.Exit                                                                    *\n");
			System.out.print("\t**********************************************************************************************\n");
			int sl = sc.nextInt();
			sc.nextLine();
			switch (sl) {
				case 1:
					System.out.println("*** Enter new Password ***");
					HealthMinistry.setAdminPass(sc.nextLine());
					System.out.println("*** Done ***");
					break;
				case 2:
					System.out.println("*** Enter specialization***");
					System.out.print("\t**********************************************************************************************\n");
					System.out.print("\t*                                                                                            *\n");
					System.out.print("\t*                  1.General                                                                 *\n");
					System.out.print("\t*                  2.AllergyAndImmunology                                                    *\n");
					System.out.print("\t*                  3.Anesthesiology                                                          *\n");
					System.out.print("\t*                  4.Dermatology                                                             *\n");
					System.out.print("\t*                  5.DiagnosticRadiology                                                     *\n");
					System.out.print("\t*                  6.InternalMedicine                                                        *\n");
					System.out.print("\t*                  7.MedicalGenetics                                                         *\n");
					System.out.print("\t*                  8.Neurology                                                               *\n");
					System.out.print("\t*                  9.Pathology                                                               *\n");
					System.out.print("\t*                  10.Urology                                                                *\n");
					System.out.print("\t**********************************************************************************************\n");
					int slc = sc.nextInt();
					sc.nextLine();
					diseaseType dt;
					switch (slc) {
						case 1:
							dt = diseaseType.General;
							break;
						case 2:
							dt = diseaseType.AllergyAndImmunology;
							break;
						case 3:
							dt = diseaseType.Anesthesiology;
							break;
						case 4:
							dt = diseaseType.Dermatology;
							break;
						case 5:
							dt = diseaseType.DiagnosticRadiology;
							break;
						case 6:
							dt = diseaseType.InternalMedicine;
							break;
						case 7:
							dt = diseaseType.MedicalGenetics;
							break;
						case 8:
							dt = diseaseType.Neurology;
							break;
						case 9:
							dt = diseaseType.Pathology;
							break;
						case 10:
							dt = diseaseType.Urology;
							break;
						default:
							System.out.println("Not Valid");
							return;
					}
					System.out.println("enter doc ID");
					int docID = sc.nextInt();
					sc.nextLine();
					System.out.println("enter doc first name");
					String fName = sc.nextLine();
					System.out.println("enter doc last name");
					String lName = sc.nextLine();
					Doctor d = new Doctor(dt, docID, fName, lName);
					HealthMinistry.adddList(d);
					break;
				case 3:
					System.out.println("enter Patient ID");
					int pID = sc.nextInt();
					sc.nextLine();
					System.out.println("enter Patient first name");
					String pfName = sc.nextLine();
					System.out.println("enter Patient last name");
					String plName = sc.nextLine();
					Patient p = new Patient(pID, pfName, plName);
					HealthMinistry.addpList(p);
					break;
				case 4:
					System.out.println("enter University ID");
					int uID = sc.nextInt();
					sc.nextLine();
					System.out.println("enter Patient first name");
					String uName = sc.nextLine();
					University u = new University(uID, uName);
					HealthMinistry.adduList(u);
					break;
				case 5:
					System.out.println("*** not now  ***");
					break;
				case 6:
					System.out.println("*** not now  ***");
					break;
				case 7:
					System.out.println("*** Bye!!!  ***");
					stay = false;
					break;
				default:
					System.out.println("Wrong choice, Try again");
					break;
			}
		}
	}

	public static void main(String[] args) {
		try {
			boolean stay = true;
			Scanner sc = new Scanner(System.in);
			String chk;

			System.out.println("\t*********************************************Reading Files*********************************************");
			FileManager.readAll();

			while (stay) {

				System.out.println("*** What do you want to do ***");
				System.out.print("\t**********************************************************************************************\n");
				System.out.print("\t*                                                                                            *\n");
				System.out.print("\t*                  1.Admin                                                                   *\n");
				System.out.print("\t*                  2.Doctor                                                                  *\n");
				System.out.print("\t*                  3.Patient                                                                 *\n");
				System.out.print("\t*                  4.Exit                                                                    *\n");
				System.out.print("\t**********************************************************************************************\n");
				int sl = sc.nextInt();
				sc.nextLine();
				switch (sl) {
					case 1:
						System.out.println("*** Enter Pass  ***");
						chk = sc.nextLine();
						if (HealthMinistry.getAdminPass().equals(chk)) {
							adminPanel();
						} else {
							System.out.println("*** Wrong Pass  ***");
						}
						break;
					case 2:
						System.out.println("*** Enter ID  ***");
						int docID = sc.nextInt();
						sc.nextLine();
						Doctor d = HealthMinistry.getDoc(docID);
						System.out.println("*** Enter Pass  ***");
						chk = sc.nextLine();
						if (d.getDocPass().equals(chk)) {
							doctorPanel(d);
						} else {
							System.out.println("*** Wrong Pass  ***");
						}
						break;
					case 3:
						System.out.println("*** Enter ID  ***");
						int pID = sc.nextInt();
						sc.nextLine();
						Patient p = HealthMinistry.getPai(pID);
						System.out.println("*** Enter Pass  ***");
						chk = sc.nextLine();
						if (p.getPatientPass().equals(chk)) {
							patientPanel(p);
						} else {
							System.out.println("*** Wrong Pass  ***");
						}
						break;
					case 4:
						System.out.println("\t*********************************************Writeing Files*********************************************");
						try {
							FileManager.writeAll();
							System.out.println("*** Bye!!!  ***");
							stay = false;
						} catch (IOException ex) {
							Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
						} catch (ClassNotFoundException ex) {
							Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
						}
						break;
					default:
						System.out.println("Wrong choice, Try again");
						break;

				}

			}
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
