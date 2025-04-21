package io.testomat.selenium.web.common;

import org.openqa.selenium.By;

public class Elements {

    public static ElementActions find(By locator) {
        return new ElementActions(locator);
    }

    public static ElementActions find(String locator) {

        By targetLocator = locator.startsWith("/") ? By.xpath(locator) : By.cssSelector(locator);

        return new ElementActions(targetLocator);
    }

    public static ElementActions findByText(String text) {
        return new ElementActions(By.xpath("//*[text()='" + text + "']"));
    }

}
