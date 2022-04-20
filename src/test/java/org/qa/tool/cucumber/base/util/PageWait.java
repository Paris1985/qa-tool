package org.qa.tool.cucumber.base.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public final class PageWait {
    private final static PageWait wait = new PageWait();
    private final WebDriver webDriver;
    private PageWait() {
        webDriver = Driver.getInstance().getWebDriver();
    }
    public  static PageWait getInstance(){
        return wait;
    }
    public WebElement waitForElementExist(By locator, Duration duration){
        WebDriverWait wait = new WebDriverWait(webDriver, duration);
        return wait.until(presenceOfElementLocated(locator));
    }

    @SuppressWarnings("unchecked")
    public WebElement waitForElementExist(By locator, Duration timeout, Duration interval, Class exception){
        FluentWait<WebDriver> wait = new FluentWait<>(webDriver);
        wait.pollingEvery(interval);
        wait.withTimeout(timeout);
        wait.ignoring(exception);
        return wait.until(presenceOfElementLocated(locator));
    }
}
