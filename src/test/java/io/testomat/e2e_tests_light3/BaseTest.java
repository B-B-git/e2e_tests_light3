package io.testomat.e2e_tests_light3;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Objects;

public class BaseTest {

    public static Dotenv env = Dotenv.load();

    static {
        Configuration.baseUrl = Objects.requireNonNull(env.get("BASE_URL"));
    }
}
