package BaseClass;

import com.microsoft.playwright.Page;

public class Base {
    protected Page page;

    public Base(Page page) {
        this.page = page;
    }
}