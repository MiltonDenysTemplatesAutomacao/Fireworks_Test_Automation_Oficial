package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class PersonNavPage extends BasePage{

    private static final String RECORD_NAV_TAB_CONTACT = "recordNavTab_contact";
    private static final String STUDENT_STATUS_TAB = "#recordNavTab_status";
    private static final String INTERESTS_ACTIVITIES_TAB = "#recordNavTab_activities_interests";
    private static final String ACTIONS_PANEL_HEADING_ELEMENT = "#recordNavTab_actions";

    public static void navigateToActions(){
        try {
            waitElementBy(By.cssSelector(ACTIONS_PANEL_HEADING_ELEMENT),20);
            BasePage.click(By.cssSelector(ACTIONS_PANEL_HEADING_ELEMENT));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_ACTIONS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_ACTIONS_FAIL);
        }
    }

    public static void navigateToInterestsActivities(){
        try {
            scrollToElement(By.id(RECORD_NAV_TAB_CONTACT));
            waitElementBy(By.cssSelector(INTERESTS_ACTIVITIES_TAB),20);
            BasePage.click(By.cssSelector(INTERESTS_ACTIVITIES_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_INTERESTS_ACTIVITIES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_INTERESTS_ACTIVITIES_FAIL);
        }
    }

    public static void navigateToContact(){
        try {
            waitElementBy(By.id(RECORD_NAV_TAB_CONTACT),20);
            BasePage.click(By.id(RECORD_NAV_TAB_CONTACT));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_CONTACT_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_CONTACT_FAIL);
        }
    }
    public static void navigateToStudentStatus(){
        try {
            wait(500);
            scrollToElement(By.id(RECORD_NAV_TAB_CONTACT));
            waitElementBy(By.cssSelector(STUDENT_STATUS_TAB),20);
            BasePage.click(By.cssSelector(STUDENT_STATUS_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_STUDENT_STATUS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_STUDENT_STATUS_FAIL);
        }
    }
}
