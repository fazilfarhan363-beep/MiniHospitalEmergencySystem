public class VisitHistory {

    VisitNode head;

    // Constructor
    public VisitHistory() {
        head = null;
    }

    // ADD VISIT
    public void addVisit(Visit visit) {

        VisitNode newNode = new VisitNode(visit);

        if (head == null) {
            head = newNode;
        }
        else {
            VisitNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Visit added successfully.");
    }

    // REMOVE VISIT
    public void removeVisit(String visitId) {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.visit.visitId.equals(visitId)) {
            head = head.next;
            System.out.println("Visit removed successfully.");
            return;
        }

        VisitNode current = head;

        while (current.next != null) {

            if (current.next.visit.visitId.equals(visitId)) {

                current.next = current.next.next;

                System.out.println("Visit removed successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }

    // SEARCH VISIT
    public Visit searchVisit(String visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visit.visitId.equals(visitId)) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    // DISPLAY VISIT HISTORY
    public void displayHistory() {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        System.out.println("\nPatient Visit History:");

        VisitNode current = head;

        while (current != null) {

            System.out.println("--------------------");

            current.visit.displayVisit();

            current = current.next;
        }

        System.out.println("--------------------");
    }
}
