package mobile.po;

import mobile.config.base.BaseMethods;

import org.openqa.selenium.By;

public class ListSavedArticlePage extends BaseMethods {
    private final By addToListButton = By.xpath("//android.widget.Button[@resource-id='org.wikipedia:id/snackbar_action']");
    private final By nameList = By.xpath("//android.widget.EditText[@resource-id=\"org.wikipedia:id/text_input\"]");
    private final By okButton = By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
    private final By viewList = By.xpath("//android.widget.Button[@resource-id=\"org.wikipedia:id/snackbar_action\"]");
    private final By appiumArticle = By.xpath("//android.view.ViewGroup[@resource-id=\"org.wikipedia:id/page_list_item_container\"]");
    private final By articleCount = By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/item_reading_list_statistical_description\"]");
    private final By threeDotsMenu = By.id("org.wikipedia:id/item_overflow_menu");
    private final By deleteList = By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/title\" and @text=\"Delete list\"]");
    private final By okeyButton = By.id("android:id/button1");
    private final By saved = By.xpath("(//android.widget.TextView[@text=\"Saved\"])[1]");

    public ListSavedArticlePage clickAddToListButton() {
        click(addToListButton);
        return this;
    }

    public ListSavedArticlePage fillNameList(String text) {
        sendKeys(nameList, text);
        return this;
    }

    public ListSavedArticlePage clickOkButton() {
        click(okButton);
        return this;
    }

    public void viewList() {
        click(viewList);
    }

    public void swipeElementRight(int time) {
        swipeElementRight(appiumArticle, time);
    }

    public String getArticlesText() {
        return getText(articleCount);
    }

    public ListSavedArticlePage clickThreeDotsMenu() {
        click(threeDotsMenu);
        return this;
    }

    public ListSavedArticlePage clickDelete() {
        click(deleteList);
        return this;
    }

    public void clickOkeyButton() {
        click(okeyButton);
    }

    public String getSavedText() {
        return getText(saved);
    }
}
