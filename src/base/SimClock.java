package base;

public class SimClock extends Thread {
    /**
     * Class SimClock has been implemented as static, it contains methods
     * to tick the clock base on checking system time, and to return the
     * simulatedTime when requested.
     * <p>
     * ---Note the entire class and all methods are package-private.---
     */

    private int simulatedTime;
    private int period;
    private long initialTime;

    SimClock(int newPeriod) {

        simulatedTime = 0;
        period = newPeriod;
        initialTime = System.currentTimeMillis();
        System.out.println("Clock Started " + initialTime);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            if (System.currentTimeMillis() - initialTime >= period) {
                initialTime += period;

                //noinspection ValueOfIncrementOrDecrementUsed
                System.out.println("TICKING " + ++simulatedTime);
                PrisonSimulation.gameBoard.repaint();
            }
        }
    }

    private void tick() {

    }

    public int getTime() {
        return simulatedTime;
    }


}