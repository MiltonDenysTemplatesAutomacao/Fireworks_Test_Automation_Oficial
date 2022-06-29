package steps.Records;

import bean.AddressBean;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Records.PersonContactAddressPage;

public class PersonContactAddressSteps {


    @Then("I create address on contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, group {string}")
    public void createAddress(String address1,String address2,String address3,String address4,String city,String state,String region,String country,String postalCode,String addressType,String educationNeighborhood,String addressComments,String active,String primary,String group){
        AddressBean address = new AddressBean();
        address.address1 = address1;
        address.address2 = address2;
        address.address3 = address3;
        address.address4 = address4;
        address.city = city;
        address.state = state;
        address.region = region;
        address.country = country;
        address.postalCode = postalCode;
        address.addressType = addressType;
        address.educationNeighborhood = educationNeighborhood;
        address.addressComments = addressComments;
        address.active = active;
        address.primary = primary;
        PersonContactAddressPage.createAddress(address,group);
    }
    @And("I add address {string}")
    public static void addAddress(String group) {
        PersonContactAddressPage.addAddress(group);
    }
}
