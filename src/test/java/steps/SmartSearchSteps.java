package steps;

import io.cucumber.java.en.When;
import pages.SmartSearchPage;

public class SmartSearchSteps {
    @When("I verify smart search results {string}")
    public static void verifySearchResults(String results) {
        SmartSearchPage.verifySearchResults(results);
    }
    @When("I click on run search button")
    public static void runSearch() {
        SmartSearchPage.runSearch();
    }
    @When("I validate number of records {string}")
    public static void numberOfRecords(String results) {
        SmartSearchPage.numberOfRecords(results);
    }
    @When("I verify result count on smart search table {string}")
    public static void verifyResultCount(String numRecords) {
        SmartSearchPage.verifyResultCount(numRecords);
    }
    @When("I verify results on smart search table {string}")
    public static void verifySmartSearchResults(String results) {
        SmartSearchPage.verifySmartSearchResults(results);
    }
    @When("I click on create smart search button")
    public static void navigateSmartSearchPage() {
        SmartSearchPage.createNewSmartSearch();
    }
    @When("I select {string} search field group {string} condition {string} in smart search composer")
    public static void selectSearchField(String search,String group,String condition) {
        SmartSearchPage.selectSearchField(search,group,condition);
    }
    @When("I select {string} operator field group {string} condition {string} in smart search composer")
    public static void selectOperator(String search,String group,String operator) {
        SmartSearchPage.selectOperator(search,group,operator);
    }
    @When("I fill {string} text group {string} condition {string}")
    public static void fillTextConditionValue(String search,String group,String operator) {
        SmartSearchPage.fillTextConditionValue(search,group,operator);
    }
    @When("I open smart search {string}")
    public static void openSearch(String search) {
        SmartSearchPage.openSearch(search);
    }
    @When("I select match {string}")
    public static void selectMatch(String match) {
        SmartSearchPage.selectMatch(match);
    }
    @When("I click on save this search button")
    public static void clickSaveThisSearch() {
        SmartSearchPage.clickSaveThisSearch();
    }
    @When("I add a new group on smart search composer {string}")
    public static void addGroupSmartSearchComposer(String index) {
        SmartSearchPage.addGroupSmartSearchComposer(index);
    }
    @When("I fill smart search name {string}")
    public static void fillSmartSearchName(String searchName) {
        SmartSearchPage.fillSmartSearchName(searchName);
    }
}
