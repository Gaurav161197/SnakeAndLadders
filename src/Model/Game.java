package Model;

import java.util.*;

public class Game {

    private Board board;
    private Queue<Player> players;

    private Map<Player, Integer> playerPosition;

    private Dice dice;

    private Player winner;

    private GameStatus gameStatus;

    private static int rankCount = 0;


    private Game(Board board, Queue<Player> players, Map<Player, Integer> playerPositionMap, Dice dice) {
        this.board = board;
        this.players = players;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.playerPosition = playerPositionMap;
        this.dice = dice;
    }

    public Board getBoard() {
        return board;
    }

    public Dice getDice() {
        return dice;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public Map<Player, Integer> getPlayerPosition() {
        return playerPosition;
    }

    public Player getWinner() {
        return winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public static GameBuilder getGameBuilder() {
        return new GameBuilder();
    }

    public Player getCurrentPlayer() {
        return players.peek();
    }

    public void updatePlayerPositions(Map<Player, Integer> playerPosition) {
        this.playerPosition = playerPosition;
    }

    public Player playerWon(Queue<Player> players) {
        Player wonPlayer = players.remove();
        rankCount += 1;
        if (rankCount == 1)
            this.winner = wonPlayer;

        wonPlayer.setRank(rankCount);
        return wonPlayer;

    }

    public void updatePlayers(Queue<Player> players) {
        this.players = players;
    }

    public static class GameBuilder {
        private Dice dice;
        private Board board;
        private Queue<Player> players;
        private Map<Player, Integer> playerPositionMap;

        public GameBuilder() {
            this.dice = new Dice(1);
            this.board = new Board(0, new ArrayList<>());
            this.players = new LinkedList<>();
            this.playerPositionMap = new HashMap<>();
        }

        public GameBuilder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public GameBuilder addAllPlayers(Queue<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder addPlayer(Player player) {
            players.add(player);
            return this;
        }

        public GameBuilder setPlayerPositionMap(Map<Player, Integer> playerPositionMap) {
            this.playerPositionMap = playerPositionMap;
            return this;
        }

        public GameBuilder setDice(Dice dice) {
            this.dice = dice;
            return this;
        }

        public Game build() {
            return new Game(board, players, playerPositionMap, dice);
        }
    }

}

