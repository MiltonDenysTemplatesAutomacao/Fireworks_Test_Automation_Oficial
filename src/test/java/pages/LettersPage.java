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
    public static final String ACTION_COMMENTS_FIELD = "action_comments";
    public static final String CREATE_NEW_LETTER_BUTTON = "#top-controls-create-new-letter";
    public static final String LOAD_TEMPLATE_DROPDOWN = "s2id_loadTemplate";
    public static final String DROPDOWN_INPUT_FIELD_ELEMENT = "s2id_autogen1_search";
    public static final String LETTER_NAME_FIELD = "name";
    public static final String SMART_SEARCH_DROPDOWN = "div#s2id_saved_search_id.select2-container.form-control.select2.select2 a.select2-choice";
    public static final String LETTER_FORMAT_DROPDOWN = "div#s2id_letter_size_format_id.select2-container.form-control.select2.select2 a.select2-choice";

    public static void verifyDraftLetter(String letterName,String search,String letterFormat,String letterContent){
        try {
            scrollToElement(By.id(LOAD_TEMPLATE_DROPDOWN));
            String letterNameText = getText(By.id(LETTER_NAME_FIELD));
            String searchText = getText(By.cssSelector(SMART_SEARCH_DROPDOWN));
            String letterFormatText = getText(By.cssSelector(LETTER_FORMAT_DROPDOWN));
            switchToIFrame(LetterTemplatePage.LETTER_CONTENT_IFRAME_ELEMENT);
            String letterContentText = getText(By.id(LetterTemplatePage.LETTER_CONTENT_IFRAME_BODY_ELEMENT));
            switchToDefaultContent();


        } catch (Exception e) {

        }

    }
    public static void loadTemplate(String templateName){
        String errorMessage = String.format(LogPage.LOAD_TEMPLATE_PASS, templateName);
        String passMessage = String.format(LogPage.LOAD_TEMPLATE_FAIL, templateName);
        try {
            waitElementBy(By.id(LOAD_TEMPLATE_DROPDOWN),20);
            click(By.id(LOAD_TEMPLATE_DROPDOWN));
            waitElementBy(By.id(DROPDOWN_INPUT_FIELD_ELEMENT),20);
            write(By.id(DROPDOWN_INPUT_FIELD_ELEMENT),templateName);
            KeyPage.sendKey("Enter");
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
                BasePage.write(By.id(ACTION_COMMENTS_FIELD),mass.get(personNumber).get("Comments"));
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
