package pages.Records;

import bean.RelationshipBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class RelationshipPage extends BasePage {
    private static final String RELATIONSHIP_MANAGER_SEARCH_FIELD = "#personRelationshipsManagerTableControlsTableSearch";
    private static final String RELATIONSHIP_MANAGER_TABLE_ROW1_COL1_ELEMENT = "#personRelationshipsManagerTable_row_0_col_0";
    private static final String RELATIONSHIP_TARGET_FIELD = "#entity_relationship_0_relationship_entity_out";
    private static final String RELATIONSHIP_TARGET_ROLE_DROPDOWN = "#s2id_entity_relationship_0_relationship_out.select2-container.form-control.select2 a.select2-choice";
    private static final String ROLE_OF_IN_RELATIONSHIP_DROPDOWN = "#s2id_entity_relationship_0_relationship_in.select2-container.form-control.select2 a";
    private static final String RELATIONSHIPS_COMMENTS_FIELD = "#entity_relationship_0_relationship_comments";
    private static final String RELATIONSHIP_ACTIVE_CHECKBOX = "#entity_relationship_0_active";
    private static final String RELATIONSHIP_TARGET_DISABLED_FIELD = "#entity_relationship_0_relationship_entity_out[readonly]";
    private static final String RELATIONSHIP_TARGET_ROLE_DISABLED_DROPDOWN = "#s2id_entity_relationship_0_relationship_out.select2-container.select2-container-disabled.form-control.childSelect.entity_relationship.select2.required";
    private static final String ROLE_OF_IN_RELATIONSHIP_DISABLED_DROPDOWN = "#s2id_entity_relationship_0_relationship_in.select2-container.select2-container-disabled.form-control.parentSelect.entity_relationship.select2.required";
    private static final String RELATIONSHIPS_COMMENTS_DISABLED_FIELD = "#entity_relationship_0_relationship_comments[readonly]";

    public static void verifyRelationshipTextResults(String resultText){
        String passMessage = String.format(LogPage.VERIFY_RELATIONSHIP_TEXT_RESULTS_PASS,resultText);
        String failMessage = String.format(LogPage.VERIFY_RELATIONSHIP_TEXT_RESULTS_FAIL,resultText);
        try {
            waitElementBy(By.cssSelector(RELATIONSHIP_MANAGER_TABLE_ROW1_COL1_ELEMENT),20);
            boolean resultTextValidation = resultText.contains(getText(By.cssSelector(RELATIONSHIP_MANAGER_TABLE_ROW1_COL1_ELEMENT)));
            if(resultTextValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void verifyRelationshipReadOnly(){
        try {
            boolean relationshipTargetValidation = checkIfElementIsVisible(By.cssSelector(RELATIONSHIP_TARGET_DISABLED_FIELD));
            boolean targetRoleValidation = checkIfElementIsVisible(By.cssSelector(RELATIONSHIP_TARGET_ROLE_DISABLED_DROPDOWN));
            boolean roleInRelationshipValidation = checkIfElementIsVisible(By.cssSelector(ROLE_OF_IN_RELATIONSHIP_DISABLED_DROPDOWN));
            boolean commentsValidation = checkIfElementIsVisible(By.cssSelector(RELATIONSHIPS_COMMENTS_DISABLED_FIELD));

            if(relationshipTargetValidation
            && targetRoleValidation
            && roleInRelationshipValidation
            && commentsValidation){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_RELATIONSHIP_READ_ONLY_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_RELATIONSHIP_READ_ONLY_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_RELATIONSHIP_READ_ONLY_FAIL);
        }
    }
    public static void verifyRelationshipValues(RelationshipBean relationship){
        boolean relationshipTargetValidation = false;
        boolean targetRoleValidation = false;
        boolean roleInRelationshipValidation = false;
        boolean commentsValidation = false;
        boolean activeValidation = false;

        int verifyRelationshipValuesDelay=20;
        try {
            if(relationship.getRelationshipTarget()!=""){
                waitElementBy(By.cssSelector(RELATIONSHIP_TARGET_FIELD),verifyRelationshipValuesDelay);
                scrollToElement(By.cssSelector(RELATIONSHIP_TARGET_FIELD));
                scrollTo("-150");
                String relationshipTargetText = getAtribute(By.cssSelector(RELATIONSHIP_TARGET_FIELD),"value");
                relationshipTargetValidation = relationshipTargetText.contains(relationship.getRelationshipTarget());
            }else{
                relationshipTargetValidation=true;
            }
            if(relationship.getTargetRole()!=""){
                waitElementBy(By.cssSelector(RELATIONSHIP_TARGET_ROLE_DROPDOWN),verifyRelationshipValuesDelay);
                scrollToElement(By.cssSelector(RELATIONSHIP_TARGET_ROLE_DROPDOWN));
                scrollTo("-150");
                String targetRoleText = getAtribute(By.cssSelector(RELATIONSHIP_TARGET_FIELD),"value");
                targetRoleValidation = targetRoleText.contains(relationship.getTargetRole());

            }else{
                targetRoleValidation=true;
            }
            if(relationship.getRoleInRelationship()!=""){
                waitElementBy(By.cssSelector(ROLE_OF_IN_RELATIONSHIP_DROPDOWN),verifyRelationshipValuesDelay);
                scrollToElement(By.cssSelector(ROLE_OF_IN_RELATIONSHIP_DROPDOWN));
                scrollTo("-150");
                String roleInRelationshipText = getText(By.cssSelector(ROLE_OF_IN_RELATIONSHIP_DROPDOWN));
                roleInRelationshipValidation = roleInRelationshipText.contains(relationship.getRoleInRelationship());
            }else{
                roleInRelationshipValidation=true;
            }
            if(relationship.getComments()!=""){
                waitElementBy(By.cssSelector(RELATIONSHIPS_COMMENTS_FIELD),verifyRelationshipValuesDelay);
                scrollToElement(By.cssSelector(RELATIONSHIPS_COMMENTS_FIELD));
                scrollTo("-150");
                String commentsText = getAtribute(By.cssSelector(RELATIONSHIPS_COMMENTS_FIELD),"value");
                commentsValidation = commentsText.contains(relationship.getComments());
            }else{
                commentsValidation=true;
            }
            switch (relationship.getActive()) {
                case "1":
                    activeValidation = checkBoxIsActive(By.cssSelector(RELATIONSHIP_ACTIVE_CHECKBOX));
                    break;
                case "0":
                    activeValidation = !checkBoxIsActive(By.cssSelector(RELATIONSHIP_ACTIVE_CHECKBOX));
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled index. Update business logic");
            }
            if(relationshipTargetValidation
            && targetRoleValidation
            && roleInRelationshipValidation
            && commentsValidation
            && activeValidation){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_RELATIONSHIP_VALUES_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_RELATIONSHIP_VALUES_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_RELATIONSHIP_VALUES_FAIL);
        }
    }
    public static void searchRelationshipTable(String relationship){
        String passMessage = String.format(LogPage.SEARCH_RELATIONSHIP_TABLE_PASS,relationship);
        String failMessage = String.format(LogPage.SEARCH_RELATIONSHIP_TABLE_PASS,relationship);
        try {
            waitElementBy(By.cssSelector(RELATIONSHIP_MANAGER_SEARCH_FIELD),20);
            write(By.cssSelector(RELATIONSHIP_MANAGER_SEARCH_FIELD),relationship);
            wait(2000);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void openRelationship(String relationship){
        String passMessage = String.format(LogPage.OPEN_RELATIONSHIP_TABLE_PASS,relationship);
        String failMessage = String.format(LogPage.OPEN_RELATIONSHIP_TABLE_FAIL,relationship);
        try {
            searchRelationshipTable(relationship);
            waitUntilElementToBeSelected(By.cssSelector(RELATIONSHIP_MANAGER_TABLE_ROW1_COL1_ELEMENT),20);
            click(By.cssSelector(RELATIONSHIP_MANAGER_TABLE_ROW1_COL1_ELEMENT));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
