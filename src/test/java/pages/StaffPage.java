package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.Records.StudentStatusPage;

public class StaffPage extends BasePage{
    public static final String STAFF_STATUS_RECORD = "staffHeaderRecordStatusButton";
    public static final String STAFF_PERMISSION_RECORD = ".//*[@class='btn-group autoSubmit dropDownSelect'][2]";
    private static final String CONTACT_PHONE_NUMBER_FIELD = "entity_phone_0_phone_number";
    private static final String CONTACT_PHONE_TYPE_DROPDOWN = "s2id_entity_phone_0_phone_type";
    private static final String CONTACT_PHONE_TYPE_DROPDOWN_LIST = "#select2-drop";
    private static final String CONTACT_PHONE_COMMENTS_FIELD = "entity_phone_0_phone_comments";
    private static final String STAFF_CONTACT_SAVE_CHANGES_BUTTON = "saveChangesBtnStaffContact";
    private static final String BASIC_PANEL_HEADING_ELEMENT = "#basic span";
    private static final String HEADER_STAFF_DELETE_BUTTON = "#deleteStaffButton";
    private static final String DELETE_STAFF_CONFIRM_SUBMIT_BUTTON = "#modalSubmitButtondeleteStaffConfirm";
    private static final String STAFF_MANAGER_TABLE_SEARCH_FIELD = "staffManagerTableControlsTableSearch";
    private static final String VALIDATE_STAFF_MANGER_DATATABLE_MESSAGE = "staffManagerTable_row_0_col_0";
    private static final String STAFF_ID_TYPES_SAVE_CHANGES_BUTTON = "saveChangesBtnStaffIdTypes";

    private static String statusPlusSignElement(String index){
        return String.format("#user_external_ids_%s_add",index);
    }
    private static String idTypePrimaryCheckbox(String index){
        return String.format("#user_external_ids_%s_primary",index);
    }
    private static String typeDropdown(String index){
        return String.format("#s2id_user_external_ids_%s_user_id_type_id",index);
    }
    private static String idNumber(String index){
        return String.format("#user_external_ids_%s_user_id_number",index);
    }
    private static String idRecordedDate(String index){
        return String.format("#user_external_ids_%s_user_id_date",index);
    }
    private static String whoAddedID(String index){
        return String.format("#s2id_user_external_ids_%s_user_id_user_added_id",index);
    }
    private static String comments(String index){
        return String.format("#user_external_ids_%s_user_id_comments",index);
    }

    public static void validateIdTypes(String index, int person){

        String errorMessage = String.format(LogPage.VALIDATE_ID_TYPES_FAIL, index,person);
        String passMessage = String.format(LogPage.VALIDATE_ID_TYPES_PASS, index,person);

        boolean idTypeValidation = false;
        boolean idTypePrymaryCheckboxLocator = false;
        boolean idNumberValidation = false;
        boolean idRecordedDateValidation = false;
        boolean commentsValidation = false;

        try {

            scrollToElement(By.cssSelector(statusPlusSignElement(index)));
            if (mass.get(person).get("IDType") != null) {
                String idType = getText(By.cssSelector(typeDropdown(index)));
                idTypeValidation = idType.contains(mass.get(person).get("IDType"));
            }else{
                idTypeValidation = true;
            }
            if (mass.get(person).get("IDNumber") != null) {
                String idNumber = getAtribute(By.cssSelector(idNumber(index)),"value");
                idNumberValidation = idNumber.contains(mass.get(person).get("IDNumber"));
            }else{
                idNumberValidation = true;
            }
            if (mass.get(person).get("IdRecordedDate") != null) {
                String idRecordedDate = getAtribute(By.cssSelector(idRecordedDate(index)),"value");
                idRecordedDateValidation = idRecordedDate.contains(mass.get(person).get("IdRecordedDate"));
            }else{
                idRecordedDateValidation = true;
            }
            if (mass.get(person).get("Comments") != null) {
                String comments = getText(By.cssSelector(comments(index)));
                commentsValidation = comments.contains(mass.get(person).get("Comments"));
            }else{
                commentsValidation = true;
            }
            switch (mass.get(person).get("Primary")) {
                case "1":
                    idTypePrymaryCheckboxLocator = checkBoxIsActive(By.cssSelector(idTypePrimaryCheckbox(index)));
                    break;
                case "0":
                    idTypePrymaryCheckboxLocator = !checkBoxIsActive(By.cssSelector(idTypePrimaryCheckbox(index)));
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled index. Update business logic");
            }
                    if(idTypeValidation
                            && idTypePrymaryCheckboxLocator
                            && idNumberValidation
                            && idRecordedDateValidation
                            && commentsValidation){
                        ExtentReportsSetUp.testingPass(passMessage);
                    }else{
                        FailureDelegatePage.handlePageException(errorMessage);
                    }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void updateIdTypes(String index, int person){
        String errorMessage = String.format(LogPage.UPDATE_ID_TYPES_ORG_FAIL, index,person);
        String passMessage = String.format(LogPage.UPDATE_ID_TYPES_ORG_PASS, index,person);
        try {
            if (mass.get(person).get("IDType") != null) {
                scrollToElement(By.cssSelector(statusPlusSignElement(index)));
                waitUntilElementToBeSelected(By.cssSelector(typeDropdown(index)),20);
                BasePage.click(By.cssSelector(typeDropdown(index)));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("IDType"));
            }
            if (mass.get(person).get("IDNumber") != null) {
                scrollToElement(By.cssSelector(statusPlusSignElement(index)));
                waitElementBy(By.cssSelector(idNumber(index)),20);
                BasePage.write(By.cssSelector(idNumber(index)),mass.get(person).get("IDNumber"));
            }
            if (mass.get(person).get("IdRecordedDate") != null) {
                scrollToElement(By.cssSelector(statusPlusSignElement(index)));
                waitElementBy(By.cssSelector(idRecordedDate(index)),20);
                BasePage.write(By.cssSelector(idRecordedDate(index)),mass.get(person).get("IdRecordedDate"));
            }
            if (mass.get(person).get("WhoAddedID") != null) {
                scrollToElement(By.cssSelector(statusPlusSignElement(index)));
                BasePage.click(By.cssSelector(whoAddedID(index)));
                BasePage.selectElementsList(By.cssSelector(OrgPage.WHO_ADDED_ID_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("WhoAddedID"));
            }
            if (mass.get(person).get("Comments") != null) {
                scrollToElement(By.cssSelector(statusPlusSignElement(index)));
                waitElementBy(By.cssSelector(comments(index)),20);
                BasePage.write(By.cssSelector(comments(index)),mass.get(person).get("Comments"));
            }
            if (mass.get(person).get("Primary") != null) {
                scrollToElement(By.cssSelector(statusPlusSignElement(index)));
                waitUntilElementPresence(By.cssSelector(idTypePrimaryCheckbox(index)),20);
                BasePage.click(By.cssSelector(idTypePrimaryCheckbox(index)));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void saveChangesBtnStaffIdTypes(){
        try {
            waitElementBy(By.id(STAFF_ID_TYPES_SAVE_CHANGES_BUTTON),20);
            BasePage.scrollToElement(By.id(STAFF_ID_TYPES_SAVE_CHANGES_BUTTON));
            BasePage.click(By.id(STAFF_ID_TYPES_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }

    public static void validateStaffMangerDatatableMessage(String message){
        String errorMessage = String.format(LogPage.VALIDATE_QUICK_SEARCH_EMPTY_FAIL, message);
        String passMessage = String.format(LogPage.VALIDATE_QUICK_SEARCH_EMPTY_PASS, message);
        try {
            wait(2000);
            String messageQuickSearchEmpty = getText(By.id(VALIDATE_STAFF_MANGER_DATATABLE_MESSAGE));
            if(messageQuickSearchEmpty.equals(message)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    public static void searchStaffManager(String search){
        String passMessage = String.format(LogPage.SEARCH_STAFF_MANAGER_PASS, search);
        String failMessage = String.format(LogPage.SEARCH_STAFF_MANAGER_FAIL, search);
        try {
            waitElementBy(By.id(STAFF_MANAGER_TABLE_SEARCH_FIELD),20);
            write(By.id(STAFF_MANAGER_TABLE_SEARCH_FIELD),mass.get(0).get(search));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void deleteStaff(){
        try {
            waitElementBy(By.cssSelector(HEADER_STAFF_DELETE_BUTTON),20);
            BasePage.click(By.cssSelector(HEADER_STAFF_DELETE_BUTTON));
            waitElementBy(By.cssSelector(DELETE_STAFF_CONFIRM_SUBMIT_BUTTON),20);
            BasePage.click(By.cssSelector(DELETE_STAFF_CONFIRM_SUBMIT_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.DELETE_STAFF_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.DELETE_STAFF_FAIL);
        }
    }

    public static void validateBasicElementIsVisible(){
        try {
            String basicReturn = getText(By.cssSelector(BASIC_PANEL_HEADING_ELEMENT));
            if(basicReturn.equals("Basic")){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_BASIC_ELEMENT_IS_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_ELEMENT_IS_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_ELEMENT_IS_VISIBLE_FAIL);

        }
    }


    public static void verifyHeaderRecordStatus(String status){
        String passMessage = String.format(LogPage.VERIFY_HEADER_RECORD_STATUS_PASS, status);
        String failMessage = String.format(LogPage.VERIFY_HEADER_RECORD_STATUS_FAIL, status);
        try {
            waitUntilElementPresence(By.id(STAFF_STATUS_RECORD),20);
            String studentTypeText = getText(By.id(STAFF_STATUS_RECORD));
            if(studentTypeText.contains(status)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyHeaderPermissions(String permission){
        String passMessage = String.format(LogPage.VERIFY_HEADER_PERMISSIONS_PASS, permission);
        String failMessage = String.format(LogPage.VERIFY_HEADER_PERMISSIONS_FAIL, permission);
        try {
            waitUntilElementPresence(By.xpath(STAFF_PERMISSION_RECORD),20);
            String studentTypeText = getText(By.xpath(STAFF_PERMISSION_RECORD));
            if(studentTypeText.contains(permission)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void updatePhoneNumber(String phone,String phoneType,String comment){
        try {
            waitElementBy(By.id(CONTACT_PHONE_NUMBER_FIELD),20);
            if (mass.get(0).get(phone) != null) {
                BasePage.write(By.id(CONTACT_PHONE_NUMBER_FIELD), mass.get(0).get(phone));
            }
            if (mass.get(0).get(phoneType) != null) {
                BasePage.click(By.id(CONTACT_PHONE_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(CONTACT_PHONE_TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(phoneType));
            }
            if (mass.get(0).get(comment) != null) {
                BasePage.write(By.id(CONTACT_PHONE_COMMENTS_FIELD), mass.get(0).get(comment));
            }
            saveChangesBtnStaffContact();
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_PHONE_NUMBER_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_PHONE_NUMBER_FAIL);
        }
    }
    /*
     * to save changes in contact tab on records
     */
    public static void saveChangesBtnStaffContact(){
        try {
            waitElementBy(By.id(STAFF_CONTACT_SAVE_CHANGES_BUTTON),20);
            BasePage.scrollToElement(By.id(STAFF_CONTACT_SAVE_CHANGES_BUTTON));
            BasePage.click(By.id(STAFF_CONTACT_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
}
