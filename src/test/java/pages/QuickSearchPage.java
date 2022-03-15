package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import config.extent_reports.ExtentReportsSetUp;

public class QuickSearchPage extends BasePage{

    public static String quickSearchManagerTable = "//*[@id='quickSearchManagerTable']/tbody";
    public static String objectTitleElement = "objectTitle";
    public static String quickSearchManagerTableRow0 = "#quickSearchManagerTable_row_0_col_0_link_0";

    /*
     * Method to verify and validate a result from quick search
     * I did not use LogPage class for this method because this method can be use with more parameters
     */
    public static void validateIfSearchResultIsCorrect(String parameter) {
            String errorMessage = "Error while verifying a quick search for " + parameter + " result";
            String passMessage = "I validate if a search for " + parameter + " result is correct";
        try {
            wait(2000);
            String text = getText(By.xpath(quickSearchManagerTable));
            if (text.contains(mass.get(0).get(parameter))) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                ExtentReportsSetUp.testingFail(errorMessage);
                Assert.assertFalse(true);
                System.err.println(errorMessage);
            }
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail(errorMessage);
            Assert.assertFalse(true);
            System.err.println(errorMessage);
        }
    }
    /*
     * Method to open a record
     */
    public static void openRecord() {
        wait(2000);
        try {
            BasePage.click(By.cssSelector(quickSearchManagerTableRow0));
            ExtentReportsSetUp.testingPass(LogPage.OPEN_RECORD_PASS);
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail(LogPage.OPEN_RECORD_FAIL);
            Assert.assertFalse(true);
            System.err.println(LogPage.OPEN_RECORD_FAIL);
        }
    }

    /*
     * validate if opened corrected summary
     */
    public static void validateIfOpenedSummaryProperly(String parameter) {
        try {
            String text = getText(By.id(objectTitleElement));

            if (mass.get(0).get(parameter).equals(text)) {
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_IF_OPENED_SUMMARY_PROPERLY_PASS);
            } else {
                ExtentReportsSetUp.testingFail(LogPage.VALIDATE_IF_OPENED_SUMMARY_PROPERLY_FAIL);
                Assert.assertFalse(true);
                System.err.println(LogPage.VALIDATE_IF_OPENED_SUMMARY_PROPERLY_FAIL);
            }
        } catch (Exception e) {
            System.err.println(LogPage.VALIDATE_IF_OPENED_SUMMARY_PROPERLY_FAIL);
        }
    }
}