package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class OrgPage extends BasePage{

    private static final String EMAIL_ADDRESS_FIELD = "#entity_email_0_org_email_address";
    private static final String EMAIL_TYPE_DROP_DOWN = "#s2id_entity_email_0_org_email_type";
    private static final String EMAIL_TYPE_DROP_DOWN_LIST = "#select2-drop";

    private static final String EMAIL_OPT_DROP_DOWN = "#s2id_entity_email_0_org_opt_in_method_id";
    private static final String EMAIL_OPT_DROP_DOWN_LIST = "#select2-drop";

    private static final String ORG_BASIC_SAVE_CHANGES_BUTTON = "saveChangesBtnOrgContact";
    private static final String ORGANIZATION_NAME_FIELD = "#org_name_0_org_name_formal";

    private static final String TYPE_DROPDOWN = "#select2-chosen-6";
    private static final String TYPE_DROPDOWN_LIST = "#select2-drop";
    private static final String ID_NUMBER_FIELD = "#entity_external_id_0_org_id_number";
    private static final String ID_RECORDED_DATE_FIELD = "#entity_external_id_0_org_id_date";
    private static final String WHO_ADDED_ID_DROPDOWN = "#select2-chosen-7";
    private static final String WHO_ADDED_ID_DROPDOWN_LIST = "#select2-drop";
    private static final String COMMENTS_FIELD = "#entity_external_id_0_org_id_comments";
    private static final String PLUS_BUTTON_EXTERNAL_ID = "//*[@id='entity_external_id_0_add']";
    private static final String SAVE_CHANGES_BTN_ORG_ID_TYPES = "saveChangesBtnOrgIdTypes";

    /*
     * to update email address in Contact tab on records
     */
    public static void updateEmailAddress(String emailAddress,String emailType,String emailOpt, String optStatus, String optDate, String emailStatus, String emailContent){
        try {
            waitElementBy(By.cssSelector(EMAIL_ADDRESS_FIELD),20);
            BasePage.scrollToElement(By.cssSelector(ORGANIZATION_NAME_FIELD));
            if (mass.get(0).get(emailAddress) != null) {
                BasePage.write(By.cssSelector(EMAIL_ADDRESS_FIELD), mass.get(0).get(emailAddress));
            }
            if (mass.get(0).get(emailType) != null) {
                BasePage.click(By.cssSelector(EMAIL_TYPE_DROP_DOWN));
                BasePage.selectElementsList(By.cssSelector(EMAIL_TYPE_DROP_DOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(emailType));
            }
            if (mass.get(0).get(emailOpt) != null) {
                BasePage.click(By.cssSelector(EMAIL_OPT_DROP_DOWN));
                BasePage.selectElementsList(By.cssSelector(EMAIL_OPT_DROP_DOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(emailOpt));
            }
            saveChangesBtnOrgContact();
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EMAIL_ADDRESS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_EMAIL_ADDRESS_FAIL);
        }
    }


    /*
     * to save changes in Contact tab on records
     */
    public static void saveChangesBtnOrgContact(){
        try {
            waitElementBy(By.id(ORG_BASIC_SAVE_CHANGES_BUTTON),20);
            BasePage.scrollToElement(By.id(ORG_BASIC_SAVE_CHANGES_BUTTON));
            BasePage.click(By.id(ORG_BASIC_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
    /*
     * to update Id Types in contact tab on records
     */
    public static void updateExternalIdTypes(String type,String idNumber,String idRecordedDate,String whoAddedId, String comments){
        try {
            waitElementBy(By.xpath(PLUS_BUTTON_EXTERNAL_ID),20);
            BasePage.scrollToElement(By.xpath(PLUS_BUTTON_EXTERNAL_ID));

            if (mass.get(0).get(type) != null) {
                BasePage.click(By.cssSelector(TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(type));
            }
            if (mass.get(0).get(idNumber) != null) {
                BasePage.write(By.cssSelector(ID_NUMBER_FIELD), mass.get(0).get(idNumber));
            }
            if (mass.get(0).get(idRecordedDate) != null) {
                BasePage.write(By.cssSelector(ID_RECORDED_DATE_FIELD), mass.get(0).get(idRecordedDate));
            }
            if (mass.get(0).get(whoAddedId) != null) {
                BasePage.click(By.cssSelector(WHO_ADDED_ID_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(WHO_ADDED_ID_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(whoAddedId));
            }
            if (mass.get(0).get(comments) != null) {
                BasePage.write(By.cssSelector(COMMENTS_FIELD), mass.get(0).get(comments));
            }
            saveChangesBtnPersonIdTypes();
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EXTERNAL_ID_TYPES_PASS);

        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_EXTERNAL_ID_TYPES_FAIL);
        }
    }

    /*
     * to save changes in Id Types tab on records
     */
    public static void saveChangesBtnPersonIdTypes(){
        try {
            waitElementBy(By.id(SAVE_CHANGES_BTN_ORG_ID_TYPES),20);
            BasePage.scrollToElement(By.id(SAVE_CHANGES_BTN_ORG_ID_TYPES));
            BasePage.click(By.id(SAVE_CHANGES_BTN_ORG_ID_TYPES));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
}