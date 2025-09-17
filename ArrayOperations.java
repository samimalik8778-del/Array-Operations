import java.util.Scanner;

public class ArrayOperations {
    static int[] arr = new int[10]; 
    static int size = 0; 

    
    public static void traverse() {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        System.out.print("Array Elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    
    public static void insertAtBeg(int val) {
        if (size < arr.length) {
            for (int i = size; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = val;
            size++;
            System.out.println("Element inserted at the beginning.");
        } else {
            System.out.println("Array is full, cannot insert.");
        }
    }

    
    public static void insertAtPos(int val, int pos) {
        if (pos < 1 || pos > size + 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (size < arr.length) {
            for (int i = size; i >= pos; i--) {
                arr[i] = arr[i - 1];
            }
            arr[pos - 1] = val;
            size++;
            System.out.println("Element inserted at position " + pos);
        } else {
            System.out.println("Array is full, cannot insert.");
        }
    }

   
    public static void insertAtEnd(int val) {
        if (size < arr.length) {
            arr[size] = val;
            size++;
            System.out.println("Element inserted at the end.");
        } else {
            System.out.println("Array is full, cannot insert.");
        }
    }

   
    public static void deleteBeg() {
        if (size == 0) {
            System.out.println("Array is empty, nothing to delete.");
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        System.out.println("Element deleted from the beginning.");
    }

    
    public static void deletePos(int pos) {
        if (pos < 1 || pos > size) {
            System.out.println("Invalid position!");
            return;
        }
        for (int i = pos - 1; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        System.out.println("Element deleted from position " + pos);
    }

    
    public static void deleteEnd() {
        if (size == 0) {
            System.out.println("Array is empty, nothing to delete.");
            return;
        }
        size--;
        System.out.println("Element deleted from the end.");
    }

  
    public static void search(int key) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                System.out.println("Element " + key + " found at index " + i);
                return;
            }
        }
        System.out.println("Element " + key + " not found in the array.");
    }

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int choice, val, pos;

        while (true) {
            System.out.println("============================");
            System.out.println("       ARRAY OPERATIONS MENU");
            System.out.println("============================");
            System.out.println("1. Traversal");
            System.out.println("2. Insert Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Search Element");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = S.nextInt();

            switch (choice) {
                case 1:
                    traverse();
                    break;

                case 2:
                    System.out.println("1. Insert at Beginning");
                    System.out.println("2. Insert at Given Position");
                    System.out.println("3. Insert at End");
                    System.out.print("Choose the insertion type: ");
                    int insertChoice = S.nextInt();
                    System.out.print("Enter the element to insert: ");
                    val = S.nextInt();
                    switch (insertChoice) {
                        case 1:
                            insertAtBeg(val);
                            break;
                        case 2:
                            System.out.print("Enter the position: ");
                            pos = S.nextInt();
                            insertAtPos(val, pos);
                            break;
                        case 3:
                            insertAtEnd(val);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 3:
                    System.out.println("1. Delete from Beginning");
                    System.out.println("2. Delete from Given Position");
                    System.out.println("3. Delete from End");
                    System.out.print("Choose the deletion type: ");
                    int deleteChoice = S.nextInt();
                    switch (deleteChoice) {
                        case 1:
                            deleteBeg();
                            break;
                        case 2:
                            System.out.print("Enter the position: ");
                            pos = S.nextInt();
                            deletePos(pos);
                            break;
                        case 3:
                            deleteEnd();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the element to search: ");
                    val = S.nextInt();
                    search(val);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    S.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
