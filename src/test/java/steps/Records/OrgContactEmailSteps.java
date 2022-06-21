package steps.Records;

import io.cucumber.java.en.Then;
import pages.Records.OrgContactEmailPage;

public class OrgContactEmailSteps {


    @Then("I click on create a new email on contact for organization {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void createEmail(String emailAddress,String emailType,String emailStatus,String emailOptInMethod,String emailOptInStatus,String emailComments,String active,String primary,String group) {
        OrgContactEmailPage.createEmail(emailAddress,emailType,emailStatus,emailOptInMethod,emailOptInStatus,emailComments,active,primary,group);
    }

}
