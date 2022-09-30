package steps;

import io.cucumber.java.en.Then;
import pages.DuplicatesPage;

public class DuplicatesSteps {

    @Then("I verify content of the suspended record person {int}")
    public static void verifyContentOfSuspendedRecord(int person) {
        DuplicatesPage.verifyContentOfSuspendedRecord(person);
    }
    @Then("I make suspended record active")
    public static void makeSuspendedRecordActive() {
        DuplicatesPage.makeSuspendedRecordActive();
    }
    @Then("I verify content of the {string} possible match record person {int}")
    public static void verifyContentOfPossibleMatch(String possibleMatch,int person) {
        DuplicatesPage.verifyContentOfPossibleMatch(possibleMatch,person);
    }
    @Then("I merge duplicates")
    public static void mergeDuplicates() {
        DuplicatesPage.mergeDuplicates();
    }
    @Then("I verify merge preview {int}")
    public static void verifyMergePreview(int person) {
        DuplicatesPage.verifyMergePreview(person);
    }
    @Then("I confirm merge and close")
    public static void confirmMergeAndClose() {
        DuplicatesPage.confirmMergeAndClose();
    }
    @Then("I open a duplicate")
    public static void openDuplicate() {
        DuplicatesPage.openDuplicate();
    }
    @Then("I confirm merge and go")
    public static void confirmMergeAndGo() {
        DuplicatesPage.confirmMergeAndGo();
    }
    @Then("I validate if {string} record lo longer exists on the duplicates page")
    public static void verifyIfRecordNoLongerExistsOnDuplicatesPage(String fullname) {
        DuplicatesPage.verifyIfRecordNoLongerExistsOnDuplicatesPage(fullname);
    }
    @Then("I search {string} on duplicate manager person {int}")
    public static void searchDuplicateManager(String parameter,int person) {
        DuplicatesPage.searchDuplicateManager(parameter,person);
    }
    @Then("I verify if it is able to see {string}")
    public static void verifyDuplicateFound(String duplicate) {
        DuplicatesPage.verifyDuplicateFound(duplicate);
    }
    @Then("I verify if it is not able to see {string}")
    public static void verifyDuplicateNotFound(String duplicate) {
        DuplicatesPage.verifyDuplicateNotFound(duplicate);
    }

}
