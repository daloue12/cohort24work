public class Exercise20 {

    public static void main(String[] args) {

        // From Alice Roosevelt Longworth:
        String aliceQuote = "If you can't say something good about someone, sit right here by me.";

        char tenthChar = aliceQuote.charAt(9);
        System.out.println(tenthChar);

        // 1. Store the first character from aliceQuote in a char variable.
        char firstChar = aliceQuote.charAt(1);
        // 2. Print it.
        System.out.println(firstChar);
        // 3. Print the 20th character.
        char twentiethChar = aliceQuote.charAt(20);
        System.out.println(twentiethChar);
        // 4. Print the 68th character.
        char sixtyeigth = aliceQuote.charAt(67);
        System.out.print(sixtyeigth);
    }
}