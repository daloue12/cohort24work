import org.w3c.dom.ls.LSOutput;

public class Exercise09 {

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println("box 2x2");
        printBox(2,2);
        System.out.println("box 3x4");
        printBox(3, 4);


    }

    public static void printBox(int a, int b ) {
        int i, j;
        for (i = 0; i <= a; i ++) {
            for (j = 0; j <= b; j ++) {
                if (i == 1 || i == a || j == 1 || j == b) {
                    System.out.print("#");
                }
                }
            System.out.println();
            }
        }
    }
    // 1. Create a method.
    // Name: printBox
    // Inputs: int, int
    // Output: void
    // Description: prints a visual box to the console. The first parameter is the number of rows to print.
    // The second parameter is the number of columns.
    // See repetition Exercise15.

    // Expected Output (5 rows, 5 columns)
    // #####
    // #####
    // #####
    // #####
    // #####

    // (3 rows, 4 columns)
    // ####
    // ####
    // ####
