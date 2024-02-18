package mobile.services;

import mobile.po.TopReadPage;

public class TopReadService {

    private final TopReadPage topReadPage = new TopReadPage();

    public void clickFirstArticle() {
        topReadPage.clickFirstArticle();
    }
}
