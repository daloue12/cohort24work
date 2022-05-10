import java.util.Random;

public class Exercise11 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                evenCount += 1;
            } else if (values[i] % 2 != 0) {
                oddCount += 1;
            }
        }


        int[] evenNumberArray = new int[evenCount];

        for (int i = 0; i < evenNumberArray.length; i++) {
            for (int j = 0; j < values.length; j++) {
                if (values[j] % 2 == 0) {
                    evenNumberArray[i] = values[j];
                    System.out.println(evenNumberArray[i]);
                }
            }
        }
    }




        // 1. Count the number of positive elements in `values`.
        // 2. Create a new int[] to hold the positive elements.
        // (We must count first to know the capacity to allocate.)
        // 3. Loop through `values` a second time. Add positive elements to the new array.
        // 4. Confirm the positive array is properly populated either by debugging or printing its elements.

    public static int[] makeRandomArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(1000) - 500;
        }
        return result;
    }

}
