package steps.Records;

import bean.FinancialAidPaymentBean;
import io.cucumber.java.en.Then;
import pages.Records.FinancialAidPaymentPage;

public class FinancialAidPaymentSteps {
    @Then("I update FinancialAidPayment {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void updateFinancialAidPayment(String paymentDate,String paymentAmount,String paymentPurpose,String paymentType,String paymentWhoAdded,String paymentComment,String group) {
        FinancialAidPaymentBean financialAidPaymentBean = new FinancialAidPaymentBean();
        financialAidPaymentBean.setPaymentDate(paymentDate);
        financialAidPaymentBean.setPaymentAmount(paymentAmount);
        financialAidPaymentBean.setPaymentPurpose(paymentPurpose);
        financialAidPaymentBean.setPaymentType(paymentType);
        financialAidPaymentBean.setPaymentWhoAdded(paymentWhoAdded);
        financialAidPaymentBean.setPaymentComment(paymentComment);
        FinancialAidPaymentPage.updateFinancialAidPayment(financialAidPaymentBean,group);
    }
    @Then("I verify FinancialAidPayment {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void verifyFinancialAidPayment(String paymentDate,String paymentAmount,String paymentPurpose,String paymentType,String paymentWhoAdded,String paymentComment,String group) {
        FinancialAidPaymentBean financialAidPaymentBean = new FinancialAidPaymentBean();
        financialAidPaymentBean.setPaymentDate(paymentDate);
        financialAidPaymentBean.setPaymentAmount(paymentAmount);
        financialAidPaymentBean.setPaymentPurpose(paymentPurpose);
        financialAidPaymentBean.setPaymentType(paymentType);
        financialAidPaymentBean.setPaymentWhoAdded(paymentWhoAdded);
        financialAidPaymentBean.setPaymentComment(paymentComment);
        FinancialAidPaymentPage.verifyFinancialAidPayment(financialAidPaymentBean,group);
    }

}
