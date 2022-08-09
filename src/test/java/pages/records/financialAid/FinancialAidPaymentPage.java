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

        boolean paymentDateValidation = false;
        boolean paymentAmountValidation = false;
        boolean paymentPurposeValidation = false;
        boolean paymentTypeValidation = false;
        boolean paymentWhoAddedValidation = false;
        boolean paymentCommentValidation = false;

        try {
            if(financialAidPaymentBean.getPaymentDate()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(group)));
                String paymentDateText = getAtribute(By.cssSelector(paymentDateField(group)),"value");
                paymentDateValidation = paymentDateText.contains(financialAidPaymentBean.getPaymentDate());
            }else{
                paymentDateValidation=true;
            }
            if(financialAidPaymentBean.getPaymentAmount()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(group)));
                String paymentAmountText = getAtribute(By.cssSelector(paymentAmountField(group)),"value");
                paymentAmountValidation = paymentAmountText.contains(financialAidPaymentBean.getPaymentAmount());
            }else{
                paymentAmountValidation=true;
            }
            if(financialAidPaymentBean.getPaymentPurpose()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(group)));
                String paymentPurposeText = getText(By.cssSelector(paymentPurposeDropdown(group)));
                paymentPurposeValidation = paymentPurposeText.contains(financialAidPaymentBean.getPaymentPurpose());
            }else{
                paymentPurposeValidation=true;
            }
            if(financialAidPaymentBean.getPaymentType()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(group)));
                String paymentTypeText = getText(By.cssSelector(paymentTypeDropdown(group)));
                paymentTypeValidation = paymentTypeText.contains(financialAidPaymentBean.getPaymentType());
            }else{
                paymentTypeValidation=true;
            }
            if(financialAidPaymentBean.getPaymentWhoAdded()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(group)));
                String paymentWhoAddedText = getText(By.cssSelector(paymentWhoAddedDropdown(group)));
                paymentWhoAddedValidation = paymentWhoAddedText.contains(financialAidPaymentBean.getPaymentWhoAdded());
            }else{
                paymentWhoAddedValidation=true;
            }
            if(financialAidPaymentBean.getPaymentComment()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(group)));
                String paymentCommentText = getAtribute(By.cssSelector(paymentCommentField(group)),"value");
                paymentCommentValidation = paymentCommentText.contains(financialAidPaymentBean.getPaymentComment());

            }else{
                paymentCommentValidation=true;
            }
            if(paymentDateValidation
            && paymentAmountValidation
            && paymentPurposeValidation
            && paymentTypeValidation
            && paymentWhoAddedValidation
            && paymentCommentValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateFinancialAidPayment(FinancialAidPaymentBean financialAidPaymentBean, String group){

        int updateFinancialAidPaymentDelay=10;
        String passMessage = String.format(LogPage.UPDATE_FINANCIAL_AID_PAYMENT_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_FINANCIAL_AID_PAYMENT_FAIL,group);
        try {
            if(financialAidPaymentBean.getPaymentDate()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(group)));
                waitElementBy(By.cssSelector(paymentDateField(group)),updateFinancialAidPaymentDelay);
                KeyPage.erase(By.cssSelector(paymentDateField(group)));
                waitElementBy(By.cssSelector(paymentDateField(group)),updateFinancialAidPaymentDelay);
                write(By.cssSelector(paymentDateField(group)),financialAidPaymentBean.getPaymentDate());
                KeyPage.pressKey(By.cssSelector(paymentDateField(group)),"Enter");
            }
            if(financialAidPaymentBean.getPaymentAmount()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(group)));
                waitElementBy(By.cssSelector(paymentAmountField(group)),updateFinancialAidPaymentDelay);
                write(By.cssSelector(paymentAmountField(group)),financialAidPaymentBean.getPaymentAmount());
            }
            if(financialAidPaymentBean.getPaymentPurpose()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(group)));
                waitElementBy(By.cssSelector(paymentPurposeDropdown(group)),updateFinancialAidPaymentDelay);
                click(By.cssSelector(paymentPurposeDropdown(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateFinancialAidPaymentDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(financialAidPaymentBean.getPaymentPurpose());
            }
            if(financialAidPaymentBean.getPaymentType()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(group)));
                waitElementBy(By.cssSelector(paymentTypeDropdown(group)),updateFinancialAidPaymentDelay);
                click(By.cssSelector(paymentTypeDropdown(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateFinancialAidPaymentDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(financialAidPaymentBean.getPaymentType());
            }
            if(financialAidPaymentBean.getPaymentWhoAdded()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(group)));
                waitElementBy(By.cssSelector(paymentWhoAddedDropdown(group)),updateFinancialAidPaymentDelay);
                click(By.cssSelector(paymentWhoAddedDropdown(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateFinancialAidPaymentDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(financialAidPaymentBean.getPaymentWhoAdded());
            }
            if(financialAidPaymentBean.getPaymentComment()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(group)));
                waitElementBy(By.cssSelector(paymentCommentField(group)),updateFinancialAidPaymentDelay);
                write(By.cssSelector(paymentCommentField(group)),financialAidPaymentBean.getPaymentComment());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
