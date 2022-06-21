package steps.Records;

import io.cucumber.java.en.Then;
import pages.Records.PersonContactPhonePage;

public class PersonContactPhoneSteps {

    @Then("I add phone {string}")
    public static void addPhone(String index) {
        PersonContactPhonePage.addPhone(index);
    }
    @Then("I update phone number in contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} field group {string}")
    public static void createPhoneForPerson(String phoneNumber, String phoneType,String phoneStatus, String phoneOptInMethod, String phoneOptInStatus, String phoneComments, String active,String primary,String group){
        PersonContactPhonePage.createPhoneForPerson(phoneNumber,phoneType,phoneStatus,phoneOptInMethod,phoneOptInStatus,phoneComments,active,primary,group);
    }
    @Then("I verify phone number on contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, group {string}")
    public static void verifyPhone(String phoneNumber, String phoneType,String phoneStatus, String timeZone, String phoneOptInMethod, String phoneOptInStatus, String optInStatusDate, String phoneComments, String active,String primary,String group) {
        PersonContactPhonePage.verifyPhone(phoneNumber,phoneType,phoneStatus,timeZone,phoneOptInMethod,phoneOptInStatus,optInStatusDate, phoneComments,active,primary,group);
    }
}
