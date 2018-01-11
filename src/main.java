import java.awt.EventQueue;
import javax.swing.JFrame;

public class main extends JFrame {

    public main() {

        initUI();
    }

    private void initUI() {

        add(new GameWindow());

        setSize(800, 600);
        setResizable(false);

        setTitle("Moving sprite");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                main ex = new main();
                ex.setVisible(true);
            }
        });
    }
}