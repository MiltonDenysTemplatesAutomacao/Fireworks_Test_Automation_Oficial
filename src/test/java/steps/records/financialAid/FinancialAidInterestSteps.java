package steps.records.financialAid;

import bean.FinancialAidInterestBean;
import io.cucumber.java.en.And;
import pages.records.financialAid.FinancialAidInterestsPage;

public class FinancialAidInterestSteps {

    @And("I update Financial Aid Interest {string}, {string}, {string}, {string} group {string}")
    public static void updateFinancialAidInterest(String aidInterestCategory, String aidInterestType, String expressedInterest, String expressedInterestDate,String group) {
        FinancialAidInterestBean financialAidInterestBean = new FinancialAidInterestBean();
        financialAidInterestBean.setAidInterestCategory(aidInterestCategory);
        financialAidInterestBean.setAidInterestType(aidInterestType);
        financialAidInterestBean.setExpressedInterest(expressedInterest);
        financialAidInterestBean.setExpressedInterestDate(expressedInterestDate);
        FinancialAidInterestsPage.updateFinancialAidInterest(financialAidInterestBean,group);
    }
    @And("I verify Financial Aid Interest {string}, {string}, {string}, {string} group {string}")
    public static void verifyFinancialAidInterest(String aidInterestCategory, String aidInterestType, String expressedInterest, String expressedInterestDate,String group) {
        FinancialAidInterestBean financialAidInterestBean = new FinancialAidInterestBean();
        financialAidInterestBean.setAidInterestCategory(aidInterestCategory);
        financialAidInterestBean.setAidInterestType(aidInterestType);
        financialAidInterestBean.setExpressedInterest(expressedInterest);
        financialAidInterestBean.setExpressedInterestDate(expressedInterestDate);
        FinancialAidInterestsPage.verifyFinancialAidInterest(financialAidInterestBean,group);
    }

}
