package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;

public class GlobalNavPage extends BasePage {

    public static final String fireWorksIcon = "smallHeaderLogo";
    public static final String homeQuickSearchField = "#homeBillboardSearch";
    public static final String homeQuickSearchButton = "#mainSearchSubmitBtn";

    /*
     * Footer Css
     */
    public static final String footerNavElement = "#footerNave";
    public static final String footerQuickAddMen = "#global_nav_quick_add_toggle";
    public static final String footerQuickAddPersonMenuItem = "#global_nav_add_person";
    public static final String footerQuickAddOrganizationMenuItem = "#global_nav_add_org";
    public static final String footerQuickAddStaffMenuItem = "#global_nav_add_staff";
    public static final String footerToolsMenu = "#global_nav_tools_toggle";
    public static final String footerToolsTasksMenuItem = "#global_nav_task";

    /*
     * Quick Add Person Css
     */
    public static final String quickAddPersonFirstNameField = "#person_name_0_quickAddPersonNameFirst";
    public static final String quickAddPersonLastNameField = "#person_name_0_quickAddPersonNameLast";
    public static final String quickAddPersonEmailAddressField = "#entity_email_0_quickAddPersonEmailAddress";
    public static final String quickAddPersonEmailTypeDropdown = "#entity_email_0_quickAddPersonEmailType_component";
    public static final String quickAddPersonEmailTypeDropdownList = "#entity_email_0_quickAddPersonEmailType_dropdown_menu";
    public static final String quickAddPersonPhoneNumberField = "#entity_phone_0_quickAddPersonPhoneNumber";
    public static final String quickAddPersonPhoneTypeDropdown = "div#entity_phone_0_quickAddPersonPhoneType_component";
    public static final String quickAddPersonPhoneTypeDropdownList = "#entity_phone_0_quickAddPersonPhoneType_dropdown_menu";
    public static final String quickAddPersonOptInMethodDropdown = "#entity_email_0_quickAddPersonOptInMethod_toggle";
    public static final String quickAddPersonOptInMethodDropdownList = "#entity_email_0_quickAddPersonOptInMethod_dropdown_menu";
    public static final String quickAddPersonAddress1Field = "#entity_address_0_quickAddPersonAddress1";
    public static final String quickAddPersonAddress2Field = "#entity_address_0_quickAddPersonAddress2";
    public static final String quickAddPersonAddress3Field = "#entity_address_0_quickAddPersonAddress3";
    public static final String quickAddPersonAddress4Field = "#entity_address_0_quickAddPersonAddress4";
    public static final String quickAddPersonCityField = "#entity_address_0_quickAddPersonAddressCity";
    public static final String quickAddPersonStateDropdown = "div#entity_address_0_quickAddPersonAddressState_component";
    public static final String quickAddPersonStateDropdownList = "#entity_address_0_quickAddPersonAddressState_dropdown_menu";
    public static final String quickAddPersonCountryDropdown = "div#entity_address_0_quickAddPersonAddressCountry_component";
    public static final String quickAddPersonCountryDropdownList = "#entity_address_0_quickAddPersonAddressCountry_dropdown_menu";
    public static final String quickAddPersonPostalCodeField = "#entity_address_0_quickAddPersonAddressPostalCode";
    public static final String quickAddPersonRegionField = "#entity_address_0_quickAddPersonAddressRegion";
    public static final String quickAddPersonRoleDropdown = "div#quickAddPersonPersonRole_component";
    public static final String quickAddPersonRoleDropdownList = "#quickAddPersonPersonRole_dropdown_menu";
    public static final String quickAddStudentStatusCategoryDropdown = "div#person_student_status_0_quickAddPersonStudentStatusCategory_component";
    public static final String quickAddStudentStatusCategoryDropdownList = "#person_student_status_0_quickAddPersonStudentStatusCategory_dropdown_menu";
    public static final String quickAddStudentStatusDropdown = "div#person_student_status_0_quickAddPersonStudentStatus_component";
    public static final String quickAddStudentStatusDropdownList = "#person_student_status_0_quickAddPersonStudentStatus_dropdown_menu";
    public static final String quickAddStudentTypeDropdown = "div#quickAddPersonStudentType_component";
    public static final String quickAddStudentTypeDropdownList = "#quickAddPersonStudentType_dropdown_menu";
    public static final String quickAddStudentStatusDateField = "#person_student_status_0_quickAddPersonStudentStatusDate";
    public static final String quickAddStudentStatusEntryTermDropdown = "div#person_student_status_0_quickAddPersonStatusEntryTerm_component";
    public static final String quickAddStudentStatusEntryTermDropdownList = "#person_student_status_0_quickAddPersonStatusEntryTerm_dropdown_menu";
    public static final String quickAddPersonSaveGoButton = "#modalSubmitButtonquickAddPersonSaveGo";
    public static final String quickAddPersonSaveCloseButton = "#modalSubmitButtonquickAddPersonSaveClose";
    /*
     * Quick Add Organization Css
     */
    public static final String quickAddOrgOrganizationNameField = "#org_name_0_quickAddOrganizationOrgName";
    public static final String quickAddOrgPhoneNumberField = "#entity_phone_0_quickAddOrganizationPhoneNumber";
    public static final String quickAddOrgRoleDropdown = "#quickAddOrganizationOrgRole_component";
    public static final String quickAddOrgRoleDropdownList = "#quickAddOrganizationOrgRole_dropdown_menu";
    public static final String quickAddOrgPhoneTypeDropdown = "#entity_phone_0_quickAddOrganizationPhoneType_component";
    public static final String quickAddOrgPhoneTypeDropdownList = "#entity_phone_0_quickAddOrganizationPhoneType_dropdown_menu";
    public static final String quickAddOrgAddress1Field = "#entity_address_0_quickAddOrganizationAddress1";
    public static final String quickAddOrgAddress2Field = "#entity_address_0_quickAddOrganizationAddress2";
    public static final String quickAddOrgAddress3Field = "#entity_address_0_quickAddOrganizationAddress3";
    public static final String quickAddOrgAddress4Field = "#entity_address_0_quickAddOrganizationAddress4";
    public static final String quickAddOrgCityField = "#entity_address_0_quickAddOrganizationAddressCity";
    public static final String quickAddOrgStateDropdown = "#entity_address_0_quickAddOrganizationAddressState_component";
    public static final String quickAddOrgStateDropdownList = "#entity_address_0_quickAddOrganizationAddressState_dropdown_menu";
    public static final String quickAddOrgRegionField = "#entity_address_0_quickAddOrganizationAddressRegion";
    public static final String quickAddOrgPostalCodeField = "#entity_address_0_quickAddOrganizationAddressPostalCode";
    public static final String quickAddOrgCountryDropdown = "#entity_address_0_quickAddOrganizationAddressCountry_component";
    public static final String quickAddOrgCountryDropdownList = "#entity_address_0_quickAddOrganizationAddressCountry_dropdown_menu";
    public static final String quickAddOrgSaveGoButton = "#modalSubmitButtonquickAddOrganizationSaveGo";
    /*
     * Quick Add Staff Css
     */
    public static final String quickAddStaffModal = "#quickAddStaffModal";
    public static final String quickAddStaffModalLabel = "#quickAddStaffModalLabel";
    public static final String quickAddStaffFirstNameField = "#quickAddStaffNameFirst";
    public static final String quickAddStaffLastNameField = "#quickAddStaffNameLast";
    public static final String quickAddStaffEmailAddressField = "#quickAddStaffEmailAddress";
    public static final String quickAddStaffEmailTypeDropdown = "#s2id_quickAddStaffEmailType.select2-container.form-control.select2 a";
    public static final String quickAddStaffAccountStartDate = "#quickAddStaffDatetimepickerStart";
    public static final String quickAddStaffAccountEndDate = "#quickAddStaffDatetimepickerEnd";
    public static final String quickAddStaffPermissionsGroupDropdown = "#s2id_quickAddStaffPermissionGroup.select2-container.form-control.select2 a";
    public static final String quickAddStaffPermissionsGroupDropdownList = "#select2-results-1";
    public static final String quickAddStaffSaveGoButton = "#quickAddStaffModalSaveGo";
    public static final String quickAddStaffSaveCloseButton = "#quickAddStaffModalSaveClose";
    public static final String footerToolsSchedulerMenuItem = "#global_nav_scheduler";


    public static void validateTaskInToolMenuIsNotDisplayed(){
        try {
            waitUntilElementToBeSelected(By.cssSelector(footerToolsSchedulerMenuItem),20);
            if (!checkIfElementIsVisible(By.cssSelector(footerToolsTasksMenuItem))){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_IN_TOOL_MENU_NOT_DISPLAYED_PASS);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_IN_TOOL_MENU_NOT_DISPLAYED_PASS_FAIL);
        }
    }

    /*
     * Method to create a Person
     */
    public static void createPerson(DataTable data) {
        try {
            navigateQuickAddCreatePersonPage();
            quickAddPerson(data);
            quickAddPersonSaveGoButton();
        } catch (Exception e) {
            System.err.println(LogPage.CREATE_PERSON_FAIL);
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
            System.err.println(LogPage.CREATE_ORGANIZATION_FAIL);
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
            System.err.println(LogPage.CREATE_STAFF_FAIL);
        }
    }

    /*
     * Method to go to Home Page
     */
    public static void goToHomePage() {
        try {
            BasePage.click(By.id(fireWorksIcon));
            ExtentReportsSetUp.testingPass(LogPage.GO_TO_HOME_PAGE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.GO_TO_HOME_PAGE_FAIL);
        }
    }

    /*
     * Method to go to quick add person page
     */
    public static void navigateQuickAddCreatePersonPage() {
        try {
            BasePage.click(By.cssSelector(footerQuickAddMen));
            waitElementBy(By.cssSelector(footerQuickAddPersonMenuItem),20);
            BasePage.click(By.cssSelector(footerQuickAddPersonMenuItem));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_QUICK_ADD_CREATE_PERSON_PAGE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_QUICK_ADD_CREATE_PERSON_PAGE_FAIL);
        }
    }

    /*
     * Method to go to quick add organization page
     */
    public static void navigateQuickAddCreateOrganizationPage() {
        try {
            BasePage.wait(1000);
            BasePage.click(By.cssSelector(footerQuickAddMen));
            BasePage.wait(1000);
            BasePage.click(By.cssSelector(footerQuickAddOrganizationMenuItem));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_QUICK_ADD_CREATE_CREATE_ORGANIZATION_PAGE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_QUICK_ADD_CREATE_CREATE_ORGANIZATION_PAGE_FAIL);
        }
    }

    /*
     * Method to go to quick add staff page
     */
    public static void navigateQuickAddCreateStaffPage() {
        try {
            BasePage.wait(1000);
            BasePage.click(By.cssSelector(footerQuickAddMen));
            BasePage.wait(1000);
            BasePage.click(By.cssSelector(footerQuickAddStaffMenuItem));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_QUICK_ADD_CREATE_CREATE_STAFF_PAGE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_QUICK_ADD_CREATE_CREATE_STAFF_PAGE_FAIL);
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
            if (mass.get(0).get("StudentType") != null) {
                BasePage.click(By.cssSelector(quickAddStudentTypeDropdown));
                BasePage.selectElementsList(quickAddStudentTypeDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("StudentType"));
            }
            if (mass.get(0).get("StudentStatusCategory") != null) {
                BasePage.click(By.cssSelector(quickAddStudentStatusCategoryDropdown));
                BasePage.selectElementsList(quickAddStudentStatusCategoryDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("StudentStatusCategory"));
            }
            if (mass.get(0).get("StudentStatus") != null) {
                BasePage.click(By.cssSelector(quickAddStudentStatusDropdown));
                BasePage.selectElementsList(quickAddStudentStatusDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("StudentStatus"));
            }
            if (mass.get(0).get("StudentStatusDate") != null) {
                BasePage.write(By.cssSelector(quickAddStudentStatusDateField), mass.get(0).get("StudentStatusDate"));
            }
            if (mass.get(0).get("EntryTerm") != null) {
                BasePage.click(By.cssSelector(quickAddStudentStatusEntryTermDropdown));
                BasePage.selectElementsList(quickAddStudentStatusEntryTermDropdownList, "a");
                clickOnListOfElements(mass.get(0).get("EntryTerm"));
            }
            ExtentReportsSetUp.testingPass(LogPage.QUICK_ADD_PERSON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.QUICK_ADD_PERSON_FAIL);
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
            ExtentReportsSetUp.testingPass(LogPage.QUICK_ADD_ORGANIZATION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.QUICK_ADD_ORGANIZATION_FAIL);
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
            ExtentReportsSetUp.testingPass(LogPage.QUICK_ADD_STAFF_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.QUICK_ADD_STAFF_FAIL);
        }
    }

    /*
     * Method to click on Save and Go button in Add Person Page
     */
    public static void quickAddPersonSaveGoButton() {
        try {
            click(By.cssSelector(quickAddPersonSaveGoButton));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_QUICK_ADD_PERSON_SAVE_AND_GO_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_QUICK_ADD_PERSON_SAVE_AND_GO_FAIL);
        }
    }

    /*
     * Method to click on Save and Go button in Add Organization Page
     */
    public static void quickAddOrganizationSaveGoButton() {
        try {
            click(By.cssSelector(quickAddOrgSaveGoButton));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_QUICK_ADD_ORGANIZATION_SAVE_AND_GO_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_QUICK_ADD_ORGANIZATION_SAVE_AND_GO_FAIL);
        }
    }

    /*
     * Method to click on Save and Go button in Add Staff Page
     */
    public static void quickAddStaffSaveGoButton() {
        try {
            click(By.cssSelector(quickAddStaffSaveGoButton));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_QUICK_ADD_STAFF_SAVE_AND_GO_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_QUICK_ADD_STAFF_SAVE_AND_GO_FAIL);
        }

    }

    /*
     * Method to validate alert message
     */
    public static void alertMessageAfterAddPerson(String alertMessage) {
        String errorMessage = String.format(LogPage.ALERT_MESSAGE_FAIL, alertMessage);
        String passMessage = String.format(LogPage.ALERT_MESSAGE_PASS, alertMessage);
        try {
            waitElementBy(By.id("alertMessage"), 10);
            if (alertMessageByIdContains("alertMessage", alertMessage)) {
                ExtentReportsSetUp.testingPass(passMessage);
            } else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            System.err.println(errorMessage);
        }
    }

    /*
     * Method to quick search using one String parameter
     */
    public static void quickSearchOneParameter(String parameter) {
        String errorMessage = String.format(LogPage.QUICK_SEARCH_ONE_PARAMETER_FAIL, parameter);
        String passMessage = String.format(LogPage.QUICK_SEARCH_ONE_PARAMETER_PASS, parameter);
        try {
            BasePage.write(By.cssSelector(homeQuickSearchField), mass.get(0).get(parameter));
            BasePage.click(By.cssSelector(homeQuickSearchButton));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    /*
     * Method to quick search from home page partial
     */
    public static void quickSearchQuickPartial(String parameter) {
        String errorMessage = String.format(LogPage.QUICK_SEARCH_PARTIAL_FAIL, parameter);
        String passMessage = String.format(LogPage.QUICK_SEARCH_PARTIAL_PASS, parameter);
        try {
            String data = mass.get(0).get(parameter);
            BasePage.write(By.cssSelector(homeQuickSearchField), data.substring(0, 5));
            BasePage.click(By.cssSelector(homeQuickSearchButton));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    /*
     * Method to navigate to tools
     */
    public static void navigateToTools() {
        try {
            waitUntilElementToBeSelected(By.cssSelector(footerToolsMenu),20);
            BasePage.click(By.cssSelector(footerToolsMenu));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_TOOLS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_TOOLS_FAIl);
        }

    }


    /*
     * Method to navigate to tasks
     */
    public static void navigateToTasks() {
        try {
            BasePage.click(By.cssSelector(footerToolsMenu));
            waitElementBy(By.cssSelector(footerToolsTasksMenuItem),10);
            BasePage.click(By.cssSelector(footerToolsTasksMenuItem));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_TASKS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_TASKS_FAIl);
        }

    }
}
