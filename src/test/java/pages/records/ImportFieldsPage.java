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

    private static String fieldSourceDropdown(String field){
        return String.format("//div[contains(@id, '_%s_source')]",field);
    }
    private static String fieldGroupDropdownElement(String field){
        return String.format("//div[contains(@id, 'conversionFieldGroupSelect_%s')]",field);
    }
    private static String inputFieldGroup(String field){
        return String.format("#conversionFieldGroupSelect_%s_search",field);
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
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    /*
     * username return list
     */
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
