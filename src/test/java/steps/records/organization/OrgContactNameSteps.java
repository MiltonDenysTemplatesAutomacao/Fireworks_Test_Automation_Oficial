package steps.records.organization;

import io.cucumber.java.en.When;
import pages.records.organization.OrgContactNamePage;

public class OrgContactNameSteps {

    @When("I verify organization name {string} on contact")
    public static void verifyName(String name) {
        OrgContactNamePage.verifyContactOrganizationName(name);
    }
    @When("I verify organization name is 1 to 1")
    public static void verifyOrgNameIs1to1() {
        OrgContactNamePage.verifyOrgNameIs1to1();
    }

}
