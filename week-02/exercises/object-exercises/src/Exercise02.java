public class Exercise02 {

    public static void main(String[] args) {

        // 1. Add a getter for the rating field in Musician.

        Musician ocean = new Musician("Frank Ocean", 10);
        System.out.println(ocean.getName());
        // 2. Uncomment the line below and insure that it compiles and runs.
        System.out.println(ocean.getRating());

        // 3. Instantiate two musicians and assign them to new variables.
        // 4. Print each musicians' name and rating on a single line.
        Musician one = new Musician("Donkey Kong", 100);
        System.out.printf("%s %s", one.getName(), one.getRating());
        System.out.println();
        Musician two = new Musician("Linkin Park", 99);
        System.out.printf("%s %s", two.getName(), two.getRating());
    }
}
