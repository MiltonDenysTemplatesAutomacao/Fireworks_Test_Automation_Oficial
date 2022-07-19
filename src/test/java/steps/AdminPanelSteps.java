package steps;

import io.cucumber.java.en.When;
import pages.AdminPanelPage;

public class AdminPanelSteps {

    @When("I update required school name {string}")
    public static void updateRequiredSchoolName(String schoolName) {
        AdminPanelPage.updateRequiredSchoolName(schoolName);
    }

}
