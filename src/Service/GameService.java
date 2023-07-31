package Service;

import Model.*;

import java.util.List;
import java.util.Map;

public class GameService {

    public void makeMove(Game game, int diceOutput) {

        Player player = game.getCurrentPlayer();
        System.out.printf("Player %s make the move %s", player.getPlayerName(), diceOutput);
        System.out.println();
        Map<Player, Integer> playerPosition = game.getPlayerPosition();
        List<Jumper> snakesAndLaderList = game.getBoard().getSnakesAndLaderList();
        int boardSize = game.getBoard().getDimension();

        //current player make move and return new position
        int newPosition = player.makeMove(playerPosition, diceOutput);
        System.out.printf("Player %s new Position should be %s, let's check for any player,ladder orSnake at that position", player.getPlayerName(), newPosition);
        System.out.println();

        //check if the player won
        if (newPosition - boardSize == 0 || newPosition - boardSize == 1) {
            Player wonPlayer = game.playerWon(game.getPlayers());
            playerPosition.remove(wonPlayer);
            System.out.printf("Congratulations %s has won the game with rank %s", wonPlayer.getPlayerName(), wonPlayer.getRank());
            return;
        } else if (boardSize < newPosition) {
            System.out.printf("Oops board size is smaller than the new position, better luck next time..!");
            return;
        }

        //update the player position
        playerPosition.put(player, newPosition);

        //check if there is any other player at new position, other than the current player
        for (Player p : playerPosition.keySet()) {
            if (playerPosition.get(p) == newPosition && !p.equals(player)) {
                playerPosition.put(p, 0);
                System.out.printf("Player %s got killed by %s,new position of %s is %s and new position of %s is %s",
                        p.getPlayerName(), player.getPlayerName(),
                        p.getPlayerName(), playerPosition.get(p), player.getPlayerName(),
                        playerPosition.get(player));
                System.out.println();
                break;
            }
        }

        //if there is any Snake or ladder
        for (Jumper jumper : snakesAndLaderList) {
            int startPosition = jumper.getStartPoint();
            int endPosition = jumper.getEndPoint();

            if (jumper instanceof Snake && startPosition == newPosition) {
                playerPosition.put(player, endPosition);
                System.out.printf("Opps..! there is a Snake at position %s, new Position of player %s is %s", newPosition, player.getPlayerName(), endPosition);
                System.out.println();

            } else if (jumper instanceof Ladder && startPosition == newPosition) {
                System.out.printf("Yoo..! there is a Ladder at position %s, new Position of player %s is %s", newPosition, player.getPlayerName(), endPosition);
                playerPosition.put(player, endPosition);
                System.out.println();
            }

        }

        //update position of all players within game
        game.updatePlayerPositions(playerPosition);

        //printing updated player positions
        for (Player x : playerPosition.keySet()) {
            System.out.println(x.getPlayerName() + " is now at " + playerPosition.get(x));
        }


    }
}
