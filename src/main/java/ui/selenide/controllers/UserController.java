package ui.selenide.controllers;

import ui.selenide.entities.User;
import ui.selenide.utils.Utils;

public class UserController {

    private UserController() {}

    public static User getUserCredentials() {
        return new User(String.valueOf(Utils.getProperty("login")), String.valueOf(Utils.getProperty("password")));
    }
}
