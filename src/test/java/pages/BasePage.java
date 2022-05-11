package pages;

import config.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
        return DriverBase.getDriver().findElement(by).isDisplayed();
    }
    /*
     * Method to check if a checkbox is active
     */
    public static boolean checkBoxIsActive(By by) throws Exception {
        return DriverBase.getDriver().findElement(by).isSelected();
    }
    /*
     * Method to check if a checkbox is not active
     */
    public static boolean checkBoxIsNotActive(By by) throws Exception {
        return DriverBase.getDriver().findElement(by).isSelected();
    }

    /*
     * Method to check if an element is enabled
     */
    public static boolean checkIfElementIsEnabled(By by) throws Exception {
        return DriverBase.getDriver().findElement(by).isEnabled();
    }

    /*
     * Method to save elements in a list
     */
    public static List<WebElement> findElements(By by) throws Exception {
        return DriverBase.getDriver().findElements(by);
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
        return table.findElements(By.tagName(tag));
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
     ***********
     * @return*/

    /*
     * Method to get current date time from America/New_York
     */
    public static String currentDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a");
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/New_York"));
        return dtf.format(now);
    }

    /*
     * Method to validate if a message contains the correct
     */
    public static boolean alertMessageContains(By by, String message) throws Exception {
        boolean alertMessage = false;
        String fullNameReturn = BasePage.getText(by);
        if (fullNameReturn.contains(message)) {
            alertMessage = true;
        }
        return alertMessage;
    }

    /*
     * Method to validate if a message is equals to the correct
     */
    public static boolean alertMessageEquals(By by,String id, String message) throws Exception {
        boolean alertMessage = false;
        String fullNameReturn = BasePage.getText(by);
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
