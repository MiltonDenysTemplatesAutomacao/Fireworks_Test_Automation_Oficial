package steps;


import bean.ContactAddressBean;
import bean.ContactPhoneBean;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Records.PersonContactAddressPage;
import pages.StaffPage;

public class StaffSteps {

    @When("I update phone number in contact for staff {string}, {string}, {string}")
    public static void updatePhoneNumber(String phoneNumber, String phoneType, String comment) {
        ContactPhoneBean contactPhoneBean = new ContactPhoneBean();
        contactPhoneBean.phoneNumber = phoneNumber;
        contactPhoneBean.phoneType = phoneType;
        contactPhoneBean.phoneComments = comment;
        StaffPage.updatePhoneNumber(contactPhoneBean);
    }
    @When("I verify phone number on contact for staff {string}, {string}, {string}")
    public static void verifyPhoneNumber(String phoneNumber, String phoneType, String comment) {
        ContactPhoneBean contactPhoneBean = new ContactPhoneBean();
        contactPhoneBean.phoneNumber = phoneNumber;
        contactPhoneBean.phoneType = phoneType;
        contactPhoneBean.phoneComments = comment;
        StaffPage.verifyStaffPhoneNumber(contactPhoneBean);
    }

    @When("I verify Header Record Status {string}")
    public static void verifyHeaderRecordStatus(String status) {
        StaffPage.verifyHeaderRecordStatus(status);
    }
    @When("I verify Header Permission {string}")
    public static void verifyHeaderPermissions(String permission) {
        StaffPage.verifyHeaderPermissions(permission);
    }
    @When("I validate if basic panel element is visible")
    public static void validateBasicElementIsVisible() {
        StaffPage.validateBasicElementIsVisible();
    }
    @When("I delete a staff member")
    public static void deleteStaff() {
        StaffPage.deleteStaff();
    }
    @When("I search {string} on staff page manager")
    public static void searchStaffManager(String search) {
        StaffPage.searchStaffManager(search);
    }
    @Then("I navigate to ID Types on staff manager page")
    public static void navigateToIdTypesStaffManager() {
        StaffPage.navigateToIdTypesStaffManager();
    }
    @When("I validate if {string} message on staff datatable is displayed")
    public static void validateStaffMangerDatatableMessage(String message) {
        StaffPage.validateStaffMangerDatatableMessage(message);
    }
    @When("I click on ID Types SaveChanges button")
    public static void saveChangesBtnStaffIdTypes() {
        StaffPage.saveChangesBtnStaffIdTypes();
    }
    @When("I update Id Types group {string} person {int}")
    public static void updateIdTypes(String index, int person) {
        StaffPage.updateIdTypes(index,person);
    }
    @When("I validate Id Types group {string} person {int}")
    public static void validateIdTypes(String index, int person) {
        StaffPage.validateIdTypes(index,person);
    }
    @When("I click on save changes in contact for staff")
        public static void saveChangesBtnStaffContact() {
            StaffPage.saveChangesBtnStaffContact();
        }



    @Then("I create address on contact for staff {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, group {string}")
    public void createAddress(String address1,String address2,String address3,String address4,String city,String state,String region,String country,String postalCode,String addressType, String addressComments,String active,String primary,String group){
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
        contactAddress.addressComments = addressComments;
        contactAddress.active = active;
        contactAddress.primary = primary;
        StaffPage.createContactStaffAddress(contactAddress,group);
    }
}
