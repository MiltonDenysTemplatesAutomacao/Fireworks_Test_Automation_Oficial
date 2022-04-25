package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TasksPage extends BasePage{

    public static final String CREATE_TASK_BUTTON = "#top-controls-create-new-task";
    public static final String TASK_NAME_FIELD = "task_name";
    public static final String TASK_DESCRIPTION_FIELD = "task_description";
    public static final String TASK_TYPE_DROPDOWN = "#task_category_id_component";
    public static final String TASK_TYPE_DROPDOWN_LIST = "#task_category_id_dropdown_menu";
    public static final String TASK_TYPE_DISABLED_DROPDOWN = "//*[@id='task_category_id_component']";
    public static final String SMART_SEARCH_ELEMENT = "#savedSearchPickerReadable";
    public static final String SMART_SEARCH_PICKER_BUTTON = "savedSearchPickerTrigger";
    public static final String SMART_SEARCH_PICKER_MODAL_SEARCH_FIELD = "savedSearchPickerModalTableControlsTableSearch";
    public static final String SMART_SEARCH_PICKER_MODAL_TABLE_ROW1_COL1 = "#savedSearchPickerModalTable_row_0_col_1";
    public static final String SMART_SEARCH_PICKER_MODAL_ROW1_CHECKBOX = "#savedSearchPickerModalTable_row_0_col_0";
    public static final String SMART_SEARCH_PICKER_MODAL_CHOOSE_BUTTON = "modalSubmitButtonsavedSearchPicker";
    public static final String ASSIGN_TO_DROPDOWN = "#task_assign_to_component";
    public static final String ASSIGN_TO_DROPDOWN_LIST = "#task_assign_to_dropdown_menu";
    public static final String DUE_DATE_FIELD = "task_due_date";
    public static final String DUE_TIME_FIELD = "task_due_time_display";
    public static final String PRIORITY_DROPDOWN = "div#task_priority_component";
    public static final String PRIORITY_DROPDOWN_LIST = "#task_priority_dropdown_menu";
    public static final String STATUS_DROPDOWN = "#task_status_component";
    public static final String STATUS_DROPDOWN_LIST = "#task_status_dropdown_menu";
    public static final String COMMENTS_FIELD = "task_comments";
    public static final String TASK_SAVE_CHANGES_BUTTON = "taskSaveButton";
    public static final String TASK_MANAGER_SEARCH_FIELD = "#taskManagerTableControlsTableSearch";
    public static final String TASK_MANAGER_TABLE_ROW1 = "#taskManagerTable_row_0";
    public static final String TASK_MANAGER_TABLE_ROW1_COL0 = "#taskManagerTable_row_0_col_0";
    public static final String CLEAR_CHANGES_BUTTON = "clearChangesButton";
    public static final String MODAL_CLEAR_CHANGES_CONFIRMATION_BUTTON = "modalSubmitButtonclearChangesConfirmation";
    public static final String DUE_TIME_DISABLED_FIELD = "#task_due_time_display[disabled]";
    public static final String DELETE_TASK_BUTTON = "deleteTaskButton";
    public static final String TASK_DELETE_MODAL_YES_DELETE_BUTTON = "modalSubmitButtondeleteTask";
    public static final String TASK_DELETE_MODAL_CANCEL_BUTTON = "modalCancelButtondeleteTask";
    public static final String TASK_DELETE_MODAL_LABEL = "deleteTaskModalLabel";
    public static final String ARCHIVE_TASK_BUTTON = "taskArchiveButton";
    public static final String ACTIVATE_TASK_BUTTON = "taskActivateButton";
    public static final String CLEAR_CHANGES_DISABLED_BUTTON = "#clearChangesButton[disabled]";
    public static final String TASK_SAVE_CHANGES_DISABLED_BUTTON = "#taskSaveButton[disabled]";
    public static final String TASK_NAME_DISABLED_FIELD = "#task_name[disabled]";
    public static final String TASK_MANAGER_TABLE_FILTER_BUTTON = "div.btn-group.columnFilter";
    public static final String TASK_MANAGER_TABLE_FILTER_BUTTON_YES = ".//*[@href='6038']";
    public static final String TASK_MANAGER_TABLE_FILTER_BUTTON_NO = ".//*[@href='6039']";
    public static final String ASSIGN_TO_COLUMN = "//*[@id='taskManagerTable']/thead/tr/th[4]";


    public static void validateAssignedToColumnNotDisplayed(){
        try {
            waitUntilElementToBeSelected(By.xpath(ASSIGN_TO_COLUMN),20);
            if (!checkIfElementIsVisible(By.xpath(ASSIGN_TO_COLUMN))){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_ASSIGNED_TO_COLUMN_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_ASSIGNED_TO_COLUMN_FAIL);
            }
        } catch (Exception e) {
        }
    }


    /*
     * Method to click on Yes button on delete task modal
     */
    public static void validateTaskNotDisplayed(){
        try {
            wait(2000);
            String task = getText(By.cssSelector(TASK_MANAGER_TABLE_ROW1_COL0));
            if(task.equals("No search results to display.")){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_TASK_NOT_DISPLAYED_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_TASK_NOT_DISPLAYED_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_TASK_NOT_DISPLAYED_FAIL);
        }
    }
    /*
     * Method to validate if delete button is not displayed
     */
    public static void validateDeleteButtonNotDisplayed(){
        try {
            waitUntilElementToBeSelected(By.id(TASK_NAME_FIELD),20);
            waitUntilElementToBeSelected(By.id(TASK_SAVE_CHANGES_BUTTON),20);
            if (!checkIfElementIsVisible(By.id(DELETE_TASK_BUTTON))){
                ExtentReportsSetUp.testingPass(LogPage.DELETE_BUTTON_NOT_DISPLAYED_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.DELETE_BUTTON_NOT_DISPLAYED_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.DELETE_BUTTON_NOT_DISPLAYED_FAIL);
        }
    }
    /*
     * Method to validate if activate and archive button is displayed
     */
    public static void validateArchiveAndActivateButtonsNotDisplayed(){
        try {
            waitUntilElementToBeSelected(By.id(TASK_NAME_FIELD),20);
            waitUntilElementToBeSelected(By.id(TASK_SAVE_CHANGES_BUTTON),20);
            if (!checkIfElementIsVisible(By.id(ACTIVATE_TASK_BUTTON))||
                    !checkIfElementIsVisible(By.id(ARCHIVE_TASK_BUTTON))){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_ARCHIVE_AND_ACTIVATE_BUTTON_NOT_DISPLAYED_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_ARCHIVE_AND_ACTIVATE_BUTTON_NOT_DISPLAYED_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_ARCHIVE_AND_ACTIVATE_BUTTON_NOT_DISPLAYED_FAIL);
        }
    }

    /*
     * Method to set a status on archive filter
     */
    public static void clickFilterArchivedStatus(String status){
        try {
            waitUntilElementToBeSelected(By.cssSelector(TASK_MANAGER_TABLE_FILTER_BUTTON),20);
            BasePage.click(By.cssSelector(TASK_MANAGER_TABLE_FILTER_BUTTON));

            switch (status) {
                case "Yes":
                    BasePage.click(By.xpath(TASK_MANAGER_TABLE_FILTER_BUTTON_YES));
                    System.out.println(true);
                    break;
                case "No":
                    BasePage.click(By.xpath(TASK_MANAGER_TABLE_FILTER_BUTTON_NO));
                    System.out.println(false);
                    break;
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.FILTER_ARCHIVED_STATUS_FAIL);
        }
    }

    /*
     * Method to validate if task is not read-only
     */
    public static void validateTaskIsNotReadOnly(){

        try {
            if(checkIfElementIsVisible(By.id(TASK_NAME_FIELD))&&
                    checkIfElementIsVisible(By.cssSelector(TASK_TYPE_DROPDOWN))&&
                    checkIfElementIsVisible(By.id(CLEAR_CHANGES_BUTTON))&&
                    checkIfElementIsVisible(By.id(ARCHIVE_TASK_BUTTON))){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_TASK_IS_NOT_READ_ONLY_PASS);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_TASK_IS_NOT_READ_ONLY_FAIL);
        }
    }
    /*
     * Method to validate if task is read-only
     */
    public static void validateTaskReadOnly(){

        try {
            if(checkIfElementIsVisible(By.xpath(TASK_TYPE_DISABLED_DROPDOWN))&&
            checkIfElementIsVisible(By.cssSelector(CLEAR_CHANGES_DISABLED_BUTTON))&&
            checkIfElementIsVisible(By.cssSelector(TASK_SAVE_CHANGES_DISABLED_BUTTON))&&
            checkIfElementIsVisible(By.id(ACTIVATE_TASK_BUTTON))){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_TASK_READ_ONLY_PASS);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_TASK_READ_ONLY_FAIL);
        }
    }


    /*
     * Method to click on Yes button on delete task modal
     */
    public static void validateDeletedTask(){
        try {
            waitElementBy(By.cssSelector(TASK_MANAGER_TABLE_ROW1_COL0),20);
            String task = getText(By.cssSelector(TASK_MANAGER_TABLE_ROW1_COL0));
            if(task != mass.get(0).get("Name")){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_DELETED_TASK_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_DELETED_TASK_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_DELETED_TASK_FAIL);
        }
    }
    /*
     * Method to click on delete button
     */
    public static void deleteTaskButton(){
        wait(3000);
        try {
            BasePage.click(By.id(DELETE_TASK_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.DELETE_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.DELETE_TASK_FAIL);
        }
    }
    /*
     * Method to click on archive task button
     */
    public static void archiveTaskButton(){
        try {
            waitUntilElementToBeSelected(By.id(ARCHIVE_TASK_BUTTON),20);
            BasePage.click(By.id(ARCHIVE_TASK_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.ARCHIVE_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ARCHIVE_TASK_FAIL);
        }
    } /*
     * Method to click on activate task button
     */
    public static void activateTaskButton(){
        try {
            waitUntilElementToBeSelected(By.id(ACTIVATE_TASK_BUTTON),20);
            BasePage.click(By.id(ACTIVATE_TASK_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.ACTIVATE_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ACTIVATE_TASK_FAIL);
        }
    }
    /*
     * Method to click on Cancel button on delete task modal
     */
    public static void taskDeleteModalCancelDeleteButton(){
        try {
            waitElementBy(By.id(TASK_DELETE_MODAL_LABEL),10);
            BasePage.click(By.id(TASK_DELETE_MODAL_CANCEL_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CANCEL_BUTTON_DELETE_TASK_MODAL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CANCEL_BUTTON_DELETE_TASK_MODAL_FAIL);
        }
    }
    /*
     * Method to click on Yes button on delete task modal
     */
    public static void taskDeleteModalYesDeleteButton(){
        try {
            waitElementBy(By.id(TASK_DELETE_MODAL_YES_DELETE_BUTTON),10);
            BasePage.click(By.id(TASK_DELETE_MODAL_YES_DELETE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.YES_BUTTON_DELETE_TASK_MODAL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.YES_BUTTON_DELETE_TASK_MODAL_FAIL);
        }
    }
    /*
     * Method to erase DueDate field
     */
    public static void eraseDueDateField(){
        try {
            BasePage.write(By.id(DUE_DATE_FIELD), "");
            ExtentReportsSetUp.testingPass(LogPage.ERASE_DUE_DATE_FIELD_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ERASE_DUE_DATE_FIELD_FAIL);
        }
    }
    /*
     * Method to validate if Duo Time is disabled
     */
    public static void validateDuoTimeDisabled(){
        try {
            if(checkIfElementIsVisible(By.cssSelector(DUE_TIME_DISABLED_FIELD))){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_DUO_TIME_DISABLED_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_DUO_TIME_DISABLED_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_DUO_TIME_DISABLED_FAIL);
        }
    }


    /*
     * Method to validate alert message
     */
    public static void validationAlertMessage(String alertMessage) {
        String errorMessage = String.format(LogPage.ALERT_MESSAGE_FAIL,alertMessage);
        String passMessage = String.format(LogPage.ALERT_MESSAGE_PASS,alertMessage);
        try {
            waitElementBy(By.id("pageValidationAlertMessageClose"), 10);
            String fullNameReturn = BasePage.getText(By.id("pageAlertMessages"));
            if (alertMessageContains(By.id("pageAlertMessages"), alertMessage)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            System.err.println(errorMessage);
        }
    }
    /*
     * Method to click on save changes button
     */
    public static void clickTaskSaveChangesButton(){
        try {
            taskSaveChangesButton();
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
    /*
     * Method to validate task data table
     */
    public static void validateTaskDataTable(){
        try {
            waitElementBy(By.cssSelector(TASK_MANAGER_TABLE_ROW1),20);
            String dataTableText = BasePage.getText(By.cssSelector(TASK_MANAGER_TABLE_ROW1));
            if (mass.get(0).get("Name") != null) {
                Assert.assertTrue(dataTableText.contains(mass.get(0).get("Name")));
            }
            if (mass.get(0).get("Status") != null) {
                Assert.assertTrue(dataTableText.contains(mass.get(0).get("Status")));
            }
            if (mass.get(0).get("AssignTo") != null) {
                Assert.assertTrue(dataTableText.contains(mass.get(0).get("AssignTo")));
            }
            if (mass.get(0).get("Type") != null) {
                Assert.assertTrue(dataTableText.contains(mass.get(0).get("Type")));
            }
            if (mass.get(0).get("DueDate") != null) {
                Assert.assertTrue(dataTableText.contains(mass.get(0).get("DueDate")));
            }
            ExtentReportsSetUp.testingPass(LogPage.VALIDATE_MANAGER_DATA_TABLE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_MANAGER_DATA_TABLE_FAIL);
        }
    }
    /*
     * Method to clear changes
     */
    public static void clearChanges(){
        try {
            clickClearChanges();
            affirmClearChanges();
            ExtentReportsSetUp.testingPass(LogPage.CLEAR_CHANGES_PASS);

        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLEAR_CHANGES_FAIL);

        }
    }
    /*
     * Method to click on clear changes button
     */
    public static void clickClearChanges()throws Exception{
        BasePage.scrollToElement(By.id(COMMENTS_FIELD));
        waitElementBy(By.id(CLEAR_CHANGES_BUTTON),20);
        BasePage.click(By.id(CLEAR_CHANGES_BUTTON));
    }
    /*
     * Method to affirm clear changes
     */
    public static void affirmClearChanges()throws Exception{
        waitElementBy(By.id(MODAL_CLEAR_CHANGES_CONFIRMATION_BUTTON),20);
        BasePage.click(By.id(MODAL_CLEAR_CHANGES_CONFIRMATION_BUTTON));
    }
    /*
     * Method to click on choose button on smart search picker modal
     */
    public static void smartSearchPickerModalChooseButton()throws Exception{
            BasePage.click(By.id(SMART_SEARCH_PICKER_MODAL_CHOOSE_BUTTON));
    }
    /*
     * Method to click on create task button
     */
    public static void clickCreateTaskButton(){
        try {
            waitElementBy(By.cssSelector(CREATE_TASK_BUTTON), 10);
            BasePage.click(By.cssSelector(CREATE_TASK_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CREATE_TASK_BUTTON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_TASK_BUTTON_FAIL);
        }
    }
    /*
     * Method to pick a smart search
     */
    public static void pickSmartSearch(String smartSearch){
        try {
            waitElementBy(By.id(SMART_SEARCH_PICKER_BUTTON),20);
            BasePage.click(By.id(SMART_SEARCH_PICKER_BUTTON));
            searchSmartSearchPicker(smartSearch);
            smartSearchPickerModalChooseButton();
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.PICK_SMART_SEARCH_FAIL);
        }

    }
    /*
     * Method to search a smart search and validate if it is corrected with the one searched
     */
    public static void searchSmartSearchPicker (String searchName)throws Exception{
        try {
            waitElementBy(By.id(SMART_SEARCH_PICKER_MODAL_SEARCH_FIELD),20);
            BasePage.write(By.id(SMART_SEARCH_PICKER_MODAL_SEARCH_FIELD), searchName);
            if(verifySmartSearchFound(searchName)){
                waitElementBy(By.cssSelector(SMART_SEARCH_PICKER_MODAL_ROW1_CHECKBOX),20);
                BasePage.click(By.cssSelector(SMART_SEARCH_PICKER_MODAL_ROW1_CHECKBOX));
            }else{
                FailureDelegatePage.handlePageException(LogPage.SEARCH_SMART_SEARCH_PICKER_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SEARCH_SMART_SEARCH_PICKER_FAIL);
        }
    }
    /*
     * Method to validate a smart search
     */
    public static boolean verifySmartSearchFound (String searchName)throws Exception{
        String text = getText(By.cssSelector(SMART_SEARCH_PICKER_MODAL_TABLE_ROW1_COL1));
        return text.equals(searchName);
    }
    /*
     * Method to create task
     */
    public static void createTask(){
        try {
            updateTaskFields();
            taskSaveChangesButton();
            ExtentReportsSetUp.testingPass(LogPage.CREATE_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_TASK_FAIL);
        }
    }
    /*
     * Method to update task
     */
    public static void updateTaskFields(){
        try {
            wait(2000);
            BasePage.scrollToElement(By.id(TASK_NAME_FIELD));
            if (mass.get(0).get("Name") != null) {
                BasePage.write(By.id(TASK_NAME_FIELD), mass.get(0).get("Name"));
            }
            if (mass.get(0).get("Description") != null) {
                BasePage.write(By.id(TASK_DESCRIPTION_FIELD), mass.get(0).get("Description"));
            }
            BasePage.scrollToElement(By.id(TASK_DESCRIPTION_FIELD));
            if (mass.get(0).get("Type") != null) {
                BasePage.click(By.cssSelector(TASK_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(TASK_TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Type"));
            }
            if (mass.get(0).get("SmartSearch") != null) {
                pickSmartSearch(mass.get(0).get("SmartSearch"));
            }
            BasePage.scrollToElement(By.id(SMART_SEARCH_PICKER_BUTTON));

            if (mass.get(0).get("AssignTo") != null) {
                wait(2000);
                waitElementBy(By.cssSelector(ASSIGN_TO_DROPDOWN),20);
                BasePage.click(By.cssSelector(ASSIGN_TO_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(ASSIGN_TO_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("AssignTo"));
            }
            if (mass.get(0).get("DueDate") != null) {
                BasePage.write(By.id(DUE_DATE_FIELD), mass.get(0).get("DueDate"));
            }
            if (mass.get(0).get("DueTime") != null) {
                BasePage.click(By.id(DUE_TIME_FIELD));
                BasePage.write(By.id(DUE_TIME_FIELD), mass.get(0).get("DueTime"));
            }
            if (mass.get(0).get("Priority") != null) {
                BasePage.click(By.cssSelector(PRIORITY_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(PRIORITY_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Priority"));
            }
            if (mass.get(0).get("Status") != null) {
                BasePage.click(By.cssSelector(STATUS_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(STATUS_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Status"));
            }
            if (mass.get(0).get("Comments") != null) {
                BasePage.write(By.id(COMMENTS_FIELD), mass.get(0).get("Comments"));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_FIELDS_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_FIELDS_TASK_FAIL);
        }
    }
    public static int index(int index){
        return index;
    }
    /*
     * Method to update task
     */
    public static void fillTaskFields(DataTable data){
        try {
            mass = data.asMaps(String.class, String.class);

            BasePage.scrollToElement(By.id(TASK_NAME_FIELD));
            if (mass.get(0).get("Name") != null) {
                BasePage.write(By.id(TASK_NAME_FIELD), mass.get(0).get("Name"));
            }
            if (mass.get(0).get("Description") != null) {
                BasePage.write(By.id(TASK_DESCRIPTION_FIELD), mass.get(0).get("Description"));
            }
            BasePage.scrollToElement(By.id(TASK_DESCRIPTION_FIELD));
            if (mass.get(0).get("Type") != null) {
                BasePage.click(By.cssSelector(TASK_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(TASK_TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Type"));
            }
            if (mass.get(0).get("SmartSearch") != null) {
                pickSmartSearch(mass.get(0).get("SmartSearch"));
            }
            BasePage.scrollToElement(By.id(SMART_SEARCH_PICKER_BUTTON));

            if (mass.get(0).get("AssignTo") != null) {
                waitElementBy(By.cssSelector(ASSIGN_TO_DROPDOWN),10);
                BasePage.click(By.cssSelector(ASSIGN_TO_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(ASSIGN_TO_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("AssignTo"));
            }

            if (mass.get(0).get("DueDate") != null) {
                waitUntilElementToBeSelected(By.id(DUE_DATE_FIELD),20);
                BasePage.write(By.id(DUE_DATE_FIELD), mass.get(0).get("DueDate"));
                BasePage.write(By.id(DUE_DATE_FIELD), KeyPage.ENTER);
            }
            if (mass.get(0).get("DueTime") != null) {
                BasePage.click(By.id(DUE_TIME_FIELD));
                BasePage.write(By.id(DUE_TIME_FIELD), mass.get(0).get("DueTime"));
            }
            if (mass.get(0).get("Priority") != null) {
                BasePage.click(By.cssSelector(PRIORITY_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(PRIORITY_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Priority"));
            }
            if (mass.get(0).get("Status") != null) {
                waitUntilElementToBeSelected(By.cssSelector(STATUS_DROPDOWN),20);
                BasePage.click(By.cssSelector(STATUS_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(STATUS_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Status"));
            }
            if (mass.get(0).get("Comments") != null) {
                BasePage.write(By.id(COMMENTS_FIELD), mass.get(0).get("Comments"));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_FIELDS_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_FIELDS_TASK_FAIL);
        }
    }
    /*
     * Method to verify if update is correctly
     */
    public static void verifyTask(){
        try {
            waitElementBy(By.id(TASK_NAME_FIELD),20);
            if (mass.get(0).get("Name") != null) {
               String text = BasePage.getAtribute(By.id(TASK_NAME_FIELD),"value");
               Assert.assertEquals(text,mass.get(0).get("Name"));
            }
            if (mass.get(0).get("Description") != null) {
                String text = BasePage.getAtribute(By.id(TASK_DESCRIPTION_FIELD),"value");
                Assert.assertEquals(text,mass.get(0).get("Description"));
            }
            BasePage.scrollToElement(By.id(TASK_DESCRIPTION_FIELD));
            if (mass.get(0).get("Type") != null) {
                String text = BasePage.getText(By.xpath(TASK_TYPE_DISABLED_DROPDOWN));
                Assert.assertEquals(text,mass.get(0).get("Type"));
            }
            if (mass.get(0).get("SmartSearch") != null) {
                String text = BasePage.getAtribute(By.cssSelector(SMART_SEARCH_ELEMENT),"value");
                Assert.assertEquals(text,mass.get(0).get("SmartSearch"));
            }
            BasePage.scrollToElement(By.id(SMART_SEARCH_PICKER_BUTTON));

            if (mass.get(0).get("AssignTo") != null) {
                String text = BasePage.getText(By.cssSelector(ASSIGN_TO_DROPDOWN));
                Assert.assertEquals(text,mass.get(0).get("AssignTo"));
            }
            if (mass.get(0).get("DueDate") != null) {
                String text = BasePage.getAtribute(By.id(DUE_DATE_FIELD),"value");
                Assert.assertEquals(text,mass.get(0).get("DueDate"));
            }
            if (mass.get(0).get("DueTime") != null) {
                String text = BasePage.getAtribute(By.id(DUE_TIME_FIELD),"value");
                Assert.assertEquals(text,mass.get(0).get("DueTime"));
            }
            if (mass.get(0).get("Priority") != null) {
                String text = BasePage.getText(By.cssSelector(PRIORITY_DROPDOWN));
                Assert.assertEquals(text,mass.get(0).get("Priority"));

            }
            if (mass.get(0).get("Status") != null) {
                String text = BasePage.getText(By.cssSelector(STATUS_DROPDOWN));
                Assert.assertEquals(text,mass.get(0).get("Status"));
            }
            if (mass.get(0).get("Comments") != null) {
                String text = BasePage.getAtribute(By.id(COMMENTS_FIELD),"value");
                Assert.assertEquals(text,mass.get(0).get("Comments"));
            }
            ExtentReportsSetUp.testingPass(LogPage.VERIFY_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_TASK_FAIL);
        }
    }/*
     * Method to verify if update is correctly
     */
    public static void validateClearChanges(){
        try {
            wait(2000);

            if (mass.get(1).get("Name") != null) {
               String text = BasePage.getAtribute(By.id(TASK_NAME_FIELD),"value");
               Assert.assertEquals(text,mass.get(1).get("Name"));
            }
            if (mass.get(1).get("Description") != null) {
                String text = BasePage.getAtribute(By.id(TASK_DESCRIPTION_FIELD),"value");
                Assert.assertEquals(text,mass.get(1).get("Description"));
            }
            BasePage.scrollToElement(By.id(TASK_DESCRIPTION_FIELD));
            if (mass.get(1).get("Type") != null) {
                String text = BasePage.getText(By.xpath(TASK_TYPE_DISABLED_DROPDOWN));
                Assert.assertEquals(text,mass.get(1).get("Type"));
            }
            if (mass.get(1).get("SmartSearch") != null) {
                String text = BasePage.getAtribute(By.cssSelector(SMART_SEARCH_ELEMENT),"value");
                Assert.assertEquals(text,mass.get(1).get("SmartSearch"));
            }
            BasePage.scrollToElement(By.id(SMART_SEARCH_PICKER_BUTTON));

            if (mass.get(1).get("AssignTo") != null) {
                String text = BasePage.getText(By.cssSelector(ASSIGN_TO_DROPDOWN));
                Assert.assertEquals(text,mass.get(1).get("AssignTo"));
            }
            if (mass.get(1).get("DueDate") != null) {
                String text = BasePage.getAtribute(By.id(DUE_DATE_FIELD),"value");
                Assert.assertEquals(text,mass.get(1).get("DueDate"));
            }
            if (mass.get(1).get("DueTime") != null) {
                String text = BasePage.getAtribute(By.id(DUE_TIME_FIELD),"value");
                Assert.assertEquals(text,mass.get(1).get("DueTime"));
            }
            if (mass.get(1).get("Priority") != null) {
                String text = BasePage.getText(By.cssSelector(PRIORITY_DROPDOWN));
                Assert.assertEquals(text,mass.get(1).get("Priority"));

            }
            if (mass.get(1).get("Status") != null) {
                String text = BasePage.getText(By.cssSelector(STATUS_DROPDOWN));
                Assert.assertEquals(text,mass.get(1).get("Status"));
            }
            if (mass.get(1).get("Comments") != null) {
                String text = BasePage.getAtribute(By.id(COMMENTS_FIELD),"value");
                Assert.assertEquals(text,mass.get(1).get("Comments"));
            }
            ExtentReportsSetUp.testingPass(LogPage.VALIDATE_CLEAR_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_CLEAR_CHANGES_FAIL);
        }
    }
    /*
     * Method to click on save changes button
     */
    public static void taskSaveChangesButton(){
        try {
            waitElementBy(By.id(TASK_SAVE_CHANGES_BUTTON),10);
            BasePage.scrollToElement(By.id(COMMENTS_FIELD));
            waitElementBy(By.id(TASK_SAVE_CHANGES_BUTTON),10);
            BasePage.click(By.id(TASK_SAVE_CHANGES_BUTTON));
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
    /*
     * Method to open task
     */
    public static void openTask(String task){
        wait(2000);
        String nameTask = mass.get(0).get(task);
        try {
            searchTaskManager(nameTask);
            verifyTaskFound(nameTask);
            BasePage.click(By.cssSelector(TASK_MANAGER_TABLE_ROW1_COL0));
            ExtentReportsSetUp.testingPass(LogPage.OPEN_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.OPEN_TASK_FAIL);
        }
    }
    /*
     * Method to search a task
     */
    public static void searchTaskManager(String searchedTask){
        wait(2000);
        try {
            if(searchedTask.equals("Name")||searchedTask.equals("AssignTo")){
                String taskManager = mass.get(0).get(searchedTask);
                BasePage.write(By.cssSelector(TASK_MANAGER_SEARCH_FIELD), taskManager);
            }else{
                BasePage.write(By.cssSelector(TASK_MANAGER_SEARCH_FIELD), searchedTask);
            }
            ExtentReportsSetUp.testingPass(LogPage.SEARCH_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SEARCH_TASK_FAIL);
        }
    }
    /*
     * Method to search a task
     */
    public static void searchTaskManagerByString(String searchedTask){
        wait(2000);
        try {
                BasePage.write(By.cssSelector(TASK_MANAGER_SEARCH_FIELD), searchedTask);
                verifyTaskFound(searchedTask);
                ExtentReportsSetUp.testingPass(LogPage.SEARCH_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SEARCH_TASK_FAIL);
        }
    }
    /*
     * Method to search a task
     */
    public static void fillSearchField(String searchedTask){
        wait(2000);
        try {
            BasePage.write(By.cssSelector(TASK_MANAGER_SEARCH_FIELD), searchedTask);
            ExtentReportsSetUp.testingPass(LogPage.SEARCH_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SEARCH_TASK_FAIL);
        }
    }
    /*
     * Method to verify if searched task is correctly
     */
    public static void verifyTaskFound(String name)throws Exception{
        String text = BasePage.getText(By.cssSelector(TASK_MANAGER_TABLE_ROW1));
        Assert.assertTrue(text.contains(name));
    }
    /*
     * Method to verify if searched task is correctly
     */
    public static void verifyTaskIsDisplayed(String name){
        try {
            String text = BasePage.getText(By.cssSelector(TASK_MANAGER_TABLE_ROW1_COL0));
            ExtentReportsSetUp.testingPass(LogPage.VALIDATE_MANAGER_DATA_TABLE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_MANAGER_DATA_TABLE_FAIL);
        }
    }

}
