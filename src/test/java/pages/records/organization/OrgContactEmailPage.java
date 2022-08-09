package pages.records.organization;

import bean.ContactEmailBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class OrgContactEmailPage extends BasePage {

    private static String emailAddressField(String index){
        return String.format("#entity_email_%s_org_email_address",index);
    }
    private static String emailTypeElement(String index){
        return String.format("#entity_email_%s_org_email_type_toggle",index);
    }
    private static String emailOptInMethodElement(String index){
        return String.format("#entity_email_%s_org_opt_in_method_id_toggle",index);
    }
    private static String emailOptInStatusElement(String index){
        return String.format("#entity_email_%s_org_opt_in_status_toggle",index);
    }
    private static String emailOptInDateField(String index){
        return String.format("#entity_email_%s_org_opt_in_date",index);
    }

    private static String emailStatusElement(String index){
        return String.format("#entity_email_%s_org_email_status_toggle",index);
    }
    private static String emailCommentsField(String index){
        return String.format("#entity_email_%s_org_email_comments",index);
    }
    private static String emailPlusSignElement(String index){
        return String.format("#entity_email_%s_add",index);
    }
    private static String emailActiveCheckbox(String index){
        return String.format("#entity_email_%s_active",index);
    }
    private static String emailPrimaryCheckbox(String index){
        return String.format("#entity_email_%s_primary",index);
    }
    private static String emailTypeElementList(String index){
        return String.format("#entity_email_%s_org_email_type_dropdown_menu",index);
    }
    private static String emailStatusElementList(String index){
        return String.format("#entity_email_%s_org_email_status_dropdown_menu",index);
    }
    private static String selectEmailOptInMethodList(String index){
        return String.format("#entity_email_%s_org_opt_in_method_id_dropdown_menu",index);
    }
    private static String emailOptInStatusElementList(String index){
        return String.format("#entity_email_%s_org_opt_in_status_dropdown_menu",index);
    }

    public static void verifyEmail(ContactEmailBean email,String group){
        boolean emailAddressValidation = false;
        boolean emailTypeValidation = false;
        boolean emailOptInMethodValidation = false;
        boolean emailOptInStatusValidation = false;
        boolean emailOptInDateValidation = false;
        boolean emailStatusValidation = false;
        boolean emailCommentsValidation = false;
        boolean emailActiveCheckboxLocator = false;
        boolean emailPrymaryCheckboxLocator = false;

        String passMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_FAIL,group);

        try {
            scrollToElement(By.cssSelector(emailPlusSignElement(group)));
            if (email.getEmailAddress() != "") {
                String emailAddressText = getAtribute(By.cssSelector(emailAddressField(group)),"value");
                emailAddressValidation = email.getEmailAddress().equals(emailAddressText);
            }else{
                emailAddressValidation = true;
            }
            if (email.getEmailType() != "") {
                String emailTypeText = getText(By.cssSelector(emailTypeElement(group)));
                emailTypeValidation = email.getEmailType().equals(emailTypeText);
            }else{
                emailTypeValidation = true;
            }
            if (email.getEmailOptInMethod()!= "") {
                String emailOptInMethodText = getText(By.cssSelector(emailOptInMethodElement(group)));
                emailOptInMethodValidation = email.getEmailOptInMethod().equals(emailOptInMethodText);
            }else{
                emailOptInMethodValidation = true;
            }
            if (email.getEmailOptInStatus()!= "") {
                String emailOptInStatusText = getText(By.cssSelector(emailOptInStatusElement(group)));
                emailOptInStatusValidation = email.getEmailOptInStatus().equals(emailOptInStatusText);
            }else{
                emailOptInStatusValidation=true;
            }
            if (email.getEmailOptInDate() != "") {
                String emailOptInDateText = getAtribute(By.cssSelector(emailOptInDateField(group)),"value");
                emailOptInDateValidation = email.getEmailOptInDate().equals(emailOptInDateText);
            }else{
                emailOptInDateValidation = true;
            }
            if (email.getEmailStatus()!= "") {
                String emailStatusText = getText(By.cssSelector(emailStatusElement(group)));
                emailStatusValidation = email.getEmailStatus().equals(emailStatusText);
            }else{
                emailStatusValidation = true;
            }
            if (email.getEmailComments()!= "") {
                String emailCommentsText = getAtribute(By.cssSelector(emailCommentsField(group)),"value");
                emailCommentsValidation = email.getEmailComments().equals(emailCommentsText);
            }else{
                emailCommentsValidation = true;
            }

            if(email.getActive() != ""){
                switch (email.getActive()){
                    case "1":
                        emailActiveCheckboxLocator = checkBoxIsActive(By.cssSelector(emailActiveCheckbox(group)));
                        break;
                    case "0":
                        emailActiveCheckboxLocator = !checkBoxIsActive(By.cssSelector(emailActiveCheckbox(group)));
                        break;
                    default: throw new IllegalArgumentException("Unhandled index. Update business logic");
                }
            }else{
                emailActiveCheckboxLocator=true;
            }

            if(email.getPrimary() != ""){
                switch (email.getPrimary()){
                    case "1":
                        emailPrymaryCheckboxLocator = checkBoxIsActive(By.cssSelector(emailPrimaryCheckbox(group)));
                        break;
                    case "0":
                        emailPrymaryCheckboxLocator = !checkBoxIsActive(By.cssSelector(emailPrimaryCheckbox(group)));
                        break;
                    default: throw new IllegalArgumentException("Unhandled index. Update business logic");
                }
            }else{
                emailPrymaryCheckboxLocator=true;
            }

            if(emailAddressValidation
                    && emailTypeValidation
                    && emailOptInMethodValidation
                    && emailOptInStatusValidation
                    && emailOptInDateValidation
                    && emailStatusValidation
                    && emailCommentsValidation
                    && emailActiveCheckboxLocator
                    && emailPrymaryCheckboxLocator){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void addEmail(String group){
        try {
            scrollToElement(By.cssSelector(emailPlusSignElement(group)));
            scrollTo("-100");
            waitUntilElementToBeSelected(By.cssSelector(emailPlusSignElement(group)),20);
            click(By.cssSelector(emailPlusSignElement(group)));
            ExtentReportsSetUp.testingPass(LogPage.ADD_EMAIL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ADD_EMAIL_FAIL);
        }
    }
    public static void createEmail(ContactEmailBean email, String group){
        String passMessage = String.format(LogPage.CREATE_EMAIL_ORG_PASS,group);
        String failMessage = String.format(LogPage.CREATE_EMAIL_ORG_FAIL,group);
        int createEmailDelay=20;

        try {
            if(email.getEmailAddress()!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                waitElementBy(By.cssSelector(emailAddressField(group)),createEmailDelay);
                write(By.cssSelector(emailAddressField(group)), email.getEmailAddress());
            }
            if(email.getEmailType()!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                waitElementBy(By.cssSelector(emailTypeElement(group)),createEmailDelay);
                BasePage.click(By.cssSelector(emailTypeElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(emailTypeElementList(group)), "a");
                wait(1000);
                clickOnListOfElements(email.getEmailType());
            }
            if(email.getEmailStatus()!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                waitElementBy(By.cssSelector(emailStatusElement(group)),createEmailDelay);
                BasePage.click(By.cssSelector(emailStatusElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(emailStatusElementList(group)), "a");
                wait(500);
                clickOnListOfElements(email.getEmailStatus());
            }
            if(email.getEmailOptInMethod()!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                waitElementBy(By.cssSelector(emailOptInMethodElement(group)),createEmailDelay);
                BasePage.click(By.cssSelector(emailOptInMethodElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(selectEmailOptInMethodList(group)), "a");
                wait(1000);
                clickOnListOfElements(email.getEmailOptInMethod());
            }
            if(email.getEmailOptInStatus()!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                waitElementBy(By.cssSelector(emailOptInStatusElement(group)),createEmailDelay);
                BasePage.click(By.cssSelector(emailOptInStatusElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(emailOptInStatusElementList(group)), "a");
                wait(1000);
                clickOnListOfElements(email.getEmailOptInStatus());
            }
            if(email.getEmailComments()!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                waitElementBy(By.cssSelector(emailCommentsField(group)),createEmailDelay);
                write(By.cssSelector(emailCommentsField(group)), email.getEmailComments());
            }
            if(email.getActive()!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                click(By.cssSelector(emailActiveCheckbox(group)));
            }
            if(email.getPrimary()!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                click(By.cssSelector(emailPrimaryCheckbox(group)));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

}
