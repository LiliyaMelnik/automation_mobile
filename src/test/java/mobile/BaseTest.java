package mobile;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static mobile.config.driver.DriverInit.getDriver;
import static mobile.config.driver.DriverInit.quit;

public class BaseTest {
    protected static AppiumDriver driver;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @AfterClass
    public void close() {
        quit();
    }
}
