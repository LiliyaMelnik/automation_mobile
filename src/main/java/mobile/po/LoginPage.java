package mobile.po;

import mobile.config.base.BaseMethods;

import org.openqa.selenium.By;

public class LoginPage extends BaseMethods {
    private final By moreMenu = By.id("org.wikipedia:id/menu_icon");
    private final By loginOrJoin = By.id("org.wikipedia:id/main_drawer_login_button");
    private final By loginBeforeCred = By.id("org.wikipedia:id/create_account_login_button");
    private final By usernameInput = By.xpath("//android.widget.EditText[@text=\"Username\"]");
    private final By passwordInput = By.xpath("//android.widget.EditText[@text=\"Password\"]");
    private final By logInAfterCred = By.id("org.wikipedia:id/login_button");
    private final By noThanks = By.id("android:id/button2");
    private final By userLoggedIn = By.id("org.wikipedia:id/main_drawer_account_name");

    public LoginPage clickMoreMenu() {
        click(moreMenu);
        return this;
    }

    public LoginPage clickLoginOrJoin() {
        click(loginOrJoin);
        return this;
    }

    public LoginPage clickLoginBeforeCred() {
        click(loginBeforeCred);
        return this;
    }

    public LoginPage enterCred(String username, String password) {
        sendKeys(usernameInput, username);
        sendKeys(passwordInput, password);
        return this;
    }

    public LoginPage clickLogInAfterCred() {
        click(logInAfterCred);
        return this;
    }

    public void clickNoThanks() {
        click(noThanks);
    }

    public String getUserLoggedIn() {
        return getText(userLoggedIn);
    }
}
