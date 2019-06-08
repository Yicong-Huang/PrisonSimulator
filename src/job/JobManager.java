package job;

import base.Coordinate;

import java.util.LinkedList;
import java.util.Queue;

public class JobManager {
    static long jobId = 0;

    private final Queue<Job> jobs = new LinkedList<Job>();

    public synchronized void add(Job job) {
        jobs.add(job);
    }


    @Override
    public String toString() {
//        StringBuilder s = new StringBuilder();
//
//            for (Job job : jobs) {
//                s.append(job).append("\n");
//
//            }


        return "JobManager{" + "} total jobs " + jobs.size();
    }

    public void reSet() {
        jobId = 0;
        jobs.clear();

    }

    public Job poll() {
        return jobs.poll();
    }

    public Job peek() {
        return jobs.peek();
    }

    public boolean hasJob() {
        return jobs.size() != 0;
    }

    public synchronized Job closestJob(Coordinate coordinate) {

        double min = Double.MAX_VALUE;
        Job theJob = null;
        for (Job job : jobs) {
            if (coordinate.distance(job.getCoordinate()) < min) {
                theJob = job;
                min = coordinate.distance(job.getCoordinate());
            }
        }
        jobs.remove(theJob);
        return theJob;
    }


}
