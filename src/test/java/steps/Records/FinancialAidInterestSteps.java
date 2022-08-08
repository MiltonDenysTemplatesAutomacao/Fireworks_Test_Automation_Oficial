package steps.Records;

import bean.FinancialAidInterestBean;
import io.cucumber.java.en.And;
import pages.Records.FinancialAidInterestsPage;

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

}
