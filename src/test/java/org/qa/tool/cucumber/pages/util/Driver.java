package org.qa.tool.cucumber.pages.util;

import com.browserstack.local.Local;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.minidev.json.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Driver {

    private final static Driver browser = new Driver();
    private WebDriver webDriver;
    private URL url;
    private DesiredCapabilities capabilities;
    private Driver() {
    }

    public static Driver getInstance() {
        return browser;
    }

    public WebDriver getWebDriver()  {
        if (this.webDriver != null)
            return this.webDriver;
        String browser = DriverProperty.getProperty("browser");
        String server = DriverProperty.getProperty("server");

        if("grid-remote".equalsIgnoreCase(browser)){
            setBrowserStack();
            this.webDriver = new Augmenter().augment(
                    new RemoteWebDriver(url, capabilities));
        } else if("grid-local".equalsIgnoreCase(browser)){
            try {
                EdgeOptions edgeOptions =  new EdgeOptions();

                this.webDriver = new Augmenter().augment(
                        new RemoteWebDriver(new URL("http://192.168.100.20:4444/" ), edgeOptions));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            this.webDriver = WebDriverManager.getInstance(browser).create();
        }
        return this.webDriver;
    }

    public void setBrowserStack() {

        JSONParser parser = new JSONParser();
        JSONObject config = null;
        try {
            config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/suite.conf.json"));
            JSONObject envs = (JSONObject) config.get("environments");

            capabilities = new DesiredCapabilities();

            setEnvCapabilities(envs, capabilities);
            setCommonCapabilities(config, capabilities);

            String username = System.getProperty("USERNAME");
            String accessKey = System.getProperty("ACCESS_KEY");

            setLocal(capabilities, accessKey);

           url = new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub");
        } catch (ParseException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void setLocal(DesiredCapabilities capabilities, String accessKey) throws Exception {
        Local l;
        if (capabilities.getCapability("browserstack.local") != null
                && capabilities.getCapability("browserstack.local") == "true") {
            l = new Local();
            Map<String, String> options = new HashMap<String, String>();
            options.put("key", accessKey);
            l.start(options);
        }
    }

    private void setCommonCapabilities(JSONObject config, DesiredCapabilities capabilities) {
        Iterator it;

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (capabilities.getCapability(pair.getKey().toString()) == null) {
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }
        }
    }

    private void setEnvCapabilities(JSONObject envs, DesiredCapabilities capabilities) {
        Map<String, String> envCapabilities = (Map<String, String>) envs.get("chrome");
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }
    }
}
