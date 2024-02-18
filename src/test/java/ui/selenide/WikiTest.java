package ui.selenide;

import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ui.selenide.po.ArticlePage;
import ui.selenide.po.LoginPage;
import ui.selenide.po.SearchPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static ui.selenide.controllers.UserController.getUserCredentials;

@Epic("[123] - Wikipedia epic")
public class WikiTest extends BaseTest {

    @Test
    @Story("[234] - Open ubisoft article")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Severity(SeverityLevel.CRITICAL)
    void shouldBeOpenedArticle() {
        new SearchPage()
                .searchUbisoftArticle("Ubisoft")
                .clickEnter()
                .clickOnUbisoftArticle();

        assertThat(new ArticlePage().getHeadingOfArticle()).as("The text must be Ubisoft").isEqualTo("Ubisoft");
    }

    @Test
    @Story("[345] - Auth with user")
    void shouldBeAuth() {
        new LoginPage()
                .clickLogin()
                .auth(getUserCredentials());
    }
}
