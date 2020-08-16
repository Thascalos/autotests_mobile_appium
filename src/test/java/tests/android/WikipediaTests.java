package tests.android;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static helpers.EnvironmentHelper.KEYWORD;
import static io.qameta.allure.Allure.step;

@Feature("Selenide-appium Android tests")
@Story("Search tests")
@Tag("android")
class WikipediaTests extends TestBase {

    @Test
    @DisplayName("Успешный поиск фразы в приложении Wikipedia")
    void successfulSearch() {
        step("Открыть приложение", ()-> open());

        step("Вбить в поиск фразу", ()-> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(KEYWORD);
        });

        step("Проверить что контент существует", ()-> {
            $$(MobileBy.className("android.widget.TextView"))
                    .shouldHave(CollectionCondition.sizeGreaterThan(0));
        });
    }

}
