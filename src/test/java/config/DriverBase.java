package config;

import config.browser_factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverBase {

    protected static final Logger LOG = (Logger) LogManager.getLogger(DriverBase.class);
    private static final List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverFactoryThread;

    public static void instantiateDriverObject() {
        LOG.warn("Testing before Suite");
        driverFactoryThread = ThreadLocal.withInitial(() -> {
            DriverFactory driverFactory = new DriverFactory();
            webDriverThreadPool.add(driverFactory);
            return driverFactory;
        });
    }

    public static RemoteWebDriver getDriver() throws Exception {
        return driverFactoryThread.get().getDriver();
    }

    public static void clearCookies() {
        try {
            driverFactoryThread.get().getStoredDriver().manage().deleteAllCookies();
        } catch (Exception ignored) {
            LOG.warn("Unable to clear cookies, driver object is not viable...");
        }
    }

    public static void closeDriverObjects() {
        for (DriverFactory driverFactory : webDriverThreadPool) {
            driverFactory.quitDriver();
        }
    }
}
