package steps.Records;

import bean.ContactPhoneBean;
import io.cucumber.java.en.Then;
import pages.Records.PersonContactPhonePage;

public class PersonContactPhoneSteps {

    @Then("I add phone {string}")
    public static void addPhone(String index) {
        PersonContactPhonePage.addPhone(index);
    }
    @Then("I update phone number in contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} field group {string}")
    public static void createPhoneForPerson(String phoneNumber, String phoneType,String phoneStatus, String phoneOptInMethod, String phoneOptInStatus, String phoneComments, String active,String primary,String group){
        ContactPhoneBean contactPhone = new ContactPhoneBean();
        contactPhone.phoneNumber = phoneNumber;
        contactPhone.phoneType = phoneType;
        contactPhone.phoneStatus = phoneStatus;
        contactPhone.phoneOptInMethod = phoneOptInMethod;
        contactPhone.phoneOptInStatus = phoneOptInStatus;
        contactPhone.phoneComments = phoneComments;
        contactPhone.active = phoneNumber;
        contactPhone.primary = primary;
        PersonContactPhonePage.createPhoneForPerson(contactPhone,group);
    }
    @Then("I verify phone number on contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, group {string}")
    public static void verifyPhone(String phoneNumber, String phoneType,String phoneStatus, String timeZone, String phoneOptInMethod, String phoneOptInStatus, String optInStatusDate, String phoneComments, String active,String primary,String group) {
        ContactPhoneBean contactPhone = new ContactPhoneBean();
        contactPhone.phoneNumber = phoneNumber;
        contactPhone.phoneType = phoneType;
        contactPhone.phoneStatus = phoneStatus;
        contactPhone.phoneOptInMethod = phoneOptInMethod;
        contactPhone.phoneOptInStatus = phoneOptInStatus;
        contactPhone.phoneTimeZone = timeZone;
        contactPhone.phoneComments = phoneComments;
        contactPhone.active = phoneNumber;
        contactPhone.primary = primary;
        PersonContactPhonePage.verifyPhone(contactPhone,group);
    }
}
