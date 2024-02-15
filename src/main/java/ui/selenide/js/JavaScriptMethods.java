package ui.selenide.js;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JavaScriptMethods {

    public static void jsClick(SelenideElement element) {
        executeJavaScript("arguments[0].click();", element);
    }

    public static void jsScroll(SelenideElement element) {
        executeJavaScript("arguments[0].scrollIntoView(true);", element);
    }
}
