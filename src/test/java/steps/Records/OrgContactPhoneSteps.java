package steps.Records;

import bean.ContactPhoneBean;
import io.cucumber.java.en.Then;
import pages.Records.OrgContactPhone;

public class OrgContactPhoneSteps {



    @Then("I verify phone number on contact for organization {string}, {string}, {string}, {string}, {string}, {string}, {string}, group {string}")
    public static void verifyPhone(String phoneNumber, String phoneType,String phoneStatus, String timeZone, String phoneComments, String active,String primary,String group) {
        ContactPhoneBean contactPhone = new ContactPhoneBean();
        contactPhone.phoneNumber = phoneNumber;
        contactPhone.phoneType = phoneType;
        contactPhone.phoneStatus = phoneStatus;
        contactPhone.phoneTimeZone = timeZone;
        contactPhone.phoneComments = phoneComments;
        contactPhone.active = active;
        contactPhone.primary = primary;
        OrgContactPhone.verifyPhoneContactOrg(contactPhone,group);
    }
}
