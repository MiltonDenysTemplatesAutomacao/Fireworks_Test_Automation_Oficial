package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PersonPage extends BasePage{

    private static final String recordNavTabBasic = "recordNavTab_basic";
    private static final String recordNavTabIdTypes = "recordNavTab_id_types";

    private static final String citizenshipTypeDropdown = "#s2id_citizenship_type";
    private static final String citizenshipTypeDropdownList = "#select2-results-21";
    private static final String citizenshipCountryDropdown = "#s2id_country_of_citizenship";
    private static final String citizenshipCountryDropdownList = "#select2-results-22";
    private static final String socialSecurityNumberField = "#social_security_number";
    private static final String personBasicSaveChangesButton = "saveChangesBtnPersonBasic";


    private static final String firstNameField = "person_name_0_name_first";
    private static final String lastNameField = "person_name_0_name_last";
    private static final String middleNameField = "person_name_0_name_middle";
    private static final String preferredNameField = "person_name_0_preferred_name";
    private static final String suffixDropdown = "#person_name_0_name_suffix_toggle";
    private static final String suffixDropdownList = "#person_name_0_name_suffix_dropdown_menu";
    private static final String salutationDropdown = "#person_name_0_salutation_toggle";
    private static final String salutationDropdownList = "#person_name_0_salutation_dropdown_menu";
    private static final String saveChangesBtnPersonContact = "saveChangesBtnPersonContact";

    private static final String typeDropdown = "#s2id_entity_external_id_0_id_type";
    private static final String typeDropdownList = "#select2-drop";
    private static final String idNumberField = "#entity_external_id_0_id_number";
    private static final String idRecordedDateField = "#entity_external_id_0_id_date";
    private static final String whoAddedIdDropdown = "#s2id_entity_external_id_0_id_user";
    private static final String whoAddedIdDropdownList = "#select2-drop";
    private static final String commentsField = "#entity_external_id_0_id_comments";
    private static final String plusButtonExternalId = "//*[@id='entity_external_id_0_add']";
    private static final String saveChangesBtnPersonIdTypes = "saveChangesBtnPersonIdTypes";


    /*
     * go to Basic tab on records
     */
    public static void navigateToBasic(){
        try {
            BasePage.click(By.id(recordNavTabBasic));
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
            BasePage.click(By.id(recordNavTabIdTypes));
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
            waitElementBy(By.cssSelector(citizenshipTypeDropdown),20);
            if (mass.get(0).get(citizenshipType) != null) {
                BasePage.click(By.cssSelector(citizenshipTypeDropdown));
                BasePage.selectElementsList(citizenshipTypeDropdownList, "a");
                clickOnListOfElements(mass.get(0).get(citizenshipType));
            }
            if (mass.get(0).get(countryOfCitizenship) != null) {
                BasePage.click(By.cssSelector(citizenshipCountryDropdown));
                BasePage.selectElementsList(citizenshipCountryDropdownList, "a");
                clickOnListOfElements(mass.get(0).get(countryOfCitizenship));
            }
            if (mass.get(0).get(ssn) != null) {
                BasePage.write(By.cssSelector(socialSecurityNumberField), mass.get(0).get(ssn));
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
            waitElementBy(By.id(firstNameField),20);
            if (mass.get(0).get(firstName) != null) {
                BasePage.write(By.id(firstNameField), mass.get(0).get(firstName));
            }
            if (mass.get(0).get(lastName) != null) {
                BasePage.write(By.id(lastNameField), mass.get(0).get(lastName));
            }
            if (mass.get(0).get(middleName) != null) {
                BasePage.write(By.id(middleNameField), mass.get(0).get(middleName));
            }
            if (mass.get(0).get(preferredName) != null) {
                BasePage.write(By.id(preferredNameField), mass.get(0).get(preferredName));
            }
            if (mass.get(0).get(suffix) != null) {
                BasePage.click(By.cssSelector(suffixDropdown));
                BasePage.selectElementsList(suffixDropdownList, "a");
                clickOnListOfElements(mass.get(0).get(suffix));
            }
            if (mass.get(0).get(salutation) != null) {
                BasePage.click(By.cssSelector(salutationDropdown));
                BasePage.selectElementsList(salutationDropdownList, "a");
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
            waitElementBy(By.cssSelector(typeDropdown),20);
            BasePage.scrollToElement(By.xpath(plusButtonExternalId));
            if (mass.get(0).get(type) != null) {
                BasePage.click(By.cssSelector(typeDropdown));
                BasePage.selectElementsList(typeDropdownList, "a");
                clickOnListOfElements(mass.get(0).get(type));
            }
            if (mass.get(0).get(idNumber) != null) {
                BasePage.write(By.cssSelector(idNumberField), mass.get(0).get(idNumber));
            }
            if (mass.get(0).get(idRecordedDate) != null) {
                BasePage.write(By.cssSelector(idRecordedDateField), mass.get(0).get(idRecordedDate));
            }
            if (mass.get(0).get(whoAddedId) != null) {
                BasePage.click(By.cssSelector(whoAddedIdDropdown));
                BasePage.selectElementsList(whoAddedIdDropdownList, "a");
                clickOnListOfElements(mass.get(0).get(whoAddedId));
            }
            if (mass.get(0).get(comments) != null) {
                BasePage.write(By.cssSelector(commentsField), mass.get(0).get(comments));
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
            waitElementBy(By.id(personBasicSaveChangesButton),20);
            BasePage.scrollToElement(By.id(personBasicSaveChangesButton));
            BasePage.click(By.id(personBasicSaveChangesButton));
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
            waitElementBy(By.id(saveChangesBtnPersonContact),20);
            BasePage.scrollToElement(By.id(saveChangesBtnPersonContact));
            BasePage.click(By.id(saveChangesBtnPersonContact));
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
            waitElementBy(By.id(saveChangesBtnPersonIdTypes),20);
            BasePage.scrollToElement(By.id(saveChangesBtnPersonIdTypes));
            BasePage.click(By.id(saveChangesBtnPersonIdTypes));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
}
