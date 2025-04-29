package io.testomat.e2e_tests_light3.web.selenide;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e_tests_light3.web.selenide.common.Application;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static Dotenv env = Dotenv.load();
    protected static String username = env.get("USERNAME");
    protected static String password = env.get("PASSWORD");
    protected static Application app = new Application();

    static {
        Configuration.baseUrl = env.get("BASE_URL");
        Configuration.headless = true;
    }

    protected String targetProjectName = "Manufacture light";

    @BeforeAll
    static void openTestomatAndLogin() {
        app.signInPage.open();
        app.signInPage.loginUser(username, password);
        app.projectsPage.signInSuccess();
    }
}
