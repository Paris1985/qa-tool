package org.qa.tool.cucumber.base;


import com.google.gson.Gson;
import io.cucumber.java.Scenario;
import junit.framework.TestResult;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.qa.tool.cucumber.base.util.Driver;
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

    public void markTestStatus()  {
        TestResult result = new TestResult();
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;

        if (System.getProperty("REMOTE").equalsIgnoreCase("browserstack") ) {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+ (result.wasSuccessful() ? "passed" : "failed") + "\", \"reason\": \"" + (result.wasSuccessful() ? "successful" : "not successful") + "\"}}");
        }
        else{
            jse.executeScript("sauce:job-result=" + (result.wasSuccessful() ? "passed" : "failed"));
        }
    }

    public void after(Scenario scenario) {
       markTestStatus();
        close(scenario);
        //webDriver = Driver.getInstance().getWebDriver();
    }
}
