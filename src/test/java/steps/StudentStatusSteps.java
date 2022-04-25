package steps;

import io.cucumber.java.en.Then;
import pages.Records.StudentStatusPage;

public class StudentStatusSteps {

    @Then("I verify student status group {string} person {int}")
    public static void verifyStudentStatus(String studentStatus, int person) {
        StudentStatusPage.verifyStudentStatus(studentStatus, person);
    }
    @Then("I click on add student status {string}")
    public static void clickAddStudentStatus(String index) {
        StudentStatusPage.clickOnAddStudentStatus(index);
    }

    @Then("I update student status group {string} person {int}")
    public static void updateStudentStatus(String index, int person) {
        StudentStatusPage.updateStudentStatus(index,person);
    }
    @Then("I click on Save Changes button in Student Status")
    public static void clickSaveChanges() {
        StudentStatusPage.clickSaveChangesStudentStatus();
    }
    @Then("I click on status primary checkbox {string}")
    public static void clickStudentStatusPrymaryCheckbox(String index) {
        StudentStatusPage.clickStudentStatusPrymaryCheckbox(index);
    }
    @Then("I click on status active checkbox {string}")
    public static void clickStudentStatusActiveCheckbox(String index) {
        StudentStatusPage.clickStudentStatusActiveCheckbox(index);
    }



}
