package steps.records.imports;

import io.cucumber.java.en.When;
import pages.records.imports.ImportRunPage;

public class ImportRunSteps {


    @When("I update Run Tab Actions {string}, {string}, {string}, {string}, {string}")
    public static void updateRunTabActions(String category,String action,String staff,String actionDate,String comments) {
        ImportRunPage.updateRunTabActions(category,action,staff,actionDate,comments);
    }
    @When("I click on Run Import button")
    public static void runImport() {
        ImportRunPage.runImport();
    }
    @When("I click on review import button")
    public static void clickReviewImport() {
        ImportRunPage.clickReviewImport();
    }
    @When("I verify if package settings were loaded {string}, {string}")
    public static void verifyPackageSettingsLoaded(String packageName,String sourceFile) {
        ImportRunPage.verifyPackageSettingsLoaded(packageName,sourceFile);
    }

}
