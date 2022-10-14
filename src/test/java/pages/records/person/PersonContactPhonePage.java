package pages.records.person;

import bean.ContactPhoneBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;


public class PersonContactPhonePage extends BasePage {
    public static String phonePlusSignElement(String index){
        return String.format("#entity_phone_%s_add",index);
    }

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
        return String.format("#entity_phone_%s_text_messaging_opt_in_method_toggle",index);
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
    private static String phoneNumberFieldReadOnly(String index){
        return String.format("//input[@id='entity_phone_%s_phone_number'][@readonly='readonly']",index);
    }


    public static void verifyPhoneReadOnly(String index){
        String passMessage = String.format(LogPage.VERIFY_PHONE_READ_ONLY_PASS,index);
        String failMessage = String.format(LogPage.VERIFY_PHONE_READ_ONLY_FAIL,index);
        try {
            if(MainPage.verifyIfElementIsVisible(By.xpath(phoneNumberFieldReadOnly(index)))){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void addPhone(String index){
        try {
            MainPage.addDeleteWithPlusButton(By.cssSelector(phonePlusSignElement(index)));
            ExtentReportsSetUp.testingPass(LogPage.ADD_PHONE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ADD_PHONE_FAIL);
        }
    }
    public static void createPhoneForPerson(ContactPhoneBean phone, String group){

        try {
            if(phone.getPhoneNumber()!=""){
                MainPage.fillField(By.cssSelector(phoneNumberField(group)), phone.getPhoneNumber());
            }
            if(phone.getPhoneType()!=""){
                MainPage.clickOptionList(By.cssSelector(phoneTypeElement(group)),
                        phone.getPhoneType(),
                        By.cssSelector(phoneTypeElementList(group)));
            }
            if(phone.getPhoneStatus()!=""){
                MainPage.clickOptionList(By.cssSelector(phoneStatusElement(group)),
                        phone.getPhoneStatus(),
                        By.cssSelector(phoneStatusElementList(group)));
            }
            if(phone.getPhoneOptInMethod()!=""){
                MainPage.clickOptionList(By.cssSelector(phoneOptInMethodElement(group)),
                        phone.getPhoneOptInMethod(),
                        By.cssSelector(phoneOptInMethodElementList(group)));
            }
            if(phone.getPhoneOptInStatus()!=""){
                MainPage.clickOptionList(By.cssSelector(phoneOptInStatusElement(group)),
                        phone.getPhoneOptInStatus(),
                        By.cssSelector(phoneOptInStatusElementList(group)));
            }
            if(phone.getPhoneComments()!=""){
                MainPage.fillField(By.cssSelector(phoneCommentsField(group)), phone.getPhoneComments());
            }
            if(phone.getActive()!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                click(By.cssSelector(phoneActiveCheckbox(group)));
            }
            if(phone.getPrimary()!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                click(By.cssSelector(phonePrimaryCheckbox(group)));
            }
            ExtentReportsSetUp.testingPass(LogPage.CREATE_PHONE_FOR_PERSON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_PHONE_FOR_PERSON_FAIL);
        }
    }
    public static void verifyPhone(ContactPhoneBean phone,String group){
        String passMessage = String.format(LogPage.VERIFY_PHONE_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_PHONE_FAIL,group);
        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(phoneNumberField(group)),phone.getPhoneNumber())
                    && MainPage.verifyGetText(By.cssSelector(phoneTypeElement(group)),phone.getPhoneType())
                    && MainPage.verifyGetText(By.cssSelector(phoneStatusElement(group)),phone.getPhoneStatus())
                    && MainPage.verifyGetText(By.cssSelector(phoneTimeZoneElement(group)),phone.getPhoneTimeZone())
                    && MainPage.verifyGetText(By.cssSelector(phoneOptInMethodElement(group)),phone.getPhoneOptInMethod())
                    && MainPage.verifyGetText(By.cssSelector(phoneOptInStatusElement(group)),phone.getPhoneOptInStatus())
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
