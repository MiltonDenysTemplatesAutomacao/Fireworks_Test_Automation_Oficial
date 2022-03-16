package steps;

import io.cucumber.java.en.When;
import pages.GlobalNavPage;
import pages.TasksPage;

public class TasksSteps {

    @When("I click on create task button")
    public static void clickCreateTaskButton( ) {
        TasksPage.clickCreateTaskButton();
    }
    @When("I update task")
    public static void updateTask( ) {
        TasksPage.updateTask();
    }
    @When("I open task")
    public static void openTask( ) {
        TasksPage.openTask();
    }
    @When("I verify if task was created correctly")
    public static void validateTask( ) {
        TasksPage.verifyTask();
    }
}
