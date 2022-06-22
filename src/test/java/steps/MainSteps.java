package steps;

import io.cucumber.java.en.When;
import pages.MainPage;

public class MainSteps {

    @When("I add an opt-in method {string}")
    public static void selectQuickAddEmailOptIn(String emailOptIn) {
        MainPage.selectQuickAddEmailOptIn(emailOptIn);
    }


}
