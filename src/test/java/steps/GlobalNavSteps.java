package steps;

import io.cucumber.java.en.And;
import pages.GlobalNavPage;

public class GlobalNavSteps {

    @And("I navigate to tasks")
    public static void navigateToTask() {
        GlobalNavPage.navigateToTasks();
    }
    @And("I navigate to tools")
    public static void navigateToTools() {
        GlobalNavPage.navigateToTools();
    }
    @And("I validate if task is not displayed in tools menu")
    public static void validateTaskNotDisplayedToolsMenu() {
        GlobalNavPage.validateTaskInToolMenuIsNotDisplayed();
    }
}
