package steps;

import io.cucumber.java.en.Then;
import pages.DuplicatesPage;

public class DuplicatesSteps {

    @Then("I verify content of the suspended record")
    public static void verifyContentOfSuspendedRecord() {
        DuplicatesPage.verifyContentOfSuspendedRecord();
    }
    @Then("I verify content of the first possible match record")
    public static void verifyContentOfFirstPossibleMatch() {
        DuplicatesPage.verifyContentOfFirstPossibleMatch();
    }
    @Then("I merge duplicates")
    public static void mergeDuplicates() {
        DuplicatesPage.mergeDuplicates();
    }

}
