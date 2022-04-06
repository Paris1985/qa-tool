package org.qa.tool.cucumber.pages.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public final class PageWait {
    private final static PageWait wait = new PageWait();
    protected WebDriver webDriver;
    private PageWait() {
        webDriver = Driver.getInstance().getWebDriver();
    }
    public static PageWait getInstance(){
        return wait;
    }
    public WebElement waitForElementExist(By locator, Duration duration){
        WebDriverWait wait = new WebDriverWait(webDriver, duration);
        return wait.until(presenceOfElementLocated(locator));
    }

    public WebElement waitForElementExist(By locator, Duration timeout, Duration interval, Class exception){
        Wait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(timeout)
                .pollingEvery(interval)
                .ignoring(exception);
        return wait.until(presenceOfElementLocated(locator));
    }
}
