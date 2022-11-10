package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;
import pages.records.ActionsPage;
import support.mailtrap.MailTrapApi;
import support.mailtrap.entity.MessageEntity;

import java.util.HashMap;
import java.util.Map;

public class EmailPage extends BasePage{
    public static final String EMAIL_SETTINGS_TAB = "body > section > div > ul > li:nth-child(3) > a";
    private static final String CREATE_NEW_EMAIL_BUTTON = "#top-controls-create-new-email";
    private static final String EMAIL_TYPE_DIRECT = "top-controls-create-new-email-direct-link";
    private static final String EMAIL_TYPE_MARKETING = "top-controls-create-new-email-marketing-link";
    private static final String EMAIL_TYPE_NON_MARKETING = "top-controls-create-new-email-non-marketing-link";
    private static final String SEND_EMAIL_BUTTON = "#sendEmail";
    private static final String PREVIEW_RECIPIENTS_MODAL_LABEL = "#previewRecipientsModalLabel";
    private static final String PREVIEW_RECIPIENTS_ORG_MODAL_LABEL = "#previewOrgRecipientsModalLabel";
    private static final String PREVIEW_RECIPIENTS_MODAL_OK_BUTTON = "#modalSubmitButtonpreviewRecipients";
    private static final String PREVIEW_RECIPIENTS_ORG_MODAL_OK_BUTTON = "#modalSubmitButtonpreviewOrgRecipients";
    private static final String EMAIL_MANAGER_TABLE = "#emailManagerTable";
    private static final String EMAIL_MANAGER_SEARCH_FIELD = "#emailManagerTableControlsTableSearch";
    private static final String EMAIL_MANAGER_TABLE_ROW1_COLUMN1 = "#emailManagerTable_row_0_col_0";
    private static final String EMAIL_MANAGER_TABLE_ROW1_COLUMN3 = "#emailManagerTable_row_0_col_3";
    private static final String SCHEDULE_EMAIL_BUTTON = "#scheduleEmail";

    public static void testEmailHasBeenSent(String subject ){
        try {
            //instaciate dotenv to get variables from .env file and set here
            Dotenv dotenv = Dotenv.load();
            //Instanciating MailTrap Api
            MailTrapApi mailTrapApi = new MailTrapApi(dotenv.get("MAILTRAP_API_TOKEN"),dotenv.get("MAILTRAP_ACCOUNT_ID"),dotenv.get("MAILTRAP_INBOX_ID"));
            //search message list by subject on mailtrap
            MessageEntity[] response = mailTrapApi.searchMessage(subject);
            //get the first message from the list
            MessageEntity message = response[0];
            //get the subject and save in a variable
            String subjectFromApi = message.subject;
            //get the from email and save in a variable
            String fromEmailApi = message.from_email;
            //get html body message and save in a variable(for this it is necessary a new request because html is not included on the first request)
            String html = mailTrapApi.getHtmlBody(message.id);
            //request for mail trap to delete a message
            MessageEntity deletedMessage = mailTrapApi.deleteMessage(message.id);

            if(subject.equals(message.subject)){
                System.out.println(true);
            }else{
                System.out.println(false);
            }

        } catch (Exception e) {

        }
    }
    public static String returnElements (String elements){
        Map<String, String> returnElement = new HashMap<String, String>();
        returnElement.put("clearChangesDisabledButton", ClearChangesPage.CLEAR_CHANGES_DISABLED_BUTTON);
        returnElement.put("deleteActionDisabledButton", ActionsPage.DELETE_ACTION_DISABLED_BUTTON);
        returnElement.put("saveChangesDisabledButton", ActionsPage.SAVE_CHANGES_DISABLED_BUTTON);
        return returnElement.get(elements);
    }

    public static void validateIfElementIsVisibleOrNotForEmail(String element,String status){
        String passMessageVisible = String.format(LogPage.VALIDATE_IF_ELEMENT_IS_VISIBLE_PASS,element,status);
        String failMessageVisible = String.format(LogPage.VALIDATE_IF_ELEMENT_IS_VISIBLE_FAIL,element,status);
        String passMessageNotVisible = String.format(LogPage.VALIDATE_IF_ELEMENT_IS_NOT_VISIBLE_PASS,element,status);
        String failMessageNotVisible = String.format(LogPage.VALIDATE_IF_ELEMENT_IS_NOT_VISIBLE_FAIL,element,status);
        try {
            switch (status){
                case "visible":
                    if(verifyIfElementIsVisible(By.cssSelector(returnElements(element)))){
                        ExtentReportsSetUp.testingPass(passMessageVisible);
                    }else{
                        FailureDelegatePage.handlePageException(failMessageVisible);
                    }
                    break;
                case "not visible":
                    if(!verifyIfElementIsVisible(By.cssSelector(returnElements(element)))){
                        ExtentReportsSetUp.testingPass(passMessageNotVisible);
                    }else{
                        FailureDelegatePage.handlePageException(failMessageNotVisible);
                    }
                    break;
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_IF_ELEMENT_ERROR);
        }
    }

    public static void openEmail(String emailSearch){
        String passMessage = String.format(LogPage.OPEN_EMAIL_PASS,emailSearch);
        String failMessage = String.format(LogPage.OPEN_EMAIL_FAIL,emailSearch);
        try {
            searchEmailManager(emailSearch);
            verifyEmailFound(emailSearch);
            clickOption(By.cssSelector(EMAIL_MANAGER_TABLE_ROW1_COLUMN1));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void scheduleEmail(){
        try {
            clickOption(By.cssSelector(SCHEDULE_EMAIL_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SCHEDULE_EMAIL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SCHEDULE_EMAIL_FAIL);
        }
    }
    public static void verifyEmailFound(String emailName){
        String passMessage = String.format(LogPage.VERIFY_EMAIL_FOUND_PASS,emailName);
        String failMessage = String.format(LogPage.VERIFY_EMAIL_FOUND_FAIL,emailName);
        try {
            waitElementBy(By.cssSelector(EMAIL_MANAGER_TABLE),20);
            String emailText= getText(By.cssSelector(EMAIL_MANAGER_TABLE_ROW1_COLUMN1));
            if(emailName.equals(emailText)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }

    }
    public static void searchEmailManager(String emailName){
        try {
            waitElementBy(By.cssSelector(EMAIL_MANAGER_TABLE),20);
            write(By.cssSelector(EMAIL_MANAGER_SEARCH_FIELD),emailName);
            wait(2000);
        } catch (Exception e) {

        }
    }

    public static void waitUntilEmailSent(String emailName){
        int counter = 0;
        String status = "Queued";
        try {
        while(status=="Queued" && counter <10){
            searchEmailManager(emailName);
            verifyEmailFound(emailName);
            status = getText(By.cssSelector(EMAIL_MANAGER_TABLE_ROW1_COLUMN3));
        }
            if(status.contains("Sent")){
                ExtentReportsSetUp.testingPass(LogPage.WAIT_UNTIL_EMAIL_SENT_PASS);
            }else{
                counter++;
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.WAIT_UNTIL_EMAIL_SENT_FAIL);
        }
    }
    public static void confirmPreviewOK()throws Exception{
        waitUntilElementToBeSelected(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_OK_BUTTON),20);
        click(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_OK_BUTTON));
    }
    public static void confirmPreviewOrgOK()throws Exception{
        waitUntilElementToBeSelected(By.cssSelector(PREVIEW_RECIPIENTS_ORG_MODAL_OK_BUTTON),20);
        click(By.cssSelector(PREVIEW_RECIPIENTS_ORG_MODAL_OK_BUTTON));
    }
    public static void verifySendEmailConfirmationModal()throws Exception{
        waitElementBy(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_LABEL),20);
        verifyIfEquals(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_LABEL),"Preview Recipients");
    }
    public static void verifySendEmailOrgConfirmationModal()throws Exception{
        waitElementBy(By.cssSelector(PREVIEW_RECIPIENTS_ORG_MODAL_LABEL),20);
        verifyIfEquals(By.cssSelector(PREVIEW_RECIPIENTS_ORG_MODAL_LABEL),"Preview Recipients");
    }
    public static void confirmEmailSend(String type){
        try {
            switch (type){
                case "Person":
                    waitElementBy(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_LABEL),20);
                    verifySendEmailConfirmationModal();
                    confirmPreviewOK();
                    ExtentReportsSetUp.testingPass(LogPage.CONFIRM_EMAIL_SEND_PASS);
                    break;
                case "Organization":
                    waitElementBy(By.cssSelector(PREVIEW_RECIPIENTS_ORG_MODAL_LABEL),20);
                    verifySendEmailOrgConfirmationModal();
                    confirmPreviewOrgOK();
                    ExtentReportsSetUp.testingPass(LogPage.CONFIRM_EMAIL_SEND_PASS);
                    break;
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CONFIRM_EMAIL_SEND_PASS);
        }
    }
    public static void sendEmail(){
        try {
            scrollToTheBottom();
            waitUntilElementToBeSelected(By.cssSelector(SEND_EMAIL_BUTTON),20);
            click(By.cssSelector(SEND_EMAIL_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SEND_EMAIL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SEND_EMAIL_FAIL);
        }
    }
    public static void createNewEmail(String type){
        try {
            waitUntilElementToBeSelected(By.cssSelector(CREATE_NEW_EMAIL_BUTTON),20);
            click(By.cssSelector(CREATE_NEW_EMAIL_BUTTON));
            wait(500);
            switch (type){
                case "Direct":
                    click(By.id(EMAIL_TYPE_DIRECT));
                    break;
                case "Marketing":
                    click(By.id(EMAIL_TYPE_MARKETING));
                    break;
                case "Non-Marketing":
                    click(By.id(EMAIL_TYPE_NON_MARKETING));
                    break;
                default: throw new IllegalArgumentException("Unhandled index. Update business logic");
            }
            ExtentReportsSetUp.testingPass(LogPage.CREATE_NEW_EMAIL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_NEW_EMAIL_FAIL);
        }
    }

}
