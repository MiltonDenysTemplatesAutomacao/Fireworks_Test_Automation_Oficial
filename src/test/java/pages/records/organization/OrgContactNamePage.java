package pages.records.organization;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;

public class OrgContactNamePage extends BasePage {

    public static final String ORG_NAME_FIELD = "#org_name_0_org_name_formal";
    public static final String ORG_NAME_FIELD_1 = "#org_name_1_org_name_formal";
    public static final String ORG_INFORMAL_NAME_FIELD_1 = "#org_name_1_org_name_informal";
    public static final String ORG_INFORMAL_NAME_FIELD = "#org_name_0_org_name_informal";

    public static void verifyOrgNameIs1to1(){
        try {

            if(!verifyIfElementsIsVisible(By.cssSelector(ORG_NAME_FIELD_1))
                    && !verifyIfElementsIsVisible(By.cssSelector(ORG_INFORMAL_NAME_FIELD_1))){
                    ExtentReportsSetUp.testingPass(LogPage.VERIFY_ORG_NAME_IS_1TO1_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_ORG_NAME_IS_1TO1_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_ORG_NAME_IS_1TO1_FAIL);
        }
    }

    public static void verifyContactOrganizationName(String name){
        String passMessage = String.format(LogPage.VERIFY_CONTACT_ORGANIZATION_NAME_PASS,name);
        String failMessage = String.format(LogPage.VERIFY_CONTACT_ORGANIZATION_NAME_FAIL,name);
        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(ORG_NAME_FIELD),name)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
