package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PersonPage extends BasePage{

    private static String recordNavTabBasic = "recordNavTab_basic";
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
     * to update Citizenship values in basic tab on records
     */
    public static void updateCitizenshipValues(String citizenshipType,String countryOfCitizenship,String ssn){
        BasePage.wait(3000);
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
}
