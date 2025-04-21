package io.testomat.selenium.web.common;

import org.openqa.selenium.By;

import static io.testomat.selenium.web.common.WebDriverProvider.driver;

public class ElementActions {

    private final By selector;

    public ElementActions(By selector) {
        this.selector = selector;
    }

    public void click() {
        waitfor().visibility();
        driver().findElement(selector).click();
    }

    public void sendKeys(String text) {
        waitfor().visibility();
        driver().findElement(selector).sendKeys(text);
    }

    public Waits waitfor() {
        return new Waits(selector);
    }
}
