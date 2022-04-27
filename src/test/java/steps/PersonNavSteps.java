package steps;

import io.cucumber.java.en.Then;
import pages.PersonNavPage;

public class PersonNavSteps {
    @Then("I navigate to Interests & Activities")
    public static void navigateToInterestsActivities() {
        PersonNavPage.navigateToInterestsActivities();
    }
    @Then("I navigate to contact")
    public static void navigateToContact() {
        PersonNavPage.navigateToContact();
    }

    @Then("I click on student status")
    public static void navigateToStudentStatus() {
        PersonNavPage.navigateToStudentStatus();
    }


}
