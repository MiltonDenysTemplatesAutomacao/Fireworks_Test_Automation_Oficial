package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class EmailPage extends BasePage{

    public static final String CREATE_NEW_EMAIL_BUTTON = "#top-controls-create-new-email";
    public static final String EMAIL_TYPE_DIRECT = "top-controls-create-new-email-direct-link";
    public static final String EMAIL_TYPE_MARKETING = "top-controls-create-new-email-marketing-link";
    public static final String EMAIL_TYPE_NON_MARKETING = "top-controls-create-new-email-non-marketing-link";
    public static final String SEND_EMAIL_BUTTON = "#sendEmail";
    public static final String PREVIEW_RECIPIENTS_MODAL_LABEL = "#previewRecipientsModalLabel";
    public static final String PREVIEW_RECIPIENTS_MODAL_OK_BUTTON = "#modalSubmitButtonpreviewRecipients";
    public static final String EMAIL_MANAGER_TABLE = "#emailManagerTable";
    public static final String EMAIL_MANAGER_SEARCH_FIELD = "#emailManagerTableControlsTableSearch";
    public static final String EMAIL_MANAGER_TABLE_ROW1_COLUMN1 = "#emailManagerTable_row_0_col_0";
    public static final String EMAIL_MANAGER_TABLE_ROW1_COLUMN3 = "#emailManagerTable_row_0_col_3";


    public static void verifyEmailFound(String emailName){
        try {
            waitElementBy(By.cssSelector(EMAIL_MANAGER_TABLE),20);
            String emailText= getText(By.cssSelector(EMAIL_MANAGER_TABLE_ROW1_COLUMN1));
            if(emailName.equals(emailText)){
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        } catch (Exception e) {

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
    public static void verifySendEmailConfirmationModal()throws Exception{
        waitElementBy(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_LABEL),20);
        verifyIfEquals(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_LABEL),"Preview Recipients");
    }
    public static void confirmEmailSend(){
        try {
            waitElementBy(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_LABEL),20);
            verifySendEmailConfirmationModal();
            confirmPreviewOK();
            ExtentReportsSetUp.testingPass(LogPage.CONFIRM_EMAIL_SEND_PASS);
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
            }
            ExtentReportsSetUp.testingPass(LogPage.CREATE_NEW_EMAIL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_NEW_EMAIL_FAIL);
        }
    }

}
