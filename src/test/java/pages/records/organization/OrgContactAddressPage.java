package pages.records.organization;

import bean.ContactAddressBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;

public class OrgContactAddressPage extends BasePage {


    private static String address1Field(String index){
        return String.format("#entity_address_%s_org_address_1",index);
    }
    private static String address2Field(String index){
        return String.format("#entity_address_%s_org_address_2",index);
    }
    private static String address3Field(String index){
        return String.format("#entity_address_%s_org_address_3",index);
    }
    private static String address4Field(String index){
        return String.format("#entity_address_%s_org_address_4",index);
    }
    private static String cityField(String index){
        return String.format("#entity_address_%s_org_address_city",index);
    }
    private static String stateElement(String index){
        return String.format("#entity_address_%s_org_address_state_toggle",index);
    }
    private static String regionField(String index){
        return String.format("#entity_address_%s_org_address_region",index);
    }
    private static String countryElement(String index){
        return String.format("#entity_address_%s_org_address_country_toggle",index);
    }
    private static String postalCodeField(String index){
        return String.format("#entity_address_%s_org_address_postal_code",index);
    }
    private static String geomarketElement(String index){
        return String.format("#entity_address_%s_org_address_geomarket_toggle",index);
    }
    private static String addressType(String index){
        return String.format("#entity_address_%s_org_address_type_toggle",index);
    }
    private static String commentsField(String index){
        return String.format("#entity_address_%s_org_address_comments",index);
    }
    private static String addressActiveCheckbox(String index){
        return String.format("#entity_address_%s_active",index);
    }
    private static String addressPrimaryCheckbox(String index){
        return String.format("#entity_address_%s_primary",index);
    }

    public static void verifyOrgAddress(ContactAddressBean address, String group){
        String passMessage = String.format(LogPage.VERIFY_ORG_ADDRESS_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_ORG_ADDRESS_FAIL,group);

        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(address1Field(group)),address.getAddress1())
                && MainPage.verifyGetAttribute(By.cssSelector(address2Field(group)),address.getAddress2())
                && MainPage.verifyGetAttribute(By.cssSelector(address3Field(group)),address.getAddress3())
                && MainPage.verifyGetAttribute(By.cssSelector(address4Field(group)),address.getAddress4())
                && MainPage.verifyGetAttribute(By.cssSelector(cityField(group)),address.getCity())
                && MainPage.verifyGetText(By.cssSelector(stateElement(group)),address.getState())
                && MainPage.verifyGetAttribute(By.cssSelector(regionField(group)),address.getRegion())
                && MainPage.verifyGetText(By.cssSelector(countryElement(group)),address.getCountry())
                && MainPage.verifyGetAttribute(By.cssSelector(postalCodeField(group)),address.getPostalCode())
                && MainPage.verifyGetText(By.cssSelector(geomarketElement(group)),address.getGeomarket())
                && MainPage.verifyGetText(By.cssSelector(addressType(group)),address.getAddressType())
                && MainPage.verifyGetAttribute(By.cssSelector(commentsField(group)),address.getAddressComments())
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
}
