package config.hooks;

import config.DriverBase;
import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Hooks extends DriverBase {
    private RemoteWebDriver driver;

    @BeforeAll
    public static void setUp(){
        ExtentReportsSetUp.initializeReport();
    }

    @Before
    public void beforeSuite(Scenario scenario) throws Exception {
        ExtentReportsSetUp.startTestReport(scenario.getName());
        Dotenv dotenv = Dotenv.configure().load();
        instantiateDriverObject();
        driver = getDriver();
        String url = dotenv.get("APP_URL");
        driver.get(url);
    }
    @After
    public void afterSuite() {
        clearCookies();
        closeDriverObjects();
    }
    @AfterAll
    public static void tearDown(){
        closeDriverObjects();
        ExtentReportsSetUp.endTestReport();
    }
}
