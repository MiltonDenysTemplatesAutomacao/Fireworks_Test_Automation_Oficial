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
}
