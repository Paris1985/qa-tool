
package org.qa.tool.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.BeforeClass;

@CucumberOptions(
        features = "classpath:features",
        glue = {"org.qa.tool.cucumber.steps" },
        plugin = {"pretty", "json:target/report.json"},
        publish = true)
public class CucumberTest extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void init() {
        System.setProperty("CUCUMBER_PUBLISH_ENABLED", "true");
    }
}
