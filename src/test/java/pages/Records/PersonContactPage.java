package pages.Records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class PersonContactPage extends BasePage {

    private static final String EMAIL_ADDRESS_FIELD = "#entity_email_%s_email_address";
    private static final String EMAIL_TYPE_ELEMENT = "#entity_email_%s_email_type_component";
    private static final String EMAIL_OPT_IN_METHOD_ELEMENT = "#entity_email_%s_opt_in_method_id_component";
    private static final String EMAIL_OPT_IN_STATUS_ELEMENT = "#entity_email_%s_opt_in_status_component";
    private static final String EMAIL_OPT_IN_DATE_FIELD = "#entity_email_%s_opt_in_date";
    private static final String EMAIL_STATUS_ELEMENT = "#entity_email_%s_email_status_component";
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

    /*
     * Method to check to verify email person on page records
     */
    public static void verifyEmailPersonPageRecord(String index){

        boolean emailAddressValidation = false;
        boolean emailTypeValidation = false;
        boolean emailOptInMethodValidation = false;
        boolean emailOptInStatusValidation = false;
        boolean emailOptInDateValidation = false;
        boolean emailStatusValidation = false;
        boolean emailCommentsValidation = false;
        boolean emailActiveCheckboxLocator = false;
        boolean emailPrymaryCheckboxLocator = false;

        try {
            scrollToElement(By.cssSelector(emailAddressField(index)));
            int indexInt = Integer.parseInt(index);
            if (mass.get(indexInt).get("EmailAddress") != null) {
                String emailAddress = getAtribute(By.cssSelector(emailAddressField(index)),"value");
                emailAddressValidation = emailAddress.equals(mass.get(indexInt).get("EmailAddress"));
            }else{
                emailAddressValidation = true;
            }
            if (mass.get(indexInt).get("EmailType") != null) {
                String emailType = getText(By.cssSelector(emailTypeElement(index)));
                emailTypeValidation = emailType.equals(mass.get(indexInt).get("EmailType"));
            }else{
                emailTypeValidation = true;
            }
            if (mass.get(indexInt).get("EmailOptInMethod") != null) {
                String emailOptInMethod = getText(By.cssSelector(emailOptInMethodElement(index)));
                emailOptInMethodValidation = emailOptInMethod.equals(mass.get(indexInt).get("EmailOptInMethod"));
            }else{
                emailOptInMethodValidation = true;
            }
            if (mass.get(indexInt).get("EmailOptInStatus") != null) {
                String emailOptInStatus = getText(By.cssSelector(emailOptInStatusElement(index)));
                emailOptInStatusValidation = emailOptInStatus.equals(mass.get(indexInt).get("EmailOptInStatus"));
            }else{
                emailOptInStatusValidation=true;
            }
            if (mass.get(indexInt).get("EmailOptInDate") != null) {
                String emailOptInDate = getAtribute(By.cssSelector(emailOptInDateField(index)),"value");
                emailOptInDateValidation = emailOptInDate.equals(mass.get(indexInt).get("EmailOptInDate"));
            }else{
                emailOptInDateValidation = true;
            }
            if (mass.get(indexInt).get("EmailStatus") != null) {
                String emailStatus = getText(By.cssSelector(emailStatusElement(index)));
                emailStatusValidation = emailStatus.equals(mass.get(indexInt).get("EmailStatus"));
            }else{
                emailStatusValidation = true;
            }
            if (mass.get(indexInt).get("EmailComments") != null) {
                String emailComments = getText(By.cssSelector(emailCommentsField(index)));
                emailCommentsValidation = emailComments.equals(mass.get(indexInt).get("EmailComments"));
            }else{
                emailCommentsValidation = true;
            }
            switch (indexInt){
                case 0:
                    emailActiveCheckboxLocator = checkBoxIsActive(By.cssSelector(emailActiveCheckbox(index)));
                    break;
                case 1:
                    emailActiveCheckboxLocator = !checkBoxIsActive(By.cssSelector(emailActiveCheckbox(index)));
                    break;
                default: throw new IllegalArgumentException("Unhandled index. Update business logic");
            }

            switch (indexInt){
                case 0:
                    emailPrymaryCheckboxLocator = checkBoxIsActive(By.cssSelector(emailPrimaryCheckbox(index)));
                    break;
                case 1:
                    emailPrymaryCheckboxLocator = !checkBoxIsActive(By.cssSelector(emailPrimaryCheckbox(index)));
                    break;
                default: throw new IllegalArgumentException("Unhandled index. Update business logic");
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
                    ExtentReportsSetUp.testingPass(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_PASS);
                }else{
                    FailureDelegatePage.handlePageException(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_FAIL);
                }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_FAIL);
        }
    }
}
