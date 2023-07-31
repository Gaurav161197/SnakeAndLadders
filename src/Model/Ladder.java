package Model;

public class Ladder extends Jumper {
    public Ladder(int startPoint, int endPoint) {

        super(startPoint, endPoint);

        if(endPoint<startPoint)
            throw new IllegalArgumentException("Ladder end point cannot be smaller than start point");
    }
}
