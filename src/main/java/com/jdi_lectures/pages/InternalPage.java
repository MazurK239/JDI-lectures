package com.jdi_lectures.pages;

import com.epam.jdi.uitests.web.selenium.elements.base.Clickable;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Konstantin_Mazurin on 17/10/16.
 */
public class InternalPage extends WebPage {

    @FindBy(xpath=".//*[@class='dropdown uui-profile-menu']")
    private Clickable profilePhoto;

    @FindBy(id="Login")
    private TextField loginField;

    @FindBy(id="Password")
    private TextField passwordField;

    @FindBy(xpath="//form//button[@type='submit']")
    private Button submitButton;

    @FindBy(xpath="//div[@class='logout']/button[@type='submit']")
    private Button logoutButton;

    public void openLoginForm() {
        profilePhoto.click();
    }

    public void loginAs(String username, String password) {
        loginField.newInput(username);
        passwordField.newInput(password);
        submitButton.click();
    }

    public boolean isLoggedIn() {
        return logoutButton.isDisplayed() ? true : false;
    }
}
