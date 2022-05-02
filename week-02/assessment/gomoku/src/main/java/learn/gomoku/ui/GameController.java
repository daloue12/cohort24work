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

    private void setup() {
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

        System.out.println("Randomizing...");
        game = new Gomoku(firstPlayer, secondPlayer);
        System.out.println();
        System.out.printf("It is %s's turn!", game.getCurrent().getName());
        System.out.println();
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
            Stone stone = currentPlayer.generateMove(this.game.getStones());

            int row = intSelectionRow() - 1;
            int column = intSelectionColumn() - 1;

            if (stone == null) {
                stone = new Stone(row, column, this.game.isBlacksTurn());
                this.game.place(stone);
            } else {
                this.board[stone.getRow()][stone.getColumn()] = stone.isBlack() ? 'X' : 'O';
            }
            if (game.getWinner() == null) {
                System.out.println("The game is over. It's a draw!");
            }
        } while (!this.game.isOver());
        System.out.printf("The game is over! The winner is %s", game.getWinner().getName());
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
            input = console.nextLine().trim();
        } while (input.isBlank());
        return input;
    }

    private int readInt(String message, int min, int max) {
        System.out.println(message);
        String userInput = readRequiredString(message);
        if (userInput.equals("1")) {
            return 1;
        } else if (userInput.equals("2")) {
            return 2;
        } else {
            System.out.println("Sorry, that is not a valid entry");
        }
        return 0;
    }

    private boolean playAgain() {
        System.out.println();
        choice = readInt("Do you want to play again? [1 = yes | 2 = no]", 1, 2);
        if (choice == 1) {
            return true;
        } else if (choice == 2) {
            return false;
        } else {
            System.out.println("Sorry, that is not valid entry.");
            return false;
        }
    }

    private int intSelectionRow() {
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
    }
}




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
