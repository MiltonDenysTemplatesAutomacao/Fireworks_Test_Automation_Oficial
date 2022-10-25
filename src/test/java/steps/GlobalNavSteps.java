package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.GlobalNavPage;
import pages.OrgPage;

public class GlobalNavSteps {

    @And("I navigate to tasks")
    public static void navigateToTask() {
        GlobalNavPage.navigateToTasks();
    }
    @And("I navigate to tools")
    public static void navigateToTools() {
        GlobalNavPage.navigateToTools();
    }
    @And("I navigate to ImportsPackagesPage")
    public static void navigateImportsPackagesPage() {
        GlobalNavPage.navigateImportsPackagesPage();
    }
    @And("I validate if task is not displayed in tools menu")
    public static void validateTaskNotDisplayedToolsMenu() {
        GlobalNavPage.validateTaskInToolMenuIsNotDisplayed();
    }
    @And("I navigate to duplicates")
    public static void navigateDuplicatesPage() {
        GlobalNavPage.navigateDuplicatesPage();
    }
    @And("I navigate to people on records")
    public static void navigatePeoplePage() {
        GlobalNavPage.navigatePersonPage();
    }
    @And("I navigate to reports page")
    public static void navigateReportsPage() {
        GlobalNavPage.navigateReportsPage();
    }
    @And("I log out")
    public static void logout() {
        GlobalNavPage.logout();
    }

    @When("I navigate to organization on Records")
    public static void navigateOrganizationRecords() {
        GlobalNavPage.navigateOrganizationRecords();
    }
    @When("I navigate to smart search page")
    public static void navigateSmartSearchPage() {
        GlobalNavPage.navigateSmartSearchPage();
    }
    @When("I navigate to chat setting page")
    public static void navigateChatSettingsPage() {
        GlobalNavPage.navigateChatSettingsPage();
    }
    @When("I navigate to Letters Template Page")
    public static void navigateLettersTemplatesPage() {
        GlobalNavPage.navigateLettersTemplatesPage();
    }
    @When("I navigate to text message page")
    public static void navigateTextMessagePage() {
        GlobalNavPage.navigateTextMessagePage();
    }
    @When("I navigate to email manager page")
    public static void navigateEmailManagerPage() {
        GlobalNavPage.navigateEmailManagerPage();
    }
    @When("I navigate to Admin Panel Page")
    public static void navigateAdminPanelPage() {
        GlobalNavPage.navigateAdminPanelPage();
    }
    @When("I navigate to scheduler")
    public static void navigateToScheduler() {
        GlobalNavPage.navigateToScheduler();
    }
}
