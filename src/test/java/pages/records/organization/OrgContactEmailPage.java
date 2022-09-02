package pages.records.organization;

import bean.ContactEmailBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;

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
        String passMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_FAIL,group);

        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(emailAddressField(group)),email.getEmailAddress())
                    && MainPage.verifyGetText(By.cssSelector(emailTypeElement(group)),email.getEmailType())
                    && MainPage.verifyGetText(By.cssSelector(emailOptInMethodElement(group)),email.getEmailOptInMethod())
                    && MainPage.verifyGetText(By.cssSelector(emailOptInStatusElement(group)),email.getEmailOptInStatus())
                    && MainPage.verifyGetAttribute(By.cssSelector(emailOptInDateField(group)),email.getEmailOptInDate())
                    && MainPage.verifyGetText(By.cssSelector(emailStatusElement(group)),email.getEmailStatus())
                    && MainPage.verifyGetAttribute(By.cssSelector(emailCommentsField(group)),email.getEmailComments())
                    && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(emailActiveCheckbox(group)),email.getActive())
                    && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(emailPrimaryCheckbox(group)),email.getPrimary())
            ){
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
            MainPage.addDeleteWithPlusButton(By.cssSelector(emailPlusSignElement(group)));
            ExtentReportsSetUp.testingPass(LogPage.ADD_EMAIL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ADD_EMAIL_FAIL);
        }
    }
    public static void createEmail(ContactEmailBean email, String group){
        String passMessage = String.format(LogPage.CREATE_EMAIL_ORG_PASS,group);
        String failMessage = String.format(LogPage.CREATE_EMAIL_ORG_FAIL,group);

        try {
            if(email.getEmailAddress()!=""){
                MainPage.fillField(By.cssSelector(emailAddressField(group)), email.getEmailAddress());
            }
            if(email.getEmailType()!=""){
                MainPage.clickOptionList(By.cssSelector(emailTypeElement(group)),
                        email.getEmailType(),
                        By.cssSelector(emailTypeElementList(group)));
            }
            if(email.getEmailStatus()!=""){
                MainPage.clickOptionList(By.cssSelector(emailStatusElement(group)),
                        email.getEmailStatus(),
                        By.cssSelector(emailStatusElementList(group)));
            }
            if(email.getEmailOptInMethod()!=""){
                MainPage.clickOptionList(By.cssSelector(emailOptInMethodElement(group)),
                        email.getEmailOptInMethod(),
                        By.cssSelector(selectEmailOptInMethodList(group)));
            }
            if(email.getEmailOptInStatus()!=""){
                MainPage.clickOptionList(By.cssSelector(emailOptInStatusElement(group)),
                        email.getEmailOptInStatus(),
                        By.cssSelector(emailOptInStatusElementList(group)));
            }
            if(email.getEmailComments()!=""){
                MainPage.fillField(By.cssSelector(emailCommentsField(group)), email.getEmailComments());
            }
            if(email.getActive()!=""){
                scrollToElement(By.cssSelector(emailActiveCheckbox(group)));
                scrollTo("-150");
                click(By.cssSelector(emailActiveCheckbox(group)));
            }
            if(email.getPrimary()!=""){
                scrollToElement(By.cssSelector(emailPrimaryCheckbox(group)));
                scrollTo("-150");
                click(By.cssSelector(emailPrimaryCheckbox(group)));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
