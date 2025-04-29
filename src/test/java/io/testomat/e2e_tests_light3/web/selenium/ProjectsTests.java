package io.testomat.e2e_tests_light3.web.selenium;

import io.testomat.e2e_tests_light3.web.selenium.common.LoginTestomat;
import io.testomat.e2e_tests_light3.web.selenium.common.WebDriverLifeCycleExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.testomat.selenium.web.common.Elements.find;
import static io.testomat.selenium.web.common.Elements.findByText;

@ExtendWith({WebDriverLifeCycleExtension.class, LoginTestomat.class})
public class ProjectsTests {


    @Test
    @DisplayName("Project possible to find")
    void projectPossibleToFindByName() {
        find(".common-flash-success").waitfor().visibility();

        String targetProjectName = "Manufacture light";
        find("#search").sendKeys(targetProjectName);

        findByText(targetProjectName).click();

        find("h2").waitfor().containsText(targetProjectName);

    }
}

