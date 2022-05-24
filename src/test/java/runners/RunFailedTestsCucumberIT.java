package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@failed_scenarios/failed_scenarios.txt",
        glue = {"steps","config.hooks"},//the path of the step definition files
        plugin = {"rerun:failed_scenarios/failed_scenarios.txt"},//to generate different types of reporting
        dryRun = false,//to check the mapping is proper between feature file and step def file
        monochrome = true //display the console output in a proper readable format
)
//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("failed_scenarios/failed_scenarios.txt")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "rerun:failed_scenarios/failed_scenarios.txt")

public class RunFailedTestsCucumberIT {

}
