package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.Records.ActionsPage;


public class ClearChangesPage extends BasePage{

    public static final String CLEAR_CHANGES_BUTTON = "#clearChangesButton";
    public static final String MODAL_CLEAR_CHANGES_CONFIRMATION_LABEL = "#clearChangesConfirmationModalLabel";
    public static final String MODAL_CLEAR_CHANGES_CONFIRMATION_BUTTON = "#modalSubmitButtonclearChangesConfirmation";

    public static void clearChanges(){
        try {
            scrollToTheBottom();
            waitUntilElementToBeSelected(By.cssSelector(CLEAR_CHANGES_BUTTON),20);
            click(By.cssSelector(CLEAR_CHANGES_BUTTON));
            waitUntilElementToBeSelected(By.cssSelector(MODAL_CLEAR_CHANGES_CONFIRMATION_LABEL),20);
            click(By.cssSelector(MODAL_CLEAR_CHANGES_CONFIRMATION_BUTTON));
            wait(1000);
            ExtentReportsSetUp.testingPass(LogPage.CLICK_CLEAR_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_CLEAR_CHANGES_FAIL);
        }
    }
    public static void clickClearChangesActions(String parameter){
        try {
            switch (parameter){
                case "Person":
                    scrollToElement(By.id(ActionsPage.ACTION_COMMENTS_FIELD));
                    break;
                case "Organization":
                    scrollToElement(By.id(OrgPage.ORG_ACTION_COMMENTS_FIELD));
                    break;
            }
            waitUntilElementToBeSelected(By.cssSelector(CLEAR_CHANGES_BUTTON),20);
            click(By.cssSelector(CLEAR_CHANGES_BUTTON));
            waitUntilElementToBeSelected(By.cssSelector(MODAL_CLEAR_CHANGES_CONFIRMATION_LABEL),20);
            click(By.cssSelector(MODAL_CLEAR_CHANGES_CONFIRMATION_LABEL));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_CLEAR_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_CLEAR_CHANGES_FAIL);
        }
    }
}
