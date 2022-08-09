package steps.records.organization;

import bean.ContactPhoneBean;
import io.cucumber.java.en.Then;
import pages.records.organization.OrgContactPhone;

public class OrgContactPhoneSteps {

    @Then("I verify phone number on contact for organization {string}, {string}, {string}, {string}, {string}, {string}, {string}, group {string}")
    public static void verifyPhone(String phoneNumber, String phoneType,String phoneStatus, String timeZone, String phoneComments, String active,String primary,String group) {
        ContactPhoneBean contactPhone = new ContactPhoneBean();
        contactPhone.setPhoneNumber(phoneNumber);
        contactPhone.setPhoneType(phoneType);
        contactPhone.setPhoneStatus(phoneStatus);
        contactPhone.setPhoneComments(phoneComments);
        contactPhone.setActive(active);
        contactPhone.setPrimary(primary);
        contactPhone.setPhoneTimeZone(timeZone);
        OrgContactPhone.verifyPhoneContactOrg(contactPhone,group);
    }
}
