package bean;

public class SchedulerBean {

    private String jobName;
    private String jobType;
    private String taskName;
    private String importFile;
    private String startDateTime;
    private String timeZone;

    public SchedulerBean() {
    }

    public SchedulerBean(String jobName, String jobType, String taskName, String importFile, String startDateTime, String timeZone) {
        this.jobName = jobName;
        this.jobType = jobType;
        this.taskName = taskName;
        this.importFile = importFile;
        this.startDateTime = startDateTime;
        this.timeZone = timeZone;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getImportFile() {
        return importFile;
    }

    public void setImportFile(String importFile) {
        this.importFile = importFile;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
