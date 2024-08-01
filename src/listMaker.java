
import java.util.ArrayList;
import java.util.Scanner;

public class listMaker {
    private static ArrayList<String> myArrList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            String command = SafeInput.getRegExString(scanner, "Please enter a command: ", "[AaDdIiPpQq]");
            switch (command.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    running = quitProgram();
                    break;
            }
        }
        System.out.println("So long!");
    }

    private static void displayMenu() {
        System.out.println("\nCurrent List:");
        printList();
        System.out.println("\nMenu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem() {
        String item = SafeInput.getRegExString(scanner, "Please enter the item to add: ", ".+");
        myArrList.add(item);
        System.out.println("Item has been added.");
    }

    private static void deleteItem() {
        printList();
        int index = SafeInput.getRangedInt(scanner, "Please enter the number of the item to delete: ", 1, myArrList.size()) - 1; // Convert to zero-based index
        myArrList.remove(index);
        System.out.println("Item has been deleted.");
    }

    private static void insertItem() {
        printList();
        int index = SafeInput.getRangedInt(scanner, "Please enter the index to insert the item at: ", 1, myArrList.size() + 1) - 1; // Convert to zero-based index
        String item = SafeInput.getRegExString(scanner, "Please enter the item to insert: ", ".+");
        myArrList.add(index, item);
        System.out.println("Item has been inserted.");
    }

    private static void printList() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is currently empty.");
            return;
        }
        for (int i = 0; i < myArrList.size(); i++) {
            System.out.println((i + 1) + ": " + myArrList.get(i)); // Display list with one-based indexing
        }
    }

    private static boolean quitProgram() {
        return !SafeInput.getYNConfirm(scanner, "Are you sure you would like to quit?");
    }
}
