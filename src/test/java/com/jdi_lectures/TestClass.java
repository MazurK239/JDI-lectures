package com.jdi_lectures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Created by Konstantin_Mazurin on 10/10/16.
 */
public class TestClass {

    @Test
    public void UserAgent() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.whatsmyua.com");
        String text = driver.findElement(By.id("ua-link")).getText();
        Assert.assertTrue(text.contains("Chrome"));
        driver.close();
    }

}
