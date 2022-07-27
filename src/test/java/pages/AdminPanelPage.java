package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class AdminPanelPage extends BasePage{

    public static final String DROPDOWN_LIST = "#select2-drop";
    public static final String SCHOOL_NAME = "#schoolName";
    private static final String HIGH_SCORE_DISPLAY_DROPDOWN = "#s2id_highScoreDisplay";
    private static final String SAT_R2016_HIGH_SCORE_DROPDOWN = "#s2id_satR2016HighScore";
    private static final String CHANGE_HIGH_SCORE_YES_CHANGE_BUTTON = "#modalSubmitButtonchangeHighScoreConfirm";
    private static final String BASIC_SAVE_CHANGES_BUTTON = "#adminPanelBasicSaveChangesButton";

    public static void saveChangesBasicAdminPanel(){
        try {
            waitUntilElementToBeSelected(By.cssSelector(BASIC_SAVE_CHANGES_BUTTON),20);
            scrollToTheBottom();
            click(By.cssSelector(BASIC_SAVE_CHANGES_BUTTON));
            wait(3000);
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_BASIC_ADMIN_PANEL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_BASIC_ADMIN_PANEL_FAIL);
        }
    }

    public static void updateHighScoreDisplay(String highScore){
        try {
            scrollToElement(By.cssSelector(HIGH_SCORE_DISPLAY_DROPDOWN));
            scrollTo("-150");
            waitElementBy(By.cssSelector(HIGH_SCORE_DISPLAY_DROPDOWN),20);
            click(By.cssSelector(HIGH_SCORE_DISPLAY_DROPDOWN));
            BasePage.selectElementsList(By.cssSelector(DROPDOWN_LIST), "a");
            clickOnListOfElements(highScore);
            waitElementBy(By.cssSelector(CHANGE_HIGH_SCORE_YES_CHANGE_BUTTON),20);
            click(By.cssSelector(CHANGE_HIGH_SCORE_YES_CHANGE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_HIGH_SCORE_DISPLAY_PASS);
            wait(1000);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_HIGH_SCORE_DISPLAY_FAIL);
        }
    }
    public static void updateSATR2016HighScore(String satr2016HighScore){
        try {
            scrollToElement(By.cssSelector(SAT_R2016_HIGH_SCORE_DROPDOWN));
            scrollTo("-150");
            waitElementBy(By.cssSelector(SAT_R2016_HIGH_SCORE_DROPDOWN),20);
            click(By.cssSelector(SAT_R2016_HIGH_SCORE_DROPDOWN));
            BasePage.selectElementsList(By.cssSelector(DROPDOWN_LIST), "a");
            clickOnListOfElements(satr2016HighScore);
            waitElementBy(By.cssSelector(CHANGE_HIGH_SCORE_YES_CHANGE_BUTTON),20);
            click(By.cssSelector(CHANGE_HIGH_SCORE_YES_CHANGE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_SAT_R2016_HIGH_SCORE_PASS);
            wait(5000);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_SAT_R2016_HIGH_SCORE_FAIL);
        }
    }
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
