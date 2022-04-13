package pages;

import config.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class BasePage {

    /********* Used for Automation ************/
    protected static List<Map<String, String>> mass;
    protected static List<WebElement> listOfElements;

    /********* Utils ************/

//    public static void openHomePage() throws Exception {
//        Dotenv dotenv = Dotenv.load();
//        DriverBase.getDriver().get(dotenv.get("APP_URL"));
//
//    }
    /*
     * Method to check if an element is visible
     */
    public static boolean checkIfElementIsVisible(By by) throws Exception {
        boolean display = DriverBase.getDriver().findElement(by).isDisplayed();
        return display;
    }

    /*
     * Method to check if an element is enabled
     */
    public static boolean checkIfElementIsEnabled(By by) throws Exception {
        boolean display = DriverBase.getDriver().findElement(by).isEnabled();
        return display;
    }

    /*
     * Method to save elements in a list
     */
    public static List<WebElement> findElements(By by) throws Exception {
        List<WebElement> elements = DriverBase.getDriver().findElements(by);
        return elements;

    }

    /*
     * Method to clear fields
     */
    public static void clearField(By by) throws Exception {
        DriverBase.getDriver().findElement(by).clear();
    }

    /*
     * Method to list elements in a list by css and tag
     */
    public static List<WebElement> elementsList(By by, String tag) throws Exception {

        WebElement table = DriverBase.getDriver().findElement(by);
        List<WebElement> rowsTable = table.findElements(By.tagName(tag));
        return rowsTable;
    }

    /*
     * Method to select an element from a list by css and tag
     */
    public static void selectElementsList(By by, String tag) throws Exception {
        listOfElements = elementsList(by, tag);
    }

    /*
     * Method click on an element from a list by css and tag
     */
    public static void clickOnListOfElements(String value) throws Exception {
        for (int i = 0; i < listOfElements.size(); i++) {
            if (listOfElements.get(i).getText().equals(value)) {
                System.out.println(listOfElements.get(i).getText());
                listOfElements.get(i).click();
                break;
            }
        }

    }

    /********* write ************/

    public static void write(By by, String text) throws Exception {
        DriverBase.getDriver().findElement(by).clear();
        DriverBase.getDriver().findElement(by).sendKeys(text);
    }

    public static void write(String id_campo, String text) throws Exception {
        write(By.id(id_campo), text);
    }

    /********* Click ************/

    public static void click(By by) throws Exception {
        DriverBase.getDriver().findElement(by).click();
    }

    /********* Texts ************/

    public static String getText(By by) throws Exception {
        return DriverBase.getDriver().findElement(by).getText();
    }

    public static String getAtribute(By by, String value) throws Exception {
        return DriverBase.getDriver().findElement(by).getAttribute(value);
    }

    /*
     * Method replace a String
     */
    public static String replaceString(String name, String from, String to) {
        String text = name;
        return name.replace(from, to);
    }

    /*********
     * Miscellaneous
     *
     * @throws Exception
     ************/

    /*
     * Method to validate if a message contains the correct value by id
     */
    public static boolean alertMessageByIdContains(String id, String message) throws Exception {
        boolean alertMessage = false;
        String fullNameReturn = BasePage.getText(By.id(id));
        if (fullNameReturn.contains(message)) {
            alertMessage = true;
        }
        return alertMessage;
    }

    /*
     * Method to validate if a message is equals to the correct value by id
     */
    public static boolean alertMessageByidEquals(String id, String message) throws Exception {
        boolean alertMessage = false;
        String fullNameReturn = BasePage.getText(By.id(id));
        if (fullNameReturn.equals(message)) {
            alertMessage = true;
        }
        return alertMessage;
    }

    /*
     * Method to wait until a specific element by id appears
     */
    public static void waitElementBy(By by, int time) throws Exception {
        WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitUntilElementPresence(By by, int time) throws Exception {
        WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitUntilElementToBeSelected(By by, int time) throws Exception {
        WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static int wait(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (Exception e) {
            System.err.println("Fail while trying to use wait method");
        }
        return miliseconds;
    }

    /*
     * Method to scroll until element is visible
     */
    public static void scrollToElement(By by) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) DriverBase.getDriver();
        WebElement element = DriverBase.getDriver().findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
