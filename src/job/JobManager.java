package job;

import java.util.LinkedList;
import java.util.Queue;

public class JobManager {
    static long jobId = 0;

    private Queue<Job> jobs = new LinkedList<Job>();

    public void add(Job job) {
        jobs.add(job);
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Job job : jobs) {
            s.append(job).append("\n");

        }
        return "JobManager{" + s + "} total jobs " + jobs.size();
    }

    public void reSet() {
        jobId = 0;
        jobs = new LinkedList<Job>();

    }

    public Job poll() {
        return jobs.poll();
    }

    public Job peek() {
        return jobs.peek();
    }
}
