package tests.ios;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.appium.java_client.MobileBy;

import tests.TestBase;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static helpers.EnvironmentHelper.KEYWORD;
import static io.qameta.allure.Allure.step;

@Feature("Selenide-appium IOS tests")
@Story("Element manipulation tests")
@Tag("ios")
public class BrowserStackIOS extends TestBase {

    @Test
    @DisplayName("Успешное добавление элемента в список")
    void successfulSearch() {
        step("Запускаем приложение", () -> open());

        step("Добавляем новый элемент", () -> {
            $(MobileBy.AccessibilityId("Text Button")).click();
            $(MobileBy.AccessibilityId("Text Input")).sendKeys(KEYWORD);
            $(MobileBy.AccessibilityId("Text Input")).sendKeys("\n");
        });

        step("Проверяем существование добавленного элемента", () -> {
            $(MobileBy.AccessibilityId("Text Output")).shouldHave(exactText(KEYWORD));
        });
    }
}
