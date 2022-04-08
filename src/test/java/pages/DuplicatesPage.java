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


    public static void searchDuplicateManager(String parameter){
        String passMessage = String.format(LogPage.SEARCH_DUPLICATE_MANAGER_PASS, parameter);
        String failMessage = String.format(LogPage.SEARCH_DUPLICATE_MANAGER_FAIL, parameter);
        try {
            waitElementBy(By.cssSelector(DUPLICATE_MANAGER_TABLE),20);
            write(By.cssSelector(DUPLICATE_MANAGER_SEARCH_FIELD),mass.get(0).get(parameter));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }


    public static void verifyIfRecordNoLongerExistsOnDuplicatesPage(){
        try {
            waitElementBy(By.cssSelector(DUPLICATE_MANAGER_TABLE),20);
            if(!DUPLICATE_MANAGER_TABLE.contains(mass.get(0).get("Fullname"))){
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
    public static void verifyMergePreview(){
        try {
            BasePage.waitElementBy(By.cssSelector(PREVIEW_MERGE_MATCH_NAME), 20);

            String previewRecordNameText = getText(By.cssSelector(PREVIEW_MERGE_MATCH_NAME));
            String previewRecordPreferredNameText = getText(By.cssSelector(PREVIEW_MERGE_MATCH_PREFERRED_NAME));
            String previewRecordRoleText = getText(By.cssSelector(PREVIEW_MERGE_MATCH_ROLE));
            String previewRecordBirthDataText = getText(By.cssSelector(PREVIEW_MERGE_MATCH_BIRTH_DATE));
            String previewRecordSSNText = getText(By.cssSelector(PREVIEW_MERGE_MATCH_SSN));
            String previewRecordEmailText = getText(By.cssSelector(PREVIEW_MERGE_MATCH_EMAIL));
            String previewRecordAddress1Text = getText(By.cssSelector(PREVIEW_MERGE_MATCH_ADDRESS1));
            String previewRecordAddress2Text = getText(By.cssSelector(PREVIEW_MERGE_MATCH_ADDRESS2));
            String previewRecordAddress3Text = getText(By.cssSelector(PREVIEW_MERGE_MATCH_ADDRESS3));
            String previewRecordCityText = getText(By.cssSelector(PREVIEW_MERGE_MATCH_CITY));
            String previewRecordStateText = getText(By.cssSelector(PREVIEW_MERGE_MATCH_STATE));
            String previewRecordPostaCodeText = getText(By.cssSelector(PREVIEW_MERGE_MATCH_POSTAL_CODE));
            String previewRecordCountryText = getText(By.cssSelector(PREVIEW_MERGE_MATCH_COUNTRY));
            String previewRecordPhoneText = getText(By.cssSelector(PREVIEW_MERGE_MATCH_PHONE));
            String previewRecordDateAddedText = getText(By.cssSelector(PREVIEW_MERGE_MATCH_DATE_ADDED));

            boolean validateFields = false;
                if(previewRecordNameText.equals(mass.get(0).get("Fullname"))
                        && previewRecordRoleText.contains(mass.get(0).get("Role2"))
                        && previewRecordRoleText.contains(mass.get(0).get("Role1"))
                        && previewRecordEmailText.equals(mass.get(0).get("EmailAddress"))
                        && previewRecordAddress1Text.equals(mass.get(0).get("Address1"))
                        && previewRecordCityText.equals(mass.get(0).get("City"))
                        && previewRecordStateText.equals(mass.get(0).get("State"))
                        && previewRecordPostaCodeText.equals(mass.get(0).get("PostalCode"))
                        && previewRecordCountryText.equals(mass.get(0).get("Country"))
                        && previewRecordPhoneText.equals(mass.get(0).get("Phone"))){
                    validateFields=true;
                }
                boolean validateEmptyFields = false;
                if(previewRecordPreferredNameText.isEmpty()
                        && previewRecordBirthDataText.isEmpty()
                        && previewRecordSSNText.isEmpty()
                        && previewRecordAddress2Text.isEmpty()
                        && previewRecordAddress3Text.isEmpty()
                        && previewRecordDateAddedText.isEmpty()){
                    validateEmptyFields=true;
                }
                if(validateFields && validateEmptyFields){
                    ExtentReportsSetUp.testingPass(LogPage.VERIFY_MERGE_PREVIEW_PASS);
                }else{
                    FailureDelegatePage.handlePageException(LogPage.VERIFY_MERGE_PREVIEW_FAIL);
                }
                } catch (Exception e) {

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
    public static void verifyContentOfSuspendedRecord(){

        try {
            BasePage.waitElementBy(By.cssSelector(SUSPENDED_RECORD_NAME), 20);
            String suspendedRecordNameText = getText(By.cssSelector(SUSPENDED_RECORD_NAME));
            String suspendedRecordPreferredNameText = getText(By.cssSelector(SUSPENDED_RECORD_PREFERRED_NAME));
            String suspendedRecordRoleText = getText(By.cssSelector(SUSPENDED_RECORD_ROLE));
            String suspendedRecordBirthDataText = getText(By.cssSelector(SUSPENDED_RECORD_BIRTH_DATE));
            String suspendedRecordSSNText = getText(By.cssSelector(SUSPENDED_RECORD_SSN));
            String suspendedRecordEmailText = getText(By.cssSelector(SUSPENDED_RECORD_EMAIL));
            String suspendedRecordAddress1Text = getText(By.cssSelector(SUSPENDED_RECORD_ADDRESS1));
            String suspendedRecordAddress2Text = getText(By.cssSelector(SUSPENDED_RECORD_ADDRESS2));
            String suspendedRecordAddress3Text = getText(By.cssSelector(SUSPENDED_RECORD_ADDRESS3));
            String suspendedRecordCityText = getText(By.cssSelector(SUSPENDED_RECORD_CITY));
            String suspendedRecordStateText = getText(By.cssSelector(SUSPENDED_RECORD_STATE));
            String suspendedRecordPostaCodeText = getText(By.cssSelector(SUSPENDED_RECORD_POSTAL_CODE));
            String suspendedRecordCountryText = getText(By.cssSelector(SUSPENDED_RECORD_COUNTRY));
            String suspendedRecordPhoneText = getText(By.cssSelector(SUSPENDED_RECORD_PHONE));
            String suspendedRecordDateAddedText = getText(By.cssSelector(SUSPENDED_RECORD_DATE_ADDED));

            boolean validateFields = false;
            if(suspendedRecordNameText.equals(mass.get(0).get("Fullname"))
                && suspendedRecordRoleText.contains(mass.get(0).get("Role2"))
                && suspendedRecordRoleText.contains(mass.get(0).get("Role1"))
                && suspendedRecordEmailText.equals(mass.get(0).get("EmailAddress"))
                && suspendedRecordAddress1Text.equals(mass.get(0).get("Address1"))
                && suspendedRecordCityText.equals(mass.get(0).get("City"))
                && suspendedRecordStateText.equals(mass.get(0).get("State"))
                && suspendedRecordPostaCodeText.equals(mass.get(0).get("PostalCode"))
                && suspendedRecordCountryText.equals(mass.get(0).get("Country"))
                && suspendedRecordPhoneText.equals(mass.get(0).get("Phone"))){
                validateFields=true;
                }
            boolean validateEmptyFields = false;
            if(suspendedRecordPreferredNameText.isEmpty()
            && suspendedRecordBirthDataText.isEmpty()
            && suspendedRecordSSNText.isEmpty()
            && suspendedRecordAddress2Text.isEmpty()
            && suspendedRecordAddress3Text.isEmpty()
            && suspendedRecordDateAddedText.isEmpty()){
                validateEmptyFields=true;
            }
            if(validateFields && validateEmptyFields){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_CONTENT_OF_SUSPENDED_RECORD_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_CONTENT_OF_SUSPENDED_RECORD_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_CONTENT_OF_SUSPENDED_RECORD_FAIL);
        }
    }
    /*
     * Method to verify content of the first possible match record
     */
    public static void verifyContentOfFirstPossibleMatch() {
        try {
            BasePage.waitElementBy(By.cssSelector(FIRST_POSSIBLE_MATCH_NAME), 20);
            String firstPossibleRecordNameText = getText(By.cssSelector(SUSPENDED_RECORD_NAME));
            String firstPossibleRecordPreferredNameText = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_PREFERRED_NAME));
            String firstPossibleRecordRoleText = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_ROLE));
            String firstPossibleRecordBirthDataText = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_BIRTH_DATE));
            String firstPossibleRecordSSNText = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_SSN));
            String firstPossibleRecordEmailText = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_EMAIL));
            String firstPossibleRecordAddress1Text = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_ADDRESS1));
            String firstPossibleRecordAddress2Text = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_ADDRESS2));
            String firstPossibleRecordAddress3Text = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_ADDRESS3));
            String firstPossibleRecordCityText = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_CITY));
            String firstPossibleRecordStateText = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_STATE));
            String firstPossibleRecordPostaCodeText = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_POSTAL_CODE));
            String firstPossibleRecordCountryText = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_COUNTRY));
            String firstPossibleRecordPhoneText = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_PHONE));
            String firstPossibleRecordDateAddedText = getText(By.cssSelector(FIRST_POSSIBLE_MATCH_DATE_ADDED));

            boolean validateFields = false;
            if(firstPossibleRecordNameText.equals(mass.get(1).get("Fullname"))
                    && firstPossibleRecordRoleText.contains(mass.get(1).get("Role1"))
                    && firstPossibleRecordEmailText.equals(mass.get(1).get("EmailAddress"))
                    && firstPossibleRecordAddress1Text.equals(mass.get(1).get("Address1"))
                    && firstPossibleRecordCityText.equals(mass.get(1).get("City"))
                    && firstPossibleRecordStateText.equals(mass.get(1).get("State"))
                    && firstPossibleRecordPostaCodeText.equals(mass.get(1).get("PostalCode"))
                    && firstPossibleRecordCountryText.equals(mass.get(1).get("Country"))
                    && firstPossibleRecordPhoneText.equals(mass.get(1).get("Phone"))){
                validateFields=true;
            }
            boolean validateEmptyFields = false;
            if(firstPossibleRecordPreferredNameText.isEmpty()
                    && firstPossibleRecordBirthDataText.isEmpty()
                    && firstPossibleRecordSSNText.isEmpty()
                    && firstPossibleRecordAddress2Text.isEmpty()
                    && firstPossibleRecordAddress3Text.isEmpty()
                    && firstPossibleRecordDateAddedText.isEmpty()){
                validateEmptyFields=true;
            }
            if(validateFields && validateEmptyFields){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_CONTENT_OF_FIRST_POSSIBLE_MATCH_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_CONTENT_OF_FIRST_POSSIBLE_MATCH_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_CONTENT_OF_FIRST_POSSIBLE_MATCH_FAIL);
        }

    }
}
