package steps;

import io.cucumber.java.en.Then;
import pages.Records.PersonContactPage;

public class PersonContactSteps {

    @Then("I verify email address {string} fields")
    public static void verifyEmailFieldsPersonPage(String index) {
        PersonContactPage.verifyEmailPersonPageRecord(index);
    }
}
