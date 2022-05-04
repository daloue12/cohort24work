import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean exit = false;
        System.out.println();
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
                    checkOut(console, capsules);
                    break;
                case 3:
                    viewGuests(console, capsules);
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
        System.out.println("Which capsule would you like to check into?");
        int capsuleNumber = console.nextInt() - 1;
        if (capsuleNumber > 0 && capsuleNumber < array.length) {
            console.nextLine();
            if (array[capsuleNumber] == null) {
                System.out.println("Enter guest name: ");
                String guestName = console.nextLine();
                array[capsuleNumber] = guestName;
                System.out.println("Check in complete!");
            } else if (array[capsuleNumber] != null) {
                System.out.println("Sorry, that capsule is not available at this time.");
            }
        } else {
            System.out.println("Sorry, that is not a valid capsule number that exists.");
        }
    }

    private static void checkOut(Scanner console, String[] array) {
        System.out.println("Which room would you like to check out?");
        console.nextLine();
        int update = console.nextInt() - 1;
        if (array[update] == null) {
            System.out.println("That capsule is currently vacant. Please try again.");
            System.out.println();
        } else if (array[update] != null) {
            System.out.printf("Success. Capsule %s is now vacant", update + 1);
            System.out.println();
            array[update] = null;
        }
    }

    private static void viewGuests(Scanner console, String[] array) {
        console.nextLine();
        System.out.println("Enter a room number:");
        int guestOption = console.nextInt() - 1;
        if (guestOption - 5 < 0) {
            for (int i = 0; i <= guestOption + 5; i++) {
                System.out.println(array[i]);
            }
        }else if (guestOption + 5 > array.length) {
            for (int i = guestOption - 5; i < array.length; i ++) {
                System.out.println(array[i]);
            }
        } else {
            for (int i = guestOption - 5; i < guestOption + 5; i ++) {
                System.out.println(array[i]);
            }
        }
    }
}