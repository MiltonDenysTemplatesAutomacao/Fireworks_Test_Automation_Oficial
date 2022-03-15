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
}
