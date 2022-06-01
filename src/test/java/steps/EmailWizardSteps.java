package steps;

import io.cucumber.java.en.When;
import pages.EmailWizardPage;

public class EmailWizardSteps {
    @When("I update Email Start Tab {string}, {string}, {string}, {string}, {string}")
    public static void createNewEmail(String template, String emailName, String emailDescription, String smartSearch, String singleEmail) {
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
    public static void updateEmailContentTab() {
        EmailWizardPage.updateEmailContentTab();
    }
}