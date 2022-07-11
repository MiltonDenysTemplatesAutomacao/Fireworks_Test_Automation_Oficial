package steps.Records;

import bean.ContactPhoneBean;
import io.cucumber.java.en.Then;
import pages.Records.PersonContactPhonePage;

public class PersonContactPhoneSteps {

    @Then("I add phone {string}")
    public static void addPhone(String index) {
        PersonContactPhonePage.addPhone(index);
    }
    @Then("I verify phone read only group {string}")
    public static void verifyPhoneReadOnly(String index) {
        PersonContactPhonePage.verifyPhoneReadOnly(index);
    }
    @Then("I update phone number in contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} field group {string}")
    public static void createPhoneForPerson(String phoneNumber, String phoneType,String phoneStatus, String phoneOptInMethod, String phoneOptInStatus, String phoneComments, String active,String primary,String group){
        ContactPhoneBean contactPhone = new ContactPhoneBean();
        contactPhone.setPhoneNumber(phoneNumber);
        contactPhone.setPhoneType(phoneType);
        contactPhone.setPhoneStatus(phoneStatus);
        contactPhone.setPhoneOptInMethod(phoneOptInMethod);
        contactPhone.setPhoneOptInStatus(phoneOptInStatus);
        contactPhone.setPhoneComments(phoneComments);
        contactPhone.setActive(active);
        contactPhone.setPrimary(primary);
        PersonContactPhonePage.createPhoneForPerson(contactPhone,group);
    }
    @Then("I verify phone number on contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, group {string}")
    public static void verifyPhone(String phoneNumber, String phoneType,String phoneStatus, String timeZone, String phoneOptInMethod, String phoneOptInStatus, String optInStatusDate, String phoneComments, String active,String primary,String group) {
        ContactPhoneBean contactPhone = new ContactPhoneBean();
        contactPhone.setPhoneNumber(phoneNumber);
        contactPhone.setPhoneType(phoneType);
        contactPhone.setPhoneStatus(phoneStatus);
        contactPhone.setPhoneOptInMethod(phoneOptInMethod);
        contactPhone.setPhoneOptInStatus(phoneOptInStatus);
        contactPhone.setPhoneComments(phoneComments);
        contactPhone.setActive(active);
        contactPhone.setPrimary(primary);
        contactPhone.setPhoneOptInStatusDate(optInStatusDate);
        contactPhone.setPhoneTimeZone(timeZone);
        PersonContactPhonePage.verifyPhone(contactPhone,group);
    }
}
