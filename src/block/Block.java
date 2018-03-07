package block;

import base.Coordinate;
import base.Preview;
import exception.MultiplePreviewError;

import java.awt.*;

public abstract class Block {


    public static int id;
    public BlockType blockType;
    Coordinate coordinate;

    public int getX() {
        return coordinate.getX() * 20;
    }

    public int getY() {
        return coordinate.getY() * 20;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public abstract Color getColor();

    public abstract void addPreview(Preview preview) throws MultiplePreviewError;


    public abstract void removePreview();


}
