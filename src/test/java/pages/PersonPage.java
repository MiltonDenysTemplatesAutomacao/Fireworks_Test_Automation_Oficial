package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonPage extends BasePage{

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
            write(By.cssSelector(PEOPLE_MANAGER_TABLE_SEARCH_FIELD),mass.get(0).get(search));
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
    public static void verifyStudentType(){
        try {
            waitUntilElementPresence(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT),20);
            String studentTypeText = getText(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT));
            System.out.println(studentTypeText);
            if(studentTypeText.contains(mass.get(0).get("StudentType"))){
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
    /*
     * go to Basic tab on records
     */
    public static void navigateToBasic(){
        try {
            BasePage.click(By.id(RECORD_NAV_TAB_BASIC));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_BASIC_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_BASIC_FAIL);
        }
    }
    /*
     * go to Basic tab on records
     */
    public static void navigateToIdTypes(){
        try {
            BasePage.click(By.id(RECORD_NAV_TAB_ID_TYPES));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_ID_TYPES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_ID_TYPES_FAIL);
        }
    }
    /*
     * to update Citizenship values in basic tab on records
     */
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
    /*
     * to save changes  in Basic tab on records
     */
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
    /*
     * to save changes in Contact tab on records
     */
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
    /*
     * to save changes in Id Types tab on records
     */
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
