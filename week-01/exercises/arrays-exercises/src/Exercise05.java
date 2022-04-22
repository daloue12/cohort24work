public class Exercise05 {

    public static void main(String[] args) {
        String[] continents = new String[7];

        continents[0] = "North America";
        continents[1] = "South America";
        continents[2] = "Africa";
        continents[3] = "Europe";
        continents[4] = "Asia";
        continents[5] = "Australia";
        continents[6] = "Antarctica";

        for (int i = 0; i < continents.length; i ++) {
            String continent = continents[i];
            System.out.println(continent);
        }

        // 1. Declare an array to hold the names of the world's continents.
        // Do not use array literal notation. Allocate space for 6 continents and then set each value by index.
        // 2. Loop over each element and print it.
    }
}
