import java.util.Scanner;

public class Exercise05 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        Musician[] musicians = new Musician[5];
        musicians[0] = new Musician("Frank Ocean", 10);

        // 1. Use a loop to populate the `musicians` array with your top 5 favorite musicians.
        // (Replace Frank Ocean.)
        // Create musicians from user input. (See Exercise04.)
        for (int i = 0; i < musicians.length; i++) {
            Musician first = new Musician();
            System.out.println("Enter musician name: ");
            String name = console.nextLine();
            System.out.println("Musician rating: ");
            int rating = Integer.parseInt(console.next());
            Musician m = new Musician(name, rating);
            System.out.printf("%s, %s%n", m.getName(), m.getRating());
            }

        for (int i = 0; i < musicians.length; i ++) {
            System.out.printf("#%s, %s: %s%n", i+1, musicians[i].getName(), musicians[i].getRating());
        }

        // 2. Use a second loop to print details about each musician.
    }
}
