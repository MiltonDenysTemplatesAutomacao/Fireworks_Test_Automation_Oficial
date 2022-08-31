package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;

public class AdminPanelPage extends BasePage{

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
            MainPage.clickOptionList(By.cssSelector(HIGH_SCORE_DISPLAY_DROPDOWN),
                    highScore,
                    By.cssSelector(PersonPage.SELECT_DROP),
                    "a");
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
            MainPage.clickOptionList(By.cssSelector(SAT_R2016_HIGH_SCORE_DROPDOWN),
                    satr2016HighScore,
                    By.cssSelector(PersonPage.SELECT_DROP),
                    "a");
            wait(1000);
            click(By.cssSelector(CHANGE_HIGH_SCORE_YES_CHANGE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_SAT_R2016_HIGH_SCORE_PASS);
            wait(5000);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_SAT_R2016_HIGH_SCORE_FAIL);
        }
    }
    public static void updateRequiredSchoolName(String schoolName){
        try {
            MainPage.fillField(By.cssSelector(SCHOOL_NAME), schoolName);
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_REQUIRED_SCHOOL_NAME_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_REQUIRED_SCHOOL_NAME_FAIL);
        }
    }
}
