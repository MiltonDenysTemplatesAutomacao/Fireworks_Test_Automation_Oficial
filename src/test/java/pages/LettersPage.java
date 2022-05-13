package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class LettersPage extends BasePage{

    public static final String LETTER_TEMPLATES_TAB = "body > section > div > ul > li:nth-child(2) > a";
    public static final String USER_ACTION_SECTION_LABEL = "//p[contains(text(), 'User Action')]";
    public static final String ACTION_CATEGORY_DROPDOWN = "div#s2id_action_category_id.select2-container.form-control.select2.select2 a.select2-choice";
    public static final String ACTION_CATEGORY_DROPDOWN_LIST = "select2-results-23";
    public static final String ACTION_DROPDOWN = "div#s2id_action_id.select2-container.form-control.select2.select2 a.select2-choice";
    public static final String ACTION_DROPDOWN_LIST = "select2-results-24";
    public static final String ACTION_STAFF_DROPDOWN = "div#s2id_action_staff.select2-container.form-control.select2 a.select2-choice";
    public static final String ACTION_STAFF_DROPDOWN_LIST = "select2-results-25";
    public static final String ACTION_VISIBILITY = "#s2id_action_visibility_id";
    public static final String ACTION_VISIBILITY_LIST = "select2-results-26";
    public static final String ACTION_COMMENTS_FIELD = "#action_comments";
    public static final String CREATE_NEW_LETTER_BUTTON = "#top-controls-create-new-letter";
    public static final String LOAD_TEMPLATE_DROPDOWN = "s2id_loadTemplate";
    public static final String DROPDOWN_INPUT_FIELD_ELEMENT = "s2id_autogen1_search";
    public static final String LETTER_NAME_FIELD = "#name";
    public static final String SMART_SEARCH_DROPDOWN = "div#s2id_saved_search_id.select2-container.form-control.select2.select2 a.select2-choice";
    public static final String SMART_SEARCH_DROPDOWN_LIST = "select2-results-2";
    public static final String LETTER_FORMAT_DROPDOWN = "#select2-chosen-23";
    public static final String SYSTEM_ACTION_CATEGORY_ELEMENT = "div#s2id_system_action_category_id.select2-container.select2-container-disabled.form-control.actionCategoryIdSelector.parentSelect.select2";
    public static final String READ_ONLY_ACTION_TYPE_ELEMENT = "div#s2id_action_type_id.select2-container.select2-container-disabled.form-control.actionTypeIdSelector.select2";
    public static final String READ_ONLY_ACTION_VISIBILITY_ELEMENT = "div#s2id_action_visibility_id.select2-container.select2-container-disabled.form-control.actionVisibilityIdSelector.select2";
    public static final String ACTION_DATE_FIELD = "#action_date";
    public static final String SINGLE_RECIPIENT_PICKER_BUTTON = "#recordPickerTrigger";
    public static final String RECORD_PICKER_MODAL_SEARCH_FIELD = "#recordPickerModalTableControlsTableSearch";
    public static final String RECORD_PICKER_MODAL_TABLE_ROW1 = "#recordPickerModalTable_row_0";
    public static final String RECORD_PICKER_MODAL_TABLE_ROW1_CHECKBOX = "#recordPickerModalTable_row_0_col_0";
    public static final String RECORD_PICKER_MODAL_CHOOSE_BUTTON = "#modalSubmitButtonrecordPicker";

    public static void searchSingleRecipientPicker (String searchName)throws Exception{
        try {
            waitElementBy(By.cssSelector(RECORD_PICKER_MODAL_SEARCH_FIELD),20);
            BasePage.write(By.cssSelector(RECORD_PICKER_MODAL_SEARCH_FIELD), searchName);
            if(verifyIfContains(By.cssSelector(RECORD_PICKER_MODAL_TABLE_ROW1),searchName)){
                wait(2000);
                BasePage.click(By.cssSelector(RECORD_PICKER_MODAL_TABLE_ROW1_CHECKBOX));
            }else{
                FailureDelegatePage.handlePageException(LogPage.SEARCH_SINGLE_RECIPIENT_PICKER_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SEARCH_SINGLE_RECIPIENT_PICKER_FAIL);
        }
    }
    public static void singleRecipientPickerModalChooseButton()throws Exception{
        BasePage.click(By.cssSelector(RECORD_PICKER_MODAL_CHOOSE_BUTTON));
    }
    public static void pickSingleRecipient(String singleRecipient){
        try {
            waitElementBy(By.cssSelector(SINGLE_RECIPIENT_PICKER_BUTTON),20);
            BasePage.click(By.cssSelector(SINGLE_RECIPIENT_PICKER_BUTTON));
            searchSingleRecipientPicker(singleRecipient);
            singleRecipientPickerModalChooseButton();
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.PICK_SMART_SEARCH_FAIL);
        }
    }

    public static void updateLetterRecipients(int index){

        try {
            if (mass.get(index).get("SmartSearch") != null) {
                scrollToElement(By.cssSelector(LETTER_NAME_FIELD));
                waitUntilElementToBeSelected(By.cssSelector(SMART_SEARCH_DROPDOWN), 20);
                BasePage.click(By.cssSelector(SMART_SEARCH_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(SMART_SEARCH_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(index).get("SmartSearch"));
            }
            if (mass.get(0).get("SingleRecipient") != null) {
                pickSingleRecipient(mass.get(index).get("SingleRecipient"));
            }

        } catch (Exception e) {

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

    public static void verifyDraftLetter(String letterName,String search,String letterFormat,String letterContent){
        try {
            scrollToElement(By.id(LOAD_TEMPLATE_DROPDOWN));
            String letterNameText = getText(By.cssSelector(LETTER_NAME_FIELD));
            String searchText = getText(By.cssSelector(SMART_SEARCH_DROPDOWN));
            wait(4000);
            scrollToElement(By.cssSelector(SMART_SEARCH_DROPDOWN));
            String letterFormatText = getText(By.cssSelector(LETTER_FORMAT_DROPDOWN));
            scrollToElement(By.cssSelector(LETTER_FORMAT_DROPDOWN));
            switchToIFrame(LetterTemplatePage.LETTER_CONTENT_IFRAME_ELEMENT);
            String letterContentText = getText(By.id(LetterTemplatePage.LETTER_CONTENT_IFRAME_BODY_ELEMENT));
            switchToDefaultContent();
            if(letterNameText.equals(letterName)
                && searchText.equals(search)
                && letterFormatText.equals(letterFormat)
                && letterContentText.equals(letterContent)){
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

    public static void updateLetterPersonAction(String index){
        int personNumber = Integer.parseInt(index);
        int updateLetterPersonActionDelay = 20;

        try {
            if (mass.get(personNumber).get("Category") != null) {
                scrollToElement(By.xpath(USER_ACTION_SECTION_LABEL));
                waitUntilElementToBeSelected(By.cssSelector(ACTION_CATEGORY_DROPDOWN), updateLetterPersonActionDelay);
                BasePage.click(By.cssSelector(ACTION_CATEGORY_DROPDOWN));
                BasePage.selectElementsList(By.id(ACTION_CATEGORY_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(personNumber).get("Category"));
            }
            if (mass.get(personNumber).get("Action") != null) {
                scrollToElement(By.xpath(USER_ACTION_SECTION_LABEL));
                waitUntilElementToBeSelected(By.cssSelector(ACTION_DROPDOWN), updateLetterPersonActionDelay);
                BasePage.click(By.cssSelector(ACTION_DROPDOWN));
                BasePage.selectElementsList(By.id(ACTION_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(personNumber).get("Action"));
            }
            if (mass.get(personNumber).get("Staff") != null) {
                scrollToElement(By.xpath(USER_ACTION_SECTION_LABEL));
                waitUntilElementToBeSelected(By.cssSelector(ACTION_STAFF_DROPDOWN), updateLetterPersonActionDelay);
                BasePage.click(By.cssSelector(ACTION_STAFF_DROPDOWN));
                BasePage.selectElementsList(By.id(ACTION_STAFF_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(personNumber).get("Staff"));
            }
            if (mass.get(personNumber).get("Visibility") != null) {
                scrollToElement(By.xpath(USER_ACTION_SECTION_LABEL));
                waitUntilElementToBeSelected(By.cssSelector(ACTION_VISIBILITY), updateLetterPersonActionDelay);
                BasePage.click(By.cssSelector(ACTION_VISIBILITY));
                BasePage.selectElementsList(By.id(ACTION_VISIBILITY_LIST), "a");
                clickOnListOfElements(mass.get(personNumber).get("Visibility"));
            }
            if (mass.get(personNumber).get("Comments") != null) {
                scrollToElement(By.xpath(USER_ACTION_SECTION_LABEL));
                waitUntilElementToBeSelected(By.cssSelector(ACTION_VISIBILITY), updateLetterPersonActionDelay);
                BasePage.write(By.cssSelector(ACTION_COMMENTS_FIELD),mass.get(personNumber).get("Comments"));
            }

            ExtentReportsSetUp.testingPass(LogPage.UPDATE_LETTER_PERSON_ACTION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_LETTER_PERSON_ACTION_FAIL);
        }

    }
    public static void navigateToTemplatesTab(){
        try {
            waitUntilElementToBeSelected(By.cssSelector(LETTER_TEMPLATES_TAB),20);
            click(By.cssSelector(LETTER_TEMPLATES_TAB));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_TEMPLATES_TAB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_TEMPLATES_TAB_FAIL);
        }
    }

}
