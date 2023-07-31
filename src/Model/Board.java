package Model;

import java.util.List;

public class Board {

    int dimension;

    private List<Jumper> snakesAndLaderList;


    public Board(int dimension, List<Jumper> snakesAndLaderList) {
        this.dimension = dimension;
        this.snakesAndLaderList = snakesAndLaderList;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<Jumper> getSnakesAndLaderList() {
        return snakesAndLaderList;
    }

    public void setSnakesAndLadderList(List<Jumper> snakesAndLaderList) {
        this.snakesAndLaderList = snakesAndLaderList;
    }
}
