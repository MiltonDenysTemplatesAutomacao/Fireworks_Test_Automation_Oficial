package steps.records;

import bean.RelationshipBean;
import io.cucumber.java.en.Then;
import pages.records.RelationshipPage;

public class RelationshipSteps {

    @Then("I open a relationship {string}")
    public static void openRelationship(String relationship) {
        RelationshipPage.openRelationship(relationship);
    }
    @Then("I open an organization relationship {string}")
    public static void openOrgRelationship(String relationship) {
        RelationshipPage.openOrgRelationship(relationship);
    }
    @Then("I update relationship {string}, {string}, {string}")
    public static void updateRelationshipValues(String targetRole,String roleInRelationship,String comments ) {
        RelationshipPage.updateRelationshipValues(targetRole,roleInRelationship,comments);
    }
    @Then("I click on save changes on Relationships")
    public static void saveChangesRelationship( ) {
        RelationshipPage.saveChangesRelationship();
    }
    @Then("I validate relationship readonly")
    public static void verifyRelationshipReadOnly() {
        RelationshipPage.verifyRelationshipReadOnly();
    }
    @Then("I validate relationship readonly field {string}")
    public static void verifyRelationshipReadOnlyWithParameters(String relationship) {
        RelationshipPage.verifyRelationshipReadOnlyWithParameters(relationship);
    }
    @Then("I search a relationship {string}")
    public static void searchRelationshipTable(String relationship) {
        RelationshipPage.searchRelationshipTable(relationship);
    }
    @Then("I verify relationships results message is correct {string}")
    public static void verifyRelationshipTextResults(String message) {
        RelationshipPage.verifyRelationshipTextResults(message);
    }
    @Then("I open a record picker {string}")
    public static void openRecordPicker(String recordPicker) {
        RelationshipPage.openRecordPicker(recordPicker);
    }
    @Then("I create a relationship")
    public static void createRelationship() {
        RelationshipPage.createRelationship();
    }
    @Then("I delete a relationship")
    public static void deleteRelationship() {
        RelationshipPage.deleteRelationship();
    }
    @Then("I open an organization record picker {string}")
    public static void selectFromOrgPicker(String recordPicker) {
        RelationshipPage.selectFromOrgPicker(recordPicker);
    }
    @Then("I verify relationship values {string}, {string}, {string}, {string}, {string}")
    public static void verifyRelationshipValues(String relationshipTarget, String targetRole, String roleInRelationship, String comments, String active) {
        RelationshipBean relationship = new RelationshipBean();
        relationship.setRelationshipTarget(relationshipTarget);
        relationship.setTargetRole(targetRole);
        relationship.setRoleInRelationship(roleInRelationship);
        relationship.setComments(comments);
        relationship.setActive(active);
        RelationshipPage.verifyRelationshipValues(relationship);
    }

}
