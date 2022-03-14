package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.junit.Assert;
import org.openqa.selenium.By;

public class TasksPage extends BasePage{

    public static String createTaskButton = "#top-controls-create-new-task";
    public static String taskNameField = "task_name";
    public static String taskDescriptionFieldDropDown = "#task_category_id_toggle_label";
    public static String taskDescriptionFieldDropDownList = "#task_category_id_dropdown_menu";
    public static String taskTypeDropdown = "div#task_category_id_component";
    public static String taskTypeDisabledDropdown = "button#task_category_id_toggle.btn-block.btn.btn-default.dropdown-toggle.form-control.disabled.btn-md";

    public static void clickCreateTaskButton(){
        try {
            BasePage.click(By.cssSelector(createTaskButton));
            ExtentReportsSetUp.testingPass(LogPage.CREATE_TASK_BUTTON_PASS);
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail(LogPage.CREATE_TASK_BUTTON_FAIL);
            Assert.assertFalse(true);
            System.err.println(LogPage.CREATE_TASK_BUTTON_FAIL);
        }
    }
    public static void updateTask(){
        try {
            if (mass.get(0).get("Name") != null) {
                BasePage.write(By.cssSelector(taskNameField), mass.get(0).get("Name"));
            }
            if (mass.get(0).get("Description") != null) {
                BasePage.write(By.cssSelector(taskNameField), mass.get(0).get("Description"));
            }
            if (mass.get(0).get("Type") != null) {
                BasePage.click(By.cssSelector(taskDescriptionFieldDropDown));
                BasePage.selectElementsList(taskDescriptionFieldDropDownList, "a");
                clickOnListOfElements(mass.get(0).get("Type"));
            }
            if (mass.get(0).get("SmartSearch") != null) {
                BasePage.write(By.cssSelector(taskNameField), mass.get(0).get("SmartSearch"));
            }
        } catch (Exception e) {
        }
    }

}
