package character;

import base.PrisonSimulation;
import job.Job;

public class Worker extends Character {


    void getToWork() {

    }

    Job findJob() {
        Job job = PrisonSimulation.jobManager.poll();
        job.setInProgress(true);
        return job;
    }
}
