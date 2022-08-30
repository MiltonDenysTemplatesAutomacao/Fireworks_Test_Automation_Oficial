package pages.records.organization;

import bean.ContactPhoneBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;

public class OrgContactPhone extends BasePage {


    private static String phoneNumberField(String index){
        return String.format("#entity_phone_%s_org_phone_number",index);
    }
    private static String phoneTypeElement(String index){
        return String.format("#entity_phone_%s_org_phone_type_toggle",index);
    }
    private static String phoneStatusElement(String index){
        return String.format("#entity_phone_%s_org_phone_status_toggle",index);
    }
    private static String phoneTimeZoneElement(String index){
        return String.format("#entity_phone_%s_org_phone_time_zone_toggle",index);
    }
    private static String phoneCommentsField(String index){
        return String.format("#entity_phone_%s_org_phone_comments",index);
    }
    private static String phoneActiveCheckbox(String index){
        return String.format("#entity_phone_%s_active",index);
    }
    private static String phonePrimaryCheckbox(String index){
        return String.format("#entity_phone_%s_primary",index);
    }

    public static void verifyPhoneContactOrg(ContactPhoneBean phone,String group){

        String passMessage = String.format(LogPage.VERIFY_PHONE_CONTACT_ORG_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_PHONE_CONTACT_ORG_FAIL,group);
        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(phoneNumberField(group)),phone.getPhoneNumber())
                && MainPage.verifyGetText(By.cssSelector(phoneTypeElement(group)),phone.getPhoneType())
                && MainPage.verifyGetText(By.cssSelector(phoneStatusElement(group)),phone.getPhoneStatus())
                && MainPage.verifyGetText(By.cssSelector(phoneTimeZoneElement(group)),phone.getPhoneTimeZone())
                && MainPage.verifyGetAttribute(By.cssSelector(phoneCommentsField(group)),phone.getPhoneComments())
                && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(phoneActiveCheckbox(group)),phone.getActive())
                && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(phonePrimaryCheckbox(group)),phone.getPrimary())){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    }

