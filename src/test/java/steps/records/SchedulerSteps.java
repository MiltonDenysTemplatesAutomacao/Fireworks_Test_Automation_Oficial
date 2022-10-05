package steps.records;

import io.cucumber.java.en.When;
import pages.SchedulerPage;

public class SchedulerSteps {

    @When("I create a new schedule {string}")
    public static void createNewJob(String jobType) {
        SchedulerPage.createNewJob(jobType);
    }

}
