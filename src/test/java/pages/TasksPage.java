package pages;

import config.DriverBase;
import config.extent_reports.ExtentReportsSetUp;
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



    public static void smartSearchPickerModalChooseButton()throws Exception{
            BasePage.click(By.id(smartSearchPickerModalChooseButton));
    }
    public static void clickCreateTaskButton(){
        try {
            wait(2000);
            BasePage.click(By.cssSelector(createTaskButton));
            ExtentReportsSetUp.testingPass(LogPage.CREATE_TASK_BUTTON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_TASK_BUTTON_FAIL);
        }
    }
    public static void pickSmartSearch(String smartSearch){
        wait(2000);
        try {
            BasePage.click(By.id(smartSearchPickerButton));
            searchSmartSearchPicker(smartSearch);
            smartSearchPickerModalChooseButton();
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.PICK_SMART_SEARCH_FAIL);
        }

    }
    public static void searchSmartSearchPicker (String searchName)throws Exception{
        wait(2000);
        try {
            BasePage.write(By.id(smartSearchPickerModalSearchField), searchName);
            if(verifySmartSearchFound(searchName)){
                wait(2000);
                BasePage.click(By.cssSelector(smartSearchPickerModalRow1Checkbox));
            }else{
                FailureDelegatePage.handlePageException(LogPage.SEARCH_SMART_SEARCH_PICKER_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SEARCH_SMART_SEARCH_PICKER_FAIL);
        }
    }

    public static boolean verifySmartSearchFound (String searchName)throws Exception{
        boolean alertMessage = false;
        String text = getText(By.cssSelector(smartSearchPickerModalTableRow1Col1));
        if (text.equals(searchName)) {
            alertMessage = true;
        }
        return alertMessage;
    }

    public static void updateTask(){
        try {

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
            taskSaveChangesButton();
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_TASK_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_TASK_FAIL);
        }
    }
    public static void verifyTask(){
        try {
            wait(2000);
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
    }
    public static void taskSaveChangesButton()throws Exception{
        try {
            BasePage.scrollToElement(By.id(commentsField));
            BasePage.click(By.id(taskSaveChangesButton));
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
    public static void openTask(){
        wait(2000);
        String nameTask = mass.get(0).get("PreviousName");
        try {
            searchTaskManager(nameTask);
            verifyTaskFound(nameTask);
            BasePage.click(By.cssSelector(taskManagerTableRow1Col0));

        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.OPEN_TASK_FAIL);

        }
    }
    public static void searchTaskManager(String name)throws Exception{
        BasePage.write(By.cssSelector(taskManagerSearchField), name);
    }
    public static void verifyTaskFound(String name)throws Exception{
        String text = BasePage.getText(By.cssSelector(taskManagerTableRow1));
        Assert.assertTrue(text.contains(name));
    }




}
