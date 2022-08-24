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
        int updateRunTabActionsDelay = 10;
        try {
            if(category!=""){
                MainPage.selectOptionList(By.cssSelector(UPDATE_ACTION_CATEGORY),category,By.cssSelector(UPDATE_ACTION_CATEGORY_FIELD));
//                scrollToElement(By.cssSelector(UPDATE_ACTION_CATEGORY));
//                scrollTo("-150");
//                waitElementBy(By.cssSelector(UPDATE_ACTION_CATEGORY),updateRunTabActionsDelay);
//                click(By.cssSelector(UPDATE_ACTION_CATEGORY));
//                waitElementBy(By.cssSelector(UPDATE_ACTION_CATEGORY_FIELD),updateRunTabActionsDelay);
//                write(By.cssSelector(UPDATE_ACTION_CATEGORY_FIELD),category);
//                KeyPage.pressKey(By.cssSelector(UPDATE_ACTION_CATEGORY_FIELD),"Enter");
            }
            if(action!=""){
                MainPage.selectOptionList(By.cssSelector(UPDATE_ACTION),action,By.cssSelector(UPDATE_ACTION_FIELD));

//                scrollToElement(By.cssSelector(UPDATE_ACTION));
//                scrollTo("-150");
//                waitElementBy(By.cssSelector(UPDATE_ACTION),updateRunTabActionsDelay);
//                click(By.cssSelector(UPDATE_ACTION));
//                waitElementBy(By.cssSelector(UPDATE_ACTION_FIELD),updateRunTabActionsDelay);
//                write(By.cssSelector(UPDATE_ACTION_FIELD),action);
//                KeyPage.pressKey(By.cssSelector(UPDATE_ACTION_FIELD),"Enter");
            }
            if(staff!=""){
                MainPage.selectOptionList(By.cssSelector(UPDATE_ACTION),action,By.cssSelector(IMPORT_ACTION_STAFF_FIELD));

//                scrollToElement(By.cssSelector(IMPORT_ACTION_STAFF_DROPDOWN),staff,By.cssSelector(IMPORT_ACTION_STAFF_FIELD));
//                scrollTo("-150");
//                waitElementBy(By.cssSelector(IMPORT_ACTION_STAFF_DROPDOWN),updateRunTabActionsDelay);
//                click(By.cssSelector(IMPORT_ACTION_STAFF_DROPDOWN));
//                waitElementBy(By.cssSelector(IMPORT_ACTION_STAFF_FIELD),updateRunTabActionsDelay);
//                write(By.cssSelector(IMPORT_ACTION_STAFF_FIELD),staff);
//                KeyPage.pressKey(By.cssSelector(IMPORT_ACTION_STAFF_FIELD),"Enter");
            }
            if(actionDate!=""){
                MainPage.fillDateField(By.cssSelector(IMPORT_ACTION_DATE_FIELD),actionDate);
//                scrollToElement(By.cssSelector(IMPORT_ACTION_DATE_FIELD));
//                scrollTo("-150");
//                waitElementBy(By.cssSelector(IMPORT_ACTION_DATE_FIELD),updateRunTabActionsDelay);
//                KeyPage.erase(By.cssSelector(IMPORT_ACTION_DATE_FIELD));
//                write(By.cssSelector(IMPORT_ACTION_DATE_FIELD),actionDate);
//                KeyPage.pressKey(By.cssSelector(IMPORT_ACTION_DATE_FIELD),"Enter");
            }
            if(comments!=""){
                MainPage.fillField(By.cssSelector(UPDATE_ACTION_COMMENTS),comments);
//
//                scrollToElement(By.cssSelector(UPDATE_ACTION_COMMENTS));
//                scrollTo("-150");
//                waitElementBy(By.cssSelector(UPDATE_ACTION_COMMENTS),updateRunTabActionsDelay);
//                write(By.cssSelector(UPDATE_ACTION_COMMENTS),comments);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_RUN_TAB_ACTIONS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_RUN_TAB_ACTIONS_FAIL);
        }
    }
}
