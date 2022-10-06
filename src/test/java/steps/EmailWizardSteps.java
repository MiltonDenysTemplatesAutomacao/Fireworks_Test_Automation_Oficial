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
    @When("I update Email Content Tab {string}, {string}")
    public static void updateEmailContentTab(String bodyHTML, String bodyText) {
        EmailWizardPage.updateEmailContentTab(bodyHTML,bodyText);
    }
    @When("I click on finish tab")
    public static void updateEmailContentTab() {
        EmailWizardPage.clickFinishTab();
    }
    @When("I update Email Finish Tab {string}, {string}, {string}, {string}, {string}")
    public static void updateEmailFinishTab(String category, String action, String staff, String actionDateTime, String comments) {
        EmailWizardPage.updateEmailFinishTab(category,action,staff,actionDateTime,comments);
    }
    @When("I verify RecipientsPreview {string}, {string}, {string}, {string}, {string}")
    public static void verifyRecipientsPreview(String firstName, String lastName, String emailAddress, String reason, String validRecipients) {
        EmailWizardPage.verifyRecipientsPreview(firstName,lastName,emailAddress,reason,validRecipients);
    }
}