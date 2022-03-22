package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import config.extent_reports.ExtentReportsSetUp;

public class QuickSearchPage extends BasePage{

    public static final String quickSearchManagerTable = "//*[@id='quickSearchManagerTable']/tbody";
    public static final String objectTitleElement = "objectTitle";
    public static final String quickSearchManagerTableRow0 = "#quickSearchManagerTable_row_0_col_0_link_0";

    /*
     * Method to verify and validate a result from quick search
     */
    public static void validateIfSearchResultIsCorrect(String parameter) {
        String errorMessage = String.format(LogPage.QUICK_SEARCH_ONE_PARAMETER_FAIL,parameter);
        String passMessage = String.format(LogPage.QUICK_SEARCH_ONE_PARAMETER_PASS,parameter);
        try {
            waitElementBy(By.xpath(quickSearchManagerTable),20);
            String text = getText(By.xpath(quickSearchManagerTable));
            if (text.contains(mass.get(0).get(parameter))) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    /*
     * Method to open a record
     */
    public static void openRecord() {
        try {
            waitElementBy(By.cssSelector(quickSearchManagerTableRow0),20);
            BasePage.click(By.cssSelector(quickSearchManagerTableRow0));
            ExtentReportsSetUp.testingPass(LogPage.OPEN_RECORD_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.OPEN_RECORD_FAIL);
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
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_IF_OPENED_SUMMARY_PROPERLY_FAIL);
            }
        } catch (Exception e) {
            System.err.println(LogPage.VALIDATE_IF_OPENED_SUMMARY_PROPERLY_FAIL);
        }
    }
}
