package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.records.ActionsPage;

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
    public static final String SINGLE_RECIPIENT_PICKER_MODAL_FIRST_ROW_CHECKBOX = "//*[@id='emailAddressPickerModalTable_row_0_col_0']/button";
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
    public static final String PREVIEW_RECIPIENTS_MODAL_TABLE = "#previewEmailRecipientsTable_row_0";
    public static final String TEXT = "previewEmailContentText";
    public static final String TEXT_BODY = "/html/body";
    public static final String TEXT_TAB = "//*[text() = 'Text']";
    public static final String HTML = "previewEmailContentHtml";
    public static final String HTML_BODY = "/html/body/p";
    public static final String DISABLE_FOOTER_CHECKBOX = "#disable_footer";
    public static final String TEST_EMAIL_ADDRESS_FIELD = "#quickTestAddress";
    public static final String TEST_EMAIL_NOTE_FIELD = "#quickTestMessage";
    public static final String SEND_TEST_EMAIL_BUTTON = "#sendTestMailButton";
    public static final String TEST_LIST_PICKER_BUTTON = "#emailTestListPickerTrigger";
    public static final String TEST_LIST_PICKER_SEARCH_FIELD = "#testRecipientListPickerModalTableControlsTableSearch";
    public static final String TEST_LIST_PICKER_TABLE_ROW1 = "#testRecipientListPickerModalTable_row_0";
    public static final String TEST_LIST_PICKER_TABLE_ROW1_CHECKBOX = "#testRecipientListPickerModalTable_row_0_col_0 > div > input";
    public static final String TEST_LIST_PICKER_CHOOSE_BUTTON = "#modalSubmitButtontestRecipientListPicker";
    public static final String USE_COUNSELOR_AS_SENDER_NAME_CHECKBOX = "#use_assigned_counselor_name";

    public static void clickUseAssignedCounselorCheckbox(){
        try {
            clickCheckbox(By.cssSelector(USE_COUNSELOR_AS_SENDER_NAME_CHECKBOX));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_USE_ASSIGNED_COUNSELOR_CHECKBOX_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_USE_ASSIGNED_COUNSELOR_CHECKBOX_FAIL);
        }
    }
    public static void sendTestEmail(String testList,String email, String testNote){

        try {
            picker(By.cssSelector(TEST_LIST_PICKER_BUTTON),
                    By.cssSelector(TEST_LIST_PICKER_SEARCH_FIELD),
                    By.cssSelector(TEST_LIST_PICKER_TABLE_ROW1),
                    By.cssSelector(TEST_LIST_PICKER_TABLE_ROW1_CHECKBOX),
                    By.cssSelector(TEST_LIST_PICKER_CHOOSE_BUTTON),
                    testList);
            fillField(By.cssSelector(TEST_EMAIL_ADDRESS_FIELD),email);
            fillField(By.cssSelector(TEST_EMAIL_NOTE_FIELD),testNote);
            clickOption(By.cssSelector(SEND_TEST_EMAIL_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SEND_TEST_EMAIL_BUTTON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SEND_TEST_EMAIL_BUTTON_FAIL);
        }
    }
    public static void disableFooterCheckbox(){
        try {
            clickCheckbox(By.cssSelector(DISABLE_FOOTER_CHECKBOX));
            ExtentReportsSetUp.testingPass(LogPage.DISABLE_FOOTER_CHECKBOX_MESSAGE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.DISABLE_FOOTER_CHECKBOX_MESSAGE_FAIL);
        }
    }
    public static boolean validateMessageBodyText(String value)throws Exception{
        boolean validation = false;
        clickOption(By.xpath(TEXT_TAB));
        if(value!="" && value !=null){
            if(verifyElementWithIFrameByAttribute(By.id(TEXT),
                    TEXT,
                    By.xpath(TEXT_BODY),
                    value,
                    "innerHTML")){
                validation = true;
            }else{
                validation = false;
            }
        }else{
            validation = true;
        }
        return validation;
    }

    public static void verifyMessageHeader(String senderName,String senderEmail,String replyToEmail,String subject,String preheaders,String html,String text,String status){
        try {
            switch (status){
                case "visible":
                    if(verifyGetAttribute(By.cssSelector(SENDER_NAME_FIELD),senderName)
                            && verifyGetAttribute(By.cssSelector(SENDER_EMAIL_FIELD),senderEmail)
                            && verifyGetAttribute(By.cssSelector(REPLY_TO_EMAIL_FIELD),replyToEmail)
                            && verifyGetAttribute(By.cssSelector(SUBJECT_FIELD),subject)
                            && verifyGetAttribute(By.cssSelector(PREHEADERS_FIELD),preheaders)
                            && verifyElementWithIFrame(By.id(HTML),
                            HTML,
                            By.xpath(HTML_BODY),
                            html)
                            && validateMessageBodyText(text)){
                        ExtentReportsSetUp.testingPass(LogPage.VERIFY_MESSAGE_HEADER_PASS);
                    }else{
                        FailureDelegatePage.handlePageException(LogPage.VERIFY_MESSAGE_HEADER_FAIL);
                    }
                    break;
                case "not visible":
                    if(!verifyGetAttribute(By.cssSelector(SENDER_NAME_FIELD),senderName)
                            && !verifyGetAttribute(By.cssSelector(SENDER_EMAIL_FIELD),senderEmail)
                            && !verifyGetAttribute(By.cssSelector(REPLY_TO_EMAIL_FIELD),replyToEmail)
                            && !verifyGetAttribute(By.cssSelector(SUBJECT_FIELD),subject)
                            && !verifyGetAttribute(By.cssSelector(PREHEADERS_FIELD),preheaders)
                            && !verifyElementWithIFrame(By.id(HTML),
                            HTML,
                            By.xpath(HTML_BODY),
                            html)
                            && !validateMessageBodyText(text)){
                        ExtentReportsSetUp.testingPass(LogPage.VERIFY_MESSAGE_HEADER_PASS);
                    }else{
                        FailureDelegatePage.handlePageException(LogPage.VERIFY_MESSAGE_HEADER_FAIL);
                    }
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_MESSAGE_HEADER_FAIL);
        }
    }
    public static void verifyOrganizationActionFinishTab(String category, String action, String actionType, String actionVisibility,String staff, String actionDateTime, String comments){
        try {
            if(verifyGetText(By.id(OrgPage.ORG_ACTION_CATEGORY_DROPDOWN),category)
                    && verifyGetText(By.id(OrgPage.ORG_ACTION_DROPDOWN),action)
                    && verifyGetText(By.cssSelector(OrgPage.ACTION_TYPE_DISABLED_DROPDOWN),actionType)
                    && verifyGetText(By.cssSelector(OrgPage.ACTION_VISIBILITY_DISABLED_DROPDOWN),actionVisibility)
                    && verifyGetText(By.id(ActionsPage.ACTION_STAFF_DROPDOWN),staff)
                    && verifyGetAttribute(By.cssSelector(ACTION_DATE_FIELD),actionDateTime)
                    && verifyGetAttribute(By.cssSelector(ACTION_COMMENTS_FIELD),comments)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_RECIPIENTS_PREVIEW_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_RECIPIENTS_PREVIEW_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_RECIPIENTS_PREVIEW_FAIL);
        }
    }
    public static void verifyRecipientsPreview(String firstName, String lastName, String emailAddress, String reason, String validRecipients){
        try {
            wait(2000);
            if(verifyGetText(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_TABLE),firstName)
                    && verifyGetText(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_TABLE),lastName)
                    && verifyGetText(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_TABLE),emailAddress)
                    && verifyGetText(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_TABLE),reason)
                    && verifyGetText(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_TABLE),validRecipients)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_RECIPIENTS_PREVIEW_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_RECIPIENTS_PREVIEW_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_RECIPIENTS_PREVIEW_FAIL);
        }
    }
    public static void updateEmailFinishTab(String category, String action, String staff, String actionDateTime, String comments){
        try {
            if (category != ""){
                MainPage.clickOptionList(By.cssSelector(ACTION_CATEGORY_DROPDOWN),
                        category,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (action != ""){
                MainPage.clickOptionList(By.cssSelector(ACTION_DROPDOWN),
                        action,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (staff != ""){
                MainPage.clickOptionList(By.cssSelector(ACTION_STAFF_DROPDOWN),
                        staff,
                        By.cssSelector(PersonPage.SELECT_DROP));
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
    public static void updateOrgEmailFinishTab(String category, String action, String staff, String actionDateTime, String comments){
        try {
            if (category != ""){
                MainPage.clickOptionList(By.id(OrgPage.ORG_ACTION_CATEGORY_DROPDOWN),
                        category,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (action != ""){
                MainPage.clickOptionList(By.id(OrgPage.ORG_ACTION_DROPDOWN),
                        action,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (staff != ""){
                MainPage.clickOptionList(By.id(ActionsPage.ACTION_STAFF_DROPDOWN),
                        staff,
                        By.cssSelector(PersonPage.SELECT_DROP));
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
            fillElementWithIFrame(HTML_CONTENT_IFRAME_ELEMENT,
                    By.cssSelector(HTML_CONTENT_IFRAME_BODY_ELEMENT),
                    bodyHTML);
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
            clickOption(By.xpath(SAVE_AND_CONTINUE_BUTTON));
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
                        By.xpath(SINGLE_RECIPIENT_PICKER_MODAL_FIRST_ROW_CHECKBOX),
                        By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_CHOOSE_BUTTON),
                        singleEmail);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EMAIL_START_TAB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_EMAIL_START_TAB_FAIL);
        }
    }
}
