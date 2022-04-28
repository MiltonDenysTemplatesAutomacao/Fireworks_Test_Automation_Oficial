package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class MessagePage extends BasePage{

    public static final String QUICK_ADD_PERSON_MODAL_VALIDATION_ALERT_MESSAGE = "quickAddPersonModalValidationAlertMessage";
    public static final String QUICK_ADD_PERSON_VALIDATION_ALERT_CLOSE_BUTTON = "quickAddPersonModalValidationAlertMessageAlertMessageClose";
    public static final String CLOSE_ALERT_PERSON_MODAL = ".//*[@class='panel-heading clearfix']";
    public static final String GENERAL_ALERT_MESSAGE = "#alertMessage";
    public static final String GENERAL_ALERT_CLOSE_BUTTON = "#generalAlertMessageClose";
    public static final String REQUIRED_FIELDS_PERSON_RECORD_MODAL = "#pageAlertMessages";
    public static final String VALIDATION_ALERT_CLOSE_BUTTON = "#pageValidationAlertMessageClose";


    /*
     * Method to close alert person modal
     */
    public static void closeAlertPersonRecordModal(){
        try {
            waitUntilElementToBeSelected(By.cssSelector(VALIDATION_ALERT_CLOSE_BUTTON),20);
            scrollToElement(By.cssSelector(VALIDATION_ALERT_CLOSE_BUTTON));
            click(By.cssSelector(VALIDATION_ALERT_CLOSE_BUTTON));
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

        try {
            String messageReturn = getText(By.cssSelector(GENERAL_ALERT_MESSAGE));
            if(messageReturn.contains(messageAlert)){
                waitUntilElementToBeSelected(By.cssSelector(GENERAL_ALERT_MESSAGE),20);
                scrollToElement(By.cssSelector(GENERAL_ALERT_MESSAGE));
                click(By.cssSelector(GENERAL_ALERT_CLOSE_BUTTON));
            }
            ExtentReportsSetUp.testingPass(passMessage);
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
