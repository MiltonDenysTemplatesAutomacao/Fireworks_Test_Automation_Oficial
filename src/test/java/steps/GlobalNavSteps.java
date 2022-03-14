package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pages.GlobalNavPage;

public class GlobalNavSteps {

    @And("I navigate to tasks")
    public static void navigateToTask() {
        GlobalNavPage.navigateToTasks();
    }
}
