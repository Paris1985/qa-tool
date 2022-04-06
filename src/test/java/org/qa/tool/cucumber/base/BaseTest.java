package org.qa.tool.cucumber.base;


import org.openqa.selenium.WebDriver;
import org.qa.tool.cucumber.pages.util.Driver;

public class BaseTest {

    protected WebDriver webDriver;

    public BaseTest() {
        webDriver = Driver.getInstance().getWebDriver();
    }

    public void  close() {
        if( webDriver != null ) {
            webDriver.quit();
        }
    }

    public void setUrl(String url) {
        if( webDriver != null ) {
            webDriver.get(url);
        }
    }
}
