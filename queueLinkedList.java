import java.util.Scanner;

class Node2 {
    int data1;
    Node1 next1;

    Node2(int data1) {
        this.data1 = data1;
        this.next1 = null;
    }
}

// Queue built using a linked list (FIFO: First In, First Out)
class Queue1 {
    private Node1 front1;
    private Node1 rear1;
    private int size1;

    Queue1() {
        front1 = null;
        rear1 = null;
        size1 = 0;
    }

    // Add an item at the rear (back) of the queue
    void enqueue1(int value1) {
        Node1 newNode1 = new Node1(value1);
        if (isEmpty1()) {
            front1 = newNode1;        // first node is both front and rear
            rear1 = newNode1;
        } else {
            rear1.next1 = newNode1;   // link old rear to the new node
            rear1 = newNode1;         // new node becomes the rear
        }
        size1++;
        System.out.println(value1 + " enqueued to queue.");
    }

    // Remove and return the item at the front
    int dequeue1() {
        if (isEmpty1()) {
            System.out.println("Queue is empty! Nothing to dequeue.");
            return -1;
        }
        int value1 = front1.data1;
        front1 = front1.next1;        // move front to the next node
        if (front1 == null) {
            rear1 = null;             // queue became empty
        }
        size1--;
        System.out.println(value1 + " dequeued from queue.");
        return value1;
    }

    // Look at the front item without removing it
    int peek1() {
        if (isEmpty1()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front1.data1;
    }

    boolean isEmpty1() {
        return front1 == null;
    }

    int getSize1() {
        return size1;
    }

    // Print all items from front to rear
    void display1() {
        if (isEmpty1()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Queue (front to rear):");
        Node1 current1 = front1;
        while (current1 != null) {
            System.out.print(current1.data1 + " ");
            current1 = current1.next1;
        }
        System.out.println();
    }
}

public class queueLinkedList {
    public static void main(String[] args) {
        Queue1 queue1 = new Queue1();
        Scanner scanner1 = new Scanner(System.in);
        int choice1;

        do {
            System.out.println("\n===== QUEUE MENU =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice1 = scanner1.nextInt();

            switch (choice1) {
                case 1:
                    System.out.print("Enter a number to enqueue: ");
                    int value1 = scanner1.nextInt();
                    queue1.enqueue1(value1);
                    break;
                case 2:
                    queue1.dequeue1();
                    break;
                case 3:
                    if (!queue1.isEmpty1()) {
                        System.out.println("Front element: " + queue1.peek1());
                    } else {
                        System.out.println("Queue is empty!");
                    }
                    break;
                case 4:
                    queue1.display1();
                    break;
                case 5:
                    System.out.println("Queue size: " + queue1.getSize1());
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice1 != 6);

        scanner1.close();
    }
}