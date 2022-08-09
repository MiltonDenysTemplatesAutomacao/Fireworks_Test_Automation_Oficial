package steps.Records;

import bean.FinancialAidBean;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Records.FinancialAidPage;

public class FinancialAidSteps {

    @And("I click save changes on financial aid")
    public static void clickSaveChanges() {
        FinancialAidPage.clickSaveChanges();
    }
    @And("I add Financial Aid {string}")
    public static void addFinancialAid(String fin) {
        FinancialAidPage.addFinancialAid(fin);
    }
    @And("I update Financial Aid Active {string}")
    public static void clickFinancialAidActive(String fin) {
        FinancialAidPage.clickFinancialAidActive(fin);
    }
    @And("I verify financial Aid {string} group {string} checkbox {string}")
    public static void verifyFinancialAidActivePrimaryCheckbox(String checkboxName,String fin,String checkbox) {
        FinancialAidPage.verifyFinancialAidActivePrimaryCheckbox(checkboxName,fin,checkbox);
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
    @Then("I verify financial Aid {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void verifyFinancialAid(String aidAppType,String status,String aidTerm,String awardCount,String totalAwardAmount, String dateReceived,String desirabilityScore,String needScore,String group) {
        FinancialAidBean financialAidBean = new FinancialAidBean();
        financialAidBean.setAidAppType(aidAppType);
        financialAidBean.setStatus(status);
        financialAidBean.setAidTerm(aidTerm);
        financialAidBean.setAwardCount(awardCount);
        financialAidBean.setTotalAwardAmount(totalAwardAmount);
        financialAidBean.setDateReceived(dateReceived);
        financialAidBean.setDesirabilityScore(desirabilityScore);
        financialAidBean.setNeedScore(needScore);
        FinancialAidPage.verifyFinancialAid(financialAidBean,group);
    }

}
