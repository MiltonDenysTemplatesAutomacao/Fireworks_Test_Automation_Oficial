package steps.records;

import io.cucumber.java.en.Then;
import pages.records.EmploymentPage;

public class EmploymentSteps {
    @Then("I update Employment {string}, {string}, {string}, {string}, {string} group {string}")
    public static void updateEmployment(String position,String startDate,String endDate,String duties,String comments,String group) {
        EmploymentPage.updateEmployment(position,startDate,endDate,duties,comments,group);
    }
}
