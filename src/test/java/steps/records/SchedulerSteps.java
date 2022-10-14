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
    @When("I verify job details {string}, {string}, {string}, {string}")
    public static void updateJobDetails(String jobName,String taskName,String startDateTime,String timeZone) {
        SchedulerBean scheduler = new SchedulerBean();
        scheduler.setJobName(jobName);
        scheduler.setTaskName(taskName);
        scheduler.setStartDateTime(startDateTime);
        scheduler.setTimeZone(timeZone);
        SchedulerPage.verifyJobDetails(scheduler);
    }
    @When("I update Frequency1Weekly {string}, {string}, {string}, {string}")
    public static void updateFrequency1Weekly(String frequency,String dayOfWeek,String time,String endDateTime) {
        SchedulerPage.updateFrequency1Weekly(frequency,dayOfWeek,time,endDateTime);
    }
    @When("I update Frequency1Daily {string}, {string}, {string}")
    public static void updateFrequency1Daily(String frequency,String time,String endDateTime) {
        SchedulerPage.updateFrequency1Daily(frequency,time,endDateTime);
    }
    @When("I update Frequency1Monthly {string}, {string}, {string}, {string}")
    public static void updateFrequency1Monthly(String frequency,String dayOfWeek,String time,String endDateTime) {
        SchedulerPage.updateFrequency1Monthly(frequency,dayOfWeek,time,endDateTime);
    }
    @When("I validate numbers of elements {int} on calendar")
    public static void validateNumbersOfElements(int elements) {
        SchedulerPage.validateNumbersOfElements(elements);
    }
    @When("I verify Frequency1Weekly {string}, {string}, {string}, {string}")
    public static void verifyFrequency1Weekly(String frequency,String dayOfWeek,String time,String endDateTime) {
        SchedulerPage.verifyFrequency1Weekly(frequency,dayOfWeek,time,endDateTime);
    }
    @When("I verify Frequency1Monthly {string}, {string}, {string}, {string}")
    public static void verifyFrequency1Monthly(String frequency,String monthDay,String time,String endDateTime) {
        SchedulerPage.verifyFrequency1Monthly(frequency,monthDay,time,endDateTime);
    }
    @When("I update Exclude1Date {string}")
    public static void updateExclude1Date(String date) {
        SchedulerPage.updateExclude1Date(date);
    }
    @When("I verify Exclude1Date {string}")
    public static void verifyExclude1Date(String date) {
        SchedulerPage.verifyExclude1Date(date);
    }
    @When("I update Notify Recipients {string}")
    public static void updateNotifyRecipients(String emailAddress) {
        SchedulerPage.updateNotifyRecipients(emailAddress);
    }
    @When("I click on job save button")
    public static void clickJobSaveButton() {
        SchedulerPage.clickJobSaveButton();
    }
    @When("I open a schedule job {string}")
    public static void openScheduledJob(String job) {
        SchedulerPage.openScheduledJob(job);
    }
    @When("I verify Checkbox Defaults")
    public static void verifyCheckboxDefaults() {
        SchedulerPage.verifyCheckboxDefaults();
    }
    @When("I delete job")
    public static void deleteJob() {
        SchedulerPage.deleteJob();
    }
    @When("I search a schedule job {string}")
    public static void searchJobsManager(String job) {
        SchedulerPage.searchJobsManager(job);
    }
    @When("I validate if schedule job {string} is not displayed")
    public static void validateIfJobIsNotDisplayed(String job) {
        SchedulerPage.validateIfJobIsNotDisplayed(job);
    }

}
