import java.awt.*;

public abstract class Block {


    public static int id;
    public Coordinate coordinate;

    public BlockType blockType;

    public abstract int getX();

    public abstract int getY();

    public abstract Coordinate getCoordinate();

    public abstract Color getColor();
//
//    public abstract void draw(Graphics g);


}
