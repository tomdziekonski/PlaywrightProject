package PageElements;

import BaseClass.Base;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartSection extends Base {

    public CartSection(Page page) {
        super(page);
    }

    Locator cartItemQuantity = page.locator("//input[@class='cart_quantity_input form-control grey']");
    Locator proceedToCheckout = page.locator("//a[@class='button btn btn-default standard-checkout button-medium']");
    Locator additionalComment = page.locator("//textarea[@class='form-control']");
    Locator agreeToTermsCheckbox = page.locator("//input[@id='cgv']");
    Locator processAddress = page.locator("//button[@class='button btn btn-default button-medium']");
    Locator processShipping = page.locator("//button[@name='processCarrier']");
    Locator bankWirePaymentMethod = page.locator("//a[@title='Pay by bank wire']");
    Locator confirmOrder = page.locator("//p[@class='alert alert-success']");
    Locator totalPrice = page.locator("//span[@id='total_price']");


    public Locator getTotalPrice() {
        return totalPrice;
    }

    public Locator getBankWirePaymentMethod() {
        return bankWirePaymentMethod;
    }

    public Locator getConfirmOrder() {
        return confirmOrder;
    }

    public Locator getProcessShipping() {
        return processShipping;
    }

    public Locator getprocessAddress() {
        return processAddress;
    }

    public Locator getAgreeToTermsCheckbox() {
        return agreeToTermsCheckbox;
    }

    public Locator getAdditionalCommentForm() {
        return additionalComment;
    }

    public Locator getCartItemQuantity() {
        return cartItemQuantity;
    }

    public void proceedToCheckout() {
        proceedToCheckout.click();
    }
}