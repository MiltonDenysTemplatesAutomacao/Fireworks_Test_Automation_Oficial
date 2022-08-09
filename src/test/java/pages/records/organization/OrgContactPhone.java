package pages.records.organization;

import bean.ContactPhoneBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.records.person.PersonContactPhonePage;

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
        boolean phoneNumberValidation = false;
        boolean phoneTypeValidation = false;
        boolean timeZoneValidation = false;
        boolean phoneStatusValidation = false;
        boolean phoneCommentsValidation = false;
        boolean activeCheckboxValidation = false;
        boolean primaryCheckboxValidation = false;

        String passMessage = String.format(LogPage.VERIFY_PHONE_CONTACT_ORG_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_PHONE_CONTACT_ORG_FAIL,group);
        try {
            scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));

            if(phone.getPhoneNumber()!=""){
                String phoneNumberText = getAtribute(By.cssSelector(phoneNumberField(group)),"value");
                phoneNumberValidation = phone.getPhoneNumber().equals(phoneNumberText);
            }else{
                phoneNumberValidation=true;
            }
            if(phone.getPhoneType()!=""){
                String phoneTypeText = getText(By.cssSelector(phoneTypeElement(group)));
                phoneTypeValidation = phone.getPhoneType().equals(phoneTypeText);
            }else{
                phoneTypeValidation=true;
            }
            if(phone.getPhoneStatus()!=""){
                String phoneStatusText = getText(By.cssSelector(phoneStatusElement(group)));
                phoneStatusValidation = phone.getPhoneStatus().equals(phoneStatusText);
            }else{
                phoneStatusValidation=true;
            }
            if(phone.getPhoneTimeZone()!=""){
                String timeZoneText = getText(By.cssSelector(phoneTimeZoneElement(group)));
                timeZoneValidation = phone.getPhoneTimeZone().equals(timeZoneText);
            }else{
                timeZoneValidation=true;
            }
            if(phone.getPhoneComments()!=""){
                String phoneCommentsText = getAtribute(By.cssSelector(phoneCommentsField(group)),"value");
                phoneCommentsValidation = phone.getPhoneComments().equals(phoneCommentsText);
            }else{
                phoneCommentsValidation=true;
            }
            if(phone.getActive()!=""){
                switch (phone.getActive()){
                    case "1":
                        activeCheckboxValidation = checkBoxIsActive(By.cssSelector(phoneActiveCheckbox(group)));
                        break;
                    case "0":
                        activeCheckboxValidation = !checkBoxIsActive(By.cssSelector(phoneActiveCheckbox(group)));
                        break;
                    default: throw new IllegalArgumentException("Active Checkbox not verified");
                }
            }else{
                activeCheckboxValidation=true;
            }
            if(phone.getPrimary()!=""){
                switch (phone.getPrimary()){
                    case "1":
                        primaryCheckboxValidation = checkBoxIsActive(By.cssSelector(phonePrimaryCheckbox(group)));
                        break;
                    case "0":
                        primaryCheckboxValidation = !checkBoxIsActive(By.cssSelector(phonePrimaryCheckbox(group)));
                        break;
                    default: throw new IllegalArgumentException("Primary Checkbox not verified");
                }
            }else{
                primaryCheckboxValidation=true;
            }
            if(phoneNumberValidation
                    && phoneTypeValidation
                    && timeZoneValidation
                    && phoneStatusValidation
                    && phoneCommentsValidation
                    && activeCheckboxValidation
                    && primaryCheckboxValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }


    }

