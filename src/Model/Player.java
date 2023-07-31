package Model;


import java.util.Map;
import java.util.Objects;

public class Player {
    private long playerId;
    private String playerName;
    private char playerSymbol;

    private int rank;

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Player(long playerId, String playerName, char playerSymbol) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;

    }

    public int makeMove(Map<Player, Integer> playerPosition, int diceOutput) {
        int currentPosition = playerPosition.get(this);
        return currentPosition + diceOutput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerId == player.playerId && playerSymbol == player.playerSymbol && Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, playerName, playerSymbol);
    }
}

