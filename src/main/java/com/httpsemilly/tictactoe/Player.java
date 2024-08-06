package main.java.com.httpsemilly.tictactoe;

public class Player {
    private String playerName;
    private String playerSymbol;

    // constructor
    public Player(String name, String symbol) {
        this.playerName = name;
        this.playerSymbol = symbol;
    }

    // getters
    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerSymbol() {
        return playerSymbol;
    }

    // setters
    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public void setPlayerSymbol(String symbol) {
        this.playerSymbol = symbol;
    }
}
