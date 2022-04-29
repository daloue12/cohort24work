import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise03 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();
        games.add(new BoardGame("Age of Empires", 1, 4, "City Building"));
        System.out.print(games);
        games.add(new BoardGame("Halo 3", 1, 4, "Online RPG"));
        System.out.print(games);

        // 1. Add three new games to `games` with the `add` method.
        // 2. Print `games` after each add.
    }
}
