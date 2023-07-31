package Model;

import java.util.Random;

public class Dice {

    private int diceCount;

    public int rollTheDice() {
        int min = diceCount;
        int max = 6 * diceCount;
        Random randomNumber = new Random();
        return randomNumber.nextInt(max - min + 1) + min;
    }

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }
}
