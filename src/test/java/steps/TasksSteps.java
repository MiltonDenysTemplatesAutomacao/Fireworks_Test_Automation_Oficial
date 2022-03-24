package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.TasksPage;
public class TasksSteps {

    @When("I click on create task button")
    public static void clickCreateTaskButton( ) {
        TasksPage.clickCreateTaskButton();
    }
    @When("I click on filter archived status and set {string}")
    public static void clickFilterArchivedStatus( String status) {
        TasksPage.clickFilterArchivedStatus(status);
    }
    @When("I validate if task was deleted correctly")
    public static void validateDeletedTask( ) {
        TasksPage.validateDeletedTask();
    }
    @When("I validate if task is archived sucessfully")
    public static void validateArchivedTask( ) {
        TasksPage.validateDeletedTask();
    }
    @When("I erase Due Date field")
    public static void eraseField() {
        TasksPage.eraseDueDateField();
    }
    @When("I validate if duo time is disabled")
    public static void validateDuoTimeDisabled( ) {
        TasksPage.validateDuoTimeDisabled();
    }
    @When("I click on Save Changes button")
    public static void clickSaveChangesButton( ) {
        TasksPage.clickTaskSaveChangesButton();
    }
    @When("I create a task")
    public static void updateTask( ) {
        TasksPage.createTask();
    }
    @When("I update task fields")
    public static void updateTaskFields( ) {
        TasksPage.updateTaskFields();
    }
    @When("I fill task fields")
    public static void fillTaskFields(DataTable data) {
        TasksPage.fillTaskFields(data);
    }
    @When("I open task {string}")
    public static void openTask(String task) {
        TasksPage.openTask(task);
    }
    @When("I click on delete task button")
    public static void deleteTask( ) {
        TasksPage.deleteTaskButton();
    }
    @When("I click on archive task button")
    public static void archiveTaskButton( ) {
        TasksPage.archiveTaskButton();
    }
    @When("I click on activate task button")
    public static void activateTaskButton( ) {
        TasksPage.activateTaskButton();
    }
    @When("I validate if archive button is displayed and fields are not disabled")
    public static void validateTaskIsNotReadOnly( ) {
        TasksPage.validateTaskIsNotReadOnly();
    }
    @When("I validate if the task is read-only")
    public static void validateTaskReadOnly( ) {
        TasksPage.validateTaskReadOnly();
    }
    @When("I click on cancel button on delete task modal")
    public static void clickCancelTaskButtonDeleteModal( ) {
        TasksPage.taskDeleteModalCancelDeleteButton();
    }
    @When("I click on yes button on delete task modal")
    public static void taskDeleteModalYesDeleteButton( ) {
        TasksPage.taskDeleteModalYesDeleteButton();
    }
    @When("I search a task {string}")
    public static void searchTask(String task) {
        TasksPage.searchTaskManager(task);
    }
    @When("I validate if {string} validation alert message is correct")
    public static void validateAlertMessage(String alertMessage) {
        TasksPage.validationAlertMessage(alertMessage);
    }
    @When("I validate if manager table shows the task created")
    public static void validateTaskDataTable( ) {
        TasksPage.validateTaskDataTable();
    }
    @When("I clear changes")
    public static void clickClearChanges( ) {
        TasksPage.clearChanges();
    }@When("I validate if clear changes worked")
    public static void validateClearChanges( ) {
        TasksPage.validateClearChanges();
    }
    @When("I verify if task was created correctly")
    public static void validateTask( ) {
        TasksPage.verifyTask();
    }
}
