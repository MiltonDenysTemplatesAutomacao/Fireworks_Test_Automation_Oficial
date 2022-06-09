package steps;


import io.cucumber.java.en.Then;
import pages.ClearChangesPage;

public class ClearChangesSteps {
    @Then("I click on clear changes on actions for {string}")
    public static void validateDisabledDeleteButtonIsNotVisible(String parameter) {
        ClearChangesPage.clickClearChangesActions(parameter);
    }
    @Then("I click on clear changes on Basic")
    public static void clearChangesBasic() {
        ClearChangesPage.clearChangesBasic();
    }
}