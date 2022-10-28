package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MediaPage extends BasePage{

    protected static String storage1 ;
    protected static String storage2 ;

    private static final String CREATE_MEDIA_BUTTON = "#top-controls-create-new-media";
    private static final String FILE_NAME_FIELD = "#fileUploadName";
    private static final String FILE_DESCRIPTION_FIELD = "#fileUploadDescription";
    private static final String FILE_INPUT = "#mediaDropzone-mediaSourceFileButton";
    private static final String MEDIA_MANAGER_SEARCH_FIELD = "#mediaManagerTableControlsTableSearch";
    private static final String MEDIA_MANAGER_TABLE_ROW1_COL1 = "#mediaManagerTable_row_0_col_0";
    private static final String MEDIA_MANAGER_TABLE_ROW1 = "#mediaManagerTable_row_0";
    private static final String FILE_LOCATION_LINK = "//*[@id='fileLocation']";
    private static final String DELETE_MEDIA_BUTTON = "#deleteMediaButton";
    private static final String DELETE_MEDIA_MODAL_YES_DELETE_BUTTON = "#modalSubmitButtondeleteMediaConfirm";
    private static final String STORAGE_USAGE_TEXT = "body > main > section > div:nth-child(1) > div > div:nth-child(1) > div > p > span:nth-child(1)";

    public static void validateStorageValueDifferentFromEachOther(){
        try {
            if(!storage1.equals(storage2)){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_STORAGE_VALUE_DIFFERENT_FROM_EACH_OTHER_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_STORAGE_VALUE_DIFFERENT_FROM_EACH_OTHER_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_STORAGE_VALUE_DIFFERENT_FROM_EACH_OTHER_FAIL);
        }
    }
    public static String returnElements (String elements){
        Map<String, String> returnElement = new HashMap<String, String>();
        returnElement.put("mediaManagerTableRow1", MEDIA_MANAGER_TABLE_ROW1);
        return returnElement.get(elements);
    }

    public static void validateMediaIsVisibleOrNot(String media,String status){
        String passMessage = String.format(LogPage.VALIDATE_MEDIA_IS_VISIBLE_OR_NOT_PASS,media,status);
        String failMessage = String.format(LogPage.VALIDATE_MEDIA_IS_VISIBLE_OR_NOT_FAIL,media,status);
        try {
            switch (status){
                case "visible":
                    if(verifyGetText(By.cssSelector(returnElements("mediaManagerTableRow1")),media)){
                        ExtentReportsSetUp.testingPass(passMessage);
                    }else{
                        FailureDelegatePage.handlePageException(failMessage);
                    }
                    break;
                case "not visible":
                    if(!verifyGetText(By.cssSelector(returnElements("mediaManagerTableRow1")),media)){
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

    public static void deleteMedia(){
        try {
            clickOption(By.cssSelector(DELETE_MEDIA_BUTTON));
            clickOption(By.cssSelector(DELETE_MEDIA_MODAL_YES_DELETE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.DELETE_MEDIA_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.DELETE_MEDIA_FAIL);
        }
    }
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
        try {
            fillField(By.cssSelector(MEDIA_MANAGER_SEARCH_FIELD),media);
            ExtentReportsSetUp.testingPass(passMessage);
            wait(2000);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void storageUsage1(){
        String passMessage = String.format(LogPage.STORAGE_USAGE1_PASS,storage1);
        String failMessage = String.format(LogPage.STORAGE_USAGE1_FAIL,storage1);
        try {
            storage1 = getText(By.cssSelector(STORAGE_USAGE_TEXT));
            passMessage = String.format(LogPage.STORAGE_USAGE1_PASS,storage1);
            failMessage = String.format(LogPage.STORAGE_USAGE1_FAIL,storage1);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void storageUsage2(){
        String passMessage = String.format(LogPage.STORAGE_USAGE2_PASS,storage2);
        String failMessage = String.format(LogPage.STORAGE_USAGE2_FAIL,storage2);
        try {
            storage2 = getText(By.cssSelector(STORAGE_USAGE_TEXT));
            passMessage = String.format(LogPage.STORAGE_USAGE2_PASS,storage2);
            failMessage = String.format(LogPage.STORAGE_USAGE2_FAIL,storage2);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
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
            String timestamp = currentDateTimeWithoutHour();
            if(verifyGetAttribute(By.cssSelector(FILE_NAME_FIELD),mediaName+timestamp)
                    && verifyGetAttribute(By.cssSelector(FILE_DESCRIPTION_FIELD),mediaDescription)
                    && verifyGetAttribute(By.xpath(FILE_LOCATION_LINK),mediaFileSource,"href")){
                    ExtentReportsSetUp.testingPass(LogPage.VERIFY_MEDIA_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_MEDIA_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_MEDIA_FAIL);
        }



    }
    public static void updateMedia(String mediaName,String mediaDescription,String mediaFileSource){
        try {
            String timestamp = currentDateTimeWithoutHour();
            fillField(By.cssSelector(FILE_NAME_FIELD),mediaName+timestamp);
            fillField(By.cssSelector(FILE_DESCRIPTION_FIELD),mediaDescription);
            attachFile(mediaFileSource,By.cssSelector(FILE_INPUT));
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_MEDIA_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_MEDIA_FAIL);
        }
    }
}
