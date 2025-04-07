package io.testomat.e2e_tests_light3.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    public void IsLoaded(String targetProjectName) {
        $(".first h2").shouldHave(text(targetProjectName));
        $(".first [href*='/readme']").shouldHave(text("Readme"));
    }

    public void isLoaded(String targetProjectName) {

    }

    public void countOfTestCasesShouldBeEqualTo(SelenideElement targetProject, int i) {

    }
}
