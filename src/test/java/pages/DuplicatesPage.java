package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class DuplicatesPage extends BasePage{


    private static final String DUPLICATE_MANAGER_TABLE = "#duplicateManagerTable";
    private static final String DUPLICATE_MANAGER_SEARCH_FIELD = "#duplicateManagerTableControlsTableSearch";
    private static final String DUPLICATEMANAGERTABLE_ROW_0_COL_0 = "#duplicateManagerTable_row_0_col_0";
    private static final String DUPLICATE_MANAGER_FIRST_ROW_ELEMENT = "#duplicateManagerTable_row_0";

    private static final String SUSPENDED_RECORD_NAME = "#table-duplicate-record-suspended [data-field-name='full_name_with_middle']";
    private static final String SUSPENDED_RECORD_PREFERRED_NAME = "#table-duplicate-record-suspended [data-field-name='preferred_name']";
    private static final String SUSPENDED_RECORD_ROLE = "#table-duplicate-record-suspended [data-field-name='person_role_string']";
    private static final String SUSPENDED_RECORD_BIRTH_DATE = "#table-duplicate-record-suspended [data-field-name='birth_date']";
    private static final String SUSPENDED_RECORD_SSN = "#table-duplicate-record-suspended [data-field-name='social_security_number']";
    private static final String SUSPENDED_RECORD_EMAIL = "#table-duplicate-record-suspended [data-field-name='email_address']";
    private static final String SUSPENDED_RECORD_ADDRESS1 = "#table-duplicate-record-suspended [data-field-name='address_1']";
    private static final String SUSPENDED_RECORD_ADDRESS2 = "#table-duplicate-record-suspended [data-field-name='address_2']";
    private static final String SUSPENDED_RECORD_ADDRESS3 = "#table-duplicate-record-suspended [data-field-name='address_3']";
    private static final String SUSPENDED_RECORD_CITY = "#table-duplicate-record-suspended [data-field-name='address_city']";
    private static final String SUSPENDED_RECORD_STATE = "#table-duplicate-record-suspended [data-field-name='address_state']";
    private static final String SUSPENDED_RECORD_POSTAL_CODE = "#table-duplicate-record-suspended [data-field-name='address_postal_code']";
    private static final String SUSPENDED_RECORD_COUNTRY = "#table-duplicate-record-suspended [data-field-name='address_country']";
    private static final String SUSPENDED_RECORD_PHONE = "#table-duplicate-record-suspended [data-field-name='phone_number']";
    private static final String SUSPENDED_RECORD_DATE_ADDED = "#table-duplicate-record-suspended [data-field-name='created_at']";

    private static final String MERGE_DUPLICATES_BUTTON = "#delete-duplicate-record-0";
    private static final String MERGE_AND_GO_BUTTON = "mergeRecordsModalSaveGo";
    private static final String MERGE_AND_CLOSE_BUTTON = "mergeRecordsModalSaveClose";
    private static final String CANCEL_MERGE_BUTTON = "#modalCancelButtonmergeRecords";
    private static final String PREVIEW_MERGE_MATCH_NAME = "#merge-preview [data-field-name='full_name_with_middle']";
    private static final String PREVIEW_MERGE_MATCH_PREFERRED_NAME = "#merge-preview [data-field-name='preferred_name']";
    private static final String PREVIEW_MERGE_MATCH_ROLE = "#merge-preview [data-field-name='person_role_string']";
    private static final String PREVIEW_MERGE_MATCH_BIRTH_DATE = "#merge-preview [data-field-name='birth_date']";
    private static final String PREVIEW_MERGE_MATCH_SSN = "#merge-preview [data-field-name='social_security_number']";
    private static final String PREVIEW_MERGE_MATCH_EMAIL = "#merge-preview [data-field-name='email_address']";
    private static final String PREVIEW_MERGE_MATCH_ADDRESS1 = "#merge-preview [data-field-name='address_1']";
    private static final String PREVIEW_MERGE_MATCH_ADDRESS2 = "#merge-preview [data-field-name='address_2']";
    private static final String PREVIEW_MERGE_MATCH_ADDRESS3 = "#merge-preview [data-field-name='address_3']";
    private static final String PREVIEW_MERGE_MATCH_CITY = "#merge-preview [data-field-name='address_city']";
    private static final String PREVIEW_MERGE_MATCH_STATE = "#merge-preview [data-field-name='address_state']";
    private static final String PREVIEW_MERGE_MATCH_POSTAL_CODE = "#merge-preview [data-field-name='address_postal_code']";
    private static final String PREVIEW_MERGE_MATCH_COUNTRY = "#merge-preview [data-field-name='address_country']";
    private static final String PREVIEW_MERGE_MATCH_PHONE = "#merge-preview [data-field-name='phone_number']";
    private static final String PREVIEW_MERGE_MATCH_DATE_ADDED = "#merge-preview [data-field-name='created_at']";
    private static final String MAKE_SUSPENDED_RECORD_ACTIVE_BUTTON = "make-suspended-record-active";
    private static final String MAKE_SUSPENDED_ACTIVE_MODAL_CONFIRM_CREATE = "modalSubmitButtoncreateUnique";

    private static String possibleMatchName(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='full_name_with_middle']",possibleMatch);
    }
    private static String possibleMatchPreferredName(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='preferred_name']",possibleMatch);
    }
    private static String possibleMatchRole(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='person_role_string']",possibleMatch);
    }
    private static String possibleMatchBirthDate(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='birth_date']",possibleMatch);
    }
    private static String possibleMatchSSN(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='social_security_number']",possibleMatch);
    }
    private static String possibleMatchEmail(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='email_address']",possibleMatch);
    }
    private static String possibleMatchAddress1(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='address_1']",possibleMatch);
    }
    private static String possibleMatchAddress2(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='address_2']",possibleMatch);
    }
    private static String possibleMatchAddress3(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='address_3']",possibleMatch);
    }
    private static String possibleMatchCity(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='address_city']",possibleMatch);
    }
    private static String possibleMatchState(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='address_state']",possibleMatch);
    }
    private static String possibleMatchPostalCode(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='address_postal_code']",possibleMatch);
    }
    private static String possibleMatchCountry(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='address_country']",possibleMatch);
    }
    private static String possibleMatchPhone(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='phone_number']",possibleMatch);
    }
    private static String possibleMatchDateAdded(String possibleMatch){
        return String.format("#table-duplicate-record-%s [data-field-name='created_at']",possibleMatch);
    }

    public static void verifyDuplicateNotFound(String duplicate){
        String passMessage = String.format(LogPage.VERIFY_DUPLICATE_NOT_FOUND_PASS,duplicate);
        String failMessage = String.format(LogPage.VERIFY_DUPLICATE_NOT_FOUND_FAIL,duplicate);
        try {
            if(MainPage.verifyIfElementsIsVisible(By.cssSelector(DUPLICATE_MANAGER_FIRST_ROW_ELEMENT))){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyDuplicateFound(String duplicate){
        String passMessage = String.format(LogPage.VERIFY_DUPLICATE_FOUND_PASS,duplicate);
        String failMessage = String.format(LogPage.VERIFY_DUPLICATE_FOUND_FAIL,duplicate);
        try {
            if(MainPage.verifyGetText(By.cssSelector(DUPLICATE_MANAGER_FIRST_ROW_ELEMENT),duplicate)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void openDuplicate(){
        try {
            MainPage.clickOption(By.cssSelector(DUPLICATEMANAGERTABLE_ROW_0_COL_0));
            ExtentReportsSetUp.testingPass(LogPage.OPEN_DUPLICATE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.OPEN_DUPLICATE_FAIL);
        }
    }
    public static void verifyContentOfPossibleMatch(String possibleMatch,int person) {
        String passMessage = String.format(LogPage.VERIFY_CONTENT_OF_POSSIBLE_MATCH_PASS,possibleMatch,person);
        String failMessage = String.format(LogPage.VERIFY_CONTENT_OF_POSSIBLE_MATCH_FAIL,possibleMatch,person);

        try {
            if(MainPage.verifyGetText(By.cssSelector(possibleMatchName(possibleMatch)),mass.get(person).get("FullName"))
                    && MainPage.verifyGetText(By.cssSelector(possibleMatchPreferredName(possibleMatch)),mass.get(person).get("PreferredName"))
                    && MainPage.verifyGetText(By.cssSelector(possibleMatchRole(possibleMatch)),mass.get(person).get("Role1"))
                    && MainPage.verifyGetText(By.cssSelector(possibleMatchBirthDate(possibleMatch)),mass.get(person).get("BirthDate"))
                    && MainPage.verifyGetText(By.cssSelector(possibleMatchSSN(possibleMatch)),mass.get(person).get("SNN"))
                    && MainPage.verifyGetText(By.cssSelector(possibleMatchEmail(possibleMatch)),mass.get(person).get("EmailAddress"))
                    && MainPage.verifyGetText(By.cssSelector(possibleMatchAddress1(possibleMatch)),mass.get(person).get("Address1"))
                    && MainPage.verifyGetText(By.cssSelector(possibleMatchAddress2(possibleMatch)),mass.get(person).get("Address2"))
                    && MainPage.verifyGetText(By.cssSelector(possibleMatchAddress3(possibleMatch)),mass.get(person).get("Address3"))
                    && MainPage.verifyGetText(By.cssSelector(possibleMatchCity(possibleMatch)),mass.get(person).get("City"))
                    && MainPage.verifyGetText(By.cssSelector(possibleMatchState(possibleMatch)),mass.get(person).get("State"))
                    && MainPage.verifyGetText(By.cssSelector(possibleMatchPostalCode(possibleMatch)),mass.get(person).get("PostalCode"))
                    && MainPage.verifyGetText(By.cssSelector(possibleMatchCountry(possibleMatch)),mass.get(person).get("Country"))
                    && MainPage.verifyGetText(By.cssSelector(possibleMatchPhone(possibleMatch)),mass.get(person).get("Phone"))
                    && MainPage.validateCurrentDateTimeWithoutHour(By.cssSelector(possibleMatchDateAdded(possibleMatch)),mass.get(person).get("ActualDate"))){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void makeSuspendedRecordActive(){
        try {
            MainPage.clickOption(By.id(MAKE_SUSPENDED_RECORD_ACTIVE_BUTTON));
            waitUntilElementToBeSelected(By.id(MAKE_SUSPENDED_ACTIVE_MODAL_CONFIRM_CREATE),10);
            MainPage.clickOption(By.id(MAKE_SUSPENDED_ACTIVE_MODAL_CONFIRM_CREATE));
            ExtentReportsSetUp.testingPass(LogPage.MAKE_SUSPENDED_RECORD_ACTIVE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.MAKE_SUSPENDED_RECORD_ACTIVE_FAIL);
        }
    }
    public static void searchDuplicateManager(String parameter,int person){
        String passMessage = String.format(LogPage.SEARCH_DUPLICATE_MANAGER_PASS, parameter);
        String failMessage = String.format(LogPage.SEARCH_DUPLICATE_MANAGER_FAIL, parameter);
        try {
            waitElementBy(By.cssSelector(DUPLICATE_MANAGER_TABLE),20);
            write(By.cssSelector(DUPLICATE_MANAGER_SEARCH_FIELD),mass.get(person).get(parameter));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void verifyIfRecordNoLongerExistsOnDuplicatesPage(String fullname){
        try {
            waitElementBy(By.cssSelector(DUPLICATE_MANAGER_TABLE),20);
            if(!DUPLICATE_MANAGER_TABLE.contains(fullname)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_IF_RECORD_NO_LONGER_EXISTS_ON_DUPLICATES_PAGE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_RECORD_NO_LONGER_EXISTS_ON_DUPLICATES_PAGE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_RECORD_NO_LONGER_EXISTS_ON_DUPLICATES_PAGE_FAIL);
        }
    }

    public static void confirmMergeAndClose(){
        try {
            MainPage.clickOption(By.id(MERGE_AND_CLOSE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CONFIRM_MERGE_AND_CLOSE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CONFIRM_MERGE_AND_CLOSE_FAIL);
        }
    }
    public static void confirmMergeAndGo(){
        try {
            MainPage.clickOption(By.id(MERGE_AND_GO_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CONFIRM_MERGE_AND_GO_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CONFIRM_MERGE_AND_GO_FAIL);
        }
    }

    /*
     * Method to verify content of the preview record
     */
    public static void verifyMergePreview(int person){
        String passMessage = String.format(LogPage.VERIFY_MERGE_PREVIEW_PASS,person);
        String failMessage = String.format(LogPage.VERIFY_MERGE_PREVIEW_FAIL,person);
        wait(2000);
        try {
            if(MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_NAME),(mass.get(person).get("FullName")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_PREFERRED_NAME),(mass.get(person).get("PreferredName")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_ROLE),(mass.get(person).get("Role1")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_BIRTH_DATE),(mass.get(person).get("BirthDate")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_SSN),(mass.get(person).get("SSN")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_EMAIL),(mass.get(person).get("EmailAddress")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_ADDRESS1),(mass.get(person).get("Address1")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_ADDRESS2),(mass.get(person).get("Address2")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_ADDRESS3),(mass.get(person).get("Address3")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_CITY),(mass.get(person).get("City")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_STATE),(mass.get(person).get("State")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_POSTAL_CODE),(mass.get(person).get("PostalCode")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_COUNTRY),(mass.get(person).get("Country")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_PHONE),(mass.get(person).get("Phone")))
                    && MainPage.verifyGetText(By.cssSelector(PREVIEW_MERGE_MATCH_DATE_ADDED),(mass.get(person).get("DateAdded")))){
                    ExtentReportsSetUp.testingPass(passMessage);
            }else{
                    FailureDelegatePage.handlePageException(failMessage);
                        }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    /*
     * Method to click on merge button
     */
    public static void mergeDuplicates(){
        try {
            scrollToElement(By.cssSelector(SUSPENDED_RECORD_POSTAL_CODE));
            waitUntilElementToBeSelected(By.cssSelector(MERGE_DUPLICATES_BUTTON),20);
            click(By.cssSelector(MERGE_DUPLICATES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.MERGE_DUPLICATES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.MERGE_DUPLICATES_FAIL);
        }
    }

    /*
     * Method to verify content of the suspended record
     */
    public static void verifyContentOfSuspendedRecord(int person){
        String passMessage = String.format(LogPage.VERIFY_CONTENT_OF_SUSPENDED_RECORD_PASS,person);
        String failMessage = String.format(LogPage.VERIFY_CONTENT_OF_SUSPENDED_RECORD_FAIL,person);

        try {
            if(MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_NAME),mass.get(person).get("FullName"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_ROLE),mass.get(person).get("Role2"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_ROLE),mass.get(person).get("Role1"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_EMAIL),mass.get(person).get("EmailAddress"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_ADDRESS1),mass.get(person).get("Address1"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_CITY),mass.get(person).get("City"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_STATE),mass.get(person).get("State"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_POSTAL_CODE),mass.get(person).get("PostalCode"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_COUNTRY),mass.get(person).get("Country"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_PHONE),mass.get(person).get("Phone"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_PREFERRED_NAME),mass.get(person).get("PreferredName"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_BIRTH_DATE),mass.get(person).get("BirthDate"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_SSN),mass.get(person).get("SNN"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_ADDRESS2),mass.get(person).get("Address2"))
                && MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_ADDRESS3),mass.get(person).get("Address3"))
                && MainPage.validateCurrentDateTimeWithoutHour(By.cssSelector(SUSPENDED_RECORD_DATE_ADDED),mass.get(person).get("ActualDate"))){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
