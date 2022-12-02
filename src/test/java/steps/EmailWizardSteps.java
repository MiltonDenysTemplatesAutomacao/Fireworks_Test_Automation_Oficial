package steps;

import io.cucumber.java.en.When;
import pages.EmailWizardPage;

public class EmailWizardSteps {
    @When("I update Email Start Tab {string}, {string}, {string}, {string}, {string}")
    public static void updateEmailStartTab(String template, String emailName, String emailDescription, String smartSearch, String singleEmail) {
        EmailWizardPage.updateEmailStartTab(template,emailName,emailDescription,smartSearch,singleEmail);
    }
    @When("I click on save and continue on Marketing Email Composer")
    public static void clickSaveAndContinue() {
        EmailWizardPage.clickSaveAndContinue();
    }
    @When("I update Email Headers Tab {string}, {string}, {string}, {string}, {string}, {string}")
    public static void updateEmailHeadersTab(String senderName,String senderEmail,String replyToEmail,String subject,String preheaders,String attachment) {
        EmailWizardPage.updateEmailHeadersTab(senderName,senderEmail,replyToEmail,subject,preheaders,attachment);
    }
    @When("I click checkbox Use assigned counselor when available")
    public static void clickUseAssignedCounselorCheckbox() {
        EmailWizardPage.clickUseAssignedCounselorCheckbox();
    }
    @When("I click on disable message footer checkbox")
    public static void disableFooterCheckbox() {
        EmailWizardPage.disableFooterCheckbox();
    }

    @When("I send a test email {string}, {string}, {string}")
    public static void sendTestEmail(String testList,String email, String testNote) {
        EmailWizardPage.sendTestEmail(testList,email,testNote);
    }
    @When("I open preview recipients button")
    public static void openPreviewRecipientsModal() {
        EmailWizardPage.openPreviewRecipientsModal();
    }
    @When("I close preview recipients button")
    public static void closePreviewRecipientsModal() {
        EmailWizardPage.closePreviewRecipientsModal();
    }
    @When("I update Email Content Tab {string}, {string}")
    public static void updateEmailContentTab(String bodyHTML, String bodyText) {
        EmailWizardPage.updateEmailContentTab(bodyHTML,bodyText);
    }
    @When("I click on finish tab")
    public static void clickFinishTab() {
        EmailWizardPage.clickFinishTab();
    }
    @When("I click on content tab")
    public static void clickContentTab() {
        EmailWizardPage.clickContentTab();
    }
    @When("I click on Save Changes on content tab")
    public static void clickOnSaveChangesOnContentTab() {
        EmailWizardPage.clickOnSaveChangesOnContentTab();
    }
    @When("I update Email Finish Tab {string}, {string}, {string}, {string}, {string}")
    public static void updateEmailFinishTab(String category, String action, String staff, String actionDateTime, String comments) {
        EmailWizardPage.updateEmailFinishTab(category,action,staff,actionDateTime,comments);
    }
    @When("I verify action values for organization on finish tab index {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public static void verifyOrganizationActionFinishTab(String category, String action, String actionType, String actionVisibility,String staff, String actionDateTime, String comments) {
        EmailWizardPage.verifyOrganizationActionFinishTab(category,action,actionType,actionVisibility,staff,actionDateTime,comments);
    }
    @When("I update Email Finish Tab for organization {string}, {string}, {string}, {string}, {string}")
    public static void updateOrgEmailFinishTab(String category, String action, String staff, String actionDateTime, String comments) {
        EmailWizardPage.updateOrgEmailFinishTab(category,action,staff,actionDateTime,comments);
    }
    @When("I verify RecipientsPreview {string}, {string}, {string}, {string}, {string}")
    public static void verifyRecipientsPreview(String firstName, String lastName, String emailAddress, String reason, String validRecipients) {
        EmailWizardPage.verifyRecipientsPreview(firstName,lastName,emailAddress,reason,validRecipients);
    }
    @When("I validate message header {string}, {string}, {string}, {string}, {string}, {string}, {string} status {string}")
    public static void verifyMessageHeader(String senderName,String senderEmail,String replyToEmail,String subject,String preheaders,String html,String text,String status) {
        EmailWizardPage.verifyMessageHeader(senderName,senderEmail,replyToEmail,subject,preheaders,html,text,status);
    }
}