package steps.Records;

import io.cucumber.java.en.Then;
import pages.Records.PersonContactEmailPage;

public class PersonContactEmailSteps {
    @Then("I verify email address {string} fields")
    public static void verifyEmailFieldsPersonPage(String index) {
        PersonContactEmailPage.verifyEmailPersonPageRecord(index);
    }
    @Then("I add a new email on contact for person group {string}")
    public static void addEmail(String index) {
        PersonContactEmailPage.addEmail(index);
    }
    @Then("I update email on contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and group {string}")
    public static void createEmail(String emailAddress,String emailType,String emailStatus,String emailOptInMethod,String emailOptInStatus,String emailComments,String active,String primary,String group) {
        PersonContactEmailPage.createEmail(emailAddress,emailType,emailStatus,emailOptInMethod,emailOptInStatus,emailComments,active,primary,group);
    }
}
