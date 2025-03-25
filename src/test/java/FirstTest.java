import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class FirstTest {
    @Test
    void successfulSearchTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 6000;
        // Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        // Перейдите в раздел Wiki проекта
        //$("#wiki-tab").click();
        $x("//a[@id='wiki-tab']").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        //$(".js-wiki-more-pages-link").click();
        $x("//*[contains(@class,'wiki-more-pages-link')]//button").click();
        //$("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $x("//a[contains(text(),'SoftAssertions')]").shouldHave(text("SoftAssertions"));
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        //$("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $x("//a[contains(text(),'SoftAssertions')]").click();
        //$("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
        $x("//h4[contains(text(),'Using JUnit5 extend test class')]").shouldHave(text("Using JUnit5 extend test class"));
    }
}

