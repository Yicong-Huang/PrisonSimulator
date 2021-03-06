package base;

import block.Block;
import block.BlockManager;
import exception.MultiplePreviewError;
import job.Job;
import job.JobType;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;


public class GameBoard extends JPanel implements MouseInputListener {

    private static final int BOARD_WIDTH = 20;
    private static final int BOARD_HEIGHT = 20;
    private BlockManager blockManager;

    private Coordinate temp;

    private Set<Block> tempBlocks;


    GameBoard() {

        setFocusable(true);

        blockManager = new BlockManager(BOARD_WIDTH, BOARD_HEIGHT);
        setBounds(0, 0, BOARD_WIDTH * Block.WIDTH, BOARD_HEIGHT * Block.HEIGHT);

        addMouseListener(this);
        addMouseMotionListener(this);


    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        blockManager.update(g2d);
        PrisonSimulation.characterManager.update(g2d);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("in GameBoard Click");

    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("in GameBoard Press");
        temp = new Coordinate(e.getX() / Block.WIDTH, e.getY() / Block.HEIGHT);


    }

    @Override
    public void mouseReleased(MouseEvent e) {

//        System.out.println("in GameBoard Release");
//        synchronized (jobManager) {
        for (Block block : tempBlocks) {

            PrisonSimulation.jobManager.add(new Job(JobType.BUILD, block.getCoordinate()));
        }
        System.out.println(PrisonSimulation.jobManager);
        tempBlocks = null;
//        }

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

        tempBlocks = new HashSet<>();
        int eventX = e.getX() / Block.WIDTH;
        int eventY = e.getY() / Block.HEIGHT;
        int initX = temp.getX();
        int initY = temp.getY();
        Coordinate start = new Coordinate();
        Coordinate end = new Coordinate();

        if (eventX > initX) {
            start.setX(initX);
            end.setX(eventX);

        } else {
            start.setX(eventX);
            end.setX(initX);
        }

        if (eventY > initY) {
            start.setY(initY);
            end.setY(eventY);

        } else {
            start.setY(eventY);
            end.setY(initY);

        }

        if (PrisonSimulation.currentState == State.BUILD_WALL) {

            createJob(start, end);


        }

        repaint();


    }

    private void createJob(Coordinate start, Coordinate end) {

        for (int i = start.getX(); i <= end.getX(); i++) {
            for (int j = start.getY(); j <= end.getY(); j++)
                try {
                    if (i == start.getX() || i == end.getX() || j == start.getY() || j == end.getY()) {
                        blockManager.getBlock(new Coordinate(i, j)).addPreview(new Preview());
                        tempBlocks.add(blockManager.getBlock(new Coordinate(i, j)));

                    }

                } catch (MultiplePreviewError ignored) {
                }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println("in GameBoard Move");

    }
}
