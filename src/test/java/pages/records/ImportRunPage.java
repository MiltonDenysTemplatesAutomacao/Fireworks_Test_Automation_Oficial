package pages.records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.*;

public class ImportRunPage extends BasePage {

    private static final String UPDATE_ACTION_CATEGORY = "#s2id_person_import_composer_action_category_id";
    private static final String UPDATE_ACTION = "#s2id_person_import_composer_action_id";
    private static final String IMPORT_ACTION_STAFF_DROPDOWN = "#s2id_person_import_composer_action_staff";
    private static final String UPDATE_ACTION_CATEGORY_FIELD = "#s2id_autogen2_search";
    private static final String UPDATE_ACTION_FIELD = "#s2id_autogen3_search";
    private static final String IMPORT_ACTION_STAFF_FIELD = "#s2id_autogen4_search";
    private static final String IMPORT_ACTION_DATE_FIELD = "#person_import_composer_action_date";
    private static final String UPDATE_ACTION_COMMENTS = "#person_import_composer_action_comments";
    private static final String RUN_IMPORT_BUTTON = "#runSummaryFormSubmitButton";


    public static void runImport(){
        try {
            waitElementBy(By.cssSelector(RUN_IMPORT_BUTTON),20);
            scrollToElement(By.cssSelector(RUN_IMPORT_BUTTON));
            scrollTo("-150");
            BasePage.click(By.cssSelector(RUN_IMPORT_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.RUN_IMPORT_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.RUN_IMPORT_FAIL);
        }
    }

    public static void updateRunTabActions(String category,String action,String staff,String actionDate,String comments){
        try {
            if(category!=""){
                MainPage.selectOptionList(By.cssSelector(UPDATE_ACTION_CATEGORY),category,By.cssSelector(UPDATE_ACTION_CATEGORY_FIELD));
            }
            if(action!=""){
                MainPage.selectOptionList(By.cssSelector(UPDATE_ACTION),action,By.cssSelector(UPDATE_ACTION_FIELD));
            }
            if(staff!=""){
                MainPage.selectOptionList(By.cssSelector(UPDATE_ACTION),action,By.cssSelector(IMPORT_ACTION_STAFF_FIELD));
            }
            if(actionDate!=""){
                MainPage.fillDateField(By.cssSelector(IMPORT_ACTION_DATE_FIELD),actionDate);
            }
            if(comments!=""){
                MainPage.fillField(By.cssSelector(UPDATE_ACTION_COMMENTS),comments);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_RUN_TAB_ACTIONS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_RUN_TAB_ACTIONS_FAIL);
        }
    }
}
