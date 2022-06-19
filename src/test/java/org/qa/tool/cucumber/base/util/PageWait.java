package org.qa.tool.cucumber.base.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public final class PageWait {
    private final static PageWait wait = new PageWait();
    private static WebDriver webDriver;

    public static PageWait getInstance(){
        webDriver = Driver.getInstance().getWebDriver();
        return wait;
    }
    public WebElement waitForElementExist(By locator, Duration duration){
        WebDriverWait wait = new WebDriverWait(webDriver, duration);
        return wait.until(presenceOfElementLocated(locator));
    }
}
