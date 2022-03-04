package pages;

import org.openqa.selenium.By;

public class StaffPage extends BasePage{
    public static String recordNavTabContact = "recordNavTab_contact";

    public static void navigateToContact(){

        try {
            BasePage.click(By.id(recordNavTabContact));

        } catch (Exception e) {
        }
    }
    public static void updatePhoneNumber(){

        try {

        } catch (Exception e) {
        }
    }

}
