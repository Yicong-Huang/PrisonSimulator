package job;

import location.Location;

public class Job {

    private long id;
    private JobType jobType;
    private Location location;

    private boolean inProgress = false;
    private boolean canBeDone = false;

    public Job(JobType jobType, Location location) {

        this.id = JobManager.jobId++;
        this.jobType = jobType;
        this.location = location;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
                ", location=" + location +
                ", inProgress=" + inProgress +
                ", canBeDone=" + canBeDone +
                '}';
    }
}
