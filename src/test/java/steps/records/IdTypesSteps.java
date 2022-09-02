package steps.records;

import io.cucumber.java.en.When;
import pages.records.IdTypesPage;

public class IdTypesSteps {

    @When("I update External Id group {string} person {int}")
    public static void updateExternalId(String index, int person) {
        IdTypesPage.updateExternalId(index,person);
    }
    @When("I add an External ID {string}")
    public static void addExternalID(String group) {
        IdTypesPage.addExternalID(group);
    }
    @When("I click on external ID SaveChanges button")
    public static void saveChangesBtnIdTypes() {
        IdTypesPage.saveChangesBtnIdTypes();
    }
    @When("I validate if Visa number is correct")
    public static void validateVisaNumber() {
        IdTypesPage.validateVisaNumber();
    }
    @When("I update visa {string}, {string}, {string} group {string}")
    public static void updateVisa(String entryTerm,String country,String visaType,String group) {
        IdTypesPage.updateVisa(entryTerm,country,visaType,group);
    }

}
