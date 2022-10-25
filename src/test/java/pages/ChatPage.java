package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class ChatPage extends BasePage{
    public static final String SETTINGS_TAB = "#chatSettingsTab";
    private static final String EMAIL_CONTACT_FIELD = "#contactEmail";
    private static final String ADD_ATTACHMENTS_CHAT_SETTINGS_BUTTON = "#active-image-dz-mediaSourceFileButton";
    private static final String ERROR_MESSAGE = "#active-image-dz-error";

    private static String imageThumbnail(String thumbnail,String filename){
        return String.format("//div[@id = '%s_thumbnail']/img[@title = '%s']",thumbnail,filename);
    }

    public static void validateErrorMessage(String errorMessage){
        String passMessage = String.format(LogPage.VALIDATE_ERROR_MESSAGE_PASS,errorMessage);
        String failMessage = String.format(LogPage.VALIDATE_ERROR_MESSAGE_FAIL,errorMessage);
        try {
            if(verifyGetText(By.cssSelector(ERROR_MESSAGE),errorMessage)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void uploadFile(String file){
        String passMessage = String.format(LogPage.UPLOAD_FILE_PASS,file);
        String failMessage = String.format(LogPage.UPLOAD_FILE_FAIL,file);
        try {
            attachFile(file,By.cssSelector(ADD_ATTACHMENTS_CHAT_SETTINGS_BUTTON));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyImage(String thumbnail,String filename){
        String passMessage = String.format(LogPage.VERIFY_IMAGE_PASS,thumbnail,filename);
        String failMessage = String.format(LogPage.VERIFY_IMAGE_FAIL,thumbnail,filename);
        String thumbnailLocator = imageThumbnail(thumbnail,filename);
        try {
            if(verifyIfElementsIsVisible(By.xpath(thumbnailLocator))){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateEmailContact(String emailContact){
        String passMessage = String.format(LogPage.UPDATE_EMAIL_CONTACT_PASS,emailContact);
        String failMessage = String.format(LogPage.UPDATE_EMAIL_CONTACT_FAIL,emailContact);
        try {
            fillField(By.cssSelector(EMAIL_CONTACT_FIELD),emailContact);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

}
