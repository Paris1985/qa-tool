package org.qa.tool.cucumber.base;


import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.qa.tool.cucumber.pages.util.Driver;
import org.qa.tool.cucumber.pages.util.Player;

public class BaseTest {

    protected WebDriver webDriver;


    public BaseTest() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();


        webDriver = Driver.getInstance().getWebDriver();

    }

    public void  close(Scenario scenario) {
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
