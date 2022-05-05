package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.Records.StudentStatusPage;

public class OrgPage extends BasePage{
    public static final String HEADER_RECORD_STATUS_ELEMENT = "orgHeaderRecordStatusButton";
    public static final String HEADER_OK_TO_CONTACT_ELEMENT = "personHeaderContactButton";
    public static final String HEADER_ORG_CATEGORY_ELEMENT = "orgHeaderCategoryButton";
    public static final String DATATABLE_EMPTY = "organizationManagerTable_row_0_col_0";
    public static final String WHO_ADDED_ID_DROPDOWN_LIST = "#select2-drop";
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
    private static final String COMMENTS_FIELD = "#entity_external_id_0_org_id_comments";
    private static final String PLUS_BUTTON_EXTERNAL_ID = "//*[@id='entity_external_id_0_add']";
    private static final String SAVE_CHANGES_BTN_ORG_ID_TYPES = "saveChangesBtnOrgIdTypes";
    private static final String ORG_STATUS_SAVE_CHANGES_BUTTON = "saveChangesBtnOrgStatus";
    private static final String ORG_HEADER_DELETE_BUTTON = "orgHeaderDeleteButton";
    private static final String DELETE_ORG_MODAL_DELETE_BUTTON = "modalSubmitButtondeleteOrganizationConfirm";
    private static final String ORGANIZATION_MANAGER_TABLE = "organizationManagerTable";
    private static final String ORGANIZATION_MANAGER_TABLE_SEARCH_FIELD = "organizationManagerTableControlsTableSearch";
    private static final String HEADER_ORG_ID_DISPLAY = "descriptionObjectOrgIdValue";



    private static String statusPlusSignElement(String index){
        return String.format("#org_status_%s_add",index);
    }
    private static String orgStatusStatusDropdown(String index){
        return String.format("#s2id_org_status_%s_org_status_value",index);
    }
    private static String orgStatusStatusDate(String index){
        return String.format("#org_status_%s_org_status_date",index);
    }
    private static String orgStatusStatusComments(String index){
        return String.format("#org_status_%s_org_status_comments",index);
    }


    public static void verifyOrgId(String orgId){
        try {
            scrollToElement(By.id(QuickSearchPage.OBJECT_TITLE_ELEMENT));
            waitElementBy(By.id(QuickSearchPage.OBJECT_TITLE_ELEMENT),20);
            String orgIdText = getText(By.id(HEADER_ORG_ID_DISPLAY));
            if(orgIdText.contains(orgId)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_ORG_ID_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_ORG_ID_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_ORG_ID_FAIL);
        }
    }
    public static void verifyRecordHeader(String name, String oktoContact, String recordStatus, String orgCategory){

        try {
            scrollToElement(By.id(QuickSearchPage.OBJECT_TITLE_ELEMENT));
            waitElementBy(By.id(QuickSearchPage.OBJECT_TITLE_ELEMENT),20);
            String fullNameText = getText(By.id(QuickSearchPage.OBJECT_TITLE_ELEMENT));
            String okToContactText = getText(By.id(HEADER_OK_TO_CONTACT_ELEMENT));
            String recordStatusText = getText(By.id(HEADER_RECORD_STATUS_ELEMENT));
            String orgCategoryText = getText(By.id(HEADER_ORG_CATEGORY_ELEMENT));
            if(fullNameText.contains(name)
                && okToContactText.contains(oktoContact)
                && recordStatusText.contains(recordStatus)
                && orgCategoryText.contains(orgCategory)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_RECORD_HEADER_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_RECORD_HEADER_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_RECORD_HEADER_FAIL);
        }

    }

    public static void validateOrganizationDatatableMessage(String message){
        String errorMessage = String.format(LogPage.VALIDATE_ORG_REQUIRED_FIELDS_MESSAGE_FAIL, message);
        String passMessage = String.format(LogPage.VALIDATE_ORG_REQUIRED_FIELDS_MESSAGE_PASS, message);
        try {
            wait(2000);
            String messageDatatableEmpty = getText(By.id(DATATABLE_EMPTY));
            if(messageDatatableEmpty.equals(message)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void searchOrganizationManager(String search){
        String passMessage = String.format(LogPage.SEARCH_ORGANIZATION_MANAGER_PASS, search);
        String failMessage = String.format(LogPage.SEARCH_ORGANIZATION_MANAGER_FAIL, search);
        try {
            waitElementBy(By.id(ORGANIZATION_MANAGER_TABLE),20);
            write(By.id(ORGANIZATION_MANAGER_TABLE_SEARCH_FIELD),mass.get(0).get(search));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void deleteOrganization(){
        try {
            waitUntilElementToBeSelected(By.id(ORG_HEADER_DELETE_BUTTON),20);
            BasePage.click(By.id(ORG_HEADER_DELETE_BUTTON));

            waitUntilElementToBeSelected(By.id(DELETE_ORG_MODAL_DELETE_BUTTON),20);
            BasePage.click(By.id(DELETE_ORG_MODAL_DELETE_BUTTON));

            ExtentReportsSetUp.testingPass(LogPage.DELETE_ORGANIZATION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.DELETE_ORGANIZATION_FAIL);
        }
    }

    public static void clickOnAddOrgStatus(String index){
        try {
            waitUntilElementToBeSelected(By.cssSelector(statusPlusSignElement(index)),20);
            BasePage.click(By.cssSelector(statusPlusSignElement(index)));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_ON_ADD_ORG_STATUS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_ON_ADD_ORG_STATUS_FAIL);
        }
    }

    public static void updateStatusOrg(String index, int person){
        String errorMessage = String.format(LogPage.UPDATE_STATUS_ORG_FAIL, index,person);
        String passMessage = String.format(LogPage.UPDATE_STATUS_ORG_PASS, index,person);
        try {
            if (mass.get(person).get("OrgStatus") != null) {
                scrollToElement(By.cssSelector(statusPlusSignElement(index)));
                waitUntilElementToBeSelected(By.cssSelector(orgStatusStatusDropdown(index)),20);
                BasePage.click(By.cssSelector(orgStatusStatusDropdown(index)));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("OrgStatus"));
            }
            if (mass.get(person).get("OrgStatusDate") != null) {
                scrollToElement(By.cssSelector(statusPlusSignElement(index)));
                waitElementBy(By.cssSelector(orgStatusStatusDate(index)),20);
                BasePage.write(By.cssSelector(orgStatusStatusDate(index)),mass.get(person).get("OrgStatusDate"));
            }
            if (mass.get(person).get("OrgStatusComments") != null) {
                scrollToElement(By.cssSelector(statusPlusSignElement(index)));
                waitElementBy(By.cssSelector(orgStatusStatusComments(index)),20);
                BasePage.write(By.cssSelector(orgStatusStatusComments(index)),mass.get(person).get("OrgStatusComments"));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void organizationStatusSaveChanges(){
        try {
            waitUntilElementToBeSelected(By.id(ORG_STATUS_SAVE_CHANGES_BUTTON),20);
            BasePage.click(By.id(ORG_STATUS_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.ORGANIZATION_STATUS_SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ORGANIZATION_STATUS_SAVE_CHANGES_FAIL);
        }
    }

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