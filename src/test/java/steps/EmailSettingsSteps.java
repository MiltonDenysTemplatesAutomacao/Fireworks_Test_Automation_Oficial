package steps;

import io.cucumber.java.en.And;
import pages.records.EmailSettingsPage;

public class EmailSettingsSteps {

    @And("I update CAM-SPAM index {int}")
    public static void setCANSPAMDefaultProfile(int index) {
        EmailSettingsPage.setCANSPAMDefaultProfile(index);
    }
    @And("I click on Test Lists")
    public static void clickTestLists() {
        EmailSettingsPage.clickTestLists();
    }
    @And("I click on create test list button")
    public static void clickCreateTestListButton() {
        EmailSettingsPage.clickCreateTestListButton();
    }
    @And("I update test list {string}, {string}, {string}")
    public static void updateTestList(String name,String description,String recipients) {
        EmailSettingsPage.updateTestList(name,description,recipients);
    }

}
