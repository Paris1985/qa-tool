package org.qa.tool.cucumber.base.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Map;

public final class Driver {

    private Logger logger = LoggerFactory.getLogger(Driver.class);
    private static String DEFAULT_BROWSER = "chrome";

    private final static Driver browser = new Driver();
    private WebDriver webDriver;
    private URL url;
    private SessionId sessionId;
    private DesiredCapabilities capabilities = new DesiredCapabilities();

    private Driver() {
    }

    public void setDesiredCapability(String name, String value) {
        capabilities.setCapability(name, value);
    }

    public static Driver getInstance() {
        return browser;
    }

    public WebDriver getWebDriver() {
        if (this.webDriver != null)
            return this.webDriver;

        String remote = System.getProperty("REMOTE");
        String browser = System.getProperty("BROWSER");
        String confFile = "";

        if ("browserstack".equalsIgnoreCase(remote)) {
            confFile = "browser_stack.conf.json";
        } else if ("saucelabs".equalsIgnoreCase(remote)) {
            confFile = "saucelabs.conf.json";
        } else if ("grid-local".equalsIgnoreCase(remote)) {
            confFile = "local.conf.json";
        } else {
            if(StringUtils.isBlank(browser)) {
                browser = DEFAULT_BROWSER;
            }
            this.webDriver = WebDriverManager.getInstance(browser).create();
            return this.webDriver;
        }

        if (StringUtils.isBlank(confFile)) {
            throw new InvalidParameterException("conf not found");
        }

        setProperties(confFile, browser);
        this.webDriver = new RemoteWebDriver(url, capabilities);
        this.sessionId = ((RemoteWebDriver) this.webDriver).getSessionId();
        return this.webDriver;
    }

    private void setProperties(String conf, String browser) {

        JSONParser parser = new JSONParser();
        JSONObject config = null;
        try {
            config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + conf));
            JSONObject envs = (JSONObject) config.get("environments");

            setEnvCapabilities(envs, capabilities, browser);
            setCommonCapabilities(config, capabilities);
            setRemoteUrl(config);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setRemoteUrl(JSONObject config) throws MalformedURLException {
        String username = System.getProperty("USERNAME");
        if(username == null) {
            username = System.getenv("USERNAME") ;
        }
        String accessKey = System.getProperty("ACCESS_KEY");
        if (accessKey == null) {
            accessKey = System.getProperty("ACCESS_KEY");
        }

        String server = System.getProperty("SERVER");

        if (server == null) {
            server = System.getenv("SERVER");
        }

        if (server == null) {
            server = (String) config.get("server");
        }

        if (username == null || accessKey == null || server == null) {
            throw new MalformedURLException("Missing username and access key");
        }

        url = new URL("https://" + username + ":" + accessKey + "@" + server);
        System.out.println(url.toString());
    }


    private void setCommonCapabilities(JSONObject config, DesiredCapabilities capabilities) {
        Iterator<Map.Entry<String, String>> it;

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = it.next();
            if (capabilities.getCapability(pair.getKey().toString()) == null) {
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }
        }
    }

    private void setEnvCapabilities(JSONObject envs, DesiredCapabilities capabilities, String browser) {
        Map<String, String> envCapabilities = (Map<String, String>) envs.get(browser);
        Iterator<Map.Entry<String, String>> it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }
    }

    public void exit() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    public String getSessionId() {
        return sessionId.toString();
    }
}
