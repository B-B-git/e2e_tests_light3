package io.testomat.pw;

import com.microsoft.playwright.Page;

public class SigninPage {
    private final Page page;

    public SigninPage(Page page) {
        this.page = page;
    }

    public SigninPage loginUser(String username, String password) {
        page.locator("#content-desktop #user_email").fill(username);
        page.locator(("#content-desktop #user_password")).fill(password);
        page.locator(("#content-desktop #user_remember_me")).click();
        page.locator(("#content-desktop [name=\"commit\"]")).click();
        return this;
    }
}
