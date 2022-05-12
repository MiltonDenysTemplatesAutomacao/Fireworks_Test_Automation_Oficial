package pages;

import java.util.HashMap;
import java.util.Map;

public class KeyPage {
    public static final String ENTER = "u\ue007";

    public static String keyList(String section) {
        Map<String, String> keyReturn = new HashMap<String, String>();
        keyReturn.put("Enter", ENTER);
        return keyReturn.get(section);
    }

    public static void sendKey(String key){


    }
}
