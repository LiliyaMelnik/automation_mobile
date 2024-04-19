package mobile.po;

import mobile.config.base.BaseMethods;

import org.openqa.selenium.By;

public class MainPage extends BaseMethods {
    private final By article = By.id("org.wikipedia:id/articleTitle");

    public MainPage swipeToArticle() {
        swipeDownToElement(article);
        return this;
    }

    public void clickArticle() {
        click(article);
    }
}