package steps.records.financialAid;

import bean.FinancialAidBean;
import io.cucumber.java.en.Then;
import pages.records.financialAid.FinancialComponentsAidPage;

public class FinancialAidComponentsSteps {

    @Then("I update Financial Aid Component {string}, {string}, {string}, {string}, {string} Financial {string} Aid {string}")
    public static void updateAidComponent(String aidComponentType,String aidComponentRcvd,String aidComponentRcvdDate,String aidComponentReqd,String aidComponentComments,String fin,String aid) {
        FinancialAidBean financialAidBean = new FinancialAidBean();
        financialAidBean.setAidComponentType(aidComponentType);
        financialAidBean.setAidComponentRcvd(aidComponentRcvd);
        financialAidBean.setAidComponentRcvdDate(aidComponentRcvdDate);
        financialAidBean.setAidComponentReqd(aidComponentReqd);
        financialAidBean.setAidComponentComments(aidComponentComments);
        FinancialComponentsAidPage.updateAidComponent(financialAidBean,fin,aid);
    }
    @Then("I verify Financial Aid Component {string}, {string}, {string}, {string}, {string} Financial {string} Aid {string}")
    public static void verifyAidComponent(String aidComponentType,String aidComponentRcvd,String aidComponentRcvdDate,String aidComponentReqd,String aidComponentComments,String fin,String aid) {
        FinancialAidBean financialAidBean = new FinancialAidBean();
        financialAidBean.setAidComponentType(aidComponentType);
        financialAidBean.setAidComponentRcvd(aidComponentRcvd);
        financialAidBean.setAidComponentRcvdDate(aidComponentRcvdDate);
        financialAidBean.setAidComponentReqd(aidComponentReqd);
        financialAidBean.setAidComponentComments(aidComponentComments);
        FinancialComponentsAidPage.verifyAidComponent(financialAidBean,fin,aid);
    }
}
