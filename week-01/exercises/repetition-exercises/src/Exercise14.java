import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.println("Please enter a phrase: ");
        String phrase = console.nextLine();
        int count = 0;

        for (int i = 0; i < phrase.length(); i ++) {
            if(Character.isDigit(phrase.charAt(i)));
            count++;
        }
        System.out.println("The number of digits in your phrase is: " + count);


        // 1. Collect a phrase from a user via the console.
        // 2. Count the number of digits in the phrase.
        // Hint: Character.isDigit
        // 3. Print the result.
    }
}
