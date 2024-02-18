package ui.selenide;

import org.testng.annotations.BeforeMethod;
import ui.selenide.utils.Utils;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    @BeforeMethod
    void setUp() {
        switch (System.getProperty("url")){
            case "wiki":
            open((String) Utils.getProperty("wiki"));
            break;
            case "demoqa":
            open((String) Utils.getProperty("demoqa"));
            break;
        }
        getWebDriver().manage().window().maximize();
    }
}
