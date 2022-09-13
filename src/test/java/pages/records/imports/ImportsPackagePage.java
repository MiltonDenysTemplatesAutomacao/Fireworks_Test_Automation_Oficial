package pages.records.imports;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.MainPage;
import pages.BasePage;
import pages.LettersPage;
import pages.PersonPage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class ImportsPackagePage extends BasePage {

    private static final String CREATE_NEW_PACKAGE_BUTTON = "#top-controls-create-new-package";
    private static final String PACKAGE_NAME_FIELD = "#packageName";
    private static final String PACKAGE_DESCRIPTION = "#packageDescription";
    private static final String PACKAGE_RECORD_TYPE_DROPDOWN = "#s2id_packageRecordType";
    private static final String CHOOSE_FILE_BUTTON = "#importSourceFileButton";
    private static final String UPDATE_ACTION_CATEGORY = "#s2id_import_composer_action_category_id";
    private static final String UPDATE_ACTION = "#s2id_import_composer_action_id";
    private static final String UPDATE_ACTION_COMMENTS = "#import_composer_action_comments";

    private static String packageSaveContinueButton(String index){
        return String.format("#package%sFormSubmitButton",index);
    }

    public static void updatePackageActions(String category,String action,String comments){
        try {
            if(category!=""){
                MainPage.selectOptionList(By.cssSelector(UPDATE_ACTION_CATEGORY),category,By.id(LettersPage.DROPDOWN_INPUT_FIELD_ELEMENT));
            }
            if(action!=""){
                MainPage.clickOptionList(By.cssSelector(UPDATE_ACTION),action,By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(comments!=""){
                MainPage.fillField(By.cssSelector(UPDATE_ACTION_COMMENTS),comments);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_PACKAGE_ACTIONS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_PACKAGE_ACTIONS_FAIL);
        }
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

        try {
            if(name!=""){
                MainPage.fillField(By.cssSelector(PACKAGE_NAME_FIELD),name);
            }
            if(description!=""){
                MainPage.fillField(By.cssSelector(PACKAGE_DESCRIPTION),description);
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
                MainPage.clickOptionList(By.cssSelector(PACKAGE_RECORD_TYPE_DROPDOWN),recordType,By.cssSelector(PersonPage.SELECT_DROP));
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
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_PACKAGE_FAIL);
        }
    }


}
