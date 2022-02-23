package config.hooks;

import config.DriverBase;
import config.browser_factory.DriverFactory;
import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Hooks extends DriverBase {
    private RemoteWebDriver driver;

    @Before
    public void init(Scenario scenario) throws Exception {
        ExtentReportsSetUp.initializeReport();
        ExtentReportsSetUp.startTestReport(scenario.getName());
        instantiateDriverObject();
        driver = getDriver();
        String url = System.getenv("APP_URL");
        driver.get(url);

    }

    @After
    public void finish() {

        closeDriverObjects();
    }
}
