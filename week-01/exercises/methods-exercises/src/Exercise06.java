public class Exercise06 {
    public static boolean isBetween(int a, int b, int c) {
        if ((b > a && a > c) || (c < a && a < b)) {
            return true;
        } else {
            return false;
        }
    }

    // 1. Create a method.
    // Name: isBetween
    // Inputs: int, int, int
    // Output: boolean
    // Description: return true if the first parameter is between the second and third parameter.
    // Otherwise, returns false.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        boolean result = isBetween(3, 6, 2);
        System.out.println(result);

        System.out.println(isBetween(50, 23, 32));
        System.out.println(isBetween(42, 11, 2));
    }
}
