package steps;

import io.cucumber.java.en.Then;
import pages.Records.PersonBasicPage;

public class PersonBasicSteps {

    @Then("I verify basic fields labels")
    public static void verifyPersonBasicFieldLabels() {
        PersonBasicPage.returnAndValidateTextBasicFieldsLabel();
    }
    @Then("I validate not displayed fields are correct")
    public static void validateNotDisplayedFields() {
        PersonBasicPage.returnAndValidateElementsNotDisplayed();
    }
}
