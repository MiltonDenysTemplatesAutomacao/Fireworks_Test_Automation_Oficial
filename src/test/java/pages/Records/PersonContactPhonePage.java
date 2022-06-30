package pages.Records;

import bean.ContactPhoneBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;


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

    public static void addPhone(String index){
        try {
            scrollToElement(By.cssSelector(phonePlusSignElement(index)));
            scrollTo("-100");
            waitUntilElementToBeSelected(By.cssSelector(phonePlusSignElement(index)), 20);
            BasePage.click(By.cssSelector(phonePlusSignElement(index)));
            ExtentReportsSetUp.testingPass(LogPage.ADD_PHONE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ADD_PHONE_FAIL);
        }
    }
    public static void createPhoneForPerson(ContactPhoneBean phone, String group){
        int createPhoneForPersonDelay = 20;

        try {
            if(phone.getPhoneNumber()!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneNumberField(group)),createPhoneForPersonDelay);
                write(By.cssSelector(phoneNumberField(group)), phone.getPhoneNumber());
            }
            if(phone.getPhoneType()!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneTypeElement(group)),createPhoneForPersonDelay);
                BasePage.click(By.cssSelector(phoneTypeElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(phoneTypeElementList(group)), "a");
                clickOnListOfElements(phone.getPhoneType());
                wait(1000);
            }
            if(phone.getPhoneStatus()!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneStatusElement(group)),createPhoneForPersonDelay);
                BasePage.click(By.cssSelector(phoneStatusElement(group)));
                waitElementBy(By.cssSelector(phoneStatusElementList(group)),createPhoneForPersonDelay);
                BasePage.selectElementsList(By.cssSelector(phoneStatusElementList(group)), "a");
                clickOnListOfElements(phone.getPhoneStatus());
                wait(1000);
            }
            if(phone.getPhoneOptInMethod()!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneOptInMethodElement(group)),createPhoneForPersonDelay);
                BasePage.click(By.cssSelector(phoneOptInMethodElement(group)));
                waitElementBy(By.cssSelector(phoneOptInMethodElementList(group)),createPhoneForPersonDelay);
                BasePage.selectElementsList(By.cssSelector(phoneOptInMethodElementList(group)), "a");
                clickOnListOfElements(phone.getPhoneOptInMethod());
                wait(1000);
            }
            if(phone.getPhoneOptInStatus()!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneOptInStatusElement(group)),createPhoneForPersonDelay);
                BasePage.click(By.cssSelector(phoneOptInStatusElement(group)));
                waitElementBy(By.cssSelector(phoneOptInStatusElementList(group)),createPhoneForPersonDelay);
                BasePage.selectElementsList(By.cssSelector(phoneOptInStatusElementList(group)), "a");
                clickOnListOfElements(phone.getPhoneOptInStatus());
                wait(1000);
            }
            if(phone.getPhoneComments()!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneCommentsField(group)),createPhoneForPersonDelay);
                write(By.cssSelector(phoneCommentsField(group)), phone.getPhoneComments());
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
            if(phone.getPhoneOptInMethod()!=""){
                String phoneOptInMethodText = getText(By.cssSelector(phoneOptInMethodElement(group)));
                phoneOptInMethodValidation = phone.getPhoneOptInMethod().equals(phoneOptInMethodText);
            }else{
                phoneOptInMethodValidation=true;
            }
            if(phone.getPhoneOptInStatus()!=""){
                String phoneOptInStatusText = getText(By.cssSelector(phoneOptInStatusElement(group)));
                phoneOptInStatusValidation = phone.getPhoneOptInStatus().equals(phoneOptInStatusText);
            }else{
                phoneOptInStatusValidation=true;
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
}
