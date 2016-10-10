package com.jdi_lectures;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import ru.stqa.selenium.factory.WebDriverFactory;

import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

/**
 * Created by Konstantin_Mazurin on 03/10/16.
 */
public class TestBase {

    protected static WebDriver driver;
    protected static String baseUrl;
    protected static WebDriverWait wait;

    @BeforeSuite
    public void setUpDriver() {
        baseUrl = "https://jdi-framework.github.io/tests/";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        driver = WebDriverFactory.getDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        maximizeScreen(driver);
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void maximizeScreen(WebDriver driver) {
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point position = new Point(0, 0);
        driver.manage().window().setPosition(position);
        Dimension maximizedScreenSize =
                new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        driver.manage().window().setSize(maximizedScreenSize);
    }

}
