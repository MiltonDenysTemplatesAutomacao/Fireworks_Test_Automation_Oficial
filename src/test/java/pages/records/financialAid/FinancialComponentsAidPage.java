package pages.records.financialAid;

import bean.FinancialAidBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.*;

public class FinancialComponentsAidPage extends BasePage {

    private static String financialAidPaymentPlusButton(String fin,String aid){
        return String.format("#person_financial_aid_%s_person_financial_aid_app_component_%s_add",fin,aid);
    }
    private static String aidComponentTypeElement(String fin,String aid){
        return String.format("#s2id_person_financial_aid_%s_person_financial_aid_app_component_%s_aid_component_type",fin,aid);
    }
    private static String aidComponentReceivedElement(String fin,String aid){
        return String.format("#s2id_person_financial_aid_%s_person_financial_aid_app_component_%s_aid_component_received",fin,aid);
    }
    private static String aidComponentReceivedDateField(String fin,String aid){
        return String.format("#person_financial_aid_%s_person_financial_aid_app_component_%s_aid_component_received_date",fin,aid);
    }
    private static String aidComponentRequiredElement(String fin,String aid){
        return String.format("#s2id_person_financial_aid_%s_person_financial_aid_app_component_%s_aid_component_required",fin,aid);
    }
    private static String aidComponentCommentsField(String fin,String aid){
        return String.format("#person_financial_aid_%s_person_financial_aid_app_component_%s_aid_component_comments",fin,aid);
    }

    public static void verifyAidComponent(FinancialAidBean financialAidBean, String fin,String aid){
        String passMessage = String.format(LogPage.VERIFY_AID_COMPONENT_PASS,fin,aid);
        String failMessage = String.format(LogPage.VERIFY_AID_COMPONENT_FAIL,fin,aid);

        boolean aidComponentTypeValidation = false;
        boolean aidComponentRcvdValidation = false;
        boolean aidComponentRcvdDateValidation = false;
        boolean aidComponentReqdValidation = false;
        boolean aidComponentCommentsValidation = false;

        try {
            if(financialAidBean.getAidComponentType()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(fin,aid)));
                String aidComponentTypeText = getText(By.cssSelector(aidComponentTypeElement(fin,aid)));
                aidComponentTypeValidation = aidComponentTypeText.contains(financialAidBean.getAidComponentType());
            }else{
                aidComponentTypeValidation=true;
            }
            if(financialAidBean.getAidComponentRcvd()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(fin,aid)));
                String aidComponentRcvdText = getText(By.cssSelector(aidComponentReceivedElement(fin,aid)));
                aidComponentRcvdValidation = aidComponentRcvdText.contains(financialAidBean.getAidComponentRcvd());
            }else{
                aidComponentRcvdValidation=true;
            }
            if(financialAidBean.getAidComponentRcvdDate()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(fin,aid)));
                String aidComponentRcvdDateText = getAtribute(By.cssSelector(aidComponentReceivedDateField(fin,aid)),"value");
                aidComponentRcvdDateValidation = aidComponentRcvdDateText.contains(financialAidBean.getAidComponentRcvdDate());
            }else{
                aidComponentRcvdDateValidation=true;
            }
            if(financialAidBean.getAidComponentReqd()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(fin,aid)));
                String aidComponentReqdText = getText(By.cssSelector(aidComponentRequiredElement(fin,aid)));
                aidComponentReqdValidation = aidComponentReqdText.contains(financialAidBean.getAidComponentReqd());
            }else{
                aidComponentReqdValidation=true;
            }
            if(financialAidBean.getAidComponentComments()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(fin,aid)));
                String aidComponentCommentsText = getAtribute(By.cssSelector(aidComponentCommentsField(fin,aid)),"value");
                aidComponentCommentsValidation = aidComponentCommentsText.contains(financialAidBean.getAidComponentComments());
            }else{
                aidComponentCommentsValidation=true;
            }

            if(aidComponentTypeValidation
            && aidComponentRcvdValidation
            && aidComponentRcvdDateValidation
            && aidComponentReqdValidation
            && aidComponentCommentsValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateAidComponent(FinancialAidBean financialAidBean, String fin,String aid){
        String passMessage = String.format(LogPage.UPDATE_AID_COMPONENT_PASS,fin,aid);
        String failMessage = String.format(LogPage.UPDATE_AID_COMPONENT_FAIL,fin,aid);
        int updateAidComponentDelay=10;
        try {
            if(financialAidBean.getAidComponentType()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(fin,aid)));
                waitElementBy(By.cssSelector(aidComponentTypeElement(fin,aid)),updateAidComponentDelay);
                click(By.cssSelector(aidComponentTypeElement(fin,aid)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateAidComponentDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(financialAidBean.getAidComponentType());
            }
            if(financialAidBean.getAidComponentRcvd()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(fin,aid)));
                waitElementBy(By.cssSelector(aidComponentReceivedElement(fin,aid)),updateAidComponentDelay);
                click(By.cssSelector(aidComponentReceivedElement(fin,aid)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateAidComponentDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(financialAidBean.getAidComponentRcvd());
            }
            if(financialAidBean.getAidComponentRcvdDate()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(fin,aid)));
                waitElementBy(By.cssSelector(aidComponentReceivedDateField(fin,aid)),updateAidComponentDelay);
                KeyPage.erase(By.cssSelector(aidComponentReceivedDateField(fin,aid)));
                write(By.cssSelector(aidComponentReceivedDateField(fin,aid)),financialAidBean.getAidComponentRcvdDate());
                waitElementBy(By.cssSelector(aidComponentReceivedDateField(fin,aid)),updateAidComponentDelay);
                KeyPage.pressKey(By.cssSelector(aidComponentReceivedDateField(fin,aid)),"Enter");
            }
            if(financialAidBean.getAidComponentReqd()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(fin,aid)));
                waitElementBy(By.cssSelector(aidComponentRequiredElement(fin,aid)),updateAidComponentDelay);
                click(By.cssSelector(aidComponentRequiredElement(fin,aid)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateAidComponentDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(financialAidBean.getAidComponentReqd());
            }
            if(financialAidBean.getAidComponentComments()!=""){
                scrollToElement(By.cssSelector(financialAidPaymentPlusButton(fin,aid)));
                waitElementBy(By.cssSelector(aidComponentCommentsField(fin,aid)),updateAidComponentDelay);
                write(By.cssSelector(aidComponentCommentsField(fin,aid)),financialAidBean.getAidComponentComments());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }


}
