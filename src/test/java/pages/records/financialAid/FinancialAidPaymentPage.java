package pages.records.financialAid;

import bean.FinancialAidPaymentBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.*;

public class FinancialAidPaymentPage extends BasePage {

    private static String paymentDateField(String index){
        return String.format("#person_payment_%s_payment_date",index);
    }
    private static String paymentAmountField(String index){
        return String.format("#person_payment_%s_payment_amount",index);
    }
    private static String paymentPurposeDropdown(String index){
        return String.format("div#s2id_person_payment_%s_payment_purpose.select2-container.form-control.person_payment.select2 a.select2-choice",index);
    }
    private static String paymentTypeDropdown(String index){
        return String.format("div#s2id_person_payment_%s_payment_type.select2-container.form-control.person_payment.select2 a.select2-choice",index);
    }
    private static String paymentWhoAddedDropdown(String index){
        return String.format("div#s2id_person_payment_%s_payment_who.select2-container.form-control.person_payment.select2 a.select2-choice",index);
    }
    private static String paymentCommentField(String index){
        return String.format("#person_payment_%s_payment_comment",index);
    }
    private static String financialAidPaymentPlusButton(String index){
        return String.format("#person_payment_%s_add",index);
    }

    public static void verifyFinancialAidPayment(FinancialAidPaymentBean financialAidPaymentBean, String group){
        String passMessage = String.format(LogPage.VERIFY_FINANCIAL_AID_PAYMENT_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_FINANCIAL_AID_PAYMENT_FAIL,group);


        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(paymentDateField(group)),financialAidPaymentBean.getPaymentDate())
                && MainPage.verifyGetAttribute(By.cssSelector(paymentAmountField(group)),financialAidPaymentBean.getPaymentAmount())
                && MainPage.verifyGetText(By.cssSelector(paymentPurposeDropdown(group)),financialAidPaymentBean.getPaymentPurpose())
                && MainPage.verifyGetText(By.cssSelector(paymentTypeDropdown(group)),financialAidPaymentBean.getPaymentType())
                && MainPage.verifyGetText(By.cssSelector(paymentWhoAddedDropdown(group)),financialAidPaymentBean.getPaymentWhoAdded())
                && MainPage.verifyGetAttribute(By.cssSelector(paymentCommentField(group)),financialAidPaymentBean.getPaymentComment())){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateFinancialAidPayment(FinancialAidPaymentBean financialAidPaymentBean, String group){

        String passMessage = String.format(LogPage.UPDATE_FINANCIAL_AID_PAYMENT_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_FINANCIAL_AID_PAYMENT_FAIL,group);
        try {
            if(financialAidPaymentBean.getPaymentDate()!=""){
                MainPage.fillDateField(By.cssSelector(paymentDateField(group)), financialAidPaymentBean.getPaymentDate());
            }
            if(financialAidPaymentBean.getPaymentAmount()!=""){
                MainPage.fillField(By.cssSelector(paymentAmountField(group)), financialAidPaymentBean.getPaymentAmount());
            }
            if(financialAidPaymentBean.getPaymentPurpose()!=""){
                MainPage.clickOptionList(By.cssSelector(paymentPurposeDropdown(group)),
                        financialAidPaymentBean.getPaymentPurpose(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(financialAidPaymentBean.getPaymentType()!=""){
                MainPage.clickOptionList(By.cssSelector(paymentTypeDropdown(group)),
                        financialAidPaymentBean.getPaymentType(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(financialAidPaymentBean.getPaymentWhoAdded()!=""){
                MainPage.clickOptionList(By.cssSelector(paymentWhoAddedDropdown(group)),
                        financialAidPaymentBean.getPaymentWhoAdded(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(financialAidPaymentBean.getPaymentComment()!=""){
                MainPage.fillField(By.cssSelector(paymentCommentField(group)), financialAidPaymentBean.getPaymentComment());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
