package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PersonPage;
import pages.StaffPage;

public class PersonSteps {
    @Then("I navigate to basic")
    public static void navigateToBasic() {
        PersonPage.navigateToBasic();
    }
    @Then("I delete a person")
    public static void deletePerson() {
        PersonPage.deletePerson();
    }
    @Then("I click on create record")
    public static void clickOnCreateRecord() {
        PersonPage.clickOnCreateRecord();
    }
    @Then("I update people composer")
    public static void updatePeopleComposer(DataTable data) {
        PersonPage.updatePeopleComposer(data);
    }
    @Then("I click on save record button")
    public static void clickOnSaveNewRecord() {
        PersonPage.clickOnSaveNewRecord();
    }
    @Then("I verify Header Role {string}")
    public static void verifyHeaderRole(String role) {
        PersonPage.verifyHeaderRole(role);
    }
    @Then("I update Header Role {string}")
    public static void updateHeaderRole(String role) {
        PersonPage.updateHeaderRole(role);
    }
    @Then("I verify all three roles are selected in the role dropdown")
    public static void verifyAllthreeRolesAreSelected() {
        PersonPage.verifyAllthreeRolesAreSelected();
    }
    @Then("I open a people record by {string}")
    public static void openPeopleRecord(String search) {
        PersonPage.openPeopleRecord(search);
    }
    @Then("I search {string} on people page manager")
    public static void searchPeopleManager(String search) {
        PersonPage.searchPeopleManager(search);
    }
    @Then("I validate if {string} message on datatable is displayed")
    public static void validateDatatableMessage(String message) {
        PersonPage.validateDatatableMessage(message);
    }
    @Then("I validate if {string} message on quick search is displayed")
    public static void validateQuickSearchEmpty(String message) {
        PersonPage.validateQuickSearchEmpty(message);
    }
    @Then("I verify Student Type {string}")
    public static void verifyStudentType(String studentType) {
        PersonPage.verifyStudentType(studentType);
    }
    @Then("I verify Header Assign Staff {string}")
    public static void verifyHeaderAssignedStaff(String assignedStaff) {
        PersonPage.verifyHeaderAssignedStaff(assignedStaff);
    }
    @Then("I validate Student Status label {string}")
    public static void verifyStudentStatusLabel(String studentStatusLabel) {
        PersonPage.verifyStudentStatusLabel(studentStatusLabel);
    }
    @Then("I validate Entry Term label {string}")
    public static void verifyEntryTermLabel(String entryTerm) {
        PersonPage.verifyEntryTermLabel(entryTerm);
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
    @Then("I add in summary field {string}")
    public static void addSummaryField(String summary) {
        PersonPage.addSummaryField(summary);
    }
    @Then("I verify if summary field {string} data is correct")
    public static void verifySummaryData(String summaryField) {
        PersonPage.verifySummaryData(summaryField);
    }
    @Then("I delete summary field {string}")
    public static void deleteSummaryFields(String summaryField) {
        PersonPage.deleteSummaryFields(summaryField);
    }
    @Then("I update birth values {string}, {string}, {string}, {string}")
    public static void updateBirthValues(String date,String country,String city,String state) {
        PersonPage.updateBirthValues(date,country,city,state);
    }
    @Then("I update culture values {string}, {string}, {string}, {string}, {string}, {string}")
    public static void updateCultureValues(String ethnicity,String race,String gender,String maritalStatus,String primaryLanguage, String religion) {
        PersonPage.updateCultureValues(ethnicity,race,gender,maritalStatus,primaryLanguage,religion);
    }
    @Then("I click on save changes on basic")
    public static void saveChangesBtnPersonBasic() {
        PersonPage.saveChangesBtnPersonBasic();
    }
    @Then("I update initial Source values {string}, {string}")
    public static void updateInitialSourceValues(String categoryText, String sourceText){
        PersonPage.updateInitialSourceValues(categoryText,sourceText);
    }
    @Then("I update context values {string}, {string}, {string}")
    public static void updateContextValues(String timeZone, String classOf,String currentGrade){
        PersonPage.updateContextValues(timeZone,classOf,currentGrade);
    }
    @Then("I update record flags {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public static void updateStudentRecordFlagValues(String deceased,String studentFlag,String firstGeneration,String internationalStudent,String legacy,String stateResident,String veteran){
        PersonPage.updateStudentRecordFlagValues(deceased,studentFlag,firstGeneration,internationalStudent,legacy,stateResident,veteran);
    }
}
