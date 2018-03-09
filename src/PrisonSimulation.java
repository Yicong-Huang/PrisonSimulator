import menu.MenuBar;

import javax.swing.*;
import java.awt.*;

class PrisonSimulation extends JFrame {

    PrisonSimulation() {
        add(new GameBoard(), BorderLayout.NORTH);
        add(new MenuBar(), BorderLayout.SOUTH);

        setSize(400, 500);
        setResizable(false);
        setLayout(null);


        setTitle("Prison Simulator");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}