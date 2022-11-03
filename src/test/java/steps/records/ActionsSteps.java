package steps.records;

import io.cucumber.java.en.Then;
import pages.records.ActionsPage;

public class ActionsSteps {

    @Then("I click on add action button")
    public static void createAction() {
        ActionsPage.createAction();
    }
    @Then("I update action person {string}")
    public static void updateAction(String person) {
        ActionsPage.updateAction(person);
    }
    @Then("I verify if action manager table on actions row 1 is displayed")
    public static void verifyActionManagerTableRow1IsDisplayed() {
        ActionsPage.verifyActionManagerTableRow1IsDisplayed();
    }
    @Then("I verify if action manager table on actions row 2 is not displayed")
    public static void verifyActionManagerTableRow2IsNotDisplayed() {
        ActionsPage.verifyActionManagerTableRow2IsNotDisplayed();
    }
    @Then("I click on Save Changes button in Actions")
    public static void clickSaveChangesActions() {
        ActionsPage.clickSaveChangesActions();
    }

    @Then("I verify action Datatable values index {string}, values {string}, {string}, {string}, {string}, {string}")
    public static void verifyActionDataTableValues(String index, String category, String action, String staff, String actionDate, String comments) {
        ActionsPage.verifyActionDataTableValues(index,category,action,staff,actionDate,comments);
    }
    @Then("I open an action {string}")
    public static void openAction(String action) {
        ActionsPage.openAction(action);
    }
    @Then("I search an action {string}")
    public static void searchAction(String action) {
        ActionsPage.searchAction(action);
    }
    @Then("I verify default action values index {string}")
    public static void verifyDefaultActionValues(String index) {
        ActionsPage.verifyDefaultActionValues(index);
    }
    @Then("I validate if link text is correct {string}")
    public static void verifyLinkText(String text) {
        ActionsPage.verifyLinkText(text);
    }
    @Then("I verify current action date time")
    public static void verifyCurrentActionDateField() {
        ActionsPage.verifyCurrentActionDateField();
    }
    @Then("I delete action")
    public static void deleteAction() {
        ActionsPage.deleteAction();
    }
    @Then("I validate if action were deleted")
    public static void validateActionDeleted() {
        ActionsPage.validateActionDeleted();
    }
    @Then("I validate if delete button in action is visible")
    public static void validateDeleteButtonIsVisible() {
        ActionsPage.validateDeleteButtonIsVisible();
    }
    @Then("I validate if disable delete button is not visible")
    public static void validateDisabledDeleteButtonIsNotVisible() {
        ActionsPage.validateDisabledDeleteButtonIsNotVisible();
    }
    @Then("I click on delete button in action")
    public static void clickDeleteButton() {
        ActionsPage.clickDeleteButton();
    }
    @Then("I validate if delete modal is visible")
    public static void validateDeleteModalIsVisible() {
        ActionsPage.validateDeleteModalIsVisible();
    }
    @Then("I click on cancel button on delete action modal")
    public static void clickCancelButtonOnDeleteModal() {
        ActionsPage.clickCancelButtonOnDeleteModal();
    }
    @Then("I validate if delete modal is not visible")
    public static void validateDeleteModalIsNotVisible() {
        ActionsPage.validateDeleteModalIsNotVisible();
    }
}
