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
    private static final String MANUAL_TEST_LOG = "#manualTestLog";
    private static final String DELETE_DRAFT_EMAIL_BUTTON = "#emailHeaderDeleteButton";
    private static final String DELETE_EMAIL_MODAL_SUBMIT_BUTTON = "#modalSubmitButtondeleteEmail";
    private static final String RECIPIENTS_TABLE_ROW1_COLUMN1 = "#recipientEmailManagerTable_row_0_col_0";
    private static final String RECIPIENTS_TABLE_ROW2_COLUMN2 = "#recipientEmailManagerTable_row_1_col_1";
    private static final String RECIPIENTS_TABLE_SEARCH_FIELD = "#recipientEmailManagerTableControlsTableSearch";
    private static final String CAN_SPAM_SEND_EMAIL_BUTTON = "#modalSubmitButtoncanSpam";
    private static final String CAN_SPAM_AGREEMENT_CHECKBOX = "#canSpamAgreement";

    public static void validateAttachmentFileName(String subject , String fileName){
        String passMessage = String.format(LogPage.VALIDATE_ATTACHMENT_FILE_NAME_PASS,fileName);
        String failMessage = String.format(LogPage.VALIDATE_ATTACHMENT_FILE_NAME_FAIL,fileName);
        try {
            Dotenv dotenv = Dotenv.load();
            MailTrapApi mailTrapApi = new MailTrapApi(dotenv.get("MAILTRAP_API_TOKEN"),dotenv.get("MAILTRAP_ACCOUNT_ID"),dotenv.get("MAILTRAP_INBOX_ID"));
            MessageEntity[] response = mailTrapApi.searchMessage(subject);
            MessageEntity message = response[0];
            if(verify2StringContains(mailTrapApi.getAttachmentFileName(message.id),fileName)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_ATTACHMENT_FILE_NAME_FAIL);

        }
    }
    public static void confirmNoMarketingContent(){
        try {
            clickCheckbox(By.cssSelector(CAN_SPAM_AGREEMENT_CHECKBOX));
            clickOption(By.cssSelector(CAN_SPAM_SEND_EMAIL_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CONFIRM_NO_MARKETING_CONTENT_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CONFIRM_NO_MARKETING_CONTENT_FAIL);
        }
    }
    public static void searchRecipientsTable(String recipients){
        String passMessage = String.format(LogPage.SEARCH_RECIPIENTS_TABLE_PASS,recipients);
        String failMessage = String.format(LogPage.SEARCH_RECIPIENTS_TABLE_FAIL,recipients);
        try {
            fillField(By.cssSelector(RECIPIENTS_TABLE_SEARCH_FIELD),recipients);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyNoResultsForRecipients(String search){
        String passMessage = String.format(LogPage.VERIFY_NO_RESULTS_FOR_RECIPIENTS_PASS,search);
        String failMessage = String.format(LogPage.VERIFY_NO_RESULTS_FOR_RECIPIENTS_FAIL,search);
        try {
            if(verifyGetText(By.cssSelector(RECIPIENTS_TABLE_ROW1_COLUMN1),search)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyChangeNameForPerson3IsNotReflected(String name){
        String passMessage = String.format(LogPage.VERIFY_CHANGE_NAME_FOR_PERSON3_IS_NOT_REFLECTED_PASS,name);
        String failMessage = String.format(LogPage.VERIFY_CHANGE_NAME_FOR_PERSON3_IS_NOT_REFLECTED_FAIL,name);
        try {
            if(verifyGetText(By.cssSelector(RECIPIENTS_TABLE_ROW2_COLUMN2),name)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void deleteEmail(){
        try {
            clickOption(By.cssSelector(DELETE_DRAFT_EMAIL_BUTTON));
            clickOption(By.cssSelector(DELETE_EMAIL_MODAL_SUBMIT_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.DELETE_EMAIL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.DELETE_EMAIL_FAIL);
        }
    }
    public static void verifyTodayDateManualTestLog(){
        try {
            if(verifyDateFieldWithoutHourByText(By.cssSelector(MANUAL_TEST_LOG))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_TODAY_DATE_MANUAL_TEST_LOG_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_TODAY_DATE_MANUAL_TEST_LOG_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_DATE_FIELD_FAIL);
        }
    }

    public static void verifyManualTestLog(String log){
        String passMessage = String.format(LogPage.VERIFY_MANUAL_TEST_LOG_PASS,log);
        String failMessage = String.format(LogPage.VERIFY_MANUAL_TEST_LOG_FAIL,log);
        try {
            if(verifyGetText(By.cssSelector(MANUAL_TEST_LOG),log)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void deleteMailTrap(String subject){
        String passMessage = String.format(LogPage.DELETE_MAIL_TRAP_PASS,subject);
        String failMessage = String.format(LogPage.DELETE_MAIL_TRAP_FAIL,subject);
        try {
            Dotenv dotenv = Dotenv.load();
            MailTrapApi mailTrapApi = new MailTrapApi(dotenv.get("MAILTRAP_API_TOKEN"),dotenv.get("MAILTRAP_ACCOUNT_ID"),dotenv.get("MAILTRAP_INBOX_ID"));
            MessageEntity[] response = mailTrapApi.searchMessage(subject);
            MessageEntity message = response[0];
            mailTrapApi.deleteMessage(message.id);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void validateHtmlAndTextOnMailTrap(String condition, String subject, String html,String text){
        String passMessage = String.format(LogPage.VALIDATE_HTML_AND_TEXT_ON_MAIL_TRAP_PASS,condition,html,text);
        String failMessage = String.format(LogPage.VALIDATE_HTML_AND_TEXT_ON_MAIL_TRAP_FAIL,condition,html,text);
        try {
            Dotenv dotenv = Dotenv.load();
            MailTrapApi mailTrapApi = new MailTrapApi(dotenv.get("MAILTRAP_API_TOKEN"),dotenv.get("MAILTRAP_ACCOUNT_ID"),dotenv.get("MAILTRAP_INBOX_ID"));
            MessageEntity[] response = mailTrapApi.searchMessage(subject);
            MessageEntity message = response[0];
            switch (condition){
                case "visible":
                    if(verify2StringContains(mailTrapApi.getHtmlBody(message.id),html)
                            && verify2StringContains(mailTrapApi.getTextBody(message.id),text) ){
                            ExtentReportsSetUp.testingPass(passMessage);
                    }else{
                        FailureDelegatePage.handlePageException(failMessage);
                    }
                    break;
                /*
                 * for 'not visible' put something on the parameter that should be empty like
                 * And I verify email content on mail trap is "not visible" for subject "Subject Marketing Footer test 6010", "not validation necessary", "United States"
                 * in the case above for exemple and did not have to validate html then I put 'not validation necessary' phrase
                 */
                case "not visible":
                    if(!verify2StringContains(mailTrapApi.getHtmlBody(message.id),html)
                            && !verify2StringContains(mailTrapApi.getTextBody(message.id),text) ){
                            ExtentReportsSetUp.testingPass(passMessage);
                    }else{
                            FailureDelegatePage.handlePageException(failMessage);
                    }
                    break;
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void validateEmailOnMailTrap(String subject,String fromEmail,String fromName,String toName){
        String passMessage = String.format(LogPage.VALIDATE_EMAIL_ON_MAIL_TRAP_PASS);
        String failMessage = String.format(LogPage.VALIDATE_EMAIL_ON_MAIL_TRAP_FAIL);
        try {
            wait(2000);
            //instaciate dotenv to get variables from .env file and set here
            Dotenv dotenv = Dotenv.load();
            //Instanciating MailTrap Api
            wait(2000);
            MailTrapApi mailTrapApi = new MailTrapApi(dotenv.get("MAILTRAP_API_TOKEN"),dotenv.get("MAILTRAP_ACCOUNT_ID"),dotenv.get("MAILTRAP_INBOX_ID"));
            //search message list by subject on mailtrap
            wait(2000);
            MessageEntity[] response = mailTrapApi.searchMessage(subject);
            //get the first message from the list
            wait(2000);
            MessageEntity message = response[0];

            if(verify2StringEquals(subject,message.subject)
                && verify2StringEquals(fromEmail,message.from_email)
                && verify2StringEquals(fromName,message.from_name)
                && verify2StringContains(toName,message.to_name)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
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
