package config.extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import config.DriverBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;

public class ExtentReportsSetUp {
    static ExtentTest test;
    public static ExtentReports extent;
    static int imgNumber = 1;
    public static String filePath = System.getProperty("user.dir") + File.separator + "output";

    /*
     * Method to initialize report
     */
    public static void initializeReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(filePath + File.separator + "index.html");
        spark.config(ExtentSparkReporterConfig.builder().theme(Theme.DARK).documentTitle("Fire-Engine-Red-Test-Results")
                .reportName("Milton").build());
        extent.attachReporter(spark);
    }

    /*
     * Method to start test report
     */
    public static void startTestReport(String scenario) {
            test = extent.createTest(scenario, "Description");
    }

    /*
     * Method to pass a test and send a message
     */
    public static void testingPass(String message) {
        test.pass(message);
    }

    /*
     * Method get a full page screenshot send to a folder and then send to report
     * html page
     */
    public static void fullPageScreenShoot() throws Exception {

        JavascriptExecutor executor = (JavascriptExecutor) DriverBase.getDriver();
        executor.executeScript("document.body.style.zoom = '45%'");

        Screenshot screenshot = new AShot().takeScreenshot(DriverBase.getDriver());
        ImageIO.write(screenshot.getImage(), "PNG", new File(filePath + File.separator + imgNumber + ".png"));

    }

    /*
     * Method get a simple screenshot send to a folder and then send to report html
     * page
     */
    public static void takeScreenShot() throws Exception {
        File file = ((TakesScreenshot) DriverBase.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(filePath + File.separator + imgNumber + ".png"));
    }

    /*
     * Method to fail a test, send a message and take a screenshot
     */
    public static void testingFail(String message){
        try {
            fullPageScreenShoot();
            test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(imgNumber + ".png").build());
            imgNumber++;
        } catch (Exception e) {
            System.err.println("Error while trying to take a screenshot");
        }
    }

    /*
     * Method to end test report
     */
    public static void endTestReport() {

        extent.flush();

    }
}
