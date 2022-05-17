package pages;

import config.DriverBase;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class KeyPage extends BasePage{
    public static final String ENTER = "\ue007";
    public static final String CONTROL = "\ue009";
    public static final String DELETE = "\ue017";

    public static String keyList(String key) {
        Map<String, String> keyReturn = new HashMap<String, String>();
        keyReturn.put("Enter", ENTER);
        keyReturn.put("Control", CONTROL);
        keyReturn.put("Delete", DELETE);
        return keyReturn.get(key);
    }
    public static void pressKey(By by, String key) throws Exception{
        DriverBase.getDriver().findElement(by).sendKeys(keyList(key));
    }
    public static void erase(By by)throws Exception{
        DriverBase.getDriver().findElement(by).sendKeys(keyList("Control")+"a");
        DriverBase.getDriver().findElement(by).sendKeys(keyList("Delete"));

    }
}
