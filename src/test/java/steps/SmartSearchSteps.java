package steps;

import io.cucumber.java.en.When;
import pages.SmartSearchPage;

public class SmartSearchSteps {
    @When("I click on create smart search button")
    public static void navigateSmartSearchPage() {
        SmartSearchPage.createNewSmartSearch();
    }
    @When("I select {string} search field group {string} in smart search composer")
    public static void selectSearchField(String search,String index) {
        SmartSearchPage.selectSearchField(search,index);
    }
    @When("I select {string} operator field group {string} in smart search composer")
    public static void selectOperator(String search,String index) {
        SmartSearchPage.selectOperator(search,index);
    }
    @When("I fill {string} text condition value group {string}")
    public static void fillTextConditionValue(String search,String index) {
        SmartSearchPage.fillTextConditionValue(search,index);
    }
    @When("I click on save this search button")
    public static void clickSaveThisSearch() {
        SmartSearchPage.clickSaveThisSearch();
    }
    @When("I fill smart search name {string}")
    public static void fillSmartSearchName(String searchName) {
        SmartSearchPage.fillSmartSearchName(searchName);
    }
}
