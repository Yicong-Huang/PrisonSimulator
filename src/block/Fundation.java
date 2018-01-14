package block;

import base.Coordinate;
import base.Preview;

import java.awt.*;

public class Fundation extends Block {


    private Color color = Color.WHITE;
    private Wall wall = null;
    private Preview preview = null;


    public Fundation(int x, int y) {
        coordinate = new Coordinate(x, y);
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void addPreview(Preview preview) {

    }

    @Override
    public void removePreview() {

    }
}
