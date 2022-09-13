package steps.records.imports;

import io.cucumber.java.en.And;
import pages.records.imports.ImportsPackagePage;

public class ImportsPackageSteps {

    @And("I create a package")
    public static void createPackage() {
        ImportsPackagePage.createPackage();
    }
    @And("I click save and continue button {string}")
    public static void clickSaveAndContinue(String tab) {
        ImportsPackagePage.clickSaveAndContinuePackage(tab);
    }
    @And("I update PackageStartTab {string}, {string}, {string}, {string}")
    public static void updatePackageStartTab(String name,String description,String sourceFile,String recordType) {
        ImportsPackagePage.updatePackageStartTab(name,description,sourceFile,recordType);
    }
    @And("I update Package Actions {string}, {string}, {string}")
    public static void updatePackageActions(String category,String action,String comments) {
        ImportsPackagePage.updatePackageActions(category,action,comments);
    }
}
