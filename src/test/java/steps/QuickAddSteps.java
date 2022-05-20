package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GlobalNavPage;
import pages.LoginPage;
public class QuickAddSteps {

    @And("I create a person")
    public static void createPerson(DataTable data) {
        GlobalNavPage.createPerson(data);
    }
    @And("I create an organization")
    public static void createOrganization(DataTable data) {
        GlobalNavPage.createOrganization(data);
    }
    @And("I create a staff")
    public static void createStaff(DataTable data) {
        GlobalNavPage.createStaff(data);
    }
    @When("I quick search {string}")
    public static void quickSearchOneParameter(String parameter) {
        GlobalNavPage.quickSearchOneParameter(parameter);
    }
    @When("I quick search partial {string}")
    public static void quickSearchQuickPartial(String parameter) {
        GlobalNavPage.quickSearchQuickPartial(parameter);
    }
    @And("I navigate to QuickAddCreatePersonPage")
    public static void quickAddCreatePersonPage() {
        GlobalNavPage.navigateQuickAddCreatePersonPage();
    }
    @And("I navigate to QuickAddCreateOrganizationPage")
    public static void quickAddCreateOrganizationPage() {
        GlobalNavPage.navigateQuickAddCreateOrganizationPage();
    }
    @And("I navigate to QuickAddCreateStaffPage")
    public static void quickAddCreateStaffPage() {
        GlobalNavPage.navigateQuickAddCreateStaffPage();
    }
    @When("I quick add a person")
    public static void quickAddPerson(DataTable data) {
        GlobalNavPage.quickAddPerson(data);
    }
    @When("I quick add an organization")
    public static void quickAddOrganization(DataTable data) {
        GlobalNavPage.quickAddOrganization(data);
    }
    @When("I quick add a staff")
    public static void quickAddStaff(DataTable data) {
        GlobalNavPage.quickAddStaff(data);
    }
    @And("I clickQuickAddPersonSaveAndGo")
    public static void clickQuickAddPersonSaveAndGo() {
        GlobalNavPage.quickAddPersonSaveGoButton();
    }
    @And("I clickQuickAddOrganizationSaveAndGo")
    public static void clickQuickAddOrganizationSaveAndGo() {
        GlobalNavPage.quickAddOrganizationSaveGoButton();
    }
    @And("I clickQuickAddStaffSaveAndGo")
    public static void clickQuickAddStaffSaveAndGo() {
        GlobalNavPage.quickAddStaffSaveGoButton();
    }
    @Then("I validate if {string} message is correct")
    public static void alertMessage(String message) {
        GlobalNavPage.alertMessageAfterAddPerson(message);
    }
    @And("I go to Home page")
    public static void goToHomePage() {
        GlobalNavPage.goToHomePage();
    }
    @And("I navigate to letters page")
    public static void navigateLettersPage() {
        GlobalNavPage.navigateLettersPage();
    }
}
