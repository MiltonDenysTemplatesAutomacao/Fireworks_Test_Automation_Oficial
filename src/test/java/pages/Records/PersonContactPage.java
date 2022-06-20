package pages.Records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class PersonContactPage extends BasePage {


    private static String phoneNumberField(String index){
        return String.format("#entity_phone_%s_phone_number",index);
    }
    private static String phoneTypeElement(String index){
        return String.format("#entity_phone_%s_phone_type_component",index);
    }
    private static String phoneTypeElementList(String index){
        return String.format("#entity_phone_%s_phone_type_dropdown_menu",index);
    }
    private static String phoneStatusElement(String index){
        return String.format("#entity_phone_%s_phone_status_component",index);
    }
    private static String phoneStatusElementList(String index){
        return String.format("#entity_phone_%s_phone_status_dropdown_menu",index);
    }
    private static String phoneTimeZoneElement(String index){
        return String.format("#entity_phone_%s_phone_time_zone_component",index);
    }
    private static String phoneOptInMethodElement(String index){
        return String.format("#entity_phone_%s_phone_number",index);
    }
    private static String phoneOptInMethodElementList(String index){
        return String.format("#entity_phone_%s_text_messaging_opt_in_method_dropdown_menu",index);
    }
    private static String phoneOptInStatusElement(String index){
        return String.format("#entity_phone_%s_text_messaging_opt_in_status_component",index);
    }
    private static String phoneOptInStatusElementList(String index){
        return String.format("#entity_phone_%s_text_messaging_opt_in_status_dropdown_menu",index);
    }
    private static String phoneCommentsField(String index){
        return String.format("#entity_phone_%s_phone_comments",index);
    }
    private static String phoneActiveCheckbox(String index){
        return String.format("#entity_phone_%s_active",index);
    }
    private static String phonePrimaryCheckbox(String index){
        return String.format("#entity_phone_%s_primary",index);
    }


    public static void verifyPhone(String phoneNumber, String phoneType,String phoneStatus, String timeZone, String phoneOptInMethod, String phoneOptInStatus, String optInStatusDate, String phoneComments, String active,String primary,String group){
        boolean phoneNumberValidation = false;
        boolean phoneTypeValidation = false;
        boolean timeZoneValidation = false;
        boolean phoneStatusValidation = false;
        boolean phoneOptInMethodValidation = false;
        boolean phoneOptInStatusValidation = false;
        boolean phoneCommentsValidation = false;
        boolean activeCheckboxValidation = false;
        boolean primaryCheckboxValidation = false;

        String passMessage = String.format(LogPage.VERIFY_PHONE_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_PHONE_FAIL,group);
        try {
            scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));

            if(phoneNumber!=""){
                String phoneNumberText = getAtribute(By.cssSelector(phoneNumberField(group)),"value");
                phoneNumberValidation = phoneNumber.equals(phoneNumberText);
            }else{
                phoneNumberValidation=true;
            }
            if(phoneType!=""){
                String phoneTypeText = getText(By.cssSelector(phoneTypeElement(group)));
                phoneTypeValidation = phoneType.equals(phoneTypeText);
            }else{
                phoneTypeValidation=true;
            }
            if(phoneStatus!=""){
                String phoneStatusText = getText(By.cssSelector(phoneStatusElement(group)));
                phoneStatusValidation = timeZone.equals(phoneStatusText);
            }else{
                phoneStatusValidation=true;
            }
            if(timeZone!=""){
                String timeZoneText = getText(By.cssSelector(phoneTimeZoneElement(group)));
                timeZoneValidation = timeZone.equals(timeZoneText);
            }else{
                timeZoneValidation=true;
            }
            if(phoneOptInMethod!=""){
                String phoneOptInMethodText = getText(By.cssSelector(phoneOptInMethodElement(group)));
                phoneOptInMethodValidation = phoneOptInMethod.equals(phoneOptInMethodText);
            }else{
                phoneOptInMethodValidation=true;
            }
            if(phoneOptInStatus!=""){
                String phoneOptInStatusText = getText(By.cssSelector(phoneOptInStatusElement(group)));
                phoneOptInStatusValidation = phoneOptInStatus.equals(phoneOptInStatusText);
            }else{
                phoneOptInStatusValidation=true;
            }
            if(phoneComments!=""){
                String phoneCommentsText = getAtribute(By.cssSelector(phoneCommentsField(group)),"value");
                phoneCommentsValidation = phoneOptInStatus.equals(phoneCommentsText);
            }else{
                phoneCommentsValidation=true;
            }
            if(active!=""){
                switch (active){
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
            if(primary!=""){
                switch (primary){
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
            && phoneOptInMethodValidation
            && phoneOptInStatusValidation
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

    public static void createPhoneForPerson(String phoneNumber, String phoneType,String phoneStatus,String phoneOptInMethod,String phoneOptInStatus, String phoneComments, String active,String primary,String group){
        int createPhoneForPersonDelay = 20;

        try {
            if(phoneNumber!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneNumberField(group)),createPhoneForPersonDelay);
                write(By.cssSelector(phoneNumberField(group)), phoneNumber);
            }
            if(phoneType!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneTypeElement(group)),createPhoneForPersonDelay);
                BasePage.click(By.cssSelector(phoneTypeElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(phoneTypeElementList(group)), "a");
                clickOnListOfElements(phoneType);
                wait(1000);
            }
            if(phoneStatus!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneStatusElement(group)),createPhoneForPersonDelay);
                BasePage.click(By.cssSelector(phoneStatusElement(group)));
                waitElementBy(By.cssSelector(phoneStatusElementList(group)),createPhoneForPersonDelay);
                BasePage.selectElementsList(By.cssSelector(phoneStatusElementList(group)), "a");
                clickOnListOfElements(phoneStatus);
                wait(1000);
            }
            if(phoneOptInMethod!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneOptInMethodElement(group)),createPhoneForPersonDelay);
                BasePage.click(By.cssSelector(phoneOptInMethodElement(group)));
                waitElementBy(By.cssSelector(phoneOptInMethodElementList(group)),createPhoneForPersonDelay);
                BasePage.selectElementsList(By.cssSelector(phoneOptInMethodElementList(group)), "a");
                clickOnListOfElements(phoneOptInMethod);
                wait(1000);
            }
            if(phoneOptInStatus!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneOptInStatusElement(group)),createPhoneForPersonDelay);
                BasePage.click(By.cssSelector(phoneOptInStatusElement(group)));
                waitElementBy(By.cssSelector(phoneOptInStatusElementList(group)),createPhoneForPersonDelay);
                BasePage.selectElementsList(By.cssSelector(phoneOptInStatusElementList(group)), "a");
                clickOnListOfElements(phoneOptInStatus);
                wait(1000);
            }
            if(phoneComments!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneCommentsField(group)),createPhoneForPersonDelay);
                write(By.cssSelector(phoneCommentsField(group)), phoneComments);
            }
            if(active!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                click(By.cssSelector(phoneActiveCheckbox(group)));
            }
            if(primary!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                click(By.cssSelector(phonePrimaryCheckbox(group)));
            }
            ExtentReportsSetUp.testingPass(LogPage.CREATE_PHONE_FOR_PERSON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_PHONE_FOR_PERSON_FAIL);
        }
    }
}
