package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PersonPage extends BasePage{

    private static String recordNavTabBasic = "recordNavTab_basic";
    private static String recordNavTabIdTypes = "recordNavTab_id_types";

    private static String citizenshipTypeDropdown = "#s2id_citizenship_type";
    private static String citizenshipTypeDropdownList = "#select2-results-21";
    private static String citizenshipCountryDropdown = "#s2id_country_of_citizenship";
    private static String citizenshipCountryDropdownList = "#select2-results-22";
    private static String socialSecurityNumberField = "#social_security_number";
    private static String personBasicSaveChangesButton = "saveChangesBtnPersonBasic";


    private static String firstNameField = "person_name_0_name_first";
    private static String lastNameField = "person_name_0_name_last";
    private static String middleNameField = "person_name_0_name_middle";
    private static String preferredNameField = "person_name_0_preferred_name";
    private static String suffixDropdown = "#person_name_0_name_suffix_toggle";
    private static String suffixDropdownList = "#person_name_0_name_suffix_dropdown_menu";
    private static String salutationDropdown = "#person_name_0_salutation_toggle";
    private static String salutationDropdownList = "#person_name_0_salutation_dropdown_menu";
    private static String saveChangesBtnPersonContact = "saveChangesBtnPersonContact";

    private static String typeDropdown = "#s2id_entity_external_id_0_id_type";
    private static String typeDropdownList = "#select2-drop";
    private static String idNumberField = "#entity_external_id_0_id_number";
    private static String idRecordedDateField = "#entity_external_id_0_id_date";
    private static String whoAddedIdDropdown = "#s2id_entity_external_id_0_id_user";
    private static String whoAddedIdDropdownList = "#select2-drop";
    private static String commentsField = "#entity_external_id_0_id_comments";
    private static String plusButtonExternalId = "//*[@id='entity_external_id_0_add']";
    private static String saveChangesBtnPersonIdTypes = "saveChangesBtnPersonIdTypes";



    /*
     * go to Basic tab on records
     */
    public static void navigateToBasic(){
        try {
            BasePage.click(By.id(recordNavTabBasic));
            ExtentReportsSetUp.testingPass(LogPage.navigateToBasicPass);
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail(LogPage.navigateToBasicFail);
            Assert.assertFalse(true);
            System.err.println(LogPage.navigateToBasicFail);
        }
    }
    /*
     * go to Basic tab on records
     */
    public static void navigateToIdTypes(){
        try {
            BasePage.click(By.id(recordNavTabIdTypes));
            ExtentReportsSetUp.testingPass(LogPage.navigateToIdTypesPass);
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail(LogPage.navigateToIdTypesFail);
            Assert.assertFalse(true);
            System.err.println(LogPage.navigateToIdTypesFail);
        }
    }
    /*
     * to update Citizenship values in basic tab on records
     */
    public static void updateCitizenshipValues(String citizenshipType,String countryOfCitizenship,String ssn){
        BasePage.wait(2000);
        try {
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
            ExtentReportsSetUp.testingPass(LogPage.updateCitizenshipPass);
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail(LogPage.updateCitizenshipFail);
            Assert.assertFalse(true);
            System.err.println(LogPage.updateCitizenshipFail);
        }
    }
    /*
     * to update names values values in contact tab on records
     */
    public static void updateNameValues(String firstName,String lastName,String middleName,String preferredName, String suffix, String salutation){
        BasePage.wait(3000);
        try {
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
            ExtentReportsSetUp.testingPass(LogPage.updateNamePass);
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail(LogPage.updateNameFail);
            Assert.assertFalse(true);
            System.err.println(LogPage.updateNameFail);
        }
    }
    /*
     * to update Id Types in contact tab on records
     */
    public static void updateExternalIdTypes(String type,String idNumber,String idRecordedDate,String whoAddedId, String comments){
        BasePage.wait(2000);
        try {
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
            ExtentReportsSetUp.testingPass(LogPage.updateExternalIdTypesPass);

        } catch (Exception e) {
            ExtentReportsSetUp.testingFail(LogPage.updateExternalIdTypesFail);
            Assert.assertFalse(true);
            System.err.println(LogPage.updateExternalIdTypesFail);
        }
    }
    /*
     * to save changes  in Basic tab on records
     */
    public static void saveChangesBtnPersonBasic(){
        BasePage.wait(2000);
        try {
            BasePage.scrollToElement(By.id(personBasicSaveChangesButton));
            BasePage.click(By.id(personBasicSaveChangesButton));
            ExtentReportsSetUp.testingPass(LogPage.saveChangesPass);
        } catch (Exception e) {
            Assert.assertFalse(true);
            System.err.println(LogPage.saveChangesFail);
        }
    }
    /*
     * to save changes in Contact tab on records
     */
    public static void saveChangesBtnPersonContact(){
        BasePage.wait(2000);
        try {
            BasePage.scrollToElement(By.id(saveChangesBtnPersonContact));
            BasePage.click(By.id(saveChangesBtnPersonContact));
            ExtentReportsSetUp.testingPass(LogPage.saveChangesPass);
        } catch (Exception e) {
            Assert.assertFalse(true);
            System.err.println(LogPage.saveChangesFail);
        }
    }
    /*
     * to save changes in Id Types tab on records
     */
    public static void saveChangesBtnPersonIdTypes(){
        BasePage.wait(2000);
        try {
            BasePage.scrollToElement(By.id(saveChangesBtnPersonIdTypes));
            BasePage.click(By.id(saveChangesBtnPersonIdTypes));
            ExtentReportsSetUp.testingPass(LogPage.saveChangesPass);
        } catch (Exception e) {
            Assert.assertFalse(true);
            System.err.println(LogPage.saveChangesFail);
        }
    }




}
