import Controller.GameController;
import Model.*;

import java.util.*;

public class Client {
    public static void main(String[] args) {


        System.out.println("Game is started");

        Player p1 = new Player(1, "GAURAV", 'Y');
        Player p2 = new Player(2, "KAPIL", 'X');
        Player p3 = new Player(3, "ASMITA", 'Z');

        Queue<Player> playerQueue = new LinkedList<>(Arrays.asList(p1, p2,p3));

        List<Jumper> snakeAndLadderList = new ArrayList<>();

        snakeAndLadderList.add(new Ladder(5,15));
        snakeAndLadderList.add(new Ladder(30,55));
        snakeAndLadderList.add(new Ladder(50,90));
        snakeAndLadderList.add(new Ladder(35,70));
        snakeAndLadderList.add(new Ladder(12,67));
        snakeAndLadderList.add(new Snake(99,3));
        snakeAndLadderList.add(new Snake(26,6));
        snakeAndLadderList.add(new Snake(57,33));
        snakeAndLadderList.add(new Snake(81,18));
        snakeAndLadderList.add(new Snake(68,45));


        Map<Player, Integer> playerPositionMap = new HashMap<>();
        playerPositionMap.put(p1, 0);
        playerPositionMap.put(p2, 0);
        playerPositionMap.put(p3, 0);

        Dice dice = new Dice(2);

        GameController gameController = new GameController();
        Board board = gameController.createBoard(100, snakeAndLadderList);

        Game game = gameController.initiateGame(board, playerQueue, playerPositionMap, dice);

        while (game.getPlayers().size() > 1) {
            System.out.printf("Next chance is of Player %s", game.getCurrentPlayer().getPlayerName());
            System.out.println();
            int diceOutput = gameController.rollDice(game);
            System.out.printf("Dice output is %s, ", diceOutput);
            gameController.executeNextMove(game, diceOutput);
            gameController.updatePlayerTurn(game);
            System.out.println();
            System.out.println("-----------------------------------------------------------------");
        }

        System.out.println("Winner of the GAME is: "+game.getWinner().getPlayerName());

    }
}