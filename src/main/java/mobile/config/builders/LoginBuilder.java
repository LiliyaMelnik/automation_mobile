package mobile.config.builders;

public class LoginBuilder {
    private String username;
    private String password;

    public LoginBuilder fromProperties() {
        this.username = System.getProperty("username");
        this.password = System.getProperty("password");
        return this;
    }

    public Login build() {
        return new Login(username, password);
    }
}