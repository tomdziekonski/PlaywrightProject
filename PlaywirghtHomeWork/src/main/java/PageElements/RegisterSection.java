package PageElements;

import BaseClass.Base;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.Random;

public class RegisterSection extends Base {
    Locator signIn = page.locator("//a[@class='login']");
    Locator emailAddressInputField = page.locator("//input[@id='email_create']");
    Locator createAccountButton = page.locator("//i[@class='icon-user left']");
    Locator firstNameInputField = page.locator("//input[@id='customer_firstname']");
    Locator lastNameInputField = page.locator("//input[@id='customer_lastname']");
    Locator emailInputField = page.locator("//input[@id='email']");
    Locator specialOffers = page.locator("//div[@id='uniform-newsletter']");
    Locator passwordInputField = page.locator("//input[@id='passwd']");
    Locator registerButton = page.locator("//span[contains(text(), 'Register')]");

    public RegisterSection(Page page) {
        super(page);
    }

    public Locator getDaySelector(int value) {
        return page.locator("//select[@id='days']//option[@value='" + value + "']");
    }

    public Locator getMonthSelector(int value) {
        return page.locator("//select[@id='months']//option[@value='" + value + "']");
    }

    public Locator getYearSelector(int value) {
        return page.locator("//select[@id='years']//option[@value='" + value + "']");
    }

    public Locator getSuccessfulRegistrationInfo() {
        return page.locator("//p[@class='alert alert-success']");

    }

    public void register(String name, String surname, String password) {
        Random emailRandomizer = new Random();
        int randomEmail = emailRandomizer.nextInt();
        signIn.click();
        emailAddressInputField.fill(randomEmail + "@testing.pl");
        createAccountButton.click();
        firstNameInputField.fill(name);
        lastNameInputField.fill(surname);
        specialOffers.click();
        passwordInputField.fill(password);
        registerButton.click();
    }
}