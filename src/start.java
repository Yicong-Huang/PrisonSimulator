import javax.swing.*;
import java.awt.*;

public class start {

    /**
     * {
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */

    public static JFrame frame;


    public static void main(String[] args) {
        // 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 300);

                frame.setVisible(true);
                frame.pack();
                JPanel jPanel = new JPanel();
                Graphics2D graphics = (Graphics2D) jPanel.getGraphics();
                graphics.drawLine( 0, 50,  20, 50);
                graphics.drawRect(40, 50,  20, 20);
                graphics.drawOval(80, 50,  20, 20);
                frame.add(jPanel);
                frame.setContentPane(jPanel);
                frame.setLocationRelativeTo(null);



            }
        });
    }


}
