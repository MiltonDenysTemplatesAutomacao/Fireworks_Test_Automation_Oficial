package steps.records.organization;

import bean.ContactAddressBean;
import io.cucumber.java.en.Then;
import pages.records.organization.OrgContactAddressPage;

public class OrgContactAddressSteps {


    @Then("I verify address on contact for organization {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public void verifyOrgAddress(String address1,String address2,String address3,String address4,String city,String state,String region,String country,String postalCode, String geomarket,String addressType,String addressComments,String active,String primary,String group){
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
        contactAddress.setGeomarket(geomarket);
        contactAddress.setAddressType(addressType);
        contactAddress.setAddressComments(addressComments);
        contactAddress.setActive(active);
        contactAddress.setPrimary(primary);
        OrgContactAddressPage.verifyOrgAddress(contactAddress,group);
    }

}
