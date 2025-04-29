package io.testomat.e2e_tests_light3.web.selenium.common;

import io.testomat.selenium.web.pages.LoginPageSelenium;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.testomat.selenium.web.common.WebDriverProvider.driver;

public class LoginTestomat implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        driver().get("http://app.testomat.io/");

        new LoginPageSelenium()
                .login("bazhanl95@gmail.com", "Viddanist2025!");
    }


}
