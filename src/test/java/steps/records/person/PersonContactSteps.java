package steps.records.person;

import io.cucumber.java.en.Then;
import pages.PersonPage;

public class PersonContactSteps {

    @Then("I click on save changes in contact for person")
    public static void saveChangesBtnPersonContact() {
        PersonPage.saveChangesBtnPersonContact();
    }
}
