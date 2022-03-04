package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.QuickSearchPage;
import pages.StaffPage;

public class StaffSteps {
    @Then("I navigate to contact")
    public static void navigateToContact() {
        StaffPage.navigateToContact();
    }
    @When(" I update phone number")
    public static void updatePhoneNumber() {
        StaffPage.navigateToContact();
    }



}
