package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.QuickSearchPage;

public class QuickSearchSteps {
    @Then("I validate if result for {string} is correct")
    public static void validateIfSearchResultIsCorrect(String parameter) {
        QuickSearchPage.validateIfSearchResultIsCorrect(parameter);
    }
    @And("I open a record")
    public static void openRecord() {
        QuickSearchPage.openRecord();
    }

    @And("I validate if {string}summary opened properly")
    public static void validateIfOpenedSummaryProperly(String parameter) {
        QuickSearchPage.validateIfOpenedSummaryProperly(parameter);
    }

}
