package steps.records.person;

import bean.ContactAddressBean;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.records.person.PersonContactAddressPage;

public class PersonContactAddressSteps {


    @Then("I verify address on contact por person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public void verifyAddress(String address1,String address2,String address3,String address4,String city,String county, String state,String region,String country,String postalCode,String geomarket, String addressType,String educationNeighborhood,String addressComments,String active,String primary,String group){
        ContactAddressBean contactAddress = new ContactAddressBean();
        contactAddress.setAddress1(address1);
        contactAddress.setAddress2(address2);
        contactAddress.setAddress3(address3);
        contactAddress.setAddress4(address4);
        contactAddress.setCity(city);
        contactAddress.setCounty(county);
        contactAddress.setState(state);
        contactAddress.setRegion(region);
        contactAddress.setCountry(country);
        contactAddress.setPostalCode(postalCode);
        contactAddress.setGeomarket(geomarket);
        contactAddress.setAddressType(addressType);
        contactAddress.setEducationNeighborhood(educationNeighborhood);
        contactAddress.setAddressComments(addressComments);
        contactAddress.setActive(active);
        contactAddress.setPrimary(primary);
        PersonContactAddressPage.verifyAddress(contactAddress,group);
    }

    @Then("I create address on contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, group {string}")
    public void createAddress(String address1,String address2,String address3,String address4,String city,String state,String region,String country,String postalCode,String addressType,String educationNeighborhood,String addressComments,String active,String primary,String group){
        ContactAddressBean contactAddress = new ContactAddressBean();
        contactAddress.setAddress1(address1);
        contactAddress.setAddress2(address2);
        contactAddress.setAddress3(address3);
        contactAddress.setAddress4(address4);
        contactAddress.setCity(city);
        contactAddress.setState(state);
        contactAddress.setRegion(region);
        contactAddress.setCountry(country);
        contactAddress.setPostalCode(postalCode);
        contactAddress.setAddressType(addressType);
        contactAddress.setEducationNeighborhood(educationNeighborhood);
        contactAddress.setAddressComments(addressComments);
        contactAddress.setActive(active);
        contactAddress.setPrimary(primary);
        PersonContactAddressPage.createAddress(contactAddress,group);
    }
    @And("I add address {string}")
    public static void addAddress(String group) {
        PersonContactAddressPage.addAddress(group);
    }
}
