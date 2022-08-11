package pages.records;

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
    private static String optionalFieldsPlusSign(String group){
        return String.format("#person_financial_aid_%s_addFieldGroupDropdownBtn",group);
    }
    private static String addGroupDropdownElement(String groupType){
        return String.format("//div[contains(text(),'%s')]",groupType);
    }
    private static String conversionOptionalField(String group,String value){
        return String.format("person_financial_aid_interest_%s_%s_toggle",group,value);
    }

    public static void addConversion(String group,String value){
        String passMessage = String.format(LogPage.ADD_CONVERSION_PASS,group,value);
        String failMessage = String.format(LogPage.ADD_CONVERSION_FAIL,group,value);
        try {
            waitUntilElementToBeSelected(By.cssSelector(conversionOptionalField(group,value)),10);
            //click(By.cssSelector());
        } catch (Exception e) {

        }
    }

    public static void addFieldSubFieldRelationshipFieldGroup(String option,String name,String group){
        String passMessage = String.format(LogPage.ADD_FIELD_SUB_FIELD_RELATIONSHIP_FIELD_GROUP_PASS,option,name,group);
        String failMessage = String.format(LogPage.ADD_FIELD_SUB_FIELD_RELATIONSHIP_FIELD_GROUP_FAIL,option,name,group);

        try {
            scrollToElement(By.cssSelector(optionalFieldsPlusSign(group)));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.cssSelector(optionalFieldsPlusSign(group)),10);
            click(By.cssSelector(optionalFieldsPlusSign(group)));
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
    public static String returnMapOptionalFields(String field){
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

    public static void mapOptionalField(String field){
        String passMessage = String.format(LogPage.MAP_OPTIONAL_FIELD_PASS,field);
        String failMessage = String.format(LogPage.MAP_OPTIONAL_FIELD_FAIL,field);
        try {
            String fieldReturn = returnMapOptionalFields(field);
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
        return fieldParameter.get(field);
    }

    public static void mapRequiredFields(String field){
        String passMessage = String.format(LogPage.MAP_REQUIRED_FIELDS_PASS,field);
        String failMessage = String.format(LogPage.MAP_REQUIRED_FIELDS_FAIL,field);
        try {
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
