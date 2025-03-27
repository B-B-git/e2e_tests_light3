package io.testomat.e2e_tests_light3;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.testomat.e2e_tests_light_3.utils.StringParsel.parseIntegerFromString;

public class ProjectPageTests extends BaseTest {



    static String baseUrl = env.get("BASE_URL");
    static String username = env.get("USERNAME");
    static String password = env.get("PASSWORD");
    String targetProjectName = "Manufacture light";

    @BeforeAll
    static void openTestomatAndLogin() {
        open(baseUrl);
        loginUser(username, password);
    }

    @BeforeEach
    void openHomePage() {
        open(baseUrl);
    }

    @Test
    public void userCanFindProjectWithTests() {

        searchForProject(targetProjectName);

        selectProject(targetProjectName);

        waitForProjectPageIsLoaded(targetProjectName);
    }

    @Test
    public void anotherTest() {

        searchForProject(targetProjectName);
        SelenideElement targetProject = countOfProjectsShouldBeEqualTo(1).first();
        countOfTestCasesShouldBeEqualTo(targetProject, 0);

    }

    private void waitForProjectPageIsLoaded(String targetProjectName) {
        $(".first h2").shouldHave(text(targetProjectName));
        $(".first [href*='/readme']").shouldHave(text("Readme"));
    }

    private void selectProject(String targetProjectName) {
        $(byText(targetProjectName)).click();
    }

    private void searchForProject(String targetProjectName) {
        $("#search").setValue(targetProjectName);
    }



    private void countOfTestCasesShouldBeEqualTo(SelenideElement targetProject, int expectedCount) {
        String countOfTests = targetProject.$("p").getText();
        Integer actualCountOfTests = parseIntegerFromString(countOfTests);
        Assertions.assertEquals(expectedCount, actualCountOfTests);
    }

    @NotNull
    private ElementsCollection countOfProjectsShouldBeEqualTo(int expectedSize) {
        return $$("#grid ul li").filter(visible).shouldHave(size(expectedSize));
    }


    public static void loginUser(String email, String password) {
        $("#content-desktop #user_email").setValue(email);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success").shouldBe(visible);
    }


}
