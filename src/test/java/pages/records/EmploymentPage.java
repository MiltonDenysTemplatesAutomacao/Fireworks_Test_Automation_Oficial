package pages.records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;

public class EmploymentPage extends BasePage {

    private static String paymentTypeDropdown(String index){
        return String.format("#person_employment_%s_employment_position",index);
    }
    private static String employmentStartDate(String index){
        return String.format("#person_employment_%s_employment_start_date",index);
    }
    private static String employmentEndDate(String index){
        return String.format("#person_employment_%s_employment_end_date",index);
    }
    private static String employmentDuties(String index){
        return String.format("#person_employment_%s_employment_duties",index);
    }
    private static String employmentComments(String index){
        return String.format("#person_employment_%s_employment_comments",index);
    }

    public static void updateEmployment(String position,String startDate,String endDate,String duties,String comments,String group){
        String passMessage = String.format(LogPage.UPDATE_EMPLOYMENT_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_EMPLOYMENT_FAIL,group);
        try {
            if(position!=""){
                MainPage.fillField(By.cssSelector(paymentTypeDropdown(group)),position);
            }
            if(startDate!=""){
                MainPage.fillDateField(By.cssSelector(employmentStartDate(group)),startDate);
            }
            if(endDate!=""){
                MainPage.fillDateField(By.cssSelector(employmentEndDate(group)),endDate);
            }
            if(duties!=""){
                MainPage.fillField(By.cssSelector(employmentDuties(group)),duties);
            }
            if(comments!=""){
                MainPage.fillField(By.cssSelector(employmentComments(group)),comments);
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
