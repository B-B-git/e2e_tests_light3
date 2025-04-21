package io.testomat.selenide.pages;

import com.codeborne.selenide.Selectors;

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
