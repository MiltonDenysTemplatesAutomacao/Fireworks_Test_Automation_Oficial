package pages;

import bean.ActionBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class LettersPage extends BasePage{

    public static final String ACTION_COMMENTS_FIELD = "#action_comments";
    public static final String LETTER_TEMPLATES_TAB = "body > section > div > ul > li:nth-child(2) > a";
    private static final String USER_ACTION_SECTION_LABEL = "//p[contains(text(), 'User Action')]";
    private static final String ACTION_CATEGORY_DROPDOWN = "div#s2id_action_category_id.select2-container.form-control.select2.select2 a.select2-choice";
    private static final String ACTION_CATEGORY_DROPDOWN_LIST = "s2id_autogen30_search";
    private static final String ACTION_DROPDOWN = "div#s2id_action_id.select2-container.form-control.select2.select2 a.select2-choice";
    private static final String ACTION_DROPDOWN_LIST = "s2id_autogen31_search";
    private static final String ACTION_STAFF_DROPDOWN = "div#s2id_action_staff.select2-container.form-control.select2 a.select2-choice";
    private static final String ACTION_STAFF_DROPDOWN_LIST = "s2id_autogen34_search";
    private static final String ACTION_VISIBILITY = "#s2id_action_visibility_id";
    private static final String ACTION_VISIBILITY_LIST = "select2-results-26";
    private static final String CREATE_NEW_LETTER_BUTTON = "#top-controls-create-new-letter";
    private static final String LOAD_TEMPLATE_DROPDOWN = "s2id_loadTemplate";
    public static final String DROPDOWN_INPUT_FIELD_ELEMENT = "s2id_autogen1_search";
    private static final String LETTER_NAME_FIELD = "#name";
    private static final String SMART_SEARCH_DROPDOWN = "div#s2id_saved_search_id.select2-container.form-control.select2.select2 a.select2-choice";
    private static final String SMART_SEARCH_DROPDOWN_LIST = "#select2-results-2";
    private static final String LETTER_FORMAT_DROPDOWN = "#select2-chosen-24";
    private static final String SYSTEM_ACTION_CATEGORY_ELEMENT = "div#s2id_system_action_category_id.select2-container.select2-container-disabled.form-control.actionCategoryIdSelector.parentSelect.select2";
    private static final String READ_ONLY_ACTION_TYPE_ELEMENT = "div#s2id_action_type_id.select2-container.select2-container-disabled.form-control.actionTypeIdSelector.select2";
    private static final String READ_ONLY_ACTION_VISIBILITY_ELEMENT = "div#s2id_action_visibility_id.select2-container.select2-container-disabled.form-control.actionVisibilityIdSelector.select2";
    private static final String ACTION_DATE_FIELD = "#action_date";
    private static final String SINGLE_RECIPIENT_PICKER_BUTTON = "#recordPickerTrigger";
    private static final String RECORD_PICKER_MODAL_SEARCH_FIELD = "#recordPickerModalTableControlsTableSearch";
    private static final String RECORD_PICKER_MODAL_TABLE_ROW1 = "#recordPickerModalTable_row_0";
    private static final String RECORD_PICKER_MODAL_TABLE_ROW1_CHECKBOX = "#recordPickerModalTable_row_0_col_0";
    private static final String RECORD_PICKER_MODAL_CHOOSE_BUTTON = "#modalSubmitButtonrecordPicker";
    private static final String INCLUDE_LABELS_CHECKBOX = "includeLabelsCheckbox";
    private static final String SYSTEM_ACTION_ACTION_ELEMENT = "div#s2id_system_action_id.select2-container.select2-container-disabled.form-control.actionIdSelector.childSelect.select2";
    private static final String LETTER_CREATE_PDF = "#createPDF";
    private static final String PREVIEW_RECIPIENTS_MODAL = "#previewRecipientsModalLabel";
    private static final String PREVIEW_RECIPIENTS_MODAL_MESSAGE = "//*[@id='previewRecipientsModal']/div/div/div[2]/p";
    private static final String PREVIEW_RECIPIENTS_LETTER_RECIPIENTS = "//h1[text()='Letter Recipients']";
    private static final String PREVIEW_RECIPIENTS_MODAL_OK_BUTTON = "div.in button.modalConfirm";
    private static final String LETTER_FORMAT_DROPDOWN_FIELD = "div#s2id_letter_size_format_id.select2-container.form-control.select2.select2 a.select2-choice";
    private static final String LETTER_FORMAT_DROPDOWN_FIELD_LIST = "#s2id_autogen24_search";
    private static final String LETTER_CONTENT_IFRAME_BODY_ELEMENT = "body#tinymce";
    private static final String LETTER_CONTENT_IFRAME_ELEMENT = "content_ifr";
    private static final String LETTER_SCHEDULE_BUTTON = "#letterFormScheduleButton";
    private static final String ORG_ACTION_CATEGORY_DROPDOWN = "div#s2id_org_action_category_id.select2-container.form-control.select2.select2 a.select2-choice";
    private static final String ORG_ACTION_DROPDOWN = "div#s2id_org_action_id.select2-container.form-control.select2.select2 a.select2-choice";
    private static final String ORG_ACTION_INPUT_FIELD = "#s2id_autogen20_search";

    public static void verifyLetterOrgAction(ActionBean actionBean){
        try {
            if(verifyGetText(By.cssSelector(ORG_ACTION_CATEGORY_DROPDOWN),actionBean.getCategory())
                && verifyGetText(By.cssSelector(ORG_ACTION_DROPDOWN),actionBean.getAction())
                && verifyGetText(By.cssSelector(ACTION_STAFF_DROPDOWN),actionBean.getStaff())
                && verifyGetText(By.cssSelector(ORG_ACTION_DROPDOWN),actionBean.getAction())
                && verifyGetText(By.cssSelector(ACTION_DATE_FIELD),actionBean.getActionDate())
                && verifyGetText(By.cssSelector(ACTION_COMMENTS_FIELD),actionBean.getComments())){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_LETTER_ORG_ACTION_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_LETTER_ORG_ACTION_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_LETTER_ORG_ACTION_FAIL);
        }
    }
    public static void updateLetterOrgAction(ActionBean actionBean){
        try {
            clickOptionList(By.cssSelector(ORG_ACTION_CATEGORY_DROPDOWN),
                    actionBean.getCategory(),
                    By.cssSelector(PersonPage.SELECT_DROP));
            selectOptionList(By.cssSelector(ORG_ACTION_DROPDOWN),
                    actionBean.getAction(),
                    By.cssSelector(ORG_ACTION_INPUT_FIELD));
            clickOptionList(By.cssSelector(ACTION_STAFF_DROPDOWN),
                    actionBean.getStaff(),
                    By.cssSelector(PersonPage.SELECT_DROP));
            clickOptionList(By.cssSelector(ACTION_DATE_FIELD),
                    actionBean.getActionDate(),
                    By.cssSelector(PersonPage.SELECT_DROP));
            fillField(By.cssSelector(ACTION_COMMENTS_FIELD),actionBean.getComments());
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_LETTER_ORG_ACTION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_LETTER_ORG_ACTION_FAIL);
        }
    }
    public static void scheduleLetterButton(){
        try {
            clickOption(By.cssSelector(LETTER_SCHEDULE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SCHEDULE_LETTER_BUTTON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SCHEDULE_LETTER_BUTTON_FAIL);
        }
    }

    public static void updateLetterContent(int index){
        try {
            if(mass.get(index).get("LetterFormat")!= null){
                selectOptionList(By.cssSelector(LETTER_FORMAT_DROPDOWN_FIELD),
                        mass.get(index).get("LetterFormat"),
                        By.cssSelector(LETTER_FORMAT_DROPDOWN_FIELD_LIST));
            }
            if(mass.get(index).get("LetterContent")!= null){
                switchToIFrame(LETTER_CONTENT_IFRAME_ELEMENT);
                waitElementBy(By.cssSelector(LETTER_CONTENT_IFRAME_BODY_ELEMENT), 10);
                BasePage.write(By.cssSelector(LETTER_CONTENT_IFRAME_BODY_ELEMENT),mass.get(index).get("LetterContent"));
                switchToDefaultContent();
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_LETTER_CONTENT_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_LETTER_CONTENT_FAIL);
        }
    }

    public static void confirmRecipientsModal(){
        try {
            waitElementBy(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_OK_BUTTON),20);
            click(By.cssSelector(PREVIEW_RECIPIENTS_MODAL_OK_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CONFIRM_RECIPIENTS_MODAL_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CONFIRM_RECIPIENTS_MODAL_FAIL);
        }
    }
    public static void verifyRecipientsModal(){
        try {
            waitElementBy(By.cssSelector(PREVIEW_RECIPIENTS_MODAL),20);
            boolean previewRecipientsValidation = verifyIfEquals(By.cssSelector(PREVIEW_RECIPIENTS_MODAL),"Preview Recipients");
            boolean previewRecipientsModalValidation = verifyIfEquals(By.xpath(PREVIEW_RECIPIENTS_MODAL_MESSAGE),"You are about to create this PDF. This cannot be undone.");
            boolean previewRecipientsLetterValidation = verifyIfEquals(By.xpath(PREVIEW_RECIPIENTS_LETTER_RECIPIENTS),"Letter Recipients");

            if(previewRecipientsValidation && previewRecipientsModalValidation && previewRecipientsLetterValidation){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_RECIPIENTS_MODAL_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_RECIPIENTS_MODAL_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_RECIPIENTS_MODAL_FAIL);
        }

    }
    public static void createPDF(){
        try {
            clickOption(By.cssSelector(LETTER_CREATE_PDF));
            ExtentReportsSetUp.testingPass(LogPage.CREATE_PDF_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_PDF_FAIL);
        }
    }

    public static void verifyLetterSystemAction(String systemActionsCategory, String systemActionsAction){
        String errorMessage = String.format(LogPage.VERIFY_LETTER_SYSTEM_ACTION_FAIL, systemActionsCategory,systemActionsAction);
        String passMessage = String.format(LogPage.VERIFY_LETTER_SYSTEM_ACTION_PASS, systemActionsCategory,systemActionsAction);
        try {
            scrollToElement(By.id(INCLUDE_LABELS_CHECKBOX));
            waitElementBy(By.cssSelector(SYSTEM_ACTION_CATEGORY_ELEMENT),20);
            boolean systemActionsCategoryValidation = verifyIfContains(By.cssSelector(SYSTEM_ACTION_CATEGORY_ELEMENT),systemActionsCategory);
            boolean systemActionsActionValidation = verifyIfContains(By.cssSelector(SYSTEM_ACTION_ACTION_ELEMENT),systemActionsAction);
            if(systemActionsCategoryValidation && systemActionsActionValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void updateLetterRecipients(int index){
        try {
            if (mass.get(index).get("SmartSearch") != null) {
                MainPage.clickOptionList(By.cssSelector(SMART_SEARCH_DROPDOWN),
                        mass.get(index).get("SmartSearch"),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (mass.get(0).get("SingleRecipient") != null) {
                MainPage.picker(By.cssSelector(SINGLE_RECIPIENT_PICKER_BUTTON),
                        By.cssSelector(RECORD_PICKER_MODAL_SEARCH_FIELD),
                        By.cssSelector(RECORD_PICKER_MODAL_TABLE_ROW1),
                        By.cssSelector(RECORD_PICKER_MODAL_TABLE_ROW1_CHECKBOX),
                        By.cssSelector(RECORD_PICKER_MODAL_CHOOSE_BUTTON),
                        mass.get(0).get("SingleRecipient"));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_LETTER_RECIPIENTS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_LETTER_RECIPIENTS_FAIL);
        }
    }

    public static void updateLetterDetails(int index){
        try {
            scrollToElement(By.id(LOAD_TEMPLATE_DROPDOWN));
            waitElementBy(By.cssSelector(LETTER_NAME_FIELD),20);
            write(By.cssSelector(LETTER_NAME_FIELD),mass.get(index).get("LetterName"));
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_LETTER_DETAILS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_LETTER_DETAILS_FAIL);
        }

    }
    public static void verifyLetterPersonAction(String category,String action,String actionType,String actionVisibility, String staff, String date,String comments){
        try {
            scrollToElement(By.cssSelector(SYSTEM_ACTION_CATEGORY_ELEMENT));
            String categoryText = getText(By.cssSelector(ACTION_CATEGORY_DROPDOWN));
            String actionText = getText(By.cssSelector(ACTION_DROPDOWN));
            String actionTypeText = getText(By.cssSelector(READ_ONLY_ACTION_TYPE_ELEMENT));
            String actionVisibilityText = getText(By.cssSelector(READ_ONLY_ACTION_VISIBILITY_ELEMENT));
            String staffText = getText(By.cssSelector(ACTION_STAFF_DROPDOWN));
            String dateText = getAtribute(By.cssSelector(ACTION_DATE_FIELD),"value");
            String commentsText = getAtribute(By.cssSelector(ACTION_COMMENTS_FIELD),"value");
             if(categoryText.equals(category)
                && actionText.equals(action)
                && actionTypeText.contains(actionType)
                && actionVisibilityText.contains(actionVisibility)
                && staffText.equals(staff)
                && dateText.equals(date)
                && commentsText.equals(comments)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_LETTER_PERSON_ACTION_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_LETTER_PERSON_ACTION_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_LETTER_PERSON_ACTION_FAIL);
        }

    }

    public static boolean validateLetterFormat(String letterContent)throws Exception{
        scrollToElement(By.id(LetterTemplatePage.LETTER_CONTENT_IFRAME_ELEMENT));
        scrollTo("-150");
        switchToIFrame(LetterTemplatePage.LETTER_CONTENT_IFRAME_ELEMENT);
        boolean verification = verifyGetText(By.cssSelector(LETTER_CONTENT_IFRAME_BODY_ELEMENT),letterContent);
        switchToDefaultContent();
        return verification;
    }
    public static void verifyDraftLetter(String letterName,String search,String letterFormat,String letterContent){
        try {
            if(verifyGetAttribute(By.cssSelector(LETTER_NAME_FIELD),letterName)
                && verifyGetText(By.cssSelector(SMART_SEARCH_DROPDOWN),search)
                && verifyGetText(By.cssSelector(LETTER_FORMAT_DROPDOWN),letterFormat)
                && validateLetterFormat(letterContent)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_DRAFT_LETTER_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_DRAFT_LETTER_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_DRAFT_LETTER_FAIL);
        }

    }
    public static void loadTemplate(String templateName){
        String errorMessage = String.format(LogPage.LOAD_TEMPLATE_FAIL, templateName);
        String passMessage = String.format(LogPage.LOAD_TEMPLATE_PASS, templateName);
        try {
            waitElementBy(By.id(LOAD_TEMPLATE_DROPDOWN),20);
            click(By.id(LOAD_TEMPLATE_DROPDOWN));
            waitElementBy(By.id(DROPDOWN_INPUT_FIELD_ELEMENT),20);
            write(By.id(DROPDOWN_INPUT_FIELD_ELEMENT),templateName);
            KeyPage.pressKey(By.id(DROPDOWN_INPUT_FIELD_ELEMENT),"Enter");
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void createLetter(){
        try {
            waitUntilElementToBeSelected(By.cssSelector(CREATE_NEW_LETTER_BUTTON),20);
            click(By.cssSelector(CREATE_NEW_LETTER_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CREATE_LETTER_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_LETTER_FAIL);
        }
    }

    public static void updateLetterPersonAction(int index){
        wait(2000);
        try {
            if (mass.get(index).get("Category") != null) {
                MainPage.selectOptionList(By.cssSelector(ACTION_CATEGORY_DROPDOWN),
                        mass.get(index).get("Category"),
                        By.id(ACTION_CATEGORY_DROPDOWN_LIST));
            }
            if (mass.get(index).get("Action") != null) {
                MainPage.selectOptionList(By.cssSelector(ACTION_DROPDOWN),
                        mass.get(index).get("Action"),
                        By.id(ACTION_DROPDOWN_LIST));
            }
            if (mass.get(index).get("Staff") != null) {
                MainPage.selectOptionList(By.cssSelector(ACTION_STAFF_DROPDOWN),
                        mass.get(index).get("Staff"),
                        By.id(ACTION_STAFF_DROPDOWN_LIST));
            }
            if (mass.get(index).get("Visibility") != null) {
                MainPage.selectOptionList(By.cssSelector(ACTION_VISIBILITY),
                        mass.get(index).get("Visibility"),
                        By.id(ACTION_VISIBILITY_LIST));
            }
            if (mass.get(index).get("Comments") != null) {
                MainPage.fillField(By.cssSelector(ACTION_COMMENTS_FIELD), mass.get(index).get("Comments"));
            }
            if (mass.get(index).get("ActionDateTime") != null) {
                MainPage.fillDateField(By.cssSelector(ACTION_DATE_FIELD), mass.get(index).get("ActionDateTime"));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_LETTER_PERSON_ACTION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_LETTER_PERSON_ACTION_FAIL);
        }

    }
    public static void navigateToTemplatesTab(){
        try {
            clickOption(By.cssSelector(LETTER_TEMPLATES_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_TEMPLATES_TAB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_TEMPLATES_TAB_FAIL);
        }
    }

}
