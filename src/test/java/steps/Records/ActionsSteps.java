package steps.Records;

import io.cucumber.java.en.Then;
import pages.Records.ActionsPage;

public class ActionsSteps {

    @Then("I click on add action button")
    public static void createAction() {
        ActionsPage.createAction();
    }
    @Then("I update action person {string}")
    public static void updateAction(String person) {
        ActionsPage.updateAction(person);
    }
    @Then("I click on Save Changes button in Actions")
    public static void clickSaveChangesActions() {
        ActionsPage.clickSaveChangesActions();
    }
}
