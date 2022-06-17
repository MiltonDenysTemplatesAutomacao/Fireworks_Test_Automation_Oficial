package pages.Records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class PersonContactAddressPage extends BasePage{

    private static String emailAddressAddButton(String index){
        return String.format("#entity_address_%s_add",index);
    }
    private static String address1Field(String index){
        return String.format("#entity_address_%s_address_1",index);
    }
    private static String address2Field(String index){
        return String.format("#entity_address_%s_address_2",index);
    }
    private static String address3Field(String index){
        return String.format("#entity_address_%s_address_3",index);
    }
    private static String address4Field(String index){
        return String.format("#entity_address_%s_address_4",index);
    }
    private static String addressCityField(String index){
        return String.format("#entity_address_%s_address_city",index);
    }
    private static String addressStateElement(String index){
        return String.format("#entity_address_%s_address_state_component",index);
    }
    private static String addressStateElementList(String index){
        return String.format("#entity_address_%s_address_state_dropdown_menu",index);
    }
    private static String addressStateSearch(String index){
        return String.format("#entity_address_%s_address_state_search",index);
    }

    private static String addressRegionField(String index){
        return String.format("#entity_address_%s_address_region",index);
    }
    private static String addressCountryElement(String index){
        return String.format("#entity_address_%s_address_country_component",index);
    }
    private static String addressCountryElementList(String index){
        return String.format("#entity_address_%s_address_country_dropdown_menu",index);
    }
    private static String addressPostalCodeField(String index){
        return String.format("#entity_address_%s_address_postal_code",index);
    }
    private static String addressTypeElement(String index){
        return String.format("#entity_address_%s_address_type_component",index);
    }
    private static String addressTypeElementList(String index){
        return String.format("#entity_address_%s_address_type_dropdown_menu",index);
    }
    private static String addressNeighborhoodElement(String index){
        return String.format("#entity_address_%s_address_neighborhood_component",index);
    }
    private static String addressNeighborhoodElementList(String index){
        return String.format("#entity_address_%s_address_neighborhood_dropdown_menu",index);
    }
    private static String addressCommentsField(String index){
        return String.format("#entity_address_%s_address_comments",index);
    }
    private static String addressActiveCheckbox(String index){
        return String.format("#entity_address_%s_active",index);
    }
    private static String addressPrimaryCheckbox(String index){
        return String.format("#entity_address_%s_primary",index);
    }

    public static void createAddress(String address1,String address2,String address3,String address4,String city,String state,String region,String country,String postalCode,String addressType,String educationNeighborhood,String addressComments,String active,String primary, String group){
        int createAddressDelay = 20;
        try {
            if(address1!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(address1Field(group)),createAddressDelay);
                write(By.cssSelector(address1Field(group)),address1);

            }
            if(address2!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(address2Field(group)),createAddressDelay);
                write(By.cssSelector(address1Field(group)),address2);
            }
            if(address3!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(address1Field(group)),createAddressDelay);
                write(By.cssSelector(address3Field(group)),address3);
            }
            if(address4!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(address4Field(group)),createAddressDelay);
                write(By.cssSelector(address1Field(group)),address4);
            }
            if(city!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(addressCityField(group)),createAddressDelay);
                write(By.cssSelector(addressCityField(group)),city);
            }
            if(state!=""){
                scrollToElement(By.cssSelector(addressCityField(group)));
                waitElementBy(By.cssSelector(addressStateElement(group)),createAddressDelay);
                BasePage.click(By.cssSelector(addressStateElement(group)));
                waitElementBy(By.cssSelector(addressStateElementList(group)),createAddressDelay);
                write(By.cssSelector(addressStateSearch(group)),state);
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(addressStateElementList(group)), "a");
                clickOnListOfElements(state);
                wait(1000);
            }
            if(region!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(addressRegionField(group)),createAddressDelay);
                write(By.cssSelector(addressRegionField(group)),region);
            }
            if(country!=""){
                scrollToElement(By.cssSelector(addressCityField(group)));
                waitElementBy(By.cssSelector(addressCountryElement(group)),createAddressDelay);
                BasePage.click(By.cssSelector(addressCountryElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(addressCountryElementList(group)), "a");
                clickOnListOfElements(country);
                wait(1000);
            }
            if(postalCode!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(addressPostalCodeField(group)),createAddressDelay);
                write(By.cssSelector(addressPostalCodeField(group)),postalCode);
            }
            if(addressType!=""){
                scrollToElement(By.cssSelector(addressStateElement(group)));
                waitElementBy(By.cssSelector(addressTypeElement(group)),createAddressDelay);
                BasePage.click(By.cssSelector(addressTypeElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(addressTypeElementList(group)), "a");
                clickOnListOfElements(addressType);
                wait(1000);
            }
            if(educationNeighborhood!=""){
                scrollToElement(By.cssSelector(addressStateElement(group)));
                waitElementBy(By.cssSelector(addressNeighborhoodElement(group)),createAddressDelay);
                BasePage.click(By.cssSelector(addressNeighborhoodElement(group)));
                waitElementBy(By.cssSelector(addressNeighborhoodElementList(group)),createAddressDelay);
                BasePage.selectElementsList(By.cssSelector(addressNeighborhoodElementList(group)), "a");
                clickOnListOfElements(educationNeighborhood);
                wait(1000);
            }
            if(addressComments!=""){
                scrollToElement(By.cssSelector(addressCommentsField(group)));
                waitElementBy(By.cssSelector(addressCommentsField(group)),createAddressDelay);
                write(By.cssSelector(addressCommentsField(group)),addressComments);
            }
            if(active!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(addressActiveCheckbox(group)),createAddressDelay);
                click(By.cssSelector(addressActiveCheckbox(group)));
            }
            if(primary!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(addressPrimaryCheckbox(group)),createAddressDelay);
                click(By.cssSelector(addressPrimaryCheckbox(group)));
            }
            ExtentReportsSetUp.testingPass(LogPage.CREATE_ADDRESS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_ADDRESS_FAIL);
        }
    }

}
