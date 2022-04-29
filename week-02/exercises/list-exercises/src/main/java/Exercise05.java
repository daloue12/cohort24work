import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;
import java.util.Objects;

public class Exercise05 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Loop over each BoardGame in `games` and print games with the "Adventure" category.
        for (BoardGame allAdventure : games) {
            if (allAdventure.getCategory().equalsIgnoreCase("Adventure")) {
                System.out.println(allAdventure);
            }
        }
    }


}
