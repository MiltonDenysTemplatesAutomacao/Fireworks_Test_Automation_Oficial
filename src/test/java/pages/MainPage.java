package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.testng.reporters.jq.Main;

import static pages.GlobalNavPage.QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN;
import static pages.GlobalNavPage.QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN_LIST;

public class MainPage extends BasePage{
    public static final String QUICK_SEARCH_MAGNIFYING_GLASS = "#quickFindToggle";
    public static final String HEADER_QUICK_SEARCH_FIELD = "#headerSearch";
    public static final String HEADER_QUICK_SEARCH_BUTTON = "#navSearchSubmitButton";

    public static void quickSearchFromHeader(String data){
        String passMessage = String.format(LogPage.QUICK_SEARCH_FROM_HEADER_PASS,data);
        String failMessage = String.format(LogPage.QUICK_SEARCH_FROM_HEADER_FAIL,data);
        try {
            MainPage.clickOption(By.cssSelector(QUICK_SEARCH_MAGNIFYING_GLASS));
            MainPage.fillField(By.cssSelector(HEADER_QUICK_SEARCH_FIELD),data);
            MainPage.clickOption(By.cssSelector(HEADER_QUICK_SEARCH_BUTTON));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void selectQuickAddEmailOptIn(String emailOptIn){
        String errorMessage = String.format(LogPage.SELECT_QUICK_ADD_EMAIL_OPT_IN_FAIL, emailOptIn);
        String passMessage = String.format(LogPage.SELECT_QUICK_ADD_EMAIL_OPT_IN_PASS, emailOptIn);
        try {
            waitElementBy(By.cssSelector(QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN),20);
            BasePage.click(By.cssSelector(QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN));
            BasePage.selectElementsList(By.cssSelector(QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN_LIST), "a");
            wait(1000);
            clickOnListOfElements(emailOptIn);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    public static void clickElementByText(String text){
        String errorMessage = String.format(LogPage.CLICK_ELEMENT_BY_TEXT_FAIL, text);
        String passMessage = String.format(LogPage.CLICK_ELEMENT_BY_TEXT_PASS, text);
        try {
            waitUntilElementToBeSelected(By.xpath(getElementByText(text)),10);
            scrollToElement(By.xpath(getElementByText(text)));
            scrollTo("-150");
            wait(1000);
            BasePage.click(By.xpath(getElementByText(text)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
}
