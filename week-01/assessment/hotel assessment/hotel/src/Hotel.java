import org.w3c.dom.ls.LSOutput;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Welcome to America's Finest Capsule Hotel!");
        System.out.println("How many capsules are available today: ");
        int numOfCapsules = console.nextInt();
        System.out.println();
        System.out.printf("Woohoo! There are %s capsules that are ready to be booked!", numOfCapsules);
        System.out.println();

        String[] capsules = new String[numOfCapsules];

        do {
            int choice = menu(console);
            switch (choice) {
                case 1:
                    checkIn(console, capsules);
                    break;
                case 2:
                    checkOut(console, grabIndex(console, capsules), capsules);
                    break;
                case 3:
                    viewGuests(capsules);
                    break;
                case 4:
                    System.out.println("Are you sure that you want to exit?");
                    System.out.println("All of your data will be lost [yes/no]");
                    console.nextLine();
                    String option = console.nextLine();
                    if (option.equalsIgnoreCase("yes")) {
                        exit = true;
                    } else {
                        exit = false;
                    }
                default:
                    System.out.println("Hmm that's not a valid option. Please enter a new selection [1-4] ");
                    break;
            }
        } while (!exit);
        System.out.println();
        System.out.println("Thanks for using our app. Have a nice day!");
    }

    //The curly bracket above closes the main method. User menu code to follow this comment line.
    private static int menu(Scanner console) {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1. Check Guest In");
        System.out.println("2. Check Guest Out");
        System.out.println("3. View Guests");
        System.out.println("4. Exit");
        System.out.print("Selection: ");
        int userOption = console.nextInt();
        System.out.println();
        return userOption;
    }

    //Check in method follows this comment
    private static void checkIn(Scanner console, String[] array) {
        console.nextLine();
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            System.out.println("Enter guest name: ");
            String guestName = console.nextLine();
            if (array[i] == null) {
                array[i] = guestName;
                System.out.printf("%s is checked now checked into capsule %s", guestName, (i + 1));
                System.out.println();
            } else if (array[i] != null && !array[i].isBlank()) {
                System.out.println("Sorry, there are no open capsules available at this time!");
            }
        }
    }

    private static int grabIndex(Scanner console, String[] array) {
        int index = -1;
        System.out.println("Who would you like to check out?");
        console.nextLine();
        String update = console.nextLine();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(update)) {
                index = i;
                return index;
            } else {
                System.out.println();
            }
        }
        System.out.println("Sorry, we cannot find that person.");
        return grabIndex(console, array);
    }

    private static void checkOut(Scanner console, int x, String[] array) {
        System.out.println("Enter new guest name: ");
        System.out.println();
        String newName = console.nextLine();

        array[x] = newName;
    }
    private static void viewGuests(String[] array) {
        if (array[0] == null) {
            System.out.println("All capsules are currently vacant. Nobody has checked in yet.");
        }else{
            System.out.println("Current Guests: ");
            System.out.println();
            for (int i = 0; i < array.length; i++) {
                String currentGuest = array[i];
                int assignment = i + 1;
                System.out.printf("%s is in capsule %s.%n", !currentGuest.isBlank() ? currentGuest : "Empty", assignment);
                }
            }
        }

}
