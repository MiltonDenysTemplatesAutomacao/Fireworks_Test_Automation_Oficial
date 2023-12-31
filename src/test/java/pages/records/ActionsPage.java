package pages.records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;
import pages.PersonPage;

import java.util.List;

public class ActionsPage extends BasePage {

    public static final String ADD_ACTION_BUTTON = "top-controls-create-new-action";
    public static final String ACTION_CATEGORY_DROPDOWN = "s2id_action_category_id";
    public static final String ACTION_DROPDOWN = "s2id_action_id";
    public static final String ACTION_STAFF_DROPDOWN = "s2id_action_staff";
    public static final String ACTION_COMMENTS_FIELD = "#action_comments";
    public static final String ACTION_DATE_FIELD = "#action_date";
    public static final String DETAILS_LABEL = ".//*[@data-field-group-label='Details']";
    public static final String ACTION_SAVE_CHANGES_BUTTON = "actionSaveChangesButton";
    public static final String ACTION_VISIBILITY_DISABLED_DROPDOWN = "s2id_action_visibility_id";
    public static final String ACTION_TYPE_DISABLED_DROPDOWN = "s2id_action_type_id";
    public static final String ACTIONS_MANAGER_TABLE = "#actionsSummaryTable";
    public static final String ACTIONS_MANAGER_TABLE_ROW1_EDIT_LINK = "actionsSummaryTable_row_0_col_0_link_0";
    public static final String CREATE_ACTION_PANEL_TITLE = "div#actions span.panel-title.responsive-pull-left";
    public static final String ACTIONS_MANAGER_SEARCH_FIELD = "actionsSummaryTableControlsTableSearch";
    public static final String DELETE_ACTION_BUTTON = "#deleteActionButton";
    public static final String DELETE_ACTION_YES_DELETE_BUTTON = "#modalSubmitButtondeleteConfirm";
    public static final String DELETE_ACTION_DISABLED_BUTTON = "#deleteActionButton[disabled]";
    public static final String DELETE_ACTION_CONFIRM_MODAL_LABEL = "#deleteConfirmModalLabel";
    public static final String DELETE_ACTION_CANCEL_BUTTON = "#modalCancelButtondeleteConfirm";
    public static final String ACTIONS_MANAGER_TABLE_ROW1 = "#actionsSummaryTable_row_0";
    public static final String ACTIONS_MANAGER_TABLE_ROW2 = "#actionsSummaryTable_row_1";
    public static final String SAVE_CHANGES_DISABLED_BUTTON = "#actionSaveChangesButton[disabled]";
    public static final String CHILDREN_LINK = "#child_action_link_62";
    public static final String PARENT_LINK = "#parent_action_link_61";

    public static void verifyLinkText(String text,String type){
        String passMessage = String.format(LogPage.VERIFY_LINK_TEXT_PASS,text);
        String failMessage = String.format(LogPage.VERIFY_LINK_TEXT_FAIL,text);
        wait(1000);
        try {
            switch (type){
                case "Person":
                    if(verifyGetText(By.cssSelector(CHILDREN_LINK),text)){
                        ExtentReportsSetUp.testingPass(passMessage);
                    }else{
                        FailureDelegatePage.handlePageException(failMessage);
                    }
                    break;
                case "Organization":
                    if(verifyGetText(By.cssSelector(PARENT_LINK),text)){
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
    public static void verifyActionManagerTableRow2IsNotDisplayed(){
        try {
            if(!verifyIfElementsIsVisible(By.cssSelector(ACTIONS_MANAGER_TABLE_ROW2))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_ACTION_MANAGER_TABLE_ROW2_IS_NOT_DISPLAYED_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_MANAGER_TABLE_ROW2_IS_NOT_DISPLAYED_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_MANAGER_TABLE_ROW2_IS_NOT_DISPLAYED_FAIL);
        }
    }
    public static void verifyActionManagerTableRow1IsDisplayed(){
        try {
            waitElementBy(By.cssSelector(ACTIONS_MANAGER_TABLE_ROW1),10);
            if(verifyIfElementsIsVisible(By.cssSelector(ACTIONS_MANAGER_TABLE_ROW1))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_ACTION_MANAGER_TABLE_ROW1_IS_DISPLAYED_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_MANAGER_TABLE_ROW1_IS_DISPLAYED_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_MANAGER_TABLE_ROW1_IS_DISPLAYED_FAIL);
        }
    }

    public static void validateDeleteModalIsNotVisible(){
        try {
            wait(2000);
            if(!checkIfElementIsVisible(By.cssSelector(DELETE_ACTION_CONFIRM_MODAL_LABEL))){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_DELETE_MODAL_IS_NOT_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_DELETE_MODAL_IS_NOT_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_DELETE_MODAL_IS_NOT_VISIBLE_FAIL);
        }
    }
    public static void clickCancelButtonOnDeleteModal(){
        try {
            waitUntilElementToBeSelected(By.cssSelector(DELETE_ACTION_CANCEL_BUTTON),20);
            click(By.cssSelector(DELETE_ACTION_CANCEL_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_CANCEL_BUTTON_ON_DELETE_MODAL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_CANCEL_BUTTON_ON_DELETE_MODAL_FAIL);
        }
    }
    public static void validateDeleteModalIsVisible(){
        try {
            waitElementBy(By.cssSelector(DELETE_ACTION_CONFIRM_MODAL_LABEL),20);
            if(checkIfElementIsVisible(By.cssSelector(DELETE_ACTION_CONFIRM_MODAL_LABEL))){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_DELETE_MODAL_IS_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_DELETE_MODAL_IS_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_DELETE_MODAL_IS_VISIBLE_FAIL);
        }
    }
    public static void clickDeleteButton(){
        try {
            waitUntilElementToBeSelected(By.cssSelector(DELETE_ACTION_BUTTON),20);
            click(By.cssSelector(DELETE_ACTION_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_DELETE_BUTTON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_DELETE_BUTTON_FAIL);
        }
    }

    public static void validateDisabledDeleteButtonIsNotVisible(){
        try {
            List<WebElement> element = getElement(By.cssSelector(DELETE_ACTION_DISABLED_BUTTON));
            if(element.size()==0){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_DISABLED_DELETE_BUTTON_IS_NOT_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_DISABLED_DELETE_BUTTON_IS_NOT_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_DISABLED_DELETE_BUTTON_IS_NOT_VISIBLE_FAIL);
        }
    }
    public static void validateDeleteButtonIsVisible(){
        try {
            if(checkIfElementIsVisible(By.cssSelector(DELETE_ACTION_BUTTON))){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_DELETE_BUTTON_IS_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_DELETE_BUTTON_IS_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_DELETE_BUTTON_IS_VISIBLE_FAIL);
        }
    }

    public static void validateActionDeleted(){
        try {
            waitElementBy(By.cssSelector(ACTIONS_MANAGER_TABLE),20);
            String textReturn = getText(By.cssSelector(ACTIONS_MANAGER_TABLE));
            if (textReturn.contains("No table data available.")){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_ACTION_DELETED_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_ACTION_DELETED_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_ACTION_DELETED_FAIL);
        }
    }
    public static void deleteAction(){
        try {
            scrollToTheTop();
            waitUntilElementToBeSelected(By.cssSelector(DELETE_ACTION_BUTTON),20);
            click(By.cssSelector(DELETE_ACTION_BUTTON));
            waitUntilElementToBeSelected(By.cssSelector(DELETE_ACTION_YES_DELETE_BUTTON),20);
            click(By.cssSelector(DELETE_ACTION_YES_DELETE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.DELETE_ACTION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.DELETE_ACTION_FAIL);
        }
    }
    public static void verifyCurrentActionDateField(){
        try {
            if(verifyDateFieldWithoutHourByValue(By.cssSelector(ACTION_DATE_FIELD))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_BASIC_IDENTIFICATION_VALUES_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_DATE_FIELD_PASS);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_DATE_FIELD_FAIL);
        }
    }
    public static void verifyCurrentActionDateFieldOnDataTable(){
        try {
            if(verifyDateFieldWithoutHourByText(By.cssSelector(ACTIONS_MANAGER_TABLE))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_BASIC_IDENTIFICATION_VALUES_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_DATE_FIELD_PASS);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_DATE_FIELD_FAIL);
        }
    }
    public static void verifyDefaultActionValues(String index){
        try {
            if(verifyActionAttributes(index)&& verifyActionDetails(index)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_DEFAULT_ACTION_VALUES_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_DEFAULT_ACTION_VALUES_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_DEFAULT_ACTION_VALUES_FAIL);
        }
    }

    public static boolean verifyActionAttributes(String index) {
        int indexNumber = Integer.parseInt(index);
        boolean validation = false;
        String passMessage = String.format(LogPage.VERIFY_ACTION_ATTRIBUTES_PASS,index);
        String failMessage = String.format(LogPage.VERIFY_ACTION_ATTRIBUTES_FAIL,index);
        try {
            if (MainPage.verifyGetText(By.id(ACTION_STAFF_DROPDOWN), mass.get(indexNumber).get("Staff"))
                    && MainPage.verifyGetAttribute(By.cssSelector(ACTION_DATE_FIELD), mass.get(indexNumber).get("ActionDateTime"))
                    && MainPage.verifyGetAttribute(By.cssSelector(ACTION_COMMENTS_FIELD), mass.get(indexNumber).get("Comments"))) {
                    validation = true;
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                validation = false;
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
        return validation;
    }

    public static boolean verifyActionDetails(String index){
        String passMessage = String.format(LogPage.VERIFY_ACTION_DETAILS_PASS,index);
        String failMessage = String.format(LogPage.VERIFY_ACTION_DETAILS_FAIL,index);
        int indexNumber = Integer.parseInt(index);
        boolean validation = false;

        try {
            if(MainPage.verifyGetText(By.id(ACTION_CATEGORY_DROPDOWN),mass.get(indexNumber).get("Category"))
                && MainPage.verifyGetText(By.id(ACTION_DROPDOWN),mass.get(indexNumber).get("Action"))
                && MainPage.verifyGetText(By.id(ACTION_TYPE_DISABLED_DROPDOWN),mass.get(indexNumber).get("ActionType"))
                && MainPage.verifyGetText(By.id(ACTION_VISIBILITY_DISABLED_DROPDOWN),mass.get(indexNumber).get("ActionVisibility"))){
                validation = true;
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                validation = false;
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
        return validation;
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
    public static void searchAction(String action){
        String passMessage = String.format(LogPage.SEARCH_ACTION_PASS,action);
        String failMessage = String.format(LogPage.SEARCH_ACTION_FAIL,action);
        try {
            waitUntilElementToBeSelected(By.id(ACTIONS_MANAGER_SEARCH_FIELD),20);
            write(By.id(ACTIONS_MANAGER_SEARCH_FIELD),action);
            wait(3000);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    /*
     * for this method if there is any value for index on step the values will come from datatable case there is no value for index
     * the value will come from step
     */
    public static void verifyActionDataTableValues(String index,String category, String action, String staff, String actionDate, String comments){
        try {
            wait(2000);
            int indexNumber = Integer.parseInt(index);
            if(MainPage.verifyGetText(By.cssSelector(ACTIONS_MANAGER_TABLE),mass.get(indexNumber).get("Category"))
                && MainPage.verifyGetText(By.cssSelector(ACTIONS_MANAGER_TABLE),mass.get(indexNumber).get("Action"))
                && MainPage.verifyGetText(By.cssSelector(ACTIONS_MANAGER_TABLE),mass.get(indexNumber).get("Staff"))
                && MainPage.verifyGetText(By.cssSelector(ACTIONS_MANAGER_TABLE),mass.get(indexNumber).get("ActionDate"))
                && MainPage.verifyGetText(By.cssSelector(ACTIONS_MANAGER_TABLE),mass.get(indexNumber).get("Comments"))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_ACTION_DATA_TABLE_VALUES_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_DATA_TABLE_VALUES_FAIL);
            }
            if(MainPage.verifyGetText(By.cssSelector(ACTIONS_MANAGER_TABLE),category)
                    && MainPage.verifyGetText(By.cssSelector(ACTIONS_MANAGER_TABLE),action)
                    && MainPage.verifyGetText(By.cssSelector(ACTIONS_MANAGER_TABLE),staff)
                    && MainPage.verifyGetText(By.cssSelector(ACTIONS_MANAGER_TABLE),actionDate)
                    && MainPage.verifyGetText(By.cssSelector(ACTIONS_MANAGER_TABLE),comments)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_ACTION_DATA_TABLE_VALUES_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_DATA_TABLE_VALUES_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_ACTION_DATA_TABLE_VALUES_FAIL);
        }
    }

    public static void updateAction(String person){
        int personNumber = Integer.parseInt(person);
        String passMessage = String.format(LogPage.UPDATE_ACTION_PASS,person);
        String failMessage = String.format(LogPage.UPDATE_ACTION_FAIL,person);
        try {
            if (mass.get(personNumber).get("Category") != null) {
                MainPage.clickOptionList(By.id(ACTION_CATEGORY_DROPDOWN),
                        mass.get(personNumber).get("Category"),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (mass.get(personNumber).get("Action") != null) {
                MainPage.clickOptionList(By.id(ACTION_DROPDOWN),
                        mass.get(personNumber).get("Action"),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (mass.get(personNumber).get("Staff") != null) {
                MainPage.clickOptionList(By.id(ACTION_STAFF_DROPDOWN),
                        mass.get(personNumber).get("Staff"),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (mass.get(personNumber).get("ActionDateTime") != null) {
                MainPage.fillDateField(By.cssSelector(ACTION_DATE_FIELD),mass.get(personNumber).get("ActionDateTime"));
            }
            if (mass.get(personNumber).get("Comments") != null) {
                MainPage.fillField(By.cssSelector(ACTION_COMMENTS_FIELD),mass.get(personNumber).get("Comments"));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void clickSaveChangesActions(){
        try {
            MainPage.clickOption(By.id(ACTION_SAVE_CHANGES_BUTTON));
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
