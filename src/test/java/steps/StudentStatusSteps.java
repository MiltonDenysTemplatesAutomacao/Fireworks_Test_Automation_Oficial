package steps;

import io.cucumber.java.en.Then;
import pages.Records.StudentStatusPage;

public class StudentStatusSteps {

    @Then("I verify student status {string}")
    public static void verifyStudentStatus(String index) {
        StudentStatusPage.verifyStudentStatus(index);
    }



}
