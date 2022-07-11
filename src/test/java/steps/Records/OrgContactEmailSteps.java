package steps.Records;

import bean.ContactEmailBean;
import io.cucumber.java.en.Then;
import pages.Records.OrgContactEmailPage;

public class OrgContactEmailSteps {


    @Then("I click on create a new email on contact for organization {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
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
        OrgContactEmailPage.createEmail(contactEmail,group);
    }
    @Then("I add a new email on contact for organization group {string}")
    public static void addEmail(String group) {
        OrgContactEmailPage.addEmail(group);
    }
    @Then("I verify email address for organization {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void verifyEmail(String emailAddress,String emailType,String emailStatus,String emailOptInMethod,String emailOptInStatus,String emailOptInDate,String emailComments,String active,String primary,String group) {
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
        OrgContactEmailPage.verifyEmail(contactEmail,group);
    }

}
