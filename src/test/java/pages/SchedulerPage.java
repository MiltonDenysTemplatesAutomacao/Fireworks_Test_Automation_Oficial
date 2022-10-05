package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class SchedulerPage extends BasePage{
    public static final String JOBS_MANAGER_TABLE = "#schedulerJobTable";
    public static final String JOB_NAME_FIELD = "#schedule_name";
    public static final String CREATE_JOB_BUTTON = "#top-controls-create-new-job";
    public static final String CREATE_JOB_BUTTON_LIST = "#top-controls-create-new-job-dropdown-menu";

    public static void createNewJob(String jobType){
        try {
            MainPage.clickOptionList(By.cssSelector(CREATE_JOB_BUTTON),jobType,By.cssSelector(CREATE_JOB_BUTTON_LIST));
            waitElementBy(By.cssSelector(JOB_NAME_FIELD),10);
            ExtentReportsSetUp.testingPass(LogPage.CREATE_NEW_JOB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_NEW_JOB_FAIL);
        }
    }


}
