package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class MessagePage extends BasePage{

    public static final String QUICK_ADD_PERSON_MODAL_VALIDATION_ALERT_MESSAGE = "quickAddPersonModalValidationAlertMessage";
    public static final String QUICK_ADD_ORGANIZATION_MODAL_VALIDATION_ALERT_MESSAGE = "quickAddOrganizationModalValidationAlertMessage";
    public static final String QUICK_ADD_PERSON_VALIDATION_ALERT_CLOSE_BUTTON = "quickAddPersonModalValidationAlertMessageAlertMessageClose";
    public static final String CLOSE_ALERT_PERSON_MODAL = ".//*[@class='panel-heading clearfix']";
    public static final String GENERAL_ALERT_MESSAGE = "#alertMessage";
    public static final String GENERAL_ALERT_CLOSE_BUTTON = "#generalAlertMessageClose";
    public static final String REQUIRED_FIELDS_PERSON_RECORD_MODAL = "#pageAlertMessages";
    public static final String VALIDATION_ALERT_CLOSE_BUTTON = "#pageValidationAlertMessageClose";
    public static final String QUICK_ADD_STAFF_MODAL_VALIDATION_ALERT_MESSAGE = "quickAddStaffModalValidationAlertMessage";
    public static final String QUICK_ADD_STAFF_MODAL_ALERT_MESSAGE = "#quickAddStaffModalAlertMessage";
    public static final String PAGE_ALERT_MESSAGES = "#pageAlertMessages";
    public static final String VALIDATION_ALERT_MESSAGE = "div.pageValidationAlertMessage.alert.alert-danger.alert-dismissible";


    public static void verifyDoNotSeeValidationMessage(String message){
        String errorMessage = String.format(LogPage.VERIFY_DO_NOT_SEE_VALIDATION_MESSAGE_FAIL, message);
        String passMessage = String.format(LogPage.VERIFY_DO_NOT_SEE_VALIDATION_MESSAGE_PASS, message);
        wait(500);
        try {
            String verifyValidationMessage = getText(By.cssSelector(VALIDATION_ALERT_MESSAGE));
            waitElementBy(By.cssSelector(VALIDATION_ALERT_MESSAGE), 10);
            if (!verifyValidationMessage.contains(message)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    public static void verifyValidationMessage(String message){
        String errorMessage = String.format(LogPage.VERIFY_VALIDATION_MESSAGE_FAIL, message);
        String passMessage = String.format(LogPage.VERIFY_VALIDATION_MESSAGE_PASS, message);
        wait(1000);
        try {
            String verifyValidationMessage = getText(By.cssSelector(VALIDATION_ALERT_MESSAGE));
            waitElementBy(By.cssSelector(VALIDATION_ALERT_MESSAGE), 10);
            if (verifyValidationMessage.contains(message)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void seeInSourceMessage(String message){
        String errorMessage = String.format(LogPage.SEE_IN_SOURCE_MESSAGE_FAIL, message);
        String passMessage = String.format(LogPage.SEE_IN_SOURCE_MESSAGE_PASS, message);
        try {
            if(seeInSource(message)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    public static void pageAlertMessages(String alertMessage){
        String errorMessage = String.format(LogPage.ALERT_MESSAGE_FAIL, alertMessage);
        String passMessage = String.format(LogPage.ALERT_MESSAGE_PASS, alertMessage);
        try {
            waitElementBy(By.cssSelector(PAGE_ALERT_MESSAGES), 10);
            if (alertMessageContains(By.cssSelector(PAGE_ALERT_MESSAGES), alertMessage)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }


    public static void validateStaffRequiredFields(String requiredMessage) {
        String errorMessage = String.format(LogPage.VALIDATE_STAFF_REQUIRED_FIELDS_MESSAGE_FAIL,requiredMessage);
        String passMessage = String.format(LogPage.VALIDATE_STAFF_REQUIRED_FIELDS_MESSAGE_PASS,requiredMessage);
        try {
            waitElementBy(By.cssSelector(QUICK_ADD_STAFF_MODAL_ALERT_MESSAGE), 10);
            if (alertMessageContains(By.cssSelector(QUICK_ADD_STAFF_MODAL_ALERT_MESSAGE), requiredMessage)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    public static void validateStaffRequiredFieldsMessage(String requiredMessage) {
        String errorMessage = String.format(LogPage.VALIDATE_STAFF_REQUIRED_FIELDS_MESSAGE_FAIL,requiredMessage);
        String passMessage = String.format(LogPage.VALIDATE_STAFF_REQUIRED_FIELDS_MESSAGE_PASS,requiredMessage);
        try {
            waitElementBy(By.id(QUICK_ADD_STAFF_MODAL_VALIDATION_ALERT_MESSAGE), 10);
            if (alertMessageContains(By.id(QUICK_ADD_STAFF_MODAL_VALIDATION_ALERT_MESSAGE), requiredMessage)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    public static void closeAlertPersonRecordModal(){
        try {
            waitUntilElementToBeSelected(By.cssSelector(VALIDATION_ALERT_CLOSE_BUTTON),20);
            scrollToElement(By.cssSelector(VALIDATION_ALERT_CLOSE_BUTTON));
            click(By.cssSelector(VALIDATION_ALERT_CLOSE_BUTTON));
            wait(1000);
            ExtentReportsSetUp.testingPass(LogPage.CLOSE_ALERT_PERSON_RECORD_MODAL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLOSE_ALERT_PERSON_RECORD_MODAL_FAIL);
        }
    }

    /*
     * Method to close alert if a specific message returns
     */
    public static void closeAlertIfReturned(String messageAlert){
        String errorMessage = String.format(LogPage.CLOSE_ALERT_IF_RETURNED_FAIL, messageAlert);
        String passMessage = String.format(LogPage.CLOSE_ALERT_IF_RETURNED_PASS, messageAlert);
        wait(500);
        try {
            String messageReturn = getText(By.cssSelector(GENERAL_ALERT_MESSAGE));
            if(messageReturn.contains(messageAlert)){
                waitUntilElementToBeSelected(By.cssSelector(GENERAL_ALERT_MESSAGE),20);
                scrollToElement(By.cssSelector(GENERAL_ALERT_MESSAGE));
                wait(1000);
                click(By.cssSelector(GENERAL_ALERT_CLOSE_BUTTON));
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    /*
     * Method to close alert person modal
     */
    public static void closeAlertPersonModal(){
        try {
            waitUntilElementToBeSelected(By.id(QUICK_ADD_PERSON_VALIDATION_ALERT_CLOSE_BUTTON),20);
            scrollToElement(By.xpath(CLOSE_ALERT_PERSON_MODAL));
            click(By.id(QUICK_ADD_PERSON_VALIDATION_ALERT_CLOSE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLOSE_ALERT_PERSON_MODAL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLOSE_ALERT_PERSON_MODAL_FAIL);
        }
    }
    /*
     * Method to validate alert message while creating a person
     */
    public static void validateRequiredFieldsMessage(String requiredMessage) {
        String errorMessage = String.format(LogPage.VALIDATE_REQUIRED_FIELDS_MESSAGE_FAIL,requiredMessage);
        String passMessage = String.format(LogPage.VALIDATE_REQUIRED_FIELDS_MESSAGE_PASS,requiredMessage);
        try {
            waitElementBy(By.id(QUICK_ADD_PERSON_MODAL_VALIDATION_ALERT_MESSAGE), 10);
            if (alertMessageContains(By.id(QUICK_ADD_PERSON_MODAL_VALIDATION_ALERT_MESSAGE), requiredMessage)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    public static void validateOrgRequiredFieldsMessage(String requiredMessage) {
        String errorMessage = String.format(LogPage.VALIDATE_REQUIRED_FIELDS_MESSAGE_FAIL,requiredMessage);
        String passMessage = String.format(LogPage.VALIDATE_REQUIRED_FIELDS_MESSAGE_PASS,requiredMessage);
        try {
            waitElementBy(By.id(QUICK_ADD_ORGANIZATION_MODAL_VALIDATION_ALERT_MESSAGE), 10);
            if (alertMessageContains(By.id(QUICK_ADD_ORGANIZATION_MODAL_VALIDATION_ALERT_MESSAGE), requiredMessage)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    /*
     * Method to validate required messages for person record
     */
    public static void validateRecordRequiredFieldsMessage(String requiredMessage) {
        String errorMessage = String.format(LogPage.VALIDATE_PERSON_RECORD_REQUIRED_FIELDS_MESSAGE_FAIL,requiredMessage);
        String passMessage = String.format(LogPage.VALIDATE_PERSON_RECORD_REQUIRED_FIELDS_MESSAGE_PASS,requiredMessage);
        try {
            waitElementBy(By.cssSelector(REQUIRED_FIELDS_PERSON_RECORD_MODAL), 10);
            if (alertMessageContains(By.cssSelector(REQUIRED_FIELDS_PERSON_RECORD_MODAL), requiredMessage)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
}
