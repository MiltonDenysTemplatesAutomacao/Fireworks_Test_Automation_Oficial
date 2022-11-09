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

}
