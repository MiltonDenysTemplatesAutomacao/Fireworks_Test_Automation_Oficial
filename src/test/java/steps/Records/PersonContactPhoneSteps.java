package steps.Records;

import io.cucumber.java.en.Then;
import pages.PersonNavPage;
import pages.Records.PersonContactPhonePage;

public class PersonContactPhoneSteps {

    @Then("I add phone {string}")
    public static void addPhone(String index) {
        PersonContactPhonePage.addPhone(index);
    }

}
