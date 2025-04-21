package io.testomat.selenide.utils;

import org.jetbrains.annotations.NotNull;

public class StringParsers {

    @NotNull
    public static Integer parseIntegerFromString(String countOfTests) {
        String digitText = countOfTests.replaceAll("\\D+", "");
        return Integer.parseInt(digitText);
    }

}
