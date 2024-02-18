package mobile.po;

import mobile.config.base.BaseMethods;
import org.openqa.selenium.By;

public class TopReadPage extends BaseMethods {

    private final By firstArticle =
            By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.wikipedia:id/most_read_recycler_view\"]/android.view.ViewGroup[1]");

    public void clickFirstArticle() {
        click(firstArticle);
    }
}
