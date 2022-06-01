package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class EmailPage extends BasePage{

    public static final String CREATE_NEW_EMAIL_BUTTON = "#top-controls-create-new-email";
    public static final String EMAIL_TYPE_DIRECT = "top-controls-create-new-email-direct-link";
    public static final String EMAIL_TYPE_MARKETING = "top-controls-create-new-email-marketing-link";
    public static final String EMAIL_TYPE_NON_MARKETING = "top-controls-create-new-email-non-marketing-link";

    public static void createNewEmail(String type){
        try {
            waitUntilElementToBeSelected(By.cssSelector(CREATE_NEW_EMAIL_BUTTON),20);
            click(By.cssSelector(CREATE_NEW_EMAIL_BUTTON));
            wait(500);
            switch (type){
                case "Direct":
                    click(By.id(EMAIL_TYPE_DIRECT));
                    break;
                case "Marketing":
                    click(By.id(EMAIL_TYPE_MARKETING));
                    break;
                case "Non-Marketing":
                    click(By.id(EMAIL_TYPE_NON_MARKETING));
                    break;
            }
            ExtentReportsSetUp.testingPass(LogPage.CREATE_NEW_EMAIL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_NEW_EMAIL_FAIL);
        }
    }

}
