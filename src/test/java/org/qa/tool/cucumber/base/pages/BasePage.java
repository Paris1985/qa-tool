package org.qa.tool.cucumber.base.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.qa.tool.cucumber.base.shared.core.Driver;

public abstract class BasePage {
    private String url;
    protected WebDriver webDriver;

    public BasePage(String url) {
        this.url = url;
        webDriver = Driver.getInstance().getWebDriver();
        PageFactory.initElements(webDriver, this);
        webDriver.get(this.url);
    }

}
