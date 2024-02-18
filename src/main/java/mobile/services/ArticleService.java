package mobile.services;

import mobile.po.ArticlePage;

public class ArticleService {

    private final ArticlePage articlePage = new ArticlePage();

    public String getArticleName() {
        return articlePage
                .clickFirstArticle()
                .getArticleName();
    }
    public void clickFirstArticle() {
         articlePage.clickFirstArticle();
    }
    public String getHistoryName() {
        return articlePage
                .getHistoriaText();
    }
}
