package mobile.services;

import mobile.po.LoginPage;

public class LoginService {
    public final LoginPage page = new LoginPage();

    public void loginUser(String username, String password) {
        page.clickMoreMenu()
                .clickLoginOrJoin()
                .clickLoginBeforeCred()
                .enterCred(username, password)
                .clickLogInAfterCred()
                .clickNoThanks();
    }

    public String getUsername() {
        return page.clickMoreMenu().getUserLoggedIn();
    }
}
