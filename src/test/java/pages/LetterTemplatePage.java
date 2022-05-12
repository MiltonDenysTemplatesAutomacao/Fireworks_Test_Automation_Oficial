package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.Records.StudentStatusPage;

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
            scrollToElement(By.id(LettersPage.ACTION_COMMENTS_FIELD));
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
    public static void updateLetterTemplate(String person){
        int personNumber = Integer.parseInt(person);
        int updateLetterTemplateDelay = 20;

        try {
            if (mass.get(personNumber).get("TemplateName") != null) {
                waitElementBy(By.cssSelector(TEMPLATE_NAME_FIELD), updateLetterTemplateDelay);
                BasePage.write(By.cssSelector(TEMPLATE_NAME_FIELD),mass.get(personNumber).get("TemplateName"));
            }
            if (mass.get(personNumber).get("TemplateDescription") != null) {
                waitElementBy(By.cssSelector(TEMPLATE_DESCRIPTION_FIELD), updateLetterTemplateDelay);
                BasePage.write(By.cssSelector(TEMPLATE_DESCRIPTION_FIELD),mass.get(personNumber).get("TemplateDescription"));
            }
            if (mass.get(personNumber).get("RecordType") != null) {
                scrollToElement(By.cssSelector(TEMPLATE_DESCRIPTION_FIELD));
                waitUntilElementToBeSelected(By.cssSelector(TEMPLATE_RECORD_TYPE_DROPDOWN), updateLetterTemplateDelay);
                BasePage.click(By.cssSelector(TEMPLATE_RECORD_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(personNumber).get("RecordType"));
            }
            if (mass.get(personNumber).get("LetterFormat") != null) {
                scrollToElement(By.cssSelector(TEMPLATE_RECORD_TYPE_DROPDOWN));
                waitUntilElementToBeSelected(By.cssSelector(LETTER_FORMAT_DROPDOWN), updateLetterTemplateDelay);
                BasePage.click(By.cssSelector(LETTER_FORMAT_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(personNumber).get("LetterFormat"));
            }
            if (mass.get(personNumber).get("LetterContent") != null) {
                switchToIFrame(LETTER_CONTENT_IFRAME_ELEMENT);
                waitElementBy(By.id(LETTER_CONTENT_IFRAME_BODY_ELEMENT), updateLetterTemplateDelay);
                BasePage.write(By.id(LETTER_CONTENT_IFRAME_BODY_ELEMENT),mass.get(personNumber).get("LetterContent"));
                switchToDefaultContent();
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_LETTER_TEMPLATE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_LETTER_TEMPLATE_FAIL);
        }
    }
}
