import java.util.*;

public class Array {

    static final int CAPACITY = 10;       // maximum number of elements
    static int[] arr = new int[CAPACITY];
    static int current = -1;             // index of last occupied element
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== ARRAY MENU =====");
            System.out.println("1. Add value");
            System.out.println("2. Insert at index");
            System.out.println("3. Fill array");
            System.out.println("4. Delete last element");
            System.out.println("5. Delete by index");
            System.out.println("6. Display");
            System.out.println("7. Search value");
            System.out.println("8. Get value at index");
            System.out.println("9. Replace/Update value at index");
            System.out.println("10. Size");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number.");
                sc.next();
                choice = 0;
                continue;
            }

            choice = sc.nextInt();

            if (choice == 1) {
                addValue();
            }
            else if (choice == 2) {
                insertAtIndex();
            }
            else if (choice == 3) {
                fillArray();
            }
            else if (choice == 4) {
                deleteLast();
            }
            else if (choice == 5) {
                deleteByIndex();
            }
            else if (choice == 6) {
                display();
            }
            else if (choice == 7) {
                searchValue();
            }
            else if (choice == 8) {
                getValueAtIndex();
            }
            else if (choice == 9) {
                replaceValue();
            }
            else if (choice == 10) {
                showSize();
            }
            else if (choice == 11) {
                System.out.println("Exiting program. Goodbye!");
            }
            else {
                System.out.println("Invalid choice. Please select a valid menu option.");
            }

        } while (choice != 11);

        sc.close();
    }


    // 1. Add a value to the end of the array
    static void addValue() {

        if (current == CAPACITY - 1) {
            System.out.println("OVERFLOW! Array is full. Cannot add more values.");
            return;
        }

        System.out.print("Enter value to add: ");
        int val = sc.nextInt();

        current++;
        arr[current] = val;

        System.out.println("Value added successfully.");
    }


    // 2. Insert a value at a specific index
    static void insertAtIndex() {

        if (current == CAPACITY - 1) {
            System.out.println("OVERFLOW! Array is full. Cannot insert more values.");
            return;
        }

        System.out.print("Enter index to insert at (0 to "
                + (current + 1) + "): ");
        int index = sc.nextInt();

        if (index < 0 || index > current + 1) {
            System.out.println("Invalid index.");
            return;
        }

        System.out.print("Enter value to insert: ");
        int val = sc.nextInt();

        // Shift elements one position to the right
        for (int j = current; j >= index; j--) {
            arr[j + 1] = arr[j];
        }

        arr[index] = val;
        current++;

        System.out.println("Value inserted successfully.");
    }


    // 3. Fill the array with multiple values
    static void fillArray() {

        if (current == CAPACITY - 1) {
            System.out.println("Array is already full.");
            return;
        }

        System.out.println(
                "Enter values one by one. Enter -9999 to stop early."
        );

        while (current < CAPACITY - 1) {

            System.out.print("Enter value (" +
                    (current + 1) + "/" + CAPACITY + "): ");

            int val = sc.nextInt();

            if (val == -9999) {
                System.out.println("Stopped by user.");
                break;
            }

            current++;
            arr[current] = val;
        }

        if (current == CAPACITY - 1) {
            System.out.println("Array is now full.");
        }
    }


    // 4. Delete the last element
    static void deleteLast() {

        if (current == -1) {
            System.out.println(
                    "UNDERFLOW! Array is empty. Nothing to delete."
            );
            return;
        }

        int deletedValue = arr[current];

        current--;

        System.out.println("Deleted value: " + deletedValue);
    }


    // 5. Delete a value at a specific index
    static void deleteByIndex() {

        if (current == -1) {
            System.out.println(
                    "UNDERFLOW! Array is empty. Nothing to delete."
            );
            return;
        }

        System.out.print(
                "Enter index to delete (0 to " + current + "): "
        );

        int index = sc.nextInt();

        if (index < 0 || index > current) {
            System.out.println("Invalid index.");
            return;
        }

        int deletedValue = arr[index];

        // Shift elements one position to the left
        for (int j = index; j < current; j++) {
            arr[j] = arr[j + 1];
        }

        current--;

        System.out.println("Deleted value: " + deletedValue);
    }


    // 6. Display all elements
    static void display() {

        if (current == -1) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.print("Array elements: ");

        for (int i = 0; i <= current; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }


    // 7. Search for a value
    static void searchValue() {

        if (current == -1) {
            System.out.println(
                    "Array is empty. Nothing to search."
            );
            return;
        }

        System.out.print("Enter value to search: ");
        int val = sc.nextInt();

        boolean found = false;

        System.out.print("Value found at index/indexes: ");

        for (int i = 0; i <= current; i++) {

            if (arr[i] == val) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Element Not Found!");
        }
        else {
            System.out.println();
        }
    }


    // 8. Get value at a specific index
    static void getValueAtIndex() {

        if (current == -1) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.print(
                "Enter index (0 to " + current + "): "
        );

        int index = sc.nextInt();

        if (index < 0 || index > current) {
            System.out.println("Invalid index.");
            return;
        }

        System.out.println(
                "Value at index " + index + " is " + arr[index]
        );
    }


    // 9. Replace / Update value
    static void replaceValue() {

        if (current == -1) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.print(
                "Enter index to update (0 to " + current + "): "
        );

        int index = sc.nextInt();

        if (index < 0 || index > current) {
            System.out.println("Invalid index.");
            return;
        }

        System.out.print("Enter new value: ");
        int val = sc.nextInt();

        arr[index] = val;

        System.out.println("Value updated successfully.");
    }


    // 10. Show current number of elements
    static void showSize() {

        System.out.println(
                "Current number of elements: " + (current + 1)
        );
    }
}
