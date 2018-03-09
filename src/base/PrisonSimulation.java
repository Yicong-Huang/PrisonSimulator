package base;

import job.JobManager;
import menu.MenuBar;

import javax.swing.*;
import java.awt.*;

public class PrisonSimulation extends JFrame {
    public static State currentState = State.BUILD_WALL;
    public static JobManager jobManager = new JobManager();

    public PrisonSimulation() {
        add(new GameBoard(), BorderLayout.NORTH);
        add(new MenuBar(), BorderLayout.SOUTH);


        setSize(400, 500);
        setResizable(false);
        setLayout(null);


        setTitle("Prison Simulator");
        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}