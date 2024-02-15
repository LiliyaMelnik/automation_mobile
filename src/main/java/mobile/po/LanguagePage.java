package mobile.po;

import mobile.config.base.BaseMethods;
import org.openqa.selenium.By;

public class LanguagePage extends BaseMethods {
    private final By languageBtn = By.id("org.wikipedia:id/page_language");
    private final By langSpanish = By
            .xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/localized_language_name\" and @text=\"Español\"]");

    public LanguagePage clickOnLangBtn() {
        click(languageBtn);
        return new LanguagePage();
    }
    public LanguagePage clickOnSpanish() {
        click(langSpanish);
        return new LanguagePage();
    }

}
