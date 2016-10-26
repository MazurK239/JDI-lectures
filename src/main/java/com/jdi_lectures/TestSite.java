package com.jdi_lectures;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.jdi_lectures.pages.HomePage;

/**
 * Created by Konstantin_Mazurin on 17/10/16.
 */
@JSite(domain="jdi-framework.github.io/tests")
public class TestSite extends WebSite{

    @JPage(url="/index.htm")
    public static HomePage homePage;


}
