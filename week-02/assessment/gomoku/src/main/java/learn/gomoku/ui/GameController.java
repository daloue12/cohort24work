package learn.gomoku.ui;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;

public class GameController {
    public void run() {
        HumanPlayer playerOne = new HumanPlayer("Dori");
        HumanPlayer playerTwo = new HumanPlayer("Nemo");
        Gomoku game = new Gomoku(playerOne, playerTwo);
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


    }
}
