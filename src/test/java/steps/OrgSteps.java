package steps;

import io.cucumber.java.en.When;
import pages.OrgPage;
import pages.PersonPage;

public class OrgSteps {

    @When("I update {string}, {string}, {string}, {string}, {string}, {string} and {string} to update email address")
    public static void updateEmailAddress(String emailAddress,String emailType,String emailOpt, String optStatus, String optDate, String emailStatus, String emailContent) {
        OrgPage.updateEmailAddress(emailAddress,emailType,emailOpt,optStatus,optDate,emailStatus,emailContent);
    }
}
