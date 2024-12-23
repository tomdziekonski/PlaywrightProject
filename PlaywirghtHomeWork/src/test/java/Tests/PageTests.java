package Tests;

import PageElements.RegisterSection;
import TestBase.TestBase;
import PageElements.HomePage;
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
}

