package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;

import static pages.GlobalNavPage.QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN;
import static pages.GlobalNavPage.QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN_LIST;

public class MainPage extends BasePage{

    public static void toUseDatatable(DataTable data){
        createDatatable(data);
    }

    public static void createDatatable(DataTable data){
        mass = data.asMaps(String.class, String.class);
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
            waitElementBy(By.xpath(getElementByText(text)),20);
            scrollToElement(By.xpath(getElementByText(text)));
            scrollTo("-150");
            BasePage.click(By.xpath(getElementByText(text)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
}
