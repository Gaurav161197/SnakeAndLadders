package Controller;

import Model.*;
import Service.GameService;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameController {

    public Game initiateGame(Board board, Queue<Player> players, Map<Player, Integer> playerPositionMap, Dice dice) {
        return Game.getGameBuilder()
                .addAllPlayers(players)
                .setPlayerPositionMap(playerPositionMap)
                .setBoard(board)
                .setDice(dice)
                .build();
    }

    public Board createBoard(int boardSize, List<Jumper> jumpers) {
        return new Board(boardSize, jumpers);
    }

    public int rollDice(Game game) {
        Dice dice = game.getDice();
        return dice.rollTheDice();
    }

    public void executeNextMove(Game game, int diceOutput) {
        GameService gameService = new GameService();
        gameService.makeMove(game, diceOutput);
    }

    public void updatePlayerTurn(Game game) {
        Queue<Player> players = game.getPlayers();
        Player playerToPlayLast = players.remove();
        players.add(playerToPlayLast);
        game.updatePlayers(players);

    }
}
