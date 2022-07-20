package steps;

import io.cucumber.java.en.When;
import pages.AdminPanelPage;

public class AdminPanelSteps {

    @When("I update required school name {string}")
    public static void updateRequiredSchoolName(String schoolName) {
        AdminPanelPage.updateRequiredSchoolName(schoolName);
    }
    @When("I update High Score Display {string}")
    public static void updateHighScoreDisplay(String highScore) {
        AdminPanelPage.updateHighScoreDisplay(highScore);
    }
    @When("I update SAT R2016 High Score {string}")
    public static void updateSATR2016HighScore(String satR2016HighScore) {
        AdminPanelPage.updateSATR2016HighScore(satR2016HighScore);
    }
    @When("I click on save changes for Admin Panel on basic tab")
    public static void saveChangesBasicAdminPanel() {
        AdminPanelPage.saveChangesBasicAdminPanel();
    }

}
