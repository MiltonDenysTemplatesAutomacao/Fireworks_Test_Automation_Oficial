package steps;

import io.cucumber.java.en.Then;
import pages.OrgNavPage;

public class OrgNavSteps {

    @Then("I navigate to status organization")
    public static void navigateToStatus() {
        OrgNavPage.navigateToStatus();
    }

}
