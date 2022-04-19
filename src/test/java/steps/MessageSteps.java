package steps;

import io.cucumber.java.en.When;
import pages.MessagePage;

public class MessageSteps {


    @When("I validate if {string} message alert required is correct")
    public static void validateRequiredFieldsMessage(String requiredMessage) {
        MessagePage.validateRequiredFieldsMessage(requiredMessage);
    }
    @When("I close alert person modal")
    public static void closeAlertPersonModal() {
        MessagePage.closeAlertPersonModal();
    }
    @When("I close alert if return this message {string}")
    public static void closeAlertIfReturned(String alert) {
        MessagePage.closeAlertIfReturned(alert);
    }


}
