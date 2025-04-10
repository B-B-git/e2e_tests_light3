package io.testomat.e2e_tests_light3.web.pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    private SelenideElement searchInput = $("#search");

    public void open() { Selenide.open(""); }

    public ProjectsPage isLoaded() {
        searchInput.shouldBe(visible);
        return this;
    }

    public void signInSuccess() {$("#container .common-flash-success").shouldBe(Condition.visible);}

    public ProjectsPage searchForProject(String targetProjectName) {
        searchInput.setValue(targetProjectName);
        return this;
    }

    public void selectProject(String targetProjectName) {
        $(byText(targetProjectName)).click();
    }

    public ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return $$("#grid ul li").filter(visible).shouldHave(size(expectedSize));
    }

    public void countOfTestCasesShouldBeEqualTo(SelenideElement targetProject, int expectedCount) {
        targetProject.shouldHave(text(expectedCount + " tests"));

    }


}
