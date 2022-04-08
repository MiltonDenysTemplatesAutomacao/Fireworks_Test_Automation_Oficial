package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PersonPage;
import pages.StaffPage;

public class PersonSteps {
    @Then("I navigate to basic")
    public static void navigateToBasic() {
        PersonPage.navigateToBasic();
    }
    @Then("I verify Header Role {string}")
    public static void verifyHeaderRole(String role) {
        PersonPage.verifyHeaderRole(role);
    }
    @Then("I open a people record by {string}")
    public static void openPeopleRecord(String search) {
        PersonPage.openPeopleRecord(search);
    }
    @Then("I search {string} on people page manager")
    public static void searchPeopleManager(String search) {
        PersonPage.searchPeopleManager(search);
    }
    @Then("I verify Student Type")
    public static void verifyStudentType() {
        PersonPage.verifyStudentType();
    }
    @Then("I verify the record panels for a student record")
    public static void verifyStudentRecordPanels() {
        PersonPage.verifyStudentRecordPanels();
    }
    @When("I update {string}, {string} and {string} to update citizenship")
    public static void updateCitizenship(String citizenshipType,String countryOfCitizenship,String ssn) {
        PersonPage.updateCitizenshipValues(citizenshipType,countryOfCitizenship,ssn);
    }
    @When("I update {string}, {string}, {string}, {string}, {string} and {string} to update name")
    public static void updateName(String firstName,String lastName,String middleName,String preferredName, String suffix, String salutation) {
        PersonPage.updateNameValues(firstName,lastName,middleName,preferredName,suffix,salutation);
    }
    @When("I update {string}, {string}, {string}, {string}, and {string} to update external ID Types for person")
    public static void updateExternalIdTypes(String type,String idNumber,String idRecordedDate,String whoAddedId, String comments) {
        PersonPage.updateExternalIdTypes(type,idNumber,idRecordedDate,whoAddedId,comments);
    }
    @Then("I navigate to ID Types")
    public static void navigateToIdTypes() {
        PersonPage.navigateToIdTypes();
    }
}
