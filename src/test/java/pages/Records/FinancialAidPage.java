package pages.Records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class FinancialAidPage extends BasePage {

    public static final String FINANCIAL_AID_SAVE_CHANGES_BUTTON = "#saveChangesBtnPersonFinancial";

    public static void clickSaveChanges(){
        try {
            scrollToTheBottom();
            waitElementBy(By.cssSelector((FINANCIAL_AID_SAVE_CHANGES_BUTTON)),10);
            click(By.cssSelector(FINANCIAL_AID_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_SAVE_CHANGES_FINANCIAL_AID_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_SAVE_CHANGES_FINANCIAL_AID_PASS);
        }
    }

}
