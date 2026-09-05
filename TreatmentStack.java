public class TreatmentStack {

    TreatmentRecord[] stack;
    int top;

    // Constructor
    public TreatmentStack(int capacity) {

        stack = new TreatmentRecord[capacity];
        top = -1;
    }

    // PUSH - Add completed treatment
    public void push(TreatmentRecord treatment) {

        if (top == stack.length - 1) {

            System.out.println("Treatment stack is full.");
            return;
        }

        top++;

        stack[top] = treatment;

        System.out.println("Treatment record added to stack.");
    }

    // POP - Remove latest treatment
    public TreatmentRecord pop() {

        if (top == -1) {

            System.out.println("Treatment stack is empty.");
            return null;
        }

        TreatmentRecord treatment = stack[top];

        stack[top] = null;

        top--;

        return treatment;
    }

    // DISPLAY - Show treatment records
    public void displayStack() {

        if (top == -1) {

            System.out.println("Treatment stack is empty.");
            return;
        }

        System.out.println("\nTreatment History:");

        for (int i = top; i >= 0; i--) {

            System.out.println("--------------------");

            System.out.println(stack[i]);
        }

        System.out.println("--------------------");
    }
}
