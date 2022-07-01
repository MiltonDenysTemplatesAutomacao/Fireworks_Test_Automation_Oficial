package pages.Records;

import bean.ContactAddressBean;
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
        boolean address1Validation = false;
        boolean address2Validation = false;
        boolean address3Validation = false;
        boolean address4Validation = false;
        boolean cityValidation = false;
        boolean countyValidation = false;
        boolean stateValidation = false;
        boolean regionValidation = false;
        boolean countryValidation = false;
        boolean postalCodeValidation = false;
        boolean geomarketValidation = false;
        boolean addressTypeValidation = false;
        boolean educationNeighborhoodValidation = false;
        boolean addressCommentsValidation = false;
        boolean activeValidation = false;
        boolean primaryValidation = false;

        String passMessage = String.format(LogPage.VERIFY_ADDRESS_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_ADDRESS_FAIL,group);

        try {
            if(address.getAddress1()!=""){
                String address1Text = getAtribute(By.cssSelector(address1Field(group)),"value");
                address1Validation = address.getAddress1().equals(address1Text);
            }else{
                address1Validation=true;
            }
            if(address.getAddress2()!=""){
                String address2Text = getAtribute(By.cssSelector(address2Field(group)),"value");
                address2Validation = address.getAddress2().equals(address2Text);
            }else{
                address2Validation=true;
            }
            if(address.getAddress3()!=""){
                String address3Text = getAtribute(By.cssSelector(address3Field(group)),"value");
                address3Validation = address.getAddress1().equals(address3Text);
            }else{
                address3Validation=true;
            }
            if(address.getAddress4()!=""){
                String address4Text = getAtribute(By.cssSelector(address4Field(group)),"value");
                address4Validation = address.getAddress4().equals(address4Text);
            }else{
                address4Validation=true;
            }
            if(address.getCity()!=""){
                String cityText = getAtribute(By.cssSelector(addressCityField(group)),"value");
                cityValidation = address.getCity().equals(cityText);
            }else{
                cityValidation=true;
            }
            if(address.getCounty()!=""){
                String countyText = getAtribute(By.cssSelector(addressCountyField(group)),"value");
                countyValidation = address.getCounty().equals(countyText);
            }else{
                countyValidation=true;
            }
            if(address.getState()!=""){
                String stateText = getText(By.cssSelector(addressStateElement(group)));
                stateValidation = address.getState().equals(stateText);
            }else{
                stateValidation=true;
            }
            if(address.getRegion()!=""){
                String regionText = getAtribute(By.cssSelector(addressRegionField(group)),"value");
                regionValidation = address.getRegion().equals(regionText);
            }else{
                regionValidation=true;
            }
            if(address.getCountry()!=""){
                String countryText = getText(By.cssSelector(addressCountryElement(group)));
                countryValidation = address.getCountry().equals(countryText);
            }else{
                countryValidation=true;
            }
            if(address.getPostalCode()!=""){
                String postalCodeText = getAtribute(By.cssSelector(addressPostalCodeField(group)),"value");
                postalCodeValidation = address.getPostalCode().equals(postalCodeText);
            }else{
                postalCodeValidation=true;
            }
            if(address.getGeomarket()!=""){
                String geomarketText = getText(By.cssSelector(addressGeomarketElement(group)));
                geomarketValidation = address.getGeomarket().equals(geomarketText);
            }else{
                geomarketValidation=true;
            }
            if(address.getAddressType()!=""){
                String addressTypeText = getText(By.cssSelector(addressTypeElement(group)));
                addressTypeValidation = address.getAddressType().equals(addressTypeText);
            }else{
                addressTypeValidation=true;
            }
            if(address.getEducationNeighborhood()!=""){
                String educationNeighborhoodText = getText(By.cssSelector(addressNeighborhoodElement(group)));
                educationNeighborhoodValidation = address.getEducationNeighborhood().equals(educationNeighborhoodText);
            }else{
                educationNeighborhoodValidation=true;
            }
            if(address.getAddressComments()!=""){
                String addressCommentsText = getAtribute(By.cssSelector(addressCommentsField(group)),"value");
                addressCommentsValidation = address.getAddressComments().equals(addressCommentsText);
            }else{
                addressCommentsValidation=true;
            }
            if(address.getActive()!=""){
                switch (address.getActive()){
                    case "1":
                        activeValidation = checkBoxIsActive(By.cssSelector(addressActiveCheckbox(group)));
                        break;
                    case "0":
                        activeValidation = !checkBoxIsActive(By.cssSelector(addressActiveCheckbox(group)));
                        break;
                    default: throw new IllegalArgumentException("Active Checkbox not verified");
                }
            }
            if(address.getPrimary()!=""){
                switch (address.getPrimary()){
                    case "1":
                        primaryValidation = checkBoxIsActive(By.cssSelector(addressPrimaryCheckbox(group)));
                        break;
                    case "0":
                        primaryValidation = !checkBoxIsActive(By.cssSelector(addressPrimaryCheckbox(group)));
                        break;
                    default: throw new IllegalArgumentException("Active Checkbox not verified");
                }
            }
            if(address1Validation
                    && address2Validation
                    && address3Validation
                    && address4Validation
                    && cityValidation
                    && countyValidation
                    && stateValidation
                    && regionValidation
                    && countryValidation
                    && postalCodeValidation
                    && geomarketValidation
                    && addressTypeValidation
                    && educationNeighborhoodValidation
                    && addressCommentsValidation
                    && activeValidation
                    && primaryValidation
            ){
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
            scrollToElement(By.cssSelector(emailAddressAddButton(group)));
            scrollTo("-100");
            waitUntilElementToBeSelected(By.cssSelector(emailAddressAddButton(group)),20);
            click(By.cssSelector(emailAddressAddButton(group)));
            ExtentReportsSetUp.testingPass(LogPage.ADD_ADDRESS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ADD_ADDRESS_FAIL);
        }
    }

    public static void createAddress(ContactAddressBean address, String group){
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
