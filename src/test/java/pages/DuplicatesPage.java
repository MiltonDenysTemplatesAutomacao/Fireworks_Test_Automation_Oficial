package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class DuplicatesPage extends BasePage{

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


    public static void mergeDuplicates(){

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
