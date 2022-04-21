public class Exercise03 {

    public static void main(String[] args) {
        float result = milesToKilometers(12.0f);

        System.out.println(result); // Expected (roughly): 19.32
        System.out.println(milesToKilometers(1024f)); // Expected: 1648.64
        System.out.println(milesToKilometers(123.45f)); // Expected: 198.7545
        System.out.println(milesToKilometers(1234f));
        //The last call for milesToKilometers was the one that I input per the instruction comment below

        // 2. Add at least one more milesToKilometers call and confirm it works.
    }

    // milesToKilometers converts miles to kilometers.
    // 1. Complete the milesToKilometers method.
    public static float milesToKilometers(float miles) {return (float) (miles * 1.609344);}
}
