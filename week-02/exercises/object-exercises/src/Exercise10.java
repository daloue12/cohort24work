import javax.swing.plaf.basic.BasicLookAndFeel;
import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        // BALLOON GAME
        Scanner console = new Scanner(System.in);

        // 1. Instantiate three balloons of different colors.
        Balloon mine = new Balloon("blue", 0.0);
        Balloon his = new Balloon("red", 0.0);
        Balloon doggy = new Balloon("silver", 0.0);

        do {

            System.out.println("Inflate? [y/n]: ");
            if (console.nextLine().equalsIgnoreCase("y")) {
                // 2. If the user confirms an inflate, inflate each balloon.
                mine.inflate();
                his.inflate();
                doggy.inflate();
            }

            // 3. When one or more balloons explode, stop the loop.
        } while (!mine.isExploded() && !his.isExploded() && !doggy.isExploded());

        // 4. Print the color of the winners (balloons that exploded).
        System.out.printf("%s%n", mine.getPsi());
        System.out.printf("%s%n", his.getPsi());
        System.out.printf("%s%n", doggy.getPsi());
    }
}
