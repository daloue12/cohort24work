package learn.gomoku.ui;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;

import java.util.Scanner;

public class GameController {
    Scanner console = new Scanner(System.in);
    char[][] board = new char[15][15];
    Gomoku game;
    int choice;
    boolean playAgain;
    String message;

    public void run() {
        setup();
        play();
        playAgain();
    }

    void setup() {
        System.out.println("Welcome to the Gomoku Game!");
        Player playerOne = getPlayer(1);
        System.out.println();
        Player playerTwo = getPlayer(2);
        game = new Gomoku(playerOne, playerTwo);
        System.out.println("Randomizing...");
        System.out.println();
        System.out.printf("It is %s's turn!", game.getCurrent().getName());
        System.out.println();
    }

    Player getPlayer(int playerNumber) {
        int choice;
        Player player = null;
        choice = readInt("Would you like to be a human player or random player? [1 = human, 2 = random]", 1, 2);
        if (choice == 1) {
            String playerName = readRequiredString("Enter your name: ");
            player = new HumanPlayer(playerName);
            return player;
        } else if (choice == 2) {
            player = new RandomPlayer();
            return player;
        }
        return player;
    }

      /*  do {
            Player currentPlayer = game.getCurrent();
            System.out.printf("%s it's your turn!%n", currentPlayer.getName());

            System.out.println("Enter row: ");
            int row = Integer.parseInt(console.nextLine()) - 1;

            System.out.println("Enter column: ");
            int column = Integer.parseInt(console.nextLine()) - 1;

            Stone stone = new Stone(row, column, game.isBlacksTurn());

            Result result = game.place(stone);
            System.out.println(result);
        } while (!game.isOver());
        System.out.println("Game is over? " + game.isOver());
        System.out.println("The winner is: " + game.getWinner().getName());*/

    private void play() {
        System.out.println();
        do {
            printBoard();
            System.out.println();
            Player currentPlayer = this.game.getCurrent();
            System.out.println(currentPlayer.getName() + " it's your turn.");
            System.out.println();
            Stone stone = currentPlayer.generateMove(this.game.getStones());

            if (stone == null) {
                System.out.println("Enter row: ");
                int row = Integer.parseInt(console.nextLine()) - 1;
                System.out.println();

                System.out.println("Enter column: ");
                int column = Integer.parseInt(console.nextLine()) - 1;
                System.out.println();
                stone = new Stone(row, column, this.game.isBlacksTurn());
                this.game.place(stone);
            } else {
                this.board[stone.getRow()][stone.getColumn()] = stone.isBlack() ? 'X' : 'O';
            }
            Result result = game.place(stone);

            if (!result.isSuccess()) {
                System.out.println(result.getMessage());
            } else {
                System.out.printf("Stone placed in row: %s column: %s", stone.getRow(), stone.getColumn());
                System.out.println();
                printBoard();
            }
            /*this.board[stone.getRow()][stone.getColumn()] = stone.isBlack() ? 'X' : 'O';*/
        } while (!this.game.isOver());
        if (game.getWinner() == null) {
            System.out.println("The game is over. It's a draw!");
        } else {
            System.out.printf("The winner is %s", game.getWinner().getName());
        }
    }

    private void printBoard() {
        int row;
        int column;

        for (Stone stone : game.getStones()) {
            row = stone.getRow();
            column = stone.getColumn();
            board[row][column] = stone.isBlack() ? 'X' : 'O';
        }

        for (row = 0; row < board.length; row++) {
            for (column = 0; column < board[row].length; column++) {
                if (board[row][column] == '\0') {
                    board[row][column] = '_';
                }
            }
        }
        System.out.println("  01 02 03 04 05 06 07 08 09 10 11 12 13 14 15");
        for (row = 0; row < board.length; row++) {
            System.out.printf("%02d", row + 1);
            for (column = 0; column < board[row].length; column++) {
                System.out.print(" " + board[row][column] + " ");
            }
            System.out.println();
        }
    }

    private String readRequiredString(String message) {
        String input;
        do {
            System.out.print(message);
            input = console.nextLine();
        } while (input.isBlank());
        return input;
    }

    int readInt(String message, int min, int max) {
        String userInput = readRequiredString(message);

        if (userInput.equals("1")) {
            return 1;
        } else if (userInput.equals("2")) {
            return 2;
        } else {
            System.out.println("Sorry, that is not a valid entry");
            readInt(message, min, max);
        }
        return 0;
    }

    private boolean playAgain() {
        System.out.println();
        choice = readInt("Do you want to play again? [1 = yes | 2 = no]", 1, 2);

        if (choice == 1) {
            run();
            return true;
        } else if (choice == 2) {
            return false;
        } else {
            System.out.println("Sorry, that is not valid entry.");
            return false;
        }
    }
}

/*  private int intSelectionRow() {
        boolean validInput = false;
        do {
            System.out.println("Pick a row [1-15]");
            int choice = console.nextInt();
            if (choice >= 1 && choice <= 15) {
                return choice;
            } else {
                System.out.println("Sorry, that is not valid.");
            }
        } while (validInput);
        return 0;
    }

    private int intSelectionColumn() {
        boolean validInput = false;
        do {
            System.out.println("Pick a column [1-15]");
            int choice = console.nextInt();
            if (choice >= 1 && choice <= 15) {
                return choice;
            } else {
                System.out.println("Sorry, that is not valid.");
            }
        } while (validInput);
        return 0;
    }*/




       /*
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

*/
