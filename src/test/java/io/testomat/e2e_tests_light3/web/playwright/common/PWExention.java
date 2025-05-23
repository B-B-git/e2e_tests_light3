package io.testomat.e2e_tests_light3.web.playwright.common;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class PWExention implements BeforeAllCallback, AfterAllCallback {

    private static Page page;
    private Playwright playwright;
    private BrowserType browserType;
    private Browser browser;

    public Page page() {
        return page;
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        playwright = Playwright.create();
        browserType = playwright.chromium();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();

    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        page.close();
        browser.close();
        playwright.close();
    }
}
