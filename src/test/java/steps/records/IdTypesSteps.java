package steps.records;

import io.cucumber.java.en.When;
import pages.records.IdTypesPage;

public class IdTypesSteps {

    @When("I update External Id group {string} person {int}")
    public static void updateExternalId(String index, int person) {
        IdTypesPage.updateExternalId(index,person);
    }
    @When("I click on external ID SaveChanges button")
    public static void saveChangesBtnIdTypes() {
        IdTypesPage.saveChangesBtnIdTypes();
    }
    @When("I validate if Visa number is correct")
    public static void validateVisaNumber() {
        IdTypesPage.validateVisaNumber();
    }

}
