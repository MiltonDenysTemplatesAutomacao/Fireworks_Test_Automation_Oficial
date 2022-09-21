package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class DuplicatesPage extends BasePage{


    public static final String DUPLICATE_MANAGER_TABLE = "#duplicateManagerTable";
    public static final String DUPLICATE_MANAGER_SEARCH_FIELD = "#duplicateManagerTableControlsTableSearch";

    public static final String SUSPENDED_RECORD_NAME = "#table-duplicate-record-suspended [data-field-name='full_name_with_middle']";
    public static final String SUSPENDED_RECORD_PREFERRED_NAME = "#table-duplicate-record-suspended [data-field-name='preferred_name']";
    public static final String SUSPENDED_RECORD_ROLE = "#table-duplicate-record-suspended [data-field-name='person_role_string']";
    public static final String SUSPENDED_RECORD_BIRTH_DATE = "#table-duplicate-record-suspended [data-field-name='birth_date']";
    public static final String SUSPENDED_RECORD_SSN = "#table-duplicate-record-suspended [data-field-name='social_security_number']";
    public static final String SUSPENDED_RECORD_EMAIL = "#table-duplicate-record-suspended [data-field-name='email_address']";
    public static final String SUSPENDED_RECORD_ADDRESS1 = "#table-duplicate-record-suspended [data-field-name='address_1']";
    public static final String SUSPENDED_RECORD_ADDRESS2 = "#table-duplicate-record-suspended [data-field-name='address_2']";
    public static final String SUSPENDED_RECORD_ADDRESS3 = "#table-duplicate-record-suspended [data-field-name='address_3']";
    public static final String SUSPENDED_RECORD_CITY = "#table-duplicate-record-suspended [data-field-name='address_city']";
    public static final String SUSPENDED_RECORD_STATE = "#table-duplicate-record-suspended [data-field-name='address_state']";
    public static final String SUSPENDED_RECORD_POSTAL_CODE = "#table-duplicate-record-suspended [data-field-name='address_postal_code']";
    public static final String SUSPENDED_RECORD_COUNTRY = "#table-duplicate-record-suspended [data-field-name='address_country']";
    public static final String SUSPENDED_RECORD_PHONE = "#table-duplicate-record-suspended [data-field-name='phone_number']";
    public static final String SUSPENDED_RECORD_DATE_ADDED = "#table-duplicate-record-suspended [data-field-name='created_at']";

    public static final String FIRST_POSSIBLE_MATCH_NAME = "#table-duplicate-record-0 [data-field-name='full_name_with_middle']";
    public static final String FIRST_POSSIBLE_MATCH_PREFERRED_NAME = "#table-duplicate-record-0 [data-field-name='preferred_name']";
    public static final String FIRST_POSSIBLE_MATCH_ROLE = "#table-duplicate-record-0 [data-field-name='person_role_string']";
    public static final String FIRST_POSSIBLE_MATCH_BIRTH_DATE = "#table-duplicate-record-0 [data-field-name='birth_date']";
    public static final String FIRST_POSSIBLE_MATCH_SSN = "#table-duplicate-record-0 [data-field-name='social_security_number']";
    public static final String FIRST_POSSIBLE_MATCH_EMAIL = "#table-duplicate-record-0 [data-field-name='email_address']";
    public static final String FIRST_POSSIBLE_MATCH_ADDRESS1 = "#table-duplicate-record-0 [data-field-name='address_1']";
    public static final String FIRST_POSSIBLE_MATCH_ADDRESS2 = "#table-duplicate-record-0 [data-field-name='address_2']";
    public static final String FIRST_POSSIBLE_MATCH_ADDRESS3 = "#table-duplicate-record-0 [data-field-name='address_3']";
    public static final String FIRST_POSSIBLE_MATCH_CITY = "#table-duplicate-record-0 [data-field-name='address_city']";
    public static final String FIRST_POSSIBLE_MATCH_STATE = "#table-duplicate-record-0 [data-field-name='address_state']";
    public static final String FIRST_POSSIBLE_MATCH_POSTAL_CODE = "#table-duplicate-record-0 [data-field-name='address_postal_code']";
    public static final String FIRST_POSSIBLE_MATCH_COUNTRY = "#table-duplicate-record-0 [data-field-name='address_country']";
    public static final String FIRST_POSSIBLE_MATCH_PHONE = "#table-duplicate-record-0 [data-field-name='phone_number']";
    public static final String FIRST_POSSIBLE_MATCH_DATE_ADDED = "#table-duplicate-record-0 [data-field-name='created_at']";
    public static final String MERGE_DUPLICATES_BUTTON = "#delete-duplicate-record-0";
    public static final String MERGE_AND_GO_BUTTON = "mergeRecordsModalSaveGo";
    public static final String MERGE_AND_CLOSE_BUTTON = "mergeRecordsModalSaveClose";
    public static final String CANCEL_MERGE_BUTTON = "#modalCancelButtonmergeRecords";

    public static final String PREVIEW_MERGE_MATCH_NAME = "#merge-preview [data-field-name='full_name_with_middle']";
    public static final String PREVIEW_MERGE_MATCH_PREFERRED_NAME = "#merge-preview [data-field-name='preferred_name']";
    public static final String PREVIEW_MERGE_MATCH_ROLE = "#merge-preview [data-field-name='person_role_string']";
    public static final String PREVIEW_MERGE_MATCH_BIRTH_DATE = "#merge-preview [data-field-name='birth_date']";
    public static final String PREVIEW_MERGE_MATCH_SSN = "#merge-preview [data-field-name='social_security_number']";
    public static final String PREVIEW_MERGE_MATCH_EMAIL = "#merge-preview [data-field-name='email_address']";
    public static final String PREVIEW_MERGE_MATCH_ADDRESS1 = "#merge-preview [data-field-name='address_1']";
    public static final String PREVIEW_MERGE_MATCH_ADDRESS2 = "#merge-preview [data-field-name='address_2']";
    public static final String PREVIEW_MERGE_MATCH_ADDRESS3 = "#merge-preview [data-field-name='address_3']";
    public static final String PREVIEW_MERGE_MATCH_CITY = "#merge-preview [data-field-name='address_city']";
    public static final String PREVIEW_MERGE_MATCH_STATE = "#merge-preview [data-field-name='address_state']";
    public static final String PREVIEW_MERGE_MATCH_POSTAL_CODE = "#merge-preview [data-field-name='address_postal_code']";
    public static final String PREVIEW_MERGE_MATCH_COUNTRY = "#merge-preview [data-field-name='address_country']";
    public static final String PREVIEW_MERGE_MATCH_PHONE = "#merge-preview [data-field-name='phone_number']";
    public static final String PREVIEW_MERGE_MATCH_DATE_ADDED = "#merge-preview [data-field-name='created_at']";
    public static final String MAKE_SUSPENDED_RECORD_ACTIVE_BUTTON = "make-suspended-record-active";
    public static final String MAKE_SUSPENDED_ACTIVE_MODAL_CONFIRM_CREATE = "modalSubmitButtoncreateUnique";


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
            waitUntilElementToBeSelected(By.cssSelector(CANCEL_MERGE_BUTTON),20);
            scrollToElement(By.cssSelector(PREVIEW_MERGE_MATCH_COUNTRY));
            waitUntilElementToBeSelected(By.id(MERGE_AND_CLOSE_BUTTON),20);
            click(By.id(MERGE_AND_CLOSE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CONFIRM_MERGE_AND_CLOSE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CONFIRM_MERGE_AND_CLOSE_FAIL);
        }
    }

    /*
     * Method to verify content of the preview record
     */
    public static void verifyMergePreview(int person){
        String passMessage = String.format(LogPage.VERIFY_MERGE_PREVIEW_PASS,person);
        String failMessage = String.format(LogPage.VERIFY_MERGE_PREVIEW_FAIL,person);
        wait(1000);
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
    /*
     * Method to verify content of the first possible match record
     */
    public static void verifyContentOfFirstPossibleMatch(int person) {
        String passMessage = String.format(LogPage.VERIFY_CONTENT_OF_FIRST_POSSIBLE_MATCH_PASS,person);
        String failMessage = String.format(LogPage.VERIFY_CONTENT_OF_FIRST_POSSIBLE_MATCH_FAIL,person);
        try {
            if(MainPage.verifyGetText(By.cssSelector(SUSPENDED_RECORD_NAME),mass.get(person).get("FullName"))
                    && MainPage.verifyGetText(By.cssSelector(FIRST_POSSIBLE_MATCH_ROLE),mass.get(person).get("Role1"))
                    && MainPage.verifyGetText(By.cssSelector(FIRST_POSSIBLE_MATCH_EMAIL),mass.get(person).get("EmailAddress"))
                    && MainPage.verifyGetText(By.cssSelector(FIRST_POSSIBLE_MATCH_ADDRESS1),mass.get(person).get("Address1"))
                    && MainPage.verifyGetText(By.cssSelector(FIRST_POSSIBLE_MATCH_CITY),mass.get(person).get("City"))
                    && MainPage.verifyGetText(By.cssSelector(FIRST_POSSIBLE_MATCH_STATE),mass.get(person).get("State"))
                    && MainPage.verifyGetText(By.cssSelector(FIRST_POSSIBLE_MATCH_POSTAL_CODE),mass.get(person).get("PostalCode"))
                    && MainPage.verifyGetText(By.cssSelector(FIRST_POSSIBLE_MATCH_COUNTRY),mass.get(person).get("Country"))
                    && MainPage.verifyGetText(By.cssSelector(FIRST_POSSIBLE_MATCH_PHONE),mass.get(person).get("Phone"))
                    && MainPage.verifyGetText(By.cssSelector(FIRST_POSSIBLE_MATCH_PREFERRED_NAME),mass.get(person).get("PreferredName"))
                    && MainPage.verifyGetText(By.cssSelector(FIRST_POSSIBLE_MATCH_BIRTH_DATE),mass.get(person).get("BirthDate"))
                    && MainPage.verifyGetText(By.cssSelector(FIRST_POSSIBLE_MATCH_SSN),mass.get(person).get("SNN"))
                    && MainPage.verifyGetText(By.cssSelector(FIRST_POSSIBLE_MATCH_ADDRESS2),mass.get(person).get("Address2"))
                    && MainPage.verifyGetText(By.cssSelector(FIRST_POSSIBLE_MATCH_ADDRESS3),mass.get(person).get("Address3"))
                    && MainPage.validateCurrentDateTimeWithoutHour(By.cssSelector(FIRST_POSSIBLE_MATCH_DATE_ADDED),mass.get(person).get("ActualDate"))){
                    ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
