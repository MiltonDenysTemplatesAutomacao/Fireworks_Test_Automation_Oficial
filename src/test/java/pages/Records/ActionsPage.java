package pages.Records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class ActionsPage extends BasePage {

    public static final String ADD_ACTION_BUTTON = "top-controls-create-new-action";
    public static final String ACTION_CATEGORY_DROPDOWN = "s2id_action_category_id";
    public static final String ACTION_DROPDOWN = "s2id_action_id";
    public static final String ACTION_STAFF_DROPDOWN = "s2id_action_staff";
    public static final String ACTION_COMMENTS_FIELD = "action_comments";
    public static final String ACTION_DATE_FIELD = "#action_date";
    public static final String DETAILS_LABEL = ".//*[@data-field-group-label='Details']";
    public static final String ACTION_SAVE_CHANGES_BUTTON = "actionSaveChangesButton";

    public static void updateAction(String person){
        int personNumber = Integer.parseInt(person.toString());
        try {
            if (mass.get(personNumber).get("Category") != null) {
                scrollToElement(By.xpath(DETAILS_LABEL));
                waitUntilElementToBeSelected(By.id(ACTION_CATEGORY_DROPDOWN), 20);
                BasePage.click(By.id(ACTION_CATEGORY_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(personNumber).get("Category"));
            }
            if (mass.get(personNumber).get("Action") != null) {
                scrollToElement(By.xpath(DETAILS_LABEL));
                waitUntilElementToBeSelected(By.id(ACTION_DROPDOWN), 20);
                BasePage.click(By.id(ACTION_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(personNumber).get("Action"));
            }
            if (mass.get(personNumber).get("Staff") != null) {
                scrollToElement(By.xpath(DETAILS_LABEL));
                waitUntilElementToBeSelected(By.id(ACTION_STAFF_DROPDOWN), 20);
                BasePage.click(By.id(ACTION_STAFF_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(personNumber).get("Staff"));
            }
            if (mass.get(personNumber).get("ActionDateField") != null) {
                scrollToElement(By.xpath(DETAILS_LABEL));
                waitUntilElementToBeSelected(By.cssSelector(ACTION_DATE_FIELD), 20);
                BasePage.write(By.cssSelector(ACTION_DATE_FIELD),mass.get(personNumber).get("ActionDateField"));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_ACTION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_ACTION_FAIL);
        }
    }

    public static void clickSaveChangesActions(){
        try {
            waitUntilElementToBeSelected(By.id(ACTION_SAVE_CHANGES_BUTTON),20);
            click(By.id(ACTION_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);

        }
    }
    public static void createAction(){
        try {
            waitUntilElementToBeSelected(By.id(ADD_ACTION_BUTTON),20);
            click(By.id(ADD_ACTION_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CREATE_ACTION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_ACTION_FAIL);

        }
    }
}
