package pages.records.person;

import bean.ContactEmailBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;


public class PersonContactEmailPage extends BasePage {
    private static final String EMAIL_ADDRESS_FIELD = "#entity_email_%s_email_address";
    private static final String EMAIL_TYPE_ELEMENT = "#entity_email_%s_email_type_component";
    private static final String EMAIL_OPT_IN_METHOD_ELEMENT = "#entity_email_%s_opt_in_method_id_component";
    private static final String EMAIL_OPT_IN_STATUS_ELEMENT = "#entity_email_%s_opt_in_status_toggle";
    private static final String EMAIL_OPT_IN_DATE_FIELD = "#entity_email_%s_opt_in_date";
    private static final String EMAIL_STATUS_ELEMENT = "#entity_email_%s_email_status_toggle";
    private static final String EMAIL_ACTIVE_CHECKBOX = "#entity_email_%s_active";
    private static final String EMAIL_PRIMARY_CHECKBOX = "#entity_email_%s_primary";
    private static final String EMAIL_COMMENTS_FIELD = "#entity_email_%s_email_comments";
    private static final String EMAIL_PLUS_SIGN_ELEMENT = "#entity_email_%s_add";
    private static final String EMAIL_DROP_DOWN = "//ul[starts-with(@id, 'entity_email_%s_')]//a[contains(text(),'%s')]";
    private static final String EMAIL_ADDRESS_FIELD_READ_ONLY = "//input[@id='entity_email_%s_email_address'][@readonly='readonly']";


    public static String emailAddressField(String index){
        return String.format(EMAIL_ADDRESS_FIELD,index);
    }
    public static String emailTypeElement(String index){
        return String.format(EMAIL_TYPE_ELEMENT,index);
    }
    public static String emailOptInMethodElement(String index){
        return String.format(EMAIL_OPT_IN_METHOD_ELEMENT,index);
    }
    public static String emailOptInStatusElement(String index){
        return String.format(EMAIL_OPT_IN_STATUS_ELEMENT,index);
    }
    public static String emailOptInDateField(String index){
        return String.format(EMAIL_OPT_IN_DATE_FIELD,index);
    }
    public static String emailStatusElement(String index){
        return String.format(EMAIL_STATUS_ELEMENT,index);
    }
    public static String emailCommentsField(String index){
        return String.format(EMAIL_COMMENTS_FIELD,index);
    }
    public static String emailActiveCheckbox(String index){
        return String.format(EMAIL_ACTIVE_CHECKBOX,index);
    }
    public static String emailPrimaryCheckbox(String index){
        return String.format(EMAIL_PRIMARY_CHECKBOX,index);
    }

    public static String emailPlusSignElement(String index){
        return String.format(EMAIL_PLUS_SIGN_ELEMENT,index);
    }
    public static String emailDropDown(String index){
        return String.format(EMAIL_DROP_DOWN,index);
    }
    public static String emailAddressFieldReadOnly(String index){
        return String.format(EMAIL_ADDRESS_FIELD_READ_ONLY,index);
    }
    public static String emailTypeElementList(String index){
        return String.format("#entity_email_%s_email_type_dropdown_menu",index);
    }
    public static String emailStatusElementList(String index){
        return String.format("#entity_email_%s_email_status_dropdown_menu",index);
    }
    public static String selectEmailOptInMethodList(String index){
        return String.format("#entity_email_%s_opt_in_method_id_dropdown_menu",index);
    }
    public static String emailOptInStatusElementList(String index){
        return String.format("#entity_email_%s_opt_in_status_dropdown_menu",index);
    }

    public static void verifyEmailPersonPageRecordParametersSteps(ContactEmailBean email , String group){
        String passMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_FAIL,group);

        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(emailAddressField(group)),email.getEmailAddress())
                    && MainPage.verifyGetText(By.cssSelector(emailTypeElement(group)),email.getEmailType())
                    && MainPage.verifyGetText(By.cssSelector(emailOptInMethodElement(group)),email.getEmailOptInMethod())
                    && MainPage.verifyGetText(By.cssSelector(emailOptInStatusElement(group)),email.getEmailOptInStatus())
                    && MainPage.verifyGetText(By.cssSelector(emailOptInDateField(group)),email.getEmailOptInDate())
                    && MainPage.verifyGetText(By.cssSelector(emailStatusElement(group)),email.getEmailStatus())
                    && MainPage.verifyGetText(By.cssSelector(emailCommentsField(group)),email.getEmailComments())
                    && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(emailActiveCheckbox(group)),email.getActive())
                    && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(emailPrimaryCheckbox(group)),email.getPrimary())){
            ExtentReportsSetUp.testingPass(passMessage);
        }else{
            FailureDelegatePage.handlePageException(failMessage);
        }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }


    public static void verifyReadOnlyEmail(String group){
        try {
            if(checkIfElementIsVisible(By.xpath(emailAddressFieldReadOnly(group)))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_READ_ONLY_EMAIL_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_READ_ONLY_EMAIL_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_READ_ONLY_EMAIL_FAIL);
        }
    }

    public static void createEmail(ContactEmailBean email, String group){
        String passMessage = String.format(LogPage.CREATE_EMAIL_PASS,group);
        String failMessage = String.format(LogPage.CREATE_EMAIL_FAIL,group);
        try {
            if(email.getEmailAddress()!=""){
                MainPage.fillField(By.cssSelector(emailAddressField(group)), email.getEmailAddress());
            }
            if(email.getEmailType()!=""){
                MainPage.clickOptionList(By.cssSelector(emailTypeElement(group)),
                        email.getEmailType(),
                        By.cssSelector(emailTypeElement(group)));
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

    public static void addEmail(String index){
        try {
            MainPage.addDeleteWithPlusButton(By.cssSelector(emailPlusSignElement(index)));
            ExtentReportsSetUp.testingPass(LogPage.ADD_EMAIL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ADD_EMAIL_FAIL);
        }
    }
    public static void verifyEmailPersonPageRecord(String index){

        int indexInt = Integer.parseInt(index);
        String passMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_PASS,index);
        String failMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_FAIL,index);

        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(emailAddressField(index)),mass.get(indexInt).get("EmailAddress"))
                    && MainPage.verifyGetText(By.cssSelector(emailTypeElement(index)),mass.get(indexInt).get("EmailType"))
                    && MainPage.verifyGetText(By.cssSelector(emailOptInMethodElement(index)),mass.get(indexInt).get("EmailOptInMethod"))
                    && MainPage.verifyGetText(By.cssSelector(emailOptInStatusElement(index)),mass.get(indexInt).get("EmailOptInStatus"))
                    && MainPage.verifyGetAttribute(By.cssSelector(emailOptInDateField(index)),mass.get(indexInt).get("EmailOptInDate"))
                    && MainPage.verifyGetText(By.cssSelector(emailStatusElement(index)),mass.get(indexInt).get("EmailStatus"))
                    && MainPage.verifyGetText(By.cssSelector(emailCommentsField(index)),mass.get(indexInt).get("EmailComments"))
                    && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(emailActiveCheckbox(index)),mass.get(indexInt).get("Active"))
                    && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(emailPrimaryCheckbox(index)),mass.get(indexInt).get("Primary"))){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
