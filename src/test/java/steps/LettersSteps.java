package steps;

import io.cucumber.java.en.And;
import pages.LettersPage;

public class LettersSteps {
    @And("I navigate to template tab")
    public static void navigateToTemplatesTab() {
        LettersPage.navigateToTemplatesTab();
    }
    @And("I update letter person action index {string}")
    public static void updateLetterPersonAction(String index) {
        LettersPage.updateLetterPersonAction(index);
    }
    @And("I click on create letter button")
    public static void createLetter() {
        LettersPage.createLetter();
    }
    @And("I load Template {string}")
    public static void loadTemplate(String templateName) {
        LettersPage.loadTemplate(templateName);
    }
    @And("I verify draft letter {string}, {string}, {string} and {string}")
    public static void verifyDraftLetter(String letterName,String search,String letterFormat,String letterContent) {
        LettersPage.verifyDraftLetter(letterName,search,letterFormat,letterContent);
    }
    @And("I verify letter person action {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public static void verifyLetterPersonAction(String category,String action,String actionType,String actionVisibility, String staff, String date,String comments) {
        LettersPage.verifyLetterPersonAction(category,action,actionType,actionVisibility,staff,date,comments);
    }
    @And("I update letter details person {int}")
    public static void updateLetterDetails(int index) {
        LettersPage.updateLetterDetails(index);
    }
    @And("I update letter recipients person {int}")
    public static void updateLetterRecipients(int index) {
        LettersPage.updateLetterRecipients(index);
    }
}
