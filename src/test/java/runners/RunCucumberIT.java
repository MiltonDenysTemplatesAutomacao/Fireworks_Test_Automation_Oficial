package runners;

import config.extent_reports.ExtentReportsSetUp;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberIT {

    @BeforeClass
    public static void initAll() {
        //ExtentReportsSetUp.initializeReport();
    }
    @AfterClass
    public static void finishAll() {
        ExtentReportsSetUp.endTestReport();
    }
}
