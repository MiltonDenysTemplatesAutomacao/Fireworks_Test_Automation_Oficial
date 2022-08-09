package steps.records;

import io.cucumber.java.en.Then;
import pages.records.InterestsActivitiesPage;

public class InterestsActivitiesSteps {

    @Then("I update Interests group {string} person {int}")
    public static void updateInterest(String index, int person) {
        InterestsActivitiesPage.updateInterest(index,person);
    }
    @Then("I update Activities group {string} person {int}")
    public static void updateActivities(String index, int person) {
        InterestsActivitiesPage.updateActivities(index,person);
    }
    @Then("I click on Save Changes button in Interests & Activities")
    public static void clickSaveChangesInterestsActivities() {
        InterestsActivitiesPage.clickSaveChangesInterestsActivities();
    }
    @Then("I verify Interests group {string} person {int}")
    public static void verifyInterests(String index, int person) {
        InterestsActivitiesPage.verifyInterests(index,person);
    }
    @Then("I verify Activities group {string} person {int}")
    public static void verifyActivities(String index, int person) {
        InterestsActivitiesPage.verifyActivities(index,person);
    }

}
