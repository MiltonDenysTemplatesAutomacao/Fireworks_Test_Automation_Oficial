package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.junit.Assert;

public class FailureDelegatePage {
    public static void handlePageException(String errorMessage){
        fail(errorMessage);
        Assert.assertFalse(true);
    }
    public static void fail(String errorMessage){
        ExtentReportsSetUp.testingFail(errorMessage);
        System.err.println(errorMessage);
    }
}
