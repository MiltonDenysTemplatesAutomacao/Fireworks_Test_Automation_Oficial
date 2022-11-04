package steps;

import io.cucumber.java.en.And;
import pages.records.EmailSettingsPage;

public class EmailSettingsSteps {

    @And("I update CAM-SPAM index {int}")
    public static void navigateEmailSettingsPage(int index) {

        EmailSettingsPage.setCANSPAMDefaultProfile(index);
    }

}
