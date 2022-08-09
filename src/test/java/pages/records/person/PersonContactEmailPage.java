package pages.records.person;

import bean.ContactEmailBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;


public class PersonContactEmailPage extends BasePage {
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
        boolean emailAddressValidation = false;
        boolean emailTypeValidation = false;
        boolean emailOptInMethodValidation = false;
        boolean emailOptInStatusValidation = false;
        boolean emailOptInDateValidation = false;
        boolean emailStatusValidation = false;
        boolean emailCommentsValidation = false;
        boolean emailActiveCheckboxLocator = false;
        boolean emailPrymaryCheckboxLocator = false;

        int verifyEmailPersonPageRecordParametersStepsDelay = 20;

        String passMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_FAIL,group);

        try {
            scrollToElement(By.cssSelector(emailPlusSignElement(group)));
            if (email.getEmailAddress() != "") {
                waitElementBy(By.cssSelector(emailAddressField(group)),verifyEmailPersonPageRecordParametersStepsDelay);
                String emailAddressText = getAtribute(By.cssSelector(emailAddressField(group)),"value");
                emailAddressValidation = email.getEmailAddress().equals(emailAddressText);
            }else{
                emailAddressValidation = true;
            }
            if (email.getEmailType() != "") {
                waitElementBy(By.cssSelector(emailTypeElement(group)),verifyEmailPersonPageRecordParametersStepsDelay);
                String emailTypeText = getText(By.cssSelector(emailTypeElement(group)));
                emailTypeValidation = email.getEmailType().equals(emailTypeText);
            }else{
                emailTypeValidation = true;
            }
            if (email.getEmailOptInMethod() != "") {
                waitElementBy(By.cssSelector(emailOptInMethodElement(group)),verifyEmailPersonPageRecordParametersStepsDelay);
                String emailOptInMethodText = getText(By.cssSelector(emailOptInMethodElement(group)));
                emailOptInMethodValidation = email.getEmailOptInMethod().equals(emailOptInMethodText);
            }else{
                emailOptInMethodValidation = true;
            }
            if (email.getEmailOptInStatus() != "") {
                waitElementBy(By.cssSelector(emailOptInStatusElement(group)),verifyEmailPersonPageRecordParametersStepsDelay);
                String emailOptInStatusText = getText(By.cssSelector(emailOptInStatusElement(group)));
                emailOptInStatusValidation = email.getEmailOptInStatus().equals(emailOptInStatusText);
            }else{
                emailOptInStatusValidation=true;
            }
            if (email.getEmailOptInDate() != "") {
                waitElementBy(By.cssSelector(emailOptInDateField(group)),verifyEmailPersonPageRecordParametersStepsDelay);
                emailOptInDateValidation = verifyDateFieldWithoutHour(By.cssSelector(emailOptInDateField(group)));
            }else{
                emailOptInDateValidation = true;
            }
            if (email.getEmailOptInStatus() != "") {
                waitElementBy(By.cssSelector(emailStatusElement(group)),verifyEmailPersonPageRecordParametersStepsDelay);
                String emailStatusText = getText(By.cssSelector(emailStatusElement(group)));
                emailStatusValidation = email.getEmailOptInStatus().equals(emailStatusText);
            }else{
                emailStatusValidation = true;
            }
            if (email.getEmailComments() != "") {
                waitElementBy(By.cssSelector(emailCommentsField(group)),verifyEmailPersonPageRecordParametersStepsDelay);
                String emailCommentsText = getText(By.cssSelector(emailCommentsField(group)));
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
                wait(500);
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
                wait(500);
                clickOnListOfElements(email.getEmailOptInMethod());
            }
            if(email.getEmailOptInStatus()!=""){
                scrollToElement(By.cssSelector(emailPlusSignElement(group)));
                waitElementBy(By.cssSelector(emailOptInStatusElement(group)),createEmailDelay);
                BasePage.click(By.cssSelector(emailOptInStatusElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(emailOptInStatusElementList(group)), "a");
                wait(500);
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

        String passMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_PASS,index);
        String failMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_FAIL,index);

        try {
            scrollToElement(By.cssSelector(emailPlusSignElement(index)));
            int indexInt = Integer.parseInt(index);
            if (mass.get(indexInt).get("EmailAddress") != null) {
                String test = mass.get(indexInt).get("EmailAddress");
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
            if(mass.get(indexInt).get("Active") != null){
                switch (mass.get(indexInt).get("Active")){
                    case "1":
                        emailActiveCheckboxLocator = checkBoxIsActive(By.cssSelector(emailActiveCheckbox(index)));
                        break;
                    case "0":
                        emailActiveCheckboxLocator = !checkBoxIsActive(By.cssSelector(emailActiveCheckbox(index)));
                        break;
                    default: throw new IllegalArgumentException("Unhandled index. Update business logic");
                }
            }

            if(mass.get(indexInt).get("Primary") != null){
                switch (mass.get(indexInt).get("Primary")){
                    case "1":
                        emailPrymaryCheckboxLocator = checkBoxIsActive(By.cssSelector(emailPrimaryCheckbox(index)));
                        break;
                    case "0":
                        emailPrymaryCheckboxLocator = !checkBoxIsActive(By.cssSelector(emailPrimaryCheckbox(index)));
                        break;
                    default: throw new IllegalArgumentException("Unhandled index. Update business logic");
                }
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
}
