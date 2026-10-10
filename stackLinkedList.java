import java.util.Scanner;

// Each Node1 holds one value and a link to the next node
class Node1 {
    int data1;
    Node1 next1;

    Node1(int data1) {
        this.data1 = data1;
        this.next1 = null;
    }
}

// Stack built using a linked list (LIFO: Last In, First Out)
class Stack1 {
    private Node1 top1;   // the top of the stack
    private int size1;    // number of items in the stack

    Stack1() {
        top1 = null;
        size1 = 0;
    }

    // Add an item on top of the stack
    void push1(int value1) {
        Node1 newNode1 = new Node1(value1);
        newNode1.next1 = top1;   // new node points to the old top
        top1 = newNode1;         // new node becomes the top
        size1++;
        System.out.println(value1 + " pushed to stack.");
    }

    // Remove and return the top item
    int pop1() {
        if (isEmpty1()) {
            System.out.println("Stack is empty! Nothing to pop.");
            return -1;
        }
        int value1 = top1.data1;
        top1 = top1.next1;       // move top to the next node
        size1--;
        System.out.println(value1 + " popped from stack.");
        return value1;
    }

    // Look at the top item without removing it
    int peek1() {
        if (isEmpty1()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return top1.data1;
    }

    boolean isEmpty1() {
        return top1 == null;
    }

    int getSize1() {
        return size1;
    }

    // Print all items from top to bottom
    void display1() {
        if (isEmpty1()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Stack (top to bottom):");
        Node1 current1 = top1;
        while (current1 != null) {
            System.out.println(current1.data1);
            current1 = current1.next1;
        }
    }
}

public class stackLinkedList {
    public static void main(String[] args) {
        Stack1 stack1 = new Stack1();
        Scanner scanner1 = new Scanner(System.in);
        int choice1;

        do {
            System.out.println("\n===== STACK MENU =====");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice1 = scanner1.nextInt();

            switch (choice1) {
                case 1:
                    System.out.print("Enter a number to push: ");
                    int value1 = scanner1.nextInt();
                    stack1.push1(value1);
                    break;
                case 2:
                    stack1.pop1();
                    break;
                case 3:
                    if (!stack1.isEmpty1()) {
                        System.out.println("Top element: " + stack1.peek1());
                    } else {
                        System.out.println("Stack is empty!");
                    }
                    break;
                case 4:
                    stack1.display1();
                    break;
                case 5:
                    System.out.println("Stack size: " + stack1.getSize1());
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
