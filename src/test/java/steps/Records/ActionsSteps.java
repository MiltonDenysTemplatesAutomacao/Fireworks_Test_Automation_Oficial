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
    @Then("I verify action Datatable values index {int}")
    public static void verifyActionDataTableValues(int index) {
        ActionsPage.verifyActionDataTableValues(index);
    }
    @Then("I open an action {string}")
    public static void openAction(String action) {
        ActionsPage.openAction(action);
    }
    @Then("I verify action values index {string}")
    public static void verifyActionValues(String index) {
        ActionsPage.verifyActionValues(index);
    }
    @Then("I verify default action values index {string}")
    public static void verifyDefaultActionValues(String index) {
        ActionsPage.verifyDefaultActionValues(index);
    }
}
