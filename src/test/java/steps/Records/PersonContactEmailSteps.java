package steps.Records;

import bean.ContactEmailBean;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        ContactEmailBean contactEmail = new ContactEmailBean();
        contactEmail.emailAddress = emailAddress;
        contactEmail.emailType = emailType;
        contactEmail.emailStatus = emailStatus;
        contactEmail.emailOptInMethod = emailOptInMethod;
        contactEmail.emailOptInStatus = emailOptInStatus;
        contactEmail.emailComments = emailComments;
        contactEmail.active = active;
        contactEmail.primary = primary;
        PersonContactEmailPage.createEmail(contactEmail,group);
    }
    @When("I verify read only email {string}")
    public static void verifyValidationMessage(String group) {
        PersonContactEmailPage.verifyReadOnlyEmail(group);
    }
    @When("I verify email address {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void verifyEmailPersonPageRecordParametersSteps(String emailAddress,String emailType,String emailStatus,String emailOptInMethod,String emailOptInStatus,String emailOptInDate, String emailComments,String active,String primary,String group) {
        ContactEmailBean contactEmail = new ContactEmailBean();
        contactEmail.emailAddress = emailAddress;
        contactEmail.emailType = emailType;
        contactEmail.emailStatus = emailStatus;
        contactEmail.emailOptInDate = emailOptInDate;
        contactEmail.emailOptInMethod = emailOptInMethod;
        contactEmail.emailOptInStatus = emailOptInStatus;
        contactEmail.emailComments = emailComments;
        contactEmail.active = active;
        contactEmail.primary = primary;
        PersonContactEmailPage.verifyEmailPersonPageRecordParametersSteps(contactEmail,group);
    }
}
