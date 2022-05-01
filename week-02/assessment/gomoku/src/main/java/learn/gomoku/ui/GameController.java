package learn.gomoku.ui;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;

import java.util.Random;
import java.util.Scanner;

public class GameController {
    public void run() {
        Scanner console = new Scanner(System.in);
        Player firstPlayer = null;
        Player secondPlayer = null;
        boolean onePlayerEstablished = false;
        boolean twoPlayersEstablished = false;

        System.out.println("Welcome to the Gomoku Game!");
        do {
            System.out.println("Do you want to play as a human player or a random player? [human/random]");
            String userChoice = console.nextLine();
            if (userChoice.equalsIgnoreCase("human")) {
                System.out.println("Please enter a player's name: ");
                String humanPlayerName = console.nextLine();
                firstPlayer = new HumanPlayer(humanPlayerName);
                onePlayerEstablished = true;
            } else if (userChoice.equalsIgnoreCase("random")) {
                firstPlayer = new RandomPlayer();
                onePlayerEstablished = true;
            } else {
                System.out.println("Sorry, that is not a valid entry");
                onePlayerEstablished = false;
            }
        } while (onePlayerEstablished == false);

        do {
            System.out.println("For player two, do you want to play as a human player or a random player? [human/random]");
            String userSecondChoice = console.nextLine();
            if (userSecondChoice.equalsIgnoreCase("human")) {
                System.out.println("Please enter a player's name: ");
                String humanPlayerName = console.nextLine();
                secondPlayer = new HumanPlayer(humanPlayerName);
                twoPlayersEstablished = true;
            } else if (userSecondChoice.equalsIgnoreCase("random")) {
                secondPlayer = new RandomPlayer();
                twoPlayersEstablished = true;
            } else {
                System.out.println("Sorry, that is not a valid entry");
                twoPlayersEstablished = false;
            }
        } while (twoPlayersEstablished == false);

       /* Gomoku game = new Gomoku(firstPlayer, secondPlayer);


        do {


        } while (!game.isOver());
        Player black = game.getCurrent();

        // Black player's first move.
        Result result = game.place(new Stone(0, 0, game.isBlacksTurn()));

        // White player's first move.
        result = game.place(new Stone(1, 0, game.isBlacksTurn()));

        // Black player's second move.
        result = game.place(new Stone(0, 1, game.isBlacksTurn()));

        // White player's second move.
        result = game.place(new Stone(1, 1, game.isBlacksTurn()));

        // Black player's third move.
        result = game.place(new Stone(0, 2, game.isBlacksTurn()));

        // White player's third move.
        result = game.place(new Stone(1, 2, game.isBlacksTurn()));

        // Black player's fourth move.
        result = game.place(new Stone(0, 3, game.isBlacksTurn()));

        // White player's fourth move.
        result = game.place(new Stone(1, 3, game.isBlacksTurn()));

        // Black player's fifth move... the winning move of the game.
        // Not only should the result be successful, but it should contain the expected "winning" message.
        result = game.place(new Stone(0, 4, game.isBlacksTurn()));

        // Check that the game is in fact over and that the winner was the black player.
        System.out.println("Game is over? " + game.isOver());
        System.out.println(game.getWinner());

*/    }
}
