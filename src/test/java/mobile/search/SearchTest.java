package mobile.search;

import mobile.BaseTest;
import mobile.po.SkipPage;
import mobile.services.ArticleService;
import mobile.services.LanguageService;
import mobile.services.SearchService;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {

    @Test
    void shouldBeArticleNameVisible() {
        new SkipPage().clickSkip();

        new SearchService().searchTest("Appium");

        var article = new ArticleService().getArticleName();

        assertThat(article).as("The article has wrong name").isEqualTo("Appium");
    }
    @Test
    void shouldBeSpanishLang() {
        new SkipPage().clickSkip();
        new SearchService().searchTest("Appium");
        new ArticleService().clickFirstArticle();
        new LanguageService().changeLangToSpanish();
        var historia = new ArticleService().getHistoryName();

        assertThat(historia).as("Check Historia text").isEqualTo("Historia");
    }
}
