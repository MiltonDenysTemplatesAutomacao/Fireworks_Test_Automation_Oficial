package pages.records.financialAid;

import bean.FinancialAidBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.*;

public class FinancialAidAwardComponentsPage extends BasePage {

    private static String awardAmountField(String fin,String awardComponent){
        return String.format("#person_financial_aid_%s_person_financial_aid_award_component_%s_award_amount",fin,awardComponent);
    }
    private static String awardCategoryElement(String fin,String awardComponent){
        return String.format("#s2id_person_financial_aid_%s_person_financial_aid_award_component_%s_award_category",fin,awardComponent);
    }
    private static String awardTypeElement(String fin,String awardComponent){
        return String.format("#s2id_person_financial_aid_%s_person_financial_aid_award_component_%s_award_type",fin,awardComponent);
    }
    private static String awardCommentsField(String fin,String awardComponent){
        return String.format("#person_financial_aid_%s_person_financial_aid_award_component_%s_award_comments",fin,awardComponent);
    }
    private static String awardComponentAddButton(String fin,String awardComponent){
        return String.format("#person_financial_aid_%s_person_financial_aid_award_component_%s_add",fin,awardComponent);
    }

    public static void addAwardComponent(String fin,String awardComponent){
        String passMessage = String.format(LogPage.ADD_AWARD_COMPONENT_PASS,fin,awardComponent);
        String failMessage = String.format(LogPage.ADD_AWARD_COMPONENT_FAIL,fin,awardComponent);
        try {
            MainPage.addDeleteWithPlusButton(By.cssSelector(awardComponentAddButton(fin,awardComponent)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyAwardComponent(FinancialAidBean financialAidBean, String fin, String awardComponent){
        String passMessage = String.format(LogPage.VERIFY_AWARD_COMPONENT_PASS,fin,awardComponent);
        String failMessage = String.format(LogPage.VERIFY_AWARD_COMPONENT_FAIL,fin,awardComponent);

        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(awardAmountField(fin,awardComponent)),financialAidBean.getAwardComponentAmount())
                    && MainPage.verifyGetText(By.cssSelector(awardCategoryElement(fin,awardComponent)),financialAidBean.getAwardComponentCategory())
                    && MainPage.verifyGetText(By.cssSelector(awardTypeElement(fin,awardComponent)),financialAidBean.getAwardComponentType())
                    && MainPage.verifyGetAttribute(By.cssSelector(awardCommentsField(fin,awardComponent)),financialAidBean.getAwardComponentComments())){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateAwardComponent(FinancialAidBean financialAidBean, String fin, String awardComponent){
        String passMessage = String.format(LogPage.UPDATE_AWARD_COMPONENT_PASS,fin,awardComponent);
        String failMessage = String.format(LogPage.UPDATE_AWARD_COMPONENT_FAIL,fin,awardComponent);
        try {
            if(financialAidBean.getAwardComponentAmount()!=""){
                MainPage.fillField(By.cssSelector(awardAmountField(fin,awardComponent)), financialAidBean.getAwardComponentAmount());
            }
            if(financialAidBean.getAwardComponentCategory()!=""){
                MainPage.clickOptionList(By.cssSelector(awardCategoryElement(fin,awardComponent)),
                        financialAidBean.getAwardComponentCategory(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(financialAidBean.getAwardComponentType()!=""){
                MainPage.clickOptionList(By.cssSelector(awardTypeElement(fin,awardComponent)),
                        financialAidBean.getAwardComponentType(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(financialAidBean.getAwardComponentComments()!=""){
                MainPage.fillField(By.cssSelector(awardCommentsField(fin,awardComponent)), financialAidBean.getAwardComponentComments());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
