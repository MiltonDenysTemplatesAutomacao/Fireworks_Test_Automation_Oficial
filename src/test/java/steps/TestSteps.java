package steps;

import io.cucumber.java.en.And;
import pages.TestPage;

public class TestSteps {

    @And("I verify if quick search result {string} is correct")
    public static void verifyQuickSearchResults(String quickSearchResult) {
        TestPage.verifyQuickSearchResults(quickSearchResult);
    }
    @And("I navigate to basic option")
    public static void navigateToBasic() {
        TestPage.navigateToBasic();
    }
    @And("I quick search {string} on home page")
    public static void quickSearchFromHomePage(String search) {
        TestPage.quickSearchFromHomePage(search);
    }
    @And("I navigate to contact option")
    public static void navigateToContact() {
        TestPage.navigateToContact();
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
    @And("I create name on contact tab for group {string}")
    public static void createName(String group) {
        TestPage.createName(group);
    }
}
