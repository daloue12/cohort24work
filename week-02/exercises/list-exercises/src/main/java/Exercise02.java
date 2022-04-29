import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise02 {

    // 1. Create a method to print all BoardGames in an ArrayList<BoardGame>.
    // Consider making it `public` so you can use it in other exercises.
    public static void printAllGames(ArrayList<BoardGame> boardGames){
        ArrayList<BoardGame> games = new ArrayList<>(Arrays.asList(
                new BoardGame("Catan", 3, 4, "Economic"),
                new BoardGame("Monopoly", 2, 8, "Economic"),
                new BoardGame("Dominion", 2, 4, "Card Game"),
                new BoardGame("Splendor", 2, 4, "Card Game"),
                new BoardGame("The Resistance", 5, 10, "Bluffing"),
                new BoardGame("7 Wonders", 2, 7, "City Building"),
                new BoardGame("Gloomhaven", 1, 4, "Adventure"),
                new BoardGame("Betrayal at House on the Hill", 3, 6, "Adventure"),
                new BoardGame("Terraforming Mars", 1, 5, "Economic"),
                new BoardGame("Ravine", 3, 6, "Party Game"),
                new BoardGame("Ultimate Werewolf: Deluxe Edition", 5, 75, "Party Game"),
                new BoardGame("Coup", 2, 6, "Bluffing"),
                new BoardGame("Machi Koro", 2, 4, "City Building")
        ));

        for (BoardGame allGames : games) {
            System.out.println(allGames);
        }


    }

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 2. Print `games` using your "print all" method.
        printAllGames(games);
    }
}
