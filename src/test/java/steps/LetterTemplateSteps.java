package steps;

import io.cucumber.java.en.And;
import pages.LetterTemplatePage;

public class LetterTemplateSteps {

    @And("I click on create template button")
    public static void createPerson() {
        LetterTemplatePage.createTemplate();
    }
    @And("I update letter template person {string}")
    public static void updateLetterTemplate(String person) {
        LetterTemplatePage.updateLetterTemplate(person);
    }
    @And("I click on save template button")
    public static void saveTemplate() {
        LetterTemplatePage.saveTemplate();
    }


}
