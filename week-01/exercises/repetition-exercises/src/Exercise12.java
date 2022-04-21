import java.util.Scanner;

public class Exercise12 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a phrase: ");
        String phrase = console.nextLine();

        String testLetter = "x";

        if (phrase.contains(testLetter)) {
            System.out.println("There is at least 1 x in this word");
        } else {
            System.out.println("There are no x\'s in this word");
        }

        // 1. Write a loop to determine if the letter `x` occurs in a user-entered phrase.
        // 2. Print a message for both finding and not finding the `x`.
    }
}
