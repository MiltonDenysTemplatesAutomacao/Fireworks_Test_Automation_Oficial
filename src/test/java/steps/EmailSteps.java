package steps;

import io.cucumber.java.en.When;
import pages.EmailPage;

public class EmailSteps {

    @When("I click on create a new email button and select type {string}")
    public static void createNewEmail(String type) {
        EmailPage.createNewEmail(type);
    }
    @When("I send email")
    public static void sendEmail() {
        EmailPage.sendEmail();
    }
    @When("I confirm EmailSend")
    public static void confirmEmailSend() {
        EmailPage.confirmEmailSend();
    }
    @When("I wait until email sent {string}")
    public static void waitUntilEmailSent(String emailName) {
        EmailPage.waitUntilEmailSent(emailName);
    }
}