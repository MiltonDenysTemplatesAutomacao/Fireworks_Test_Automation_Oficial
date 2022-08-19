package steps;

import io.cucumber.java.en.Then;
import pages.PersonNavPage;

public class PersonNavSteps {
    @Then("I navigate to Interests & Activities")
    public static void navigateToInterestsActivities() {
        PersonNavPage.navigateToInterestsActivities();
    }
    @Then("I navigate to Actions")
    public static void navigateToActions() {
        PersonNavPage.navigateToActions();
    }
    @Then("I navigate to contact")
    public static void navigateToContact() {
        PersonNavPage.navigateToContact();
    }
    @Then("I click on student status")
    public static void navigateToStudentStatus() {
        PersonNavPage.navigateToStudentStatus();
    }
    @Then("I navigate to Relationship")
    public static void navigateToRelationships() {
        PersonNavPage.navigateToRelationships();
    }
    @Then("I navigate to Applications")
    public static void navigateToApplications() {
        PersonNavPage.navigateToApplications();
    }
    @Then("I navigate to Financial Aid")
    public static void navigateToFinancialAid() {
        PersonNavPage.navigateToFinancialAid();
    }
    @Then("I navigate to Employment")
    public static void navigateToEmployment() {
        PersonNavPage.navigateToEmployment();
    }


}
