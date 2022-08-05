package steps.Records;

import bean.FinancialAidBean;
import bean.FinancialAidPaymentBean;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Records.FinancialAidPage;

public class FinancialAidPageSteps {

    @And("I click save changes on financial aid")
    public static void clickSaveChanges() {
        FinancialAidPage.clickSaveChanges();
    }

    @Then("I update Financial Aid {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void updateFinancialAid(String aidAppType,String status,String aidTerm,String dateReceived,String desirabilityScore,String needScore,String group) {
        FinancialAidBean financialAidBean = new FinancialAidBean();
        financialAidBean.setAidAppType(aidAppType);
        financialAidBean.setStatus(status);
        financialAidBean.setAidTerm(aidTerm);
        financialAidBean.setDateReceived(dateReceived);
        financialAidBean.setDesirabilityScore(desirabilityScore);
        financialAidBean.setNeedScore(needScore);
        FinancialAidPage.updateFinancialAid(financialAidBean,group);
    }

}
