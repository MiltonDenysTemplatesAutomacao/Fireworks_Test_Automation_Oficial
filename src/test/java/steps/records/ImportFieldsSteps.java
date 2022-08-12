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
    @And("I map Financial Aid optional fields {string}")
    public static void mapFinancialAidOptionalField(String field) {
        ImportFieldsPage.mapFinancialAidOptionalField(field);
    }
    @And("I map Financial Aid Interests optional fields {string}")
    public static void mapFinancialAidInterestsOptionalField(String field) {
        ImportFieldsPage.mapFinancialAidInterestsOptionalField(field);
    }
    @And("I {string} name {string} group {string}")
    public static void addFieldSubFieldRelationshipFieldGroup(String option,String name,String group) {
        ImportFieldsPage.addFieldSubFieldRelationshipFieldGroup(option,name,group);
    }
    @And("I add conversion field {string} value {string} group {string}")
    public static void addConversion(String option,String value,String group) {
        ImportFieldsPage.addConversion(option,value,group);
    }

}
