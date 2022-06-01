package steps;

import io.cucumber.java.en.When;
import pages.EmailPage;

public class EmailSteps {

    @When("I click on create a new email button and select type {string}")
    public static void createNewEmail(String type) {
        EmailPage.createNewEmail(type);
    }
}