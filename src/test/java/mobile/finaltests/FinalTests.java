package mobile.finaltests;

import mobile.BaseTest;
import mobile.config.builders.Login;
import mobile.config.builders.LoginBuilder;
import mobile.po.ListSavedArticlePage;
import mobile.po.MainPage;
import mobile.po.SavePage;
import mobile.po.SkipPage;
import mobile.services.ArticleService;
import mobile.services.ListSavedArticleService;
import mobile.services.LoginService;
import mobile.services.SearchService;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalTests extends BaseTest {
    @Test
    void shouldBeArticleOpened() {
        new SkipPage().clickSkip();

        new SearchService().searchTest("Appium");
        var article = new ArticleService().getArticleName();
        assertThat(article).isEqualTo("Appium");
    }

    @Test
    void shouldBeSavedArticleWithScreenshot() {
        new SkipPage().clickSkip();

        new MainPage().swipeToArticle().clickArticle();
        new ArticleService().getPicture("photo.png");

        boolean exists = new ArticleService().pictureExists("photo.png");
        assertThat(exists).isEqualTo(true);

        new SavePage().clickSaveButton();
        new ListSavedArticleService()
                .addToListArticle("ABC");

        String text = new ListSavedArticleService().getArticlesText();
        assertThat(text).contains("of 1 article");

        new ListSavedArticleService().deleteArticle();

        text = new ListSavedArticleService().getArticlesText();
        assertThat(text).contains("of 0 article");

        new ListSavedArticleService().deleteList();
        String savedText = new ListSavedArticlePage().getSavedText();
        assertThat(savedText).isEqualTo("Saved");
    }

    @Test
    void shouldBeLoggedInUser() {
        new SkipPage().clickSkip();

        Login loginCred = new LoginBuilder().fromProperties().build();

        String user = loginCred.getUsername();
        String password = loginCred.getPassword();

        new LoginService().loginUser(user, password);

        String userResult = new LoginService().getUsername();
        assertThat(userResult).isEqualTo(user);
    }
}
