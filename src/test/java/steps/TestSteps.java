package steps;

import io.cucumber.java.en.And;
import pages.TestPage;

public class TestSteps {

    @And("I navigate to basic option")
    public static void navigateToBasic() {
        TestPage.navigateToBasic();
    }
    @And("I update citizenship values {string}, {string}, {string}")
    public static void navigateToBasic(String type, String country,String ssn) {
        TestPage.updateCitizenshipValues(type,country,ssn);
    }
    @And("I click on button {string}")
    public static void clickButton(String text) {
        TestPage.clickButton(text);
    }
    @And("I validate alert message {string}")
    public static void validateAlertMessage(String text) {
        TestPage.validateAlertMessage(text);
    }
    //test
}
