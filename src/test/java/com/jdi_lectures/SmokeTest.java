package com.jdi_lectures;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Konstantin_Mazurin on 03/10/16.
 */
public class SmokeTest extends TestBase {

    @BeforeClass
    public void open() {
        driver.get(baseUrl);
    }

    @Test
    public void successfulLogin() {
        driver.findElement(By.xpath("//*[@class='dropdown uui-profile-menu']")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.xpath("//button/span[text()='Enter']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'logout')]/button")).isDisplayed());
        Assert.assertTrue(driver.getTitle().equals("Index Page"));
    }

    @Test(dependsOnMethods = {"successfulLogin"})
    public void openContactForm() {
        driver.findElement(By.xpath("//li/a[text()='Contact form']")).click();
        Assert.assertTrue(driver.getTitle().equals("Contact Form"));
        driver.findElement(By.xpath("//li/a[text()='Home']")).click();
        Assert.assertTrue(driver.getTitle().equals("Index Page"));
        driver.findElement(By.xpath("//li/a/span[text()='Contact form']")).click();
        Assert.assertTrue(driver.getTitle().equals("Contact Form"));
        driver.findElement(By.xpath("//li/a/span[text()='Home']")).click();
        Assert.assertTrue(driver.getTitle().equals("Index Page"));
    }

    @Test(dependsOnMethods = {"successfulLogin"})
    public void openMetalsColors() {
        driver.findElement(By.xpath("//li/a[text()='Metals & Colors']")).click();
        Assert.assertTrue(driver.getTitle().equals("Metal and Colors"));
        driver.findElement(By.xpath("//li/a[text()='Home']")).click();
        Assert.assertTrue(driver.getTitle().equals("Index Page"));
        driver.findElement(By.xpath("//li/a/span[text()='Metals & Colors']")).click();
        Assert.assertTrue(driver.getTitle().equals("Metal and Colors"));
        driver.findElement(By.xpath("//li/a/span[text()='Home']")).click();
        Assert.assertTrue(driver.getTitle().equals("Index Page"));
    }

    @Test(enabled = false)
    public void testServiceDropdown() {
        driver.findElement(By.xpath("//a[text()='Service']")).click();
//        Assert.assertTrue();
    }

}
