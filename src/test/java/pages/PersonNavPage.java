package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class PersonNavPage extends BasePage{

    public static final String RECORD_NAV_TAB_ID_TYPES = "recordNavTab_id_types";
    private static final String RECORD_NAV_TAB_CONTACT = "recordNavTab_contact";
    private static final String STUDENT_STATUS_TAB = "#recordNavTab_status";
    private static final String INTERESTS_ACTIVITIES_TAB = "#recordNavTab_activities_interests";
    private static final String ACTIONS_PANEL_HEADING_ELEMENT = "#recordNavTab_actions";
    private static final String RELATIONSHIPS_TAB = "#recordNavTab_relationships";
    private static final String APPLICATIONS_TAB = "#recordNavTab_applications";
    private static final String FINANCIAL_AID_TAB = "#recordNavTab_financial_affairs";
    private static final String EMPLOYMENT_TAB = "#recordNavTab_employment";
    private static final String RECORD_NAV_TAB_BASIC = "recordNavTab_basic";
    private static final String DOCUMENTS_TAB = "#recordNavTab_documents";

    public static void navigateToDocuments(){
        try {
            MainPage.navigateToFeature(By.cssSelector(DOCUMENTS_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_DOCUMENTS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_DOCUMENTS_FAIL);
        }
    }
    public static void navigateToEmployment(){
        try {
            MainPage.navigateToFeature(By.cssSelector(EMPLOYMENT_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_EMPLOYMENT_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_EMPLOYMENT_FAIL);
        }
    }
    public static void navigateToIdTypes(){
        try {
            MainPage.navigateToFeature(By.id(RECORD_NAV_TAB_ID_TYPES));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_ID_TYPES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_ID_TYPES_FAIL);
        }
    }

    public static void navigateToFinancialAid(){
        try {
            MainPage.navigateToFeature(By.cssSelector(FINANCIAL_AID_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_FINANCIAL_AID_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_FINANCIAL_AID_FAIL);
        }
    }
    public static void navigateToBasic(){
        try {
            MainPage.navigateToFeature(By.id(RECORD_NAV_TAB_BASIC));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_BASIC_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_BASIC_FAIL);
        }
    }
    public static void navigateToApplications(){
        try {
            MainPage.navigateToFeature(By.cssSelector(APPLICATIONS_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_APPLICATIONS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_APPLICATIONS_FAIL);
        }
    }
    public static void navigateToRelationships(){
        try {
            MainPage.navigateToFeature(By.cssSelector(RELATIONSHIPS_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_RELATIONSHIPS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_RELATIONSHIPS_FAIL);
        }
    }
    public static void navigateToActions(){
        try {
            MainPage.navigateToFeature(By.cssSelector(ACTIONS_PANEL_HEADING_ELEMENT));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_ACTIONS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_ACTIONS_FAIL);
        }
    }

    public static void navigateToInterestsActivities(){
        try {
            MainPage.navigateToFeature(By.cssSelector(INTERESTS_ACTIVITIES_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_INTERESTS_ACTIVITIES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_INTERESTS_ACTIVITIES_FAIL);
        }
    }

    public static void navigateToContact(){
        try {
            MainPage.navigateToFeature(By.id(RECORD_NAV_TAB_CONTACT));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_CONTACT_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_CONTACT_FAIL);
        }
    }
    public static void navigateToStudentStatus(){
        try {
            MainPage.navigateToFeature(By.cssSelector(STUDENT_STATUS_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_STUDENT_STATUS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_STUDENT_STATUS_FAIL);
        }
    }
}
