package steps;


import io.cucumber.java.en.When;
import pages.StaffPage;

public class StaffSteps {

    @When("I update {string}, {string} and {string} to update phone number")
    public static void updatePhoneNumber(String phone,String phoneType,String comment) {
        StaffPage.updatePhoneNumber(phone,phoneType,comment);
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

}
