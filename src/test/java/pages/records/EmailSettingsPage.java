package pages.records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class EmailSettingsPage extends BasePage {
    public static final String CAN_SPAM_ORG_NAME_FIELD = "#org_name";
    public static final String CAN_SPAM_ORG_EMAIL_FIELD = "#org_email";
    public static final String CAN_SPAM_REPLY_TO_EMAIL_FIELD = "#reply_to_email";
    public static final String CAN_SPAM_REPLY_PHONE_NUMBER_FIELD = "#phone_number";
    public static final String CAN_SPAM_ADDRESS1_FIELD = "#address_1";
    public static final String CAN_SPAM_ADDRESS2_FIELD = "#address_2";
    public static final String CAN_SPAM_ADDRESS3_FIELD = "#address_3";
    public static final String CAN_SPAM_ADDRESS4_FIELD = "#address_4";
    public static final String CAN_SPAM_ADDRESS_CITY_FIELD = "#address_city";
    public static final String CAN_SPAM_STATE_DROPDOWN = "#s2id_address_state";
    public static final String CAN_SPAM_STATE_INPUT_FIELD = "#s2id_autogen1_search";
    public static final String CAN_SPAM_REGION = "#address_region";
    public static final String CAN_SPAM_COUNTRY_DROPDOWN = "#s2id_address_country";
    public static final String CAN_SPAM_COUNTRY_INPUT_FIELD = "#s2id_autogen2_search";
    public static final String CAN_SPAM_POSTAL_CODE = "#address_postal_code";
    public static final String TEST_LISTS_TAB = "#emailSettingsNavTab_test_lists";
    public static final String CREATE_TEST_LIST_BUTTON = "#top-controls-create-new-test-list";
    public static final String TEST_LIST_NAME = "#name";
    public static final String TEST_LIST_DESCRIPTION = "#description";
    public static final String TEST_LIST_RECIPIENTS = "#email_addresses";

    public static void updateTestList(String name,String description,String recipients){
        try {
            fillField(By.cssSelector(TEST_LIST_NAME),name);
            fillField(By.cssSelector(TEST_LIST_DESCRIPTION),description);
            fillField(By.cssSelector(TEST_LIST_RECIPIENTS),recipients);
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_TEST_LIST_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_TEST_LIST_FAIL);
        }
    }
    public static void clickCreateTestListButton(){
        try {
            clickOption(By.cssSelector(CREATE_TEST_LIST_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_CREATE_TEST_LIST_BUTTON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_CREATE_TEST_LIST_BUTTON_FAIL);
        }
    }
    public static void clickTestLists(){
        try {
            clickOption(By.cssSelector(TEST_LISTS_TAB));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_TEST_LISTS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_TEST_LISTS_FAIL);
        }
    }
    public static void setCANSPAMDefaultProfile(int index){
        try {
            fillField(By.cssSelector(CAN_SPAM_ORG_NAME_FIELD),mass.get(index).get("OrganizationName"));
            fillField(By.cssSelector(CAN_SPAM_ORG_EMAIL_FIELD),mass.get(index).get("OrganizationEmail"));
            fillField(By.cssSelector(CAN_SPAM_REPLY_TO_EMAIL_FIELD),mass.get(index).get("ReplyToEmail"));
            fillField(By.cssSelector(CAN_SPAM_REPLY_PHONE_NUMBER_FIELD),mass.get(index).get("PhoneNumberEmail"));
            fillField(By.cssSelector(CAN_SPAM_ADDRESS1_FIELD),mass.get(index).get("Address1Email"));
            fillField(By.cssSelector(CAN_SPAM_ADDRESS2_FIELD),mass.get(index).get("Address2Email"));
            fillField(By.cssSelector(CAN_SPAM_ADDRESS3_FIELD),mass.get(index).get("Address3Email"));
            fillField(By.cssSelector(CAN_SPAM_ADDRESS4_FIELD),mass.get(index).get("Address4Email"));
            fillField(By.cssSelector(CAN_SPAM_ADDRESS4_FIELD),mass.get(index).get("Address4Email"));
            fillField(By.cssSelector(CAN_SPAM_ADDRESS_CITY_FIELD),mass.get(index).get("City"));
            selectOptionList(By.cssSelector(CAN_SPAM_STATE_DROPDOWN),
                    mass.get(index).get("State/Province"),
                    By.cssSelector(CAN_SPAM_STATE_INPUT_FIELD));
            fillField(By.cssSelector(CAN_SPAM_REGION),mass.get(index).get("Region"));
            selectOptionList(By.cssSelector(CAN_SPAM_COUNTRY_DROPDOWN),
                    mass.get(index).get("Country"),
                    By.cssSelector(CAN_SPAM_COUNTRY_INPUT_FIELD));
            fillField(By.cssSelector(CAN_SPAM_POSTAL_CODE),mass.get(index).get("PostalCode"));
            ExtentReportsSetUp.testingPass(LogPage.VERIFY_BASIC_IDENTIFICATION_VALUES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_BASIC_IDENTIFICATION_VALUES_FAIL);
        }
    }
}
