package base;

import character.CharacterManager;
import character.Worker;
import job.JobManager;
import menu.MenuBar;

import javax.swing.*;
import java.awt.*;

public class PrisonSimulation extends JFrame {
    public static final JobManager jobManager = new JobManager();
    public static State currentState = State.BUILD_WALL;
    public static CharacterManager characterManager = new CharacterManager();
    static GameBoard gameBoard;


    public static SimClock simClock;

    PrisonSimulation() {
        simClock = new SimClock(1000);
        simClock.start();
        gameBoard = new GameBoard();
        add(gameBoard, BorderLayout.NORTH);

        add(new MenuBar(), BorderLayout.SOUTH);
        Worker worker = new Worker(new Coordinate(1, 1));
        worker.start();

        characterManager.addWorker(worker);
        Worker worker2 = new Worker(new Coordinate(10, 10));
        worker2.start();

        characterManager.addWorker(worker2);


        setSize(400, 500);
        setResizable(false);
        setLayout(null);


        setTitle("Prison Simulator");
        setLocationRelativeTo(null);

//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
