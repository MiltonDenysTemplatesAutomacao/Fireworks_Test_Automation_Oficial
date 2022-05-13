package pages;

import config.DriverBase;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class KeyPage extends BasePage{
    public static final String ENTER = "\ue007";

    public static String keyList(String key) {
        Map<String, String> keyReturn = new HashMap<String, String>();
        keyReturn.put("Enter", ENTER);
        return keyReturn.get(key);
    }

    public static void pressKey(By by, String key) throws Exception{
        DriverBase.getDriver().findElement(by).sendKeys(keyList(key));
    }
}
