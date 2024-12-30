package PageElements;

import BaseClass.Base;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OrderHistory extends Base {
    public OrderHistory(Page page) {
        super(page);
    }

    Locator orderHistory = page.locator("//a[@title='Go to your order history page']");
    Locator orderName = page.locator("//ul[@class='address alternate_item box']//span[@class='address_firstname']");
    Locator orderLastName = page.locator("//ul[@class='address alternate_item box']//span[@class='address_lastname']");
    Locator orderCity = page.locator("//ul[@class='address alternate_item box']//span[@class='address_city']");
    Locator orderCountry = page.locator("//ul[@class='address alternate_item box']//span[@class='address_Country:name']");
    Locator orderTotalPrice = page.locator("//tr[@class='totalprice item']//span[@class='price']");
    Locator orderComment = page.locator("//td[contains(text(), 'Additional Comment')]");
    Locator orders = page.locator("(//table[@id='order-list']//span[contains(text(), 'Details')])[1]");


    public Locator getOrderComment() {
        return orderComment;
    }

    public Locator getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public Locator getOrderCountry() {
        return orderCountry;
    }

    public Locator getOrderName() {
        return orderName;
    }

    public Locator getOrderLastName() {
        return orderLastName;
    }

    public Locator getOrderCity() {
        return orderCity;
    }

    public Locator getOrderHistory() {
        return orderHistory;
    }

    public Locator getOrderDetails() {
        return orders;
    }
}