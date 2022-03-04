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
        try {
            wait(2000);
            String text = getText(By.xpath(quickSearchManagerTable));
            if (text.contains(mass.get(0).get(parameter))) {
                ExtentReportsSetUp.testingPass("I validate if a search for " + parameter + " result is correct");
            } else {
                Assert.assertFalse(true);
                System.err.println("Error while verifying a quick search for " + parameter + " result");
                ExtentReportsSetUp.testingFail("Error while verifying a quick search for " + parameter + " result");
            }
        } catch (Exception e) {

        }
    }

    /*
     * Method to verify and validate a result from partial quick search
     */
    public static void validateIfSearchPartialResultIsCorrect(String parameter) {
        try {
            wait(2000);
            BasePage.selectElementsList(quickSearchManagerTable, "tr");
            int i = 0;
            while(i < listOfElements.size()) {
                if(listOfElements.get(i).getText().contains(mass.get(0).get(parameter))) {
                    System.out.println(true);
                }else {
                    Assert.assertFalse(true);
                    System.out.println(false);
                }
                i++;
            }
        }

        catch (Exception e) {

        }
    }

    /*
     * Method to open a record
     */
    public static void openRecord() {
        try {
            BasePage.click(By.cssSelector(quickSearchManagerTableRow0));
            ExtentReportsSetUp.testingPass("I click on a record");
        } catch (Exception e) {
            Assert.assertFalse(true);
            System.err.println("Error while clicking on a record");
            ExtentReportsSetUp.testingFail("Error validating clicking on a record");
        }
    }

    /*
     * validate if opened corrected summary
     */
    public static void validateIfOpenedSummaryProperly(String parameter) {
        try {
            String text = getText(By.id(objectTitleElement));

            if (mass.get(0).get(parameter).equals(text)) {
                ExtentReportsSetUp.testingPass("I validate if opened corrected summary");
            } else {
                Assert.assertFalse(true);
                System.err.println("Error while validating if opened summary from a record correctly");
                ExtentReportsSetUp.testingFail("Error validating if opened summary from a record correctly");
            }

        } catch (Exception e) {

        }
    }
}
