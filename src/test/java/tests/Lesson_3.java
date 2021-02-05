package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Lesson_3 {

    @Test
    public void SearchASoftAssertionInSelenide() {
        // открыть GitHub
        open("https://github.com/");
        // ввести значение в поиск и нажать Enter
        $("[name=q]").setValue("Selenide").pressEnter();
        // кликнуть по первой строке
        $$("ul.repo-list li").first().$("a").click();
        // проверить заголовок
        $("h1").shouldHave(text("selenide"));
        // перейти во вкладку wiki
        $("[data-content='Wiki']").click();
        // проверить наличие SoftAssertions и кликнуть по нему
        $$("#wiki-pages-box li").findBy(text("SoftAssertions")).click();
        // проверить наличие 'Using JUnit5 extend test class:' на странице
        $("[class=markdown-body]").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
