package Tests;

import PageElements.*;
import TestBase.TestBase;
import com.microsoft.playwright.FrameLocator;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Random;

public class PageTests extends TestBase {

    @Test
    public void areWomanSectionPricesGreaterThanZero() throws Exception {
        HomePage Home = new HomePage(getPage());
        Home.getWomanSection();

        for (double convertedPrice : Home.womenSectionPrices()) {
            if (convertedPrice <= 0) {
                throw new Exception("Price test failed");
            }
        }
    }

    @Test
    public void isBlouseFoundAndWithASpecificPrice() {
        HomePage Home = new HomePage(getPage());
        Home.search("Blouse");
        Assert.assertEquals(Home.howManyResultsFound().innerText(), "1 result has been found.");

        ArrayList<String> convertedBlouseWebElements = Home.getBlouseWebElements();

        Assert.assertEquals(convertedBlouseWebElements.get(0), "27");
    }

    @Test
    public void isItPossibleToSuccessfullyRegister() {
        RegisterSection register = new RegisterSection(getPage());
        register.register("Tom", "Dziekonski", "12345");
        Assert.assertEquals(register.getSuccessfulRegistrationInfo().innerText(), " Your account has been created.");
    }

    @Test
    public void isItPossibleToFilterProducts() {
        HomePage Home = new HomePage(getPage());

        Home.getWomenSection().hover();
        Home.getSummerDresses().click();

        Assert.assertEquals(Home.howManyResultsFound().innerText(), "There are 3 products.");
        Home.getWhiteColorFilter().click();
        Home.waitForTextChange(Home.howManyResultsFound(), "There is 1 product.");
        Assert.assertEquals(Home.howManyResultsFound().innerText(), "There is 1 product.");
    }

    @Test
    public void isItPossibleToCompareProducts() {
        HomePage Home = new HomePage(getPage());
        Home.getWomenSection().hover();
        Home.getSummerDresses().click();
        Home.scrollDown();
        Home.scrollDown();

        Home.getComparePrintedSummerDresses().hover();
        Home.getPrintedSummerDressesCompare().click();
        Home.getComparePrintedChiffonDresses().hover();
        Home.getPrintedChriffonDressesCompare().click();

        Home.getCompareButton().click();
        Assert.assertEquals(Home.getCompareSection().innerText(), "PRODUCT COMPARISON");
    }

    @Test
    public void isItPossibleToSignToTheNewsletter() {
        HomePage Home = new HomePage(getPage());
        Home.scrollDown();
        Home.scrollDown();
        Home.scrollDown();
        Home.scrollDown();

        Random emailRandomizer = new Random();
        int randomEmail = emailRandomizer.nextInt();
        Home.getNewsletterInputField().type(randomEmail + "@testing.pl");
        Home.getNewsletterButton().click();

        Assert.assertEquals(Home.getNewsletterSaved().innerText(), " Newsletter : You have successfully subscribed to this newsletter.");
    }

    @Test
    public void isItPossibleToBuyAProduct() {
        HomePage Home = new HomePage(getPage());
        Home.signIn("tester@op.pl", "12345");
        SignInSection signSection = new SignInSection(getPage());
        String whichUserIsLoggedIn = signSection.getWhichUserIsLoggedIn().innerText();
        Assert.assertEquals(whichUserIsLoggedIn, "G g");

        ShippingAddress Shipping = new ShippingAddress(getPage());
        Shipping.getAddressPage().click();
        Shipping.getUpdateAddressPage().click();
        Shipping.getCompanyField().clear();
        Shipping.getCompanyField().type("companyX");
        Shipping.getAddressField().clear();
        Shipping.getAddressField().type("Some Street");
        Shipping.getCityField().clear();
        Shipping.getCityField().type("City in Alabama");
        Shipping.selectState("2");
        Shipping.getPhoneField().clear();
        Shipping.getPhoneField().type("666");
        Shipping.getMobilePhoneField().clear();
        Shipping.getMobilePhoneField().type("111");
        Shipping.getPostalCode().clear();
        Shipping.getPostalCode().type("12345");
        Shipping.saveShippingInfo();

        Home.search("Blouse");
        Home.getBlouseDetails().click();
        FrameLocator iframe = getPage().frameLocator((Home.getIFrame()));
        iframe.locator(Home.changeColor()).click();
        iframe.locator(Home.getBuyProduct()).click();

        Assert.assertEquals(Home.getAddToCartConfirmation().innerText().trim(), "Product successfully added to your shopping cart");

        Home.getProceedToCheckout().click();
        CartSection Cart = new CartSection(getPage());
        Cart.getCartItemQuantity().clear();
        Cart.getCartItemQuantity().type("2");
        Cart.proceedToCheckout();
        Cart.getAdditionalCommentForm().type("Additional Comment");
        Cart.getprocessAddress().click();
        Cart.getAgreeToTermsCheckbox().click();
        Cart.getProcessShipping().click();
        Cart.getBankWirePaymentMethod().click();
        Cart.getprocessAddress().click();
        Assert.assertEquals(Cart.getConfirmOrder().innerText(), "Your order on My Shop is complete.");

        OrderHistory Order = new OrderHistory(getPage());
        Order.getOrderHistory().click();
        Order.getOrderDetails().click();

        Assert.assertEquals(Order.getOrderName().innerText(), "G");
        Assert.assertEquals(Order.getOrderLastName().innerText(), "g");
        Assert.assertEquals(Order.getOrderCity().innerText(), "City in Alabama,");
        Assert.assertEquals(Order.getOrderCountry().innerText(), "United States");
        Assert.assertEquals(Order.getOrderTotalPrice().innerText(), "$34");
        Assert.assertEquals(Order.getOrderComment().innerText(), "Additional Comment");

        Home.getLogout().click();
    }
}