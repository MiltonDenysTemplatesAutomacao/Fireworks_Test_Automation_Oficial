package steps.Records;

import io.cucumber.java.en.And;
import pages.Records.FinancialAidPage;

public class FinancialAidPageSteps {

    @And("I click save changes on financial aid")
    public static void clickSaveChanges() {
        FinancialAidPage.clickSaveChanges();
    }



}
