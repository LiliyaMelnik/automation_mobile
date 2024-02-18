package mobile.config.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseMethods extends Waiters {

    protected void click(By by) {
        middle(by, true, true).click();
    }

    protected void sendKeys(By by, String text) {
        middle(by, true).sendKeys(text);
    }

    protected void clear(By by) {
        middle(by, true).clear();
    }

    protected String getText(By by) {
        return middle(by, true).getText();
    }

    private WebElement middle(By by, Boolean presence, Boolean clickable) {
        if (presence) presence(by);
        if (clickable) clickable(by);
        return driver.findElement(by);
    }

    private WebElement middle(By by, Boolean presence) {
        if (presence) presence(by);
        return driver.findElement(by);
    }
}
