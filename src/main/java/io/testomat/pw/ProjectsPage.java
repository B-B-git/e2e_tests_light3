package io.testomat.pw;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProjectsPage {

    private final Page page;

    public ProjectsPage(Page page) {
        this.page = page;
    }

    public ProjectsPage signSuccessIsVisible() {
        assertThat(page.locator(".common-flash-success")).
                isVisible(new LocatorAssertions.IsVisibleOptions().
                        setTimeout(5000));
        return this;
    }

    public ProjectsPage searchForProject(String targetProjectName) {
        page.locator("#search").fill(targetProjectName);
        return this;
    }

    public ProjectsPage clickOnProjectByName(String targetProjectName) {
        page.locator("text=" + targetProjectName).click();
        return this;
    }
}
