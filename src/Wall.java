import java.awt.*;

public class Wall extends Block {

    private Color color = Color.YELLOW;

    public Wall(int x, int y) {
        coordinate = new Coordinate(x, y);
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
