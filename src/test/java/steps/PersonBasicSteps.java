package steps;

import io.cucumber.java.en.Then;
import pages.Records.PersonBasicPage;

public class PersonBasicSteps {

    @Then("I verify basic fields labels")
    public static void navigateToBasic() {
        PersonBasicPage.verifyPersonBasicFieldLabels();
    }

}
