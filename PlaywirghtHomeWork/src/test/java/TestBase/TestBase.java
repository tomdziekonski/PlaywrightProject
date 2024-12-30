package TestBase;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected BrowserContext context;

    @BeforeTest
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1920, 1080);
        page.navigate("http://automationpractice.pl");
    }

    @AfterTest
    public void close() {
        browser.close();
        playwright.close();
    }

    public Page getPage() {
        return page;
    }
}