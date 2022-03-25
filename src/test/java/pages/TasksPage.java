package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TasksPage extends BasePage{

    public static final String createTaskButton = "#top-controls-create-new-task";
    public static final String taskNameField = "task_name";
    public static final String taskDescriptionField = "task_description";
    public static final String taskTypeDropdown = "#task_category_id_component";
    public static final String taskTypeDropdownList = "#task_category_id_dropdown_menu";
    public static final String taskTypeDisabledDropdown = "//*[@id='task_category_id_component']";
    public static final String smartSearchElement = "#savedSearchPickerReadable";
    public static final String smartSearchPickerButton = "savedSearchPickerTrigger";
    public static final String smartSearchPickerModalSearchField = "savedSearchPickerModalTableControlsTableSearch";
    public static final String smartSearchPickerModalTableRow1Col1 = "#savedSearchPickerModalTable_row_0_col_1";
    public static final String smartSearchPickerModalRow1Checkbox = "#savedSearchPickerModalTable_row_0_col_0";
    public static final String smartSearchPickerModalChooseButton = "modalSubmitButtonsavedSearchPicker";
    public static final String assignToDropdown = "#task_assign_to_component";
    public static final String assignToDropdownList = "#task_assign_to_dropdown_menu";
    public static final String dueDateField = "task_due_date";
    public static final String dueTimeField = "task_due_time_display";
    public static final String priorityDropdown = "div#task_priority_component";
    public static final String priorityDropdownList = "#task_priority_dropdown_menu";
    public static final String statusDropdown = "#task_status_component";
    public static final String statusDropdownList = "#task_status_dropdown_menu";
    public static final String commentsField = "task_comments";
    public static final String taskSaveChangesButton = "taskSaveButton";
    public static final String taskManagerSearchField = "#taskManagerTableControlsTableSearch";
    public static final String taskManagerTableRow1 = "#taskManagerTable_row_0";
    public static final String taskManagerTableRow1Col0 = "#taskManagerTable_row_0_col_0";
    public static final String clearChangesButton = "clearChangesButton";
    public static final String modalClearChangesConfirmationButton = "modalSubmitButtonclearChangesConfirmation";
    public static final String dueTimeDisabledField = "#task_due_time_display[disabled]";
    public static final String deleteTaskButton = "deleteTaskButton";
    public static final String taskDeleteModalYesDeleteButton = "modalSubmitButtondeleteTask";
    public static final String taskDeleteModalCancelButton = "modalCancelButtondeleteTask";
    public static final String taskDeleteModalLabel = "deleteTaskModalLabel";
    public static final String archiveTaskButton = "taskArchiveButton";
    public static final String activateTaskButton = "taskActivateButton";
    public static final String clearChangesDisabledButton = "#clearChangesButton[disabled]";
    public static final String taskSaveChangesDisabledButton = "#taskSaveButton[disabled]";
    public static final String taskNameDisabledField = "#task_name[disabled]";
    public static final String taskManagerTableFilterButton = "div.btn-group.columnFilter";
    public static final String taskManagerTableFilterButtonYes = ".//*[@href='6038']";
    public static final String taskManagerTableFilterButtonNo = ".//*[@href='6039']";

    /*
     * Method to validate if activate and archive button is displayed
     */
    public static void validateArchiveAndActivateButtonsNotDisplayed(){
        try {
            waitUntilElementToBeSelected(By.id(taskNameField),20);
            waitUntilElementToBeSelected(By.id(taskSaveChangesButton),20);
            if (!checkIfElementIsVisible(By.id(activateTaskButton))||
                    !checkIfElementIsVisible(By.id(archiveTaskButton))){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_ARCHIVE_AND_ACTIVATE_BUTTON_NOT_DISPLAYED_PASS);
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
            waitUntilElementToBeSelected(By.cssSelector(taskManagerTableFilterButton),20);
            BasePage.click(By.cssSelector(taskManagerTableFilterButton));

            switch (status) {
                case "Yes":
                    BasePage.click(By.xpath(taskManagerTableFilterButtonYes));
                    System.out.println(true);
                    break;
                case "No":
                    BasePage.click(By.xpath(taskManagerTableFilterButtonNo));
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
            if(checkIfElementIsVisible(By.id(taskNameField))&&
                    checkIfElementIsVisible(By.cssSelector(taskTypeDropdown))&&
                    checkIfElementIsVisible(By.id(clearChangesButton))&&
                    checkIfElementIsVisible(By.id(archiveTaskButton))){
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
            if(checkIfElementIsVisible(By.xpath(taskTypeDisabledDropdown))&&
            checkIfElementIsVisible(By.cssSelector(clearChangesDisabledButton))&&
            checkIfElementIsVisible(By.cssSelector(taskSaveChangesDisabledButton))&&
            checkIfElementIsVisible(By.id(activateTaskButton))){
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
            waitElementBy(By.cssSelector(taskManagerTableRow1Col0),20);
            String task = getText(By.cssSelector(taskManagerTableRow1Col0));
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
            BasePage.click(By.id(deleteTaskButton));
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
            waitUntilElementToBeSelected(By.id(archiveTaskButton),20);
            BasePage.click(By.id(archiveTaskButton));
            ExtentReportsSetUp.testingPass(LogPage.ARCHIVE_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ARCHIVE_TASK_FAIL);
        }
    } /*
     * Method to click on activate task button
     */
    public static void activateTaskButton(){
        try {
            waitUntilElementToBeSelected(By.id(activateTaskButton),20);
            BasePage.click(By.id(activateTaskButton));
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
            waitElementBy(By.id(taskDeleteModalLabel),10);
            BasePage.click(By.id(taskDeleteModalCancelButton));
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
            waitElementBy(By.id(taskDeleteModalYesDeleteButton),10);
            BasePage.click(By.id(taskDeleteModalYesDeleteButton));
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
            BasePage.write(By.id(dueDateField), "");
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
            if(checkIfElementIsVisible(By.cssSelector(dueTimeDisabledField))){
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
            if (alertMessageByIdContains("pageAlertMessages", alertMessage)) {
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
            waitElementBy(By.cssSelector(taskManagerTableRow1),20);
            String dataTableText = BasePage.getText(By.cssSelector(taskManagerTableRow1));
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
        BasePage.scrollToElement(By.id(commentsField));
        waitElementBy(By.id(clearChangesButton),20);
        BasePage.click(By.id(clearChangesButton));
    }
    /*
     * Method to affirm clear changes
     */
    public static void affirmClearChanges()throws Exception{
        waitElementBy(By.id(modalClearChangesConfirmationButton),20);
        BasePage.click(By.id(modalClearChangesConfirmationButton));
    }
    /*
     * Method to click on choose button on smart search picker modal
     */
    public static void smartSearchPickerModalChooseButton()throws Exception{
            BasePage.click(By.id(smartSearchPickerModalChooseButton));
    }
    /*
     * Method to click on create task button
     */
    public static void clickCreateTaskButton(){
        try {
            waitElementBy(By.cssSelector(createTaskButton), 10);
            BasePage.click(By.cssSelector(createTaskButton));
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
            waitElementBy(By.id(smartSearchPickerButton),20);
            BasePage.click(By.id(smartSearchPickerButton));
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
            waitElementBy(By.id(smartSearchPickerModalSearchField),20);
            BasePage.write(By.id(smartSearchPickerModalSearchField), searchName);
            if(verifySmartSearchFound(searchName)){
                waitElementBy(By.cssSelector(smartSearchPickerModalRow1Checkbox),20);
                BasePage.click(By.cssSelector(smartSearchPickerModalRow1Checkbox));
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
        String text = getText(By.cssSelector(smartSearchPickerModalTableRow1Col1));
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
            BasePage.scrollToElement(By.id(taskNameField));
            if (mass.get(0).get("Name") != null) {
                BasePage.write(By.id(taskNameField), mass.get(0).get("Name"));
            }
            if (mass.get(0).get("Description") != null) {
                BasePage.write(By.id(taskDescriptionField), mass.get(0).get("Description"));
            }
            BasePage.scrollToElement(By.id(taskDescriptionField));
            if (mass.get(0).get("Type") != null) {
                BasePage.click(By.cssSelector(taskTypeDropdown));
                BasePage.selectElementsList(taskTypeDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("Type"));
            }
            if (mass.get(0).get("SmartSearch") != null) {
                pickSmartSearch(mass.get(0).get("SmartSearch"));
            }
            BasePage.scrollToElement(By.id(smartSearchPickerButton));

            if (mass.get(0).get("AssignTo") != null) {
                wait(2000);
                waitElementBy(By.cssSelector(assignToDropdown),20);
                BasePage.click(By.cssSelector(assignToDropdown));
                BasePage.selectElementsList(assignToDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("AssignTo"));
            }
            if (mass.get(0).get("DueDate") != null) {
                BasePage.write(By.id(dueDateField), mass.get(0).get("DueDate"));
            }
            if (mass.get(0).get("DueTime") != null) {
                BasePage.click(By.id(dueTimeField));
                BasePage.write(By.id(dueTimeField), mass.get(0).get("DueTime"));
            }
            if (mass.get(0).get("Priority") != null) {
                BasePage.click(By.cssSelector(priorityDropdown));
                BasePage.selectElementsList(priorityDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("Priority"));
            }
            if (mass.get(0).get("Status") != null) {
                BasePage.click(By.cssSelector(statusDropdown));
                BasePage.selectElementsList(statusDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("Status"));
            }
            if (mass.get(0).get("Comments") != null) {
                BasePage.write(By.id(commentsField), mass.get(0).get("Comments"));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_FIELDS_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_FIELDS_TASK_FAIL);
        }
    }
    /*
     * Method to update task
     */
    public static void fillTaskFields(DataTable data){
        try {
            mass = data.asMaps(String.class, String.class);

            BasePage.scrollToElement(By.id(taskNameField));
            if (mass.get(0).get("Name") != null) {
                BasePage.write(By.id(taskNameField), mass.get(0).get("Name"));
            }
            if (mass.get(0).get("Description") != null) {
                BasePage.write(By.id(taskDescriptionField), mass.get(0).get("Description"));
            }
            BasePage.scrollToElement(By.id(taskDescriptionField));
            if (mass.get(0).get("Type") != null) {
                BasePage.click(By.cssSelector(taskTypeDropdown));
                BasePage.selectElementsList(taskTypeDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("Type"));
            }
            if (mass.get(0).get("SmartSearch") != null) {
                pickSmartSearch(mass.get(0).get("SmartSearch"));
            }
            BasePage.scrollToElement(By.id(smartSearchPickerButton));

            if (mass.get(0).get("AssignTo") != null) {
                waitElementBy(By.cssSelector(assignToDropdown),10);
                BasePage.click(By.cssSelector(assignToDropdown));
                BasePage.selectElementsList(assignToDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("AssignTo"));
            }
            if (mass.get(0).get("DueDate") != null) {
                BasePage.write(By.id(dueDateField), mass.get(0).get("DueDate"));
            }
            if (mass.get(0).get("DueTime") != null) {
                BasePage.click(By.id(dueTimeField));
                BasePage.write(By.id(dueTimeField), mass.get(0).get("DueTime"));
            }
            if (mass.get(0).get("Priority") != null) {
                BasePage.click(By.cssSelector(priorityDropdown));
                BasePage.selectElementsList(priorityDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("Priority"));
            }
            if (mass.get(0).get("Status") != null) {
                BasePage.click(By.cssSelector(statusDropdown));
                BasePage.selectElementsList(statusDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("Status"));
            }
            if (mass.get(0).get("Comments") != null) {
                BasePage.write(By.id(commentsField), mass.get(0).get("Comments"));
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
            waitElementBy(By.id(taskNameField),20);
            if (mass.get(0).get("Name") != null) {
               String text = BasePage.getAtribute(By.id(taskNameField),"value");
               Assert.assertEquals(text,mass.get(0).get("Name"));
            }
            if (mass.get(0).get("Description") != null) {
                String text = BasePage.getAtribute(By.id(taskDescriptionField),"value");
                Assert.assertEquals(text,mass.get(0).get("Description"));
            }
            BasePage.scrollToElement(By.id(taskDescriptionField));
            if (mass.get(0).get("Type") != null) {
                String text = BasePage.getText(By.xpath(taskTypeDisabledDropdown));
                Assert.assertEquals(text,mass.get(0).get("Type"));
            }
            if (mass.get(0).get("SmartSearch") != null) {
                String text = BasePage.getAtribute(By.cssSelector(smartSearchElement),"value");
                Assert.assertEquals(text,mass.get(0).get("SmartSearch"));
            }
            BasePage.scrollToElement(By.id(smartSearchPickerButton));

            if (mass.get(0).get("AssignTo") != null) {
                String text = BasePage.getText(By.cssSelector(assignToDropdown));
                Assert.assertEquals(text,mass.get(0).get("AssignTo"));
            }
            if (mass.get(0).get("DueDate") != null) {
                String text = BasePage.getAtribute(By.id(dueDateField),"value");
                Assert.assertEquals(text,mass.get(0).get("DueDate"));
            }
            if (mass.get(0).get("DueTime") != null) {
                String text = BasePage.getAtribute(By.id(dueTimeField),"value");
                Assert.assertEquals(text,mass.get(0).get("DueTime"));
            }
            if (mass.get(0).get("Priority") != null) {
                String text = BasePage.getText(By.cssSelector(priorityDropdown));
                Assert.assertEquals(text,mass.get(0).get("Priority"));

            }
            if (mass.get(0).get("Status") != null) {
                String text = BasePage.getText(By.cssSelector(statusDropdown));
                Assert.assertEquals(text,mass.get(0).get("Status"));
            }
            if (mass.get(0).get("Comments") != null) {
                String text = BasePage.getAtribute(By.id(commentsField),"value");
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
               String text = BasePage.getAtribute(By.id(taskNameField),"value");
               Assert.assertEquals(text,mass.get(1).get("Name"));
            }
            if (mass.get(1).get("Description") != null) {
                String text = BasePage.getAtribute(By.id(taskDescriptionField),"value");
                Assert.assertEquals(text,mass.get(1).get("Description"));
            }
            BasePage.scrollToElement(By.id(taskDescriptionField));
            if (mass.get(1).get("Type") != null) {
                String text = BasePage.getText(By.xpath(taskTypeDisabledDropdown));
                Assert.assertEquals(text,mass.get(1).get("Type"));
            }
            if (mass.get(1).get("SmartSearch") != null) {
                String text = BasePage.getAtribute(By.cssSelector(smartSearchElement),"value");
                Assert.assertEquals(text,mass.get(1).get("SmartSearch"));
            }
            BasePage.scrollToElement(By.id(smartSearchPickerButton));

            if (mass.get(1).get("AssignTo") != null) {
                String text = BasePage.getText(By.cssSelector(assignToDropdown));
                Assert.assertEquals(text,mass.get(1).get("AssignTo"));
            }
            if (mass.get(1).get("DueDate") != null) {
                String text = BasePage.getAtribute(By.id(dueDateField),"value");
                Assert.assertEquals(text,mass.get(1).get("DueDate"));
            }
            if (mass.get(1).get("DueTime") != null) {
                String text = BasePage.getAtribute(By.id(dueTimeField),"value");
                Assert.assertEquals(text,mass.get(1).get("DueTime"));
            }
            if (mass.get(1).get("Priority") != null) {
                String text = BasePage.getText(By.cssSelector(priorityDropdown));
                Assert.assertEquals(text,mass.get(1).get("Priority"));

            }
            if (mass.get(1).get("Status") != null) {
                String text = BasePage.getText(By.cssSelector(statusDropdown));
                Assert.assertEquals(text,mass.get(1).get("Status"));
            }
            if (mass.get(1).get("Comments") != null) {
                String text = BasePage.getAtribute(By.id(commentsField),"value");
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
            waitElementBy(By.id(taskSaveChangesButton),10);
            BasePage.scrollToElement(By.id(commentsField));
            waitElementBy(By.id(taskSaveChangesButton),10);
            BasePage.click(By.id(taskSaveChangesButton));
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
            BasePage.click(By.cssSelector(taskManagerTableRow1Col0));
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
                BasePage.write(By.cssSelector(taskManagerSearchField), taskManager);
            }else{
                BasePage.write(By.cssSelector(taskManagerSearchField), searchedTask);
            }
            ExtentReportsSetUp.testingPass(LogPage.SEARCH_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SEARCH_TASK_FAIL);
        }
    }
    /*
     * Method to verify if searched task is correctly
     */
    public static void verifyTaskFound(String name)throws Exception{
        String text = BasePage.getText(By.cssSelector(taskManagerTableRow1));
        Assert.assertTrue(text.contains(name));
    }
}
