package steps.Records;

import bean.RelationshipBean;
import io.cucumber.java.en.Then;
import pages.Records.RelationshipPage;

public class RelationshipSteps {

    @Then("I open a relationship {string}")
    public static void openRelationship(String relationship) {
        RelationshipPage.openRelationship(relationship);
    }
    @Then("I open an organization relationship {string}")
    public static void openOrgRelationship(String relationship) {
        RelationshipPage.openOrgRelationship(relationship);
    }
    @Then("I validate relationship readonly")
    public static void verifyRelationshipReadOnly() {
        RelationshipPage.verifyRelationshipReadOnly();
    }
    @Then("I search a relationship {string}")
    public static void searchRelationshipTable(String relationship) {
        RelationshipPage.searchRelationshipTable(relationship);
    }
    @Then("I verify relationships results message is correct {string}")
    public static void verifyRelationshipTextResults(String message) {
        RelationshipPage.verifyRelationshipTextResults(message);
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
