package pages.records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class TextMessagesPage extends BasePage {
    public static final String CREATE_BUTTON = "#top-controls-create-new-text";
    public static final String NAME_FIELD = "#name";
    public static final String DESCRIPTION_FIELD = "#description";
    public static final String SMART_SEARCH_PICKER_BUTTON = "#picker_input_trigger_button";
    public static final String SMART_SEARCH_PICKER_MODAL_SEARCH_FIELD = "#savedSearchPickerModalTableControlsTableSearch";
    public static final String SMART_SEARCH_PICKER_MODAL_FIRST_ROW_FIRST_COLUMN_ELEMENT = "#savedSearchPickerModalTable_row_0_col_1";
    public static final String SMART_SEARCH_PICKER_MODAL_FIRST_ROW_CHECKBOX = "#savedSearchPickerModalTable_row_0_col_0 > div > input";
    public static final String SMART_SEARCH_PICKER_MODAL_CHOOSE_BUTTON = "#modalSubmitButtonsavedSearchPicker";
    public static final String SINGLE_RECIPIENT_PICKER_BUTTON = "#phoneNumberPickerTrigger";
    public static final String SINGLE_RECIPIENT_PICKER_MODAL_SEARCH_FIELD = "#phoneNumberPickerModalTableControlsTableSearch";
    public static final String SINGLE_RECIPIENT_PICKER_MODAL_FIRST_ROW_ELEMENT = "#phoneNumberPickerModalTable_row_0";
    public static final String SINGLE_RECIPIENT_PICKER_MODAL_FIRST_ROW_CHECKBOX = "#phoneNumberPickerModalTable_row_0_col_0 > div > input";
    public static final String SINGLE_RECIPIENT_PICKER_MODAL_CHOOSE_BUTTON = "#modalSubmitButtonphoneNumberPicker";
    public static final String MESSAGE_CONTENT_FIELD = "#message_content";

    public static void updateBodyTab(String content){
        try {
            fillField(By.cssSelector(MESSAGE_CONTENT_FIELD),content);
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_BODY_TAB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_BODY_TAB_FAIL);
        }
    }
    public static void createTextMessage(){
        try {
            clickOption(By.cssSelector(CREATE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CREATE_TEXT_MESSAGE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_TEXT_MESSAGE_FAIL);
        }
    }
    public static void updateStartTab(String name, String description,String smartSearch,String recipient){
        try {
            fillField(By.cssSelector(NAME_FIELD),name);
            fillField(By.cssSelector(DESCRIPTION_FIELD),description);
            picker(By.cssSelector(SMART_SEARCH_PICKER_BUTTON),
                    By.cssSelector(SMART_SEARCH_PICKER_MODAL_SEARCH_FIELD),
                    By.cssSelector(SMART_SEARCH_PICKER_MODAL_FIRST_ROW_FIRST_COLUMN_ELEMENT),
                    By.cssSelector(SMART_SEARCH_PICKER_MODAL_FIRST_ROW_CHECKBOX),
                    By.cssSelector(SMART_SEARCH_PICKER_MODAL_CHOOSE_BUTTON),smartSearch);
            picker(By.cssSelector(SINGLE_RECIPIENT_PICKER_BUTTON),
                    By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_SEARCH_FIELD),
                    By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_FIRST_ROW_ELEMENT),
                    By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_FIRST_ROW_CHECKBOX),
                    By.cssSelector(SINGLE_RECIPIENT_PICKER_MODAL_CHOOSE_BUTTON),recipient);
                    ExtentReportsSetUp.testingPass(LogPage.UPDATE_START_TAB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_START_TAB_FAIL);
        }
    }

}
