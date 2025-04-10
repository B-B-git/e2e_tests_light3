package io.testomat.e2e_tests_light3.web.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    public void IsLoaded(String targetProjectName) {}

    public ProjectPage openReadme() {
        $(Selectors.byLinkText("Readme")).click();
        return this;
    }

    public ProjectPage clickOnEdit() {
        $(Selectors.byLinkText("Edit")).click();
        return this;
    }

    public void isLoaded(String targetProjectName) {

    }

}
