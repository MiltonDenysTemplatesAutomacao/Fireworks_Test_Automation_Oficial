package steps.records;

import io.cucumber.java.en.And;
import pages.records.ImportFieldsPage;
import pages.records.ImportsPackagePage;

public class ImportFieldsSteps {

    @And("I map required fields {string}")
    public static void mapRequiredFields(String field) {
        ImportFieldsPage.mapRequiredFields(field);
    }
    @And("I add Optional Field Group {string} name {string}")
    public static void addOptionalFieldGroup(String group,String name) {
        ImportFieldsPage.addOptionalFieldGroup(group,name);
    }
    @And("I map optional fields {string}")
    public static void mapOptionalField(String field) {
        ImportFieldsPage.mapOptionalField(field);
    }
    @And("I {string} name {string} group {string}")
    public static void addFieldSubFieldRelationshipFieldGroup(String option,String name,String group) {
        ImportFieldsPage.addFieldSubFieldRelationshipFieldGroup(option,name,group);
    }

}
