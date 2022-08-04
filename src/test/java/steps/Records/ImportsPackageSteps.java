package steps.Records;

import io.cucumber.java.en.And;
import pages.Records.ImportsPackagePage;

public class ImportsPackageSteps {

    @And("I create a package")
    public static void createPackage() {
        ImportsPackagePage.createPackage();
    }
    @And("I click save and continue button {string}")
    public static void clickSaveAndContinue() {
        ImportsPackagePage.clickSaveAndContinue();
    }
    @And("I update PackageStartTab {string}, {string}, {string}, {string}")
    public static void updatePackageStartTab(String name,String description,String sourceFile,String recordType) {
        ImportsPackagePage.updatePackageStartTab(name,description,sourceFile,recordType);
    }

}
