import java.util.Random;

public class Exercise12 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();
        int positiveElements = 0;
        int negativeElements = 0;

        // 1. Count the number of positive and non-positive elements in `values`.
        // 2. Create two new int[]s, one for positive elements and one for non-positive.
        // (We count first to determine the capacity to allocate.)
        // 3. Loop through `values` a second time. If an element is positive, add it to the positive array.
        // If it is non-positive, add it to the non-positive array.
        // 4. Confirm that your secondary arrays are properly populated either by debugging or printing their elements.

        for (int i = 0; i < values.length; i++) {
            if (values[i] >= 0) {
                positiveElements += 1;
            }

            if (values[i] < 0) {
                negativeElements += 1;
            }
        }
        System.out.printf("The total number of elements: %s%n", values.length);
        System.out.printf("The total number of positive elements is: %s%n", positiveElements);
        System.out.printf("The total number of negative elements is: %s%n", negativeElements);
        System.out.println("-----------------------------------------------");


        int[] evenNumArray = new int[positiveElements];
        int[] oddNumArray = new int[negativeElements];

        for (int j = 0; j < values.length; j++) {
            if (values[j] >= 0) {
                evenNumArray.
            }

        }
    }

    public static int[] makeRandomArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(1000) - 500;
        }
        return result;
    }
}
