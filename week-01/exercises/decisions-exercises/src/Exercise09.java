import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a minimum value: ");
        int minValue = Integer.parseInt(console.nextLine());

        System.out.print("Enter a maximum value: ");
        int maxValue = Integer.parseInt(console.nextLine());

        System.out.print("Enter an actual value: ");
        int actualValue = Integer.parseInt(console.nextLine());

        if (actualValue > minValue && actualValue < maxValue) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
