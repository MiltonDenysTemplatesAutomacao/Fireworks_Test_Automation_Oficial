package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class PersonPage extends BasePage{
    public static final String SELECT_DROP = "#select2-drop";
    public static final String SUMMARY_LABEL = "recordNavTab_summary";
    public static final String SUMMARY_DISPLAY_EMAIL_ADDRESS = "//*[@for='summaryPanelField_64']";
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
    private static final String SUMMARY_FIELD_DROPDOWN = "s2id_summaryFieldPickerEntityType1";
    private static final String SUMMARY_FIELD_DROPDOWN_LIST = "#select2-results-2";
    private static final String COMPOSER_FIRST_NAME_FIELD = "person_name_0_createPersonNameFirst";
    private static final String COMPOSER_LAST_NAME_FIELD =  "person_name_0_createPersonNameLast";
    private static final String COMPOSER_EMAIL_ADDRESS_FIELD = "entity_email_0_createPersonEmailAddress";
    private static final String COMPOSER_EMAIL_TYPE_DROPDOWN = "entity_email_0_createPersonEmailType_component";
    private static final String COMPOSER_EMAIL_TYPE_DROPDOWN_LIST = "entity_email_0_createPersonEmailType_dropdown_menu";
    private static final String COMPOSER_EMAIL_OPT_IN_METHOD_DROPDOWN = "entity_email_0_createPersonOptInMethod_component";
    private static final String COMPOSER_EMAIL_OPT_IN_METHOD_DROPDOWN_LIST = "entity_email_0_createPersonOptInMethod_dropdown_menu";
    private static final String COMPOSER_PHONE_NUMBER_FIELD = "entity_phone_0_createPersonPhoneNumber";
    private static final String COMPOSER_PHONE_TYPE_DROPDOWN = "entity_phone_0_createPersonPhoneType_component";
    private static final String COMPOSER_PHONE_TYPE_DROPDOWN_LIST = "entity_phone_0_createPersonPhoneType_dropdown_menu";
    private static final String COMPOSER_ADDRESS1_FIELD = "entity_address_0_createPersonAddress1";
    private static final String COMPOSER_ADDRESS2_FIELD = "entity_address_0_createPersonAddress2";
    private static final String COMPOSER_ADDRESS3_FIELD = "entity_address_0_createPersonAddress3";
    private static final String COMPOSER_ADDRESS4_FIELD = "entity_address_0_createPersonAddress4";
    private static final String COMPOSER_ADDRESS_CITY_FIELD = "entity_address_0_createPersonAddressCity";
    private static final String COMPOSER_ADDRESS_STATE_DROPDOWN = "entity_address_0_createPersonAddressState_component";
    private static final String COMPOSER_ADDRESS_STATE_DROPDOWN_LIST = "entity_address_0_createPersonAddressState_dropdown_menu";
    private static final String COMPOSER_ADDRESS_POSTAL_CODE_FIELD = "entity_address_0_createPersonAddressPostalCode";
    private static final String COMPOSER_ADDRESS_COUNTRY_DROPDOWN = "entity_address_0_createPersonAddressCountry_component";
    private static final String COMPOSER_ADDRESS_COUNTRY_DROPDOWN_LIST = "entity_address_0_createPersonAddressCountry_dropdown_menu";
    private static final String COMPOSER_ADDRESS_REGION_FIELD = "entity_address_0_createPersonAddressRegion";
    private static final String COMPOSER_ROLE_DROPDOWN = "createPersonPersonRole_component";
    private static final String COMPOSER_ROLE_DROPDOWN_LIST = "createPersonPersonRole_dropdown_menu";
    private static final String COMPOSER_STUDENT_TYPE_DROPDOWN = "createPersonStudentType_component";
    private static final String COMPOSER_STUDENT_TYPE_DROPDOWN_LIST = "createPersonStudentType_dropdown_menu";
    private static final String COMPOSER_STUDENT_STATUS_CATEGORY_DROPDOWN = "person_student_status_0_createPersonStudentStatusCategory_component";
    private static final String COMPOSER_STUDENT_STATUS_CATEGORY_DROPDOWN_LIST = "person_student_status_0_createPersonStudentStatusCategory_dropdown_menu";
    private static final String COMPOSER_STUDENT_STATUS_DROPDOWN = "person_student_status_0_createPersonStudentStatus_component";
    private static final String COMPOSER_STUDENT_STATUS_DROPDOWN_LIST = "person_student_status_0_createPersonStudentStatus_dropdown_menu";
    private static final String COMPOSER_STUDENT_STATUS_DATE_FIELD = "person_student_status_0_createPersonStudentStatusDate";
    private static final String COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN = "person_student_status_0_createPersonStatusEntryTerm_component";
    private static final String COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN_LIST = "person_student_status_0_createPersonStatusEntryTerm_dropdown_menu";
    private static final String HEADER_DELETE_BUTTON = "personHeaderDeleteButton";
    private static final String DELETE_PERSON_CONFIRM_MODAL_LABEL = "deletePersonConfirmModalLabel";
    private static final String DELETE_PERSON_CONFIRM_SUBMIT_BUTTON = "modalSubmitButtondeletePersonConfirm";
    private static final String DATATABLE_EMPTY = "peopleManagerTable_row_0_col_0";
    private static final String QUICK_SEARCH_EMPTY = "quickSearchManagerTable_row_0_col_0";
    private static final String HEADER_STUDENT_STATUS_DISPLAY = "#descriptionObjectStudentStatusLabel";
    private static final String HEADER_ENTRY_TERM_DISPLAY = "#descriptionObjectEntryTermLabel";
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
    private static final String ID_NUMBER_FIELD = "#entity_external_id_0_id_number";
    private static final String ID_RECORDED_DATE_FIELD = "#entity_external_id_0_id_date";
    private static final String WHO_ADDED_ID_DROPDOWN = "#s2id_entity_external_id_0_id_user";
    private static final String COMMENTS_FIELD = "#entity_external_id_0_id_comments";
    private static final String PLUS_BUTTON_EXTERNAL_ID = "//*[@id='entity_external_id_0_add']";
    private static final String SAVE_CHANGES_BTN_PERSON_ID_TYPES = "saveChangesBtnPersonIdTypes";
    private static final String HEADER_ROLE_ELEMENT = "#personHeaderRoleButton";
    private static final String HEADER_ROLE_ELEMENT_LIST = ".//*[@class='btn-group autoSubmit dropDownSelect open']//*[@class='dropdown-menu']";
    private static final String HEADER_STUDENT_TYPE_ELEMENT = "#personHeaderStudentTypeButton";
    private static final String HEADER_ASSIGNED_STAFF_ELEMENT = "#personHeaderAssignedStaffButton";
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


    public static String emailComments(String index){
        return String.format("#entity_email_%s_email_comments",index);
    }
    private static String deleteSummaryList(String summary) {
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
        summaryItem.put("Email Address",SUMMARY_DISPLAY_EMAIL_ADDRESS);
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
            if(MainPage.verifyGetText(By.xpath(summaryList(summaryData)),summaryData)){
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
            MainPage.clickOptionList(By.id(SUMMARY_FIELD_DROPDOWN),
                    summary,
                    By.cssSelector(SUMMARY_FIELD_DROPDOWN_LIST),
                    "a");
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyStudentStatusLabel(String studentStatusLabel){
        String passMessage = String.format(LogPage.VERIFY_STUDENT_STATUS_LABEL_PASS, studentStatusLabel);
        String failMessage = String.format(LogPage.VERIFY_STUDENT_STATUS_LABEL_FAIL, studentStatusLabel);
        try {
            if(MainPage.verifyGetText(By.cssSelector(HEADER_STUDENT_STATUS_DISPLAY),studentStatusLabel)){
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
            if(MainPage.verifyGetText(By.cssSelector(HEADER_ENTRY_TERM_DISPLAY),entryTermLabel)){
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
            MainPage.clickOptionList(By.cssSelector(HEADER_ROLE_ELEMENT),
                    role,
                    By.xpath(HEADER_ROLE_ELEMENT_LIST),
                    "a");
//            waitUntilElementToBeSelected(By.cssSelector(HEADER_ROLE_ELEMENT),20);
//            click(By.cssSelector(HEADER_ROLE_ELEMENT));
//            BasePage.selectElementsList(By.xpath(HEADER_ROLE_ELEMENT_LIST), "a");
//            clickOnListOfElements(role);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void validateQuickSearchEmpty(String message){
        String failMessage = String.format(LogPage.VALIDATE_QUICK_SEARCH_EMPTY_FAIL, message);
        String passMessage = String.format(LogPage.VALIDATE_QUICK_SEARCH_EMPTY_PASS, message);
        try {
            if(MainPage.verifyGetText(By.id(QUICK_SEARCH_EMPTY),message)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
//            waitElementBy(By.id(QUICK_SEARCH_EMPTY),20);
//            String messageQuickSearchEmpty = getText(By.id(QUICK_SEARCH_EMPTY));
//            wait(3000);
//            if(messageQuickSearchEmpty.equals(message)){
//                ExtentReportsSetUp.testingPass(passMessage);
//            }else{
//                FailureDelegatePage.handlePageException(errorMessage);
//            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void validateDatatableMessage(String message){
        String failMessage = String.format(LogPage.VALIDATE_DATATABLE_MESSAGE_FAIL, message);
        String passMessage = String.format(LogPage.VALIDATE_DATATABLE_MESSAGE_PASS, message);
        try {
            if(MainPage.verifyGetText(By.id(DATATABLE_EMPTY),message)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
//            wait(2000);
//            String messageDatatableEmpty = getText(By.id(DATATABLE_EMPTY));
//            if(messageDatatableEmpty.equals(message)){
//                ExtentReportsSetUp.testingPass(passMessage);
//            }else{
//                FailureDelegatePage.handlePageException(errorMessage);
//            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
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
                MainPage.fillField(By.id(COMPOSER_FIRST_NAME_FIELD), mass.get(0).get("FirstName"));
            }
            if (mass.get(0).get("LastName") != null) {
                MainPage.fillField(By.id(COMPOSER_LAST_NAME_FIELD), mass.get(0).get("LastName"));
            }
            if (mass.get(0).get("EmailAddress") != null) {
                MainPage.fillField(By.id(COMPOSER_EMAIL_ADDRESS_FIELD), mass.get(0).get("EmailAddress"));
            }
            if (mass.get(0).get("EmailType") != null) {
                MainPage.clickOptionList(By.id(COMPOSER_EMAIL_TYPE_DROPDOWN),
                        mass.get(0).get("EmailType"),
                        By.id(COMPOSER_EMAIL_TYPE_DROPDOWN_LIST),
                        "a");
            }
            if (mass.get(0).get("EmailOptInMethod") != null) {
                MainPage.clickOptionList(By.id(COMPOSER_EMAIL_OPT_IN_METHOD_DROPDOWN),
                        mass.get(0).get("EmailOptInMethod"),
                        By.id(COMPOSER_EMAIL_OPT_IN_METHOD_DROPDOWN_LIST),
                        "a");
            }
            if (mass.get(0).get("Phone") != null) {
                MainPage.fillField(By.id(COMPOSER_PHONE_NUMBER_FIELD), mass.get(0).get("Phone"));
            }
            if (mass.get(0).get("PhoneType") != null) {
                MainPage.clickOptionList(By.id(COMPOSER_PHONE_TYPE_DROPDOWN),
                        mass.get(0).get("PhoneType"),
                        By.id(COMPOSER_PHONE_TYPE_DROPDOWN_LIST),
                        "a");
            }
            scrollToElement(By.id(COMPOSER_PHONE_TYPE_DROPDOWN));
            if (mass.get(0).get("Address1") != null) {
                MainPage.fillField(By.id(COMPOSER_ADDRESS1_FIELD), mass.get(0).get("Address1"));
            }
            if (mass.get(0).get("Address2") != null) {
                MainPage.fillField(By.id(COMPOSER_ADDRESS2_FIELD), mass.get(0).get("Address2"));
            }
            if (mass.get(0).get("Address3") != null) {
                MainPage.fillField(By.id(COMPOSER_ADDRESS3_FIELD), mass.get(0).get("Address3"));
            }
            if (mass.get(0).get("Address4") != null) {
                MainPage.fillField(By.id(COMPOSER_ADDRESS4_FIELD), mass.get(0).get("Address4"));
            }
            if (mass.get(0).get("City") != null) {
                MainPage.fillField(By.id(COMPOSER_ADDRESS_CITY_FIELD), mass.get(0).get("City"));
            }
            if (mass.get(0).get("State") != null) {
                MainPage.clickOptionList(By.id(COMPOSER_ADDRESS_STATE_DROPDOWN),
                        mass.get(0).get("State"),
                        By.id(COMPOSER_ADDRESS_STATE_DROPDOWN_LIST),
                        "a");
            }
            if (mass.get(0).get("PostalCode") != null) {
                MainPage.fillField(By.id(COMPOSER_ADDRESS_POSTAL_CODE_FIELD), mass.get(0).get("PostalCode"));
            }
            if (mass.get(0).get("Country") != null) {
                MainPage.clickOptionList(By.id(COMPOSER_ADDRESS_COUNTRY_DROPDOWN),
                        mass.get(0).get("Country"),
                        By.id(COMPOSER_ADDRESS_COUNTRY_DROPDOWN_LIST),
                        "a");
            }
            if (mass.get(0).get("Region") != null) {
                MainPage.fillField(By.id(COMPOSER_ADDRESS_REGION_FIELD), mass.get(0).get("Region"));
            }
            scrollToElement(By.id(COMPOSER_ADDRESS_CITY_FIELD));
            if (mass.get(0).get("Role1") != null) {
                MainPage.clickOptionList(By.id(COMPOSER_ROLE_DROPDOWN),
                        mass.get(0).get("Role1"),
                        By.id(COMPOSER_ROLE_DROPDOWN_LIST),
                        "a");
            }
            if (mass.get(0).get("Role2") != null) {
                MainPage.clickOptionList(By.id(COMPOSER_ROLE_DROPDOWN),
                        mass.get(0).get("Role2"),
                        By.id(COMPOSER_ROLE_DROPDOWN_LIST),
                        "a");
            }
            if (mass.get(0).get("Role3") != null) {
                MainPage.clickOptionList(By.id(COMPOSER_ROLE_DROPDOWN),
                        mass.get(0).get("Role3"),
                        By.id(COMPOSER_ROLE_DROPDOWN_LIST),
                        "a");
            }
            if (mass.get(0).get("StudentType") != null) {
                MainPage.clickOptionList(By.id(COMPOSER_STUDENT_TYPE_DROPDOWN),
                        mass.get(0).get("StudentType"),
                        By.id(COMPOSER_STUDENT_TYPE_DROPDOWN_LIST),
                        "a");
            }
            if (mass.get(0).get("StudentStatusCategory") != null) {
                MainPage.clickOptionList(By.id(COMPOSER_STUDENT_STATUS_CATEGORY_DROPDOWN),
                        mass.get(0).get("StudentStatusCategory"),
                        By.id(COMPOSER_STUDENT_STATUS_CATEGORY_DROPDOWN_LIST),
                        "a");
            }
            if (mass.get(0).get("StudentStatus") != null) {
                MainPage.clickOptionList(By.id(COMPOSER_STUDENT_STATUS_DROPDOWN),
                        mass.get(0).get("StudentStatus"),
                        By.id(COMPOSER_STUDENT_STATUS_DROPDOWN_LIST),
                        "a");
            }
            if (mass.get(0).get("StudentStatusDate") != null) {
                MainPage.fillDateField(By.id(COMPOSER_STUDENT_STATUS_DATE_FIELD), mass.get(0).get("StudentStatusDate"));
            }
            if (mass.get(0).get("EntryTerm") != null) {
                MainPage.clickOptionList(By.id(COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN),
                        mass.get(0).get("EntryTerm"),
                        By.id(COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN_LIST),
                        "a");
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
            wait(5000);
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
            if (MainPage.verifyGetText(By.cssSelector(HEADER_ASSIGNED_STAFF_ELEMENT),assignedStaff)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void verifyStudentType(String studentType){
        try {
            if (MainPage.verifyGetText(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT),studentType)) {
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_STUDENT_TYPE_PASS);
            } else {
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

    /*
     * to update names values values in contact tab on records
     */
    public static void updateNameValues(String firstName,String lastName,String middleName,String preferredName, String suffix, String salutation){
        try {
            waitElementBy(By.id(FIRST_NAME_FIELD),20);
            if (mass.get(0).get(firstName) != null) {
                MainPage.fillField(By.id(FIRST_NAME_FIELD), mass.get(0).get(firstName));
            }
            if (mass.get(0).get(lastName) != null) {
                MainPage.fillField(By.id(LAST_NAME_FIELD), mass.get(0).get(lastName));
            }
            if (mass.get(0).get(middleName) != null) {
                MainPage.fillField(By.id(MIDDLE_NAME_FIELD), mass.get(0).get(middleName));
            }
            if (mass.get(0).get(preferredName) != null) {
                MainPage.fillField(By.id(PREFERRED_NAME_FIELD), mass.get(0).get(preferredName));
            }
            if (mass.get(0).get(suffix) != null) {
                MainPage.clickOptionList(By.cssSelector(SUFFIX_DROPDOWN),
                        mass.get(0).get(suffix),
                        By.cssSelector(SUFFIX_DROPDOWN_LIST),
                        "a");
            }
            if (mass.get(0).get(salutation) != null) {
                MainPage.clickOptionList(By.cssSelector(SALUTATION_DROPDOWN),
                        mass.get(0).get(salutation),
                        By.cssSelector(SALUTATION_DROPDOWN_LIST),
                        "a");
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
            if (mass.get(0).get(type) != null) {
                MainPage.clickOptionList(By.cssSelector(TYPE_DROPDOWN),
                        mass.get(0).get(type),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (mass.get(0).get(idNumber) != null) {
                MainPage.fillField(By.cssSelector(ID_NUMBER_FIELD), mass.get(0).get(idNumber));
            }
            if (mass.get(0).get(idRecordedDate) != null) {
                MainPage.fillDateField(By.cssSelector(ID_RECORDED_DATE_FIELD), mass.get(0).get(idRecordedDate));
            }
            if (mass.get(0).get(whoAddedId) != null) {
                MainPage.clickOptionList(By.cssSelector(WHO_ADDED_ID_DROPDOWN),
                        mass.get(0).get(whoAddedId),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (mass.get(0).get(comments) != null) {
                MainPage.fillField(By.cssSelector(COMMENTS_FIELD), mass.get(0).get(comments));
            }
            saveChangesBtnPersonIdTypes();
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EXTERNAL_ID_TYPES_PASS);

        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_EXTERNAL_ID_TYPES_FAIL);
        }
    }
    public static void saveChangesBtnPersonContact(){
        try {
            waitElementBy(By.id(SAVE_CHANGES_BTN_PERSON_CONTACT),20);
            scrollToTheBottom();
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
