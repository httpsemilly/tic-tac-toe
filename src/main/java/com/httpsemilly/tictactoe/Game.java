package main.java.com.httpsemilly.tictactoe;

import java.util.*;

public class Game {
    private Board board;
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    // constructor
    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
        initializePlayer();
        currentPlayer = player1;
    }

    // method to define players
    private void initializePlayer() {
        System.out.print("Name of player 1: ");
        String player1Name = scanner.nextLine();
        System.out.print("Select the symbol (X or O): ");
        String player1Symbol = scanner.nextLine();

        player1 = new Player(player1Name, player1Symbol);
        String player2Symbol;

        if(player1.getPlayerSymbol().equals("X")) {
            player2Symbol = "O";
        } else {
            player2Symbol = "X";
        }

        System.out.print("Name of player 2: ");
        String player2Name = scanner.nextLine();

        player2 = new Player(player2Name, player2Symbol);

        System.out.println(player1.getPlayerName() + " symbol: " + player1.getPlayerSymbol());
        System.out.println(player2.getPlayerName() + " symbol: " + player2.getPlayerSymbol());
    }

    // method to start the game
    public void startGame() {
        boolean gameEnded = false;

        while(gameEnded != true) {
            board.displayBoard();
            makeMove();
            gameEnded = checkWin() || checkDraw();
            switchPlayer();
        }

        if(checkWin()) {
            switchPlayer();
            System.out.println("Congratulations, " + currentPlayer.getPlayerName() + ". You WON!");
        } else if(checkDraw()) {
            System.out.println("This game is a DRAW!");
        }
    }

    // method to make moves
    private void makeMove() {
        boolean validMove = false;

        while(validMove != true) {
            System.out.println(currentPlayer.getPlayerName() + ", select the row (0, 1, 2): ");
            int row = scanner.nextInt();
            System.out.println(currentPlayer.getPlayerName() + ", select the column (0, 1, 2): ");
            int column = scanner.nextInt();
            scanner.nextLine();

            if(board.isPositionFree(row, column)) {
                board.updateBoard(row, column, currentPlayer.getPlayerSymbol());
                validMove = true;
            } else {
                System.out.println("Invalid move. Try again!");
            }
        }
    }

    // method to check win
    private boolean checkWin() {
        int row = 0;
        int column = 0;

        // check rows
        for(int currentRow = 0; currentRow < ROWS; currentRow++) {
            if(!board.getSymbol(currentRow, column).equals("-") && 
            board.getSymbol(currentRow, column + 1).equals(board.getSymbol(currentRow, column)) && 
            board.getSymbol(currentRow, column + 2).equals(board.getSymbol(currentRow, column))) {
                return true;
            } 
        }

        // check columns
        for(int currentColumn = 0; currentColumn < COLUMNS; currentColumn++) {
            if(!board.getSymbol(row , currentColumn).equals("-") && 
            board.getSymbol(row + 1, currentColumn).equals(board.getSymbol(row, currentColumn)) &&
            board.getSymbol(row + 2, currentColumn).equals(board.getSymbol(row, currentColumn))) {
                return true;
            }
        }

        // check the main diagonal
        for(row = 0; row < ROWS - 2; row++) {
            for(column = 0; column < COLUMNS - 2; column++) {
                if(!board.getSymbol(row, column).equals("-") &&
                board.getSymbol(row + 1, column + 1).equals(board.getSymbol(row, column)) &&
                board.getSymbol(row + 2, column + 2).equals(board.getSymbol(row, column))) {
                    return true;
                }
            }
        }

        // check the secondary diagonal
        for(row = 0; row < ROWS - 2; row++) {
            for(column = 0; column < COLUMNS - 2; column++) {
                if(!board.getSymbol(row, column + 2).equals("-") &&
                board.getSymbol(row, column + 2).equals(board.getSymbol(row + 1 , column + 1)) &&
                board.getSymbol(row + 2, column).equals(board.getSymbol(row, column + 2))) {
                    return true;
                }
            }
        }

        return false;
    }

    // method to check draw
    private boolean checkDraw() {
        if(checkWin()) {
            return false;
        }

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                if(board.getSymbol(i, j).equals("-")) {
                    return false;
                }
            }
        }

        return true;
    }

    // method to switch player
    private void switchPlayer() {
        if(currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}
