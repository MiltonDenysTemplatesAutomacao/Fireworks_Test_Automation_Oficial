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
    public static final String SENDER_NAME_FIELD = "#sender_name";
    public static final String SENDER_EMAIL_FIELD = "#sender_email_address";
    public static final String REPLY_TO_EMAIL_FIELD = "#reply_to_address";
    public static final String SUBJECT_FIELD = "#subject";
    public static final String PREHEADERS_FIELD = "#preheaders";
    public static final String FILTER_BY_EMAIL_TYPE = "#s2id_email-types-filter-dropdown";
    public static final String PREVIEW_RECIPIENTS_BUTTON = "#previewRecipients";
    public static final String ADD_ATTACHMENTS_DROPZONE_BUTTON = "#addAttachmentsDropzoneButton";
    public static final String CHOOSE_HTML_LAYOUT = "#htmlLayoutPickerButton";
    public static final String HTML_CONTENT_IFRAME_ELEMENT = "contentHtml_ifr";
    public static final String HTML_CONTENT_IFRAME_BODY_ELEMENT = "body#tinymce";
    public static final String CONTENT_PLAIN_TEXT_FIELD = "contentText";
    public static final String EMAIL_FINISH_TAB = "#timeline-step-actions";
    public static final String ACTION_CATEGORY_DROPDOWN = "#select2-chosen-22";
    public static final String ACTION_DROPDOWN = "#select2-chosen-23";
    public static final String ACTION_STAFF_DROPDOWN = "#select2-chosen-26";
    public static final String ACTION_DATE_FIELD = "#action_date";
    public static final String ACTION_COMMENTS_FIELD = "#action_comments";

    public static void updateEmailFinishTab(String category, String action, String staff, String actionDateTime, String comments){
        try {
            if (category != ""){
                MainPage.clickOptionList(By.cssSelector(ACTION_CATEGORY_DROPDOWN),
                        category,
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (action != ""){
                MainPage.clickOptionList(By.cssSelector(ACTION_DROPDOWN),
                        action,
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (staff != ""){
                MainPage.clickOptionList(By.cssSelector(ACTION_STAFF_DROPDOWN),
                        staff,
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (actionDateTime != ""){
                MainPage.fillDateField(By.cssSelector(ACTION_DATE_FIELD), actionDateTime);
            }
            if (comments != ""){
                MainPage.fillField(By.cssSelector(ACTION_COMMENTS_FIELD), comments);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EMAIL_FINISH_TAB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_EMAIL_FINISH_TAB_FAIL);
        }
    }

    public static void clickFinishTab(){
        try {
            scrollToTheTop();
            waitElementBy(By.cssSelector(EMAIL_FINISH_TAB),20);
            click(By.cssSelector(EMAIL_FINISH_TAB));
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EMAIL_CONTENT_TAB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ADD_EMAIL_ATTACHMENT_FAIL);
        }

    }
    public static void addEmailAttachment(String attachment){
        try {
            waitElementBy(By.cssSelector(PREHEADERS_FIELD),20);
            scrollToElement(By.cssSelector(PREHEADERS_FIELD));
            waitElementBy(By.cssSelector(ADD_ATTACHMENTS_DROPZONE_BUTTON),20);
            click(By.cssSelector(ADD_ATTACHMENTS_DROPZONE_BUTTON));
            copyToTheClipboard(attachment);
            attachFile();
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ADD_EMAIL_ATTACHMENT_FAIL);
        }

    }
    public static void fillBodyWithHTML(String bodyHTML){
        try {
            switchToIFrame(HTML_CONTENT_IFRAME_ELEMENT);
            waitElementBy(By.cssSelector(HTML_CONTENT_IFRAME_BODY_ELEMENT), 20);
            BasePage.write(By.cssSelector(HTML_CONTENT_IFRAME_BODY_ELEMENT),bodyHTML);
            switchToDefaultContent();
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.FILL_BODY_WITH_HTML_FAIL);
        }
    }
    public static void updateEmailContentTab(String bodyHTML, String bodyText){
        int updateEmailContentTabDelay = 20;
        try {
            waitElementBy(By.cssSelector(CHOOSE_HTML_LAYOUT),updateEmailContentTabDelay);
            if (bodyHTML != ""){
                fillBodyWithHTML(bodyHTML);
            }
            if (bodyText != ""){
                scrollTo("450");
                waitElementBy(By.id(CONTENT_PLAIN_TEXT_FIELD),20);
                write(By.id(CONTENT_PLAIN_TEXT_FIELD),bodyText);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EMAIL_CONTENT_TAB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_EMAIL_CONTENT_TAB_FAIL);
        }
    }

    public static void updateEmailHeadersTab(String senderName,String senderEmail,String replyToEmail,String subject,String preheaders,String attachment){
        int updateEmailHeadersTabDelay = 20;
        try {
            waitElementBy(By.cssSelector(SENDER_NAME_FIELD),updateEmailHeadersTabDelay);
            if (senderName != ""){
                MainPage.fillField(By.cssSelector(SENDER_NAME_FIELD), senderName);
            }
            if (senderEmail != ""){
                MainPage.fillField(By.cssSelector(SENDER_EMAIL_FIELD), senderEmail);
            }
            if (replyToEmail != ""){
                MainPage.fillField(By.cssSelector(REPLY_TO_EMAIL_FIELD), replyToEmail);
            }
            if (subject != ""){
                MainPage.fillField(By.cssSelector(SUBJECT_FIELD), subject);
            }
            if (preheaders != ""){
                MainPage.fillField(By.cssSelector(PREHEADERS_FIELD), preheaders);
            }
            if (attachment != ""){
                addEmailAttachment(attachment);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EMAIL_HEADERS_TAB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_EMAIL_HEADERS_TAB_FAIL);
        }
    }

    public static void clickSaveAndContinue(){
        try {
            wait(1000);
            scrollToTheBottom();
            wait(5000);
            waitUntilElementToBeSelected(By.xpath(SAVE_AND_CONTINUE_BUTTON),20);
            click(By.xpath(SAVE_AND_CONTINUE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_SAVE_AND_CONTINUE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_SAVE_AND_CONTINUE_PASS);
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
                MainPage.fillField(By.cssSelector(EMAIL_NAME_FIELD), emailName);
            }
            if (emailDescription != ""){
                MainPage.fillField(By.cssSelector(EMAIL_DESCRIPTION_FIELD), emailDescription);
            }
            if (smartSearch != ""){
                MainPage.picker(By.cssSelector(SMART_SEARCH_PICKER_BUTTON),
                        By.cssSelector(SMART_SEARCH_PICKER_MODAL_SEARCH_FIELD),
                        By.cssSelector(SMART_SEARCH_PICKER_MODAL_FIRST_ROW_ELEMENT),
                        By.cssSelector(SMART_SEARCH_PICKER_MODAL_FIRST_ROW_CHECKBOX),
                        By.cssSelector(SMART_SEARCH_PICKER_MODAL_CHOOSE_BUTTON),
                        smartSearch);
            }
            if (singleEmail != ""){
                MainPage.picker(By.cssSelector(SINGLE_RECIPIENT_PICKER_BUTTON),
                        By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_SEARCH_BOX),
                        By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_FIRST_ROW_ELEMENT),
                        By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_FIRST_ROW_ELEMENT),
                        By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_CHOOSE_BUTTON),
                        singleEmail);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EMAIL_START_TAB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_EMAIL_START_TAB_FAIL);
        }
    }
}
