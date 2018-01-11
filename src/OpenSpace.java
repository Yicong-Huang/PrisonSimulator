import java.awt.*;

public class OpenSpace extends Block {

    public OpenSpace(int x, int y) {
        coordinate= new Coordinate(x, y);
    }


    public int getX() {
        return 20 * coordinate.getX();
    }

    public int getY() {
        return 20 * coordinate.getY();
    }



}
