package steps;

import io.cucumber.java.en.And;
import pages.ReportsPage;

public class ReportSteps {

    @And("I click on create report button")
    public static void clickReportButton() {
        ReportsPage.clickReportButton();
    }
    @And("I click on run report button")
    public static void clickRunReportButton() {
        ReportsPage.clickRunReportButton();
    }

}
