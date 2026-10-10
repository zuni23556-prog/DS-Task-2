import java.util.*;
public class Queue {

    static final int MAXSIZE = 10;
    static int[] queue = new int[MAXSIZE + 1];
    static int front = 0;
    static int rear = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n===== QUEUE OPERATIONS MENU =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            if (choice == 1) {
                enqueue(sc);
            } else if (choice == 2) {
                dequeue();
            } else if (choice == 3) {
                display();
            } else if (choice == 4) {
                showSize();
            } else if (choice == 5) {
                isEmpty();
            } else if (choice == 6) {
                isFull();
            } else if (choice == 7) {
                System.out.println("Exiting program. Goodbye!");
            } else {
                System.out.println("Invalid choice. Please select a valid menu option.");
            }

        } while (choice != 7);

        sc.close();
    }

    static void enqueue(Scanner sc) {
        if (rear == MAXSIZE) {
            System.out.println("OVERFLOW! Queue is full. Cannot enqueue more values.");
            return;
        }

        System.out.print("Enter token number to enqueue: ");
        int val = sc.nextInt();

        rear = rear + 1;
        queue[rear] = val;

        if (front == 0) {
            front = 1;
        }

        System.out.println("Token enqueued successfully.");
    }

    static void dequeue() {
        if (front == 0) {
            System.out.println("UNDERFLOW! Queue is empty. Cannot dequeue.");
            return;
        }

        int dequeuedValue = queue[front];

        if (front == rear) {
            front = 0;
            rear = 0;
        } else {
            front = front + 1;
        }

        System.out.println("Dequeued token: " + dequeuedValue);
    }

    static void display() {
        if (front == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue (front to rear): ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    static void showSize() {
        if (front == 0) {
            System.out.println("Current number of elements: 0");
        } else {
            System.out.println("Current number of elements: " + (rear - front + 1));
        }
    }

    static void isEmpty() {
        if (front == 0) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue is not empty.");
        }
    }

    static void isFull() {
        if (rear == MAXSIZE) {
            System.out.println("Queue is full.");
        } else {
            System.out.println("Queue is not full.");
        }
    }
}
