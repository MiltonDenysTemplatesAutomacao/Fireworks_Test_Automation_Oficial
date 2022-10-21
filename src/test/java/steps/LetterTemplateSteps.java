package steps;

import io.cucumber.java.en.And;
import pages.LetterTemplatePage;

public class LetterTemplateSteps {

    @And("I click on create template button")
    public static void createTemplate() {
        LetterTemplatePage.createTemplate();
    }
    @And("I update letter template person {int}")
    public static void updateLetterTemplate(int person) {
        LetterTemplatePage.updateLetterTemplate(person);
    }
    @And("I verify letter template {int}")
    public static void verifyLetterTemplate(int index) {
        LetterTemplatePage.verifyLetterTemplate(index);
    }
    @And("I click on save template button")
    public static void saveTemplate() {
        LetterTemplatePage.saveTemplate();
    }
    @And("I open template {string}")
    public static void openTemplate(String template) {
        LetterTemplatePage.openTemplate(template);
    }
    @And("I search template {string}")
    public static void searchTemplateManager(String template) {
        LetterTemplatePage.searchTemplateManager(template);
    }
    @And("I verify if template {string} exists")
    public static void verifyIfTemplateExists(String template) {
        LetterTemplatePage.verifyIfTemplateExists(template);
    }

}
