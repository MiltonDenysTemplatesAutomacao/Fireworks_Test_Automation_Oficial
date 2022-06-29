package pages.Records;

import bean.AddressBean;
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

    public static void addAddress(String group){
        try {
            scrollToElement(By.cssSelector(emailAddressAddButton(group)));
            scrollTo("-100");
            waitUntilElementToBeSelected(By.cssSelector(emailAddressAddButton(group)),20);
            click(By.cssSelector(emailAddressAddButton(group)));
            ExtentReportsSetUp.testingPass(LogPage.ADD_ADDRESS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ADD_ADDRESS_FAIL);
        }
    }

    public static void createAddress(AddressBean address, String group){
        int createAddressDelay = 20;

        try {
            if(address.getAddress1()!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(address1Field(group)),createAddressDelay);
                write(By.cssSelector(address1Field(group)),address.getAddress1());

            }
            if(address.getAddress2()!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(address2Field(group)),createAddressDelay);
                write(By.cssSelector(address1Field(group)),address.getAddress2());
            }
            if(address.getAddress3()!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(address1Field(group)),createAddressDelay);
                write(By.cssSelector(address3Field(group)),address.getAddress3());
            }
            if(address.getAddress4()!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(address4Field(group)),createAddressDelay);
                write(By.cssSelector(address1Field(group)),address.getAddress4());
            }
            if(address.getCity()!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(addressCityField(group)),createAddressDelay);
                write(By.cssSelector(addressCityField(group)),address.getCity());
            }
            if(address.getState()!=""){
                scrollToElement(By.cssSelector(addressCityField(group)));
                waitElementBy(By.cssSelector(addressStateElement(group)),createAddressDelay);
                BasePage.click(By.cssSelector(addressStateElement(group)));
                waitElementBy(By.cssSelector(addressStateElementList(group)),createAddressDelay);
                write(By.cssSelector(addressStateSearch(group)),address.getState());
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(addressStateElementList(group)), "a");
                clickOnListOfElements(address.getState());
                wait(1000);
            }
            if(address.getRegion()!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(addressRegionField(group)),createAddressDelay);
                write(By.cssSelector(addressRegionField(group)),address.getRegion());
            }
            if(address.getCountry()!=""){
                scrollToElement(By.cssSelector(addressCityField(group)));
                waitElementBy(By.cssSelector(addressCountryElement(group)),createAddressDelay);
                BasePage.click(By.cssSelector(addressCountryElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(addressCountryElementList(group)), "a");
                clickOnListOfElements(address.getCountry());
                wait(1000);
            }
            if(address.getPostalCode()!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(addressPostalCodeField(group)),createAddressDelay);
                write(By.cssSelector(addressPostalCodeField(group)),address.getPostalCode());
            }
            if(address.getAddressType()!=""){
                scrollToElement(By.cssSelector(addressStateElement(group)));
                waitElementBy(By.cssSelector(addressTypeElement(group)),createAddressDelay);
                BasePage.click(By.cssSelector(addressTypeElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(addressTypeElementList(group)), "a");
                clickOnListOfElements(address.getAddressType());
                wait(1000);
            }
            if(address.getEducationNeighborhood()!=""){
                scrollToElement(By.cssSelector(addressStateElement(group)));
                waitElementBy(By.cssSelector(addressNeighborhoodElement(group)),createAddressDelay);
                BasePage.click(By.cssSelector(addressNeighborhoodElement(group)));
                waitElementBy(By.cssSelector(addressNeighborhoodElementList(group)),createAddressDelay);
                BasePage.selectElementsList(By.cssSelector(addressNeighborhoodElementList(group)), "a");
                clickOnListOfElements(address.getEducationNeighborhood());
                wait(1000);
            }
            if(address.getAddressComments()!=""){
                scrollToElement(By.cssSelector(addressCommentsField(group)));
                waitElementBy(By.cssSelector(addressCommentsField(group)),createAddressDelay);
                write(By.cssSelector(addressCommentsField(group)),address.getAddressComments());
            }
            if(address.getActive()!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                click(By.cssSelector(addressActiveCheckbox(group)));
            }
            if(address.getPrimary()!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                click(By.cssSelector(addressPrimaryCheckbox(group)));
            }
            ExtentReportsSetUp.testingPass(LogPage.CREATE_ADDRESS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_ADDRESS_FAIL);
        }
    }
}
