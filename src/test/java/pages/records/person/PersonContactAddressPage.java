package pages.records.person;

import bean.ContactAddressBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;

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
    private static String addressGeomarketElement(String index){
        return String.format("#entity_address_%s_address_geomarket_component",index);
    }
    private static String addressCountyField(String index){
        return String.format("#entity_address_0_address_county",index);
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

    public static void verifyAddress(ContactAddressBean address, String group){
        String passMessage = String.format(LogPage.VERIFY_ADDRESS_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_ADDRESS_FAIL,group);

        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(address1Field(group)),address.getAddress1())
                    && MainPage.verifyGetAttribute(By.cssSelector(address2Field(group)),address.getAddress2())
                    && MainPage.verifyGetAttribute(By.cssSelector(address3Field(group)),address.getAddress3())
                    && MainPage.verifyGetAttribute(By.cssSelector(address4Field(group)),address.getAddress4())
                    && MainPage.verifyGetAttribute(By.cssSelector(addressCityField(group)),address.getCity())
                    && MainPage.verifyGetAttribute(By.cssSelector(addressCountyField(group)),address.getCounty())
                    && MainPage.verifyGetText(By.cssSelector(addressStateElement(group)),address.getState())
                    && MainPage.verifyGetAttribute(By.cssSelector(addressRegionField(group)),address.getRegion())
                    && MainPage.verifyGetText(By.cssSelector(addressCountryElement(group)),address.getCountry())
                    && MainPage.verifyGetAttribute(By.cssSelector(addressPostalCodeField(group)),address.getPostalCode())
                    && MainPage.verifyGetText(By.cssSelector(addressGeomarketElement(group)),address.getGeomarket())
                    && MainPage.verifyGetText(By.cssSelector(addressTypeElement(group)),address.getAddressType())
                    && MainPage.verifyGetText(By.cssSelector(addressNeighborhoodElement(group)),address.getEducationNeighborhood())
                    && MainPage.verifyGetAttribute(By.cssSelector(addressCommentsField(group)),address.getAddressComments())
                    && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(addressActiveCheckbox(group)),address.getActive())
                    && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(addressPrimaryCheckbox(group)),address.getPrimary())){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void addAddress(String group){
        try {
            MainPage.addDeleteWithPlusButton(By.cssSelector(emailAddressAddButton(group)));
            ExtentReportsSetUp.testingPass(LogPage.ADD_ADDRESS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ADD_ADDRESS_FAIL);
        }
    }

    public static void createAddress(ContactAddressBean address, String group){
        try {
            if(address.getAddress1()!=""){
                MainPage.fillField(By.cssSelector(address1Field(group)), address.getAddress1());
            }
            if(address.getAddress2()!=""){
                MainPage.fillField(By.cssSelector(address2Field(group)), address.getAddress2());
            }
            if(address.getAddress3()!=""){
                MainPage.fillField(By.cssSelector(address3Field(group)), address.getAddress3());
            }
            if(address.getAddress4()!=""){
                MainPage.fillField(By.cssSelector(address4Field(group)), address.getAddress4());
            }
            if(address.getCity()!=""){
                MainPage.fillField(By.cssSelector(addressCityField(group)), address.getCity());
            }
            if(address.getState()!=""){
                MainPage.clickOptionList(By.cssSelector(addressStateElement(group)),
                        address.getState(),
                        By.cssSelector(addressStateElementList(group)));
            }
            if(address.getRegion()!=""){
                MainPage.fillField(By.cssSelector(addressRegionField(group)), address.getRegion());
            }
            if(address.getCountry()!=""){
                MainPage.clickOptionList(By.cssSelector(addressCountryElement(group)),
                        address.getCountry(),
                        By.cssSelector(addressCountryElementList(group)));
            }
            if(address.getPostalCode()!=""){
                MainPage.fillField(By.cssSelector(addressPostalCodeField(group)), address.getPostalCode());
            }
            if(address.getAddressType()!=""){
                MainPage.clickOptionList(By.cssSelector(addressTypeElement(group)),
                        address.getAddressType(),
                        By.cssSelector(addressTypeElementList(group)));
            }
            if(address.getEducationNeighborhood()!=""){
                MainPage.clickOptionList(By.cssSelector(addressNeighborhoodElement(group)),
                        address.getEducationNeighborhood(),
                        By.cssSelector(addressNeighborhoodElementList(group)));
            }
            if(address.getAddressComments()!=""){
                MainPage.fillField(By.cssSelector(addressCommentsField(group)), address.getAddressComments());
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
