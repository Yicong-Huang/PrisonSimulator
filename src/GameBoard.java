import base.Coordinate;
import base.Preview;
import block.Block;
import exception.MultiplePreviewError;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class GameBoard extends JPanel implements MouseInputListener {

    private static final int BOARD_WIDTH = 5;
    private static final int BOARD_HEIGHT = 5;
    private BlockManager blockManager;

    private Coordinate temp;

    private ArrayList<Block> tempBlocks;


    GameBoard() {

        setFocusable(true);

        blockManager = new BlockManager(BOARD_WIDTH, BOARD_HEIGHT);

        addMouseListener(this);
        addMouseMotionListener(this);

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        for (Block block : blockManager.getBlocks()) {
            int x = block.getX();
            int y = block.getY();
            g2d.setColor(block.getColor());
            g2d.fill3DRect(x, y, 20, 20, false);
            g2d.setColor(Color.BLACK);
            g2d.draw3DRect(x, y, 20, 20, false);

        }
        System.out.println(blockManager.getBlocks().size());


    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

        temp = new Coordinate(e.getX() / 20, e.getY() / 20);
//        blockManager.setBlock(temp, new Preview(e.getX() / 20, e.getY() / 20));

//        repaint();


    }

    @Override
    public void mouseReleased(MouseEvent e) {

        System.out.println("released " + e.getX() + ' ' + e.getY());
        tempBlocks = null;

    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseDragged(MouseEvent e) {
        if (tempBlocks != null) {
            for (Block block : tempBlocks) {
                block.removePreview();
            }
        }

        tempBlocks = new ArrayList<>();
        int eventX = e.getX() / 20;
        int eventY = e.getY() / 20;
        int initX = temp.getX();
        int initY = temp.getY();


        System.out.println(eventX + "   " + eventY + "   " + initX + "   " + initY);
        if (eventX > initX && eventY > initY) {
            for (int i = initX; i <= eventX; i++) {
                for (int j = initY; j <= eventY; j++)
                    try {
                        blockManager.getBlock(new Coordinate(i, j)).addPreview(new Preview());
                        tempBlocks.add(blockManager.getBlock(new Coordinate(i, j)));
                    } catch (MultiplePreviewError ignored) {
                    }
            }
        } else if (eventX > initX && eventY < initY) {
            for (int i = initX; i <= eventX; i++) {
                for (int j = eventY; j <= initY; j++)
                    try {
                        blockManager.getBlock(new Coordinate(i, j)).addPreview(new Preview());
                        tempBlocks.add(blockManager.getBlock(new Coordinate(i, j)));
                    } catch (MultiplePreviewError ignored) {
                    }
            }
        } else if (eventX < initX && eventY < initY) {
            for (int i = eventX; i <= initX; i++) {
                for (int j = eventY; j <= initY; j++)
                    try {
                        blockManager.getBlock(new Coordinate(i, j)).addPreview(new Preview());
                        tempBlocks.add(blockManager.getBlock(new Coordinate(i, j)));
                    } catch (MultiplePreviewError ignored) {
                    }
            }

        } else if (eventX < initX && eventY > initY) {
            for (int i = eventX; i <= initX; i++) {
                for (int j = initY; j <= eventY; j++)
                    try {
                        System.out.println(i + "   " + j);

                        blockManager.getBlock(new Coordinate(i, j)).addPreview(new Preview());
                        tempBlocks.add(blockManager.getBlock(new Coordinate(i, j)));
                    } catch (MultiplePreviewError ignored) {
                    }
            }

        }


        repaint();


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
