package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class MediaPage extends BasePage{

    private static final String CREATE_MEDIA_BUTTON = "#top-controls-create-new-media";
    private static final String FILE_NAME_FIELD = "#fileUploadName";
    private static final String FILE_DESCRIPTION_FIELD = "#fileUploadDescription";
    private static final String FILE_INPUT = "#mediaDropzone-mediaSourceFileButton";
    private static final String MEDIA_MANAGER_SEARCH_FIELD = "#mediaManagerTableControlsTableSearch";
    private static final String MEDIA_MANAGER_TABLE_ROW1_COL1 = "#mediaManagerTable_row_0_col_0";
    private static final String FILE_LOCATION_LINK = "#fileLocation";
    private static final String STORAGE_USAGE_TEXT = "body > main > section > div:nth-child(1) > div > div:nth-child(1) > div > p > span:nth-child(1)";

    public static void openMedia(String media){
        String passMessage = String.format(LogPage.OPEN_MEDIA_PASS,media);
        String failMessage = String.format(LogPage.OPEN_MEDIA_FAIL,media);
        try {
            searchMedia(media);
            clickOption(By.cssSelector(MEDIA_MANAGER_TABLE_ROW1_COL1));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void searchMedia(String media){
        String passMessage = String.format(LogPage.SEARCH_MEDIA_PASS,media);
        String failMessage = String.format(LogPage.SEARCH_MEDIA_FAIL,media);
        String timestamp = currentDateTime();
        try {
            fillField(By.cssSelector(MEDIA_MANAGER_SEARCH_FIELD),media);
            wait(2000);
            if(verifyGetText(By.cssSelector(MEDIA_MANAGER_TABLE_ROW1_COL1),media+timestamp)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void storageUsage1(){
        try {
            String storage1 = getText(By.cssSelector(STORAGE_USAGE_TEXT));
            ExtentReportsSetUp.testingPass(LogPage.STORAGE_USAGE1_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.STORAGE_USAGE1_FAIL);
        }
    }

    public static void createMedia(){
        try {
            clickOption(By.cssSelector(CREATE_MEDIA_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CREATE_MEDIA_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_MEDIA_FAIL);
        }
    }
    public static void verifyMedia(String mediaName,String mediaDescription,String mediaFileSource){
        try {
            String timestamp = currentDateTime();
            if(verifyGetAttribute(By.cssSelector(FILE_NAME_FIELD),mediaName+timestamp)
                    && verifyGetAttribute(By.cssSelector(FILE_DESCRIPTION_FIELD),mediaDescription)
                    && verifyGetAttribute(By.cssSelector(FILE_LOCATION_LINK),mediaFileSource)){
                    ExtentReportsSetUp.testingPass(LogPage.UPDATE_MEDIA_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_MEDIA_PASS);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_MEDIA_FAIL);
        }



    }
    public static void updateMedia(String mediaName,String mediaDescription,String mediaFileSource){
        try {
            String timestamp = currentDateTime();
            fillField(By.cssSelector(FILE_NAME_FIELD),mediaName+timestamp);
            fillField(By.cssSelector(FILE_DESCRIPTION_FIELD),mediaDescription);
            attachFile(mediaFileSource,By.cssSelector(FILE_INPUT));
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_MEDIA_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_MEDIA_FAIL);
        }
    }
}
