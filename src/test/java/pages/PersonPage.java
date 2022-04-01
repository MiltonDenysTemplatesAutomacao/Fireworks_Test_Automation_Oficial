package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

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

    public static void verifyHeaderRole(){
        String passMessage = String.format(LogPage.VERIFY_HEADER_ROLE_PASS, mass.get(0).get("Role1"));
        String failMessage = String.format(LogPage.VERIFY_HEADER_ROLE_FAIL, mass.get(0).get("Role1"));

        try {
            waitUntilElementPresence(By.cssSelector(HEADER_ROLE_ELEMENT),20);
            List<WebElement> headerRoles;
            switch (mass.get(0).get("Role1")){
                case "Student":
                    String studentType = getText(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT));
                    String assignedStaff = getText(By.cssSelector(HEADER_ASSIGNED_STAFF_ELEMENT));
                    Assert.assertTrue(studentType.contains("Student Type"));
                    Assert.assertTrue(assignedStaff.contains("Assigned Staff"));
                    ExtentReportsSetUp.testingPass(passMessage);
                    break;
                case "Multiple":
                    ExtentReportsSetUp.testingPass(passMessage);
                    break;
                default:
                    headerRoles = findElements(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT));
                    headerRoles = findElements(By.cssSelector(HEADER_ASSIGNED_STAFF_ELEMENT));
                    if(headerRoles.isEmpty()){
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
