package pages.records.financialAid;

import bean.FinancialAidInterestBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.PersonPage;
import pages.MainPage;
public class FinancialAidInterestsPage extends BasePage {


    private static String financialAidInterestsPlusButton(String group){
        return String.format("#person_financial_aid_interest_%s_add",group);
    }
    private static String aidInterestCategoryDropdownLocator(String group){
        return String.format("#s2id_person_financial_aid_interest_%s_aid_interest_category",group);
    }
    private static String aidInterestTypeDropdownLocator(String group){
        return String.format("#s2id_person_financial_aid_interest_%s_aid_interest_type",group);
    }
    private static String expressedInterestDropdownLocator(String group){
        return String.format("#s2id_person_financial_aid_interest_%s_aid_expressed_interest",group);
    }
    private static String expressedInterestDateField(String group){
        return String.format("#person_financial_aid_interest_%s_aid_expressed_interest_date",group);
    }

    public static void verifyFinancialAidInterest(FinancialAidInterestBean financialAidInterestBean,String group){
        String passMessage = String.format(LogPage.VERIFY_FINANCIAL_AID_INTEREST_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_FINANCIAL_AID_INTEREST_FAIL,group);
        try {
            if(MainPage.verifyGetText(By.cssSelector(aidInterestCategoryDropdownLocator(group)),financialAidInterestBean.getAidInterestCategory())
                    && MainPage.verifyGetText(By.cssSelector(aidInterestTypeDropdownLocator(group)),financialAidInterestBean.getAidInterestType())
                    && MainPage.verifyGetText(By.cssSelector(expressedInterestDropdownLocator(group)),financialAidInterestBean.getExpressedInterest())
                    && MainPage.verifyGetAttribute(By.cssSelector(expressedInterestDateField(group)),financialAidInterestBean.getExpressedInterestDate())){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateFinancialAidInterest(FinancialAidInterestBean financialAidInterestBean,String group){

        String passMessage = String.format(LogPage.UPDATE_FINANCIAL_AID_INTEREST_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_FINANCIAL_AID_INTEREST_FAIL,group);
        try {
            if(financialAidInterestBean.getAidInterestCategory()!=""){
                MainPage.clickOptionList(By.cssSelector(aidInterestCategoryDropdownLocator(group)),
                        financialAidInterestBean.getAidInterestCategory(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(financialAidInterestBean.getAidInterestType()!=""){
                MainPage.clickOptionList(By.cssSelector(aidInterestTypeDropdownLocator(group)),
                        financialAidInterestBean.getAidInterestType(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(financialAidInterestBean.getExpressedInterest()!=""){
                MainPage.clickOptionList(By.cssSelector(expressedInterestDropdownLocator(group)),
                        financialAidInterestBean.getExpressedInterest(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(financialAidInterestBean.getExpressedInterestDate()!=""){
                MainPage.fillDateField(By.cssSelector(expressedInterestDateField(group)), financialAidInterestBean.getExpressedInterestDate());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
