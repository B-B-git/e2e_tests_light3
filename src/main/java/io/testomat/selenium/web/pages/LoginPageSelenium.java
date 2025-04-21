package io.testomat.selenium.web.pages;

import static io.testomat.selenium.web.common.Elements.find;

public class LoginPageSelenium {


    public void login(String username, String password) {
        find("#content-desktop #user_email").sendKeys(username);
        find(("#content-desktop #user_password")).sendKeys(password);
        find(("#content-desktop #user_remember_me")).click();
        find(("#content-desktop [name=\"commit\"]")).click();
    }
}
