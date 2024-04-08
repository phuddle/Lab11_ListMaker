import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    static ArrayList<String> myArrList = new ArrayList<>(); // create new array list
    static Scanner console = new Scanner(System.in); //create scanner

    public static void main(String[] args)
    {
        final String menu = "A - Add an item to the list, D - Delete an item from the list, P - Print the list, Q - Quit the program"; // gives the menu options
        boolean done = false;
        boolean quitProg = false;
        String cmd = "";

        do // menu do while loop
        {
            // display list
            displayList();
            //display the menu options
            // get a menu choice
            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]" );
            cmd = cmd.toUpperCase();

            // execute the choice
            switch (cmd)
            {
                case "A":
                    addItem(); // executes add item method
                    break; // stop program
                case "D":
                    deleteItem(); // executes delete item method
                    break; // stop program
                case "P":
                    printList(); // executes print list method
                    break; // stop program
                case "Q": // executes quit
                    System.out.println("Are you sure you would like to quit?");
                    if (SafeInput.getYNConfirm(console, "Enter Y for Yes, N for No: ")) // if yes then system exit, if no show options
                    {
                        quitProg = true;
                        System.exit(0); // exits the system with code 0
                    }
                    break; // stop program
            }
        }
        while (!quitProg); // executes while done is true

        System.out.println("Exiting program...");
    }
    private static void displayList()
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        if (!myArrList.isEmpty())
        {
            for (int i = 0; i < myArrList.size(); i++) {
                System.out.printf("%3d%35s", i + 1, myArrList.get(i));
            }
        }
        else
            System.out.println("++++++++          List is empty          ++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    private static void addItem()  // Add item to the list
    {
        String newItem;
        do {
            newItem = SafeInput.getNonZeroLenString(console, "Enter an item to add: "); // Prompt user for a list item that is not an empty string
            if (!newItem.isEmpty()) {
                myArrList.add(newItem); // add new item to list
                break; // stop program
            }
            else
            {
                System.out.println("Item cannot be empty. Please try again.");
            }
            }
        while (true);
    }
    private static void deleteItem() // Remove item from list
    {
        if (myArrList.isEmpty())
        {
            System.out.println("The list is empty.");
            return;
        }
        displayList();
        int index = SafeInput.getRangedInt(console, "Enter the number of the item to delete: ", 1, myArrList.size()); // Prompt the user for the number of the item to delete
        myArrList.remove(index - 1); // Translate the number to an index by subtracting one
        System.out.println("Item deleted successfully.");
    }
    private static void printList()
    {
        if (myArrList.isEmpty())
        {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Current items: ");
        for(int i = 0; i < myArrList.size(); i++)
        {
            System.out.printf("%d. %s%n", i + 1, myArrList.get(i));
        }
    }
}