package mobile.po;

import mobile.config.base.BaseMethods;
import org.openqa.selenium.By;

public class MainPage extends BaseMethods {

    private final By topRead = By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/view_card_header_title\" and @text=\"In the news\"]");
    private final By moreTopRead = By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/footerActionButton\" and @text=\"More top read  \"]");


    public void swipeUpOnPage(int time) {
        swipeUp(time);
    }

    public void swipeDownOnPage(int time) {
        swipeDown(time);
    }

    public void swipeToElementTo() {
        swipeToElement(topRead, 1000);
    }
    public MainPage swipeToMoreTopRead() {
        swipeToElement(moreTopRead, 1000);
        return this;
    }

    public void clickMoreTopRead() {
        click(moreTopRead);
    }
}
