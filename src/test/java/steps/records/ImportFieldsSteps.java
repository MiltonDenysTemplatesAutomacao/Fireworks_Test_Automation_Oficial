package steps.records;

import io.cucumber.java.en.And;
import pages.records.ImportFieldsPage;

public class ImportFieldsSteps {

    @And("I map required fields {string}")
    public static void mapRequiredFields(String field) {
        ImportFieldsPage.mapRequiredFields(field);
    }
    @And("I add Optional Field Group {string} name {string}")
    public static void addOptionalFieldGroup(String group,String name) {
        ImportFieldsPage.addOptionalFieldGroup(group,name);
    }

}
