package steps;

import bean.ActionBean;
import bean.ContactAddressBean;
import io.cucumber.java.en.And;
import pages.LettersPage;
import pages.records.organization.OrgContactAddressPage;

public class LettersSteps {
    @And("I navigate to template tab")
    public static void navigateToTemplatesTab() {
        LettersPage.navigateToTemplatesTab();
    }
    @And("I update letter person action index {int}")
    public static void updateLetterPersonAction(int index) {
        LettersPage.updateLetterPersonAction(index);
    }
    @And("I update letter content person {int}")
    public static void updateLetterContent(int index) {
        LettersPage.updateLetterContent(index);
    }
    @And("I update labels {string}, {string}")
    public static void updateLabels(String labelFormat,String labelContent) {
        LettersPage.updateLabels(labelFormat,labelContent);
    }
    @And("I verify labels {string}, {string}")
    public static void verifyLabels(String labelFormat,String labelContent) {
        LettersPage.verifyLabels(labelFormat,labelContent);
    }
    @And("I click on schedule letter button")
    public static void scheduleLetter() {
        LettersPage.scheduleLetterButton();
    }
    @And("I click on create letter button")
    public static void createLetter() {
        LettersPage.createLetter();
    }
    @And("I include label")
    public static void includeLabels() {
        LettersPage.includeLabels();
    }
    @And("I load Template {string}")
    public static void loadTemplate(String templateName) {
        LettersPage.loadTemplate(templateName);
    }
    @And("I verify draft letter {string}, {string}, {string} and {string}")
    public static void verifyDraftLetter(String letterName,String search,String letterFormat,String letterContent) {
        LettersPage.verifyDraftLetter(letterName,search,letterFormat,letterContent);
    }
    @And("I verify letter person action {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public static void verifyLetterPersonAction(String category,String action,String actionType,String actionVisibility, String staff, String date,String comments) {
        LettersPage.verifyLetterPersonAction(category,action,actionType,actionVisibility,staff,date,comments);
    }
    @And("I update letter details person {int}")
    public static void updateLetterDetails(int index) {
        LettersPage.updateLetterDetails(index);
    }
    @And("I update letter recipients person {int}")
    public static void updateLetterRecipients(int index) {
        LettersPage.updateLetterRecipients(index);
    }
    @And("I verify Letter System Action {string} and {string}")
    public static void verifyLetterSystemAction(String systemActionsCategory, String systemActionsAction) {
        LettersPage.verifyLetterSystemAction(systemActionsCategory,systemActionsAction);
    }
    @And("I click on create PDF")
    public static void createPDF() {
        LettersPage.createPDF();
    }
    @And("I verify recipients modal")
    public static void verifyRecipientsModal() {
        LettersPage.verifyRecipientsModal();
    }
    @And("I update Letter Org Action {string}, {string}, {string}, {string}, {string}")
    public static void updateLetterOrgAction(String category, String action,String staff,String actionDateTime,String comments) {
        ActionBean actionBean = new ActionBean();
        actionBean.setCategory(category);
        actionBean.setAction(action);
        actionBean.setStaff(staff);
        actionBean.setActionDate(actionDateTime);
        actionBean.setComments(comments);
        LettersPage.updateLetterOrgAction(actionBean);
    }
    @And("I verify Letter Org Action {string}, {string}, {string}, {string}, {string}")
    public static void verifyLetterOrgAction(String category, String action,String staff,String actionDateTime,String comments) {
        ActionBean actionBean = new ActionBean();
        actionBean.setCategory(category);
        actionBean.setAction(action);
        actionBean.setStaff(staff);
        actionBean.setActionDate(actionDateTime);
        actionBean.setComments(comments);
        LettersPage.verifyLetterOrgAction(actionBean);
    }
    @And("I confirm recipients modal")
    public static void confirmRecipientsModal() {
        LettersPage.confirmRecipientsModal();
    }
}
