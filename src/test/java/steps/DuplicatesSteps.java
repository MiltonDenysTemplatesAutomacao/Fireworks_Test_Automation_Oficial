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
    @Then("I verify content of the first possible match record person {int}")
    public static void verifyContentOfFirstPossibleMatch(int person) {
        DuplicatesPage.verifyContentOfFirstPossibleMatch(person);
    }
    @Then("I merge duplicates")
    public static void mergeDuplicates() {
        DuplicatesPage.mergeDuplicates();
    }
    @Then("I verify merge preview")
    public static void verifyMergePreview() {
        DuplicatesPage.verifyMergePreview();
    }
    @Then("I confirm merge and close")
    public static void confirmMergeAndClose() {
        DuplicatesPage.confirmMergeAndClose();
    }
    @Then("I validate if {string} record lo longer exists on the duplicates page")
    public static void verifyIfRecordNoLongerExistsOnDuplicatesPage(String fullname) {
        DuplicatesPage.verifyIfRecordNoLongerExistsOnDuplicatesPage(fullname);
    }
    @Then("I search {string} on duplicate manager person {int}")
    public static void searchDuplicateManager(String parameter,int person) {
        DuplicatesPage.searchDuplicateManager(parameter,person);
    }

}
