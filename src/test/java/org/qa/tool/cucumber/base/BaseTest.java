package org.qa.tool.cucumber.base;


import com.google.gson.Gson;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.qa.tool.cucumber.pages.util.Driver;
import org.qa.tool.cucumber.pages.util.Player;

import java.util.Collection;

public class BaseTest {

    protected WebDriver webDriver;

    public void before(Scenario scenario) {
        Driver.getInstance().setDesiredCapability("name", scenario.getName());
        setTags(scenario);
        webDriver = Driver.getInstance().getWebDriver();
    }

    private void setTags(Scenario scenario) {
        Collection<String> sourceTagNames = scenario.getSourceTagNames();
        if (sourceTagNames == null || sourceTagNames.isEmpty()) {
            return;
        }
        Gson tagsGson = new Gson();
        String jsonTags = tagsGson.toJson(scenario.getSourceTagNames());
        Driver.getInstance().setDesiredCapability("tags", jsonTags);
    }

    public void close(Scenario scenario) {
        if (webDriver != null) {
            webDriver.quit();
        }

    }

    public void setUrl(String url) {
        if (webDriver != null) {
            webDriver.get(url);
        }
    }

    public void after(Scenario scenario) {
        webDriver = Driver.getInstance().getWebDriver();
    }
}
