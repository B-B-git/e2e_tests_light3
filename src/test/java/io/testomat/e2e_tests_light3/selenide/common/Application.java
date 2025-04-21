package io.testomat.e2e_tests_light3.selenide.common;

import io.testomat.selenide.pages.ProjectPage;
import io.testomat.selenide.pages.ProjectsPage;
import io.testomat.selenide.pages.ReadmePage;
import io.testomat.selenide.pages.SignInPage;

public class Application {

    public final ProjectsPage projectsPage = new ProjectsPage();
    public final SignInPage signInPage = new SignInPage();
    public final ProjectPage projectPage = new ProjectPage();
    public final ReadmePage readmePage = new ReadmePage();
}
