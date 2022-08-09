package pages.records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;



public class EducationPage extends BasePage {

    private static final String EDUCATION_TAB = "#recordNavTab_education";
    private static final String EDUCATION_SAVE_CHANGES_BUTTON = "#saveChangesBtnPersonEducation";


    public static void navigateToEducation(){
        try {
            scrollToElement(By.cssSelector(EDUCATION_TAB));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.cssSelector(EDUCATION_TAB),20);
            BasePage.click(By.cssSelector(EDUCATION_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_EDUCATION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_EDUCATION_FAIL);
        }
    }
    public static void clickSaveChanges(){
        try {
            scrollToTheBottom();
            wait(1000);
            BasePage.click(By.cssSelector(EDUCATION_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_SAVE_CHANGES_EDUCATION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_SAVE_CHANGES_EDUCATION_FAIL);
        }
    }
}
