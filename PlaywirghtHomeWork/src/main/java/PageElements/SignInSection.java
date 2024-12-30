package PageElements;

import BaseClass.Base;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignInSection extends Base {

    public SignInSection(Page page) {
        super(page);
    }

    Locator whichUserIsLoggedIn = page.locator("//a[@class='account']//span");

    public Locator getWhichUserIsLoggedIn() {
        return whichUserIsLoggedIn;
    }
}