package mobile.po;

import mobile.config.base.BaseMethods;
import org.openqa.selenium.By;

public class ArticlePage extends BaseMethods {
    private final By firstArticle =
            By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']/android.view.ViewGroup[1]");
    private final By articleName = By.xpath("(//android.widget.TextView[@text='Appium'])[1]");
    private final By photo = By.id("org.wikipedia:id/view_page_header_image");

    public ArticlePage clickFirstArticle() {
        click(firstArticle);
        return this;
    }

    public String getArticleName() {
        return getText(articleName);
    }

    public void getPicture(String fileName) {
        getPhotoFromArticle(photo, fileName);
    }
}
