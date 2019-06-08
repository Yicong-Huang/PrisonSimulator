package job;

import base.Coordinate;

public class Job {

    private long id;
    private JobType jobType;
    private Coordinate coordinate;

    private boolean inProgress = false;
    private boolean canBeDone = false;

    public Job(JobType jobType, Coordinate coordinate) {

        this.id = JobManager.jobId++;
        this.jobType = jobType;
        this.coordinate = coordinate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public boolean isCanBeDone() {
        return canBeDone;
    }

    public void setCanBeDone(boolean canBeDone) {
        this.canBeDone = canBeDone;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobType=" + jobType +
                ", coordinate=" + coordinate +
                ", inProgress=" + inProgress +
                ", canBeDone=" + canBeDone +
                '}';
    }
}
