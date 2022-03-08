package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;

public class GlobalNavPage extends BasePage{

    public static String fireWorksIcon = "smallHeaderLogo";
    public static String homeQuickSearchField = "#homeBillboardSearch";
    public static String homeQuickSearchButton = "#mainSearchSubmitBtn";

    /*
     * Footer Css
     */
    public static String footerNavElement = "#footerNave";
    public static String footerQuickAddMen = "#global_nav_quick_add_toggle";
    public static String footerQuickAddPersonMenuItem = "#global_nav_add_person";
    public static String footerQuickAddOrganizationMenuItem = "#global_nav_add_org";
    public static String footerQuickAddStaffMenuItem = "#global_nav_add_staff";

    /*
     * Quick Add Person Css
     */
    public static String quickAddPersonFirstNameField = "#person_name_0_quickAddPersonNameFirst";
    public static String quickAddPersonLastNameField = "#person_name_0_quickAddPersonNameLast";
    public static String quickAddPersonEmailAddressField = "#entity_email_0_quickAddPersonEmailAddress";
    public static String quickAddPersonEmailTypeDropdown = "#entity_email_0_quickAddPersonEmailType_component";
    public static String quickAddPersonEmailTypeDropdownList = "#entity_email_0_quickAddPersonEmailType_dropdown_menu";
    public static String quickAddPersonPhoneNumberField = "#entity_phone_0_quickAddPersonPhoneNumber";
    public static String quickAddPersonPhoneTypeDropdown = "div#entity_phone_0_quickAddPersonPhoneType_component";
    public static String quickAddPersonPhoneTypeDropdownList = "#entity_phone_0_quickAddPersonPhoneType_dropdown_menu";
    public static String quickAddPersonOptInMethodDropdown = "#entity_email_0_quickAddPersonOptInMethod_toggle";
    public static String quickAddPersonOptInMethodDropdownList = "#entity_email_0_quickAddPersonOptInMethod_dropdown_menu";
    public static String quickAddPersonAddress1Field = "#entity_address_0_quickAddPersonAddress1";
    public static String quickAddPersonAddress2Field = "#entity_address_0_quickAddPersonAddress2";
    public static String quickAddPersonAddress3Field = "#entity_address_0_quickAddPersonAddress3";
    public static String quickAddPersonAddress4Field = "#entity_address_0_quickAddPersonAddress4";
    public static String quickAddPersonCityField = "#entity_address_0_quickAddPersonAddressCity";
    public static String quickAddPersonStateDropdown = "div#entity_address_0_quickAddPersonAddressState_component";
    public static String quickAddPersonStateDropdownList = "#entity_address_0_quickAddPersonAddressState_dropdown_menu";
    public static String quickAddPersonCountryDropdown = "div#entity_address_0_quickAddPersonAddressCountry_component";
    public static String quickAddPersonCountryDropdownList = "#entity_address_0_quickAddPersonAddressCountry_dropdown_menu";
    public static String quickAddPersonPostalCodeField = "#entity_address_0_quickAddPersonAddressPostalCode";
    public static String quickAddPersonRegionField = "#entity_address_0_quickAddPersonAddressRegion";
    public static String quickAddPersonRoleDropdown = "div#quickAddPersonPersonRole_component";
    public static String quickAddPersonRoleDropdownList = "#quickAddPersonPersonRole_dropdown_menu";
    public static String quickAddStudentStatusCategoryDropdown = "div#person_student_status_0_quickAddPersonStudentStatusCategory_component";
    public static String quickAddStudentStatusDropdown = "div#person_student_status_0_quickAddPersonStudentStatus_component";
    public static String quickAddStudentTypeDropdown = "div#quickAddPersonStudentType_component";
    public static String quickAddStudentStatusDateField = "#person_student_status_0_quickAddPersonStudentStatusDate";
    public static String quickAddStudentStatusEntryTermDropdown = "div#person_student_status_0_quickAddPersonStatusEntryTerm_component";
    public static String quickAddPersonSaveGoButton = "#modalSubmitButtonquickAddPersonSaveGo";
    public static String quickAddPersonSaveCloseButton = "#modalSubmitButtonquickAddPersonSaveClose";
    /*
     * Quick Add Organization Css
     */
    public static String quickAddOrgOrganizationNameField = "#org_name_0_quickAddOrganizationOrgName";
    public static String quickAddOrgPhoneNumberField = "#entity_phone_0_quickAddOrganizationPhoneNumber";
    public static String quickAddOrgRoleDropdown = "#quickAddOrganizationOrgRole_component";
    public static String quickAddOrgRoleDropdownList = "#quickAddOrganizationOrgRole_dropdown_menu";
    public static String quickAddOrgPhoneTypeDropdown = "#entity_phone_0_quickAddOrganizationPhoneType_component";
    public static String quickAddOrgPhoneTypeDropdownList = "#entity_phone_0_quickAddOrganizationPhoneType_dropdown_menu";
    public static String quickAddOrgAddress1Field = "#entity_address_0_quickAddOrganizationAddress1";
    public static String quickAddOrgAddress2Field = "#entity_address_0_quickAddOrganizationAddress2";
    public static String quickAddOrgAddress3Field = "#entity_address_0_quickAddOrganizationAddress3";
    public static String quickAddOrgAddress4Field = "#entity_address_0_quickAddOrganizationAddress4";
    public static String quickAddOrgCityField = "#entity_address_0_quickAddOrganizationAddressCity";
    public static String quickAddOrgStateDropdown = "#entity_address_0_quickAddOrganizationAddressState_component";
    public static String quickAddOrgStateDropdownList = "#entity_address_0_quickAddOrganizationAddressState_dropdown_menu";
    public static String quickAddOrgRegionField = "#entity_address_0_quickAddOrganizationAddressRegion";
    public static String quickAddOrgPostalCodeField = "#entity_address_0_quickAddOrganizationAddressPostalCode";
    public static String quickAddOrgCountryDropdown = "#entity_address_0_quickAddOrganizationAddressCountry_component";
    public static String quickAddOrgCountryDropdownList = "#entity_address_0_quickAddOrganizationAddressCountry_dropdown_menu";
    public static String quickAddOrgSaveGoButton = "#modalSubmitButtonquickAddOrganizationSaveGo";
    /*
     * Quick Add Staff Css
     */
    public static String quickAddStaffModal = "#quickAddStaffModal";
    public static String quickAddStaffModalLabel = "#quickAddStaffModalLabel";
    public static String quickAddStaffFirstNameField = "#quickAddStaffNameFirst";
    public static String quickAddStaffLastNameField = "#quickAddStaffNameLast";
    public static String quickAddStaffEmailAddressField = "#quickAddStaffEmailAddress";
    public static String quickAddStaffEmailTypeDropdown = "#s2id_quickAddStaffEmailType.select2-container.form-control.select2 a";
    public static String quickAddStaffAccountStartDate = "#quickAddStaffDatetimepickerStart";
    public static String quickAddStaffAccountEndDate = "#quickAddStaffDatetimepickerEnd";
    public static String quickAddStaffPermissionsGroupDropdown = "#s2id_quickAddStaffPermissionGroup.select2-container.form-control.select2 a";
    public static String quickAddStaffPermissionsGroupDropdownList = "#select2-results-1";
    public static String quickAddStaffSaveGoButton = "#quickAddStaffModalSaveGo";
    public static String quickAddStaffSaveCloseButton = "#quickAddStaffModalSaveClose";

    /*
     * Method to create a Person
     */
    public static void createPerson(DataTable data) {
        try {
            navigateQuickAddCreatePersonPage();
            quickAddPerson(data);
            quickAddPersonSaveGoButton();
        } catch (Exception e) {
            System.err.println("Fail - createPerson");
        }

    }

    /*
     * Method to create an Organization
     */
    public static void createOrganization(DataTable data) {
        try {
            navigateQuickAddCreateOrganizationPage();
            quickAddOrganization(data);
            quickAddOrganizationSaveGoButton();
        } catch (Exception e) {
            System.err.println("Fail - createOrganization");
        }
    }

    /*
     * Method to create an Staff member
     */
    public static void createStaff(DataTable data) {
        try {
            navigateQuickAddCreateStaffPage();
            quickAddStaff(data);
            quickAddStaffSaveGoButton();
        } catch (Exception e) {
            System.err.println("Fail - createStaff");
        }
    }

    /*
     * Method to go to Home Page
     */
    public static void goToHomePage() {
        try {
            BasePage.click(By.id(fireWorksIcon));
            ExtentReportsSetUp.testingPass("I go to Home Page");

        } catch (Exception e) {
            ExtentReportsSetUp.testingFail("FAILED to go to Home Page");
            Assert.assertFalse(true);
        }
    }

    /*
     * Method to go to quick add person page
     */
    public static void navigateQuickAddCreatePersonPage() {
        try {
            BasePage.click(By.cssSelector(footerQuickAddMen));
            wait(2000);
            BasePage.click(By.cssSelector(footerQuickAddPersonMenuItem));
            ExtentReportsSetUp.testingPass("I navigate to QuickAddCreatePersonPage");
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail("FAILED to I navigate to QuickAddCreatePersonPage");
            Assert.assertFalse(true);
        }
    }

    /*
     * Method to go to quick add organization page
     */
    public static void navigateQuickAddCreateOrganizationPage() {
        try {
            BasePage.click(By.cssSelector(footerQuickAddMen));
            BasePage.wait(3000);
            BasePage.click(By.cssSelector(footerQuickAddOrganizationMenuItem));
            ExtentReportsSetUp.testingPass("I navigate to QuickAddCreateOrganizationPage");
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail("FAILED to I navigate to QuickAddCreateOrganizationPage");
            Assert.assertFalse(true);
        }
    }

    /*
     * Method to go to quick add staff page
     */
    public static void navigateQuickAddCreateStaffPage() {
        try {
            BasePage.click(By.cssSelector(footerQuickAddMen));
            BasePage.wait(2000);
            BasePage.click(By.cssSelector(footerQuickAddStaffMenuItem));
            ExtentReportsSetUp.testingPass("I navigate to QuickAddCreateStaffPage");
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail("FAILED to I navigate to QuickAddCreateStaffPage");
            Assert.assertFalse(true);
        }
    }

    /*
     * Method to fill in Add Person fields
     */
    public static void quickAddPerson(DataTable data) {
        BasePage.wait(3000);
        try {
            mass = data.asMaps(String.class, String.class);
            if (mass.get(0).get("Firstname") != null) {
                BasePage.write(By.cssSelector(quickAddPersonFirstNameField), mass.get(0).get("Firstname"));
            }
            if (mass.get(0).get("Lastname") != null) {
                BasePage.write(By.cssSelector(quickAddPersonLastNameField), mass.get(0).get("Lastname"));
            }
            if (mass.get(0).get("Phone") != null) {
                BasePage.write(By.cssSelector(quickAddPersonPhoneNumberField), mass.get(0).get("Phone"));
            }
            if (mass.get(0).get("PhoneType") != null) {
                BasePage.click(By.cssSelector(quickAddPersonPhoneTypeDropdown));
                BasePage.selectElementsList(quickAddPersonPhoneTypeDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("PhoneType"));
            }
            if (mass.get(0).get("Role1") != null) {
                BasePage.click(By.cssSelector(quickAddPersonRoleDropdown));
                BasePage.selectElementsList(quickAddPersonRoleDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("Role1"));
            }
            if (mass.get(0).get("EmailAddress") != null) {
                BasePage.write(By.cssSelector(quickAddPersonEmailAddressField), mass.get(0).get("EmailAddress"));
            }
            if (mass.get(0).get("EmailType") != null) {
                BasePage.click(By.cssSelector(quickAddPersonEmailTypeDropdown));
                BasePage.selectElementsList(quickAddPersonEmailTypeDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("EmailType"));
            }
            if (mass.get(0).get("EmailOptInMethod") != null) {
                BasePage.click(By.cssSelector(quickAddPersonOptInMethodDropdown));
                BasePage.selectElementsList(quickAddPersonOptInMethodDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("EmailOptInMethod"));
            }
            if (mass.get(0).get("Address1") != null) {
                BasePage.write(By.cssSelector(quickAddPersonAddress1Field), mass.get(0).get("Address1"));
            }
            if (mass.get(0).get("Address2") != null) {
                BasePage.write(By.cssSelector(quickAddPersonAddress1Field), mass.get(0).get("Address2"));
            }
            if (mass.get(0).get("Address3") != null) {
                BasePage.write(By.cssSelector(quickAddPersonAddress1Field), mass.get(0).get("Address3"));
            }
            if (mass.get(0).get("Address4") != null) {
                BasePage.write(By.cssSelector(quickAddPersonAddress1Field), mass.get(0).get("Address4"));
            }
            if (mass.get(0).get("City") != null) {
                BasePage.write(By.cssSelector(quickAddPersonCityField), mass.get(0).get("City"));
            }
            if (mass.get(0).get("State") != null) {
                BasePage.click(By.cssSelector(quickAddPersonStateDropdown));
                BasePage.selectElementsList(quickAddPersonStateDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("State"));
            }
            if (mass.get(0).get("PostalCode") != null) {
                BasePage.write(By.cssSelector(quickAddPersonPostalCodeField), mass.get(0).get("PostalCode"));
            }
            if (mass.get(0).get("Country") != null) {
                BasePage.click(By.cssSelector(quickAddPersonCountryDropdown));
                BasePage.selectElementsList(quickAddPersonCountryDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("Country"));
            }
            ExtentReportsSetUp.testingPass("I quick add a person");
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail("FAILED to Quick add a person");
            Assert.assertFalse(true);
        }

    }

    /*
     * Method to fill in Add Person fields
     */
    public static void quickAddOrganization(DataTable data) {
        BasePage.wait(3000);

        try {
            mass = data.asMaps(String.class, String.class);
            if (mass.get(0).get("Name") != null) {
                BasePage.write(By.cssSelector(quickAddOrgOrganizationNameField), mass.get(0).get("Name"));
            }
            if (mass.get(0).get("Role") != null) {
                BasePage.click(By.cssSelector(quickAddOrgRoleDropdown));
                BasePage.selectElementsList(quickAddOrgRoleDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("Role"));
            }
            if (mass.get(0).get("Phone") != null) {
                BasePage.write(By.cssSelector(quickAddOrgPhoneNumberField), mass.get(0).get("Phone"));
            }
            if (mass.get(0).get("PhoneType") != null) {
                BasePage.click(By.cssSelector(quickAddOrgPhoneTypeDropdown));
                BasePage.selectElementsList(quickAddOrgPhoneTypeDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("PhoneType"));
            }
            if (mass.get(0).get("Address1") != null) {
                BasePage.write(By.cssSelector(quickAddOrgAddress1Field), mass.get(0).get("Address1"));
            }
            if (mass.get(0).get("Address2") != null) {
                BasePage.write(By.cssSelector(quickAddOrgAddress2Field), mass.get(0).get("Address2"));
            }
            if (mass.get(0).get("Address3") != null) {
                BasePage.write(By.cssSelector(quickAddOrgAddress3Field), mass.get(0).get("Address3"));
            }
            if (mass.get(0).get("Address4") != null) {
                BasePage.write(By.cssSelector(quickAddOrgAddress4Field), mass.get(0).get("Address4"));
            }
            if (mass.get(0).get("City") != null) {
                BasePage.write(By.cssSelector(quickAddOrgCityField), mass.get(0).get("City"));
            }
            if (mass.get(0).get("State") != null) {
                BasePage.click(By.cssSelector(quickAddOrgStateDropdown));
                BasePage.selectElementsList(quickAddOrgStateDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("State"));
            }
            if (mass.get(0).get("PostalCode") != null) {
                BasePage.write(By.cssSelector(quickAddOrgPostalCodeField), mass.get(0).get("PostalCode"));
            }
            if (mass.get(0).get("Country") != null) {
                BasePage.click(By.cssSelector(quickAddOrgCountryDropdown));
                BasePage.selectElementsList(quickAddOrgCountryDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("Country"));
            }
            if (mass.get(0).get("Region") != null) {
                BasePage.write(By.cssSelector(quickAddOrgRegionField), mass.get(0).get("Region"));
            }
            ExtentReportsSetUp.testingPass("I quick add an organization");
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail("FAILED to Quick add an organization");
            Assert.assertFalse(true);
        }
    }

    /*
     * Method to fill in Add Staff fields
     */
    public static void quickAddStaff(DataTable data) {
        BasePage.wait(3000);

        try {
            mass = data.asMaps(String.class, String.class);
            if (mass.get(0).get("Firstname") != null) {
                BasePage.write(By.cssSelector(quickAddStaffFirstNameField), mass.get(0).get("Firstname"));
            }
            if (mass.get(0).get("Lastname") != null) {
                BasePage.write(By.cssSelector(quickAddStaffLastNameField), mass.get(0).get("Lastname"));
            }
            if (mass.get(0).get("EmailAddress") != null) {
                BasePage.write(By.cssSelector(quickAddStaffEmailAddressField), mass.get(0).get("EmailAddress"));
            }
            if (mass.get(0).get("AccountStartDate") != null) {
                BasePage.write(By.cssSelector(quickAddStaffAccountStartDate), mass.get(0).get("AccountStartDate"));
            }
            if (mass.get(0).get("AccountEndDate") != null) {
                BasePage.write(By.cssSelector(quickAddStaffAccountEndDate), mass.get(0).get("AccountEndDate"));
            }
            if (mass.get(0).get("PermissionGroup") != null) {
                BasePage.click(By.cssSelector(quickAddStaffPermissionsGroupDropdown));
                BasePage.selectElementsList(quickAddStaffPermissionsGroupDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("PermissionGroup"));
            }
            ExtentReportsSetUp.testingPass("I quick add a staff");
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail("FAILED to Quick add a staff");
            Assert.assertFalse(true);
        }
    }

    /*
     * Method to click on Save and Go button in Add Person Page
     */
    public static void quickAddPersonSaveGoButton() {
        try {
            click(By.cssSelector(quickAddPersonSaveGoButton));
            ExtentReportsSetUp.testingPass("I clickQuickAddStaffSaveAndGo");
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail("FAILED to ClickQuickAddStaffSaveAndGo");
            Assert.assertFalse(true);
        }
    }

    /*
     * Method to click on Save and Go button in Add Organization Page
     */
    public static void quickAddOrganizationSaveGoButton() {
        try {
            click(By.cssSelector(quickAddOrgSaveGoButton));
            ExtentReportsSetUp.testingPass("I clickQuickAddOrganizationSaveAndGo");
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail("FAILED to ClickQuickAddOrganizationSaveAndGo");
            Assert.assertFalse(true);
        }

    }

    /*
     * Method to click on Save and Go button in Add Staff Page
     */
    public static void quickAddStaffSaveGoButton() {
        try {
            click(By.cssSelector(quickAddStaffSaveGoButton));
            ExtentReportsSetUp.testingPass("I clickQuickAddOrganizationSaveAndGo");
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail("FAILED to ClickQuickAddOrganizationSaveAndGo");
            Assert.assertFalse(true);
        }

    }

    /*
     * Method to validate alert message
     */
    public static void alertMessageAfterAddPerson(String alertMessage) {
        String errorMessage = "FAILED to recieve "+alertMessage+" alert message";
        String passMessage = "I received " +alertMessage+" alert message";
        try {
            waitElementById("alertMessage", 10);
            if (alertMessageByIdContains("alertMessage", alertMessage)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                System.err.println(errorMessage);
                ExtentReportsSetUp.testingFail(errorMessage);
                Assert.assertFalse(true);
            }
        } catch (Exception e) {
            System.err.println(errorMessage);
        }
    }

    /*
     * Method to quick search using one String parameter
     */
    public static void quickSearchOneParameter(String parameter) {
        try {
            BasePage.write(By.cssSelector(homeQuickSearchField), mass.get(0).get(parameter));
            BasePage.click(By.cssSelector(homeQuickSearchButton));
            ExtentReportsSetUp.testingPass("I quick search " + parameter + " from home page");
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail("FAILED to quick search " + parameter + " firstname from home page");
            Assert.assertFalse(true);
        }
    }

    /*
     * Method to quick search from home page partial
     */
    public static void quickSearchQuickPartial(String parameter) {
        try {
            String data = mass.get(0).get(parameter);
            BasePage.write(By.cssSelector(homeQuickSearchField), data.substring(0, 5));
            BasePage.click(By.cssSelector(homeQuickSearchButton));
            ExtentReportsSetUp.testingPass("I quick search partial" +parameter);
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail("FAILED to quick search partial" +parameter);
            Assert.assertFalse(true);
        }
    }
}
