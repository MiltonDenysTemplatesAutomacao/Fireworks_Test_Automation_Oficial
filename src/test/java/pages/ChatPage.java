package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class ChatPage extends BasePage{
    public static final String SETTINGS_TAB = "#chatSettingsTab";
    private static final String EMAIL_CONTACT_FIELD = "#contactEmail";
    private static final String ACTIVE_IMAGE_DROPZONE = "#active-image-dz-mediaSourceFileButton";
    private static final String INACTIVE_IMAGE_DROPZONE = "#inactive-image-dz-mediaSourceFileButton";
    private static final String HEADER_IMAGE_DROPZONE = "#header-image-dz-mediaSourceFileButton";
    private static final String ACTIVE_ERROR_MESSAGE = "#active-image-dz-error";
    private static final String INACTIVE_ERROR_MESSAGE = "#inactive-image-dz-error";
    private static final String ENABLE_CHAT_CHECKBOX = "#is_live";

    private static String imageThumbnail(String thumbnail,String filename){
        return String.format("//div[@id = '%s_thumbnail']/img[@title = '%s']",thumbnail,filename);
    }

    public static void setChatActive(){
        try {
            clickCheckbox(By.cssSelector(ENABLE_CHAT_CHECKBOX));
            ExtentReportsSetUp.testingPass(LogPage.SET_CHAT_ACTIVE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SET_CHAT_ACTIVE_FAIL);
        }
    }
    /*
     * if status is 0 validate if checkbox is not checked if it is 1 validate id checkbox is active
     */
    public static void verifyChatCheckbox(String status){
        try {
            if(verifyCheckboxActiveOrNot(By.cssSelector(ENABLE_CHAT_CHECKBOX),status)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_CHAT_CHECKBOX_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_CHAT_CHECKBOX_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_CHAT_CHECKBOX_FAIL);
        }
    }
    public static String returnErrorMessageElement (String thumbnail){
        Map<String, String> returnElement = new HashMap<String, String>();
        returnElement.put("active", ACTIVE_ERROR_MESSAGE);
        returnElement.put("inactive", INACTIVE_ERROR_MESSAGE);
        return returnElement.get(thumbnail);
    }

    public static void validateErrorMessage(String thumbnail, String errorMessage){
        String passMessage = String.format(LogPage.VALIDATE_ERROR_MESSAGE_PASS,thumbnail,errorMessage);
        String failMessage = String.format(LogPage.VALIDATE_ERROR_MESSAGE_FAIL,thumbnail,errorMessage);
        try {
            if(verifyGetText(By.cssSelector(returnErrorMessageElement(thumbnail)),errorMessage)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static String returnUpdateButtonPath (String thumbnail){
        Map<String, String> returnElement = new HashMap<String, String>();
        returnElement.put("active", ACTIVE_IMAGE_DROPZONE);
        returnElement.put("inactive", INACTIVE_IMAGE_DROPZONE);
        returnElement.put("header", HEADER_IMAGE_DROPZONE);
        return returnElement.get(thumbnail);
    }
    public static void uploadFile(String file,String thumbnail){
        String passMessage = String.format(LogPage.UPLOAD_FILE_PASS,file,thumbnail);
        String failMessage = String.format(LogPage.UPLOAD_FILE_FAIL,file,thumbnail);
        try {
            attachFile(file,By.cssSelector(returnUpdateButtonPath(thumbnail)));
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
        if(verifyIfElementIsVisible(By.xpath(thumbnailLocator))){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{

                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyEmailContact(String emailContact){
        String passMessage = String.format(LogPage.UPDATE_EMAIL_CONTACT_PASS,emailContact);
        String failMessage = String.format(LogPage.UPDATE_EMAIL_CONTACT_FAIL,emailContact);
        try {
            if(verifyGetAttribute(By.cssSelector(EMAIL_CONTACT_FIELD),emailContact)){
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
