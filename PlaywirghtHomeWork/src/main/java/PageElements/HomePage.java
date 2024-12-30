package PageElements;

import BaseClass.Base;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends Base {
    Locator searchBar = page.locator("//input[@id='search_query_top']");
    Locator findButton = page.locator("button.btn.btn-default.button-search");
    Locator howManyResultsFound = page.locator("//div[@id='center_column']//span[@class='heading-counter']").first();
    Locator blousePrices = page.locator("//div[@class='content_price']");
    Locator womenSection = page.locator("(//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[@title='Women'])[1]");
    Locator summerDresses = page.locator("//a[@title='Summer Dresses']").first();
    Locator whiteColorFilter = page.locator("//input[@id='layered_id_attribute_group_8']");
    Locator printedChriffonDressesCompare = page.locator("//a[@data-id-product='7']");
    Locator printedSummerDressesCompare = page.locator("//a[@data-id-product='6' and contains(text(), 'Add to Compare')]");
    Locator compareButton = page.locator("//button[@class='btn btn-default button button-medium bt_compare bt_compare']");
    Locator compareSection = page.locator("//h1[@class='page-heading']");
    Locator printedDressCompareSection = page.locator("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-line last-item-of-tablet-line last-mobile-line']");
    Locator printedChiffonCompareSection = page.locator("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-in-line last-line first-item-of-tablet-line last-item-of-mobile-line last-mobile-line']");
    Locator newsletterInputField = page.locator("input[id='newsletter-input']");
    Locator newsletterButton = page.locator("//button[@class='btn btn-default button button-small']");
    Locator newsletterSaved = page.locator("p[class=\"alert alert-success\"]");
    Locator signIn = page.locator("//div[@class='header_user_info']//a[@class='login']");
    Locator signInEmailField = page.locator("//input[@id='email']");
    Locator signInPasswordField = page.locator("//input[@id='passwd']");
    Locator signInButton = page.locator("//button[@id='SubmitLogin']");
    Locator blouseDetails = page.locator("//div[@class='product-image-container']");
    String iFrame = "//iframe[contains(@name, 'fancybox-frame')]";
    String whiteColor = "//a[@name='White']";
    Locator buyProduct = page.locator("//p[@id='add_to_cart']//button[@name='Submit']");
    Locator addToCartConfirmation = page.locator("//*[text()[contains(.,\"Product successfully added to your shopping cart\")]]");
    Locator proceedToCheckout = page.locator("//a[@title='Proceed to checkout']");
    Locator logout = page.locator("//a[@class='logout']");

    public HomePage(Page page) {
        super(page);
    }

    public Locator getWomanSection() {
        Locator locator = page.locator("text='Women'");
        return locator;
    }

    public List<ElementHandle> getWomanSectionPriceWebElements() {
        Locator locator = page.locator("//span[@class='price product-price']");
        List<ElementHandle> elements = locator.elementHandles();
        return elements;
    }

    public ArrayList<Integer> womenSectionPrices() {
        ArrayList<Integer> womenSectionPrices = new ArrayList<>();

        for (ElementHandle womanSectionPricesWebElement : getWomanSectionPriceWebElements()) {
            String price = womanSectionPricesWebElement.innerText();

            if (price.contains("$")) {

                StringBuilder result = new StringBuilder();

                for (char c : price.toCharArray()) {
                    if (Character.isDigit(c)) {
                        result.append(c);
                    }
                }

                womenSectionPrices.add(Integer.parseInt(result.toString()));
            }
        }
        return womenSectionPrices;
    }

    public void search(String searchPhrase) {
        searchBar.click();
        searchBar.fill(searchPhrase);
        findButton.click();
    }

    public Locator howManyResultsFound() {
        return howManyResultsFound;
    }

    public ArrayList<String> getBlouseWebElements() {
        List<String> prices = blousePrices.allTextContents();

        StringBuilder result = new StringBuilder();

        for (String price : prices) {
            for (char c : price.toCharArray()) {
                if (Character.isDigit(c)) {
                    result.append(c);
                }
            }
            break;
        }

        ArrayList<String> womenSectionPrices = new ArrayList<>();
        womenSectionPrices.add(result.toString());

        return womenSectionPrices;
    }

    public Locator getWomenSection() {
        return womenSection;
    }

    public Locator getSummerDresses() {
        return summerDresses;
    }

    public Locator getWhiteColorFilter() {
        return whiteColorFilter;
    }

    public Locator getPrintedChriffonDressesCompare() {
        return printedChriffonDressesCompare;
    }

    public Locator getPrintedSummerDressesCompare() {
        return printedSummerDressesCompare;
    }

    public Locator getCompareButton() {
        return compareButton;
    }

    public Locator getCompareSection() {
        return compareSection;
    }

    public Locator getComparePrintedSummerDresses() {
        return printedDressCompareSection;
    }

    public Locator getComparePrintedChiffonDresses() {
        return printedChiffonCompareSection;
    }

    public void scrollDown() {
        page.keyboard().press("PageDown");
    }

    public Locator getNewsletterInputField() {
        return newsletterInputField;
    }

    public void waitForTextChange(Locator element, String expectedText) {
        element.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        while (!element.innerText().equals(expectedText)) {
            Thread.onSpinWait();
        }
    }

    public Locator getNewsletterButton() {
        return newsletterButton;
    }

    public Locator getNewsletterSaved() {
        return newsletterSaved;
    }

    public void signIn(String email, String password) {
        signIn.click();
        signInEmailField.type(email);
        signInPasswordField.type(password);
        signInButton.click();
    }

    public Locator getBlouseDetails() {
        return blouseDetails;
    }

    public String getIFrame() {
        return iFrame;
    }

    public String changeColor() {
        return whiteColor;
    }

    public Locator getBuyProduct() {
        return buyProduct;
    }

    public Locator getAddToCartConfirmation() {
        return addToCartConfirmation;
    }

    public Locator getProceedToCheckout() {
        return proceedToCheckout;
    }

    public Locator getLogout() {
        return logout;
    }
}