package config.hooks;

import config.browser_factory.DriverFactory;
import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void init(Scenario scenario) {

        ExtentReportsSetUp.startTestReport(scenario.getName());

    }

    @After
    public void finish() {

        DriverFactory.quitDriver();
    }
}
