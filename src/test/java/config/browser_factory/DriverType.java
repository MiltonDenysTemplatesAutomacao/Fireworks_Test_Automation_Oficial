package config.browser_factory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;

public enum DriverType implements DriverSetup {

    CHROME {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
            HashMap<String, Object> chromePreferences = new HashMap<>();
            chromePreferences.put("profile.password_manager_enabled", false);
            System.setProperty("webdriver.chrome.driver", "target/test-classes/selenium_standalone_binaries/windows/googlechrome/64bit/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.merge(capabilities);
            options.setHeadless(HEADLESS);
            options.addArguments("--no-default-browser-check");
            options.addArguments("start-maximized");
            options.setExperimentalOption("prefs", chromePreferences);
            return new ChromeDriver(options);
        }
    };
    public final static boolean HEADLESS = Boolean.getBoolean("headless");

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
