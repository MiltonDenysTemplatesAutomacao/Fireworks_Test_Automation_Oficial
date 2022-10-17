package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class ReportsPage extends BasePage{
    public static final String REPORTS_MANAGER_TABLE = "#reportManagerTable";
    public static final String CREATE_REPORT_BUTTON = "#top-controls-create-new-report";
    public static final String RUN_REPORT_BUTTON = "#reportCreateRunReportButton";

    public static void clickReportButton(){
        try {
            clickOption(By.cssSelector(CREATE_REPORT_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_REPORT_BUTTON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_REPORT_BUTTON_FAIL);
        }
    }
    public static void clickRunReportButton(){
        try {
            clickOption(By.cssSelector(RUN_REPORT_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_RUN_REPORT_BUTTON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_RUN_REPORT_BUTTON_FAIL);
        }
    }


}
