package mobile.config.base;

import com.google.common.collect.ImmutableList;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.List;

public class BaseMethods extends Waiters {
    protected void click(By by) {
        middle(by).click();
    }
    protected void sendKeys(By by, String text) {
        middle(by).sendKeys(text);
    }
    protected String getText(By by) {
        return middle(by).getText();
    }

    protected void swipeDownToElement(By by) {
        for (int i = 0; i < 5; i++) {
            if (isElementVisible(by)) {
                break;
            }
            Dimension dimension = driver.manage().window().getSize();

            int x = dimension.width / 2;

            int start = (int) (dimension.height * 0.2);
            int end = (int) (dimension.height * 0.8);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, end));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
            swipe.addAction(new Pause(finger, Duration.ofMillis(1000)));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), x, start));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
            driver.perform(ImmutableList.of(swipe));
        }
    }

    protected void swipeElementRight(By by, int time) {
        WebElement element = middle(by);
        int startX = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int startY = element.getLocation().getY() + element.getSize().getHeight() / 2;
        int endX = startX - 500;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipeRight = new Sequence(finger, 1);
        swipeRight.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipeRight.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        swipeRight.addAction(finger.createPointerMove(Duration.ofMillis(time), PointerInput.Origin.viewport(), endX, startY));
        swipeRight.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(List.of(swipeRight));
    }

    protected void getPhotoFromArticle(By by, String fileName) {
        WebElement element = middle(by);
        String base64 = element.getScreenshotAs(OutputType.BASE64);
        base64 = base64.replaceAll("\n", "");
        byte[] imageBytes = Base64.getDecoder().decode(base64);

        try {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
            File outputFile = new File(fileName);
            ImageIO.write(image, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isElementVisible(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private WebElement middle(By by) {
        presence(by);
        clickable(by);
        return driver.findElement(by);
    }
}
