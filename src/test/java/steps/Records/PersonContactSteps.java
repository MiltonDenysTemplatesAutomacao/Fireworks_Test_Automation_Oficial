package steps.Records;

import io.cucumber.java.en.Then;
import pages.PersonPage;
import pages.Records.PersonContactPage;

public class PersonContactSteps {

    @Then("I verify email address {string} fields")
    public static void verifyEmailFieldsPersonPage(String index) {
        PersonContactPage.verifyEmailPersonPageRecord(index);
    }
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
    @Then("I create address on contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, group {string}")
    public static void createPhoneForPerson(String address1,String address2,String address3,String address4,String city,String state,String region,String country,String postalCode,String addressType,String educationNeighborhood,String addressComments,String active,String primary, String group){
        PersonContactPage.createAddress(address1,address2,address3,address4,city,state,region,country,postalCode,addressType,educationNeighborhood,addressComments,active,primary,group);
    }



}
