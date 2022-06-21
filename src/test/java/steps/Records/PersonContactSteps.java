package steps.Records;

import io.cucumber.java.en.Then;
import pages.PersonPage;
import pages.Records.PersonContactPage;

public class PersonContactSteps {

    @Then("I click on save changes in contact for person")
    public static void saveChangesBtnPersonContact() {
        PersonPage.saveChangesBtnPersonContact();
    }
}
