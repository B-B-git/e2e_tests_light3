package io.testomat.e2e_tests_light3.selenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$;

public class CollectionOfElementsTests extends BaseTest {

    @Test
    @DisplayName("find all product experiments")
    void findAllProductExperiments() {
        var labelCountOfTests = $$("ul li p")
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement labelCountOfTest : labelCountOfTests) {
            labelCountOfTest.shouldHave(Condition.text("14 tests").or(Condition.text("0 tests")));
        }


        $$(Selectors.byText("14 tests")).shouldHave(CollectionCondition.size(0));
        $$(Selectors.byText("0 tests")).shouldHave(CollectionCondition.size(102));

        labelCountOfTests.filter(Condition.text("14 tests")).shouldHave(CollectionCondition.size(0));
        labelCountOfTests.filter(Condition.text("0 tests")).shouldHave(CollectionCondition.size(102));
    }
}
