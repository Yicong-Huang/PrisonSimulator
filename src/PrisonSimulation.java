import javax.swing.*;

class PrisonSimulation extends JFrame {

    PrisonSimulation() {

        initUI();
    }

    private void initUI() {

        add(new GameBoard());

        setSize(800, 600);
        setResizable(false);

        setTitle("Prison Simulator");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}