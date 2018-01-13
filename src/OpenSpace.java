import java.awt.*;

public class OpenSpace extends Block {

    private Color color = Color.GREEN;

    public OpenSpace(int x, int y) {
        coordinate= new Coordinate(x, y);
    }


    public int getX() {
        return 20 * coordinate.getX();
    }

    public int getY() {
        return 20 * coordinate.getY();
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
