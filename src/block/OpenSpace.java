package block;

import base.Coordinate;
import base.Preview;
import exception.MultiplePreviewError;

import java.awt.*;

public class OpenSpace extends Block {

    private Color originColor = Color.WHITE;

    private Color color = Color.WHITE;
    private Wall wall = null;
    private Preview preview = null;
    private boolean hasPreview = false;


    public OpenSpace(int x, int y) {
        coordinate = new Coordinate(x, y);
    }


    public Color getColor() {
        return color;
    }


    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void addPreview(Preview preview) throws MultiplePreviewError {

        if (!hasPreview) {
            this.preview = preview;
            setColor(preview.getColor());
            hasPreview = true;
        } else {
            throw new MultiplePreviewError();
        }

    }

    public void removePreview() {
        this.preview = null;
        this.hasPreview = false;

        setColor(originColor);
    }
}
