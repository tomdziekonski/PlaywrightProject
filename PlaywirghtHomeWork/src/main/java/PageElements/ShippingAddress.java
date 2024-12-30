package PageElements;

import BaseClass.Base;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import java.util.List;

public class ShippingAddress extends Base {
    public ShippingAddress(Page page) {
        super(page);
    }

    Locator companyField = page.locator("//input[@id='company']");
    Locator address = page.locator("//input[@id='address1']");
    Locator city = page.locator("//input[@id='city']");
    Locator phone = page.locator("//input[@id='phone']");
    Locator mobilePhone = page.locator("//input[@id='phone_mobile']");
    Locator postalCode = page.locator("//input[@id='postcode']");
    Locator saveButton = page.locator("//button[@id='submitAddress']");
    Locator addressPage = page.locator("//span[contains(text(), 'My addresses')]");
    Locator updateAddress = page.locator("//span[contains(text(), 'Update')]");

    public Locator getUpdateAddressPage() {
        return updateAddress;
    }

    public Locator getAddressPage() {
        return addressPage;
    }

    public Locator getPostalCode() {
        return postalCode;
    }

    public void saveShippingInfo() {
        saveButton.click();
    }

    public Locator getPhoneField() {
        return phone;
    }

    public Locator getMobilePhoneField() {
        return mobilePhone;
    }

    public Locator getCompanyField() {
        return companyField;
    }

    public Locator getAddressField() {
        return address;
    }

    public Locator getCityField() {
        return city;
    }

    public List<String> selectState(String value) {
        return page.selectOption("//select[@id='id_state']", new SelectOption().setValue(value));
    }
}