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
                Assert.assertFalse(true);
                System.err.println(errorMessage);
                ExtentReportsSetUp.testingFail(errorMessage);
            }
        } catch (Exception e) {
            System.err.println(errorMessage);
        }
    }
    /*
     * Method to open a record
     */
    public static void openRecord() {
        String errorMessage = "Error while clicking on a record";
        String passMessage = "I click on a record";
        try {
            BasePage.click(By.cssSelector(quickSearchManagerTableRow0));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            Assert.assertFalse(true);
            System.err.println(errorMessage);
            ExtentReportsSetUp.testingFail(errorMessage);
        }
    }

    /*
     * validate if opened corrected summary
     */
    public static void validateIfOpenedSummaryProperly(String parameter) {
        String errorMessage = "Error while validating if opened summary from a record correctly";
        String passMessage = "I validate if opened corrected summary";
        try {
            String text = getText(By.id(objectTitleElement));

            if (mass.get(0).get(parameter).equals(text)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                Assert.assertFalse(true);
                System.err.println(errorMessage);
                ExtentReportsSetUp.testingFail(errorMessage);
            }
        } catch (Exception e) {
            System.err.println(errorMessage);
        }
    }
}
