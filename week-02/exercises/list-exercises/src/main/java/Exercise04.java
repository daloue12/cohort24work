import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise04 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Instantiate a new ArrayList<BoardGame>.
        // 2. Add three BoardGames to the new list.
        // 3. Print the new list.
        // 4. Add items in the new list to `games` with the `addAll` method.
        // 5. Print `games`.
        ArrayList<BoardGame> gameList = new ArrayList<>();
        gameList.add(new BoardGame("Grand Theft Penguin", 1, 4, "Adventure"));
        gameList.add(new BoardGame("Call of Duty", 1, 4, "Online RPG"));
        gameList.add(new BoardGame("Fortnite", 1, 4, "Online RPG"));
        System.out.printf("%s%n", gameList);
        games.addAll(gameList);
        System.out.printf("%s%n", games);
    }
}
