package main.java.com.httpsemilly.tictactoe;

public class Board {
    private static final int COLUMNS = 3;
    private static final int ROWS = 3;

    private String[][] board;

    // constructor
    public Board() {
        board = new String[ROWS][COLUMNS];
        initializeBoard();
    }

    // method to initialize the board
    public void initializeBoard() {
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                board[i][j] = "-";
            }
        }
    }

    // method to display the board
    public void displayBoard() {
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    // method to verify free positions
    public boolean isPositionFree(int row, int column) {
        return board[row][column].equals("-");
    }

    // method to update the board
    public void updateBoard(int row, int column, String playerSymbol) {
        if(isPositionFree(row, column)) {
            board[row][column] = playerSymbol;
        }
    }

    // method to get the symbol
    public String getSymbol(int row, int column) {
        if(row >= 0 && row < ROWS && column >= 0 && column < COLUMNS) {
            return board[row][column];
        }

        return null;
    }

}

