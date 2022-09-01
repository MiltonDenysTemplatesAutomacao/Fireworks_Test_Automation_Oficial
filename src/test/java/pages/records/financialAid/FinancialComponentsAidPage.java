package pages.records.financialAid;

import bean.FinancialAidBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.PersonPage;
import pages.MainPage;

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
        try {
            if(MainPage.verifyGetText(By.cssSelector(aidComponentTypeElement(fin,aid)),financialAidBean.getAidComponentType())
                    && MainPage.verifyGetText(By.cssSelector(aidComponentReceivedElement(fin,aid)),financialAidBean.getAidComponentRcvd())
                    && MainPage.verifyGetAttribute(By.cssSelector(aidComponentReceivedDateField(fin,aid)),financialAidBean.getAidComponentRcvdDate())
                    && MainPage.verifyGetText(By.cssSelector(aidComponentRequiredElement(fin,aid)),financialAidBean.getAidComponentReqd())
                    && MainPage.verifyGetAttribute(By.cssSelector(aidComponentCommentsField(fin,aid)),financialAidBean.getAidComponentComments())
            ){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        }catch (Exception e){
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateAidComponent(FinancialAidBean financialAidBean, String fin,String aid){
        String passMessage = String.format(LogPage.UPDATE_AID_COMPONENT_PASS,fin,aid);
        String failMessage = String.format(LogPage.UPDATE_AID_COMPONENT_FAIL,fin,aid);
        try {
            if(financialAidBean.getAidComponentType()!=""){
                MainPage.clickOptionList(By.cssSelector(aidComponentTypeElement(fin,aid)),
                        financialAidBean.getAidComponentType(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(financialAidBean.getAidComponentRcvd()!=""){
                MainPage.clickOptionList(By.cssSelector(aidComponentReceivedElement(fin,aid)),
                        financialAidBean.getAidComponentRcvd(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(financialAidBean.getAidComponentRcvdDate()!=""){
                MainPage.fillDateField(By.cssSelector(aidComponentReceivedDateField(fin,aid)),financialAidBean.getAidComponentRcvdDate());
            }
            if(financialAidBean.getAidComponentReqd()!=""){
                MainPage.clickOptionList(By.cssSelector(aidComponentRequiredElement(fin,aid)),
                        financialAidBean.getAidComponentReqd(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(financialAidBean.getAidComponentComments()!=""){
                MainPage.fillField(By.cssSelector(aidComponentCommentsField(fin,aid)),financialAidBean.getAidComponentComments());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
