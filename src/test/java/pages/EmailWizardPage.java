package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class EmailWizardPage extends BasePage{

    public static final String EMAIL_NAME_FIELD = "#email_name";
    public static final String EMAIL_TEMPLATE_PICKER_BUTTON = "#emailTemplatePickerTrigger";
    public static final String EMAIL_TEMPLATE_PICKER_MODAL_SEARCH_FIELD = "#emailTemplatePickerModalTableControlsTableSearch";
    public static final String EMAIL_TEMPLATE_PICKER_MODAL_FIRST_ROW_ELEMENT = "#emailTemplatePickerModalTable_row_0";
    public static final String EMAIL_TEMPLATE_PICKER_MODAL_FIRST_ROW_CHECKBOX = "//th[@id='emailTemplatePickerModalTable_row_0_col_0']/div/input";
    public static final String EMAIL_TEMPLATE_PICKER_MODAL_CHOOSE_BUTTON = "#modalSubmitButtonemailTemplatePicker";
    public static final String EMAIL_DESCRIPTION_FIELD = "#email_description";
    public static final String SMART_SEARCH_PICKER_BUTTON = "#savedSearchPickerTrigger";
    public static final String SMART_SEARCH_PICKER_MODAL_SEARCH_FIELD = "#savedSearchPickerModalTableControlsTableSearch";
    public static final String SMART_SEARCH_PICKER_MODAL_FIRST_ROW_ELEMENT = "#savedSearchPickerModalTable_row_0";
    public static final String SMART_SEARCH_PICKER_MODAL_FIRST_ROW_CHECKBOX = "#savedSearchPickerModalTable_row_0_col_0";
    public static final String SMART_SEARCH_PICKER_MODAL_CHOOSE_BUTTON = "#modalSubmitButtonsavedSearchPicker";
    public static final String SINGLE_RECIPIENT_PICKER_BUTTON = "#emailAddressPickerTrigger";
    public static final String SINGLE_RECIPIENT_PICKER_MODAL_SEARCH_BOX = "#emailAddressPickerModalTableControlsTableSearch";
    public static final String SINGLE_RECIPIENT_PICKER_MODAL_FIRST_ROW_ELEMENT = "#emailAddressPickerModalTable_row_0";
    public static final String SINGLE_RECIPIENT_PICKER_MODAL_CHOOSE_BUTTON = "#modalSubmitButtonemailAddressPicker";
    public static final String SAVE_AND_CONTINUE_BUTTON = "//button[text()='Save & Continue']";

    public static void updateEmailContentTab(){

    }

    public static void updateEmailHeadersTab(String senderName,String senderEmail,String replyToEmail,String subject,String preheaders,String attachment){

    }

    public static void clickSaveAndContinue(){
        try {
            scrollToElement(By.cssSelector(SINGLE_RECIPIENT_PICKER_BUTTON));
            waitUntilElementToBeSelected(By.xpath(SAVE_AND_CONTINUE_BUTTON),20);
            click(By.xpath(SAVE_AND_CONTINUE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_SAVE_AND_CONTINUE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_SAVE_AND_CONTINUE_PASS);
        }
    }
    public static void searchEmailAddressPicker(String singleEmail){
        try {
            waitElementBy(By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_SEARCH_BOX),20);
            write(By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_SEARCH_BOX),singleEmail);
            String singleEmailText = getText(By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_FIRST_ROW_ELEMENT));
            if(!singleEmailText.equals("No table data available.")){
                waitUntilElementToBeSelected(By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_FIRST_ROW_ELEMENT),20);
                click(By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_FIRST_ROW_ELEMENT));
                waitUntilElementToBeSelected(By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_CHOOSE_BUTTON),20);
                click(By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_CHOOSE_BUTTON));
            }else{
                FailureDelegatePage.handlePageException(LogPage.EMAIL_WIZARD_SMART_SEARCH_PICKER);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.EMAIL_WIZARD_SMART_SEARCH_PICKER);
        }
    }
    public static void pickSingleRecipient(String singleEmail){
        try {
            scrollToElement(By.cssSelector(EMAIL_DESCRIPTION_FIELD));
            waitUntilElementToBeSelected(By.cssSelector(SINGLE_RECIPIENT_PICKER_BUTTON),20);
            click(By.cssSelector(SINGLE_RECIPIENT_PICKER_BUTTON));
            searchEmailAddressPicker(singleEmail);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.PICK_SINGLE_RECIPIENT_SMART_SEARCH_FAIL);
        }
    }

    public static void searchSmartSearchPicker(String smartSearch){
        try {
            waitElementBy(By.cssSelector(SMART_SEARCH_PICKER_MODAL_SEARCH_FIELD),20);
            write(By.cssSelector(SMART_SEARCH_PICKER_MODAL_SEARCH_FIELD),smartSearch);
            String smartSearchText = getText(By.cssSelector(SMART_SEARCH_PICKER_MODAL_FIRST_ROW_ELEMENT));
            if(!smartSearchText.equals("No table data available.")){
                waitUntilElementToBeSelected(By.cssSelector(SMART_SEARCH_PICKER_MODAL_FIRST_ROW_CHECKBOX),20);
                click(By.cssSelector(SMART_SEARCH_PICKER_MODAL_FIRST_ROW_CHECKBOX));
                waitUntilElementToBeSelected(By.cssSelector(SMART_SEARCH_PICKER_MODAL_CHOOSE_BUTTON),20);
                click(By.cssSelector(SMART_SEARCH_PICKER_MODAL_CHOOSE_BUTTON));
            }else{
                FailureDelegatePage.handlePageException(LogPage.EMAIL_WIZARD_SMART_SEARCH_PICKER);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.EMAIL_WIZARD_SMART_SEARCH_PICKER);
        }
    }

    public static void pickSmartSearch(String smartSearch){
        try {
            scrollToElement(By.cssSelector(EMAIL_DESCRIPTION_FIELD));
            waitUntilElementToBeSelected(By.cssSelector(EMAIL_TEMPLATE_PICKER_BUTTON),20);
            click(By.cssSelector(SMART_SEARCH_PICKER_BUTTON));
            searchSmartSearchPicker(smartSearch);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.PICK_EMAIL_WIZARD_SMART_SEARCH_FAIL);
        }

    }

    public static void loadEmailTemplate(String template){
        try {
            waitUntilElementToBeSelected(By.cssSelector(EMAIL_TEMPLATE_PICKER_BUTTON),20);
            click(By.cssSelector(EMAIL_TEMPLATE_PICKER_BUTTON));
            waitElementBy(By.cssSelector(EMAIL_TEMPLATE_PICKER_MODAL_SEARCH_FIELD),20);
            write(By.cssSelector(EMAIL_TEMPLATE_PICKER_MODAL_SEARCH_FIELD),template);
            String templateText = getText(By.cssSelector(EMAIL_TEMPLATE_PICKER_MODAL_FIRST_ROW_ELEMENT));
            if(!templateText.equals("No table data available.")){
                waitUntilElementToBeSelected(By.xpath(EMAIL_TEMPLATE_PICKER_MODAL_FIRST_ROW_CHECKBOX),20);
                click(By.xpath(EMAIL_TEMPLATE_PICKER_MODAL_FIRST_ROW_CHECKBOX));
                waitUntilElementToBeSelected(By.cssSelector(EMAIL_TEMPLATE_PICKER_MODAL_CHOOSE_BUTTON),20);
                click(By.cssSelector(EMAIL_TEMPLATE_PICKER_MODAL_CHOOSE_BUTTON));
            }else{
                FailureDelegatePage.handlePageException(LogPage.LOAD_EMAIL_TEMPLATE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.LOAD_EMAIL_TEMPLATE_FAIL);
        }
    }
    public static void updateEmailStartTab(String template, String emailName, String emailDescription, String smartSearch, String singleEmail){
        int updateEmailStartTabDelay = 20;
        try {
            waitElementBy(By.cssSelector(EMAIL_NAME_FIELD),updateEmailStartTabDelay);
            if (template != ""){
                loadEmailTemplate(template);
            }
            if (emailName != ""){
                waitElementBy(By.cssSelector(EMAIL_NAME_FIELD),updateEmailStartTabDelay);
                write(By.cssSelector(EMAIL_NAME_FIELD),emailName);
            }
            if (emailDescription != ""){
                write(By.cssSelector(EMAIL_DESCRIPTION_FIELD),emailDescription);
            }
            if (smartSearch != ""){
                pickSmartSearch(smartSearch);
            }
            if (singleEmail != ""){
                pickSingleRecipient(singleEmail);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EMAIL_START_TAB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_EMAIL_START_TAB_FAIL);
        }
    }
}
