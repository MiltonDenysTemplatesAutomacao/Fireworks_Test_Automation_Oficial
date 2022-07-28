package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class SmartSearchPage extends BasePage{
    public static final String CREATE_SEARCH_BUTTON = "#top-controls-create-new-smart-search";
    public static final String SAVE_SEARCH_BUTTON = "#saveSearchSave";
    public static final String SEARCH_NAME_FIELD = "#savedSearchName";

    private static String groupConditionFieldDropdown(String index){
        return String.format("#s2id_groups_%s_conditions_%s_field_id",index,index);
    }
    private static String operatorDropdown(String index){
        return String.format("#s2id_groups_%s_conditions_%s_operator",index,index);
    }
    private static String groupConditionConditionValueTextField(String index){
        return String.format("#groups_%s_conditions_%s_value1",index,index);
    }

    public static void fillSmartSearchName(String searchName){
        try {
            waitUntilElementToBeSelected(By.cssSelector(SEARCH_NAME_FIELD),20);
            write(By.cssSelector(SEARCH_NAME_FIELD),searchName);
            ExtentReportsSetUp.testingPass(LogPage.FILL_SMART_SEARCH_NAME_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.FILL_SMART_SEARCH_NAME_FAIL);
        }
    }

    public static void clickSaveThisSearch(){
        try {
            scrollToElement(By.cssSelector(SEARCH_NAME_FIELD));
            waitUntilElementToBeSelected(By.cssSelector(SAVE_SEARCH_BUTTON),20);
            click(By.cssSelector(SAVE_SEARCH_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_SAVE_THIS_SEARCH_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_SAVE_THIS_SEARCH_FAIL);

        }
    }
    public static void fillTextConditionValue(String search,String index){
        String passMessage = String.format(LogPage.FILL_TEXT_CONDITION_VALUE_PASS, search, index);
        String failMessage = String.format(LogPage.FILL_TEXT_CONDITION_VALUE_FAIL, search, index);
        try {
            waitElementBy(By.cssSelector(groupConditionConditionValueTextField(index)),20);
            write(By.cssSelector(groupConditionConditionValueTextField(index)),search);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }

    }
    public static void selectOperator(String search,String index){
        String passMessage = String.format(LogPage.SELECT_OPERATOR_PASS, search, index);
        String failMessage = String.format(LogPage.SELECT_OPERATOR_FAIL, search, index);

        try {
            waitElementBy(By.cssSelector(operatorDropdown(index)),20);
            click(By.cssSelector(operatorDropdown(index)));
            BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
            clickOnListOfElements(search);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }

    }
    public static void selectSearchField(String search,String index){
        String passMessage = String.format(LogPage.SELECT_SEARCH_FIELD_PASS, search, index);
        String failMessage = String.format(LogPage.SELECT_SEARCH_FIELD_FAIL, search, index);
        try {
            waitElementBy(By.cssSelector(groupConditionFieldDropdown(index)),20);
            click(By.cssSelector(groupConditionFieldDropdown(index)));
            BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
            clickOnListOfElements(search);
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
