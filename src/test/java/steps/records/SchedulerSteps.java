package steps.records;

import bean.RelationshipBean;
import bean.SchedulerBean;
import io.cucumber.java.en.When;
import pages.SchedulerPage;
import pages.records.RelationshipPage;

public class SchedulerSteps {

    @When("I create a new schedule {string}")
    public static void createNewJob(String jobType) {
        SchedulerPage.createNewJob(jobType);
    }
    @When("I update job details {string}, {string}, {string}, {string}, {string}")
    public static void updateJobDetails(String jobName,String taskName,String startDateTime,String timeZone,String importFile) {
        SchedulerBean scheduler = new SchedulerBean();
        scheduler.setJobName(jobName);
        scheduler.setTaskName(taskName);
        scheduler.setStartDateTime(startDateTime);
        scheduler.setTimeZone(timeZone);
        scheduler.setImportFile(importFile);
        SchedulerPage.updateJobDetails(scheduler);
    }
    @When("I update update Frequency1Weekly {string}, {string}, {string}, {string}")
    public static void updateFrequency1Weekly(String frequency,String dayOfWeek,String time,String endDateTime) {
        SchedulerPage.updateFrequency1Weekly(frequency,dayOfWeek,time,endDateTime);
    }
    @When("I update Exclude1Date {string}")
    public static void updateExclude1Date(String date) {
        SchedulerPage.updateExclude1Date(date);
    }
    @When("I update Notify Recipients {string}")
    public static void updateNotifyRecipients(String emailAddress) {
        SchedulerPage.updateNotifyRecipients(emailAddress);
    }
    @When("I click on job save button")
    public static void clickJobSaveButton() {
        SchedulerPage.clickJobSaveButton();
    }

}
