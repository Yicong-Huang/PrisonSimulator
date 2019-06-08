package character;

import base.Coordinate;
import job.Job;

import java.awt.*;

import static base.PrisonSimulation.jobManager;
import static base.PrisonSimulation.simClock;


public class Worker extends Character {
    private int time = simClock.getTime();
    private Job job;

    public Worker(Coordinate coordinate) {
        setCoordinate(coordinate);
        setSpeed(2);

    }

    public int getX() {
        return coordinate.getX() * 20;
    }

    public int getY() {
        return coordinate.getY() * 20;
    }

    @Override
    public void run() {
        System.out.println("worker id " + id + "is running");

//        synchronized (jobManager) {
        while (!Thread.currentThread().isInterrupted()) {
            Job job = findJob();
            if (job != null) {
                moveTo(job.getCoordinate());
            }
        }
//        }
    }

    private void moveTo(Coordinate coordinate) {
        System.out.println("moving to " + coordinate + " from " + this.coordinate);
        while (!coordinate.equals(this.coordinate)) {


            int currentTime = simClock.getTime();
            if (currentTime > time) {
                int dX = coordinate.getX() - this.coordinate.getX();
                int dY = coordinate.getY() - this.coordinate.getY();
                System.out.println("y difference " + dY + "x difference" + dX);
                angle = Math.atan2(dX, dY);
                System.out.println("    angle " + Math.toDegrees(angle));

                if (Math.pow(dY, 2) + Math.pow(dX, 2) < Math.pow(speed, 2)) {
                    this.coordinate.setCoordinate(coordinate);
                } else {
                    this.coordinate.setCoordinate((int) ((this.coordinate.getX() + speed * Math.sin(angle))), (int)
                            ((this.coordinate.getY() + speed * Math.cos(angle))));
                }
                System.out.println("    now at " + this.coordinate);


                time = currentTime;
            }
        }


    }

    public void paintComponent(Graphics2D g2d) {


        g2d.setColor(Color.YELLOW);
        g2d.fillOval(getX() + 5, getY() + 5, 10, 10);


    }

    private Job findJob() {
        job = jobManager.closestJob(coordinate);
        if (job != null) {
            job.setInProgress(true);
            return job;
        } else return null;

    }

    private void work() {
        if (job != null) {

        }

    }
}
