package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;

public class GlobalNavPage extends BasePage {

    public static final String FIRE_WORKS_ICON = "smallHeaderLogo";
    public static final String HOME_QUICK_SEARCH_FIELD = "#homeBillboardSearch";
    public static final String HOME_QUICK_SEARCH_BUTTON = "#mainSearchSubmitBtn";

    /*
     * Footer Css
     */
    public static final String FOOTER_NAV_ELEMENT = "#footerNave";
    public static final String FOOTER_QUICK_ADD_MEN = "#global_nav_quick_add_toggle";
    public static final String FOOTER_QUICK_ADD_PERSON_MENU_ITEM = "#global_nav_add_person";
    public static final String FOOTER_QUICK_ADD_ORGANIZATION_MENU_ITEM = "#global_nav_add_org";
    public static final String FOOTER_QUICK_ADD_STAFF_MENU_ITEM = "#global_nav_add_staff";
    public static final String FOOTER_TOOLS_MENU = "#global_nav_tools_toggle";
    public static final String FOOTER_TOOLS_TASKS_MENU_ITEM = "#global_nav_task";

    /*
     * Quick Add Person Css
     */
    public static final String QUICK_ADD_PERSON_FIRST_NAME_FIELD = "#person_name_0_quickAddPersonNameFirst";
    public static final String QUICK_ADD_PERSON_LAST_NAME_FIELD = "#person_name_0_quickAddPersonNameLast";
    public static final String QUICK_ADD_PERSON_EMAIL_ADDRESS_FIELD = "#entity_email_0_quickAddPersonEmailAddress";
    public static final String QUICK_ADD_PERSON_EMAIL_TYPE_DROPDOWN = "#entity_email_0_quickAddPersonEmailType_component";
    public static final String QUICK_ADD_PERSON_EMAIL_TYPE_DROPDOWN_LIST = "#entity_email_0_quickAddPersonEmailType_dropdown_menu";
    public static final String QUICK_ADD_PERSON_PHONE_NUMBER_FIELD = "#entity_phone_0_quickAddPersonPhoneNumber";
    public static final String QUICK_ADD_PERSON_PHONE_TYPE_DROPDOWN = "div#entity_phone_0_quickAddPersonPhoneType_component";
    public static final String QUICK_ADD_PERSON_PHONE_TYPE_DROPDOWN_LIST = "#entity_phone_0_quickAddPersonPhoneType_dropdown_menu";
    public static final String QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN = "#entity_email_0_quickAddPersonOptInMethod_toggle";
    public static final String QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN_LIST = "#entity_email_0_quickAddPersonOptInMethod_dropdown_menu";
    public static final String QUICK_ADD_PERSON_ADDRESS1_FIELD = "#entity_address_0_quickAddPersonAddress1";
    public static final String QUICK_ADD_PERSON_ADDRESS2_FIELD = "#entity_address_0_quickAddPersonAddress2";
    public static final String QUICK_ADD_PERSON_ADDRESS3_FIELD = "#entity_address_0_quickAddPersonAddress3";
    public static final String QUICK_ADD_PERSON_ADDRESS4_FIELD = "#entity_address_0_quickAddPersonAddress4";
    public static final String QUICK_ADD_PERSON_CITY_FIELD = "#entity_address_0_quickAddPersonAddressCity";
    public static final String QUICK_ADD_PERSON_STATE_DROPDOWN = "div#entity_address_0_quickAddPersonAddressState_component";
    public static final String QUICK_ADD_PERSON_STATE_DROPDOWN_LIST = "#entity_address_0_quickAddPersonAddressState_dropdown_menu";
    public static final String QUICK_ADD_PERSON_COUNTRY_DROPDOWN = "div#entity_address_0_quickAddPersonAddressCountry_component";
    public static final String QUICK_ADD_PERSON_COUNTRY_DROPDOWN_LIST = "#entity_address_0_quickAddPersonAddressCountry_dropdown_menu";
    public static final String QUICK_ADD_PERSON_POSTAL_CODE_FIELD = "#entity_address_0_quickAddPersonAddressPostalCode";
    public static final String QUICK_ADD_PERSON_REGION_FIELD = "#entity_address_0_quickAddPersonAddressRegion";
    public static final String QUICK_ADD_PERSON_ROLE_DROPDOWN = "div#quickAddPersonPersonRole_component";
    public static final String QUICK_ADD_PERSON_ROLE_DROPDOWN_LIST = "#quickAddPersonPersonRole_dropdown_menu";
    public static final String QUICK_ADD_STUDENT_STATUS_CATEGORY_DROPDOWN = "div#person_student_status_0_quickAddPersonStudentStatusCategory_component";
    public static final String QUICK_ADD_STUDENT_STATUS_CATEGORY_DROPDOWN_LIST = "#person_student_status_0_quickAddPersonStudentStatusCategory_dropdown_menu";
    public static final String QUICK_ADD_STUDENT_STATUS_DROPDOWN = "div#person_student_status_0_quickAddPersonStudentStatus_component";
    public static final String QUICK_ADD_STUDENT_STATUS_DROPDOWN_LIST = "#person_student_status_0_quickAddPersonStudentStatus_dropdown_menu";
    public static final String QUICK_ADD_STUDENT_TYPE_DROPDOWN = "div#quickAddPersonStudentType_component";
    public static final String QUICK_ADD_STUDENT_TYPE_DROPDOWN_LIST = "#quickAddPersonStudentType_dropdown_menu";
    public static final String QUICK_ADD_STUDENT_STATUS_DATE_FIELD = "#person_student_status_0_quickAddPersonStudentStatusDate";
    public static final String QUICK_ADD_STUDENT_STATUS_ENTRY_TERM_DROPDOWN = "div#person_student_status_0_quickAddPersonStatusEntryTerm_component";
    public static final String QUICK_ADD_STUDENT_STATUS_ENTRY_TERM_DROPDOWN_LIST = "#person_student_status_0_quickAddPersonStatusEntryTerm_dropdown_menu";
    public static final String QUICK_ADD_PERSON_SAVE_GO_BUTTON = "#modalSubmitButtonquickAddPersonSaveGo";
    public static final String QUICK_ADD_PERSON_SAVE_CLOSE_BUTTON = "#modalSubmitButtonquickAddPersonSaveClose";
    /*
     * Quick Add Organization Css
     */
    public static final String QUICK_ADD_ORG_ORGANIZATION_NAME_FIELD = "#org_name_0_quickAddOrganizationOrgName";
    public static final String QUICK_ADD_ORG_PHONE_NUMBER_FIELD = "#entity_phone_0_quickAddOrganizationPhoneNumber";
    public static final String QUICK_ADD_ORG_ROLE_DROPDOWN = "#quickAddOrganizationOrgRole_component";
    public static final String QUICK_ADD_ORG_ROLE_DROPDOWN_LIST = "#quickAddOrganizationOrgRole_dropdown_menu";
    public static final String QUICK_ADD_ORG_PHONE_TYPE_DROPDOWN = "#entity_phone_0_quickAddOrganizationPhoneType_component";
    public static final String QUICK_ADD_ORG_PHONE_TYPE_DROPDOWN_LIST = "#entity_phone_0_quickAddOrganizationPhoneType_dropdown_menu";
    public static final String QUICK_ADD_ORG_ADDRESS1_FIELD = "#entity_address_0_quickAddOrganizationAddress1";
    public static final String QUICK_ADD_ORG_ADDRESS2_FIELD = "#entity_address_0_quickAddOrganizationAddress2";
    public static final String QUICK_ADD_ORG_ADDRESS3_FIELD = "#entity_address_0_quickAddOrganizationAddress3";
    public static final String QUICK_ADD_ORG_ADDRESS4_FIELD = "#entity_address_0_quickAddOrganizationAddress4";
    public static final String QUICK_ADD_ORG_CITY_FIELD = "#entity_address_0_quickAddOrganizationAddressCity";
    public static final String QUICK_ADD_ORG_STATE_DROPDOWN = "#entity_address_0_quickAddOrganizationAddressState_component";
    public static final String QUICK_ADD_ORG_STATE_DROPDOWN_LIST = "#entity_address_0_quickAddOrganizationAddressState_dropdown_menu";
    public static final String QUICK_ADD_ORG_REGION_FIELD = "#entity_address_0_quickAddOrganizationAddressRegion";
    public static final String QUICK_ADD_ORG_POSTAL_CODE_FIELD = "#entity_address_0_quickAddOrganizationAddressPostalCode";
    public static final String QUICK_ADD_ORG_COUNTRY_DROPDOWN = "#entity_address_0_quickAddOrganizationAddressCountry_component";
    public static final String QUICK_ADD_ORG_COUNTRY_DROPDOWN_LIST = "#entity_address_0_quickAddOrganizationAddressCountry_dropdown_menu";
    public static final String QUICK_ADD_ORG_SAVE_GO_BUTTON = "#modalSubmitButtonquickAddOrganizationSaveGo";
    /*
     * Quick Add Staff Css
     */
    public static final String QUICK_ADD_STAFF_MODAL = "#quickAddStaffModal";
    public static final String QUICK_ADD_STAFF_MODAL_LABEL = "#quickAddStaffModalLabel";
    public static final String QUICK_ADD_STAFF_FIRST_NAME_FIELD = "#quickAddStaffNameFirst";
    public static final String QUICK_ADD_STAFF_LAST_NAME_FIELD = "#quickAddStaffNameLast";
    public static final String QUICK_ADD_STAFF_EMAIL_ADDRESS_FIELD = "#quickAddStaffEmailAddress";
    public static final String QUICK_ADD_STAFF_EMAIL_TYPE_DROPDOWN = "#s2id_quickAddStaffEmailType.select2-container.form-control.select2 a";
    public static final String QUICK_ADD_STAFF_ACCOUNT_START_DATE = "#quickAddStaffDatetimepickerStart";
    public static final String QUICK_ADD_STAFF_ACCOUNT_END_DATE = "#quickAddStaffDatetimepickerEnd";
    public static final String QUICK_ADD_STAFF_PERMISSIONS_GROUP_DROPDOWN = "#s2id_quickAddStaffPermissionGroup.select2-container.form-control.select2 a";
    public static final String QUICK_ADD_STAFF_PERMISSIONS_GROUP_DROPDOWN_LIST = "#select2-results-1";
    public static final String QUICK_ADD_STAFF_SAVE_GO_BUTTON = "#quickAddStaffModalSaveGo";
    public static final String QUICK_ADD_STAFF_SAVE_CLOSE_BUTTON = "#quickAddStaffModalSaveClose";
    public static final String FOOTER_TOOLS_SCHEDULER_MENU_ITEM = "#global_nav_scheduler";
    public static final String ACCOUNT_TOGGLE = "global_nav_account_toggle";
    public static final String LOGOUT_BUTTON = "logout_button";


    public static void logout(){
        try {
            waitUntilElementToBeSelected(By.id(ACCOUNT_TOGGLE),20);
            BasePage.click(By.id(ACCOUNT_TOGGLE));
            waitUntilElementToBeSelected(By.id(LOGOUT_BUTTON),20);
            BasePage.click(By.id(LOGOUT_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.LOGOUT_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.LOGOUT_FAIL);
        }


    }


    public static void validateTaskInToolMenuIsNotDisplayed(){
        try {
            waitUntilElementToBeSelected(By.cssSelector(FOOTER_TOOLS_SCHEDULER_MENU_ITEM),20);
            if (!checkIfElementIsVisible(By.cssSelector(FOOTER_TOOLS_TASKS_MENU_ITEM))){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_IN_TOOL_MENU_NOT_DISPLAYED_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_IN_TOOL_MENU_NOT_DISPLAYED_PASS_FAIL);
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
            BasePage.click(By.id(FIRE_WORKS_ICON));
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
            BasePage.click(By.cssSelector(FOOTER_QUICK_ADD_MEN));
            wait(1000);
            BasePage.click(By.cssSelector(FOOTER_QUICK_ADD_PERSON_MENU_ITEM));
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
            BasePage.click(By.cssSelector(FOOTER_QUICK_ADD_MEN));
            BasePage.wait(1000);
            BasePage.click(By.cssSelector(FOOTER_QUICK_ADD_ORGANIZATION_MENU_ITEM));
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
            BasePage.click(By.cssSelector(FOOTER_QUICK_ADD_MEN));
            BasePage.wait(1000);
            BasePage.click(By.cssSelector(FOOTER_QUICK_ADD_STAFF_MENU_ITEM));
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
                BasePage.write(By.cssSelector(QUICK_ADD_PERSON_FIRST_NAME_FIELD), mass.get(0).get("Firstname"));
            }
            if (mass.get(0).get("Lastname") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_PERSON_LAST_NAME_FIELD), mass.get(0).get("Lastname"));
            }
            if (mass.get(0).get("Phone") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_PERSON_PHONE_NUMBER_FIELD), mass.get(0).get("Phone"));
            }
            if (mass.get(0).get("PhoneType") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_PERSON_PHONE_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_PERSON_PHONE_TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("PhoneType"));
            }
            if (mass.get(0).get("Role1") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_PERSON_ROLE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_PERSON_ROLE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Role1"));
            }
            if (mass.get(0).get("Role2") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_PERSON_ROLE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_PERSON_ROLE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Role2"));
            }
            if (mass.get(0).get("EmailAddress") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_PERSON_EMAIL_ADDRESS_FIELD), mass.get(0).get("EmailAddress"));
            }
            if (mass.get(0).get("EmailType") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_PERSON_EMAIL_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_PERSON_EMAIL_TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("EmailType"));
            }
            if (mass.get(0).get("EmailOptInMethod") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("EmailOptInMethod"));
            }
            if (mass.get(0).get("Address1") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_PERSON_ADDRESS1_FIELD), mass.get(0).get("Address1"));
            }
            if (mass.get(0).get("Address2") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_PERSON_ADDRESS1_FIELD), mass.get(0).get("Address2"));
            }
            if (mass.get(0).get("Address3") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_PERSON_ADDRESS1_FIELD), mass.get(0).get("Address3"));
            }
            if (mass.get(0).get("Address4") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_PERSON_ADDRESS1_FIELD), mass.get(0).get("Address4"));
            }
            if (mass.get(0).get("City") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_PERSON_CITY_FIELD), mass.get(0).get("City"));
            }
            if (mass.get(0).get("State") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_PERSON_STATE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_PERSON_STATE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("State"));
            }
            if (mass.get(0).get("PostalCode") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_PERSON_POSTAL_CODE_FIELD), mass.get(0).get("PostalCode"));
            }
            if (mass.get(0).get("Country") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_PERSON_COUNTRY_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_PERSON_COUNTRY_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Country"));
            }
            if (mass.get(0).get("StudentType") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_STUDENT_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_STUDENT_TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("StudentType"));
            }
            if (mass.get(0).get("StudentStatusCategory") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_STUDENT_STATUS_CATEGORY_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_STUDENT_STATUS_CATEGORY_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("StudentStatusCategory"));
            }
            if (mass.get(0).get("StudentStatus") != null) {
                scrollToElement(By.cssSelector(QUICK_ADD_STUDENT_TYPE_DROPDOWN));
                BasePage.click(By.cssSelector(QUICK_ADD_STUDENT_STATUS_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_STUDENT_STATUS_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("StudentStatus"));
            }
            if (mass.get(0).get("StudentStatusDate") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_STUDENT_STATUS_DATE_FIELD), mass.get(0).get("StudentStatusDate"));
            }
            if (mass.get(0).get("EntryTerm") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_STUDENT_STATUS_ENTRY_TERM_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_STUDENT_STATUS_ENTRY_TERM_DROPDOWN_LIST), "a");
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
                BasePage.write(By.cssSelector(QUICK_ADD_ORG_ORGANIZATION_NAME_FIELD), mass.get(0).get("Name"));
            }
            if (mass.get(0).get("Role") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_ORG_ROLE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_ORG_ROLE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Role"));
            }
            if (mass.get(0).get("Phone") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_ORG_PHONE_NUMBER_FIELD), mass.get(0).get("Phone"));
            }
            if (mass.get(0).get("PhoneType") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_ORG_PHONE_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_ORG_PHONE_TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("PhoneType"));
            }
            if (mass.get(0).get("Address1") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_ORG_ADDRESS1_FIELD), mass.get(0).get("Address1"));
            }
            if (mass.get(0).get("Address2") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_ORG_ADDRESS2_FIELD), mass.get(0).get("Address2"));
            }
            if (mass.get(0).get("Address3") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_ORG_ADDRESS3_FIELD), mass.get(0).get("Address3"));
            }
            if (mass.get(0).get("Address4") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_ORG_ADDRESS4_FIELD), mass.get(0).get("Address4"));
            }
            if (mass.get(0).get("City") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_ORG_CITY_FIELD), mass.get(0).get("City"));
            }
            if (mass.get(0).get("State") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_ORG_STATE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_ORG_STATE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("State"));
            }
            if (mass.get(0).get("PostalCode") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_ORG_POSTAL_CODE_FIELD), mass.get(0).get("PostalCode"));
            }
            if (mass.get(0).get("Country") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_ORG_COUNTRY_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_ORG_COUNTRY_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("Country"));
            }
            if (mass.get(0).get("Region") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_ORG_REGION_FIELD), mass.get(0).get("Region"));
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
                BasePage.write(By.cssSelector(QUICK_ADD_STAFF_FIRST_NAME_FIELD), mass.get(0).get("Firstname"));
            }
            if (mass.get(0).get("Lastname") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_STAFF_LAST_NAME_FIELD), mass.get(0).get("Lastname"));
            }
            if (mass.get(0).get("EmailAddress") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_STAFF_EMAIL_ADDRESS_FIELD), mass.get(0).get("EmailAddress"));
            }
            if (mass.get(0).get("AccountStartDate") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_STAFF_ACCOUNT_START_DATE), mass.get(0).get("AccountStartDate"));
            }
            if (mass.get(0).get("AccountEndDate") != null) {
                BasePage.write(By.cssSelector(QUICK_ADD_STAFF_ACCOUNT_END_DATE), mass.get(0).get("AccountEndDate"));
            }
            if (mass.get(0).get("PermissionGroup") != null) {
                BasePage.click(By.cssSelector(QUICK_ADD_STAFF_PERMISSIONS_GROUP_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(QUICK_ADD_STAFF_PERMISSIONS_GROUP_DROPDOWN_LIST), "a");
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
            click(By.cssSelector(QUICK_ADD_PERSON_SAVE_GO_BUTTON));
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
            click(By.cssSelector(QUICK_ADD_ORG_SAVE_GO_BUTTON));
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
            click(By.cssSelector(QUICK_ADD_STAFF_SAVE_GO_BUTTON));
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
            BasePage.write(By.cssSelector(HOME_QUICK_SEARCH_FIELD), mass.get(0).get(parameter));
            BasePage.click(By.cssSelector(HOME_QUICK_SEARCH_BUTTON));
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
            BasePage.write(By.cssSelector(HOME_QUICK_SEARCH_FIELD), data.substring(0, 5));
            BasePage.click(By.cssSelector(HOME_QUICK_SEARCH_BUTTON));
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
            waitUntilElementToBeSelected(By.cssSelector(FOOTER_TOOLS_MENU),20);
            BasePage.click(By.cssSelector(FOOTER_TOOLS_MENU));
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
            BasePage.click(By.cssSelector(FOOTER_TOOLS_MENU));
            waitElementBy(By.cssSelector(FOOTER_TOOLS_TASKS_MENU_ITEM),10);
            BasePage.click(By.cssSelector(FOOTER_TOOLS_TASKS_MENU_ITEM));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_TASKS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_TASKS_FAIl);
        }

    }
}
