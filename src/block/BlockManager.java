package block;

import base.Coordinate;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BlockManager {

    private Map<Integer, Block> blocks;
    private int boardWidth;
    private int boardHeight;

    public BlockManager(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        blocks = new HashMap<>();

        for (int i = 0; i < boardWidth; ++i)
            for (int j = 0; j < boardHeight; ++j)
                blocks.put(i * boardWidth + j, new OpenSpace(i, j));


    }

    public Collection<Block> getBlocks() {
        return blocks.values();
    }

    public Block getBlock(Coordinate coordinate) {
        return blocks.get(coordinate.getX() * boardWidth + coordinate.getY());
    }

    public void setBlock(Coordinate coordinate, Block block) {
        blocks.put(coordinate.getX() * boardWidth + coordinate.getY(), block);
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public void update(Graphics2D g2d) {


        for (Block block : getBlocks())
            block.paintComponent(g2d);

    }
}
