package pages.records;

import bean.RelationshipBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import org.testng.reporters.jq.Main;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;

public class RelationshipPage extends BasePage {
    private static final String RELATIONSHIP_MANAGER_SEARCH_FIELD = "#personRelationshipsManagerTableControlsTableSearch";
    private static final String ORG_RELATIONSHIP_MANAGER_SEARCH_FIELD = "#organizationRelationshipsManagerTableControlsTableSearch";
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
    private static final String ORG_RELATIONSHIP_MANAGER_TABLE_ROW1_COL1_ELEMENT = "#organizationRelationshipsManagerTable_row_0_col_0";

    public static void verifyRelationshipTextResults(String resultText){
        String passMessage = String.format(LogPage.VERIFY_RELATIONSHIP_TEXT_RESULTS_PASS,resultText);
        String failMessage = String.format(LogPage.VERIFY_RELATIONSHIP_TEXT_RESULTS_FAIL,resultText);
        try {
            if(MainPage.verifyGetText(By.cssSelector(RELATIONSHIP_MANAGER_TABLE_ROW1_COL1_ELEMENT),resultText)){
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
            if(MainPage.verifyIfElementIsVisible(By.cssSelector(RELATIONSHIP_TARGET_DISABLED_FIELD))
                    && MainPage.verifyIfElementIsVisible(By.cssSelector(RELATIONSHIP_TARGET_ROLE_DISABLED_DROPDOWN))
                    && MainPage.verifyIfElementIsVisible(By.cssSelector(ROLE_OF_IN_RELATIONSHIP_DISABLED_DROPDOWN))
                    && MainPage.verifyIfElementIsVisible(By.cssSelector(RELATIONSHIPS_COMMENTS_DISABLED_FIELD))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_RELATIONSHIP_READ_ONLY_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_RELATIONSHIP_READ_ONLY_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_RELATIONSHIP_READ_ONLY_FAIL);
        }
    }
    public static void verifyRelationshipValues(RelationshipBean relationship){
        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(RELATIONSHIP_TARGET_FIELD),relationship.getRelationshipTarget())
                && MainPage.verifyGetText(By.cssSelector(RELATIONSHIP_TARGET_ROLE_DROPDOWN),relationship.getTargetRole())
                && MainPage.verifyGetText(By.cssSelector(ROLE_OF_IN_RELATIONSHIP_DROPDOWN),relationship.getRoleInRelationship())
                && MainPage.verifyGetAttribute(By.cssSelector(RELATIONSHIPS_COMMENTS_FIELD),relationship.getComments())
                && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(RELATIONSHIP_ACTIVE_CHECKBOX),relationship.getActive())
            ){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_RELATIONSHIP_VALUES_PASS);
            }else{
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_RELATIONSHIP_VALUES_PASS);
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
    public static void searchOrgRelationshipTable(String relationship){
        String passMessage = String.format(LogPage.SEARCH_ORG_RELATIONSHIP_TABLE_PASS,relationship);
        String failMessage = String.format(LogPage.SEARCH_ORG_RELATIONSHIP_TABLE_FAIL,relationship);
        try {
            waitElementBy(By.cssSelector(ORG_RELATIONSHIP_MANAGER_SEARCH_FIELD),20);
            write(By.cssSelector(ORG_RELATIONSHIP_MANAGER_SEARCH_FIELD),relationship);
            wait(2000);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void openOrgRelationship(String relationship){
        String passMessage = String.format(LogPage.OPEN_ORG_RELATIONSHIP_TABLE_PASS,relationship);
        String failMessage = String.format(LogPage.OPEN_ORG_RELATIONSHIP_TABLE_FAIL,relationship);
        try {
            searchOrgRelationshipTable(relationship);
            waitUntilElementToBeSelected(By.cssSelector(ORG_RELATIONSHIP_MANAGER_TABLE_ROW1_COL1_ELEMENT),20);
            click(By.cssSelector(ORG_RELATIONSHIP_MANAGER_TABLE_ROW1_COL1_ELEMENT));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
