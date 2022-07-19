package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class AdminPanelPage extends BasePage{

    public static final String SCHOOL_NAME = "#schoolName";

    public static void updateRequiredSchoolName(String schoolName){
        try {
            waitElementBy(By.cssSelector(SCHOOL_NAME),20);
            write(By.cssSelector(SCHOOL_NAME),schoolName);
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_REQUIRED_SCHOOL_NAME_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_REQUIRED_SCHOOL_NAME_FAIL);
        }
    }
}
