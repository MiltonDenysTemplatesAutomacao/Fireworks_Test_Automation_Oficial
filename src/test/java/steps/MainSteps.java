package steps;

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


}
