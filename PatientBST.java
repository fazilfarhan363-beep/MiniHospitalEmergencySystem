public class PatientBST {

    PatientNode root;

    public PatientBST() {
        root = null;
    }

    // INSERT
    public void insert(Patient patient) {

        root = insertRecursive(root, patient);
    }

    private PatientNode insertRecursive(PatientNode root, Patient patient) {

        if (root == null) {
            return new PatientNode(patient);
        }

        if (patient.patientId < root.patient.patientId) {

            root.left = insertRecursive(root.left, patient);
        }
        else if (patient.patientId > root.patient.patientId) {

            root.right = insertRecursive(root.right, patient);
        }

        return root;
    }
    // SEARCH
public Patient search(int patientId) {

    PatientNode current = root;

    while (current != null) {

        if (patientId == current.patient.patientId) {
            return current.patient;
        }

        if (patientId < current.patient.patientId) {
            current = current.left;
        }
        else {
            current = current.right;
        }
    }

    return null;
}
// IN-ORDER TRAVERSAL
public void inOrder() {
    inOrderRecursive(root);
}

private void inOrderRecursive(PatientNode root) {

    if (root != null) {

        inOrderRecursive(root.left);

        root.patient.displayPatient();
        System.out.println("--------------------");

        inOrderRecursive(root.right);
    }
}
// DELETE
public void delete(int patientId) {
    root = deleteRecursive(root, patientId);
}

private PatientNode deleteRecursive(PatientNode root, int patientId) {

    // Patient not found
    if (root == null) {
        return null;
    }

    // Search in left subtree
    if (patientId < root.patient.patientId) {
        root.left = deleteRecursive(root.left, patientId);
    }

    // Search in right subtree
    else if (patientId > root.patient.patientId) {
        root.right = deleteRecursive(root.right, patientId);
    }

    // Patient found
    else {

        // Case 1: No child
        if (root.left == null && root.right == null) {
            return null;
        }

        // Case 2: Only right child
        if (root.left == null) {
            return root.right;
        }

        // Case 2: Only left child
        if (root.right == null) {
            return root.left;
        }

        // Case 3: Two children
        PatientNode successor = findMinimum(root.right);

        root.patient = successor.patient;

        root.right = deleteRecursive(
                root.right,
                successor.patient.patientId
        );
    }

    return root;
}

// Find the smallest patient ID
private PatientNode findMinimum(PatientNode root) {

    PatientNode current = root;

    while (current.left != null) {
        current = current.left;
    }

    return current;
}
}