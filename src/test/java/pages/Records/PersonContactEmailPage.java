package pages.Records;

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

    public static void verifyEmailPersonPageRecordParametersSteps(String emailAddress,String emailType,String emailStatus,String emailOptInMethod,String emailOptInStatus,String emailOptInDate, String emailComments,String active,String primary,String group){
        boolean emailAddressValidation = false;
        boolean emailTypeValidation = false;
        boolean emailOptInMethodValidation = false;
        boolean emailOptInStatusValidation = false;
        boolean emailOptInDateValidation = false;
        boolean emailStatusValidation = false;
        boolean emailCommentsValidation = false;
        boolean emailActiveCheckboxLocator = false;
        boolean emailPrymaryCheckboxLocator = false;

        String passMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_FAIL,group);

        try {
            scrollToElement(By.cssSelector(emailPlusSignElement(group)));
            if (emailAddress != "") {
                String emailAddressText = getAtribute(By.cssSelector(emailAddressField(group)),"value");
                emailAddressValidation = emailAddress.equals(emailAddressText);
            }else{
                emailAddressValidation = true;
            }
            if (emailType != "") {
                String emailTypeText = getText(By.cssSelector(emailTypeElement(group)));
                emailTypeValidation = emailType.equals(emailTypeText);
            }else{
                emailTypeValidation = true;
            }
            if (emailOptInMethod != "") {
                String emailOptInMethodText = getText(By.cssSelector(emailOptInMethodElement(group)));
                emailOptInMethodValidation = emailOptInMethod.equals(emailOptInMethodText);
            }else{
                emailOptInMethodValidation = true;
            }
            if (emailOptInStatus != "") {
                String emailOptInStatusText = getText(By.cssSelector(emailOptInStatusElement(group)));
                emailOptInStatusValidation = emailOptInStatus.equals(emailOptInStatusText);
            }else{
                emailOptInStatusValidation=true;
            }
            if (emailOptInDate != "") {
                String emailOptInDateText = getAtribute(By.cssSelector(emailOptInDateField(group)),"value");
                emailOptInDateValidation = emailOptInDate.equals(emailOptInDateText);
            }else{
                emailOptInDateValidation = true;
            }
            if (emailStatus != "") {
                String emailStatusText = getText(By.cssSelector(emailStatusElement(group)));
                emailStatusValidation = emailStatus.equals(emailStatusText);
            }else{
                emailStatusValidation = true;
            }
            if (emailComments != "") {
                String emailCommentsText = getText(By.cssSelector(emailCommentsField(group)));
                emailCommentsValidation = emailComments.equals(emailCommentsText);
            }else{
                emailCommentsValidation = true;
            }

            if(active != ""){
                switch (active){
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

            if(primary != ""){
                switch (primary){
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

    public static void createEmail(String emailAddress,String emailType,String emailStatus,String emailOptInMethod,String emailOptInStatus,String emailComments,String active,String primary,String group){
        String passMessage = String.format(LogPage.CREATE_EMAIL_PASS,group);
        String failMessage = String.format(LogPage.CREATE_EMAIL_FAIL,group);
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
