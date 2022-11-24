package runners;

import config.DriverBase;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource(".")
//@ConfigurationParameter(key = PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME, value = "true")
@IncludeTags("0210QuickAdd_CreatePersonOnlyEmailAddressCept")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "rerun:failed_scenarios/failed_scenarios.txt")
public class RunCucumberIT {

    @BeforeAll
    public static void init(){
        DriverBase.instantiateDriverObject();
    }
    @After
    public static void beforeSuite(){
        DriverBase.clearCookies();
    }
    @AfterAll
    public static void finish(){
        DriverBase.closeDriverObjects();
    }
}
