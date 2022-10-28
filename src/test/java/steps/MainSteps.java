package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.MainPage;

public class MainSteps {

    @When("I add an opt-in method {string}")
    public static void selectQuickAddEmailOptIn(String emailOptIn) {
        MainPage.selectQuickAddEmailOptIn(emailOptIn);
    }
    @When("I refresh the page")
    public static void refreshPage() {
        BasePage.refreshPage();
    }
    @When("I click on {string}")
    public static void clickElementByText(String text) {
        MainPage.clickElementByText(text);
    }
    @When("I use datatable")
    public static void toUseDatatable(DataTable data) {
        MainPage.toUseDatatable(data);
    }
    @When("I quick search {string} from header")
    public static void quickSearchFromHeader(String data) {
        MainPage.quickSearchFromHeader(data);
    }
    @When("I validate if element {string} is {string}")
    public static void validateIfElementIsVisibleOrNot(String element,String status) {
        MainPage.validateIfElementIsVisibleOrNot(element,status);
    }
}
