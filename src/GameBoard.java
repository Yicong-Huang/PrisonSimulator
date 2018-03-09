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

    private static final int BOARD_WIDTH = 20;
    private static final int BOARD_HEIGHT = 20;
    private BlockManager blockManager;

    private Coordinate temp;

    private ArrayList<Block> tempBlocks;


    GameBoard() {

        setFocusable(true);

        blockManager = new BlockManager(BOARD_WIDTH, BOARD_HEIGHT);
        setBounds(0, 0, 400, 400);

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
//        System.out.println(blockManager.getBlocks().size());


    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("in GameBoard Click");

    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("in GameBoard Press");
        temp = new Coordinate(e.getX() / 20, e.getY() / 20);


    }

    @Override
    public void mouseReleased(MouseEvent e) {

//        System.out.println("in GameBoard Release");
        tempBlocks = null;

    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.println("in GameBoard Enter");


    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println("in GameBoard Exit");
    }


    @Override
    public void mouseDragged(MouseEvent e) {
//        System.out.println("in GameBoard Drag");
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
        int startX, endX, startY, endY;

        if (eventX > initX) {
            startX = initX;
            endX = eventX;

        } else {
            startX = eventX;
            endX = initX;
        }

        if (eventY > initY) {
            startY = initY;
            endY = eventY;

        } else {
            startY = eventY;
            endY = initY;
        }


        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++)
                try {
                    blockManager.getBlock(new Coordinate(i, j)).addPreview(new Preview());
                    tempBlocks.add(blockManager.getBlock(new Coordinate(i, j)));
                } catch (MultiplePreviewError ignored) {
                }
        }

        repaint();


    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println("in GameBoard Move");

    }
}
