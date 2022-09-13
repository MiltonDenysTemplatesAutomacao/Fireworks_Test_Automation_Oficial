package steps.records.imports;

import io.cucumber.java.en.When;
import pages.records.imports.ImportsPage;

public class ImportsSteps {

    @When("I validate if {string} status is displayed for package {string}")
    public static void waitUntilImportConcludes(String status, String packageName) {
        ImportsPage.waitUntilImportConcludes(status,packageName);
    }
}
