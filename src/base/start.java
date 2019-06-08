package base;

import java.awt.*;

public class start {

    /**
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    public static PrisonSimulation prisonSimulation;


    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            prisonSimulation = new PrisonSimulation();
            prisonSimulation.setVisible(true);
        });
    }


}
