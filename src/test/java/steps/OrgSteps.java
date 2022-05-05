package steps;

import io.cucumber.java.en.When;
import pages.OrgPage;
import pages.PersonPage;

public class OrgSteps {

    @When("I update {string}, {string}, {string}, {string}, {string}, {string} and {string} to update email address")
    public static void updateEmailAddress(String emailAddress,String emailType,String emailOpt, String optStatus, String optDate, String emailStatus, String emailContent) {
        OrgPage.updateEmailAddress(emailAddress,emailType,emailOpt,optStatus,optDate,emailStatus,emailContent);
    }
    @When("I update {string}, {string}, {string}, {string}, and {string} to update external ID Types for organization")
    public static void updateExternalIdTypes(String type,String idNumber,String idRecordedDate,String whoAddedId, String comments) {
        OrgPage.updateExternalIdTypes(type,idNumber,idRecordedDate,whoAddedId,comments);
    }
    @When("I update organization status group {string} person {int}")
    public static void updateStatusOrg(String index, int person) {
        OrgPage.updateStatusOrg(index,person);
    }
    @When("I click on Save Changes button in organization status")
    public static void organizationStatusSaveChanges() {
        OrgPage.organizationStatusSaveChanges();
    }
    @When("I click on add organization status {string}")
    public static void clickOnAddOrgStatus(String index) {
        OrgPage.clickOnAddOrgStatus(index);
    }
    @When("I delete an organization")
    public static void deleteOrganization() {
        OrgPage.deleteOrganization();
    }
    @When("I search {string} an organization page manager")
    public static void searchOrganizationManager(String search) {
        OrgPage.searchOrganizationManager(search);
    }
    @When("I validate if {string} message on organization datatable is displayed")
    public static void validateOrganizationDatatableMessage(String search) {
        OrgPage.validateOrganizationDatatableMessage(search);
    }
    @When("I verify the record header for organization {string}, {string}, {string} and {string}")
    public static void verifyRecordHeader(String name, String oktoContact, String recordStatus, String orgCategory) {
        OrgPage.verifyRecordHeader(name,oktoContact,recordStatus,orgCategory );
    }
    @When("I validate Org Id label {string}")
    public static void verifyOrgId(String orgId) {
        OrgPage.verifyOrgId(orgId);
    }
}
