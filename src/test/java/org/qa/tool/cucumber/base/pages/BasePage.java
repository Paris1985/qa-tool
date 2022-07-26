package org.qa.tool.cucumber.base.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.qa.tool.cucumber.base.util.Driver;

public abstract class BasePage {
    protected String url;
    protected WebDriver webDriver;

    public BasePage() {
        webDriver = Driver.getInstance().getWebDriver();
        PageFactory.initElements(webDriver, this);
    }

}
