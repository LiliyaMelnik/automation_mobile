package ui.selenide.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.selenide.entities.User;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    private final SelenideElement login = $x("//input[@id='wpName1']");

    private final SelenideElement password = $x("//input[@id='wpPassword1']");

    private final SelenideElement enter = $x("//button[@id='wpLoginAttempt']");

    private final SelenideElement loginButton = $x("//li[@id='pt-login']");

    @Step("Try to auth with - {user}")
    public LoginPage auth(User user) {
        login.shouldBe(visible).sendKeys(user.getUsername());
        password.shouldBe(visible).sendKeys(user.getPassword());
        enter.shouldBe(visible, enabled).click();
        return page(LoginPage.class);
    }

    @Step("Click login")
    public LoginPage clickLogin() {
        loginButton.shouldBe(visible, enabled).click();
        return page(LoginPage.class);
    }

}
