import java.lang.reflect.Array;
import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Welcome to America's Finest Capsule Hotel!");
        System.out.println("How many capsules are available today: ");
        int numOfCapsules = console.nextInt();
        System.out.println();
        System.out.printf("There are %s capsules that are ready to be booked", numOfCapsules);
        System.out.println();

        String[] capsule = new String[numOfCapsules];

        do {
            int choice = menu(console);
            switch (choice) {
                case 1:
                    checkIn(numOfCapsules, console);
                    break;
                case 2:
                    break;
                case 3:
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
                    System.out.println("Please enter a enw selection [1-4] ");
                    break;
            }
        }while(!exit);
        System.out.println();
        System.out.println("Thanks for using our application. Have a nice day. Goodbye!");
    }

    //The curly bracket above closes the main method. User menu code to follow this comment line.
    private static int menu(Scanner console) {
        System.out.println("What would you like to do?");
        System.out.println("1. Check in");
        System.out.println("2. Check out");
        System.out.println("3. View guests");
        System.out.println("4. Exit");
        System.out.print("Selection: ");
        int userOption = console.nextInt();
        System.out.println();
        return userOption;
    }

    //Check in method follows this comment
    private static void checkIn(int numOfCapsules, Scanner console) {
        System.out.println("Please enter your name: ");
        String guestName = console.nextLine();
        System.out.println();
        System.out.printf("Which capsule would you like to check into?");
        int capsuleNumber = console.nextInt();

        for (int i = 0; i < numOfCapsules; i++) {
            if (capsuleNumber > 0 && capsuleNumber < numOfCapsules) {
                System.out.println("You have been checked in. Enjoy your stay!");
            } else if (numOfCapsules == numOfCapsules) {
                System.out.println("Sorry but that capsule is currently occupied.");
            }
        }
    }
}
