package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class OrgNavPage extends BasePage{

    private static final String RECORD_ORG_NAV_TAB_STATUS = "#recordNavTab_status";
    private static final String RECORD_ORG_NAV_TAB_CONTACT = "#recordNavTab_contact";

    public static void navigateToStatus(){
        try {
            scrollToElement(By.cssSelector(RECORD_ORG_NAV_TAB_CONTACT));
            waitElementBy(By.cssSelector(RECORD_ORG_NAV_TAB_STATUS),20);
            BasePage.click(By.cssSelector(RECORD_ORG_NAV_TAB_STATUS));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_STATUS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_STATUS_FAIL);
        }
    }
}
