package steps.Records;

import bean.ContactAddressBean;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Records.PersonContactAddressPage;

public class PersonContactAddressSteps {


    @Then("I verify address on contact por person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public void verifyAddress(String address1,String address2,String address3,String address4,String city,String county, String state,String region,String country,String postalCode,String geomarket, String addressType,String educationNeighborhood,String addressComments,String active,String primary,String group){
        ContactAddressBean contactAddress = new ContactAddressBean();
        contactAddress.address1 = address1;
        contactAddress.address2 = address2;
        contactAddress.address3 = address3;
        contactAddress.address4 = address4;
        contactAddress.city = city;
        contactAddress.county=county;
        contactAddress.state = state;
        contactAddress.region = region;
        contactAddress.country = country;
        contactAddress.postalCode = postalCode;
        contactAddress.geomarket = geomarket;
        contactAddress.addressType = addressType;
        contactAddress.educationNeighborhood = educationNeighborhood;
        contactAddress.addressComments = addressComments;
        contactAddress.active = active;
        contactAddress.primary = primary;
        PersonContactAddressPage.verifyAddress(contactAddress,group);
    }

    @Then("I create address on contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, group {string}")
    public void createAddress(String address1,String address2,String address3,String address4,String city,String state,String region,String country,String postalCode,String addressType,String educationNeighborhood,String addressComments,String active,String primary,String group){
        ContactAddressBean contactAddress = new ContactAddressBean();
        contactAddress.address1 = address1;
        contactAddress.address2 = address2;
        contactAddress.address3 = address3;
        contactAddress.address4 = address4;
        contactAddress.city = city;
        contactAddress.state = state;
        contactAddress.region = region;
        contactAddress.country = country;
        contactAddress.postalCode = postalCode;
        contactAddress.addressType = addressType;
        contactAddress.educationNeighborhood = educationNeighborhood;
        contactAddress.addressComments = addressComments;
        contactAddress.active = active;
        contactAddress.primary = primary;
        PersonContactAddressPage.createAddress(contactAddress,group);
    }
    @And("I add address {string}")
    public static void addAddress(String group) {
        PersonContactAddressPage.addAddress(group);
    }
}
