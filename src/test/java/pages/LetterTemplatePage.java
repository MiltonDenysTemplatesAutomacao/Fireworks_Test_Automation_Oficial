package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableAny;
import org.openqa.selenium.By;

public class LetterTemplatePage extends BasePage{
    public static final String CREATE_NEW_LETTER_TEMPLATE_BUTTON = "top-controls-create-new-letter-template";
    public static final String TEMPLATE_NAME_FIELD = "#template_name";
    public static final String TEMPLATE_DESCRIPTION_FIELD = "#description";
    public static final String TEMPLATE_RECORD_TYPE_DROPDOWN = "div#s2id_record_type_id.select2-container.form-control.select2.select2 a.select2-choice";
    public static final String LETTER_FORMAT_DROPDOWN = "#s2id_letter_size_format_id";
    public static final String LETTER_CONTENT_IFRAME_ELEMENT = "content_ifr";
    public static final String LETTER_CONTENT_IFRAME_BODY_ELEMENT = "tinymce";
    public static final String SAVE_TEMPLATE_BUTTON = "#saveTemplate";
    public static final String LETTER_TEMPLATE_MANAGER_SEARCH_FIELD = "#letterTemplateManagerTableControlsTableSearch";
    public static final String LETTER_TEMPLATE_TABLE_ROW1_COL1 = "#letterTemplateManagerTable_row_0_col_0";
    public static final String INCLUDE_LETTER_CHECKBOX = "#includeLetterCheckbox";

    public static void verifyIfTemplateExists(String template){
        String passMessage = String.format(LogPage.VERIFY_IF_TEMPLATE_EXISTS_PASS,template);
        String failMessage = String.format(LogPage.VERIFY_IF_TEMPLATE_EXISTS_PASS,template);
        try {
            if(verifyGetText(By.cssSelector(LETTER_TEMPLATE_TABLE_ROW1_COL1),template)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void verifyLetterTemplate(int index){
        try {
            if(verifyGetAttribute(By.cssSelector(TEMPLATE_NAME_FIELD),mass.get(index).get("TemplateName"))
                && verifyGetAttribute(By.cssSelector(TEMPLATE_DESCRIPTION_FIELD),mass.get(index).get("TemplateDescription"))
                && verifyGetText(By.cssSelector(TEMPLATE_RECORD_TYPE_DROPDOWN),mass.get(index).get("RecordType"))
                && verifyCheckboxActiveOrNot(By.cssSelector(INCLUDE_LETTER_CHECKBOX),mass.get(index).get("IncludeLetterCheckbox"))
                && verifyGetText(By.cssSelector(LETTER_FORMAT_DROPDOWN),mass.get(index).get("LetterFormat"))
                && verifyElementWithIFrame(By.id(LETTER_CONTENT_IFRAME_ELEMENT),
                    LETTER_CONTENT_IFRAME_ELEMENT,
                    By.id(LETTER_CONTENT_IFRAME_BODY_ELEMENT),
                    mass.get(index).get("LetterContent"))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_LETTER_TEMPLATE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_LETTER_TEMPLATE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_LETTER_TEMPLATE_FAIL);
        }
    }
    public static void searchTemplateManager(String template){
        String passMessage = String.format(LogPage.SEARCH_TEMPLATE_MANAGER_PASS,template);
        String failMessage = String.format(LogPage.SEARCH_TEMPLATE_MANAGER_FAIL,template);
        try {
            fillField(By.cssSelector(LETTER_TEMPLATE_MANAGER_SEARCH_FIELD),template);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void openTemplate(String template){
        String passMessage = String.format(LogPage.OPEN_TEMPLATE_MANAGER_PASS,template);
        String failMessage = String.format(LogPage.OPEN_TEMPLATE_MANAGER_FAIL,template);
        try {
            searchTemplateManager(template);
            wait(2000);
            clickOption(By.cssSelector(LETTER_TEMPLATE_TABLE_ROW1_COL1));
            waitElementBy(By.cssSelector(TEMPLATE_NAME_FIELD),10);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void saveTemplate(){
        try {
            wait(1000);
            clickOption(By.cssSelector(SAVE_TEMPLATE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_TEMPLATE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_TEMPLATE_FAIL);
        }
    }
    public static void createTemplate(){
        try {
            waitUntilElementToBeSelected(By.id(CREATE_NEW_LETTER_TEMPLATE_BUTTON),20);
            click(By.id(CREATE_NEW_LETTER_TEMPLATE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CREATE_TEMPLATE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_TEMPLATE_FAIL);
        }
    }
    public static void updateLetterTemplate(int person){

        try {
            if (mass.get(person).get("TemplateName") != null) {
                MainPage.fillField(By.cssSelector(TEMPLATE_NAME_FIELD), mass.get(person).get("TemplateName"));
            }
            if (mass.get(person).get("TemplateDescription") != null) {
                MainPage.fillField(By.cssSelector(TEMPLATE_DESCRIPTION_FIELD), mass.get(person).get("TemplateDescription"));
            }
            if (mass.get(person).get("RecordType") != null) {
                MainPage.clickOptionList(By.cssSelector(TEMPLATE_RECORD_TYPE_DROPDOWN),
                        mass.get(person).get("RecordType"),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (mass.get(person).get("IncludeLetterCheckbox") != null) {
                clickOption(By.cssSelector(INCLUDE_LETTER_CHECKBOX));
            }
            if (mass.get(person).get("LetterFormat") != null) {
                MainPage.clickOptionList(By.cssSelector(LETTER_FORMAT_DROPDOWN),
                        mass.get(person).get("LetterFormat"),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (mass.get(person).get("LetterContent") != null) {
                fillElementWithIFrame(LETTER_CONTENT_IFRAME_ELEMENT,
                        By.id(LETTER_CONTENT_IFRAME_BODY_ELEMENT),
                        mass.get(person).get("LetterContent"));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_LETTER_TEMPLATE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_LETTER_TEMPLATE_FAIL);
        }
    }
}
