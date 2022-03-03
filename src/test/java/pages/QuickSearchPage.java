package pages;
import org.openqa.selenium.By;
import config.extent_reports.ExtentReportsSetUp;

public class QuickSearchPage extends BasePage{
    public static String quickSearchManagerTable = "#quickSearchManagerTable";
    public static String objectTitleElement = "objectTitle";

    /*
     * Method to verify and validate a result from quick search
     */
    public static void validateIfSearchResultIsCorrect(String parameter) {
        try {
            String text = getText(By.xpath("//*[@id='quickSearchManagerTable']/tbody"));
            System.out.println(text);
            String data = mass.get(0).get(parameter);

            System.out.println(data);
            if (text.contains(mass.get(0).get(parameter))) {
                ExtentReportsSetUp.testingPass("I validate if a search for " + parameter + " result is correct");
            } else {
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
                    System.out.println(false);
                }
                System.out.println(listOfElements.get(i).getText());

                i++;
            }

//			for (int i = 0; i < listOfElements.size(); i++) {
//				System.out.println(listOfElements.get(i).getText());
//				System.out.println(mass.get(0).get(parameter));
//				if (listOfElements.get(i).getText().contains(mass.get(0).get(parameter))) {
//					ExtentReportsSetUp.testingPass("I validate if a search for " + parameter + " result is correct");
//				} else {
//					System.err.println("Error while verifying a quick search partial for " + parameter + " result");
//					ExtentReportsSetUp.testingFail("Error while verifying a quick search partial for " + parameter + " result");
//				}
//			}
        }

        catch (Exception e) {

        }
    }

    /*
     * Method to open a record
     */
    public static void openRecord() {
        try {
            BasePage.click(By.cssSelector(quickSearchManagerTable));
            ExtentReportsSetUp.testingPass("I click on a record");
        } catch (Exception e) {
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
                System.err.println("Error while validating if opened summary from a record correctly");
                ExtentReportsSetUp.testingFail("Error validating if opened summary from a record correctly");
            }

        } catch (Exception e) {

        }
    }
}
