import java.sql.SQLOutput;
import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Start: ");
        int start = Integer.parseInt(console.nextLine());

        System.out.print("End: ");
        int end = Integer.parseInt(console.nextLine());

        int sum = start;
        for (int i = start; i <= end; i++) {
            sum = sum + i;
        }
        System.out.println(sum);

        // 1. Write a loop to sum all numbers between start and end.
        // 2. Print the result.
    }
}
