package steps.records;

import io.cucumber.java.en.When;
import pages.records.ImportRunPage;

public class ImportRunSteps {


    @When("I update Run Tab Actions {string}, {string}, {string}, {string}, {string}")
    public static void updateRunTabActions(String category,String action,String staff,String actionDate,String comments) {
        ImportRunPage.updateRunTabActions(category,action,staff,actionDate,comments);
    }

}
