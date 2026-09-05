public class EmergencyQueue {

    Patient[] queue;
    int front;
    int rear;
    int size;

    // Constructor
    public EmergencyQueue(int capacity) {

        queue = new Patient[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // ENQUEUE
    public void enqueue(Patient patient) {

        if (size == queue.length) {
            System.out.println("Queue is full.");
            return;
        }

        rear++;

        queue[rear] = patient;

        size++;

        System.out.println("Patient added to emergency queue.");
    }

    // DEQUEUE
    public Patient dequeue() {

        if (size == 0) {
            System.out.println("Queue is empty.");
            return null;
        }

        Patient patient = queue[front];

        front++;

        size--;

        return patient;
    }

    // DISPLAY
    public void displayQueue() {

        if (size == 0) {
            System.out.println("Queue is empty. No patients waiting.");
            return;
        }

        System.out.println("\nPatients Waiting in Emergency Queue:");

        for (int i = front; i <= rear; i++) {

            System.out.println("--------------------");

            queue[i].displayPatient();
        }

        System.out.println("--------------------");
    }
}
