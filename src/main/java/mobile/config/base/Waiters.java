package mobile.config.base;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static mobile.config.driver.DriverInit.getDriver;
import static mobile.utils.Utils.f;

public class Waiters {
    protected AppiumDriver driver = getDriver();

    private WebDriverWait waiter() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void presence(By by) {
        waiter()
                .withMessage(f("The element - %s is not found", by))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void clickable(By by) {
        waiter()
                .withMessage(f("The element - %s is not clickable", by))
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}
