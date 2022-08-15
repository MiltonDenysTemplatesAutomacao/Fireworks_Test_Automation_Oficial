package pages.records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class ImportsPage extends BasePage {


    private static final String IMPORTS_MANAGER_TABLE_STATUS_COLUMN = "importManagerTable_row_0_col_5";
    private static final String IMPORTS_MANAGER_SEARCH_FIELD = "#importManagerTableControlsTableSearch";

    public static void searchImportManager(String packageName){
        String passMessage = String.format(LogPage.SEARCH_IMPORT_MANAGER_PASS,packageName);
        String failMessage = String.format(LogPage.SEARCH_IMPORT_MANAGER_FAIL,packageName);
        try {
            waitElementBy(By.cssSelector(IMPORTS_MANAGER_SEARCH_FIELD),10);
            scrollToTheTop();
            write(By.cssSelector(IMPORTS_MANAGER_SEARCH_FIELD),packageName);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void waitUntilImportConcludes(String status,String packageName){
        int counter = 1;
        String passMessage = String.format(LogPage.WAIT_UNTIL_IMPORT_CONCLUDES_PASS,status,packageName);
        String failMessage = String.format(LogPage.WAIT_UNTIL_IMPORT_CONCLUDES_FAIL,status,packageName);
        try {
            waitElementBy(By.id(IMPORTS_MANAGER_TABLE_STATUS_COLUMN),10);
            String text = getText(By.id(IMPORTS_MANAGER_TABLE_STATUS_COLUMN));
            while(text!=status && counter < 10){
                refreshPage();
                searchImportManager(packageName);
                counter++;
            }
            if(text.equals(status)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
