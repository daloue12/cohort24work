import java.util.Random;

public class Exercise08 {
    public static String getRandomFruit() {
        String[] fruits = {"pear", "orange", "mysteryFruit", "grape", "apple"};
        String random = (fruits[new Random().nextInt(fruits.length)]);
        return random;
    }

    // 1. Create a method.
    // Name: getRandomFruit
    // Inputs: none
    // Output: String
    // Description: returns a random fruit name as a string.
    // See Exercise01.
    // Choose from at least 5 fruit.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println(getRandomFruit());
        System.out.println(getRandomFruit());
        System.out.println(getRandomFruit());
        System.out.println(getRandomFruit());
        System.out.println(getRandomFruit());
    }
}
