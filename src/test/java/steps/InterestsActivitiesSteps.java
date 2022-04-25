package steps;

import io.cucumber.java.en.Then;
import pages.Records.InterestsActivitiesPage;

public class InterestsActivitiesSteps {

    @Then("I update Interests & Activities group {string} person {int}")
    public static void updateInterest() {
        InterestsActivitiesPage.updateInterest();
    }
}
