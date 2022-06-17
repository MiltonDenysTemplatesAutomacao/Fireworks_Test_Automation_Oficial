package steps.Records;

import io.cucumber.java.en.Then;
import pages.Records.PersonContactAddressPage;

public class PersonContactAddressSteps {
    @Then("I create address on contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, group {string}")
    public static void createPhoneForPerson(String address1,String address2,String address3,String address4,String city,String state,String region,String country,String postalCode,String addressType,String educationNeighborhood,String addressComments,String active,String primary, String group){
        PersonContactAddressPage.createAddress(address1,address2,address3,address4,city,state,region,country,postalCode,addressType,educationNeighborhood,addressComments,active,primary,group);
    }
}
