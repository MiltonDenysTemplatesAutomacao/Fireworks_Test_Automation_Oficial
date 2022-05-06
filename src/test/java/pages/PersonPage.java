package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class PersonPage extends BasePage{
    public static final String SUMMARY_DISPLAY_EMAIL_EMAIL_ADDRESS = "//*[@for='summaryPanelField_64']";
    public static final String SUMMARY_DISPLAY_PERSON_CLASS_OF = "//*[@for='summaryPanelField_427']";
    public static final String SUMMARY_DISPLAY_PERSON_HIGH_SCORE = "//*[@for='summaryPanelField_406']";
    public static final String SUMMARY_DISPLAY_PERSON_INITIAL_CATEGORY = "//*[@for='summaryPanelField_592']";
    public static final String SUMMARY_DISPLAY_PERSON_INITIAL_SOURCE = "//*[@for='summaryPanelField_593']";
    public static final String SUMMARY_DISPLAY_STUDENT_STATUS_DATE = "//*[@for='summaryPanelField_240']";
    public static final String SUMMARY_EMAIL_EMAIL_ADDRESS_DELETE_BUTTON = "//*[@id='summaryPanelFieldBlock_64']/div[2]/div/div/button";
    public static final String SUMMARY_PERSON_CLASS_OF_DELETE_BUTTON = "//*[@id='summaryPanelFieldBlock_427']/div[2]/div/div/button";
    public static final String SUMMARY_PERSON_HIGH_SCORE_DELETE_BUTTON = "//*[@id='summaryPanelFieldBlock_406']/div[2]/div/div/button";
    public static final String SUMMARY_PERSON_INITIAL_CATEGORY_DELETE_BUTTON = "//*[@id='summaryPanelFieldBlock_592']/div[2]/div/div/button";
    public static final String SUMMARY_PERSON_INITIAL_SOURCE_DELETE_BUTTON = "//*[@id='summaryPanelFieldBlock_593']/div[2]/div/div/button";
    public static final String SUMMARY_STUDENT_STATUS_DATE_DELETE_BUTTON = "//*[@id='summaryPanelFieldBlock_240']/div[2]/div/div/button";
    public static final String SUMMARY_FIELD_DROPDOWN = "s2id_summaryFieldPickerEntityType1";
    public static final String SUMMARY_FIELD_DROPDOWN_LIST = "#select2-results-2";
    public static final String COMPOSER_FIRST_NAME_FIELD = "person_name_0_createPersonNameFirst";
    public static final String COMPOSER_LAST_NAME_FIELD =  "person_name_0_createPersonNameLast";
    public static final String COMPOSER_EMAIL_ADDRESS_FIELD = "entity_email_0_createPersonEmailAddress";
    public static final String COMPOSER_EMAIL_TYPE_DROPDOWN = "entity_email_0_createPersonEmailType_component";
    public static final String COMPOSER_EMAIL_TYPE_DROPDOWN_LIST = "entity_email_0_createPersonEmailType_dropdown_menu";
    public static final String COMPOSER_EMAIL_OPT_IN_METHOD_DROPDOWN = "entity_email_0_createPersonOptInMethod_component";
    public static final String COMPOSER_EMAIL_OPT_IN_METHOD_DROPDOWN_LIST = "entity_email_0_createPersonOptInMethod_dropdown_menu";
    public static final String COMPOSER_PHONE_NUMBER_FIELD = "entity_phone_0_createPersonPhoneNumber";
    public static final String COMPOSER_PHONE_TYPE_DROPDOWN = "entity_phone_0_createPersonPhoneType_component";
    public static final String COMPOSER_PHONE_TYPE_DROPDOWN_LIST = "entity_phone_0_createPersonPhoneType_dropdown_menu";
    public static final String COMPOSER_ADDRESS1_FIELD = "entity_address_0_createPersonAddress1";
    public static final String COMPOSER_ADDRESS2_FIELD = "entity_address_0_createPersonAddress2";
    public static final String COMPOSER_ADDRESS3_FIELD = "entity_address_0_createPersonAddress3";
    public static final String COMPOSER_ADDRESS4_FIELD = "entity_address_0_createPersonAddress4";
    public static final String COMPOSER_ADDRESS_CITY_FIELD = "entity_address_0_createPersonAddressCity";
    public static final String COMPOSER_ADDRESS_STATE_DROPDOWN = "entity_address_0_createPersonAddressState_component";
    public static final String COMPOSER_ADDRESS_STATE_DROPDOWN_LIST = "entity_address_0_createPersonAddressState_dropdown_menu";
    public static final String COMPOSER_ADDRESS_POSTAL_CODE_FIELD = "entity_address_0_createPersonAddressPostalCode";
    public static final String COMPOSER_ADDRESS_COUNTRY_DROPDOWN = "entity_address_0_createPersonAddressCountry_component";
    public static final String COMPOSER_ADDRESS_COUNTRY_DROPDOWN_LIST = "entity_address_0_createPersonAddressCountry_dropdown_menu";
    public static final String COMPOSER_ADDRESS_REGION_FIELD = "entity_address_0_createPersonAddressRegion";
    public static final String COMPOSER_ROLE_DROPDOWN = "createPersonPersonRole_component";
    public static final String COMPOSER_ROLE_DROPDOWN_LIST = "createPersonPersonRole_dropdown_menu";
    public static final String COMPOSER_STUDENT_TYPE_DROPDOWN = "createPersonStudentType_component";
    public static final String COMPOSER_STUDENT_TYPE_DROPDOWN_LIST = "createPersonStudentType_dropdown_menu";
    public static final String COMPOSER_STUDENT_STATUS_CATEGORY_DROPDOWN = "person_student_status_0_createPersonStudentStatusCategory_component";
    public static final String COMPOSER_STUDENT_STATUS_CATEGORY_DROPDOWN_LIST = "person_student_status_0_createPersonStudentStatusCategory_dropdown_menu";
    public static final String COMPOSER_STUDENT_STATUS_DROPDOWN = "person_student_status_0_createPersonStudentStatus_component";
    public static final String COMPOSER_STUDENT_STATUS_DROPDOWN_LIST = "person_student_status_0_createPersonStudentStatus_dropdown_menu";
    public static final String COMPOSER_STUDENT_STATUS_DATE_FIELD = "person_student_status_0_createPersonStudentStatusDate";
    public static final String COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN = "person_student_status_0_createPersonStatusEntryTerm_component";
    public static final String COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN_LIST = "person_student_status_0_createPersonStatusEntryTerm_dropdown_menu";
    public static final String HEADER_DELETE_BUTTON = "personHeaderDeleteButton";
    public static final String DELETE_PERSON_CONFIRM_MODAL_LABEL = "deletePersonConfirmModalLabel";
    public static final String DELETE_PERSON_CONFIRM_SUBMIT_BUTTON = "modalSubmitButtondeletePersonConfirm";
    public static final String DATATABLE_EMPTY = "peopleManagerTable_row_0_col_0";
    public static final String QUICK_SEARCH_EMPTY = "quickSearchManagerTable_row_0_col_0";
    public static final String HEADER_STUDENT_STATUS_DISPLAY = "#descriptionObjectStudentStatusLabel";
    public static final String HEADER_ENTRY_TERM_DISPLAY = "#descriptionObjectEntryTermLabel";
    private static final String RECORD_NAV_TAB_BASIC = "recordNavTab_basic";
    private static final String RECORD_NAV_TAB_ID_TYPES = "recordNavTab_id_types";
    private static final String CITIZENSHIP_TYPE_DROPDOWN = "#s2id_citizenship_type";
    private static final String CITIZENSHIP_TYPE_DROPDOWN_LIST = "#select2-results-21";
    private static final String CITIZENSHIP_COUNTRY_DROPDOWN = "#s2id_country_of_citizenship";
    private static final String CITIZENSHIP_COUNTRY_DROPDOWN_LIST = "#select2-results-22";
    private static final String SOCIAL_SECURITY_NUMBER_FIELD = "#social_security_number";
    private static final String PERSON_BASIC_SAVE_CHANGES_BUTTON = "saveChangesBtnPersonBasic";
    private static final String FIRST_NAME_FIELD = "person_name_0_name_first";
    private static final String LAST_NAME_FIELD = "person_name_0_name_last";
    private static final String MIDDLE_NAME_FIELD = "person_name_0_name_middle";
    private static final String PREFERRED_NAME_FIELD = "person_name_0_preferred_name";
    private static final String SUFFIX_DROPDOWN = "#person_name_0_name_suffix_toggle";
    private static final String SUFFIX_DROPDOWN_LIST = "#person_name_0_name_suffix_dropdown_menu";
    private static final String SALUTATION_DROPDOWN = "#person_name_0_salutation_toggle";
    private static final String SALUTATION_DROPDOWN_LIST = "#person_name_0_salutation_dropdown_menu";
    private static final String SAVE_CHANGES_BTN_PERSON_CONTACT = "saveChangesBtnPersonContact";
    private static final String TYPE_DROPDOWN = "#s2id_entity_external_id_0_id_type";
    private static final String TYPE_DROPDOWN_LIST = "#select2-drop";
    private static final String ID_NUMBER_FIELD = "#entity_external_id_0_id_number";
    private static final String ID_RECORDED_DATE_FIELD = "#entity_external_id_0_id_date";
    private static final String WHO_ADDED_ID_DROPDOWN = "#s2id_entity_external_id_0_id_user";
    private static final String WHO_ADDED_ID_DROPDOWN_LIST = "#select2-drop";
    private static final String COMMENTS_FIELD = "#entity_external_id_0_id_comments";
    private static final String PLUS_BUTTON_EXTERNAL_ID = "//*[@id='entity_external_id_0_add']";
    private static final String SAVE_CHANGES_BTN_PERSON_ID_TYPES = "saveChangesBtnPersonIdTypes";
    private static final String HEADER_ROLE_ELEMENT = "#personHeaderRoleButton";
    private static final String HEADER_ROLE_ELEMENT_LIST = ".//*[@class='btn-group autoSubmit dropDownSelect open']//*[@class='dropdown-menu']";
    private static final String HEADER_STUDENT_TYPE_ELEMENT = "#personHeaderStudentTypeButton";
    private static final String HEADER_ASSIGNED_STAFF_ELEMENT = "#personHeaderAssignedStaffButton";
    private static final String SUMMARY_LABEL = "recordNavTab_summary";
    private static final String ACTIONS_LABEL = "recordNavTab_actions";
    private static final String BASIC_LABEL = "recordNavTab_basic";
    private static final String CONTACT_LABEL = "recordNavTab_contact";
    private static final String CUSTOM_FIELDS_LABEL = "recordNavTab_custom";
    private static final String EMPLOYMENT_LABEL = "recordNavTab_employment";
    private static final String ID_TYPES_LABEL = "recordNavTab_summary";
    private static final String RELATIONSHIP_LABEL = "recordNavTab_summary";
    private static final String INTERESTS_ACTIVITIES_LABEL = "recordNavTab_summary";
    private static final String APPLICATIONS_LABEL = "recordNavTab_summary";
    private static final String EDUCATION_LABEL = "recordNavTab_summary";
    private static final String INTERVIEWS_LABEL = "recordNavTab_summary";
    private static final String STUDENT_STATUS_LABEL = "recordNavTab_summary";
    private static final String DOCUMENTS_LABEL = "recordNavTab_summary";
    private static final String PEOPLE_MANAGER_TABLE = "#peopleManagerTable";
    private static final String PEOPLE_MANAGER_TABLE_SEARCH_FIELD = "#peopleManagerTableControlsTableSearch";
    private static final String PEOPLE_MANAGER_TABLE_ROW1_COL1_LINK = "#peopleManagerTable_row_0_col_0_link_0";
    private static final String HEADER_ROLE_DROPDOWN_OPTION3 = "div.btn-group.autoSubmit.dropDownSelect.open > ul > li:nth-child(3)";
    private static final String HEADER_ROLE_DROPDOWN_OPTION3_ACTIVE = "div.btn-group.autoSubmit.dropDownSelect.open > ul > li:nth-child(3).active";
    private static final String HEADER_ROLE_DROPDOWN_OPTION8 = "div.btn-group.autoSubmit.dropDownSelect.open > ul > li:nth-child(8)";
    private static final String HEADER_ROLE_DROPDOWN_OPTION8_ACTIVE = "div.btn-group.autoSubmit.dropDownSelect.open > ul > li:nth-child(8).active";
    private static final String HEADER_ROLE_DROPDOWN_OPTION9 = "div.btn-group.autoSubmit.dropDownSelect.open > ul > li:nth-child(9)";
    private static final String HEADER_ROLE_DROPDOWN_OPTION9_ACTIVE = "div.btn-group.autoSubmit.dropDownSelect.open > ul > li:nth-child(9).active";
    private static final String CREATE_PERSON_BUTTON = "top-controls-create-new-person";
    private static final String COMPOSER_SAVE_CHANGES_BUTTON = "saveChangesBtnPersonCreate";

    public static String deleteSummaryList(String summary) {
        HashMap<String, String> deleteSummaryItem = new HashMap<>();
        deleteSummaryItem.put("Email Address", SUMMARY_EMAIL_EMAIL_ADDRESS_DELETE_BUTTON);
        deleteSummaryItem.put("Class Of", SUMMARY_PERSON_CLASS_OF_DELETE_BUTTON);
        deleteSummaryItem.put("High Score", SUMMARY_PERSON_HIGH_SCORE_DELETE_BUTTON);
        deleteSummaryItem.put("Initial Category", SUMMARY_PERSON_INITIAL_CATEGORY_DELETE_BUTTON);
        deleteSummaryItem.put("Initial Source", SUMMARY_PERSON_INITIAL_SOURCE_DELETE_BUTTON);
        deleteSummaryItem.put("Student Status Date", SUMMARY_STUDENT_STATUS_DATE_DELETE_BUTTON);
        return deleteSummaryItem.get(summary);

    }

    public static void deleteSummaryFields(String deleteSummaryField){
        String passMessage = String.format(LogPage.DELETE_SUMMARY_FIELDS_PASS, deleteSummaryField);
        String failMessage = String.format(LogPage.DELETE_SUMMARY_FIELDS_FAIL, deleteSummaryField);
        try {
            scrollToElement(By.id(SUMMARY_LABEL));
            waitUntilElementToBeSelected(By.xpath(deleteSummaryList(deleteSummaryField)),20);
            click(By.xpath(deleteSummaryList(deleteSummaryField)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static String summaryList(String summary){
        HashMap<String,String> summaryItem = new HashMap<>();
        summaryItem.put("Email Address",SUMMARY_DISPLAY_EMAIL_EMAIL_ADDRESS);
        summaryItem.put("Class Of",SUMMARY_DISPLAY_PERSON_CLASS_OF);
        summaryItem.put("High Score",SUMMARY_DISPLAY_PERSON_HIGH_SCORE);
        summaryItem.put("Initial Category",SUMMARY_DISPLAY_PERSON_INITIAL_CATEGORY);
        summaryItem.put("Initial Source",SUMMARY_DISPLAY_PERSON_INITIAL_SOURCE);
        summaryItem.put("Student Status Date",SUMMARY_DISPLAY_STUDENT_STATUS_DATE);
        return summaryItem.get(summary);

    }
    public static void verifySummaryData(String summaryData){
        String passMessage = String.format(LogPage.VERIFY_SUMMARY_DATA_PASS, summaryData);
        String failMessage = String.format(LogPage.VERIFY_SUMMARY_DATA_FAIL, summaryData);

        try {
            waitElementBy(By.xpath(summaryList(summaryData)),20);
            String summaryText = getText(By.xpath(summaryList(summaryData)));
            if(summaryText.contains(summaryData)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }

    }

    public static void addSummaryField(String summary){
        String passMessage = String.format(LogPage.ADD_SUMMARY_FIELD_PASS, summary);
        String failMessage = String.format(LogPage.ADD_SUMMARY_FIELD_FAIL, summary);
        try {
            waitUntilElementToBeSelected(By.id(SUMMARY_FIELD_DROPDOWN),20);
            click(By.id(SUMMARY_FIELD_DROPDOWN));
            waitElementBy(By.cssSelector(SUMMARY_FIELD_DROPDOWN_LIST),20);
            BasePage.selectElementsList(By.cssSelector(SUMMARY_FIELD_DROPDOWN_LIST), "a");
            clickOnListOfElements(summary);
            wait(500);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyStudentStatusLabel(String studentStatusLabel){
        String passMessage = String.format(LogPage.VERIFY_STUDENT_STATUS_LABEL_PASS, studentStatusLabel);
        String failMessage = String.format(LogPage.VERIFY_STUDENT_STATUS_LABEL_FAIL, studentStatusLabel);
        try {
            waitUntilElementPresence(By.cssSelector(HEADER_STUDENT_STATUS_DISPLAY),20);
            String studentStatusLabelText = getText(By.cssSelector(HEADER_STUDENT_STATUS_DISPLAY));
            if(studentStatusLabelText.contains(studentStatusLabel)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyEntryTermLabel(String entryTermLabel){
        String passMessage = String.format(LogPage.VERIFY_ENTRY_TERM_LABEL_PASS, entryTermLabel);
        String failMessage = String.format(LogPage.VERIFY_ENTRY_TERM_LABEL_FAIL, entryTermLabel);
        try {
            waitUntilElementPresence(By.cssSelector(HEADER_ENTRY_TERM_DISPLAY),20);
            String entryTermLabelText = getText(By.cssSelector(HEADER_ENTRY_TERM_DISPLAY));
            if(entryTermLabelText.contains(entryTermLabel)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateHeaderRole(String role){
        String errorMessage = String.format(LogPage.UPDATE_HEADER_ROLE_FAIL, role);
        String passMessage = String.format(LogPage.UPDATE_HEADER_ROLE_PASS, role);
        try {
            click(By.cssSelector(HEADER_ROLE_ELEMENT));
            BasePage.selectElementsList(By.xpath(HEADER_ROLE_ELEMENT_LIST), "a");
            clickOnListOfElements(role);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void validateQuickSearchEmpty(String message){
        String errorMessage = String.format(LogPage.VALIDATE_QUICK_SEARCH_EMPTY_FAIL, message);
        String passMessage = String.format(LogPage.VALIDATE_QUICK_SEARCH_EMPTY_PASS, message);
        try {
            wait(2000);
            String messageQuickSearchEmpty = getText(By.id(QUICK_SEARCH_EMPTY));
            if(messageQuickSearchEmpty.equals(message)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void validateDatatableMessage(String message){
        String errorMessage = String.format(LogPage.VALIDATE_DATATABLE_MESSAGE_FAIL, message);
        String passMessage = String.format(LogPage.VALIDATE_DATATABLE_MESSAGE_PASS, message);
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

    public static void deletePerson(){
        try {
            waitUntilElementToBeSelected(By.id(HEADER_DELETE_BUTTON),20);
            click(By.id(HEADER_DELETE_BUTTON));
            waitUntilElementToBeSelected(By.id(DELETE_PERSON_CONFIRM_MODAL_LABEL),20);
            click(By.id(DELETE_PERSON_CONFIRM_SUBMIT_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.DELETE_PERSON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.DELETE_PERSON_FAIL);
        }
    }

    public static void updatePeopleComposer(DataTable data){
        try {
            mass = data.asMaps(String.class, String.class);
            if (mass.get(0).get("FirstName") != null) {
                BasePage.write(By.id(COMPOSER_FIRST_NAME_FIELD), mass.get(0).get("Firstname"));
            }
            if (mass.get(0).get("LastName") != null) {
                BasePage.write(By.id(COMPOSER_LAST_NAME_FIELD), mass.get(0).get("Lastname"));
            }
            if (mass.get(0).get("EmailAddress") != null) {
                BasePage.write(By.id(COMPOSER_EMAIL_ADDRESS_FIELD), mass.get(0).get("EmailAddress"));
            }
            if (mass.get(0).get("EmailType") != null) {
                BasePage.click(By.id(COMPOSER_EMAIL_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_EMAIL_TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("EmailType"));
            }
            scrollToElement(By.id(COMPOSER_EMAIL_ADDRESS_FIELD));
            if (mass.get(0).get("EmailOptInMethod") != null) {
                BasePage.click(By.id(COMPOSER_EMAIL_OPT_IN_METHOD_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_EMAIL_OPT_IN_METHOD_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("EmailOptInMethod"));
            }
            if (mass.get(0).get("Phone") != null) {
                BasePage.write(By.id(COMPOSER_PHONE_NUMBER_FIELD), mass.get(0).get("Phone"));
            }
            if (mass.get(0).get("PhoneType") != null) {
                BasePage.click(By.id(COMPOSER_PHONE_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_PHONE_TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("PhoneType"));
            }
            scrollToElement(By.id(COMPOSER_PHONE_TYPE_DROPDOWN));
            if (mass.get(0).get("Address1") != null) {
                BasePage.write(By.id(COMPOSER_ADDRESS1_FIELD), mass.get(0).get("Address1"));
            }
            if (mass.get(0).get("Address2") != null) {
                BasePage.write(By.id(COMPOSER_ADDRESS2_FIELD), mass.get(0).get("Address2"));
            }
            if (mass.get(0).get("Address3") != null) {
                BasePage.write(By.id(COMPOSER_ADDRESS3_FIELD), mass.get(0).get("Address3"));
            }
            if (mass.get(0).get("Address4") != null) {
                BasePage.write(By.id(COMPOSER_ADDRESS4_FIELD), mass.get(0).get("Address4"));
            }
            if (mass.get(0).get("City") != null) {
                BasePage.write(By.id(COMPOSER_ADDRESS_CITY_FIELD), mass.get(0).get("City"));
            }
            if (mass.get(0).get("State") != null) {
                BasePage.click(By.id(COMPOSER_ADDRESS_STATE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_ADDRESS_STATE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("State"));
            }
            if (mass.get(0).get("PostalCode") != null) {
                BasePage.write(By.id(COMPOSER_ADDRESS_POSTAL_CODE_FIELD), mass.get(0).get("PostalCode"));
            }
            if (mass.get(0).get("Country") != null) {
                BasePage.click(By.id(COMPOSER_ADDRESS_COUNTRY_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_ADDRESS_COUNTRY_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Country"));
            }
            if (mass.get(0).get("Region") != null) {
                BasePage.write(By.id(COMPOSER_ADDRESS_REGION_FIELD), mass.get(0).get("Region"));
            }
            scrollToElement(By.id(COMPOSER_ADDRESS_CITY_FIELD));
            if (mass.get(0).get("Role1") != null) {
                waitElementBy(By.id(COMPOSER_ROLE_DROPDOWN),20);
                BasePage.click(By.id(COMPOSER_ROLE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_ROLE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Role1"));
            }
            if (mass.get(0).get("Role2") != null) {
                BasePage.click(By.id(COMPOSER_ROLE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_ROLE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Role2"));
            }
            if (mass.get(0).get("Role3") != null) {
                BasePage.click(By.id(COMPOSER_ROLE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_ROLE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Role3"));
            }
            if (mass.get(0).get("StudentType") != null) {
                waitElementBy(By.id(COMPOSER_STUDENT_TYPE_DROPDOWN),20);
                BasePage.click(By.id(COMPOSER_STUDENT_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_STUDENT_TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("StudentType"));
            }
            if (mass.get(0).get("StudentStatusCategory") != null) {
                BasePage.click(By.id(COMPOSER_STUDENT_STATUS_CATEGORY_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_STUDENT_STATUS_CATEGORY_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("StudentStatusCategory"));
            }
            if (mass.get(0).get("StudentStatus") != null) {
                BasePage.click(By.id(COMPOSER_STUDENT_STATUS_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_STUDENT_STATUS_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("StudentStatus"));
            }
            if (mass.get(0).get("StudentStatusDate") != null) {
                BasePage.write(By.id(COMPOSER_STUDENT_STATUS_DATE_FIELD), mass.get(0).get("StudentStatusDate"));
            }
            if (mass.get(0).get("EntryTerm") != null) {
                waitElementBy(By.id(COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN),20);
                BasePage.click(By.id(COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("EntryTerm"));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_PEOPLE_COMPOSER_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_PEOPLE_COMPOSER_FAIL);
        }
    }

    public static void clickOnSaveNewRecord(){
        try {
            waitUntilElementToBeSelected(By.id(COMPOSER_SAVE_CHANGES_BUTTON),20);
            scrollToElement(By.id(COMPOSER_SAVE_CHANGES_BUTTON));
            click(By.id(COMPOSER_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_ON_SAVE_NEW_RECORD_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_ON_SAVE_NEW_RECORD_FAIL);
        }
    }

    public static void clickOnCreateRecord(){
        try {
            waitUntilElementToBeSelected(By.id(CREATE_PERSON_BUTTON),20);
            click(By.id(CREATE_PERSON_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_ON_CREATE_RECORD_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_ON_CREATE_RECORD_FAIL);
        }
    }

    public static void verifyAllthreeRolesAreSelected(){
        try {
            waitElementBy(By.cssSelector(HEADER_ROLE_ELEMENT),20);
            click(By.cssSelector(HEADER_ROLE_ELEMENT));

            String roleDropdown3 = getText(By.cssSelector(HEADER_ROLE_DROPDOWN_OPTION3));
            String roleDropdown3Active = getText(By.cssSelector(HEADER_ROLE_DROPDOWN_OPTION3_ACTIVE));
            boolean role1Person2Validation = false;
            if(roleDropdown3.equals(mass.get(1).get("Role1")) && roleDropdown3Active.equals(mass.get(1).get("Role1"))){
                role1Person2Validation=true;
            }
            String roleDropdown8 = getText(By.cssSelector(HEADER_ROLE_DROPDOWN_OPTION8));
            String roleDropdown8Active = getText(By.cssSelector(HEADER_ROLE_DROPDOWN_OPTION8_ACTIVE));
            boolean role1Person1Validation = false;
            if(roleDropdown8.equals(mass.get(0).get("Role1")) && roleDropdown8Active.equals(mass.get(0).get("Role1"))){
                role1Person1Validation=true;
            }
            String roleDropdown9 = getText(By.cssSelector(HEADER_ROLE_DROPDOWN_OPTION9));
            String roleDropdown9Active = getText(By.cssSelector(HEADER_ROLE_DROPDOWN_OPTION9_ACTIVE));
            boolean role2Person1Validation = false;
            if(roleDropdown9.equals(mass.get(0).get("Role2")) && roleDropdown9Active.equals(mass.get(0).get("Role2"))){
                role2Person1Validation=true;
            }

            if(role1Person2Validation && role1Person1Validation && role2Person1Validation){
                click(By.cssSelector(HEADER_ROLE_ELEMENT));
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_ALL_THREE_ROLES_ARE_SELECTED_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_ALL_THREE_ROLES_ARE_SELECTED_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_ALL_THREE_ROLES_ARE_SELECTED_FAIL);
        }
    }

    public static void openPeopleRecord(String search){
        searchPeopleManager(search);
        String passMessage = String.format(LogPage.OPEN_PEOPLE_RECORD_PASS, search);
        String failMessage = String.format(LogPage.OPEN_PEOPLE_RECORD_FAIL, search);
        try {
            waitElementBy(By.cssSelector(PEOPLE_MANAGER_TABLE_ROW1_COL1_LINK),20);
            click(By.cssSelector(PEOPLE_MANAGER_TABLE_ROW1_COL1_LINK));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void searchPeopleManager(String search){
        String passMessage = String.format(LogPage.SEARCH_PEOPLE_MANAGER_PASS, search);
        String failMessage = String.format(LogPage.SEARCH_PEOPLE_MANAGER_FAIL, search);
        try {
            waitElementBy(By.cssSelector(PEOPLE_MANAGER_TABLE),20);
            write(By.cssSelector(PEOPLE_MANAGER_TABLE_SEARCH_FIELD),search);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void verifyStudentRecordPanels(){
        try {
            waitUntilElementPresence(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT),20);
            String labelsText = getText(By.xpath(".//*[@class='nav nav-pills nav-stacked stickyNavPanels']"));

            if(labelsText.contains(mass.get(0).get("Labels"))
                && labelsText.contains(mass.get(1).get("Labels"))
                && labelsText.contains(mass.get(2).get("Labels"))
                && labelsText.contains(mass.get(3).get("Labels"))
                && labelsText.contains(mass.get(4).get("Labels"))
                && labelsText.contains(mass.get(5).get("Labels"))
                && labelsText.contains(mass.get(6).get("Labels"))
                && labelsText.contains(mass.get(7).get("Labels"))
                && labelsText.contains(mass.get(8).get("Labels"))
                && labelsText.contains(mass.get(9).get("Labels"))
                && labelsText.contains(mass.get(10).get("Labels"))
                && labelsText.contains(mass.get(11).get("Labels"))
                && labelsText.contains(mass.get(12).get("Labels"))
                && labelsText.contains(mass.get(13).get("Labels"))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_RECORD_PANELS_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_RECORD_PANELS_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_RECORD_PANELS_FAIL);
        }
    }
    public static void verifyHeaderAssignedStaff(String assignedStaff){
        String passMessage = String.format(LogPage.VERIFY_HEADER_ASSIGNED_STAFF_PASS, assignedStaff);
        String failMessage = String.format(LogPage.VERIFY_HEADER_ASSIGNED_STAFF_FAIL, assignedStaff);
        try {
            waitUntilElementPresence(By.cssSelector(HEADER_ASSIGNED_STAFF_ELEMENT),20);
            String assignedStaffText = getText(By.cssSelector(HEADER_ASSIGNED_STAFF_ELEMENT));
            if(assignedStaffText.contains(assignedStaff)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void verifyStudentType(String studentType){
        try {
            waitUntilElementPresence(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT),20);
            String studentTypeText = getText(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT));
            if(studentTypeText.contains(studentType)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_STUDENT_TYPE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_STUDENT_TYPE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_STUDENT_TYPE_FAIL);
        }

    }

    public static void verifyHeaderRole(String headerRole){
        String passMessage = String.format(LogPage.VERIFY_HEADER_ROLE_PASS, headerRole);
        String failMessage = String.format(LogPage.VERIFY_HEADER_ROLE_FAIL, headerRole);

        try {
            waitUntilElementPresence(By.cssSelector(HEADER_ROLE_ELEMENT),20);
            switch (headerRole){
                case "Student":
                    String studentType = getText(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT));
                    String assignedStaff = getText(By.cssSelector(HEADER_ASSIGNED_STAFF_ELEMENT));
                    if(studentType.contains("Student Type")&& assignedStaff.contains("Assigned Staff")){
                        ExtentReportsSetUp.testingPass(passMessage);
                    }
                    break;
                case "Multiple":
                    String roleElement = getText(By.cssSelector(HEADER_ROLE_ELEMENT));
                    if(roleElement.contains(headerRole)){
                        ExtentReportsSetUp.testingPass(passMessage);
                    }
                    break;
                default:
                    List<WebElement> headerStudent = findElements(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT));
                    List<WebElement> headerStaff = findElements(By.cssSelector(HEADER_ASSIGNED_STAFF_ELEMENT));
                    if(headerStudent.isEmpty()&&headerStaff.isEmpty()){
                        ExtentReportsSetUp.testingPass(passMessage);
                    }
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void navigateToBasic(){
        try {
            BasePage.click(By.id(RECORD_NAV_TAB_BASIC));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_BASIC_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_BASIC_FAIL);
        }
    }

    public static void navigateToIdTypes(){
        try {
            scrollToElement(By.id(SUMMARY_LABEL));
            waitUntilElementToBeSelected(By.id(RECORD_NAV_TAB_ID_TYPES),20);
            BasePage.click(By.id(RECORD_NAV_TAB_ID_TYPES));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_ID_TYPES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_ID_TYPES_FAIL);
        }
    }

    public static void updateCitizenshipValues(String citizenshipType,String countryOfCitizenship,String ssn){
        try {
            waitElementBy(By.cssSelector(CITIZENSHIP_TYPE_DROPDOWN),20);
            if (mass.get(0).get(citizenshipType) != null) {
                BasePage.click(By.cssSelector(CITIZENSHIP_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(CITIZENSHIP_TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(citizenshipType));
            }
            if (mass.get(0).get(countryOfCitizenship) != null) {
                BasePage.click(By.cssSelector(CITIZENSHIP_COUNTRY_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(CITIZENSHIP_COUNTRY_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(countryOfCitizenship));
            }
            if (mass.get(0).get(ssn) != null) {
                BasePage.write(By.cssSelector(SOCIAL_SECURITY_NUMBER_FIELD), mass.get(0).get(ssn));
            }
            saveChangesBtnPersonBasic();
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_CITIZENSHIP_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_CITIZENSHIP_FAIL);
        }
    }
    /*
     * to update names values values in contact tab on records
     */
    public static void updateNameValues(String firstName,String lastName,String middleName,String preferredName, String suffix, String salutation){
        try {
            waitElementBy(By.id(FIRST_NAME_FIELD),20);
            if (mass.get(0).get(firstName) != null) {
                BasePage.write(By.id(FIRST_NAME_FIELD), mass.get(0).get(firstName));
            }
            if (mass.get(0).get(lastName) != null) {
                BasePage.write(By.id(LAST_NAME_FIELD), mass.get(0).get(lastName));
            }
            if (mass.get(0).get(middleName) != null) {
                BasePage.write(By.id(MIDDLE_NAME_FIELD), mass.get(0).get(middleName));
            }
            if (mass.get(0).get(preferredName) != null) {
                BasePage.write(By.id(PREFERRED_NAME_FIELD), mass.get(0).get(preferredName));
            }
            if (mass.get(0).get(suffix) != null) {
                BasePage.click(By.cssSelector(SUFFIX_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(SUFFIX_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(suffix));
            }
            if (mass.get(0).get(salutation) != null) {
                BasePage.click(By.cssSelector(SALUTATION_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(SALUTATION_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(salutation));
            }
            saveChangesBtnPersonContact();
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_NAME_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_NAME_FAIL);
        }
    }
    /*
     * to update Id Types in contact tab on records
     */
    public static void updateExternalIdTypes(String type,String idNumber,String idRecordedDate,String whoAddedId, String comments){
        try {
            waitElementBy(By.cssSelector(TYPE_DROPDOWN),20);
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

    public static void saveChangesBtnPersonBasic(){
        try {
            waitElementBy(By.id(PERSON_BASIC_SAVE_CHANGES_BUTTON),20);
            BasePage.scrollToElement(By.id(PERSON_BASIC_SAVE_CHANGES_BUTTON));
            BasePage.click(By.id(PERSON_BASIC_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }

    public static void saveChangesBtnPersonContact(){
        try {
            waitElementBy(By.id(SAVE_CHANGES_BTN_PERSON_CONTACT),20);
            BasePage.scrollToElement(By.id(SAVE_CHANGES_BTN_PERSON_CONTACT));
            BasePage.click(By.id(SAVE_CHANGES_BTN_PERSON_CONTACT));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }

    public static void saveChangesBtnPersonIdTypes(){
        try {
            waitElementBy(By.id(SAVE_CHANGES_BTN_PERSON_ID_TYPES),20);
            BasePage.scrollToElement(By.id(SAVE_CHANGES_BTN_PERSON_ID_TYPES));
            BasePage.click(By.id(SAVE_CHANGES_BTN_PERSON_ID_TYPES));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
}
