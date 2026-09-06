
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PatientBST bst = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue(10);
        TreatmentStack treatmentStack = new TreatmentStack(10);
        VisitHistory visitHistory = new VisitHistory();

        int choice;

        do {

            System.out.println("\n==============================================");
            System.out.println(" MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
            System.out.println("==============================================");

            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display Patients");
            System.out.println("5. Add Emergency Patient");
            System.out.println("6. Treat Next Patient");
            System.out.println("7. Display Emergency Queue");
            System.out.println("8. Add Treatment");
            System.out.println("9. Remove Latest Treatment");
            System.out.println("10. Display Treatment History");
            System.out.println("11. Add Patient Visit");
            System.out.println("12. Search Visit");
            System.out.println("13. Remove Visit");
            System.out.println("14. Display Visit History");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // =====================================
                // 1. ADD PATIENT
                // =====================================
                case 1:

                    System.out.println("\n===== ADD PATIENT =====");

                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.nextLine();

                    System.out.print("Enter Medical Condition: ");
                    String medicalCondition = scanner.nextLine();

                    Patient patient = new Patient(
                            patientId,
                            patientName,
                            age,
                            contactNumber,
                            medicalCondition
                    );

                    bst.insert(patient);

                    System.out.println("Patient added successfully.");

                    break;


                // =====================================
                // 2. SEARCH PATIENT
                // =====================================
                case 2:

                    System.out.println("\n===== SEARCH PATIENT =====");

                    System.out.print("Enter Patient ID: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    Patient foundPatient = bst.search(searchId);

                    if (foundPatient != null) {

                        System.out.println("\nPatient Found:");
                        foundPatient.displayPatient();

                    } else {

                        System.out.println("Patient not found.");
                    }

                    break;


                // =====================================
                // 3. DELETE PATIENT
                // =====================================
                case 3:

                    System.out.println("\n===== DELETE PATIENT =====");

                    System.out.print("Enter Patient ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    Patient patientToDelete = bst.search(deleteId);

                    if (patientToDelete != null) {

                        bst.delete(deleteId);

                        System.out.println("Patient deleted successfully.");

                    } else {

                        System.out.println("Patient not found.");
                    }

                    break;


                // =====================================
                // 4. DISPLAY PATIENTS
                // =====================================
                case 4:
                     System.out.println("\n===== PATIENT RECORDS (BST) =====");
                     bst.inOrder();
                     break;


                // =====================================
                // 5. ADD EMERGENCY PATIENT
                // =====================================
                case 5:

                    System.out.println("\n===== ADD EMERGENCY PATIENT =====");

                    System.out.print("Enter Patient ID: ");
                    int emergencyId = scanner.nextInt();
                    scanner.nextLine();

                    Patient emergencyPatient = bst.search(emergencyId);

                    if (emergencyPatient != null) {

                        emergencyQueue.enqueue(emergencyPatient);

                    } else {

                        System.out.println("Patient not found in patient records.");
                    }

                    break;


                // =====================================
                // 6. TREAT NEXT PATIENT
                // =====================================
                case 6:

                    System.out.println("\n===== TREAT NEXT PATIENT =====");

                    Patient nextPatient = emergencyQueue.dequeue();

                    if (nextPatient != null) {

                        System.out.println("\nPatient sent for treatment:");
                        nextPatient.displayPatient();

                    }

                    break;


                // =====================================
                // 7. DISPLAY EMERGENCY QUEUE
                // =====================================
                case 7:

                    System.out.println("\n===== EMERGENCY QUEUE =====");

                    emergencyQueue.displayQueue();

                    break;


                // =====================================
                // 8. ADD TREATMENT
                // =====================================
                case 8:

                    System.out.println("\n===== ADD TREATMENT =====");

                    System.out.print("Enter Treatment ID: ");
                    String treatmentId = scanner.nextLine();

                    System.out.print("Enter Patient ID: ");
                    int treatmentPatientId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Treatment Date: ");
                    String treatmentDate = scanner.nextLine();

                    System.out.print("Enter Treatment Description: ");
                    String treatmentDescription = scanner.nextLine();

                    TreatmentRecord treatment = new TreatmentRecord(treatmentId,
                            treatmentPatientId,
                            treatmentDate,
                            treatmentDescription
                    );

                    treatmentStack.push(treatment);

                    break;


                // =====================================
                // 9. REMOVE LATEST TREATMENT
                // =====================================
                case 9:

                    System.out.println("\n===== REMOVE LATEST TREATMENT =====");

                    TreatmentRecord latestTreatment = treatmentStack.pop();

                    if (latestTreatment != null) {

                        System.out.println("\nLatest Treatment Removed:");
                        latestTreatment.displayTreatment();

                    }

                    break;


                // =====================================
                // 10. DISPLAY TREATMENT HISTORY
                // =====================================
                case 10:

                    System.out.println("\n===== TREATMENT HISTORY =====");

                    treatmentStack.displayStack();

                    break;


                // =====================================
                // 11. ADD PATIENT VISIT
                // =====================================
                case 11:

                    System.out.println("\n===== ADD PATIENT VISIT =====");

                    System.out.print("Enter Visit ID: ");
                    String visitId = scanner.nextLine();

                    System.out.print("Enter Visit Date: ");
                    String visitDate = scanner.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String doctorName = scanner.nextLine();

                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = scanner.nextLine();

                    System.out.print("Enter Treatment: ");
                    String visitTreatment = scanner.nextLine();

                    Visit visit = new Visit(
                            visitId,
                            visitDate,
                            doctorName,
                            diagnosis,
                            visitTreatment
                    );

                    visitHistory.addVisit(visit);

                    break;


                // =====================================
                // 12. SEARCH VISIT
                // =====================================
                case 12:

                    System.out.println("\n===== SEARCH VISIT =====");

                    System.out.print("Enter Visit ID: ");
                    String searchVisitId = scanner.nextLine();

                    Visit foundVisit = visitHistory.searchVisit(searchVisitId);

                    if (foundVisit != null) {

                        System.out.println("\nVisit Found:");
                        foundVisit.displayVisit();

                    } else {

                        System.out.println("Visit not found.");
                    }

                    break;


                // =====================================
                // 13. REMOVE VISIT
                // =====================================
                case 13:

                    System.out.println("\n===== REMOVE VISIT =====");

                    System.out.print("Enter Visit ID to remove: ");
                    String removeVisitId = scanner.nextLine();

                    visitHistory.removeVisit(removeVisitId);

                    break;


                // =====================================
                // 14. DISPLAY VISIT HISTORY
                // =====================================
                case 14:

                    System.out.println("\n===== PATIENT VISIT HISTORY =====");

                    visitHistory.displayHistory();

                    break;


                // =====================================
                // 0. EXIT
                // =====================================
                case 0:

                    System.out.println("\nThank you for using the system.");
                    System.out.println("Program ended.");

                    break;


                // =====================================
                // INVALID CHOICE
                // =====================================
                default:

                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 0);


        scanner.close();
    
}

    }
