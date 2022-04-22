import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Please ");
        removeWhite(console.nextLine());
    }
    // 1. Add a `main` method.
    // 2. Create method that accepts a String and returns that string with all of its whitespace remove.
    // 2. Call your method in various ways in the main method.
    public static String removeWhite(String console) {
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter a phrase: ");
        String phrase = console.nextLine();
        String newPhrase = phrase.replace(" ", "");
        return newPhrase;
    }
}
