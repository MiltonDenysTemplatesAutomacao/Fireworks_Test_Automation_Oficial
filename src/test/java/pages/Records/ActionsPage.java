package pages.Records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class ActionsPage extends BasePage {

    public static final String ADD_ACTION_BUTTON = "top-controls-create-new-action";
    public static final String ACTION_CATEGORY_DROPDOWN = "s2id_action_category_id";
    public static final String ACTION_DROPDOWN = "s2id_action_id";
    public static final String ACTION_STAFF_DROPDOWN = "s2id_action_staff";
    public static final String ACTION_COMMENTS_FIELD = "action_comments";
    public static final String ACTION_DATE_FIELD = "#action_date";
    public static final String DETAILS_LABEL = ".//*[@data-field-group-label='Details']";
    public static final String ACTION_SAVE_CHANGES_BUTTON = "actionSaveChangesButton";
    public static final String ACTION_VISIBILITY_DISABLED_DROPDOWN = "s2id_action_visibility_id";
    public static final String ACTION_TYPE_DISABLED_DROPDOWN = "s2id_action_type_id";
    public static final String ACTIONS_MANAGER_TABLE = "#actionsSummaryTable";
    public static final String ACTIONS_MANAGER_TABLE_ROW1_EDIT_LINK = "actionsSummaryTable_row_0_col_0_link_0";
    public static final String CREATE_ACTION_PANEL_TITLE = "div#actions span.panel-title.responsive-pull-left";
    public static final String ACTIONS_MANAGER_SEARCH_FIELD = "actionsSummaryTableControlsTableSearch";


    public static void verifyDefaultActionValues(String index){
        try {
            if(verifyActionDateField()
                && verifyActionAttributes(index)
                && verifyActionDetails(index)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_DEFAULT_ACTION_VALUES_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_DEFAULT_ACTION_VALUES_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_DEFAULT_ACTION_VALUES_FAIL);
        }
    }
    public static boolean verifyActionDateField()throws Exception{
        String currentDateTime = currentDateTime();
        String actionDateTimeText = getAtribute(By.cssSelector(ACTION_DATE_FIELD),"value");
        return actionDateTimeText.equals(currentDateTime);
    }

    public static void verifyActionValues(String index){
        try {
            if(verifyActionAttributes(index) && verifyActionDetails(index)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_ACTION_VALUES_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_VALUES_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_VALUES_FAIL);
        }
    }
    public static boolean verifyActionAttributes(String index)throws Exception{
        waitElementBy(By.cssSelector(CREATE_ACTION_PANEL_TITLE),20);
        String staffText = "";
        String actionDateTimeText = "";
        String commentsText = "";
        boolean staffValidation = false;
        boolean actionDateTimeValidation = false;
        boolean commentsValidation = false;

        int indexNumber = Integer.parseInt(index);
        if(mass.get(indexNumber).get("Staff") !=null){
            staffText = getText(By.id(ACTION_STAFF_DROPDOWN));
            staffValidation = staffText.contains(mass.get(indexNumber).get("Staff"));
        }else{
            staffValidation=true;
        }
        if(mass.get(indexNumber).get("ActionDateField") !=null){
            actionDateTimeText = getAtribute(By.cssSelector(ACTION_DATE_FIELD),"value");
            actionDateTimeValidation = actionDateTimeText.contains(mass.get(indexNumber).get("ActionDateField"));
        }else{
            actionDateTimeValidation=true;
        }
        if(mass.get(indexNumber).get("Comments") !=null){
            commentsText = getAtribute(By.id(ACTION_COMMENTS_FIELD),"value");
            commentsValidation = commentsText.contains(mass.get(indexNumber).get("Comments"));
        }else{
            commentsValidation=true;
        }

        if(staffValidation
                && actionDateTimeValidation
                && commentsValidation){
            return true;
        }else{
            return false;
        }
    }

    public static boolean verifyActionDetails(String index)throws Exception{
        waitElementBy(By.cssSelector(CREATE_ACTION_PANEL_TITLE),20);

        String categoryText = "";
        String actionText = "";
        String actionTypeText = "";
        String actionVisibilityText = "";
        boolean categoryValidation = false;
        boolean actionValidation = false;
        boolean actionTypeValidation = false;
        boolean actionVisibilityValidation = false;
        int indexNumber = Integer.parseInt(index);

        if(mass.get(indexNumber).get("Category") !=null){
            categoryText = getText(By.id(ACTION_CATEGORY_DROPDOWN));
            categoryValidation = categoryText.contains(mass.get(indexNumber).get("Category"));
        }else{
            categoryValidation=true;
        }
        if(mass.get(indexNumber).get("Action") !=null){
            actionText = getText(By.id(ACTION_DROPDOWN));
            actionValidation = actionText.contains(mass.get(indexNumber).get("Action"));
        }else{
            actionValidation=true;
        }
        if(mass.get(indexNumber).get("ActionType") !=null){
            actionTypeText = getText(By.id(ACTION_TYPE_DISABLED_DROPDOWN));
            actionTypeValidation = actionTypeText.contains(mass.get(indexNumber).get("ActionType"));
        }else{
            actionTypeValidation=true;
        }
        if(mass.get(indexNumber).get("ActionVisibility") !=null){
            actionVisibilityText = getText(By.id(ACTION_VISIBILITY_DISABLED_DROPDOWN));
            actionVisibilityValidation = actionVisibilityText.contains(mass.get(indexNumber).get("ActionVisibility"));
        }else{
            actionVisibilityValidation=true;
        }
        if(categoryValidation
                && actionValidation
                && actionTypeValidation
                && actionVisibilityValidation){
            return true;
        }else{
            return false;
        }
    }
    public static void openAction(String action){
        try {
            searchAction(action);
            waitUntilElementToBeSelected(By.id(ACTIONS_MANAGER_TABLE_ROW1_EDIT_LINK),20);
            click(By.id(ACTIONS_MANAGER_TABLE_ROW1_EDIT_LINK));
            ExtentReportsSetUp.testingPass(LogPage.OPEN_ACTION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.OPEN_ACTION_FAIL);
        }

    }
    public static void searchAction(String action)throws Exception{
        waitUntilElementToBeSelected(By.id(ACTIONS_MANAGER_SEARCH_FIELD),20);
        write(By.id(ACTIONS_MANAGER_SEARCH_FIELD),action);
    }
    public static void verifyActionDataTableValues(String category,String action,String staff,String actionDate,String comments,String index){
        try {
            int indexNumber = Integer.parseInt(index);
            waitElementBy(By.cssSelector(ACTIONS_MANAGER_TABLE),20);
            String text = getText(By.cssSelector(ACTIONS_MANAGER_TABLE));
            if (text.contains(mass.get(indexNumber).get(category))
                    && text.contains(mass.get(indexNumber).get(action))
                    && text.contains(mass.get(indexNumber).get(staff))
                    && text.contains(mass.get(indexNumber).get(actionDate))
                    && text.contains(mass.get(indexNumber).get(comments))
            ) {
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_ACTION_DATA_TABLE_VALUES_PASS);
            } else {
                FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_DATA_TABLE_VALUES_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_DATA_TABLE_VALUES_FAIL);
        }
    }
    public static void updateAction(String person){
        int personNumber = Integer.parseInt(person.toString());
        try {
            if (mass.get(personNumber).get("Category") != null) {
                scrollToElement(By.xpath(DETAILS_LABEL));
                waitUntilElementToBeSelected(By.id(ACTION_CATEGORY_DROPDOWN), 20);
                BasePage.click(By.id(ACTION_CATEGORY_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(personNumber).get("Category"));
            }
            if (mass.get(personNumber).get("Action") != null) {
                scrollToElement(By.xpath(DETAILS_LABEL));
                waitUntilElementToBeSelected(By.id(ACTION_DROPDOWN), 20);
                BasePage.click(By.id(ACTION_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(personNumber).get("Action"));
            }
            if (mass.get(personNumber).get("Staff") != null) {
                scrollToElement(By.xpath(DETAILS_LABEL));
                waitUntilElementToBeSelected(By.id(ACTION_STAFF_DROPDOWN), 20);
                BasePage.click(By.id(ACTION_STAFF_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(personNumber).get("Staff"));
            }
            if (mass.get(personNumber).get("ActionDateField") != null) {
                scrollToElement(By.xpath(DETAILS_LABEL));
                waitUntilElementToBeSelected(By.cssSelector(ACTION_DATE_FIELD), 20);
                BasePage.write(By.cssSelector(ACTION_DATE_FIELD),mass.get(personNumber).get("ActionDateField"));
            }
            if (mass.get(personNumber).get("Comments") != null) {
                scrollToElement(By.xpath(DETAILS_LABEL));
                waitUntilElementToBeSelected(By.id(ACTION_COMMENTS_FIELD), 20);
                BasePage.write(By.id(ACTION_COMMENTS_FIELD),mass.get(personNumber).get("Comments"));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_ACTION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_ACTION_FAIL);
        }
    }

    public static void clickSaveChangesActions(){
        try {
            wait(2000);
            click(By.id(ACTION_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);

        }
    }
    public static void createAction(){
        try {
            waitUntilElementToBeSelected(By.id(ADD_ACTION_BUTTON),20);
            click(By.id(ADD_ACTION_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CREATE_ACTION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_ACTION_FAIL);

        }
    }
}
