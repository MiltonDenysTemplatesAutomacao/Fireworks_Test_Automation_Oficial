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
    @When("I click on url validation button")
    public static void clickUrlValidationButton() {
        EmailWizardPage.clickUrlValidationButton();
    }
    @When("I click TinyMCESourceCode")
    public static void clickTinyMCESourceCode() {
        EmailWizardPage.clickTinyMCESourceCode();
    }
    @When("I click on Submit for Html Validation button")
    public static void clickSubmitForHtmlValidationButton() {
        EmailWizardPage.clickSubmitForHtmlValidationButton();
    }
    @When("I click ok button on TinyMCESourceCode")
    public static void clickOkButtonOnTinyMCESourceCode() {
        EmailWizardPage.clickOkButtonOnTinyMCESourceCode();
    }
    @When("I update TinyMCESourceCode {string}")
    public static void updateTinyMCESourceCode(String html) {
        EmailWizardPage.updateTinyMCESourceCode(html);
    }
    @When("I update Email Headers Tab {string}, {string}, {string}, {string}, {string}, {string}")
    public static void updateEmailHeadersTab(String senderName,String senderEmail,String replyToEmail,String subject,String preheaders,String attachment) {
        EmailWizardPage.updateEmailHeadersTab(senderName,senderEmail,replyToEmail,subject,preheaders,attachment);
    }
    @When("I validate email attachment file message {string}")
    public static void emailAttachmentMessage(String message) {
        EmailWizardPage.emailAttachmentMessage(message);
    }
    @When("I validate if I do not see disable footer checkbox")
    public static void dontSeeDisableFooterCheckbox() {
        EmailWizardPage.dontSeeDisableFooterCheckbox();
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
    @When("I verify spam score {string}")
    public static void verifySpamScore(String spamScore) {
        EmailWizardPage.verifySpamScore(spamScore);
    }
    @When("I verify spam score sent {string}")
    public static void verifySpamScoreSent(String spamScore) {
        EmailWizardPage.verifySpamScoreSent(spamScore);
    }
    @When("I click on email client preview button")
    public static void clickEmailClientPreviewButton() {
        EmailWizardPage.clickEmailClientPreviewButton();
    }
    @When("I wait until spam score update {string}")
    public static void waitUntilSpamScoreUpdates(String spamScore) {
        EmailWizardPage.waitUntilSpamScoreUpdates(spamScore);
    }
    @When("I click on spam Assassin Score")
    public static void clickOnSpamAssassinScore() {
        EmailWizardPage.clickOnSpamAssassinScore();
    }
    @When("I click on spam Assassin modal ok button")
    public static void clickOnSpamModalOkButton() {
        EmailWizardPage.clickOnSpamModalOkButton();
    }
    @When("I validate HTML Message SpamAssassin Details {string}, {string}")
    public static void validateHtmlMessageSpamAssassinDetails(String errorsFound,String lastRun) {
        EmailWizardPage.validateHtmlMessageSpamAssassinDetails(errorsFound,lastRun);
    }
    @When("I verify body text Email Content Tab {string}")
    public static void verifyBodyTextEmailContentTab(String bodyText) {
        EmailWizardPage.verifyBodyTextEmailContentTab(bodyText);
    }
    @When("I verify body html Email Content Tab {string}")
    public static void verifyBodyHtmlEmailContentTab(String bodyHTML) {
        EmailWizardPage.verifyBodyHtmlEmailContentTab(bodyHTML);
    }
    @When("I click on generate Plain Text Button")
    public static void clickOnGeneratePlainTextButton() {
        EmailWizardPage.clickOnGeneratePlainTextButton();
    }
    @When("I click on generate Plain Text overwrite Button")
    public static void clickOnGeneratePlainTextOverwriteButton() {
        EmailWizardPage.clickOnGeneratePlainTextOverwriteButton();
    }
    @When("I click on headers Tab")
    public static void clickHeadersTab() {
        EmailWizardPage.clickHeadersTab();
    }
    @When("I click on finish tab")
    public static void clickFinishTab() {
        EmailWizardPage.clickFinishTab();
    }
    @When("I send to relationship {string}")
    public static void sendToRelationship(String relationship) {
        EmailWizardPage.sendToRelationship(relationship);
    }
    @When("I click on content tab")
    public static void clickContentTab() {
        EmailWizardPage.clickContentTab();
    }
    @When("I open content preview modal")
    public static void openContentPreviewModal() {
        EmailWizardPage.openContentPreviewModal();
    }
    @When("I click on Save Changes on content tab")
    public static void clickOnSaveChangesOnContentTab() {
        EmailWizardPage.clickOnSaveChangesOnContentTab();
    }
    @When("I update Email Finish Tab {string}, {string}, {string}, {string}, {string}")
    public static void updateEmailFinishTab(String category, String action, String staff, String actionDateTime, String comments) {
        EmailWizardPage.updateEmailFinishTab(category,action,staff,actionDateTime,comments);
    }
    @When("I set current action date on Email Finish tab")
    public static void setCurrentActionDateOnEmailFinishTab() {
        EmailWizardPage.setCurrentActionDateOnEmailFinishTab();
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