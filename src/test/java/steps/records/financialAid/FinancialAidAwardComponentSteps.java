package steps.records.financialAid;

import bean.FinancialAidBean;
import io.cucumber.java.en.Then;
import pages.records.financialAid.FinancialAidAwardComponentsPage;

public class FinancialAidAwardComponentSteps {
    @Then("I update Award Component {string}, {string}, {string}, {string} Financial {string} Award Component {string}")
    public static void updateAwardComponent(String awardComponentAmount,String awardComponentCategory,String awardComponentType,String awardComponentComments,String fin,String awardComponent) {
        FinancialAidBean financialAidBean = new FinancialAidBean();
        financialAidBean.setAwardComponentAmount(awardComponentAmount);
        financialAidBean.setAwardComponentCategory(awardComponentCategory);
        financialAidBean.setAwardComponentType(awardComponentType);
        financialAidBean.setAwardComponentComments(awardComponentComments);

        FinancialAidAwardComponentsPage.updateAwardComponent(financialAidBean,fin,awardComponent);
    }
    @Then("I verify Award Component {string}, {string}, {string}, {string} Financial {string} Award Component {string}")
    public static void verifyAwardComponent(String awardComponentAmount,String awardComponentCategory,String awardComponentType,String awardComponentComments,String fin,String awardComponent) {
        FinancialAidBean financialAidBean = new FinancialAidBean();
        financialAidBean.setAwardComponentAmount(awardComponentAmount);
        financialAidBean.setAwardComponentCategory(awardComponentCategory);
        financialAidBean.setAwardComponentType(awardComponentType);
        financialAidBean.setAwardComponentComments(awardComponentComments);
        FinancialAidAwardComponentsPage.verifyAwardComponent(financialAidBean,fin,awardComponent);
    }
    @Then("I add Award Component Financial {string} Award Component {string}")
    public static void addAwardComponent(String fin,String awardComponent) {
        FinancialAidAwardComponentsPage.addAwardComponent(fin,awardComponent);
    }


}
