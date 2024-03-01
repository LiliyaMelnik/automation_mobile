package mobile.services;

import mobile.po.ListSavedArticlePage;

public class ListSavedArticleService {
    private final ListSavedArticlePage list = new ListSavedArticlePage();

    public void addToListArticle(String text) {
        list.clickAddToListButton()
                .fillNameList(text)
                .clickOkButton()
                .viewList();
    }

    public String getArticlesText() {
        return list.getArticlesText();
    }

    public void deleteArticle() {
        list.swipeElementRight(150);
    }

    public void deleteList() {
        list.clickThreeDotsMenu().clickDelete().clickOkeyButton();
    }
}
