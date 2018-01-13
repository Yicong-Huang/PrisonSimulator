import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GameBoard extends JPanel implements MouseListener {

    private static final int BOARD_WIDTH = 5;
    private static final int BOARD_HEIGHT = 5;
    private BlockManager blockManager;

    private Block temp;


    GameBoard() {
        setFocusable(true);

        blockManager = new BlockManager(BOARD_WIDTH, BOARD_HEIGHT);

        addMouseListener(this);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        for (Block block : blockManager.getBlocks()) {
            int x = block.getX();
            int y = block.getY();
            g2d.setColor(block.getColor());
            g2d.fill3DRect(x, y, 20, 20, true);
            g2d.setColor(Color.BLACK);
            g2d.draw3DRect(x, y, 20, 20, true);

        }
        System.out.println(blockManager.getBlocks().size());


    }

    @Override
    public void mouseClicked(MouseEvent e) {

        blockManager.setBlock(new Coordinate(e.getX() / 20, e.getY() / 20), new Wall(e.getX() / 20, e.getY() / 20));
        repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pressed");


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
