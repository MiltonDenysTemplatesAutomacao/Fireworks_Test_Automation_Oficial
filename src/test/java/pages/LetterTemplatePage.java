package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class LetterTemplatePage extends BasePage{
    public static final String CREATE_NEW_LETTER_TEMPLATE_BUTTON = "top-controls-create-new-letter-template";
    public static final String TEMPLATE_NAME_FIELD = "#template_name";
    public static final String TEMPLATE_DESCRIPTION_FIELD = "#description";
    public static final String TEMPLATE_RECORD_TYPE_DROPDOWN = "div#s2id_record_type_id.select2-container.form-control.select2.select2 a.select2-choice";
    public static final String LETTER_FORMAT_DROPDOWN = "#s2id_letter_size_format_id";
    public static final String LETTER_CONTENT_IFRAME_ELEMENT = "content_ifr";
    public static final String LETTER_CONTENT_IFRAME_BODY_ELEMENT = "tinymce";
    public static final String SAVE_TEMPLATE_BUTTON = "saveTemplate";


    public static void saveTemplate(){
        try {
            scrollToElement(By.cssSelector(LettersPage.ACTION_COMMENTS_FIELD));
            waitUntilElementToBeSelected(By.id(SAVE_TEMPLATE_BUTTON),20);
            click(By.id(SAVE_TEMPLATE_BUTTON));
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
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (mass.get(person).get("LetterFormat") != null) {
                MainPage.clickOptionList(By.cssSelector(LETTER_FORMAT_DROPDOWN),
                        mass.get(person).get("LetterFormat"),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (mass.get(person).get("LetterContent") != null) {
                switchToIFrame(LETTER_CONTENT_IFRAME_ELEMENT);
                MainPage.fillField(By.id(LETTER_CONTENT_IFRAME_BODY_ELEMENT), mass.get(person).get("LetterContent"));
                switchToDefaultContent();
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_LETTER_TEMPLATE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_LETTER_TEMPLATE_FAIL);
        }
    }
}
