package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class PersonNavPage extends BasePage{

    private static final String RECORD_NAV_TAB_CONTACT = "recordNavTab_contact";
    private static final String STUDENT_STATUS_TAB = "#recordNavTab_status";
    private static final String INTERESTS_ACTIVITIES_TAB = "#recordNavTab_activities_interests";
    private static final String ACTIONS_PANEL_HEADING_ELEMENT = "#recordNavTab_actions";
    private static final String RELATIONSHIPS_TAB = "#recordNavTab_relationships";
    private static final String APPLICATIONS_TAB = "#recordNavTab_applications";
    private static final String FINANCIAL_AID_TAB = "#recordNavTab_financial_affairs";
    private static final String EMPLOYMENT_TAB = "#recordNavTab_employment";

    public static void navigateToEmployment(){
        try {
            scrollToElement(By.cssSelector(EMPLOYMENT_TAB));
            scrollTo("-150");
            waitElementBy(By.cssSelector(EMPLOYMENT_TAB),20);
            BasePage.click(By.cssSelector(EMPLOYMENT_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_EMPLOYMENT_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_EMPLOYMENT_FAIL);
        }
    }

    public static void navigateToFinancialAid(){
        try {
            scrollToElement(By.cssSelector(FINANCIAL_AID_TAB));
            scrollTo("-150");
            waitElementBy(By.cssSelector(FINANCIAL_AID_TAB),20);
            BasePage.click(By.cssSelector(FINANCIAL_AID_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_FINANCIAL_AID_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_FINANCIAL_AID_FAIL);
        }
    }
    public static void navigateToApplications(){
        try {
            scrollToElement(By.cssSelector(APPLICATIONS_TAB));
            scrollTo("-150");
            waitElementBy(By.cssSelector(APPLICATIONS_TAB),20);
            BasePage.click(By.cssSelector(APPLICATIONS_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_APPLICATIONS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_APPLICATIONS_FAIL);
        }
    }
    public static void navigateToRelationships(){
        try {
            scrollToElement(By.cssSelector(RELATIONSHIPS_TAB));
            scrollTo("-150");
            waitElementBy(By.cssSelector(RELATIONSHIPS_TAB),20);
            BasePage.click(By.cssSelector(RELATIONSHIPS_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_RELATIONSHIPS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_RELATIONSHIPS_FAIL);
        }
    }
    public static void navigateToActions(){
        try {
            scrollToTheTop();
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
            scrollToElement(By.id(RECORD_NAV_TAB_CONTACT));
            scrollTo("-100");
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
