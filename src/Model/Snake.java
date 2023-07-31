package Model;

public class Snake extends Jumper {

    public Snake(int startPoint, int endPoint) {

        super(startPoint, endPoint);

        if(startPoint<endPoint)
            throw new IllegalArgumentException("Snake startpoint cannot be smaller than endpoint");
    }
}
