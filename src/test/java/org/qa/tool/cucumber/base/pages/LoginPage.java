package org.qa.tool.cucumber.base.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.qa.tool.cucumber.base.util.PageWait;

import java.time.Duration;


public class LoginPage extends BasePage {

    private String logoutXpath = "//*[@id=\"post-8\"]/div/div/nav/ul/li[6]/a";
    @FindBy(id = "username")
    private WebElement usernameTxt;
    @FindBy(id = "password")
    private WebElement passwordTxt;
    @FindBy(name = "login")
    private WebElement submitBtn;

    public LoginPage() {
        url = "https://shop.demoqa.com/my-account/";
        webDriver.get(url);
    }

    public void login(String username, String password) {
        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        submitBtn.click();
    }

    public String getLoginConfirmation() {
        WebElement webElement = PageWait.getInstance().waitForElementExist(By.xpath(logoutXpath),
                Duration.ofSeconds(20));
        return webElement.getText();
    }

    public void logout() {
        WebElement logOutBtn = PageWait.getInstance().waitForElementExist(By.xpath(logoutXpath),
                Duration.ofSeconds(20));
        logOutBtn.click();
    }
}
