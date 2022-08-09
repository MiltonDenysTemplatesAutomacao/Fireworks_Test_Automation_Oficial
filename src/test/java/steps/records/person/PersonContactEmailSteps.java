package steps.records.person;

import bean.ContactEmailBean;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.records.person.PersonContactEmailPage;

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
        contactEmail.setEmailAddress(emailAddress);
        contactEmail.setEmailType(emailType);
        contactEmail.setEmailStatus(emailStatus);
        contactEmail.setEmailOptInMethod(emailOptInMethod);
        contactEmail.setEmailOptInStatus(emailOptInStatus);
        contactEmail.setEmailComments(emailComments);
        contactEmail.setActive(active);
        contactEmail.setPrimary(primary);
        PersonContactEmailPage.createEmail(contactEmail,group);
    }
    @When("I verify read only email {string}")
    public static void verifyValidationMessage(String group) {
        PersonContactEmailPage.verifyReadOnlyEmail(group);
    }
    @When("I verify email address {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void verifyEmailPersonPageRecordParametersSteps(String emailAddress,String emailType,String emailStatus,String emailOptInMethod,String emailOptInStatus,String emailOptInDate, String emailComments,String active,String primary,String group) {
        ContactEmailBean contactEmail = new ContactEmailBean();
        contactEmail.setEmailAddress(emailAddress);
        contactEmail.setEmailType(emailType);
        contactEmail.setEmailStatus(emailStatus);
        contactEmail.setEmailOptInMethod(emailOptInMethod);
        contactEmail.setEmailOptInStatus(emailOptInStatus);
        contactEmail.setEmailComments(emailComments);
        contactEmail.setActive(active);
        contactEmail.setPrimary(primary);
        contactEmail.setEmailOptInDate(emailOptInDate);
        PersonContactEmailPage.verifyEmailPersonPageRecordParametersSteps(contactEmail,group);
    }
}
