import java.util.Scanner;

public class Testing {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue(10);
        TreatmentStack stack = new TreatmentStack(10);
        VisitHistory history = new VisitHistory();

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println(" DATA STRUCTURE TESTING");
            System.out.println("================================");

            System.out.println("1. Test BST");
            System.out.println("2. Test Queue");
            System.out.println("3. Test Stack");
            System.out.println("4. Test Linked List");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n===== BST TEST =====");

                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contact = scanner.nextLine();

                    System.out.print("Enter Medical Condition: ");
                    String condition = scanner.nextLine();

                    Patient patient = new Patient(
                            id, name, age, contact, condition
                    );

                    bst.insert(patient);

                    System.out.println("Patient inserted successfully.");

                    System.out.print("Enter Patient ID to search: ");
                    int searchId = scanner.nextInt();

                    Patient found = bst.search(searchId);

                    if (found != null) {
                        System.out.println("BST Search: PASS");
                        found.displayPatient();
                    } else {
                        System.out.println("BST Search: FAIL");
                    }

                    break;

                case 2:

                    System.out.println("\n===== QUEUE TEST =====");

                    System.out.print("Enter Patient ID: ");
                    int queueId = scanner.nextInt();
                    scanner.nextLine();

                    Patient queuePatient = new Patient(
                            queueId,
                            "Test Patient",
                            25,
                            "0771234567",
                            "Fever"
                    );

                    queue.enqueue(queuePatient);

                    System.out.println("Queue Enqueue: PASS");

                    Patient treated = queue.dequeue();

                    if (treated != null) {
                        System.out.println("Queue Dequeue: PASS");
                        treated.displayPatient();
                    } else {
                        System.out.println("Queue Dequeue: FAIL");
                    }

                    break;

                case 3:

                    System.out.println("\n===== STACK TEST =====");

                    System.out.print("Enter Treatment ID: ");
                    String treatmentId = scanner.nextLine();

                    System.out.print("Enter Patient ID: ");
                    int treatmentPatientId = scanner.nextInt();
                    scanner.nextLine();

                    TreatmentRecord treatment = new TreatmentRecord(
                            treatmentId,
                            treatmentPatientId,
                            "2026-09-06",
                            "Test treatment"
                    );

                    stack.push(treatment);

                    System.out.println("Stack Push: PASS");

                    TreatmentRecord removed = stack.pop();

                    if (removed != null) {
                        System.out.println("Stack Pop: PASS");
                        removed.displayTreatment();
                    } else {
                        System.out.println("Stack Pop: FAIL");
                    }

                    break;

                case 4:

                    System.out.println("\n===== LINKED LIST TEST =====");

                    System.out.print("Enter Visit ID: ");
                    String visitId = scanner.nextLine();

                    Visit visit = new Visit(
                            visitId,
                            "2026-09-06",
                            "Dr. Kumar",
                            "Fever",
                            "Paracetamol"
                    );

                    history.addVisit(visit);

                    System.out.println("Linked List Add: PASS");

                    System.out.print("Enter Visit ID to search: ");
                    String searchVisitId = scanner.nextLine();

                    Visit foundVisit = history.searchVisit(searchVisitId);

                    if (foundVisit != null) {
                        System.out.println("Linked List Search: PASS");
                        foundVisit.displayVisit();
                    } else {
                        System.out.println("Linked List Search: FAIL");
                    }

                    break;

                case 0:

                    System.out.println("Testing completed.");
                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
    }
}