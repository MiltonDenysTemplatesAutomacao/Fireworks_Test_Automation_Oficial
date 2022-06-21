package pages.Records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;


public class PersonContactPhonePage extends BasePage {
    public static String phonePlusSignElement(String index){
        return String.format("#entity_phone_%s_add",index);
    }

    public static void addPhone(String index){
        try {
            scrollToElement(By.cssSelector(phonePlusSignElement(index)));
            scrollTo("-100");
            waitUntilElementToBeSelected(By.cssSelector(phonePlusSignElement(index)), 20);
            BasePage.click(By.cssSelector(phonePlusSignElement(index)));
            ExtentReportsSetUp.testingPass(LogPage.ADD_PHONE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ADD_PHONE_FAIL);
        }

    }
}
