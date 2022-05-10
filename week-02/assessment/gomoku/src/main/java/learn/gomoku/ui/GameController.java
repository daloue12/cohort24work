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
    char[][] board = new char[20][20];
    Gomoku game;
    int choice;
    boolean playAgain;
    String message;

    public void run() {
        do {
            setup();
            play();
        } while (!!playAgain());
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
        resetBoard();
    }

    void resetBoard() {
        int row;
        int col;

        for (row = 0; row < board.length; row ++) {
            for (col = 0; col < board[row].length; col ++) {
                    board[row][col] = '_';
            }
        }
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
    private void play() {
        do {
            System.out.println();
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
        }//exact topmost column alignment with the '_' characters is still not completely exact. Wonder if it's possible? Is so, how?
        System.out.println("  01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20");
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
