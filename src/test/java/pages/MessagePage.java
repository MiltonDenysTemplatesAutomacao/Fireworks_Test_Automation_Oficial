package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class MessagePage extends BasePage{

    public static final String QUICK_ADD_PERSON_MODAL_VALIDATION_ALERT_MESSAGE = "quickAddPersonModalValidationAlertMessage";
    public static final String QUICK_ADD_PERSON_VALIDATION_ALERT_CLOSE_BUTTON = "quickAddPersonModalValidationAlertMessageAlertMessageClose";
    public static final String CLOSE_ALERT_PERSON_MODAL = ".//*[@class='panel-heading clearfix']";


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
     * Method to validate alert message
     */
    public static void validateRequiredFieldsMessage(String requiredMessage) {
        String errorMessage = String.format(LogPage.VALIDATE_REQUIRED_FIELDS_MESSAGE_FAIL,requiredMessage);
        String passMessage = String.format(LogPage.VALIDATE_REQUIRED_FIELDS_MESSAGE_PASS,requiredMessage);
        try {
            waitElementBy(By.id(QUICK_ADD_PERSON_MODAL_VALIDATION_ALERT_MESSAGE), 10);
            if (alertMessageByIdContains(QUICK_ADD_PERSON_MODAL_VALIDATION_ALERT_MESSAGE, requiredMessage)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            System.err.println(errorMessage);
        }
    }
}
