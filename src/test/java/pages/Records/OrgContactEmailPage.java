package pages.Records;

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
    private static String emailStatusElement(String index){
        return String.format("#entity_email_%s_org_email_status",index);
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


    public static void createEmail(String emailAddress,String emailType,String emailStatus,String emailOptInMethod,String emailOptInStatus,String emailComments,String active,String primary,String group){
        String passMessage = String.format(LogPage.CREATE_EMAIL_ORG_PASS,group);
        String failMessage = String.format(LogPage.CREATE_EMAIL_ORG_FAIL,group);
        int createEmailDelay=20;

        try {
            if(emailAddress!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                waitElementBy(By.cssSelector(emailAddressField(group)),createEmailDelay);
                write(By.cssSelector(emailAddressField(group)), emailAddress);
            }
            if(emailType!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                waitElementBy(By.cssSelector(emailTypeElement(group)),createEmailDelay);
                BasePage.click(By.cssSelector(emailTypeElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(emailTypeElementList(group)), "a");
                wait(500);
                clickOnListOfElements(emailType);
            }
            if(emailStatus!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                waitElementBy(By.cssSelector(emailStatusElement(group)),createEmailDelay);
                BasePage.click(By.cssSelector(emailStatusElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(emailStatusElementList(group)), "a");
                wait(500);
                clickOnListOfElements(emailStatus);
            }
            if(emailOptInMethod!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                waitElementBy(By.cssSelector(emailOptInMethodElement(group)),createEmailDelay);
                BasePage.click(By.cssSelector(emailOptInMethodElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(selectEmailOptInMethodList(group)), "a");
                wait(500);
                clickOnListOfElements(emailOptInMethod);
            }
            if(emailOptInStatus!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                waitElementBy(By.cssSelector(emailOptInStatusElement(group)),createEmailDelay);
                BasePage.click(By.cssSelector(emailOptInStatusElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(emailOptInStatusElementList(group)), "a");
                wait(500);
                clickOnListOfElements(emailOptInStatus);
            }
            if(emailComments!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                waitElementBy(By.cssSelector(emailCommentsField(group)),createEmailDelay);
                write(By.cssSelector(emailCommentsField(group)), emailComments);
            }
            if(active!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                click(By.cssSelector(emailActiveCheckbox(group)));
            }
            if(primary!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                click(By.cssSelector(emailPrimaryCheckbox(group)));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

}
