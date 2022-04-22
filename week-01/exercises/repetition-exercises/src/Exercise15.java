public class Exercise15 {

    public static int main(String[] args) {

        String message = "x";

        int row  = 3;
        int column = 3;
        int index = 0;

        for (int i = 0; i < row; i ++) {
            System.out.println(message.charAt(row));
            i ++;
            for (int j = 0; j < column; j ++) {
                System.out.println(message.charAt(column));
                j ++;
                break;
            }
        }
        // BOX
        // 1. Use nested loops to print a box in the console.
        // One loop should represent rows and the other should represent columns.
        // 2. Change the row and column limit to change the shape of the box.

        // Expected Output (5X5)
        // #####
        // #####
        // #####
        // #####
        // #####

        // (3X4)
        // ####
        // ####
        // ####
    }
}
