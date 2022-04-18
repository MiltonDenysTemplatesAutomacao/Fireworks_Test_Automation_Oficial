package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.StaffPage;

public class StaffSteps {

    @When("I update {string}, {string} and {string} to update phone number")
    public static void updatePhoneNumber(String phone,String phoneType,String comment) {
        StaffPage.updatePhoneNumber(phone,phoneType,comment);
    }
}
