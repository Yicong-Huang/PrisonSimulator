import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class GameWindow extends JPanel implements MouseListener {

    private static final int BOARD_WIDTH = 40;
    private static final int BOARD_HEIGHT = 30;


    private ArrayList<Block> blocks;

    public GameWindow() {
        setFocusable(true);

        blocks = new ArrayList<>();
        for (int i = 0; i < BOARD_WIDTH; ++i) {
            for (int j = 0; j < BOARD_HEIGHT; ++j) {
                blocks.add(new OpenSpace(i, j));

            }
        }
        addMouseListener(this);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        for (Block block : blocks) {
            int x = ((OpenSpace) block).getX();
            int y = ((OpenSpace) block).getY();
            g2d.drawRect(x, y, 20, 20);
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {

        blocks.add(new OpenSpace(e.getX() / 20, e.getY() / 20));
        repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
