import java.util.*;

public class Stack {

    static final int MAXSTK = 10;
    static int[] stack = new int[MAXSTK];
    static int top = -1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice; // Choice ko loop se pehle declare karna lazmi hai

        do {
            System.out.println("\n===== STACK OPERATIONS MENU =====");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Peek");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number.");
                sc.next();
                choice = 0;
                continue;
            }

            choice = sc.nextInt();

            if (choice == 1) {
                push();
            } else if (choice == 2) {
                pop();
            } else if (choice == 3) {
                display();
            } else if (choice == 4) {
                peek();
            } else if (choice == 5) {
                isEmpty();
            } else if (choice == 6) {
                isFull();
            } else if (choice == 7) {
                System.out.println("Exiting Stack program. Goodbye!");
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }

        } while (choice != 7);

        sc.close();
    }

    // 1. Push
    static void push() {
        if (top == MAXSTK - 1) {
            System.out.println("OVERFLOW! Stack is full.");
            return;
        }
        System.out.print("Enter value to push: ");
        int val = sc.nextInt();
        top++;
        stack[top] = val;
        System.out.println("Value pushed successfully.");
    }

    // 2. Pop
    static void pop() {
        if (top == -1) {
            System.out.println("UNDERFLOW! Stack is empty.");
            return;
        }
        System.out.println("Popped value: " + stack[top]);
        top--;
    }

    // 3. Display
    static void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // 4. Peek
    static void peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Top element is: " + stack[top]);
    }

    // 5. isEmpty
    static void isEmpty() {
        if (top == -1) {
            System.out.println("Stack is EMPTY.");
        } else {
            System.out.println("Stack is NOT empty.");
        }
    }

    // 6. isFull
    static void isFull() {
        if (top == MAXSTK - 1) {
            System.out.println("Stack is FULL.");
        } else {
            System.out.println("Stack is NOT full.");
        }
    }
}
