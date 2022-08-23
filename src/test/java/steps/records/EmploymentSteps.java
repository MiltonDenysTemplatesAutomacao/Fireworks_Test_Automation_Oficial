package steps.records;

import io.cucumber.java.en.Then;
import pages.records.EmploymentPage;

public class EmploymentSteps {
    @Then("I update Employment {string}, {string}, {string}, {string}, {string} group {string}")
    public static void updateEmployment(String position,String startDate,String endDate,String duties,String comments,String group) {
        EmploymentPage.updateEmployment(position,startDate,endDate,duties,comments,group);
    }
    @Then("I verify Employment {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void verifyEmployment(String employerName, String position,String startDate,String endDate,String duties,String comments,String group) {
        EmploymentPage.verifyEmployment(employerName,position,startDate,endDate,duties,comments,group);
    }
    @Then("I pick an organization Employer {string} group {string}")
    public static void pickEmployer(String employerName,String group) {
        EmploymentPage.pickEmployer(employerName,group);
    }
    @Then("I add Employment group {string}")
    public static void addEmployment(String group) {
        EmploymentPage.addEmployment(group);
    }
}
