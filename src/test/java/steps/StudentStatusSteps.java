package steps;

import io.cucumber.java.en.Then;
import pages.Records.StudentStatusPage;

public class StudentStatusSteps {

    @Then("I verify student status {string}")
    public static void verifyStudentStatus(String index) {
        StudentStatusPage.verifyStudentStatus(index);
    }
    @Then("I click on add student status {string}")
    public static void clickAddStudentStatus(String index) {
        StudentStatusPage.clickOnAddStudentStatus(index);
    }
    @Then("I update student status {string}")
    public static void updateStudentStatus(String index) {
        StudentStatusPage.updateStudentStatus(index);
    }
    @Then("I click on Save Changes button in Student Status")
    public static void clickSaveChanges() {
        StudentStatusPage.clickSaveChangesStudentStatus();
    }



}
