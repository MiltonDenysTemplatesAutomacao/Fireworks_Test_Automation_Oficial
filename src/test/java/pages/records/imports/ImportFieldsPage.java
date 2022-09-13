package pages.records.imports;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.KeyPage;
import pages.LogPage;

import java.util.HashMap;
import java.util.Map;

public class ImportFieldsPage extends BasePage {

    private static final String DROPDOWN_INPUT_FIELD_ELEMENT = "#select2-drop.select2-drop.select2-display-none.select2-with-searchbox.select2-drop-active div.select2-search input";
    private static final String OPTIONAL_FIELDS_PLUS_SIGN_LIST = "//*[@id='importsPackagesCreateEditOptionalForm']/div/div[1]/div[2]/div[2]/div[3]/div[1]/div/div/div[2]/div/div[1]/ul";
    private static final String OPTIONAL_FIELDS_PLUS_SIGN = "//button[contains(@id,'addFieldGroupDropdownBtn')]";

    private static String fieldSourceDropdown(String field){
        return String.format("//div[contains(@id, '_%s_source')]",field);
    }
    private static String fieldGroupDropdownElement(String field){
        return String.format("//div[contains(@id, 'conversionFieldGroupSelect_%s')]",field);
    }
    private static String inputFieldGroup(String field){
        return String.format("#conversionFieldGroupSelect_%s_search",field);
    }
    private static String optionalDropdownMenuFieldGroupSelect(String field){
        return String.format("#conversionFieldGroupSelect_%s_dropdown_menu",field);
    }
    private static String inputOptionalFieldElement(String field){
        return String.format("//input[contains(@id, '_%s_source_search')]",field);
    }
    private static String optionalDropdownMenuFieldGroupSelectName(String field){
        return String.format("//ul[contains(@id, '_%s_source_dropdown_menu')]",field);
    }
//    private static String optionalFieldsPlusSign(String fieldGroup,String group){
//        return String.format("#person_%s_%s_addFieldGroupDropdownBtn",fieldGroup,group);
//    }
    private static String optionalFieldsPlusSign(String group){
        return String.format("//button[contains(@id, '_%s_addFieldGroupDropdownBtn')]",group);
    }
    private static String addGroupDropdownElement(String groupType){
        return String.format("//div[contains(text(),'%s')]",groupType);
    }
    private static String conversionOptionalField(String group,String value){
        return String.format("#person_financial_aid_interest_%s_%s_toggle",group,value);
    }
    private static String conversionOptionalFieldDropDownMenu(String group,String value){
        return String.format("#person_financial_aid_interest_%s_%s_dropdown_menu",group,value);
    }
    public static String returnMapCouselorFields(String field){
        Map<String, String> fieldParameter = new HashMap<String, String>();
        fieldParameter.put("COUNSELOR", "counselor_entity_id");
        fieldParameter.put("Date of Import", "counselor_date_assigned");
        return fieldParameter.get(field);
    }
    public static void mapCounselorOptionalField(String field){
        String passMessage = String.format(LogPage.MAP_COUSELOR_OPTIONAL_FIELD_PASS,field);
        String failMessage = String.format(LogPage.MAP_COUSELOR_OPTIONAL_FIELD_FAIL,field);
        try {
            String fieldReturn = returnMapCouselorFields(field);
            wait(1000);
            scrollToElement(By.xpath(fieldSourceDropdown(fieldReturn)));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.xpath(fieldSourceDropdown(fieldReturn)),10);
            click(By.xpath(fieldSourceDropdown(fieldReturn)));
            waitUntilElementToBeSelected(By.xpath(inputOptionalFieldElement(fieldReturn)),10);
            write(By.xpath(inputOptionalFieldElement(fieldReturn)),field);
            BasePage.selectElementsList(By.xpath(optionalDropdownMenuFieldGroupSelectName(fieldReturn)), "a");
            clickOnListOfElements(field);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static String returnMapPaymentFields(String field){
        Map<String, String> fieldParameter = new HashMap<String, String>();
        fieldParameter.put("PAYT_TYPE", "payment_type");
        fieldParameter.put("PAYT_AMOUNT", "payment_amount");
        fieldParameter.put("RECVD_DATE", "payment_date");
        fieldParameter.put("PAYT_WHO", "payment_who");
        fieldParameter.put("PAYT_PURPOSE", "payment_purpose");
        fieldParameter.put("PAYT_COMMENT", "payment_comment");
        return fieldParameter.get(field);
    }

    public static void mapPaymentOptionalField(String field){
        String passMessage = String.format(LogPage.MAP_PAYMENT_OPTIONAL_FIELD_PASS,field);
        String failMessage = String.format(LogPage.MAP_PAYMENT_OPTIONAL_FIELD_FAIL,field);
        try {
            String fieldReturn = returnMapPaymentFields(field);
            wait(1000);
            scrollToElement(By.xpath(fieldSourceDropdown(fieldReturn)));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.xpath(fieldSourceDropdown(fieldReturn)),10);
            click(By.xpath(fieldSourceDropdown(fieldReturn)));
            waitUntilElementToBeSelected(By.xpath(inputOptionalFieldElement(fieldReturn)),10);
            write(By.xpath(inputOptionalFieldElement(fieldReturn)),field);
            BasePage.selectElementsList(By.xpath(optionalDropdownMenuFieldGroupSelectName(fieldReturn)), "a");
            clickOnListOfElements(field);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void addFieldGroup(String option){
        String passMessage = String.format(LogPage.ADD_FIELD_GROUP_PASS,option);
        String failMessage = String.format(LogPage.ADD_FIELD_GROUP_FAIL,option);
        try {
            scrollToElement(By.xpath(OPTIONAL_FIELDS_PLUS_SIGN));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.xpath(OPTIONAL_FIELDS_PLUS_SIGN),10);
            click(By.xpath(OPTIONAL_FIELDS_PLUS_SIGN));
            waitUntilElementToBeSelected(By.xpath(OPTIONAL_FIELDS_PLUS_SIGN_LIST),10);
            BasePage.selectElementsList(By.xpath(OPTIONAL_FIELDS_PLUS_SIGN_LIST), "li");
            clickOnListOfElementsContains(option);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static String returnMapConversionFields(String field){
        Map<String, String> fieldParameter = new HashMap<String, String>();
        fieldParameter.put("Static Value", "aid_expressed_interest_static_value");
        return fieldParameter.get(field);
    }

    public static void addConversion(String option,String value,String group){
        String passMessage = String.format(LogPage.ADD_CONVERSION_PASS,option,value,group);
        String failMessage = String.format(LogPage.ADD_CONVERSION_FAIL,option,value,group);
        try {
            String returnConversion = returnMapConversionFields(option);
            scrollToElement(By.cssSelector(conversionOptionalField(group,returnConversion)));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.cssSelector(conversionOptionalField(group,returnConversion)),10);
            click(By.cssSelector(conversionOptionalField(group,returnConversion)));
            waitUntilElementToBeSelected(By.cssSelector(conversionOptionalField(group,returnConversion)),10);
            BasePage.selectElementsList(By.cssSelector(conversionOptionalFieldDropDownMenu(group,returnConversion)), "a");
            clickOnListOfElements(value);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static String returnAddFieldSubFieldRelationshipFieldGroup(String name){
        Map<String, String> fieldParameter = new HashMap<String, String>();
        fieldParameter.put("Application", "application");
        fieldParameter.put("Financial Aid", "financial_aid");
        fieldParameter.put("Payment", "payment");
        return fieldParameter.get(name);
    }

    public static void addFieldSubFieldRelationshipFieldGroup(String option,String name,String group,String fieldGroup){
        String passMessage = String.format(LogPage.ADD_FIELD_SUB_FIELD_RELATIONSHIP_FIELD_GROUP_PASS,option,name,group,fieldGroup);
        String failMessage = String.format(LogPage.ADD_FIELD_SUB_FIELD_RELATIONSHIP_FIELD_GROUP_FAIL,option,name,group,fieldGroup);

        try {
            scrollToElement(By.xpath(optionalFieldsPlusSign(group)));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.xpath(optionalFieldsPlusSign(group)),10);
            click(By.xpath(optionalFieldsPlusSign(group)));
            waitUntilElementToBeSelected(By.xpath(OPTIONAL_FIELDS_PLUS_SIGN_LIST),10);
            BasePage.selectElementsList(By.xpath(OPTIONAL_FIELDS_PLUS_SIGN_LIST), "li");
            clickOnListOfElementsContains(option);
            addGroup(option,name,group);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void addGroup(String option,String name,String group)throws Exception{
            scrollToElement(By.xpath(addGroupDropdownElement(option)));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.xpath(addGroupDropdownElement(option)),10);
            click(By.xpath(addGroupDropdownElement(option)));
            waitElementBy(By.xpath(addGroupDropdownElement(option)),10);
            write(By.cssSelector(inputFieldGroup(group)),name);
            BasePage.selectElementsList(By.cssSelector(optionalDropdownMenuFieldGroupSelect(group)), "a");
            clickOnListOfElements(name);
    }
    public static String returnMapApplicationOptionalFields(String field){
        Map<String, String> fieldParameter = new HashMap<String, String>();
        fieldParameter.put("ENTRY_TERM", "application_entry_term");
        fieldParameter.put("APP_SOURCE", "application_source");
        fieldParameter.put("APP_TYPE", "application_type");
        fieldParameter.put("COMPLETE_DATE", "application_completion_date");
        fieldParameter.put("HOUSING", "application_housing");
        fieldParameter.put("APP_COMMENTS", "application_comments");
        fieldParameter.put("MAJOR1", "application_major_1");
        fieldParameter.put("CONCENTRATION", "application_concentration");
        fieldParameter.put("COMP_STATUS", "application_status");
        fieldParameter.put("RECVD_DATE", "application_started_date");
        fieldParameter.put("APPLIED_GRADE", "application_for_grade");
        fieldParameter.put("MAJOR2", "application_major_2");
        fieldParameter.put("MAJOR3", "application_major_3");
        fieldParameter.put("MINOR", "application_minor");
        fieldParameter.put("DEGREE", "application_degree_type");
        fieldParameter.put("REVIWED_FOR", "person_application_review_0_application_review_factor");
        fieldParameter.put("RATING", "person_application_review_0_application_review_rating");
        fieldParameter.put("REVIEWED_BY", "person_application_review_0_application_review_reader");
        fieldParameter.put("REVIEW_COMMENTS", "person_application_review_0_application_review_comments");
        fieldParameter.put("REVIWED_FOR", "person_application_review_0_application_review_factor");
        fieldParameter.put("REVIEW_DATE", "person_application_review_0_application_review_date");


        return fieldParameter.get(field);
    }
    public static void mapApplicationOptionalField(String field){
        String passMessage = String.format(LogPage.MAP_APPLICATION_OPTIONAL_FIELD_PASS,field);
        String failMessage = String.format(LogPage.MAP_APPLICATION_OPTIONAL_FIELD_FAIL,field);
        try {
            String fieldReturn = returnMapApplicationOptionalFields(field);
            scrollToElement(By.xpath(fieldSourceDropdown(fieldReturn)));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.xpath(fieldSourceDropdown(fieldReturn)),10);
            click(By.xpath(fieldSourceDropdown(fieldReturn)));
            waitUntilElementToBeSelected(By.xpath(inputOptionalFieldElement(fieldReturn)),10);
            write(By.xpath(inputOptionalFieldElement(fieldReturn)),field);
            BasePage.selectElementsList(By.xpath(optionalDropdownMenuFieldGroupSelectName(fieldReturn)), "a");
            clickOnListOfElements(field);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static String returnMapFinancialAidOptionalFields(String field){
        Map<String, String> fieldParameter = new HashMap<String, String>();
        fieldParameter.put("ENTRY_TERM", "financial_aid_term");
        fieldParameter.put("APP_STATUS", "financial_aid_status");
        fieldParameter.put("APP_TYPE", "financial_aid_type");
        fieldParameter.put("RECVD_DATE", "financial_aid_date_received");
        fieldParameter.put("DESIRABILITY", "financial_aid_desirability_score");
        fieldParameter.put("NEED_SCORE", "financial_aid_need_score");
        fieldParameter.put("AWARD_CAT", "person_financial_aid_award_component_0_award_category");
        fieldParameter.put("AWARD_TYPE", "person_financial_aid_award_component_0_award_type");
        fieldParameter.put("AWARD_AMT", "person_financial_aid_award_component_0_award_amount");
        fieldParameter.put("AWARD_COMMENTS", "person_financial_aid_award_component_0_award_comments");
        fieldParameter.put("INTEREST_CATEGORY", "aid_interest_category");
        fieldParameter.put("INTEREST_TYPE", "aid_interest_type");
        fieldParameter.put("Static Value", "aid_expressed_interest");
        return fieldParameter.get(field);
    }

    public static void mapFinancialAidOptionalField(String field){
        String passMessage = String.format(LogPage.MAP_FINANCIAL_AID_OPTIONAL_FIELD_PASS,field);
        String failMessage = String.format(LogPage.MAP_FINANCIAL_AID_OPTIONAL_FIELD_FAIL,field);
        try {
            String fieldReturn = returnMapFinancialAidOptionalFields(field);
            scrollToElement(By.xpath(fieldSourceDropdown(fieldReturn)));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.xpath(fieldSourceDropdown(fieldReturn)),10);
            click(By.xpath(fieldSourceDropdown(fieldReturn)));
            waitUntilElementToBeSelected(By.xpath(inputOptionalFieldElement(fieldReturn)),10);
            write(By.xpath(inputOptionalFieldElement(fieldReturn)),field);
            BasePage.selectElementsList(By.xpath(optionalDropdownMenuFieldGroupSelectName(fieldReturn)), "a");
            clickOnListOfElements(field);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static String returnMapFinancialAidInterestsOptionalFields(String field){
        Map<String, String> fieldParameter = new HashMap<String, String>();
        fieldParameter.put("RECVD_DATE", "aid_expressed_interest_date");
        return fieldParameter.get(field);
    }
    public static void mapFinancialAidInterestsOptionalField(String field){
        String passMessage = String.format(LogPage.MAP_FINANCIAL_AID_INTERESTS_OPTIONAL_FIELD_PASS,field);
        String failMessage = String.format(LogPage.MAP_FINANCIAL_AID_INTERESTS_OPTIONAL_FIELD_FAIL,field);
        try {
            String fieldReturn = returnMapFinancialAidInterestsOptionalFields(field);
            scrollToElement(By.xpath(fieldSourceDropdown(fieldReturn)));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.xpath(fieldSourceDropdown(fieldReturn)),10);
            click(By.xpath(fieldSourceDropdown(fieldReturn)));
            waitUntilElementToBeSelected(By.xpath(inputOptionalFieldElement(fieldReturn)),10);
            write(By.xpath(inputOptionalFieldElement(fieldReturn)),field);
            BasePage.selectElementsList(By.xpath(optionalDropdownMenuFieldGroupSelectName(fieldReturn)), "a");
            clickOnListOfElements(field);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void addOptionalFieldGroup(String group,String name){
        String passMessage = String.format(LogPage.ADD_OPTIONAL_FIELD_GROUP_PASS,group);
        String failMessage = String.format(LogPage.ADD_OPTIONAL_FIELD_GROUP_FAIL,group);
        try {
            waitUntilElementToBeSelected(By.xpath(fieldGroupDropdownElement(group)),10);
            scrollToElement(By.xpath(fieldGroupDropdownElement(group)));
            scrollTo("-150");
            click(By.xpath(fieldGroupDropdownElement(group)));
            waitElementBy(By.cssSelector(inputFieldGroup(group)),10);
            write(By.cssSelector(inputFieldGroup(group)),name);
            BasePage.selectElementsList(By.cssSelector(optionalDropdownMenuFieldGroupSelect(group)), "a");
            clickOnListOfElements(name);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static String returnMapRequiredFields(String field){
        Map<String, String> fieldParameter = new HashMap<String, String>();
        fieldParameter.put("Student Type", "student_type");
        fieldParameter.put("Student Status Category", "student_status_category");
        fieldParameter.put("Student Status Field", "student_status");
        fieldParameter.put("Entry Term", "status_entry_term");
        fieldParameter.put("Student Status Date", "student_status_date");
        fieldParameter.put("Role", "person_role");
        fieldParameter.put("First Name", "name_first");
        fieldParameter.put("Last Name", "name_last");
        fieldParameter.put("Email Address", "email_address");
        fieldParameter.put("Email Type", "email_type");
        fieldParameter.put("Opt In Method", "opt_in_method_id");
        fieldParameter.put("Phone Number", "phone_number");
        fieldParameter.put("Phone Type", "phone_type");
        fieldParameter.put("STUDENT_TYPE", "student_type");
        fieldParameter.put("STUDENT_CATEGORY", "student_status_category");
        fieldParameter.put("STUDENT_STATUS", "student_status");
        fieldParameter.put("ENTRY_TERM", "status_entry_term");
        fieldParameter.put("STATUS_DATE", "student_status_date");
        fieldParameter.put("ROLE", "person_role");
        fieldParameter.put("FIRST_NAME", "name_first");
        fieldParameter.put("LAST_NAME", "name_last");
        fieldParameter.put("EMAIL_ADDRESS", "email_address");
        fieldParameter.put("EMAIL_TYPE", "email_type");
        fieldParameter.put("OPTIN", "opt_in_method_id");
        fieldParameter.put("PHONE_NUMBER", "phone_number");
        fieldParameter.put("PHONE_TYPE", "phone_type");
        return fieldParameter.get(field);
    }

    public static void mapRequiredFields(String field){
        String passMessage = String.format(LogPage.MAP_REQUIRED_FIELDS_PASS,field);
        String failMessage = String.format(LogPage.MAP_REQUIRED_FIELDS_FAIL,field);
        try {
            wait(1000);
            String fieldReturn = returnMapRequiredFields(field);
            scrollToElement(By.xpath(fieldSourceDropdown(fieldReturn)));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.xpath(fieldSourceDropdown(fieldReturn)),10);
            click(By.xpath(fieldSourceDropdown(fieldReturn)));
            waitUntilElementToBeSelected(By.cssSelector(DROPDOWN_INPUT_FIELD_ELEMENT),10);
            write(By.cssSelector(DROPDOWN_INPUT_FIELD_ELEMENT),field);
            KeyPage.pressKey(By.cssSelector(DROPDOWN_INPUT_FIELD_ELEMENT),"Enter");
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
