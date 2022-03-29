package pages.Records;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonBasicPage extends BasePage{
    public static final String basicPanelHeadingElement = "#basic span";
    public static final String basicSectionHeaderElement = "#basic p";
    public static final String basicFieldLabelElement = "#basic label.control-label";

    public static final String birth = "//*[@data-field-group-label='Birth']";

    /*
     * section return list
     */
    //work here
    public static String returnBasicSection(String section){
        Map<String, String> basicSection = new HashMap<String, String>();
        basicSection.put("birth",birth);
        return basicSection.get(section);
    }
    //work here

    public static void verifyPersonBasicFieldLabels(){
        try {
            BasePage.waitElementBy(By.cssSelector(basicPanelHeadingElement),20);
            String test = returnBasicSection(mass.get(0).get("birth"));
            System.out.println(test);
        }catch (Exception e){

        }
    }
}
