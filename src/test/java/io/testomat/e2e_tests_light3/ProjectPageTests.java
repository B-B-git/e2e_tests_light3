package io.testomat.e2e_tests_light3;

import com.codeborne.selenide.SelenideElement;
import io.testomat.e2e_tests_light3.web.pages.ProjectPage;
import io.testomat.e2e_tests_light3.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light3.web.pages.SignInPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class ProjectPageTests extends BaseTest {

    private static final ProjectsPage projectsPage = new ProjectsPage();
    private static final SignInPage signInPage = new SignInPage();
    static String baseUrl = env.get("BASE_URL");
    static String username = env.get("USERNAME");
    static String password = env.get("PASSWORD");
    private final ProjectPage projectPage = new ProjectPage();
    String targetProjectName = "Manufacture light";

    @BeforeAll
    static void openTestomatAndLogin() {
        open(baseUrl);
        signInPage.loginUser(username, password);
        projectsPage.signInSuccess();
    }

    @BeforeEach
    void openProjectsPage() {
        projectsPage.open();
        projectsPage.isLoaded();
    }

    @Test
    public void userCanFindProjectWithTests() {

        projectsPage.searchForProject(targetProjectName);

        projectsPage.selectProject(targetProjectName);

        projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void anotherTest() {

        projectsPage.searchForProject(targetProjectName);

        SelenideElement targetProject = projectsPage.countOfProjectsShouldBeEqualTo(1).first();

        projectPage.countOfTestCasesShouldBeEqualTo(targetProject, 0);
    }


}
