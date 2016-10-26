package com.jdi_lectures;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.jdi_lectures.providers.UsersProvider;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.web.matcher.testng.Assert.assertTrue;
import static com.jdi_lectures.TestSite.*;

/**
 * Created by Konstantin_Mazurin on 17/10/16.
 */
public class PageObjectsTests extends TestNGBase{

    @BeforeSuite
    public void initTest() {
        WebSite.init(TestSite.class);
        TestBase.maximizeScreen(TestSite.homePage.getDriver());
    }

    @Test(dataProvider="users", dataProviderClass=UsersProvider.class)
    public void loginTest(String username, String password) {
        homePage.isOpened();
        homePage.openLoginForm();
        homePage.loginAs(username, password);
        assertTrue(() -> homePage.isLoggedIn());
    }
    
//    @Test
//    public void 

    @AfterSuite
    public void tearDown() {
    	homePage.getDriver().close();
    	homePage.getDriver().quit();
    }
}
