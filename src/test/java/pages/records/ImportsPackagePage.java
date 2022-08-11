package pages.records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.PersonPage;

public class ImportsPackagePage extends BasePage {

    private static final String CREATE_NEW_PACKAGE_BUTTON = "#top-controls-create-new-package";
    private static final String PACKAGE_NAME_FIELD = "#packageName";
    private static final String PACKAGE_DESCRIPTION = "#packageDescription";
    private static final String PACKAGE_RECORD_TYPE_DROPDOWN = "#s2id_packageRecordType";
    private static final String CHOOSE_FILE_BUTTON = "#importSourceFileButton";

    private static String packageSaveContinueButton(String index){
        return String.format("#package%sFormSubmitButton",index);
    }

    public static void clickSaveAndContinuePackage(String tab){

        String passMessage = String.format(LogPage.CLICK_SAVE_AND_CONTINUE_PACKAGE_PASS,tab);
        String failMessage = String.format(LogPage.CLICK_SAVE_AND_CONTINUE_PACKAGE_FAIL,tab);
        try {
            scrollToTheBottom();
            waitUntilElementToBeSelected(By.cssSelector(packageSaveContinueButton(tab)),10);
            click(By.cssSelector(packageSaveContinueButton(tab)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updatePackageStartTab(String name,String description,String sourceFile,String recordType){

        int updatePackageStartTab=10;
        try {
            if(name!=""){
                scrollToElement(By.cssSelector(PACKAGE_NAME_FIELD));
                scrollTo("-150");
                write(By.cssSelector(PACKAGE_NAME_FIELD),name);
            }
            if(description!=""){
                scrollToElement(By.cssSelector(PACKAGE_DESCRIPTION));
                scrollTo("-150");
                write(By.cssSelector(PACKAGE_DESCRIPTION),description);
            }
            if(sourceFile!=""){
                String filePath = getFile(sourceFile);
                scrollToElement(By.cssSelector(CHOOSE_FILE_BUTTON));
                scrollTo("-150");
                click(By.cssSelector(CHOOSE_FILE_BUTTON));
                wait(1000);
                copyToTheClipboard(filePath);
                attachFile();
                wait(1000);
            }
            if(recordType!=""){
                scrollToElement(By.cssSelector(PACKAGE_RECORD_TYPE_DROPDOWN));
                scrollTo("-150");
                click(By.cssSelector(PACKAGE_RECORD_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(recordType);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_PACKAGE_START_TAB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_PACKAGE_START_TAB_FAIL);
        }
    }
    public static void createPackage(){
        try {
            scrollToTheTop();
            waitUntilElementToBeSelected(By.cssSelector(CREATE_NEW_PACKAGE_BUTTON),10);
            click(By.cssSelector(CREATE_NEW_PACKAGE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CREATE_PACKAGE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_PACKAGE_FAIL);
        }
    }


}
