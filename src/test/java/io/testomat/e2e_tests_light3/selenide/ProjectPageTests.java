package io.testomat.e2e_tests_light3.selenide;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectPageTests extends BaseTest {


    @BeforeEach
    void openProjectsPage() {
        app.projectsPage.open();
        app.projectsPage.isLoaded();
    }

    @Test
    public void userCanFindProjectWithTests() {

        app.projectsPage.searchForProject(targetProjectName);

        app.projectsPage.selectProject(targetProjectName);

        app.projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void anotherTest() {

        app.projectsPage.searchForProject(targetProjectName);

        SelenideElement targetProject = app.projectsPage.countOfProjectsShouldBeEqualTo(1).first();

        app.projectsPage.countOfTestCasesShouldBeEqualTo(targetProject, 0);
    }


}
