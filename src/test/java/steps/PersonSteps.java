package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PersonPage;
import pages.StaffPage;

public class PersonSteps {

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
    @Then("I update Header Assigned Staff {string}")
    public static void updateHeaderAssignedStaff(String assignedStaff) {
        PersonPage.updateHeaderAssignedStaff(assignedStaff);
    }
    @Then("I update Header Role {string}")
    public static void updateHeaderRole(String role) {
        PersonPage.updateHeaderRole(role);
    }
    @Then("verify if {string} role are selected")
    public static void verifyRolesActive(String role) {
        PersonPage.verifyRolesActive(role);
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
    @Then("I click on save changes in contact for person")
    public static void saveChangesBtnPersonContact() {
        PersonPage.saveChangesBtnPersonContact();
    }
    @When("I update {string}, {string}, {string}, {string}, {string} and {string} to update name")
    public static void updateName(String firstName,String lastName,String middleName,String preferredName, String suffix, String salutation) {
        PersonPage.updateNameValues(firstName,lastName,middleName,preferredName,suffix,salutation);
    }
    @When("I update {string}, {string}, {string}, {string}, and {string} to update external ID Types for person")
    public static void updateExternalIdTypes(String type,String idNumber,String idRecordedDate,String whoAddedId, String comments) {
        PersonPage.updateExternalIdTypes(type,idNumber,idRecordedDate,whoAddedId,comments);
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
    @Then("I verify Header Record Status {string} for person")
    public static void verifyHeaderRecordStatus(String status) {
        PersonPage.verifyHeaderRecordStatus(status);
    }
    @Then("I update Header Record Status {string} for person")
    public static void updateHeaderRecordStatus(String status) {
        PersonPage.updateHeaderRecordStatus(status);
    }

}
