package io.testomat.e2e_tests_light3.playwright;

import io.testomat.e2e_tests_light3.playwright.common.PWExention;
import io.testomat.pw.HomePage;
import io.testomat.pw.ProjectPage;
import io.testomat.pw.ProjectsPage;
import io.testomat.pw.SigninPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class ProjectsPlaywright {

    @RegisterExtension
    static PWExention pw = new PWExention();

    @Test
    void projectPossibleToFilterPWTest() {

        var page = pw.page();
        new HomePage(page).open();
        new SigninPage(page).loginUser("bazhanl95@gmail.com", "Viddanist2025!");

        var targetProjectName = "manufacture light";

        new ProjectsPage(page).signSuccessIsVisible().
                searchForProject(targetProjectName).
                clickOnProjectByName(targetProjectName);


        new ProjectPage(page).projectTitleIs(targetProjectName);

    }
}
