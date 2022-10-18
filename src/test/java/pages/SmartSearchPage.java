package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class SmartSearchPage extends BasePage{
    public static final String CREATE_SEARCH_BUTTON = "#top-controls-create-new-smart-search";
    public static final String SAVE_SEARCH_BUTTON = "#saveSearchSave";
    public static final String SEARCH_NAME_FIELD = "#savedSearchName";
    public static final String SMART_SEARCH_RESULTS_TABLE = "#searchResultsTable_row_0";
    public static final String SMART_SEARCH_MANAGER_TABLE = "#searchManagerTableControlsTableSearch";
    public static final String SMART_SEARCH_MANAGER_TABLE_ROW_0 = "#searchManagerTable_row_0_col_0";
    public static final String RUN_DROPDOWN_BUTTON = "#runDropdown";
    public static final String RUN_SEARCH_BUTTON = "#searchRun";
    public static final String SMART_SEARCH_MANAGER_TABLE_ROW_0_COL_0 = "#searchResultsTable_row_0_col_0";
    public static final String RESULT_COUNT_TEXT = "#resultCountOuter";

    private static String groupConditionFieldDropdown(String index){
        return String.format("#s2id_groups_%s_conditions_%s_field_id",index,index);
    }
    private static String operatorDropdown(String index){
        return String.format("#s2id_groups_%s_conditions_%s_operator",index,index);
    }
    private static String groupConditionConditionValueTextField(String index){
        return String.format("#groups_%s_conditions_%s_value1",index,index);
    }
    public static void verifyResultCount(String numRecords){
        String passMessage = String.format(LogPage.VERIFY_RESULT_COUNT_PASS,numRecords);
        String failMessage = String.format(LogPage.VERIFY_RESULT_COUNT_FAIL,numRecords);
        try {
            if(MainPage.verifyGetText(By.cssSelector(RESULT_COUNT_TEXT),numRecords)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifySmartSearchResults(String results){
        String passMessage = String.format(LogPage.VERIFY_SMART_SEARCH_RESULTS_PASS,results);
        String failMessage = String.format(LogPage.VERIFY_SMART_SEARCH_RESULTS_FAIL,results);
        try {
            if(MainPage.verifyGetText(By.cssSelector(SMART_SEARCH_MANAGER_TABLE_ROW_0_COL_0),results)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void runSearch(){
        try {
            MainPage.clickOption(By.cssSelector(RUN_DROPDOWN_BUTTON));
            MainPage.clickOption(By.cssSelector(RUN_SEARCH_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.RUN_SEARCH_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.RUN_SEARCH_FAIL);
        }
    }
    public static void openSearch(String search){
        String passMessage = String.format(LogPage.OPEN_SEARCH_PASS,search);
        String failMessage = String.format(LogPage.OPEN_SEARCH_FAIL,search);
        try {
            MainPage.fillField(By.cssSelector(SMART_SEARCH_MANAGER_TABLE), search);
            MainPage.clickOption(By.cssSelector(SMART_SEARCH_MANAGER_TABLE_ROW_0));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifySearchResults(String results){
        String passMessage = String.format(LogPage.VERIFY_SEARCH_RESULTS_PASS,results);
        String failMessage = String.format(LogPage.VERIFY_SEARCH_RESULTS_FAIL,results);
        try {
            if(MainPage.verifyGetText(By.cssSelector(SMART_SEARCH_RESULTS_TABLE),results)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void fillSmartSearchName(String searchName){
        try {
            MainPage.fillField(By.cssSelector(SEARCH_NAME_FIELD), searchName);
            ExtentReportsSetUp.testingPass(LogPage.FILL_SMART_SEARCH_NAME_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.FILL_SMART_SEARCH_NAME_FAIL);
        }
    }

    public static void clickSaveThisSearch(){
        try {
            clickOption(By.cssSelector(SAVE_SEARCH_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_SAVE_THIS_SEARCH_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_SAVE_THIS_SEARCH_FAIL);

        }
    }
    public static void fillTextConditionValue(String search,String index){
        String passMessage = String.format(LogPage.FILL_TEXT_CONDITION_VALUE_PASS, search, index);
        String failMessage = String.format(LogPage.FILL_TEXT_CONDITION_VALUE_FAIL, search, index);
        try {
            MainPage.fillField(By.cssSelector(groupConditionConditionValueTextField(index)),search);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }

    }
    public static void selectOperator(String search,String index){
        String passMessage = String.format(LogPage.SELECT_OPERATOR_PASS, search, index);
        String failMessage = String.format(LogPage.SELECT_OPERATOR_FAIL, search, index);

        try {
            wait(3000);
            MainPage.clickOptionList(By.cssSelector(operatorDropdown(index)),
                    search,
                    By.cssSelector(PersonPage.SELECT_DROP));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }

    }
    public static void selectSearchField(String search,String index){
        String passMessage = String.format(LogPage.SELECT_SEARCH_FIELD_PASS, search, index);
        String failMessage = String.format(LogPage.SELECT_SEARCH_FIELD_FAIL, search, index);
        try {
            MainPage.clickOptionList(By.cssSelector(groupConditionFieldDropdown(index)),
                    search,
                    By.cssSelector(PersonPage.SELECT_DROP));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void createNewSmartSearch(){
        try {
            waitUntilElementToBeSelected(By.cssSelector(CREATE_SEARCH_BUTTON),20);
            click(By.cssSelector(CREATE_SEARCH_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CREATE_NEW_SMART_SEARCH_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_NEW_SMART_SEARCH_FAIL);
        }
    }
}
