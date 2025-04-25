package io.testomat.pw;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProjectPage {

    private final Page page;

    public ProjectPage(Page page) {
        this.page = page;
    }

    public ProjectPage projectTitleIs(String targetProjectName) {
        assertThat(page.locator("h2").first()).containsText("Manufacture light");
        return this;
    }
}
