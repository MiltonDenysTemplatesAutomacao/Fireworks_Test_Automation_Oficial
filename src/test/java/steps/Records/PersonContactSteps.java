package steps.Records;

import io.cucumber.java.en.Then;
import pages.PersonPage;
import pages.Records.PersonContactPage;

public class PersonContactSteps {

    @Then("I click on save changes in contact for person")
    public static void saveChangesBtnPersonContact() {
        PersonPage.saveChangesBtnPersonContact();
    }
    @Then("I verify phone number on contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, group {string}")
    public static void verifyPhone(String phoneNumber, String phoneType,String phoneStatus, String timeZone, String phoneOptInMethod, String phoneOptInStatus, String optInStatusDate, String phoneComments, String active,String primary,String group) {
        PersonContactPage.verifyPhone(phoneNumber,phoneType,phoneStatus,timeZone,phoneOptInMethod,phoneOptInStatus,optInStatusDate, phoneComments,active,primary,group);
    }
    @Then("I update phone number in contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} field group {string}")
    public static void createPhoneForPerson(String phoneNumber, String phoneType,String phoneStatus, String phoneOptInMethod, String phoneOptInStatus, String phoneComments, String active,String primary,String group){
        PersonContactPage.createPhoneForPerson(phoneNumber,phoneType,phoneStatus,phoneOptInMethod,phoneOptInStatus,phoneComments,active,primary,group);
    }
}
